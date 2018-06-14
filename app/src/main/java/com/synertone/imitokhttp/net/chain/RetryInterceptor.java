package com.synertone.imitokhttp.net.chain;

import android.util.Log;

import com.synertone.imitokhttp.net.Call;
import com.synertone.imitokhttp.net.HttpClient;
import com.synertone.imitokhttp.net.Response;

import java.io.IOException;

/**
 * Created by Administrator on 2018/4/27.
 */

public class RetryInterceptor implements Interceptor {

    @Override
    public Response intercept(InterceptorChain chain) throws IOException {
        Log.e("拦截器", "重试拦截器.....");
        IOException exception = null;
        Call call = chain.call;
        HttpClient client = call.client();
        for (int i = 0; i < client.retrys()+1; i++) {
            //如果取消了
            if (call.isCanceled()) {
                throw new IOException("Canceled");
            }
            try {
                //执行链条中下一个拦截器
                Response response = chain.process();
                return response;
            }catch (IOException e){
                exception = e;
            }
        }
        throw  exception;
    }
}
