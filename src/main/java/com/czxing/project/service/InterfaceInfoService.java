package com.czxing.project.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.czxing.project.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.czxing.project.model.entity.InterfaceInfo;

/**
* @author zhengxingche
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-05-01 00:11:09
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest);
}
