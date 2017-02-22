package observer;

/**
 *
 * 被观察者接口定义
 *
 * 被观察者，也可以被叫做主题（Subject）是被观察的对象。通常有注册方法（register），取消注册方法(remove)和通知方法(notify)。
 *
 * Created by zhangyang on 17/2/22.
 */
public interface Observable {
    void  register(ObserverListener mObserverListener);
    void  remove(ObserverListener mObserverListener);
    void  notifyObserverListener(String notifyMessage);
}
