package RxJava2;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * @author wangzz
 * @date 2020年04月16日 16:04
 */

public class HelloRxjava2 {

    public static void main(String[] args) {

        // 被观察者 主动推消息
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                // 产生事件
                emitter.onNext("hello");
                emitter.onNext("www.coco-z.com");
                emitter.onNext("let's study!");
            }
        });

        // 观察者
        Consumer<String> consumer = new Consumer<String>() {
            // 当事件传给我的时候我做出什么的响应
            @Override
            public void accept(String s) {
                System.out.println(Thread.currentThread().getName() + "== consumer ==" + s);
            }
        };

        // 同步
        observable.subscribe(consumer);
        // 异步
        observable.observeOn(Schedulers.newThread()).subscribe(consumer);

        // 订阅者 Subscriber就是复杂版本的Consumer
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println(Thread.currentThread().getName() + "== observer ==" + o);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
        observable.observeOn(Schedulers.newThread()).subscribe(observer);

    }

}
