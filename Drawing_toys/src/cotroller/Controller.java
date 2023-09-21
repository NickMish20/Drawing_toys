package cotroller;

import model.ParticipantQueue;
import model.ToyMachine;
import viewer.UI;


/**
 * @apiNote Класс Контроллер, реализующий модель MVC
 */
public class Controller {

    private ParticipantQueue participantQueue;

    private ToyMachine toyMachine;

    private UI userInterface;

    public Controller() {
        this.participantQueue = new ParticipantQueue();
        this.toyMachine = new ToyMachine(participantQueue);
        this.userInterface = new UI();
    }


    /**
     * Метод старта программы
     */
    public void letsGo() {

        while (true) {
            String toy = userInterface.addToy();
            if (toy.equalsIgnoreCase("стоп")) break;
            else toyMachine.put(toy);
        }
        registration();
    }

    /**
     * Метод регистрации участников
     */
    public void registration() {
        while (true) {
            String participant = userInterface.registrations();
            if (participant.equalsIgnoreCase("стоп")) break;
            else {
                participantQueue.addParticipant(participant);
                System.out.println(UI.ticket + participantQueue.getParticipants());
            }
        }
        letsFun();
    }

    /**
     * Метод розыгрыша
     */
    public void letsFun() {
        while (true) {
            UI.menu();
            int select = userInterface.select();
            if (select==1){
                toyMachine.getAllToys(); return;
            }
            else if (select==2){
                toyMachine.letsFun();
                return;
            }
            else if (select==3){
                return;
            }
            // switch (select) {
            //     case 1 -> toyMachine.getAllToys(); return;
            //     case 2 -> {
            //         toyMachine.letsFun();
            //         return;
            //     }
            //     case 3 -> {
            //         return;
            //     }
            // }
        }
    }
}