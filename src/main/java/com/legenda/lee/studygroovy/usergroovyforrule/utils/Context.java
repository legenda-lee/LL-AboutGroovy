/*
 * Copyright 2019 Legenda-Lee(lee.legenda@gmail.com) All Rights Reserved.
 */

package com.legenda.lee.studygroovy.usergroovyforrule.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2019-12-07 20:44
 * @description:
 */
@Data
public class Context {
    int amount;

    Map<String,String> ruleParamMap = new HashMap<>();

    int nextScenario;

}
