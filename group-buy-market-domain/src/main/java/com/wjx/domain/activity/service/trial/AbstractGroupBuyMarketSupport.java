package com.wjx.domain.activity.service.trial;


import com.wjx.domain.activity.adapter.repository.IActivityRepository;
import com.wjx.types.design.framework.tree.AbstractMultiThreadStrategyRouter;
import com.wjx.types.design.framework.tree.AbstractStrategyRouter;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity,DynamicContext,TrialBalanceEntity> extends AbstractMultiThreadStrategyRouter<MarketProductEntity,DynamicContext,TrialBalanceEntity> {
    @Resource
    protected IActivityRepository repository;
    protected long timeout = 500;

    @Override
    protected void mutiThread(MarketProductEntity requestParameter, DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException {

    }
}
