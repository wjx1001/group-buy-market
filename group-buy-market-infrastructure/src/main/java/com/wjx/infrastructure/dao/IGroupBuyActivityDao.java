package com.wjx.infrastructure.dao;

import com.wjx.infrastructure.dao.po.GroupBuyActivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGroupBuyActivityDao {

  List<GroupBuyActivity> queryGroupBuyActivityList();

}
