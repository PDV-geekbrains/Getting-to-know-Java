import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class task_05_01 {
    private static HashMap<String, ArrayList<String>> contacts;

    public static void main(String[] args) {
        contacts = new HashMap<String, ArrayList<String>>();
        PopulatePhonebook();
        PrintContacts();
    }

    /** Заполняет телефонную книгу тестовыми значениями. */
    static void PopulatePhonebook() {
        Add("Иванов", "123");
        Add("Петров", "456");
        Add("Сидоров", "100");
        Add("Иванов", "120");
        Add("Петров", "124");
        Add("Иванов", "753");
        Add("Петров", "773");
        Add("Петров", "453");
    }

    /** Добавляет контакт в книгу. */
    static void Add(String name, String number) {
        String contactName = name.toLowerCase();
        if (contacts.containsKey(contactName))
            contacts.get(contactName).add(number);
        else {
            ArrayList<String> phoneNums = new ArrayList<>(1);
            phoneNums.add(number);
            contacts.put(contactName, phoneNums);
        }
    }

    /** Выводит список контактов на консоль. */
    static void PrintContacts() {
        for (Map.Entry<String, ArrayList<String>> c : contacts.entrySet()) {
            System.out.println(c.getKey());
            for (String p : c.getValue()) {
                System.out.println("     " + p);
            }
        }
    }
}

