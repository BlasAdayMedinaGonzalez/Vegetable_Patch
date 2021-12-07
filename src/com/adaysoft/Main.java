package com.adaysoft;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Capacity max of the Vegetable patch? ");
        int capacity = sc.nextInt();
        VegetablePatchMonitor vegetablePatchMonitor = new VegetablePatchMonitor(capacity);
        System.out.println("Number max of vegetables produced? ");
        int produceUnits = sc.nextInt();
        System.out.println("Number max of vegetables consumed? ");
        int consumedUnits = sc.nextInt();


        System.out.println("How many people for produce?");
        int countofProducers = sc.nextInt();
        System.out.println("How many people for consume?");
        int countofConsumers = sc.nextInt();

        for (int i = 0; i < countofProducers; i++) {
            Producer producer = new Producer(i, vegetablePatchMonitor, produceUnits);
            producer.start();
        }

        for (int i = 0; i < countofConsumers; i++) {
            Consumer consumer = new Consumer(i,vegetablePatchMonitor, consumedUnits, 4000);
            consumer.start();
        }

    }
}
