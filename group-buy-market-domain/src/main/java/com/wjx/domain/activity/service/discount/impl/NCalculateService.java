package com.wjx.domain.activity.service.discount.impl;

import com.wjx.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.wjx.domain.activity.service.discount.AbstractDiscountCalculateService;
import com.wjx.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service("N")
public class NCalculateService extends AbstractDiscountCalculateService {
    @Override
    protected BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        String markExpr = groupBuyDiscount.getMarketExpr();

        return new BigDecimal(markExpr);
    }
}
