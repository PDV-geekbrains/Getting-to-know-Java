import java.util.Scanner;

/** Поиск таких цифр, чтобы соблюдалось равенство
 *  Q + W = E, где Q, W, E - целые числа >= 0, а пользователь
 *  мог вводить  Q и W в формате например 2? или ?5.*/
public class extraTask_01_01 {
    static String Q, W = "";
    static int E = 0;

    public static void main(String[] args) {
        DataInput();
        FindDigits();
    }
    /** Ввод данных. */ 
    static void DataInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввод значений переменных для уравнения Q + W = E, где\n" +
                            "Е - натуральное число,\n" +
                            "Q - комбинация из одного символа '?' и одной цифры,\n" +
                            "W - то же, что и Q.\n");
        System.out.print("Введите E: ");
        E = scanner.nextInt();
        System.out.print("Введите Q: ");
        Q = scanner.next();
        System.out.print("Введите W: ");
        W = scanner.next();
        scanner.close();
    }
    /** Подбор значений Q и W. */
    static void FindDigits() {
        StringBuilder stringQ = new StringBuilder(Q);
        StringBuilder stringW = new StringBuilder(W);
        int indexQ = stringQ.indexOf("?");
        int indexW = stringW.indexOf("?");

        int currentQ = 0;
        int currentW = 0;
        boolean isFound = false;
        for (int i = 0; i < 10; i++) {
            currentQ = Integer.parseInt(stringQ.replace(indexQ, indexQ + 1, Integer.toString(i)).toString());
            for (int j = 0; j < 10; j++) {
                currentW = Integer.parseInt(stringW.replace(indexW, indexW + 1, Integer.toString(j)).toString());
                if (currentQ + currentW == E) {
                    isFound = true;
                }
                if (isFound)
                    break;
            }
            if (isFound)
                break;
        }
        PrintResult(currentQ, currentW, isFound);
    }
    /** Вывод результата. */
    static void PrintResult(int q, int w, boolean isFound) {
        if(isFound)
            System.out.printf("Q = %d, W = %d", q, w);
        else
            System.out.println("Решение не найдено :(");
    }
}
