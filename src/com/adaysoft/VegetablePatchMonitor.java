package com.adaysoft;

public class VegetablePatchMonitor {
    private String buffer[] = null;
    private int space = 0;

    private boolean full = false;
    private boolean empty = true;

    public VegetablePatchMonitor(int capacity) {
        this.buffer = new String[capacity];
    }

    public synchronized void put(String c) throws InterruptedException {
        while (full) {
            wait();
        }
        System.out.println("Adding valor in space : " + space);
        buffer[space] = c;
        space += 1;
        empty = false;
        full = space >= buffer.length;
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while (empty) {
            wait();
        }
        String c = buffer[--space];
        System.out.println("Getting valor in space : " + space);
        full = false;
        empty = space <=0;
        return c;
    }
}
