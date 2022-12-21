package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    ReadingRoom rr;
    Person ps;
    @BeforeEach
    void beforeEach(){
        Semaphore sm = new Semaphore(3);
        rr = new ReadingRoom(sm);
        ps = new Reader();
    }
    @Test
    void value() {
        assertEquals(1, ps.value());
    }

    @Test
    void gettingIn() {
        ps.gettingIn(rr);
        assertNotEquals(0, ps.sleepTime);
    }
}