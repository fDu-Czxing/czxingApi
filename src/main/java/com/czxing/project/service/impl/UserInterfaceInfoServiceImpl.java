package com.czxing.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.czxing.project.model.entity.UserInterfaceInfo;
import com.czxing.project.service.UserInterfaceInfoService;
import com.czxing.project.mapper.UserInterfaceInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author zhengxingche
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2023-05-01 00:09:35
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{

}




