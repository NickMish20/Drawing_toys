package viewer;

import java.util.Scanner;

public class UI {

    Scanner console = new Scanner(System.in);

    public static final void menu() {
        System.out.println("1. Посмотреть список всех возможных призов.");
        System.out.println("2. Начать розыгрыш.");
        System.out.println("3. Выход.");
    }
    public static final String ticket =  "Ваш билет номер: ";

    public static final String greetings = "Добро пожаловать в раффл!\n Никто не уйдет без выигрыша!";

    public String registrations() {
        System.out.println("Введите ваше имя\nДля выхода введите \"Стоп\": ");
        return console.nextLine();
    }

    public String addToy() {
        System.out.print("Введите наименование игрушки\nДля выхода введите \"Стоп\": ");
        return console.nextLine();
    }

    public int select() {
        return console.nextInt();
    }
}
