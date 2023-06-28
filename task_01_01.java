import java.util.Scanner;

public class task_01_01 {
    public static void main(String[] args) {
        // Вычисление суммы N чисел.
        Sum();
    }

    /** Сложение целых чисел от 1 до N. */
    public static void Sum() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Введите целое число N: ");
        int N = scanner.nextInt();
        int sum = 1;
        for (int i = 1; i < N; i++) {
            sum += i + 1;
        }
        System.out.printf("-> %d", sum);
        scanner.close();
    }
}
