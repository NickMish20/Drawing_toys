package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
 * @apiNote Класс представляющий собой имитацию, розыгрыша игрушек.
 */

public class ToyMachine implements ToyMachineInterface {

    private int id;

    private ParticipantQueue participantQueue;

    private List<Toy> toys;

    private Random random;

    /**
     * @param participantQueue - очередь из участников.
     * @apiNote Конструктор класса
     */

    public ToyMachine(ParticipantQueue participantQueue) {
        this.participantQueue = participantQueue;
        random = new Random();
        toys = new ArrayList<>();
    }


    /**
     * @param name наименование игрушки;
     * @apiNote Метод добавления игрушки в раффл.
     */
    @Override
    public void put(String name) {
        int weight = random.nextInt(100);
        toys.add(new Toy(++id, name, weight));
    }


    /**
     * @return Возвращаем объект класса - "Игрушка".
     * @apiNote Создаем коллекцию объектов класса Toy, представляющих все доступные игрушки.
     * Генерируем случайное число в диапазоне от 1 до суммы всех весов игрушек.
     * Это число будет использоваться для выбора игрушки.
     * Проходимся по списку игрушек и вычитаем их вес из случайного числа до тех пор,
     * пока оно не станет меньше или равно нулю. Когда это произойдет, выбираем текущую игрушку.
     * Удаляем выбранную игрушку из списка.
     */
    @Override
    public Toy getToy() {
        if (toys.isEmpty()) {
            return null;
        }
        int totalWeight = toys.stream().mapToInt(Toy::getWeight).sum();
        int randomValue = random.nextInt(totalWeight) + 1;
        int cumulativeWeight = 0;
        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomValue <= cumulativeWeight) {
                toys.remove(toy);
                return toy;
            }
        }
        return null;
    }


    /**
     * @apiNote Метод перебора всех элементов коллекции Toy.
     */
    @Override
    public void getAllToys() {
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }

    @Override
    public void write(String name) {
        try (FileWriter fw = new FileWriter("result.txt", true)) {
            fw.write(name);
        } catch (IOException e) {
            System.out.println(e.getMessage());
    }

}

    /**
     * @apiNote Метод имитирующий игру "Испытай удачу".
     * Пока очередь из участников не пуста,
     * проверяем, доступны ли элементы в коллекции.
     * Если да, то разыгрываем игрушку среди участников.
     * Если коллекция пуста, вне зависимости кончилась очередь или нет,
     * Цикл прерывается.
     */
    @Override
    public void letsFun() {
        while (!participantQueue.isEmpty()) {
            Toy toy = getToy();
            if (toy == null) {
                System.out.println("Розыгрыш окончен!");
                break;
            } else {
                String result = "Участник под номером " + participantQueue.getParticipants() +
                        " получает игрушку под номером " + toy.getId() + "(" + toy.getName() + ")";
                write(result +  "\n");
                System.out.println(result);
                participantQueue.removeParticipants();
            }
        }
        if (participantQueue.isEmpty()) System.out.println("Очередь пуста");
    }
}
