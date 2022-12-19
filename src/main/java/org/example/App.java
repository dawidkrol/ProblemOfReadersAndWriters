package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        Semaphore sm = new Semaphore(5);
        ReadingRoom rr = new ReadingRoom(sm);
        QueueToRoom queue = new QueueToRoom(rr);
        int numOfReaders = 10;
        int numOfWriters = 3;
        for (Person p :creatingPeople(numOfReaders, numOfWriters)) {
            queue.add(p);
        }
        new Thread(queue).start();
    }

    private static List<Person> creatingPeople(int numOfReaders, int numOfWriters) {
        List<Person> people = new ArrayList<Person>();
        for (int i = 0; i < numOfReaders; i++){
            people.add(new Reader());
        }
        for (int i = 0; i < numOfWriters; i++){
            people.add(new Writer());
        }
        Collections.shuffle(people);
        return people;
    }
}
