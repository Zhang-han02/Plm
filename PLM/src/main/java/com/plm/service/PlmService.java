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






}
