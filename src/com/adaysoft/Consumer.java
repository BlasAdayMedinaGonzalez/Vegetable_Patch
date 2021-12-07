package com.adaysoft;

public class Consumer extends Thread{
    private VegetablePatchMonitor buffer;
    private int consumedUnits;
    private int maxTimeForConsume;

    public Consumer(VegetablePatchMonitor buffer, int consumedUnits, int maxTimeForConsume) {
        this.buffer = buffer;
        this.consumedUnits = consumedUnits;
        this.maxTimeForConsume = maxTimeForConsume;
    }

    @Override
    public void run() {
        String vegetable;
        try {
            for (int i = 0; i < consumedUnits; i++) {
                sleep(maxTimeForConsume);
                vegetable = buffer.get();
                System.out.println("Consumed -> " + vegetable);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
