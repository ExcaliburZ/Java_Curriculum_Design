package net.wings.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DaoFactory{

    static Properties prop = new Properties();

    private DaoFactory() {
    }

    private static final DaoFactory instance = new DaoFactory();

    public static DaoFactory getInstance() {
        return instance;
    }

    static {
        try {
            InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
            prop.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T createDao(Class<T> interfaceClazz) {
        try {
            String name = interfaceClazz.getSimpleName();
            String classname = prop.getProperty(name);
            return (T) Class.forName(classname).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
