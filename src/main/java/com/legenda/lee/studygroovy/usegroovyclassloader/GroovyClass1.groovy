package com.legenda.lee.studygroovy.usegroovyclassloader

/**
 * @author Legenda-Lee
 * @date 2019-11-27 19:19
 * @description 这是一个Groovy Class
 * @since 1.0.0
 */
class GroovyClass1 {

    public String sayHello(String name, String sex, int age) {
        println 'GroovyClass1 的sayHello(String name, String sex, int age)方法';

        return "name: " + name + ", sex: " + sex + ", age: " + age;
    }

    public String sayHello1(Map<String, Object> context, String feature, String operator, int condition) {
        return context.get(feature) + operator + condition;
    }


}
