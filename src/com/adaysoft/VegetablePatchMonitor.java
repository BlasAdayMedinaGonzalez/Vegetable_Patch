package com.adaysoft;

public class VegetablePatchMonitor {
    private String buffer[] = null;
    private int space = 0;

    private boolean full = false;
    private boolean empty = true;

    public VegetablePatchMonitor(int capacity) {
        this.buffer = new String[capacity];
    }

    public synchronized void put(String vegetable) throws InterruptedException {
        while (full) {
            wait();
        }
        System.out.println("Planting in space : " + space);
        buffer[space++] = vegetable;
        empty = false;
        full = space >= buffer.length;
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while (empty) {
            wait();
        }
        String vegetable = buffer[--space];
        System.out.println("Getting valor in space : " + space);
        full = false;
        empty = space <=0;
        return vegetable;
    }
}
