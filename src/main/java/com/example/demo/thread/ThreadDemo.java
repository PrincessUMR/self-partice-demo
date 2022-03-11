package com.example.demo.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ThreadDemo implements Runnable{

    static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            new Thread( new ThreadDemo(String.valueOf(i))).start();
        }
    }

    private String id;

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        //do sth
        lock.unlock();
    }


}
