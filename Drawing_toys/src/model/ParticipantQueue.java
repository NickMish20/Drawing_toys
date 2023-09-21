package model;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @apiNote
 * Класс представляющий собой очередь из участников.
 * Каждому участнику случайным образом разыгрывается билет.
 */
public class ParticipantQueue  {

    private int ticket;

    private Random random;
    private PriorityQueue<Participant> participants;

    public ParticipantQueue() {
        participants = new PriorityQueue<>();
        random = new Random();
    }

    public void addParticipant(String name) {
        participants.add(new Participant(random.nextInt(100), name));
    }

    public boolean isEmpty() {
        return participants.isEmpty();
    }

    public int getParticipants() {
        return participants.peek() != null ? participants.peek().getTicket() : 0;
    }

    public void removeParticipants() {
        participants.poll();
    }
}
