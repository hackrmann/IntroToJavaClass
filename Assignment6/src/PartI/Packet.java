package PartI;

import java.util.*;

public class Packet implements Comparable {

    Byte[] payload;
    int priority;

    public Packet(Byte[] payload, int priority) {
        // figure out how this works
        this.payload = payload;
        this.priority = priority;
    }

    @Override
    public int compareTo(Object o) {
        Packet packet = (Packet) o;
        return this.priority - packet.priority;
    }

    public String toString() {
        return "Priority: " + this.priority + ", Payload: " + Arrays.toString(this.payload) ;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        for (int i = 0; i < 10; i++) {
            Byte[] payload = new Byte[256];
            int priority = (int) (Math.random() * 5 + 1);
            Packet p = new Packet(payload, priority);
            pq.add(p);
        }

        while (!pq.isEmpty()) {
            System.out.println("got packet " + pq.remove());
        }
    }

}
