public class MonthData {
    int[] days = new int[30];

    public MonthData() {
        for (int i = 0; i < 30; i++) {
            days[i] = 0;
        }
    }

    public void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println("День " + (i + 1) + ". " + days[i]);
        }
    }

    public int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++)
            sumSteps += days[i];
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = days[0];
        for (int i = 0; i < days.length; i++)
            if(days[i] > maxSteps)
                maxSteps = days[i];
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int bestSeries = 0;
        int currentSeries = 0;

        for (int step : days) {
            if (step > goalByStepsPerDay) {
                currentSeries++;
                if (currentSeries > bestSeries) {
                    bestSeries = currentSeries;
                } else {
                    currentSeries = 0;
                }
            }
        }
        return bestSeries;
    }
}
 