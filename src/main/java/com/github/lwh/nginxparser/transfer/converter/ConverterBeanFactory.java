package com.github.lwh.nginxparser.transfer.converter;


/**
 * bean factory
 *
 * @author longwenhao
 * @version 1.0, 2021/5/29 07 : 45
 */
public class ConverterBeanFactory {

    /**
     * 通过实例类型获取对应的处理类
     *
     * @param clazz 实例类型
     */
    public static Converter getConverter(Class<?> clazz) {
        for (ConverterEnum converterEnum : ConverterEnum.values()) {
            if (converterEnum.converter.needConverter(clazz)) {
                return converterEnum.converter;
            }
        }
        return ConverterEnum.BEAN.converter;
    }


    /**
     * 使用内部枚举的原因： 1.单例持有实现类 2.枚举天生的排序性，实现顺序查找最近的处理类 3.更好的实现方式是参考现有框架扫描指定包下的实现类实现顺序和优先级，待优化
     */
    enum ConverterEnum {

        STRING(new TypeConverter()),

        COLLECTION(new CollectionConverter()),

        MAP(new MapConverter()),

        BEAN(new BeanConverter());

        private final Converter<?> converter;

        ConverterEnum(Converter<?> converter) {
            this.converter = converter;
        }

    }

}
