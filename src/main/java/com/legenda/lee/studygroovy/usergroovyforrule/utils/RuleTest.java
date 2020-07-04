/*
 * Copyright 2019 Legenda-Lee(lee.legenda@gmail.com) All Rights Reserved.
 */

package com.legenda.lee.studygroovy.usergroovyforrule.utils;

import com.legenda.lee.studygroovy.usergroovyforrule.service.EngineGroovyModuleRule;
import groovy.lang.GroovyClassLoader;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2019-12-07 20:39
 * @description:
 */
public class RuleTest {

    public static void main(String[] args) {
        // 这是规则模板
        String template = "import com.legenda.lee.studygroovy.usergroovyforrule.service.*\n" +
                "import com.legenda.lee.studygroovy.usergroovyforrule.utils.*\n" +
                "class %s implements EngineGroovyModuleRule {\n" +
                "    Boolean run(Object context, Object result) {\n" +
                "        %s //place holder\n" +
                "    }\n" +
                "}";

        // 这一部分String的获取逻辑进行可配置化
        String StrategyLogicUnit1 = "if(context.getAmount()>=20000){\n" +
                "            context.nextScenario= 52\n" +
                "            return true\n" +
                "        }\n" +
                "        ";

        // 这一部分String的获取逻辑进行可配置化
        String StrategyLogicUnit2 = "if(context.ruleParamMap.field2.equals('lee2')){\n" +
                "            context.nextScenario= 6\n" +
                "            return true\n" +
                "        }\n" +
                "      return false\n " +
                "        ";

        // 这一部分String的获取逻辑进行可配置化
        String StrategyLogicUnit3 = "if(context1.ruleParamMap.nextScenario > 4){\n" +
                "            context.nextScenario= 6\n" +
                "            return true\n" +
                "        }\n" +
                "      return false\n " +
                "        ";

        // 这一部分String的获取逻辑进行可配置化
        String StrategyLogicUnit4 = "if(field > 4){\n" +
                // "            context.nextScenario= 6\n" +
                "            return true\n" +
                "        }\n" +
                "      return false\n " +
                "        ";

        // 这一部分String的获取逻辑进行可配置化
        String StrategyLogicUnit5 = "if(context.ruleParamMap.field2.equals('lee2')){\n" +
                "            MD5Utils.getStringMD5('hehe')\n" +
                "            return true\n" +
                "        }\n" +
                "      return false\n " +
                "        ";

        // 这一部分String的获取逻辑进行可配置化
        String className = "ScriptClassName";

        String fullScript = String.format(template, className, StrategyLogicUnit5);

        GroovyClassLoader classLoader = new GroovyClassLoader();
        Class<EngineGroovyModuleRule> aClass = classLoader.parseClass(fullScript);
        Context context = new Context();
        context.setAmount(30000);

        context.getRuleParamMap().put("field1", "lee1");
        context.getRuleParamMap().put("field2", "lee2");

        try {
            EngineGroovyModuleRule engineGroovyModuleRule = aClass.newInstance();
            System.out.println(engineGroovyModuleRule.run(context, null));

            Integer field = 4;
            System.out.println(engineGroovyModuleRule.run(field, null));
            System.out.println(context.getNextScenario());

        } catch (Exception e){
        }

    }

}
