package com.legenda.lee.studygroovy.usegroovyscriptengine;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;

/**
 * @author Legenda-Lee
 * @date 2019-11-27 19:26
 * @description
 * @since 1.0.0
 */
public class TestGroovyScriptEngine {
    public static void main(String[] args) throws Exception {
        // GroovyScriptEngine的根路径，如果参数是字符串数组，说明有多个根路径
        GroovyScriptEngine engine = new GroovyScriptEngine("src/main/java/com/legenda/lee/studygroovy/usegroovyscriptengine/");
        //GroovyScriptEngine engine = new GroovyScriptEngine(new String[] {"src/main/java/com/juxinli/groovy/shell/"});

        Binding binding = new Binding();
        binding.setVariable("name", "Legenda-Lee");

        Object result1 = engine.run("shell1.groovy", binding);
        System.out.println(result1);
        Object result2 = engine.run("shell2.groovy", binding);
        System.out.println(result2);
        Object result3 = engine.run("shell3.groovy", binding);
        System.out.println(result3);
    }
}
