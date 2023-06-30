import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileWriter;

public class task_02_02 {
    public static void main(String[] args) {
        ArrayList<Integer> listToSort = new ArrayList<Integer>(
            Arrays.asList(9, 8, 7, 6, 5));

        ArrayList<String> LogsToSave = BubbleSort(listToSort);
        SaveLogsToFile(LogsToSave);
    }
    
    /** Сортировка пузырьком */
    static ArrayList<String> BubbleSort(ArrayList<Integer> listToSort) {
        ArrayList<String> Logs = new ArrayList<String>();
        int tmp = listToSort.get(0);

        for (int i = listToSort.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (listToSort.get(j) > listToSort.get(j + 1)) {
                    tmp = listToSort.get(j + 1);
                    listToSort.set(j + 1, listToSort.get(j));
                    listToSort.set(j, tmp);
                }
                // Логирование.
                LogOperation(Logs, listToSort.toString());
            }
        }
        return Logs;
    }

    /** Логировать операцию. */
    static void LogOperation(ArrayList<String> Logs, String list) {
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                .format(new Date());

        Logs.add(timeStamp + " " + list);
    }
    /** Сохраныет строки списка в файл. */
    static void SaveLogsToFile(ArrayList<String> Logs) {
        try{
            File output = new File("task_02_02_log.txt");
            FileWriter writer = new FileWriter(output);
            for (String string : Logs) {
                writer.write(string);
                writer.write(System.lineSeparator());
                writer.flush();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
