package com.wjx.domain.activity.service;

import com.wjx.domain.activity.model.entity.MarketProductEntity;
import com.wjx.domain.activity.model.entity.TrialBalanceEntity;

public interface IIndexGroupBuyMarketService {
    TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception;

}
