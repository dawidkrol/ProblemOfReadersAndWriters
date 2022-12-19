package org.example;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Person implements Runnable {
    public int value(){
        return 1;
    }
    private ReadingRoom room;
    public Person gettingIn(ReadingRoom room){
        this.room = room;
        return this;
    }
    @Override
    public void run() {
        try {
            int sleepTime = new Random().nextInt(1000,3000);
            System.out.println(this.getClass().getSimpleName() + " will be in " + sleepTime + " sec.");
            sleep(sleepTime);
        } catch (InterruptedException e) {
        } finally {
            room.getOut(this);
        }
    }
}
