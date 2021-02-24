package com.hoperun.yuntu_maps.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hoperun.yuntu_maps.entities.MerchantDefinition;

public interface MerchantDefinitionMapper {
	
	/**
     * 新增
     * @param merchantDefinition
     * @return ra - > result affect
     */
    public int add(MerchantDefinition merchantDefinition);
    
    /**
     * 删除
     * @param uuid
     */
    public void del(Long id);

    /**
     * 修改
     * @param merchantDefinition  必须传入完整的MerchantDefinition实例，包含uuid
     *                            用户只能修改MerchantName description，其他字段非用户输入
     *                            也不能修改
     * @return
     */
    public MerchantDefinition modify(MerchantDefinition merchantDefinition);

    /**
     * 查询单条
     * @param uuid
     * @return
     */
    public MerchantDefinition get(Long id);

    /**
     * 条件查询一组
     * @param merchantDefinition
     * @param size
     * @param offset
     * @return
     */
    public List<MerchantDefinition> getMerchantDifinitions(@Param("mer") MerchantDefinition merchantDefinition,
                                                           @Param("size") Integer size,
                                                           @Param("offset") Integer offset);

    /**
     * 查询记录总数
     * @param merchantDefinition
     * @return
     */
    public Long getMerchantDifinitionsTotal(@Param("mer") MerchantDefinition merchantDefinition);
}
