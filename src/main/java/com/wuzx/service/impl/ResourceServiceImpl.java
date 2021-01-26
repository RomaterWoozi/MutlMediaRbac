package com.wuzx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuzx.login.model.entity.Resource;
import com.wuzx.login.mapper.ResourceMapper;
import com.wuzx.service.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {
    @Override
    public Set<Long> getIdsByUserId(Long id) {
        return baseMapper.selectIdsByUserId(id);
    }
}
