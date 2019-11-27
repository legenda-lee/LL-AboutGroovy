package com.legenda.lee.studygroovy.usergroovyforrule.service;

public interface RuleEngineGroovyExecutor<T> {
  /**
   * 获取脚本执行实例
   */
  T getInstance(String name);


  /**
   * 编译脚本并缓存
   */
  void praseAndCache(String name, String script);
}
