package com.github.lwh.nginxparser.transfer.converter;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.lwh.nginxparser.ngx.NgxBlock;
import com.github.lwh.nginxparser.ngx.NgxParam;
import java.util.Optional;
import java.util.Set;

/**
 * string converter
 *
 * @author longwenhao
 * @version 1.0, 2021/5/29 07 : 25
 */
public class TypeConverter implements Converter<Object> {

    /**
     * 需要转换的类型持有
     */
    private static final Set<Class<?>> typeHold = CollUtil
      .newHashSet(byte.class,short.class,float.class,int.class,long.class,double.class,char.class,
        Byte.class, Short.class, Float.class, Integer.class, Long.class,
    Double.class, Character.class, String.class);

    /**
     * 通过字段信息初始化块
     *
     * @param info field meta data
     * @param instance instance data
     */
    @Override
    public void parser2conf(ParamInfo info, NgxBlock block, Object instance) {
        if (ObjectUtil.isNotNull(info)
          && ObjectUtil.isNotNull(instance)) {
            NgxParam param = new NgxParam();
            param.addValue(Optional
              .ofNullable(info.getParamName())
              .orElse(""));
            param.addValue(instance.toString());
            block.addEntry(param);
        }
    }

    /**
     * 判定是否需要转换
     *
     * @param clazz 类型
     */
    @Override
    public Boolean needConverter(Class<?> clazz)  {
        return typeHold.contains(clazz);
    }
}
