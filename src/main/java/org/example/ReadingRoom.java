package org.example;

import java.util.concurrent.Semaphore;

/**
 * The class containing the methods to manage the reading room
 */
public class ReadingRoom {
    private final Semaphore semaphore;
    public ReadingRoom(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    /**
     * Method which is checking if person can enter to the room
     * @param p Person model
     * @return true if person can enter, false in other cases
     */
    public synchronized boolean tryGetIn(Person p){
        return semaphore.tryAcquire(p.value());
    }

    /**
     * Method for exiting person from room
     * @param p Person model
     */
    public synchronized void getOut(Person p){
        semaphore.release(p.value());
        System.out.println(p.getClass().getSimpleName() + " is getting out, avaliable places: " + availableSlots());
        notifyAll();
    }

    /**
     * Checking how many slots are available in room
     * @return Number of slots
     */
    public synchronized int availableSlots(){
        return semaphore.availablePermits();
    }
}
