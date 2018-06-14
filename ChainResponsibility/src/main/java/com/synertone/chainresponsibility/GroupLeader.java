package com.synertone.chainresponsibility;

/**
 * �鳤
 *
 * @author lzy
 *
 */
public class GroupLeader implements Ratify {

    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("GroupLeader=====>request:" + request.toString());

        if (request.days() > 1) {
            // ��װ�µ�Request����
            Request newRequest = new Request.Builder().newRequest(request)
                    .setGroupLeaderInfo(request.name() + "ƽʱ���ֲ�������������ĿҲ��æ")
                    .build();
            return chain.proceed(newRequest);
        }

        return new Result(true, "GroupLeader����ȥ���");
    }
}






