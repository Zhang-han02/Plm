package com.plm.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface PlmMapper {
    List<Map<String,Object>> zhongbiao();

    List<Map<String,Object>> youshangTop();


    List<Map<String,Object>> youshangTwo();

    List<Map<String,Object>> youshangTwoFType();

    List<Map<String,Object>> youshangTwoFTypeTop();


    List<Map<String,Object>> PojSum();


    List<Map<String,Object>> PojProportion();


    List<Map<String,Object>> youxiaNo();


    List<Map<String,Object>> youxiaTwo();

    List<Map<String,Object>> zhuzhuangtu();

    List<Map<String,Object>> selectPojNum();


    List<Map<String,Object>> PojProportionFType();

    List<Map<String,Object>> PojSumFType();

    List<Map<String,Object>> selectPojNumFType();

}
