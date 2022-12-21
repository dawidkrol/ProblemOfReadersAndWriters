package org.example;

import java.security.SecureRandom;

import static java.lang.Thread.sleep;

/**
 * Base class for models which can enter to the reading room
 */
public abstract class Person implements Runnable {
    int sleepTime;
    protected SecureRandom rnd;
    protected Person(){
        rnd = new SecureRandom();
    }

    /**
     * Returning number of places that is needed to add this person to the room
     * @return Number of places
     */
    public int value(){
        return 1;
    }
    protected ReadingRoom room;

    /**
     * Entering to the room
     * @param room Room model that person enters
     */
    public void gettingIn(ReadingRoom room){
        this.room = room;
        sleepTime = rnd.nextInt(1000,3000);
    }

    /**
     * A method that simulates a person in a room, the person is in the room for a while and then leaves.
     */
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
