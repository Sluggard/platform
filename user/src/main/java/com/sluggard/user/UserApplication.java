package com.sluggard.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.sluggard.user.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);

//        DocsConfig config = new DocsConfig();
//        config.setProjectPath(System.getProperty("user.dir") + File.separator + "user"); // root project path
//        config.setProjectName("platform"); // project name
//        config.setApiVersion("V1.0");       // api version
//        config.setDocsPath(System.getProperty("user.dir") + File.separator + "user"); // api docs target path
//        config.setAutoGenerate(Boolean.TRUE);  // auto generate
//        Docs.buildHtmlDocs(config); // execute to generate
    }

}
