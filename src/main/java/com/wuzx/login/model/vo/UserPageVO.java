package com.wuzx.login.model.vo;

import lombok.Data;

import java.util.Set;

@Data
public class UserPageVO {
    private Long id;
    private String username;
    private Set<Long> roleIds;
    private Set<Long> companyIds;
}
