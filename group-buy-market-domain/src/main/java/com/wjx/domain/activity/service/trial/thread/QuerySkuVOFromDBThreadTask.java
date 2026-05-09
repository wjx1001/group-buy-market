package com.wjx.domain.activity.service.trial.thread;

import com.wjx.domain.activity.adapter.repository.IActivityRepository;
import com.wjx.domain.activity.model.valobj.SkuVO;

import java.util.concurrent.Callable;

public class QuerySkuVOFromDBThreadTask implements Callable<SkuVO> {
   private final IActivityRepository repository;
   private final String goodsId;

    public QuerySkuVOFromDBThreadTask(String goodsId,IActivityRepository repository) {
        this.repository = repository;
        this.goodsId = goodsId;
    }
    @Override
    public SkuVO call() throws Exception {
        return repository.querySkuByGoodsId(goodsId);
    }
}
