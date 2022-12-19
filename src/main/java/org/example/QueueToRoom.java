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
        System.out.println(people.size() + " people in queue");
        while (!people.isEmpty()) {
            if(room.tryGetIn(people.peek())) {
                Person p = people.poll();
                assert p != null;
                p.gettingIn(room);
                new Thread(p).start();
                System.out.println(people.size() + " people in queue");
            }
            else {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
