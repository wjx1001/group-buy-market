package com.wjx.infrastructure.adapter.repository;

import com.wjx.domain.tag.adapter.repository.ITagRepository;
import com.wjx.domain.tag.model.entity.CrowdTagsJobEntity;
import com.wjx.infrastructure.dao.ICrowdTagsDao;
import com.wjx.infrastructure.dao.ICrowdTagsDetailDao;
import com.wjx.infrastructure.dao.ICrowdTagsJobDao;
import com.wjx.infrastructure.dao.po.CrowdTags;
import com.wjx.infrastructure.dao.po.CrowdTagsDetail;
import com.wjx.infrastructure.dao.po.CrowdTagsJob;
import com.wjx.infrastructure.redis.IRedisService;
import org.redisson.api.RBitSet;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class TagRepository implements ITagRepository {
   @Resource
   private ICrowdTagsDao crowdTagsDao;
    @Resource
   private ICrowdTagsDetailDao crowdTagsDetailDao;
    @Resource
   private ICrowdTagsJobDao crowdTagsJobDao;
    @Resource
    private IRedisService redisService;

    @Override
    public CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId) {
        CrowdTagsJob crowdTagsJob = new CrowdTagsJob();
        crowdTagsJob.setBatchId(batchId);
        crowdTagsJob.setTagId(tagId);
        CrowdTagsJob crowdTagsJobRes = crowdTagsJobDao.queryCrowdTagsJob(crowdTagsJob);
        return  CrowdTagsJobEntity.builder()
                .tagType(crowdTagsJobRes.getTagType())
                .tagRule(crowdTagsJobRes.getTagRule())
                .statStartTime(crowdTagsJobRes.getStatStartTime())
                .statEndTime(crowdTagsJobRes.getStatEndTime())
                .build();

    }

    @Override
    public void addCrowdTagsUserId(String tagId, String userId) {
        CrowdTagsDetail crowdTagsDetail = new CrowdTagsDetail();
        crowdTagsDetail.setTagId(tagId);
        crowdTagsDetail.setUserId(userId);
        try {
            crowdTagsDetailDao.addCrowdTagsUserId(crowdTagsDetail);
            RBitSet bitSet = redisService.getBitSet(tagId);
            bitSet.set(redisService.getIndexFromUserId(userId));
        }catch (DuplicateKeyException e){

        }

    }

    @Override
    public void updateCrowdTagsStatistics(String tagId, int size) {
        CrowdTags crowdTags = new CrowdTags();
        crowdTags.setTagId(tagId);
        crowdTags.setStatistics(size);
        crowdTagsDao.updateCrowdTagsStatistics(crowdTags);
    }
}
