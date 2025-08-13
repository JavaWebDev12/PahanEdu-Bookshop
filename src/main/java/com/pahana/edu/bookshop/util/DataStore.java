package com.pahana.edu.bookshop.util;

import javax.servlet.ServletContext;
import java.io.File;

public class DataStore {
    public static final String USERS_FILE = "users.txt";
    public static final String CUSTOMERS_FILE = "customers.txt";
    public static final String ITEMS_FILE = "items.txt";

    public static File resolveDataFile(ServletContext context, String fileName) {
        String realPath = context.getRealPath("/WEB-INF/data/" + fileName);
        File file = new File(realPath);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        return file;
    }
}

