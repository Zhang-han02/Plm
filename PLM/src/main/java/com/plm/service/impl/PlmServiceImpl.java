package com.plm.service.impl;

import com.plm.common.Asserts;
import com.plm.mapper.PlmMapper;
import com.plm.service.PlmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

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
        try {
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
        } catch (Exception e){
            Asserts.fail("右下角表格查询失败");
        }
        return null;
    }

    @Override
    public Map<String,List<List<Object>>> zhuzhuangtu() {
        List<List<Object>> zhuzhuangtu  = new ArrayList<>();
        List<List<Object>> zhexiantu  = new ArrayList<>();
        List<Object> wancheng = new ArrayList<>();
        List<Object> xinzeng = new ArrayList<>();
        Map<String,List<List<Object>>> data  = new LinkedHashMap<>(2);
        List<Map<String, Object>> mapList = plmMapper.zhuzhuangtu();
        try{
            for (Map obj: mapList) {
                //折线图数据格式
                List<Object> list = new ArrayList<>();
                xinzeng.add(obj.get("xinzeng"));
                wancheng.add(obj.get("wancheng"));
                //柱状图数据格式
                list.add(obj.get("yue"));
                list.add(obj.get("xinzeng"));
                list.add(obj.get("wancheng"));
                zhuzhuangtu.add(list);
            }
            zhexiantu.add(xinzeng);
            zhexiantu.add(wancheng);
            List<Object> noData = new ArrayList<>();
            noData.add("product");
            noData.add("新增项目数量");
            noData.add("已完成数");
            zhuzhuangtu.add(0,noData);
            data.put("zhuzhuangtu",zhuzhuangtu);
            data.put("zhexiantu",zhexiantu);


            return data;
        } catch (Exception e){
            Asserts.fail("柱状图查询失败");
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> selectPojNum() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String, Object>> mapList = plmMapper.selectPojNum();
        try{
            //格式化时间
            for (Map obj: mapList) {
                obj.put("jieshushijian",format.format(obj.get("jieshushijian")));
            }
            return mapList;
        } catch (Exception e){
            Asserts.fail("项目查询失败");
        }
        return  null;
    }

    @Override
    public List<Map<String, Object>> PojProportionFType() {
        return plmMapper.PojProportionFType();
    }

    @Override
    public List<Map<String, Object>> PojSumFType() {
        return plmMapper.PojSumFType();
    }

    @Override
    public List<Map<String, Object>> selectPojNumFType() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String, Object>> mapList = plmMapper.selectPojNumFType();
        try{
            //格式化时间
            for (Map obj: mapList) {
                obj.put("jieshushijian",format.format(obj.get("jieshushijian")));
            }
            return mapList;
        } catch (Exception e){
            Asserts.fail("项目查询失败");
        }
        return  null;
    }

    @Override
    public List<Map<String, Object>> youshangTwoFType() {
        return plmMapper.youshangTwoFType();
    }

    @Override
    public List<Map<String, Object>> youshangTwoFTypeTop() {
        return plmMapper.youshangTwoFTypeTop();
    }
}
