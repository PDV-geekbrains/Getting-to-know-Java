import java.util.ArrayList;
import java.util.Scanner;

public class task_01 {
    public static void main(String[] args) {
        // Вычисление суммы N чисел.
        //Sum();

        // Вычисление факториала.
        //Factorial();

        // Вывод простых чисел от 1 до 1000.
        //PrimeNumbers();

        // Простой калькулятор.
        Calculator();

        // Восстановить выражение до верного равенства.
        //FindDigits();
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

    /** Вычисление факториала числа. */
    public static void Factorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите целое число: ");
        int N = scanner.nextInt();
        int sum = 1;
        for (int i = 0; i < N; i++) {
            sum *= i + 1;
            System.out.println(sum);
        }
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
    
    /** Простой калькулятор. */
    public static void Calculator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие:\n" +
                "А + В: 1\nА - В: 2\nА * В: 3\nА / В: 4");
        int operation = scanner.nextInt();

        System.out.printf("Введите А: ");
        int A = scanner.nextInt();
        System.out.printf("Введите В: ");
        int B = scanner.nextInt();

        scanner.close();

        switch (operation) {
            case 1:
                System.out.println(A + B);
                break;
            case 2:
                System.out.println(A - B);
                break;
            case 3:
                System.out.println(A * B);
                break;
            case 4:
                if (B == 0) {
                    System.out.println("Делить на ноль нельзя!");
                    break;
                }
                System.out.println(A / B);
        }
    }
    
    /** Поиск таких цифр, чтобы соблюдалось равенство
     *  Q + W = E, где Q, W, E - целыечисла >= 0, а пользователь
     *  мог вводить  Q и W в формате например 2? или ?5.*/
    public static void FindDigits() {
        
    }
}
