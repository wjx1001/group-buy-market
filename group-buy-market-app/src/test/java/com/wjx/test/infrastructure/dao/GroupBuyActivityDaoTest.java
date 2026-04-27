package com.wjx.test.infrastructure.dao;

import com.wjx.infrastructure.dao.IGroupBuyActivityDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupBuyActivityDaoTest {
    @Resource
    private IGroupBuyActivityDao groupBuyActivityDao;
    @Test
    public void test_queryGroupBuyActivityList() {
        log.info("测试结果:{}", groupBuyActivityDao.queryGroupBuyActivityList());
    }
}
