package com.wjx.domain.activity.service.trial.node;

import com.wjx.domain.activity.model.entity.MarketProductEntity;
import com.wjx.domain.activity.model.entity.TrialBalanceEntity;
import com.wjx.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.wjx.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.wjx.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EndNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {
    @Override
    public TrialBalanceEntity apply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return null;
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return null;
    }
}
