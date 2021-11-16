package com.adaysoft;

public class Producer extends Thread{
    private VegetablePatchMonitor buffer;

    private int produceUnits;
    private int maxTimeForProduce;

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

    public Producer(VegetablePatchMonitor buffer, int produceUnits, int maxTimeForProduce) {
        this.buffer = buffer;
        this.produceUnits = produceUnits;
        this.maxTimeForProduce = maxTimeForProduce;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < produceUnits; i++) {
                int randomNum = (int) (Math.random() * vegetables.length);
                buffer.put(vegetables[randomNum]);
                System.out.println("Produced -> " + vegetables[randomNum]);
                sleep((int) (Math.random() * this.maxTimeForProduce));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
