package com.synertone.chainresponsibility;

/**
 * �����쵼
 *
 * @author lzy
 *
 */
public class DepartmentHeader implements Ratify {

    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("DepartmentHeader=====>request:"
                + request.toString());
        if (request.days() > 7) {
            return new Result(false, "�������ȫû��Ҫ");
        }
        return new Result(true, "DepartmentHeader����Ҫ�ż��������鴦�����ٻ�����");
    }

}
