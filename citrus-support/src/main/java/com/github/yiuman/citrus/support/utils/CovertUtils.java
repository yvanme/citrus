package com.github.yiuman.citrus.support.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yiuman
 * @date 2020/4/6
 */
public final class CovertUtils {

    private CovertUtils() {
    }

    public static <S, T> T convert(Class<T> clazz, S source) throws Exception {
        T t = clazz.newInstance();
        org.springframework.beans.BeanUtils.copyProperties(source, t);
        return t;
    }

    /**
     * 对象转Map
     *
     * @param s   对象
     * @param <S> 类型
     */
    public static <S> Map<String, Object> objectToMap(S s) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(s.getClass());
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            if ("class".equals(pd.getName())) {
                continue;
            }
            Object invokeValue = pd.getReadMethod().invoke(s);
            map.put(pd.getDisplayName(), invokeValue == null ? "" : invokeValue);
        }
        return map;
    }
}
