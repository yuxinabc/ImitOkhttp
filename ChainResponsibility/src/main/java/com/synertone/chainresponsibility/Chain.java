package com.synertone.chainresponsibility;

public interface Chain {
    // 获取当前request
    Request request();
    // 转发request
    Result proceed(Request request);
}
