package com.gzunk.mixspringconfig;

import java.util.Map;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;


/**
 * Main application.
 */
@SpringBootApplication
@ImportResource({"classpath:/beans.xml"})
public class ApplicationMain {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(
            ApplicationMain.class);

    /**
     * Map to take data from.
     */
    @Resource(name = "queries")
    private Map<String, String> myMap;

    /**
     * Bean to execute.
     * @return the instance of the bean.
     */
    @Bean(name = "executor")
    protected MixDepend mixDepend() {
        return new MixDepend(myMap);
    }

    /**
     * Application entry point.
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(
                ApplicationMain.class, args);
        MixDepend mixDepend = (MixDepend) app.getBean("executor");
        LOG.info(mixDepend.getValue("alasdair"));
        LOG.info(mixDepend.getValue("lesley"));
    }

}
