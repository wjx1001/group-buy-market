package com.wjx.domain.tag.service;

import com.wjx.domain.tag.adapter.repository.ITagRepository;
import com.wjx.domain.tag.model.entity.CrowdTagsJobEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;
import java.util.ArrayList;

@Slf4j
@Service
public class TagService implements ITagService {

    @Resource
    private ITagRepository repository;

    @Override
    public void execTagBatchJob(String tagId, String batchId) {
        CrowdTagsJobEntity crowdTagsJobEntity = repository.queryCrowdTagsJobEntity(tagId, batchId);
        // 采集用户数据
        List<String> userIds = new ArrayList<String>(){{
            add("xiaofuge");
            add("liergou");
        }};
        for(String userId : userIds){
            repository.addCrowdTagsUserId(tagId, userId);
        }
        // 更新统计数据
        repository.updateCrowdTagsStatistics(tagId, userIds.size());
    }
}
