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

    @RequestMapping(value = "/zhongbiao", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> zhongbiao(){
        List<Map<String,Object>> zhongbiao = plmService.zhongbiao();
        return CommonResult.success(zhongbiao);
    }
    @RequestMapping(value = "/youshangTop", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> youshangTop(){
        List<Map<String,Object>> youshangTop = plmService.youshangTop();
        return CommonResult.success(youshangTop);
    }
    @RequestMapping(value = "/youshangTwo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> youshangTwo(){
        List<Map<String,Object>> youshangTwo = plmService.youshangTwo();
        return CommonResult.success(youshangTwo);
    }
    @RequestMapping(value = "/PojSum", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> PojSum(){
        List<Map<String,Object>> PojSum = plmService.PojSum();
        return CommonResult.success(PojSum);
    }
    @RequestMapping(value = "/PojProportion", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> PojProportion(){
        List<Map<String,Object>> PojProportion = plmService.PojProportion();
        return CommonResult.success(PojProportion);
    }@RequestMapping(value = "/youxiaNo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> youxiaNo(){
        List<Map<String,Object>> youxiaNo = plmService.youxiaNo();
        return CommonResult.success(youxiaNo);
    }
    @RequestMapping(value = "/youxiaTwo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Map<String,Object>>> youxiaTwo(){
        List<Map<String,Object>> youxiaTwo = plmService.youxiaTwo();
        return CommonResult.success(youxiaTwo);
    }


}
