package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WriterTest {
    Writer wr;
    @BeforeEach
    void beforeEach(){
        wr = new Writer();
    }
    @Test
    void value() {
        assertEquals(5,wr.value());
    }
}