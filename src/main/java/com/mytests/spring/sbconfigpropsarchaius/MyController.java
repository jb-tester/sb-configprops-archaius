package com.mytests.spring.sbconfigpropsarchaius;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MyController {
    private final AppConfig appConfig;
    private final MyConfigProps myConfigProps;

    public MyController(AppConfig appConfig, MyConfigProps myConfigProps) {
        this.appConfig = appConfig;
        this.myConfigProps = myConfigProps;
    }

    // works ok:
    @GetMapping("/test1")
    public String test1() {
        return "got properties: \n"+ appConfig.getProp() + "\n" + appConfig.getSomeName() + "\n" + appConfig.isSomeFlag();
    }

    // check that the default value of property is used instead of set one
    @GetMapping("/test2")
    public String test2() {
        Map<String, DummyInterface> mapProp = myConfigProps.getMapProp();

        StringBuffer rez = new StringBuffer();
        mapProp.forEach((k, v) -> rez.append("\n").append(k).append(":").append(v.getStr()).append(", ").append(v.getNum()));
        return "got properties: \n"+ rez;
    }
}
