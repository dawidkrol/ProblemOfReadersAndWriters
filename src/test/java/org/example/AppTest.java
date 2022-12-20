package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void creatingPeople() {
        assertEquals(3+2, App.creatingPeople(3,2).size());
    }
}