package com.adaysoft;

public class Main {

    public static void main(String[] args) {
        VegetablePatchMonitor vegetablePatchMonitor = new VegetablePatchMonitor(9);

        Producer producer = new Producer(vegetablePatchMonitor, 12, 500);
        Consumer consumer = new Consumer(vegetablePatchMonitor, 12, 4000);

        producer.start();
        consumer.start();
    }
}
