import java.util.ArrayList;

public class task_01_03 {
    public static void main(String[] args) {
        // Вывод простых чисел от 1 до 1000.
        PrimeNumbers();
    }

        /** Вывод простых чисел от 1 до 1000. */
    public static void PrimeNumbers() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        for (int i = 2; i <= 1000; i++) {
            if (IsValid(i)) {
                numbers.add(i);
            }
        }
        
        System.out.println(numbers);
    }

    static boolean IsValid(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
