package com.mytests.spring.sbconfigpropsarchaius;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("my.boo") // same prefix as BooInterface uses!
public class MyConfigPropsThatUseArchaiusConfigAsNestedCP {


    @Autowired
    @NestedConfigurationProperty
    private BooInterface booInterface;

    public BooInterface getBooInterface() {
        return booInterface;
    }

    public void setBooInterface(BooInterface booInterface) {
        this.booInterface = booInterface;
    }
}
