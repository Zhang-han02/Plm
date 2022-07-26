package com.plm.service.impl;

import com.plm.mapper.PlmMapper;
import com.plm.service.PlmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PlmServiceImpl implements PlmService {
    @Autowired
    private PlmMapper plmMapper;


    @Override
    public List<Map<String, Object>> zhongbiao() {
        return plmMapper.zhongbiao();
    }

    @Override
    public List<Map<String, Object>> youshangTop() {
        return plmMapper.youshangTop();
    }

    @Override
    public List<Map<String, Object>> youshangTwo() {
        return plmMapper.youshangTwo();
    }

    @Override
    public List<Map<String, Object>> PojSum() {
        return plmMapper.PojSum();
    }

    @Override
    public List<Map<String, Object>> PojProportion() {
        return plmMapper.PojProportion();
    }

    @Override
    public List<Map<String, Object>> youxiaNo() {
        return plmMapper.youxiaNo();
    }

    @Override
    public List<Map<String, Object>> youxiaTwo() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String, Object>> mapList = plmMapper.youxiaTwo();
        //格式化时间
        for (Map obj: mapList) {
            String name = (String) obj.get("name");
            int index = name.lastIndexOf(".");
            if (index != -1){
                name= name.substring(0,index);
            }
            obj.put("name",name);
            obj.put("endDate",format.format(obj.get("endDate")));
            obj.put("startDate",format.format(obj.get("startDate")));
        }
        return mapList;
    }

    @Override
    public List<List<Object>> zhuzhuangtu() {
        List<List<Object>> lists  = new ArrayList<>();
        List<Map<String, Object>> mapList = plmMapper.zhuzhuangtu();
        for (Map obj: mapList) {
           List<Object> list = new ArrayList<>();
           list.add(obj.get("yue"));
           list.add(obj.get("xinzeng"));
           list.add(obj.get("wancheng"));
           lists.add(list);
        }
        List<Object> noData = new ArrayList<>();
        noData.add("product");
        noData.add("新增项目数量");
        noData.add("已完成数");
        lists.add(0,noData);

        return lists;
    }

    @Override
    public List<Map<String, Object>> selectPojNum() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String, Object>> mapList = plmMapper.selectPojNum();
        for (Map obj: mapList) {
            obj.put("jieshushijian",format.format(obj.get("jieshushijian")));
        }
        return mapList;
    }
}
