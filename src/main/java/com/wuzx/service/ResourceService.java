package com.wuzx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuzx.model.entity.Resource;

import java.util.Set;

public interface ResourceService extends IService<Resource> {
    Set<Long> getIdsByUserId(Long id);
}
