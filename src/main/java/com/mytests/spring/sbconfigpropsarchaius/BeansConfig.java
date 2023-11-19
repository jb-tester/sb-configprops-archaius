package com.mytests.spring.sbconfigpropsarchaius;

import com.netflix.archaius.ConfigProxyFactory;
import com.netflix.archaius.api.exceptions.ConfigException;
import com.netflix.archaius.config.DefaultCompositeConfig;
import com.netflix.archaius.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

@Configuration
public class BeansConfig {

    @Bean
    public ArchInterface archInterface(ConfigProxyFactory factory) {
        return factory.newProxy(ArchInterface.class);
    }
    @Bean
    public DummyInterface dummyInterface(ConfigProxyFactory factory) {
        return factory.newProxy(DummyInterface.class);
    }
    @Bean
    public BooInterface booInterface(ConfigProxyFactory factory) {
        return factory.newProxy(BooInterface.class);
    }

    @Bean
    public ConfigProxyFactory configProxyFactory() throws IOException, ConfigException {
        Properties properties = new Properties();
        URL url = this.getClass().getClassLoader().getResource("application.properties");
        properties.load(url.openStream());
        DefaultCompositeConfig config = new DefaultCompositeConfig();
        config.addConfig("props", new MapConfig(properties));
        return new ConfigProxyFactory(config);
    }
}
