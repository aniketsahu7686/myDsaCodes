package com.example.strings;

import java.util.concurrent.Semaphore;

public class ReadersWritersProblem {
    Semaphore mutex = new Semaphore(1);
    Semaphore rw_mutex = new Semaphore(1);
    int readers_count = 0;
    int data = 0;

    class Reader implements Runnable{
        public void run(){
            try {
                // Acquire read lock
                mutex.acquire();
                readers_count++;
                if (readers_count ==1){
                    //Acquire write lock
                    rw_mutex.acquire();
                }
                mutex.release();

                //Read data
                System.out.println("Reader " + Thread.currentThread().getId() + "reads data" + data);

                //release read lock
                mutex.acquire();
                readers_count--;
                if (readers_count==0){
                    rw_mutex.release();
                }
                mutex.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    class Writer implements Runnable{
        public void run(){
            try {
                rw_mutex.acquire();

                data++;
                System.out.println("Writer " + Thread.currentThread().getId() + "writes data" + data );

                rw_mutex.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ReadersWritersProblem rwp = new ReadersWritersProblem();
        for (int i=0;i<5;i++){
            Thread reader = new Thread(rwp.new Reader());
            reader.start();
        }

        for (int i=0;i<2;i++){
            Thread writer = new Thread(rwp.new Writer());
            writer.start();
        }
    }
}
