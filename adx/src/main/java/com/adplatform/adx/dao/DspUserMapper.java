package com.adplatform.adx.dao;

import com.adplatform.adx.pojo.DspUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Mapper
public interface DspUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DspUser record);

    int insertSelective(DspUser record);

    DspUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DspUser record);

    int updateByPrimaryKey(DspUser record);

    @Select("select * from dsp_user")
    ArrayList<DspUser> findAll();
}