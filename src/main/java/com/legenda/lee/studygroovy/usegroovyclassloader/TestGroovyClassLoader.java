package com.legenda.lee.studygroovy.usegroovyclassloader;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.codehaus.groovy.control.CompilerConfiguration;

import java.io.File;

/**
 * @author Legenda-Lee
 * @date 2019-11-27 19:17
 * @description 通过GroovyClassLoader动态加载Groovy Class
 * @since 1.0.0
 */
public class TestGroovyClassLoader {
    private static GroovyClassLoader groovyClassLoader = null;

    public static void initGroovyClassLoader() {
        CompilerConfiguration config = new CompilerConfiguration();
        config.setSourceEncoding("UTF-8");
        // 设置该GroovyClassLoader的父ClassLoader为当前线程的加载器(默认)
        groovyClassLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader(), config);
    }

    /**
     * 通过GroovyClassLoader加载GroovyClass1，并反射调用其sayHello(String name, String sex, int age)方法
     *
     */
    public static String invokeSayHello(String name, String sex, int age) {
        String result = "";

        File groovyFile = new File("src/main/java/com/legenda/lee/studygroovy/usegroovyclassloader/GroovyClass1.groovy");
        if (!groovyFile.exists()) {
            return result;
        }

        try {
            // 获得GroovyClass1加载后的class
            Class<?> groovyClass = groovyClassLoader.parseClass(groovyFile);
            // 获得GroovyClass1的实例
            GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
            // // 反射调用sayHello方法得到返回值
            // Object methodResult = groovyObject.invokeMethod("sayHello", new Object[] {name, sex, age});
            // if (methodResult != null) {
            //     result = methodResult.toString();
            // }

            // 反射调用sayHello1方法得到返回值
            // Map<String, Object> context = new HashMap<>();
            // context.put("field1", 2);
            // Object methodResult1 = groovyObject.invokeMethod("sayHello1", new Object[] {context, "field1", ">", 2});
            // if (methodResult1 != null) {
            //     result = methodResult1.toString();
            //     GroovyShell groovyShell = new GroovyShell();
            //     result = groovyShell.evaluate(result).toString();
            // }

        } catch (Exception e) {
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        initGroovyClassLoader();
        System.out.println(invokeSayHello("张三", "男", 25));
    }

}
