package functional;

import java.util.List;

public class FP01_Structured {
    public static void main(String[] args) {
        printAllNumbersInListStructured(List.of(12, 13, 4, 53, 2, 6));
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        // **How** to Loop Numbers
        for(Integer number: numbers) {
            System.out.println(number);
        }
    }
}
