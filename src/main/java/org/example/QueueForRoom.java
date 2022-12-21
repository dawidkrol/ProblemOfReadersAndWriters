package org.example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue for room
 */
public class QueueForRoom implements Runnable{
    Queue<Person> people = new LinkedList<>();
    ReadingRoom room;
    public QueueForRoom(ReadingRoom room){
        this.room = room;
    }

    /**
     * Adding person to queue
     * @param p Person model
     */
    public void add(Person p){
        people.add(p);
    }

    /**
     * A method that creates an asynchronous queue and, when there is enough space, brings the person into the room.
     */
    @Override
    public void run() {
        System.out.println(people.size() + " people in queue");
        while (!people.isEmpty()) {
            if(room.tryGetIn(people.peek())) {
                Person p = people.poll();
                assert p != null;
                p.gettingIn(room);
                new Thread(p).start();
                System.out.println(people.size() + " people in queue");
            }
        }
    }
}
