package org.example;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Person implements Runnable {
    Random random;
    public int value(){
        return 1;
    }
    private ReadingRoom room;
    public Person gettingIn(ReadingRoom room){
        this.room = room;
        random = new Random();
        return this;
    }
    @Override
    public void run() {
        try {
            int sleepTime = random.nextInt(3000);
            System.out.println(this.getClass().getSimpleName() + " will be in " + sleepTime + " sec.");
            sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            room.getOut(this);
        }
    }
}
