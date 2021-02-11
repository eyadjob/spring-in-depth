package com.spring.in.depth.mastering.utility;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class PropManager {

    private static PropManager instance = null;
    private final String path = System.getProperty("user.dir") + File.separator
            + "target" + File.separator + "classes" + File.separator;
    private final String propsPath = System.getProperty("user.dir") + File.separator + "\\src\\test\\resources\\" + File.separator;
    private final String pathPropsFilesInProject = System.getProperty("user.dir") + "\\src\\test\\resources\\" ;
    private final Properties propertiesThreadLocal = null;
    Map<String, Properties> propertiesValues = new HashMap<>();

    private PropManager() {
    }

    public void setExecutionLanguageProperty(String lang) {
        PropManager.getInstance().getPropertiesValues().get("appProperties.properties").setProperty("execution.lang",lang);
    }

    public synchronized static PropManager getInstance() {
        if (instance == null) {
            instance = new PropManager();
            instance.loadPropertiesFromResource();
        }
        return instance;
    }

    public  Map<String, Properties> getPropertiesValues() {
        return propertiesValues;
    }

    private  Map<String, Properties>  loadPropertiesFromResource() {
        Properties appProps = null;
        List<File> propsFiles = new FileHandler().getFilesListInDirectory(propsPath);
            for (File file : propsFiles) {
                if (FilenameUtils.getExtension(file.getPath()).equals(
                        "properties")) {
                    appProps = loadProperties(file.getPath());
                    propertiesValues.put(file.getName(), appProps);
                }
            }
       return  propertiesValues;
    }


    private Properties loadPropertiesForFile(String filePath) {
        Properties fileProps = null;
        File directory = new File(filePath);
        fileProps = loadProperties(filePath);
        return fileProps;
    }


    public String getProperty(String name) {
        if (propertiesValues.size() == 0) {
            loadPropertiesFromResource();
            log.warn("the properties size was 0!  in getProperty() method");
        }
        String propertyValue = propertiesValues.entrySet().stream().filter(p -> p.getValue().getProperty(name) != null).map(d -> d.getValue().getProperty(name)).findAny().orElse("");
        return propertyValue.trim();
    }

    public void setProperty(String propertyName, String propertyValue) {
        try {
            String propertiesFileName = pathPropsFilesInProject + PropManager.getInstance().getPropertiesValues().entrySet().stream().filter(properties -> properties.getValue().getProperty(propertyName) != null).findFirst().get().getKey() ;

            FileInputStream in = new FileInputStream(propertiesFileName);
            Properties props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream(propertiesFileName);
            props.setProperty(propertyName, propertyValue);
            props.store(out, null);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties loadProperties(String fileName) {
        Properties localProperties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (IOException exception) {
            log.info("Error at loadProperties in PropManger class" + exception);
        }
        log.info("Reading property file : " + fileName);
        log.info("***** loading property file: " + fileName);
        try {
            if (inputStream != null) {

                localProperties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (inputStream == null) {
            String message = "property file '" + fileName
                    + "' not found in the classpath";
            log.info(message);
        }
        return localProperties;
    }

    public String getLocatorsPath(Properties appProps) {
        String LocatorsPath = "";
        if (appProps.getProperty("execution.application.type").equalsIgnoreCase("web")) {
            LocatorsPath = "locators" + File.separator + "web" + File.separator;
        }

        return LocatorsPath;

    }

    public String getLocatorName(String name) {
        return name;
    }

}