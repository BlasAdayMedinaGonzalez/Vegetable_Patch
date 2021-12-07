package com.adaysoft;

public class Producer extends Thread{
    private VegetablePatchMonitor buffer;

    private int produceUnits;
    private int maxTimeForGrow;

    private static String vegetables [] = {
            "lettuce",
            "cabbage",
            "onion",
            "spinach",
            "potato",
            "celery",
            "asparagus",
            "radish",
            "broccoli",
            "artichoke",
            "tomato",
            "cucumber",
            "eggplant",
            "carrot",
            "green bean"
    };

    public Producer(VegetablePatchMonitor buffer, int produceUnits) {
        this.buffer = buffer;
        this.produceUnits = produceUnits;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < produceUnits; i++) {
                int randomNum = (int) (Math.random() * vegetables.length);
                maxTimeForGrow = (int) (1000 + (Math.random() * 10000));
                sleep((int) (Math.random() * maxTimeForGrow));
                buffer.put(vegetables[randomNum]);
                System.out.println("Produced -> " + vegetables[randomNum]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
