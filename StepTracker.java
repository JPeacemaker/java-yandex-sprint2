import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Scanner scan;
    Converter converter = new Converter();

    StepTracker(Scanner scanner) {
        scan = scanner;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.print("Введите номер месяца: ");
        int month = scan.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Введено неверное значение месяца!!!");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scan.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Введено неверное значение дня!!!");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scan.nextInt();
        if (steps <= 0) {
            System.out.println("Количество шагов не может быть меньше или равно нуля.");
            return;
        }

        int monthIndex = month - 1;
        int dayIndex = day - 1;

        monthToData[monthIndex].days[dayIndex] = steps;

    }

    public void printStatistics() {
        System.out.println("Введите номер месяца (1-12): ");
        int month = scan.nextInt() ;
        if (month < 1 || month > 12) {
            System.out.println("Неверное значение");
            return;
        }
        MonthData currentMonthData = monthToData[month-1];

        System.out.println("Шаги по дням: ");
        currentMonthData.printDaysAndStepsFromMonth();

        int totalSteps = currentMonthData.maxSteps();
        System.out.println("Самое большое количество шагов за месяц: " + totalSteps);

        int averageSteps = currentMonthData.sumStepsFromMonth() / 30;
        System.out.println("Среднее количество шагов за месяц: " + averageSteps);

        double distanceKm = converter.convertToKm(totalSteps);
        System.out.println("Пройденная дистанция в км: " + distanceKm);

        int kilocalories = converter.convertToKilocalories(totalSteps);
        System.out.println("Количество сожженных калорий: " + kilocalories);

        int bestSeries = currentMonthData.bestSeries(goalByStepsPerDay);
        System.out.println("Лучшая серия: " + bestSeries + " дня");

        int sumStepsForMonth = currentMonthData.sumStepsFromMonth();
        System.out.println("Сумма шагов за месяц: " + sumStepsForMonth);
    }

    public void changeStepGoal() {
        System.out.println("Введите цель по шагам на день: ");
        int steps = scan.nextInt();
        if (steps <= 0) {
            System.out.println("Количество шагов не может быть меньше или равно нуля.");
            return;
        }
        goalByStepsPerDay = steps;
        System.out.println("Теперь цель: " + steps + " шагов.");
    }
}
