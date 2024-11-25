package com.bta.utils;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class Config {
    private static final Properties properties;

    static {
        properties = new Properties();
        String path = "src/test/resources/test-config/project.properties";
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load project.properties file", e);
        }
    }

    public static String getProp(String key) {
        return properties.getProperty(key);
    }
}
