package com.qyc.jupiter.test.threadtest;

import org.junit.Test;

//@Slf4j
public class ThreadTest  {

    @Test
    public void test1(){
       Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("主线程运行:{} 运行中" + Thread.currentThread().getName());
                   Thread t1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("子线程:{} 运行中" + Thread.currentThread().getName());
                        }
                    },"tchild");
                   t1.start();
            }
        },"tfather");
        t.start();
    }


    /**
     * Thread.sleep是获取当前线程sleep
     * Thread.currentThread.sleep 同理
     * jdk11后已经没有了第二种方式，1.8会提示异常
     * @throws InterruptedException
     */
    @Test
    public void test2() throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("主线程运行:{} 运行中" + Thread.currentThread().getName());

            Thread t1 = new Thread(() ->{
                    System.out.println("子线程:{} 运行中" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(10000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                System.out.println("子线程:{} 运行结束" + Thread.currentThread().getName());
            },"tchild");
            t1.start();

            while (true){
                System.out.println("主线程运行:{} 运行中" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"tfather");
        t.start();
        Thread.sleep(11000l);
    }

}
