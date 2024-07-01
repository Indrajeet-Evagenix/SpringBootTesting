package com.example.demo12.ThreadingExample;

public class TableThread1 extends Thread {
    Table tt;

    public void run() {
        tt.printTable(2);
    }

    public TableThread1(Table t1) {
        tt = t1;
    }
}
