
public class task_02_01 {
    public static void main(String[] args) {
        StringBuilder jsonString = new StringBuilder("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");
        StringBuilder request = new StringBuilder("SELECT * FROM students WHERE ");

        // Удаление всех кавычек.
        while (jsonString.indexOf("\"") != -1) {
            int pos = jsonString.indexOf("\"");
            jsonString.deleteCharAt(pos);
        }
        // Удаление фигурных скобок.
        jsonString.deleteCharAt(0);
        jsonString.deleteCharAt(jsonString.length() - 1);

        // Удаление всех пробелов.
        while (jsonString.indexOf(" ") != -1) {
            int pos = jsonString.indexOf(" ");
            jsonString.deleteCharAt(pos);
        }

        // Замена всех ":" на "=".
        while (jsonString.indexOf(":") != -1) {
            int pos = jsonString.indexOf(":");
            jsonString.replace(pos, pos + 1, "=");
        }

        String str = jsonString.toString();
        String[] arguments = str.split(",");
        
        for (int i = 0; i < arguments.length; i++) {
            if (arguments[i].indexOf("null") == -1) {
                request.append(" \'");
                request.append(arguments[i]);
                request.append("\' and");
            }
            // Удаление " and" в конце строки.
            else {
                int len = request.length();
                request.replace(len - 4, len, "");
            }
        }

        System.out.println(request.toString());
    }
}
