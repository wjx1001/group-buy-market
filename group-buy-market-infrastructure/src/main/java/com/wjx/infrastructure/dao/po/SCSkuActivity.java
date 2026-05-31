package com.wjx.infrastructure.dao.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SCSkuActivity {
    private Long id;
    private String source;
    private String channel;
    private Long activityId;
    private String goodsId;
    private Date createTime;
    private Date updateTime;

}
