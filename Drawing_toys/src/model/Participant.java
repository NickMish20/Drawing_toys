package model;

/**
 * @apiNote
 * Класс представляющий собой участника розыгрыша.
 */
public class Participant implements Comparable<Participant> {

    private int ticket;

    private String name;

    public Participant(int id, String name) {
        this.name = name;
        this.ticket = id;
    }

    public int getTicket() {
        return ticket;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Участник " + name + " с билетом номер " + ticket;
    }

    @Override
    public int compareTo(Participant o) {
        return this.ticket - o.getTicket();
    }
}
