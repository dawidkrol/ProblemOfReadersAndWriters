package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.Semaphore;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueToRoomTest {
    QueueToRoom qtr;
    @BeforeEach
    void BeforeEach(){
        Semaphore semaphore = new Semaphore(2);
        ReadingRoom room = new ReadingRoom(semaphore);
        qtr = new QueueToRoom(room);
    }

    @Test
    void testAdd() {
        assertEquals(0, qtr.people.size());
        qtr.add(new Person());
        assertEquals(1, qtr.people.size());
    }
}