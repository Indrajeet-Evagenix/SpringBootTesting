package com.example.demo12.ThreadingExample;

public class MultiThread1 extends Thread {

    public void run() {

        for (int i = 1; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Thread is Running");
    }

}
