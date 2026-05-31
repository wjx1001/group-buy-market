package com.wjx.domain.activity.service.trial.thread;

import com.wjx.domain.activity.adapter.repository.IActivityRepository;
import com.wjx.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.wjx.domain.activity.model.valobj.SCSkuActivityVO;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

public class QueryGroupBuyActivityDiscountVOThreadTask implements Callable<GroupBuyActivityDiscountVO> {

    private final String channel;
    private final String source;
    private final String goodsId;
    private final IActivityRepository activityRepository;

    public QueryGroupBuyActivityDiscountVOThreadTask(String source, String channel, String goodsId, IActivityRepository activityRepository) {
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
        this.channel = channel;
        this.source = source;
    }

    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {
      SCSkuActivityVO scSkuActivityVO = activityRepository.querySCSkuActivityBySCGoodsId(source,channel,goodsId);
         if (scSkuActivityVO == null) return null;
        return activityRepository.queryGroupBuyActivityDiscountVO(scSkuActivityVO.getActivityId());
    }

}
