package com.github.lwh.nginxparser.transfer.converter;

import cn.hutool.core.util.ObjectUtil;
import com.github.lwh.nginxparser.ngx.NgxBlock;
import com.github.lwh.nginxparser.transfer.utils.FieldUtils;
import java.lang.reflect.Field;
import lombok.Getter;

/**
 * interface for parser nginx.conf
 *
 * @author longwenhao
 * @version 1.0, 2021/5/28 23 : 16
 */
public interface Converter<T> {


    /**
     * 通过字段信息和实例信息获取需要的NgxEntry信息
     *
     * @param info field meta data
     * @param block target block
     * @param instance instance
     */
    void parser2conf(ParamInfo info, NgxBlock block, T instance) throws IllegalAccessException;

    /**
     * 判定是否需要转换
     *
     * @param clazz 类型
     */
    Boolean needConverter(Class<?> clazz);

    @Getter
    class ParamInfo {

        private String paramName;

        private Field field;

        public ParamInfo(String paramName) {
            this.paramName = paramName;
        }

        public ParamInfo(Field field) {
            this.field = field;
        }

        public String getParamName() {
            if (ObjectUtil.isNotNull(paramName)) {
                return paramName;
            }
            paramName = FieldUtils.getParamNameByField(field);
            return paramName;
        }
    }
}
