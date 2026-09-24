public class Converter {
    public double convertToKm(int steps){
        return (steps * 0.75) / 1000;
    }

    public int convertToKilocalories(int steps){
        return (steps * 50) / 1000;
    }
}
