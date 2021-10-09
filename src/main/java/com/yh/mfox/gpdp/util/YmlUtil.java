package com.yh.mfox.gpdp.util;


import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.util.HashMap;

import java.util.Map;
import java.util.Properties;

/**
 * yml文件工具类
 */

public class YmlUtil {

    private static String file = "application.yml";

    public static String getConfigByYml(String key) {
        Resource resource = new ClassPathResource(file);
        Properties properties = null;
        try {
            YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
            yamlFactory.setResources(resource);
            properties = yamlFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return properties.getProperty(key);
    }



}