package com.github.lwh.nginxparser.transfer.converter;

import cn.hutool.core.util.ObjectUtil;
import com.github.lwh.nginxparser.ngx.NgxBlock;
import com.github.lwh.nginxparser.transfer.entry.NgxCommon;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * java bean converter
 *
 * @author longwenhao
 * @version 1.0, 2021/5/29 07 : 33
 */
public class BeanConverter implements Converter<Object> {


    /**
     * 通过字段信息初始化块
     *
     * @param info field meta data
     * @param instance instance data
     */
    @Override
    public void parser2conf(ParamInfo info, NgxBlock block, Object instance) throws IllegalAccessException {
        if (ObjectUtil.isNull(info)) {
            initBlock(block, instance);
        } else {
            NgxBlock paramBlock = new NgxBlock();
            paramBlock.addValue(info.getParamName());
            initBlock(paramBlock, instance);
            block.addEntry(paramBlock);
        }
    }

    /**
     * 初始化块
     *
     * @param block 块实体
     * @param instance 实例对象
     * @throws IllegalAccessException filed exception
     */
    private void initBlock(NgxBlock block, Object instance) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();
        //init body
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(instance);
            if (ObjectUtil.isNotNull(value)) {
                ConverterBeanFactory.getConverter(field.getType()).parser2conf(new ParamInfo(field), block, value);
            }
        }
        //init NgxCommon
        if (instance instanceof NgxCommon) {
            Map<String, Object> value = ((NgxCommon) instance).getCustomAttr();
            ConverterBeanFactory.getConverter(value.getClass()).parser2conf(null, block, value);
        }
    }

    /**
     * 判定是否需要转换
     *
     * @param clazz 类型
     */
    @Override
    public Boolean needConverter(Class<?> clazz) {
        return true;
    }

}
