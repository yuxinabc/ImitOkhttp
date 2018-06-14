package com.synertone.imitokhttp.net.chain;


import com.synertone.imitokhttp.net.Call;
import com.synertone.imitokhttp.net.HttpConnection;
import com.synertone.imitokhttp.net.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/4/27.
 */

public class InterceptorChain {


    List<Interceptor> interceptors;
    int index;
    Call call;
    HttpConnection connection;

    public InterceptorChain(List<Interceptor> interceptors, int index, Call call, HttpConnection connection) {
        this.interceptors = interceptors;
        this.index = index;
        this.call = call;
        this.connection = connection;
    }

    public Response process(HttpConnection connection) throws IOException {
        this.connection = connection;
        return process();
    }


    public Response process() throws IOException {
        if (index >= interceptors.size()) throw new IOException("Interceptor Chain Error");
        //获得拦截器 去执行
        Interceptor interceptor = interceptors.get(index);
        InterceptorChain next = new InterceptorChain(interceptors, index + 1, call, connection);
        Response response = interceptor.intercept(next);
        return response;
    }
}
