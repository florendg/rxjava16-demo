package com.weirdduke.rxjava16;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Random;
import java.util.concurrent.Executors;

public class DemoJava16Scheduler {

    public static void main(String[] args) throws InterruptedException{
        Thread.sleep(5000);
        Observable.just("A", "AB", "ABC","ANKKFLOROR","JFJjfifooe")
                .flatMap(v -> getLengthWithDelayString(v))
                .doOnNext(s-> System.out.println("Processing Thread " + Thread.currentThread().getName()))
                .subscribeOn(Schedulers.from(Executors.newVirtualThreadExecutor()))
                .subscribe(length->System.out.println("Receiver Thread "
                + Thread.currentThread().getName()
                + ", Item length " + length));
        Thread.sleep((10000));
    }

    protected static Observable<Integer> getLengthWithDelayString(String v) {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(3) * 1000);
            return Observable.just(v.length());
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return null;
    }
}
