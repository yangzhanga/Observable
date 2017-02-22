package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现了被观察者接口
 * 被观察者与观察者 一对多关系
 * 被观察者单例模式   懒汉模式 线程不安全,需要  同步 双检索 保证线程安全
 * Created by zhangyang on 17/2/22.
 */

public  class MyObservable implements Observable {

    private List<ObserverListener> mObserverListeners;
    private static MyObservable mMyObservable;

    private MyObservable() {
        mObserverListeners = new ArrayList<>();
    }

    public static MyObservable getInstance() {
        if (mMyObservable == null) {
            synchronized (MyObservable.class) {
                if (mMyObservable == null) {//双检索  保证线程安全
                    mMyObservable = new MyObservable();
                }
            }
        }
        return mMyObservable;
    }

    @Override
    public void register(ObserverListener mObserverListener) {
        if (mObserverListener == null)
            return;
        synchronized (this) {
            if (!mObserverListeners.contains(mObserverListener)) {
                mObserverListeners.add(mObserverListener);
            }
        }

    }

    @Override
    public void remove(ObserverListener mObserverListener) {
        if (mObserverListeners.contains(mObserverListener))
            mObserverListeners.remove(mObserverListener);
    }

    @Override
    public void notifyObserverListener(String notifyMessage) {
        for (ObserverListener listener : mObserverListeners) {
            listener.receive(notifyMessage);
        }
    }
}
