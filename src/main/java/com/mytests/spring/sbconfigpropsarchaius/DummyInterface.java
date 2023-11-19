package com.mytests.spring.sbconfigpropsarchaius;

import com.netflix.archaius.api.annotations.Configuration;

@Configuration(prefix = "my.dummy")
public interface DummyInterface {
    String getStr();
    int getNum();
}
