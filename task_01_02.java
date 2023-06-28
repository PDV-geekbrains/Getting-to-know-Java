import java.util.Scanner;

public class task_01_02 {
    public static void main(String[] args) {
        // Вычисление факториала.
        Factorial();
    }

    /** Вычисление факториала числа. */
    public static void Factorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите целое число: ");
        int N = scanner.nextInt();
        scanner.close();
        
        int sum = 1;
        for (int i = 0; i < N; i++) {
            sum *= i + 1;
        }
        System.out.println(sum);
    }
}
