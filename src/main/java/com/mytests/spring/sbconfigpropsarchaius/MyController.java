package com.mytests.spring.sbconfigpropsarchaius;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MyController {
    private final ArchInterface archInterface;
    private final MyConfigPropsThatUseArchaiusConfigAsMapValue myConfigPropsThatUseArchaiusConfigAsMapValue;
    private final MyConfigPropsThatUseArchaiusConfigAsNestedCP myConfigPropsThatUseArchaiusConfigAsNestedCP;

    public MyController(ArchInterface archInterface, MyConfigPropsThatUseArchaiusConfigAsMapValue myConfigPropsThatUseArchaiusConfigAsMapValue, MyConfigPropsThatUseArchaiusConfigAsNestedCP myConfigPropsThatUseArchaiusConfigAsNestedCP) {
        this.archInterface = archInterface;
        this.myConfigPropsThatUseArchaiusConfigAsMapValue = myConfigPropsThatUseArchaiusConfigAsMapValue;
        this.myConfigPropsThatUseArchaiusConfigAsNestedCP = myConfigPropsThatUseArchaiusConfigAsNestedCP;
    }

    // works ok:
    @GetMapping("/test1")
    public String test1() {
        return "got properties: \n"+ archInterface.getProp() + "\n" + archInterface.getSomeName() + "\n" + archInterface.isSomeFlag();
    }

    // check that the default value of property is used instead of set one
    @GetMapping("/test2")
    public String test2() {
        Map<String, DummyInterface> mapProp = myConfigPropsThatUseArchaiusConfigAsMapValue.getMapProp();

        StringBuffer rez = new StringBuffer();
        mapProp.forEach((k, v) -> rez.append("\n").append(k).append(":").append(v.getStr()).append(", ").append(v.getNum()));
        return "got properties: \n"+ rez;
    }

    @GetMapping("/test3")
    public String test3() {
        return "got properties: \n"+ myConfigPropsThatUseArchaiusConfigAsNestedCP.getBooInterface().getStr();
    }
}
