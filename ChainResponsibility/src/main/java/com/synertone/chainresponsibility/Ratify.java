package com.synertone.chainresponsibility;

/**
 * 接口描述：处理请求
 *
 * @author lzy
 *
 */
public interface Ratify {
    // 处理请求
   Result deal(Chain chain);
}

