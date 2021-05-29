package com.github.lwh.nginxparser.transfer.converter;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.lwh.nginxparser.ngx.NgxBlock;
import java.util.Map;

/**
 * map处理类
 *
 * @author longwenhao
 * @version 1.0, 2021/5/29 20 : 44
 */
public class MapConverter implements Converter<Map<?, ?>> {

    /**
     * 通过字段信息和实例信息获取需要的NgxEntry信息
     *
     * @param info field meta data
     * @param block target block
     * @param instance instance
     */
    @Override
    public void parser2conf(ParamInfo info, NgxBlock block, Map<?, ?> instance) throws IllegalAccessException {
        for (Object key : instance.keySet()) {
            Object value = instance.get(key);
            if (ObjectUtil.isNotEmpty(value) && StrUtil.isNotBlank(value.toString())) {
                ConverterBeanFactory.getConverter(value.getClass())
                  .parser2conf(new ParamInfo(key.toString()), block, value);
            }
        }
    }

    /**
     * 判定是否需要转换
     *
     * @param clazz 类型
     */
    @Override
    public Boolean needConverter(Class<?> clazz) {
        return Map.class.isAssignableFrom(clazz);
    }
}
