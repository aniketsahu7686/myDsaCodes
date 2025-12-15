package com.example.strings;

import java.util.concurrent.Semaphore;

public class Q {
    int item;
        static Semaphore semCon = new Semaphore(0);
        static Semaphore semprod = new Semaphore(1);

        //to get an item for buffer
    void get(){
        try {
            semCon.acquire();
        }catch (InterruptedException e){
            System.out.println("InterruptedException caught");
        }

        //consumer consuming an item
        System.out.println("Consumer consumed item : " + item);

        semprod.release();
    }

    // to put an item in buffer
    void put(int item){
        try{
            semprod.acquire();
        }catch (InterruptedException e){
            System.out.println("InterruptedException caught");
        }

        //producer producing an item
        this.item = item;

        System.out.println("Producer produced item :" + item);

        semCon.release();
    }
}

class Producer implements Runnable{
    Q q;
    Producer(Q q){
        this.q = q;
        new Thread(this,"producer").start();
    }
    public void run(){
        for (int i=0;i<5;i++) q.put(i);
    }
}

class Consumer implements Runnable{
    Q q;
    Consumer(Q q){
        this.q = q;
        new Thread(this,"Consumer").start();
    }
    public void run(){
        for (int i=0;i<5;i++) q.get();
    }
}
class PC{
    public static void main(String[] args) {
        Q q = new Q();
        new Consumer(q);
        new Producer(q);
    }
}
