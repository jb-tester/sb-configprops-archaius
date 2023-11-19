package com.mytests.spring.sbconfigpropsarchaius;

import com.netflix.archaius.ConfigProxyFactory;
import com.netflix.archaius.api.Config;
import com.netflix.archaius.api.exceptions.ConfigException;
import com.netflix.archaius.config.DefaultCompositeConfig;
import com.netflix.archaius.config.MapConfig;
import com.netflix.archaius.config.PollingDynamicConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

@SpringBootApplication
//@EnableConfigurationProperties(ArchInterface.class)
public class SbConfigpropsArchaiusApplication  {



    public static void main(String[] args) {
        SpringApplication.run(SbConfigpropsArchaiusApplication.class, args);
    }



}
