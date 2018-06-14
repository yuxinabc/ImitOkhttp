package com.synertone.chainresponsibility;

/**
 * ��������������ģʽ������
 *
 * @author lzy
 *
 */
public class Main {
    public static void main(String[] args) {
        Request request = new Request.Builder().setName("����").setDays(5)
                .setReason("�¼�").build();
        ChainOfResponsibilityClient client = new ChainOfResponsibilityClient();
        client.addRatifys(new CustomInterceptor());
        Result result = client.execute(request);

        System.out.println("�����" + result.toString());
    }
}
