package com.gzunk.mixspringconfig;

import java.util.Map;

public class MixDepend {

    Map<String, String> data;

    public MixDepend(Map<String, String> data) {
        this.data = data;
    }

    public String getValue(String value) {
        return data.get(value);
    }
}
