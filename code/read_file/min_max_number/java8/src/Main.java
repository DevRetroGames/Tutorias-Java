import helper.MinMaxCalculator;

public class Main {
    public static void main(String[] args) {
        String filePath = "../../assets/valores.txt";
        new MinMaxCalculator(filePath).print();
    }
}