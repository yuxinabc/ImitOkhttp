package com.synertone.chainresponsibility;

/**
 * ����
 *
 * @author lzy
 *
 */
public class Manager implements Ratify {

    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("Manager=====>request:" + request.toString());
        if (request.days() > 3) {
            // �����µ�Request
            Request newRequest = new Request.Builder().newRequest(request)
                    .setManagerInfo(request.name() + "ÿ�µ�KPI���˻�����������׼")
                    .build();
            return chain.proceed(newRequest);

        }
        return new Result(true, "Manager������������꣬��Ŀ�벻����");
    }

}