package com.mytests.spring.sbconfigpropsarchaius;

import com.netflix.archaius.ConfigProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties("my.cp")
public class MyConfigProps {



    Map<String,DummyInterface> mapProp = defaults();

    @Autowired
    private DummyInterface dummyInterface;


    public Map<String, DummyInterface> getMapProp() {
        return mapProp;
    }

    public void setMapProp(Map<String, DummyInterface> mapProp) {
                this.mapProp = mapProp;
    }

    private Map<String,DummyInterface> defaults(){
        Map<String,DummyInterface> rez = new HashMap<>();
        rez.put("default_key", new DummyInterface() {
            @Override
            public String getStr() {
                return dummyInterface.getStr();
            }

            @Override
            public int getNum() {
                return dummyInterface.getNum();
            }
        });
        return rez;
    }
}
