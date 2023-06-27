import java.util.ArrayList;
import java.util.Scanner;

public class task_04 {
    public static void main(String[] args) {
        // Простой калькулятор.
        Calculator();
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
                System.out.println((double)A / (double)B);
        }
    }
}
