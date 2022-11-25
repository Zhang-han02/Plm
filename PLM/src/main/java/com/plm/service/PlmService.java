package com.plm.service;

import java.util.List;
import java.util.Map;

public interface PlmService {
    /**
     * 客户项目总数
     * @return
     */
    List<Map<String,Object>> zhongbiao();
    /**
     *右上top3
     * @return
     */
    List<Map<String,Object>> youshangTop();
    /**
     *右上二表数据
     * @return
     */
    List<Map<String,Object>> youshangTwo();
    /**
     *项目总数未完成比例
     * @return
     */
    List<Map<String,Object>> PojSum();
    /**
     *客户项目占比
     * @return
     */
    List<Map<String,Object>> PojProportion();
    /**
     *左下一表
     * @return
     */
    List<Map<String,Object>> youxiaNo();
    /**
     *右下二表
     * @return
     */
    List<Map<String,Object>> youxiaTwo();


    /**
     * 页面二柱状图与折线图
     * @return
     */
    Map<String,List<List<Object>>> zhuzhuangtu();

    /**
     * 页面二表格内容
     * @return
     */
    List<Map<String,Object>> selectPojNum();


    /**
     *F类 项目占比
     * @return
     */
    List<Map<String,Object>> PojProportionFType();


    /**
     *F类 项目总数未完成比例
     * @return
     */
    List<Map<String,Object>> PojSumFType();


    /**
     * 页面二表格内容
     * @return
     */
    List<Map<String,Object>> selectPojNumFType();


    /**
     *右上二表数据
     * @return
     */
    List<Map<String,Object>> youshangTwoFType();


    /**
     *右上二表数据
     * @return
     */
    List<Map<String,Object>> youshangTwoFTypeTop();


}
