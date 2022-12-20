package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

import static org.junit.jupiter.api.Assertions.*;

class ReadingRoomTest {
    ReadingRoom rr;
    @BeforeEach
    void beforeEach(){
        Semaphore sm = new Semaphore(3);
        rr = new ReadingRoom(sm);
    }
    @Test
    void tryGetIn() {
        assertTrue(rr.tryGetIn(new Person()));
        assertTrue(rr.tryGetIn(new Person()));
        assertTrue(rr.tryGetIn(new Person()));
        assertFalse(rr.tryGetIn(new Person()));
    }

    @Test
    void availableSlots() {
        assertEquals(3,rr.availableSlots());
        rr.tryGetIn(new Person());
        assertEquals(2,rr.availableSlots());
    }

    @Test
    void getOut() {
        Person p = new Person();
        assertEquals(3,rr.availableSlots());
        rr.tryGetIn(p);
        assertEquals(2,rr.availableSlots());
        rr.getOut(p);
        assertEquals(3,rr.availableSlots());
    }
}