package com.wjx.types.design.framework.tree;

import lombok.Getter;
import lombok.Setter;

/*
 * 策略路由器
 * T 入参类型
 * D 上下文参数
 * R 返参类型
 * @author wjx
 */
public abstract class AbstractStrategyRouter<T,D,R> implements StrategyMapper<T,D,R>, StrategyHandler<T,D,R> {
    @Getter
    @Setter
    /**
     * 默认策略处理器
     */
    protected  StrategyHandler<T,D,R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    /*
    *  路由策略
     * @param requestParameter 入参
     * @param dynamicContext 上下文
     * @return 返参
     * @throws Exception 异常
    * */

    public R router(T requestParameter,D dynamicContext) throws Exception {
        StrategyHandler<T,D,R> strategyHandler = get(requestParameter, dynamicContext);
        if(null!=strategyHandler){
          return strategyHandler.apply(requestParameter, dynamicContext);
        }
        return defaultStrategyHandler.apply(requestParameter, dynamicContext);
    }
}
