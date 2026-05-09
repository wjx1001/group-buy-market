package com.wjx.domain.activity.service.trial.thread;

import com.wjx.domain.activity.adapter.repository.IActivityRepository;
import com.wjx.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

public class QueryGroupBuyActivityDiscountVOThreadTask implements Callable<GroupBuyActivityDiscountVO> {

    private final String channel;
    private final String source;
    private final IActivityRepository repository;

    public QueryGroupBuyActivityDiscountVOThreadTask(String source,String channel,IActivityRepository repository) {
        this.repository = repository;
        this.channel = channel;
        this.source = source;
    }

    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {
        return repository.queryGroupBuyActivityDiscountVO(source,channel);
    }

}
