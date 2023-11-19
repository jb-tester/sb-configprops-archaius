package com.mytests.spring.sbconfigpropsarchaius;

import com.netflix.archaius.api.annotations.Configuration;
import com.netflix.archaius.api.annotations.DefaultValue;
import com.netflix.archaius.api.annotations.PropertyName;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;



@Configuration(prefix = "my.app")
public interface AppConfig {
	
    @DefaultValue("true")
    @PropertyName(name = "flag")
    public boolean isSomeFlag();
	
    @DefaultValue("default name value")
    @PropertyName(name = "name")
    public String getSomeName();
    
    @DefaultValue("default prop value")
    public String getProp();
    
}