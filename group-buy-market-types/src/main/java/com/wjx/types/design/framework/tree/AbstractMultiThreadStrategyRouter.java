package com.wjx.types.design.framework.tree;


import lombok.Getter;
import lombok.Setter;

public abstract class AbstractMultiThreadStrategyRouter <T,D,R> implements StrategyMapper<T,D,R>, StrategyHandler<T,D,R> {
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

    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        // 异步加载数据
        mutiThread(requestParameter,dynamicContext);
        // 做受理操作
        return doApply(requestParameter,dynamicContext);
    }
    // 模拟多线程加载数据
    protected abstract void mutiThread(T requestParameter,D dynamicContext) throws Exception;
    // 做受理操作
    protected abstract R doApply(T requestParameter,D dynamicContext) throws Exception;
}
