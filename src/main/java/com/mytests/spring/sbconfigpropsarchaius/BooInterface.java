package com.mytests.spring.sbconfigpropsarchaius;

import com.netflix.archaius.api.annotations.Configuration;

@Configuration(prefix = "my.boo")
public interface BooInterface {
    String getStr();
}
