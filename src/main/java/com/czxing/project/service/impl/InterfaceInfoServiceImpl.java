package com.czxing.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.czxing.project.common.ErrorCode;
import com.czxing.project.constant.CommonConstant;
import com.czxing.project.exception.BusinessException;
import com.czxing.project.exception.ThrowUtils;
import com.czxing.project.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.czxing.project.model.entity.InterfaceInfo;
import com.czxing.project.model.entity.User;
import com.czxing.project.service.InterfaceInfoService;
import com.czxing.project.mapper.InterfaceInfoMapper;
import com.czxing.project.utils.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author zhengxingche
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2023-05-01 00:11:09
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService{

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String url = interfaceInfo.getUrl();
        String name = interfaceInfo.getName();
        String method = interfaceInfo.getMethod();
        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(url, name, method), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (StringUtils.isNotBlank(name) && name.length() > 80) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "标题过长");
        }

    }

    @Override
    public QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        if (interfaceInfoQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        Long id = interfaceInfoQueryRequest.getId();
        Long userId = interfaceInfoQueryRequest.getUserId();
        String name = interfaceInfoQueryRequest.getName();
        String method = interfaceInfoQueryRequest.getMethod();
        String sortField = interfaceInfoQueryRequest.getSortField();
        String sortOrder = interfaceInfoQueryRequest.getSortOrder();
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id != null, "id", id);
        queryWrapper.eq(userId != null, "userId", userId);
        queryWrapper.eq(StringUtils.isNotBlank(name),"name",name);
        queryWrapper.eq(StringUtils.isNotBlank(method),"method",method);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }


}




