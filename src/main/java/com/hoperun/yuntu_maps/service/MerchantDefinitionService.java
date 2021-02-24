package com.hoperun.yuntu_maps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoperun.yuntu_maps.entities.MerchantDefinition;
import com.hoperun.yuntu_maps.mapper.MerchantDefinitionMapper;

@Service
public class MerchantDefinitionService {

	@Autowired
	private MerchantDefinitionMapper merchantDefinitionMapper;
		
	/**
	 * add
	 * @param merchantDefinition
	 * @return
	 */
	public int add(MerchantDefinition merchantDefinition) {
		return merchantDefinitionMapper.add(merchantDefinition);
	}
	
	/**
	 * del
	 * @param id
	 */
    public void del(Long id){
    	merchantDefinitionMapper.del(id);
    }
    
    /**
     * get one
     * @param uuid
     * @return
     */
    public MerchantDefinition get(Long id){
        return merchantDefinitionMapper.get(id);
    }

    /**
     * 分组查询
     * @param merchantDefinition
     * @param size
     * @param offset
     * @return
     */
    public List<MerchantDefinition> getMerchantDifinitions(MerchantDefinition merchantDefinition, Integer size, Integer offset){
        return merchantDefinitionMapper.getMerchantDifinitions(merchantDefinition,size,offset);
    }
    
    /**
     * 分组查询总数
     * @param merchantDefinition
     * @return
     */
    public Long getMerchantDifinitionsTotal(MerchantDefinition merchantDefinition){
        return  merchantDefinitionMapper.getMerchantDifinitionsTotal(merchantDefinition);
    };
}


