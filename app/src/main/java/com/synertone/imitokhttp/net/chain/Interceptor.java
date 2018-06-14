package com.synertone.imitokhttp.net.chain;


import com.synertone.imitokhttp.net.Response;

import java.io.IOException;

/**
 * @author Lance
 * @date 2018/4/17
 */

public interface Interceptor {

    Response intercept(InterceptorChain chain) throws IOException;
}
