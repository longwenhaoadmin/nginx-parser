package com.github.lwh.nginxparser.transfer.utils;

import cn.hutool.core.util.ObjectUtil;
import com.github.lwh.nginxparser.transfer.annotation.BlockValue;
import com.github.lwh.nginxparser.transfer.annotation.Param;
import java.lang.reflect.Field;

/**
 * field utils
 *
 * @author longwenhao
 * @version 1.0, 2021/5/28 23 : 24
 */
public class FieldUtils {

    public static String getParamNameByField(Field field) {
        if (ObjectUtil.isEmpty(field))
            return null;
        Param param = field.getAnnotation(Param.class);
        if (ObjectUtil.isEmpty(param))
            return field.getName();
        return param.value();
    }

    public static Boolean isBlockValueField(Field field) {
        if (ObjectUtil.isEmpty(field))
            return false;
        BlockValue value = field.getAnnotation(BlockValue.class);
        return value != null;
    }

}
