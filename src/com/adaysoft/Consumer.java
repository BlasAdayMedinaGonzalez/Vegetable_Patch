package com.adaysoft;

public class Consumer extends Thread{
    private VegetablePatchMonitor buffer;
    private int expectedUnits;
    private int maxTimeForConsume;

    public Consumer(VegetablePatchMonitor buffer, int expectedUnits, int maxTimeForConsume) {
        this.buffer = buffer;
        this.expectedUnits = expectedUnits;
        this.maxTimeForConsume = maxTimeForConsume;
    }

    @Override
    public void run() {
        String vegetable;
        try {
            for (int i = 0; i < expectedUnits; i++) {
                vegetable = buffer.get();
                System.out.println("Consumed -> " + vegetable);
                sleep((int) (Math.random() * maxTimeForConsume));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
