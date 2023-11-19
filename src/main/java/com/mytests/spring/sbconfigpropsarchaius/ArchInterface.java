package com.mytests.spring.sbconfigpropsarchaius;

import com.netflix.archaius.api.annotations.Configuration;
import com.netflix.archaius.api.annotations.DefaultValue;
import com.netflix.archaius.api.annotations.PropertyName;


@Configuration(prefix = "my.arch")
public interface ArchInterface {
	
    @DefaultValue("true")
    @PropertyName(name = "flag")
    public boolean isSomeFlag();
	
    @DefaultValue("default name value")
    @PropertyName(name = "name")
    public String getSomeName();
    
    @DefaultValue("default prop value")
    public String getProp();
    
}