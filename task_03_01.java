
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task_03_01 {
    public static void main(String[] args) {
        int listLength = GetListLength();

        if (listLength != -1) {
            ArrayList<Integer> listOfInts = GetList(listLength);
            System.out.println(listOfInts);

            ArrayList<Integer> oddNumberList = GetListOfOddNumbers(listOfInts);
            int minValue = GetMinValue(listOfInts);
            int maxValue = GetMaxValue(listOfInts);
            float meanValue = GetMean(listOfInts);
            PrintResult(oddNumberList, minValue, maxValue, meanValue); 
        } else {
            System.out.println("Введите число больше 0.");
        }
        
    }
    /** Получает длину списка. */
    static int GetListLength() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину списка: ");
        int listLength = scanner.nextInt();
        scanner.close();

        // Проверка корректности ввода длины масива.
        if (listLength > 0) {
            return listLength;
        } else {
            return -1;
        }
    }

    /** Возвращает список случайных целых чисел. */
    static ArrayList<Integer> GetList(int length) {
        ArrayList<Integer> listOfInt = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            listOfInt.add(i, random.nextInt(-10, 10));
        }
        return listOfInt;
    }
    
    /** Возвращает список, удалив все четные чисела. */
    static ArrayList<Integer> GetListOfOddNumbers(ArrayList<Integer> inputList) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i) % 2 != 0)
                newList.add(inputList.get(i));
        }
        return newList;
    }
    
    /** Возвращает минимальное число из списка. */
    static int GetMinValue(ArrayList<Integer> inputList) {
        int minValue = inputList.get(0);
        for (int i = 1; i < inputList.size(); i++) {
            if (inputList.get(i) < minValue)
                minValue = inputList.get(i);
        }
        return minValue;
    }
    
    /** Возвращает минимальное число из списка. */
    static int GetMaxValue(ArrayList<Integer> inputList) {
        int maxValue = inputList.get(0);
        for (int i = 1; i < inputList.size(); i++) {
            if (inputList.get(i) > maxValue)
                maxValue = inputList.get(i);
        }
        return maxValue;
    }
    
    /** Возвращает среднее списка целых чисел. */
    static float GetMean(ArrayList<Integer> inputList) {
        int sum = 0;
        for (int i = 0; i < inputList.size(); i++) {
            sum += inputList.get(i);
        }
        return (float) sum / inputList.size();
    }
    
    /** Выводит результат на консоль. */
    static void PrintResult( ArrayList<Integer> oddNumberList, 
                             int minValue, 
                             int maxValue, 
                             float meanValue) {
        System.out.println(oddNumberList);
        System.out.printf("minValue = %d\nmaxValue = %d\n" +
            "meanValue = %.1f", minValue, maxValue, meanValue);
    }
}