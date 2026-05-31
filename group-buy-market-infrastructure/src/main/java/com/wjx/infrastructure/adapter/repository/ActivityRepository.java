package com.wjx.infrastructure.adapter.repository;

import com.wjx.domain.activity.adapter.repository.IActivityRepository;
import com.wjx.domain.activity.model.valobj.DiscountTypeEnum;
import com.wjx.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.wjx.domain.activity.model.valobj.SCSkuActivityVO;
import com.wjx.domain.activity.model.valobj.SkuVO;
import com.wjx.infrastructure.dao.IGroupBuyActivityDao;
import com.wjx.infrastructure.dao.IGroupBuyDiscountDao;
import com.wjx.infrastructure.dao.ISCSkuActivityDao;
import com.wjx.infrastructure.dao.ISkuDao;
import com.wjx.infrastructure.dao.po.GroupBuyActivity;
import com.wjx.infrastructure.dao.po.GroupBuyDiscount;
import com.wjx.infrastructure.dao.po.SCSkuActivity;
import com.wjx.infrastructure.dao.po.Sku;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ActivityRepository implements IActivityRepository {
    @Resource
    private IGroupBuyActivityDao groupBuyActivityDao;
    @Resource
    private IGroupBuyDiscountDao groupBuyDiscountDao;
    @Resource
    private ISkuDao skuDao;

    @Resource
    private ISCSkuActivityDao scSkuActivityDao;

    @Override
    public GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId) {

        GroupBuyActivity groupBuyActivityRes = groupBuyActivityDao.queryValidGroupBuyActivityId(activityId);
        if(null==groupBuyActivityRes) return null;
        String discountId = groupBuyActivityRes.getDiscountId();
        GroupBuyDiscount groupBuyDiscountRes = groupBuyDiscountDao.queryGroupBuyActivityDiscountByDiscountId(discountId);
        if(null==groupBuyDiscountRes) return null;
        GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount = GroupBuyActivityDiscountVO.GroupBuyDiscount.builder()
                .discountName(groupBuyDiscountRes.getDiscountName())
                .discountDesc(groupBuyDiscountRes.getDiscountDesc())
                .discountType(DiscountTypeEnum.get(groupBuyDiscountRes.getDiscountType()))
                .marketPlan(groupBuyDiscountRes.getMarketPlan())
                .marketExpr(groupBuyDiscountRes.getMarketExpr())
                .tagId(groupBuyDiscountRes.getTagId())
                .build();
        return GroupBuyActivityDiscountVO.builder()
                .activityId(groupBuyActivityRes.getActivityId())
                .activityName(groupBuyActivityRes.getActivityName())
                .groupBuyDiscount(groupBuyDiscount)
                .groupType(groupBuyActivityRes.getGroupType())
                .takeLimitCount(groupBuyActivityRes.getTakeLimitCount())
                .target(groupBuyActivityRes.getTarget())
                .validTime(groupBuyActivityRes.getValidTime())
                .status(groupBuyActivityRes.getStatus())
                .startTime(groupBuyActivityRes.getStartTime())
                .endTime(groupBuyActivityRes.getEndTime())
                .tagId(groupBuyActivityRes.getTagId())
                .tagScope(groupBuyActivityRes.getTagScope())
                .build();
    }

    @Override
    public SkuVO querySkuByGoodsId(String goodsId) {
        Sku sku = skuDao.querySkuByGoodsId(goodsId);
        if(null==sku) return null;
        return SkuVO.builder()
                .goodsId(sku.getGoodsId())
                .goodsName(sku.getGoodsName())
                .originalPrice(sku.getOriginalPrice())
                .build();
    }

    @Override
    public SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId) {
        SCSkuActivity scSkuActivityReq = new SCSkuActivity();
        scSkuActivityReq.setChannel(channel);
        scSkuActivityReq.setSource(source);
        scSkuActivityReq.setGoodsId(goodsId);
        SCSkuActivity scSkuActivity = scSkuActivityDao.querySCSkuActivityBySCGoodsId(scSkuActivityReq);
        if(null==scSkuActivity) return null;
        SCSkuActivityVO scSkuActivityVO = SCSkuActivityVO.builder()
                .activityId(scSkuActivity.getActivityId())
                .goodsId(scSkuActivity.getGoodsId())
                .source(scSkuActivity.getSource())
                .channel(scSkuActivity.getChannel())
                .build();
        return scSkuActivityVO;

    }
}
