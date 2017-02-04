package com.tywy.utils.wechat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 字符串常用方法工具类
 *
 * @author Liuheli
 */
public final class CommonUtils {

    /**
     * 此类不需要实例化
     */
    private CommonUtils() {
    }

    /**
     * 判断一个字符串是否为空，null也会返回true
     *
     * @param str 需要判断的字符串
     * @return 是否为空，null也会返回true
     */
    public static boolean isBlank(String str) {
        return null == str || "".equals(str.trim());
    }

    /**
     * 判断一个字符串是否不为空
     *
     * @param str 需要判断的字符串
     * @return 是否为空
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 判断一组字符串是否有空值
     *
     * @param strs 需要判断的一组字符串
     * @return 判断结果，只要其中一个字符串为null或者为空，就返回true
     */
    public static boolean hasBlank(String... strs) {
        if (null == strs || 0 == strs.length) {
            return true;
        } else {
            //这种代码如果用java8就会很优雅了
            for (String str : strs) {
                if (isBlank(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断对象是否为null
     *
     * @param object 需要判断的对象
     * @return 是否为null
     */
    public static boolean isNull(Object object) {
        return null == object;
    }

    /**
     * 判断对象是否不为null
     *
     * @param object 需要判断的对象
     * @return 是否不为null
     */
    public static boolean nonNull(Object object) {
        return null != object;
    }

    /**
     * 判断对象是否为空，如果为空，直接抛出异常
     *
     * @param object       需要检查的对象
     * @param errorMessage 异常信息
     * @return 非空的对象
     */
    public static Object requireNonNull(Object object, String errorMessage) {
        if (null == object) {
            throw new NullPointerException(errorMessage);
        }
        return object;
    }

    /**
     * 判断一个集合是否为空
     * null或者空集合都会返回true
     *
     * @param collection 需要判断的集合
     * @return 是否有值，null或者空集合都是返回true
     */
    public static boolean isCollectionEmpty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * 判断一个集合是否不为空
     *
     * @param collection 需要判断的集合
     * @return 是否不为空
     */
    public static boolean isCollectionNotEmpty(Collection<?> collection) {
        return null != collection && !collection.isEmpty();
    }

    /**
     * 创建一个空集合
     *
     * @param <T> 泛型
     * @return 集合对象
     */
    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<T>();
    }

    /**
     * 创建一个指定大小的集合
     *
     * @param initialCapacity 集合大小
     * @param <T>             泛型
     * @return 集合对象
     */
    public static <T> ArrayList<T> newArrayList(int initialCapacity) {
        return new ArrayList<T>(initialCapacity);
    }

    /**
     * 创建一个有默认内容的集合
     *
     * @param <T> 泛型
     * @param ele 内容
     * @return 集合对象
     */
    public static <T> ArrayList newArrayList(T... ele) {
        ArrayList list = null;
        if (null != ele && 0 != ele.length) {
            list = newArrayList(ele.length);
            Collections.addAll(list, ele);
        }
        return list;
    }
}