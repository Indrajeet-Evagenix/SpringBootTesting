package com.example.demo12.ThreadingExample;

public class Table {
    public void printTable(int n) {
        for (int i = 1; i < 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
