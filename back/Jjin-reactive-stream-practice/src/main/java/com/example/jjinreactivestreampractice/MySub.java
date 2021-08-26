package com.example.jjinreactivestreampractice;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {

    private Subscription s;

    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("구독자 : 구독 정보 받았어");
        this.s = s;
        System.out.println("구독자:나 이제 신문 1개씩 줘");
        s.request(12);
    }

    @Override
    public void onNext(Integer t) {
        System.out.println("onNext() :"+ t);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("구독중 에러");
    }

    @Override
    public void onComplete() {
        System.out.println("구독 완료");
    }
}
