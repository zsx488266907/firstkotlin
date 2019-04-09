package com.wd.tech.mypushs.net;

import com.blankj.utilcode.util.SPUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AppInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();

        builder.addHeader("userId", SPUtils.getInstance().getString("userId"));
        builder.addHeader("sessionId", SPUtils.getInstance().getString("sessionId"));


        Request build = builder.build();
        Response proceed = chain.proceed(build);
        return proceed;
    }


}
