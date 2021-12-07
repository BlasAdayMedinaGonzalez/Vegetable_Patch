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
        Producer producer = new Producer(vegetablePatchMonitor, produceUnits);
        System.out.println("Number max of vegetables consumed? ");
        int consumedUnits = sc.nextInt();
        Consumer consumer = new Consumer(vegetablePatchMonitor, consumedUnits, 4000);

        producer.start();
        consumer.start();
    }
}
