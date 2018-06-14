package com.synertone.chainresponsibility;

/**
 * ���������Զ��塰�����ˡ�
 *
 * @author lzy
 *
 */
public class CustomInterceptor implements Ratify {

    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("CustomInterceptor=>" + request.toString());
        String reason = request.reason();
        if (reason != null && reason.equals("�¼�")) {
            Request newRequest = new Request.Builder().newRequest(request)
                    .setCustomInfo(request.name() + "������¼٣����Һ��ż������쵼����һ��")
                    .build();
            System.out.println("CustomInterceptor=>ת������");
            return chain.proceed(newRequest);
        }
        return new Result(true, "ͬ�����");
    }

}
