package com.plm.controller;

import com.plm.common.CommonResult;
import com.plm.service.PlmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/plm")
public class PlmController {
    @Autowired
    private PlmService plmService;

    /**
     * 客户项目总数
     * @return
     */
    @RequestMapping(value = "/zhongbiao", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> zhongbiao(){
        List<Map<String,Object>> zhongbiao = plmService.zhongbiao();
        return CommonResult.success(zhongbiao);
    }
    /**
     *右上top3
     * @return
     */
    @RequestMapping(value = "/youshangTop", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> youshangTop(){
        List<Map<String,Object>> youshangTop = plmService.youshangTop();
        return CommonResult.success(youshangTop);
    }
    /**
     *右上二表数据
     * @return
     */
    @RequestMapping(value = "/youshangTwo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> youshangTwo(){
        List<Map<String,Object>> youshangTwo = plmService.youshangTwo();
        return CommonResult.success(youshangTwo);
    }
    /**
     *项目总数未完成比例
     * @return
     */
    @RequestMapping(value = "/PojSum", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> PojSum(){
        List<Map<String,Object>> PojSum = plmService.PojSum();
        return CommonResult.success(PojSum);
    }
    /**
     *客户项目占比
     * @return
     */
    @RequestMapping(value = "/PojProportion", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> PojProportion(){
        List<Map<String,Object>> PojProportion = plmService.PojProportion();
        return CommonResult.success(PojProportion);
    }
    /**
     *左下一表
     * @return
     */
    @RequestMapping(value = "/youxiaNo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> youxiaNo(){
        List<Map<String,Object>> youxiaNo = plmService.youxiaNo();
        return CommonResult.success(youxiaNo);
    }
    /**
     *右下二表
     * @return
     */
    @RequestMapping(value = "/youxiaTwo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> youxiaTwo(){
        List<Map<String,Object>> youxiaTwo = plmService.youxiaTwo();
        return CommonResult.success(youxiaTwo);
    }

    /**
     * 页面二 柱状图与折线图
     * @return
     */
    @RequestMapping(value = "/zhuzhuangtu", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Map<String,List<List<Object>>>> zhuzhuangtu(){
        Map<String,List<List<Object>>> zhuzhuangtu = plmService.zhuzhuangtu();
        return CommonResult.success(zhuzhuangtu);
    }

    /**
     * 页面二表格数据
     * @return
     */
    @RequestMapping(value = "/selectPojNum", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> selectPojNum(){
        List<Map<String,Object>> selectPojNum = plmService.selectPojNum();
        return CommonResult.success(selectPojNum);
    }


}
