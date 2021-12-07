package com.adaysoft;

public class Consumer extends Thread{
    private VegetablePatchMonitor buffer;
    private int consumedUnits;
    private int maxTimeForConsume;
    private int idConsumer;

    public Consumer(int idConsumer,VegetablePatchMonitor buffer, int consumedUnits, int maxTimeForConsume) {
        this.idConsumer = idConsumer;
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
                System.out.println(idConsumer + ": Consumed -> " + vegetable);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
