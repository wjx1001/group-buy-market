package com.wjx.test.infrastructure.dao;

import com.wjx.infrastructure.dao.IGroupBuyDiscountDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupBuyDiscountDaoTest {
    @Resource
    private IGroupBuyDiscountDao groupBuyDiscountDao;
    @Test
    public void test_queryGroupBuyDiscountList() {
        log.info("测试结果:{}", groupBuyDiscountDao.queryGroupBuyDiscountList());
    }
}
