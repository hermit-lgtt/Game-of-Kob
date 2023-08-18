package org.kob.botrunningsystem.service.impl.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BotPool extends Thread{
    private final static ReentrantLock lock = new ReentrantLock();//这里加不加static都没关系，因为是单例模式，只有一个在运行
    private  final Condition condition = lock.newCondition();
    private final Queue<Bot> bots = new LinkedList<>();


    public void addBot(Integer userId,String botCode,String input){
        lock.lock();
        try{
            bots.add(new Bot(userId,botCode,input));
            condition.signalAll();//signal也可以,效果一样


        }finally {
            lock.unlock();
        }
    }

    private void consume(Bot bot){
        Consumer consumer = new Consumer();
        consumer.startTimeOut(2000,bot);
    }

    @Override
    public void run(){
        while(true){
            lock.lock();
            if(bots.isEmpty()){
                try {
                    condition.await();//await()里面会默认包含一个锁默认的操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    lock.unlock();
                    break;
                }
            }else{
                Bot bot = bots.remove();
                lock.unlock();//这个锁要提前于consume释放,不用占着
                consume(bot);//这个函数比较耗时间,会执行几秒钟,因为要编译执行一段代码

            }
        }
    }

}
