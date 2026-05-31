package com.wjx.domain.activity.adapter.repository;

import com.wjx.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.wjx.domain.activity.model.valobj.SCSkuActivityVO;
import com.wjx.domain.activity.model.valobj.SkuVO;

public interface IActivityRepository {
   GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId);

   SkuVO querySkuByGoodsId(String goodsId);

   SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId);
}
