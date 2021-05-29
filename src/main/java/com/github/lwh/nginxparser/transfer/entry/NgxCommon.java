package com.github.lwh.nginxparser.transfer.entry;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

/**
 * 通用属性
 *
 * @author longwenhao
 * @version 1.0, 2021/5/29 20 : 56
 */
@Getter
public abstract class NgxCommon {


    private Map<String, Object> customAttr = new HashMap<>();

    public void addAttr(String key, Object value) {
        this.customAttr.put(key, value);
    }
}
