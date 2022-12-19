package org.example;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueToRoom implements Runnable{
    Queue<Person> people = new LinkedList<Person>();
    ReadingRoom room;
    public QueueToRoom(ReadingRoom room){
        this.room = room;
    }
    public void add(Person p){
        people.add(p);
    }
    @Override
    public void run() {
        while (!people.isEmpty()) {
            if(room.tryGetIn(people.peek())) {
                Person p = people.poll();
                p.gettingIn(room);
                new Thread(p).start();
            }
        }
    }
}
