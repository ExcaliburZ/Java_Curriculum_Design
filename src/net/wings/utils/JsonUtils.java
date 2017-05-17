package net.wings.utils;

import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by wing on 2017/5/12.
 */
public class JsonUtils {
    public static String getBody(HttpServletRequest request) throws IOException {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        return body;
    }

    public static boolean getBodyToFile(HttpServletRequest request, String path) throws IOException {

        try {
            InputStream inputStream = request.getInputStream();
            File file =new File(path);
            file.createNewFile();
            OutputStream outputStream =new FileOutputStream(file);
            byte[] bytes = IOUtils.toByteArray(inputStream);
            IOUtils.write(bytes,outputStream);
        } catch (IOException ex) {
            throw ex;
        } finally {

        }

        return true;
    }
}
