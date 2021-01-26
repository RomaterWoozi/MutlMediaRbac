package com.wuzx.security;

/**
* @author WuZX
* 时间  2021/1/26 11:17
*  用户上下文对象
 *  ThreadLocal 线程内部存储类，防止线程冲突
*/
public final class UserContext {

    private static final ThreadLocal<Long> USER=new ThreadLocal<>();

    private UserContext() {
    }

    public static void add(long parseLong) {
        USER.set(parseLong);
    }

    public static void remove(){
        USER.remove();
    }

    public static Long getCurrentUserId(){
        return USER.get();
    }
}
