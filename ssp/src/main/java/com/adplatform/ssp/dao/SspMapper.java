package com.adplatform.ssp.dao;

import com.adplatform.ssp.pojo.Ssp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface SspMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Ssp record);

    int insertSelective(Ssp record);

    Ssp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Ssp record);

    int updateByPrimaryKey(Ssp record);
}