import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scan);

        while(true) {
            printMenu();
            System.out.println();
            int cmd = scan.nextInt();
            switch (cmd) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    stepTracker.changeStepGoal();
                    break;
                case 3:
                    stepTracker.printStatistics();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Введено неврное значение");
                    break;
            }
        }

    }

    static void printMenu() {
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определённый месяц");
        System.out.println("4. Выйти из приложения");
    }
}