package com.hoperun.yuntu_maps.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoperun.yuntu_maps.entities.JSONBean;
import com.hoperun.yuntu_maps.entities.MerchantDefinition;
import com.hoperun.yuntu_maps.service.MerchantDefinitionService;

@Controller
public class MerchantDefinitionController {

	@Autowired
	private MerchantDefinitionService merchantDefinitionService;
	
	@RequestMapping("/merchantDefinition/add")
	@ResponseBody
	public JSONBean add(@RequestBody MerchantDefinition merchantDefinition) {
		int result=merchantDefinitionService.add(merchantDefinition);
		if(result>0) {
			return JSONBean.success().addData(result);
		}
		return JSONBean.failure();
	}
	
	/**
     * 分组查询 //http://localhost:8092/merchantDefinition/getMerchantDifinitions
     * @param merchantDefinition
     * @param size
     * @param offset
     * @return
     */
    @RequestMapping("/merchantDefinition/list")
    @ResponseBody
    public JSONBean getMerchantDifinitions(@RequestBody MerchantDefinition merchantDefinition,Integer size,Integer offset){
    	Integer fsize=size==null?10:size;
    	Integer foffset=offset==null?0:offset;
        Map<String,Object> map=new HashMap<>();
        List<MerchantDefinition> list=merchantDefinitionService.getMerchantDifinitions(merchantDefinition,fsize,foffset);
        Long total=merchantDefinitionService.getMerchantDifinitionsTotal(merchantDefinition);
        map.put("rows",list);
        map.put("total",total);
        if(list.size()>0){
            return JSONBean.success().addData(map);
        }
        return JSONBean.failure();
    }
}
