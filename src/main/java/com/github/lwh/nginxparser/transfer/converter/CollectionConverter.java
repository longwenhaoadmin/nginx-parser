package com.github.lwh.nginxparser.transfer.converter;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.lwh.nginxparser.ngx.NgxBlock;
import java.util.Collection;

/**
 * 集合处理类
 *
 * @author longwenhao
 * @version 1.0, 2021/5/29 20 : 15
 */
public class CollectionConverter implements Converter<Collection> {

    /**
     * 通过字段信息和实例信息获取需要的NgxEntry信息
     *
     * @param info field meta data
     * @param block target block
     * @param instance 实例内容
     */
    @Override
    public void parser2conf(ParamInfo info, NgxBlock block, Collection instance) throws IllegalAccessException {
        if (CollUtil.isNotEmpty(instance) && ObjectUtil.isNotEmpty(instance)) {
            for (Object value : instance) {
                if (ObjectUtil.isNotEmpty(value)) {
                    ConverterBeanFactory.getConverter(value.getClass()).parser2conf(info, block, value);
                }
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
        return Collection.class.isAssignableFrom(clazz);
    }
}
