package org.example;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Person implements Runnable {
    int sleepTime;
    protected Random rnd;
    public Person(){
        rnd = new Random();
    }
    public int value(){
        return 1;
    }
    protected ReadingRoom room;
    public Person gettingIn(ReadingRoom room){
        this.room = room;
        sleepTime = rnd.nextInt(1000,3000);
        return this;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.getClass().getSimpleName() + " will be in " + sleepTime + " sec.");
            sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            room.getOut(this);
        }
    }
}
