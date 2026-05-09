package com.wjx.domain.activity.adapter.repository;

import com.wjx.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.wjx.domain.activity.model.valobj.SkuVO;

public interface IActivityRepository {
   GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(String source,String channel);

   SkuVO querySkuByGoodsId(String goodsId);
}
