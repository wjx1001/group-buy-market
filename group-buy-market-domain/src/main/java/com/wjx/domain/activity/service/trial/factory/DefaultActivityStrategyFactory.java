package com.wjx.domain.activity.service.trial.factory;

import com.wjx.domain.activity.model.entity.MarketProductEntity;
import com.wjx.domain.activity.model.entity.TrialBalanceEntity;
import com.wjx.domain.activity.service.trial.node.RootNode;
import com.wjx.types.design.framework.tree.StrategyHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @description 活动策略工厂
 */
@Service
public class DefaultActivityStrategyFactory {
    // 根节点
    private final RootNode rootNode;
    public DefaultActivityStrategyFactory(RootNode rootNode) {
        this.rootNode = rootNode;
    }

    public StrategyHandler<MarketProductEntity,DynamicContext, TrialBalanceEntity> strategyHandler(){
        return rootNode;
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {

    }
}
