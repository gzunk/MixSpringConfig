package com.gzunk.mixspringconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootApplication
@ImportResource({"classpath:/beans.xml"})
public class ApplicationMain {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationMain.class);

    @Resource(name="queries")
    Map<String, String> myMap;

    @Bean(name="executor")
    MixDepend mixDepend() {
        return new MixDepend(myMap);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(ApplicationMain.class, args);
        MixDepend mixDepend = (MixDepend) app.getBean("executor");
        LOG.info(mixDepend.getValue("alasdair"));
        LOG.info(mixDepend.getValue("lesley"));
    }

}
