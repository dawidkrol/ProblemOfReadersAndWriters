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
            int sleepTime = new Random().nextInt(3000);
            System.out.println("In for " + sleepTime + "s");
            sleep(sleepTime);
        } catch (InterruptedException e) {
        } finally {
            room.getOut(this);
        }
    }
}
