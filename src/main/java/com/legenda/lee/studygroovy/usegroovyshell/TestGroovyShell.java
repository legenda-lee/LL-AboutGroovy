package com.legenda.lee.studygroovy.usegroovyshell;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.io.File;
import java.io.IOException;

/**
 * @author Legenda-Lee
 * @date 2019-11-27 18:54
 * @description GroovyShell的evaluate方法非常类似于Js的eva方法，可执行一段字符串。
 * @since 1.0.0
 */
public class TestGroovyShell {

    public static void main(String[] args) throws IOException {
        // 方式一：GroovyShell的evaluate方法非常类似于Js的eva方法，可执行一段字符串。
        GroovyShell groovyShell = new GroovyShell();
        groovyShell.evaluate("println 'My First Groovy shell.'");

        // 方式二：通过evaluate方法调用groovy脚本文件
        Object result = groovyShell.evaluate(new File("src\\main\\java\\com\\legenda\\lee\\studygroovy\\usegroovyshell\\shell1.groovy"));
        System.out.println(result);

        // 方式三：你可以传一个参数给Groovy文件并执行
        // 调用带参数的groovy shell时，使用bind绑定数据
        Binding binding = new Binding();
        binding.setProperty("name", "Legenda-Lee");

        GroovyShell groovyShell1 = new GroovyShell(binding);
        Object result1 = groovyShell1.evaluate(new File("src\\main\\java\\com\\legenda\\lee\\studygroovy\\usegroovyshell\\shell2.groovy"));
        System.out.println(result1);

    }
}
