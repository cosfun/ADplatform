package com.adplatform.ssp.dao;

import com.adplatform.ssp.pojo.AdInfo;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AdInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdInfo record);

    int insertSelective(AdInfo record);

    AdInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdInfo record);

    int updateByPrimaryKey(AdInfo record);
}