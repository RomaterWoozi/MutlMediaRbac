package com.wuzx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuzx.login.model.entity.Resource;

import java.util.Set;

public interface ResourceService extends IService<Resource> {
    Set<Long> getIdsByUserId(Long id);
}
