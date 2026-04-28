package com.wjx.types.design.framework.tree;

/***
 * 策略处理器
 * T 入参类型
 * D 上下文参数
 * R 返参类型
 * @author wjx
 */

public interface StrategyHandler<T,D,R> {
    /**
     * 默认策略处理器
     */
    StrategyHandler DEFAULT = (T, D) -> null;

    /**
     * 执行策略
     * @param requestParameter 入参
     * @param dynamicContext 上下文
     * @return 返参
     * @throws Exception 异常
     */
    R apply(T requestParameter,D dynamicContext) throws Exception;


}
