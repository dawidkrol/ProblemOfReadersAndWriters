package org.example;

import java.util.concurrent.Semaphore;
import java.lang.Thread;

import static java.lang.Thread.sleep;

public class ReadingRoom {
    private final Semaphore semaphore;
    public ReadingRoom(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public synchronized boolean tryGetIn(Person p){
        return semaphore.tryAcquire(p.value());
    }

    public synchronized void getOut(Person p){
        semaphore.release(p.value());
        System.out.println(p.getClass().getSimpleName() + " is getting out, avaliable places: " + availableSlots());
        this.notify();
    }

    public synchronized int availableSlots(){
        return semaphore.availablePermits();
    }
}
