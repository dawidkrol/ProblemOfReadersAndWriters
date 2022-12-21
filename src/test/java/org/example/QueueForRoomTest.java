package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

import static org.junit.jupiter.api.Assertions.*;

class QueueForRoomTest {

    QueueForRoom qtr;

    @BeforeEach
    void beforeEach(){
        Semaphore sm = new Semaphore(2);
        ReadingRoom rr = new ReadingRoom(sm);
        qtr = new QueueForRoom(rr);
    }

    @Test
    void add() {
        assertEquals(0, qtr.people.size());
        qtr.add(new Reader());
        assertEquals(1, qtr.people.size());
    }
}