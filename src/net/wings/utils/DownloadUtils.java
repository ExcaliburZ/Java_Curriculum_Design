package net.wings.utils;

import net.wings.domain.Document;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DownloadUtils {

    //提供文件上传服务，返回一个上传文件对象
    public static Document doupload(HttpServletRequest request, String uppath) {

        List<String> types = Arrays.asList("jpg", "gif", "bmp", "png", "txt", "torrent", "rar", "zip", "doc", "ppt", "docx");
        Document bean = new Document();
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置临时缓存目录
            factory.setRepository(new File(request.getSession().getServletContext().getRealPath("/WEB-INF/temp")));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            upload.setFileSizeMax(1024 * 1024 * 100);
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    BeanUtils.setProperty(bean, name, value);
                } else {
                    //得到上传文件名
                    String filename = item.getName().substring(item.getName().lastIndexOf("\\") + 1);

                    //防止空的上传项
                    if (filename == null || filename.trim().equals("")) {
                        continue;
                    }

//                    //限制上传文件的类型
//                    String ext = filename.substring(filename.lastIndexOf(".") + 1);
//                    if (!types.contains(ext)) {
//                        request.setAttribute("message", "不支持" + ext + "类型的上传");
//                        throw new Exception();
//                    }

                    //得到文件的保存名称(UUID随机值+后缀名)
                    String uuidname = generateFilename(filename);
                    //根据文件的保存名称得到得到文件的保存目录
                    String savepath = generateSavepath(uppath, uuidname);

                    InputStream in = item.getInputStream();
                    int len = 0;
                    byte buffer[] = new byte[1024];
                    OutputStream out = new FileOutputStream(savepath + "\\" + uuidname);
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }
                    in.close();
                    out.close();
                    item.delete();
                    bean.setId(UUID.randomUUID().toString());
                    bean.setName(filename);
                    bean.setDownload_url(savepath);
                    bean.setUpload_time(TimeUtils.getDateString());
                    bean.setUuidname(uuidname);
                }

            }
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //为每一个文件分配一个唯一的UUID文件名保存，防止文件重名
    private static String generateFilename(String filename) {
        String ext = filename.substring(filename.lastIndexOf("."));
        return UUID.randomUUID().toString() + ext;
    }

    //根据文件的UUID名称通过hash算法得到2层保存目录
    private static String generateSavepath(String uppath, String uuidname) {
        //根据文件的UUId名称得到Hash值
        int hashcode = uuidname.hashCode();
        //根据hash值的最后4位得到一级保存目录
        int dir1 = hashcode & 15;
        //根据hash值右移4位后的最后4位得到二级保存目录
        int dir2 = (hashcode >> 4) & 0xf;
        String savepath = uppath + File.separator + dir1 + File.separator + dir2;
        File file = new File(savepath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return savepath;
    }
}
