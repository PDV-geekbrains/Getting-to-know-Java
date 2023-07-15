import java.util.Scanner;
import java.util.LinkedList;

public class task_06_01 {
    private static LinkedList<Notebook> notebookes;

    public static void main(String[] args) {
        notebookes = getNotebooks();
        int choise = getUserChoise();
        LinkedList<Notebook> foundItems = getRelevant(choise);

        //printAllList();
        printFoundItems(foundItems);
    }

    /** Возвращает список ноутбуков соответствующих критерию.
     * @param choise - код критерия выбора.
     */
    private static LinkedList<Notebook> getRelevant(Integer choice) {
        LinkedList<Notebook> list = null;
        switch (choice) {
            case 1, 2:
                int ram = 0;
                if (choice == 1)
                    ram = 8;
                else if (choice == 2)
                    ram = 16;
                list = getNotbooksByRam(ram);
                break;
            case 3, 4, 5:
                String os = "";
                if (choice == 3)
                    os = "DOS";
                else if (choice == 4)
                    os = "Windows";
                else if (choice == 5)
                    os = "Linux";
                list = getNotbooksByOs(os);
                break;
            case 6, 7:
                String color = "";
                if (choice == 6)
                    color = "Чёрный";
                else if (choice == 7)
                    color = "Красный";
                list = getNotebooksByColor(color);
                break;
            default :
                System.out.println("Введите подходяший номер.");
        }
        return list;
    }

    /**
     * Возвращает список ноутбуков, выбранных по заданному объёму ОЗУ.
     * @param ram - объём ОЗУ.
     * @return - список найденных ноутбуков.
     */
    private static LinkedList<Notebook> getNotbooksByRam(Integer ram) {
        LinkedList<Notebook> list = new LinkedList<>();
        for (Notebook notebook : notebookes) {
            if (notebook.getRamVolume() == ram)
                list.add(notebook);
        }
        return list;
    }

    /**
     * Возвращает список ноутбуков, выбранных по установленной операционной системе.
     * @param os - название установленной операционной системы.
     * @return - список найденных ноутбуков.
     */
    private static LinkedList<Notebook> getNotbooksByOs(String os) {
        LinkedList<Notebook> list = new LinkedList<>();
        for (Notebook notebook : notebookes) {
            if (notebook.getOsName() == os)
                list.add(notebook);
        }
        return list;
    }

    /**
     * Возвращает список ноутбуков, выбранных по цвету корпуса.
     * @param color - цвет корпуса.
     * @return - список найденных ноутбуков.
     */
    private static LinkedList<Notebook> getNotebooksByColor(String color) {
        LinkedList<Notebook> list = new LinkedList<>();
        for (Notebook notebook : notebookes) {
            if (notebook.getColor() == color)
                list.add(notebook);
        }
        return list;
    }
 
    /** Возвращает критерий для поиска. */
    private static Integer getUserChoise() {
        System.out.println("Введите число для выбора ноутбуков по одному из критериев.");
        System.out.println("Выбор по объёму оперативной памяти: 1 - 8Гб, 2 - 16Гб.");
        System.out.println("Выбор по операционной системе: 3 - DOS, 4 - Windows, 5 - Linux.");
        System.out.println("Выбор по цвету корпуса: 6 - Чёрый, 7 - Красный.");
        System.out.print("Ввод: ");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        scanner.close();

        return userChoice;
    }

    /** Возвращает список ноутбуков. */
    private static LinkedList<Notebook> getNotebooks() {
        LinkedList<Notebook> list = new LinkedList<>();
        list.add(new Notebook());
        list.add(new Notebook("Windows"));
        list.add(new Notebook(16, 0, 1000, "Linux", "Красный"));
        return list;
    }

    /** Выводит данные на консоль по всем ноутбукам. */
    private static void printAllList() {
        System.out.println();
        for (Notebook item : notebookes) {
            item.printAll();
            System.out.println();
        }
    }

    /**
     * Выводит данные на консоль по каждому ноутбуку из заданного списка.
     * @param list - список ноутбуков для вывода.
     */
    private static void printFoundItems(LinkedList<Notebook> list) {
        System.out.println();
        for (Notebook item : list) {
            item.printAll();
            System.out.println();
        }
    }
}

/** Класс описывает компьютер - ноутбук. */
class Notebook {
    /** Объём оперативной памяти в гигабайтах. */
    private Integer ramVolume;

    /** Объём памяти на жёстком диске в гигабайтах. */
    private Integer hddVolume;

    /** Объём памяти на твёрдотельном накопителе в гигабайтах. */
    private Integer ssdVolume;

    /** Название предустановленной операционной системы. */
    private String osName;

    /** Цвет корпуса ноутбука. */
    private String color;
    
    /** 
     * Конструктор.
     * Типовая конфигурация ноутбука.
     */
    public Notebook() {
        this.ramVolume = 8;
        this.hddVolume = 500;
        this.ssdVolume = 0;
        this.osName = "DOS";
        this.color = "Чёрный";
    }
    
    /** 
     * Конструктор.
     * Типовая конфигурация ноутбука с возможностью
     * изменить операционную систему.
     * @param osName - название операционной системы.
     */
    public Notebook(String osName) {
        this();
        this.osName = osName;
    }

    /**
     * Конструктор.
     * Произвольная конфигурация ноутбука.
     * @param ramVolume - объём оперативной памяти в гигабайтах.
     * @param hddVolume - объём памяти на жёстком диске в гигабайтах.
     * @param sddVolume - объём памяти на твёрдотельном накопителе в гигабайтах.
     * @param osName - название предустановленной операционной системы.
     * @param color - цвет корпуса ноутбука.
     */
    public Notebook(
            Integer ramVolume,
            Integer hddVolume,
            Integer sddVolume,
            String osName,
            String color) {
        this.ramVolume = ramVolume;
        this.hddVolume = hddVolume;
        this.ssdVolume = sddVolume;
        this.osName = osName;
        this.color = color;
    }
    
    /**
     * Функция получения значения поля {@link Notebook#ramVolume}
     * @return возвращает объём оперативной памяти в гигабайтах.
     */
    public Integer getRamVolume() {
        return this.ramVolume;
    }
     /**
      * Функция получения значения поля {@link Notebook#hddVolume}
      * @return возвращает объём памяти на жёстком диске в гигабайтах.
      */
     public Integer getHddVolume() {
         return this.hddVolume;
     }
    
    /**
     * Функция получения значения поля {@link Notebook#ssdVolume}
     * @return возвращает объём памяти на твёрдотельном накопителе в гигабайтах.
     */
    public Integer getSsdVolume() {
        return this.ssdVolume;
    }

    /**
     * Функция получения значения поля {@link Notebook#osName}
     * @return возвращает название предустановленной операционной системы.
     */
    public String getOsName() {
        return this.osName;
    }

    /**
     * Функция получения значения поля {@link Notebook#color}
     * @return возвращает цвет корпуса ноутбука.
     */
    public String getColor() {
        return this.color;
    }

    /** Выводит на консоль значение всех полей класса. */
    public void printAll() {
        System.out.println("ОЗУ: " + ramVolume);

        if(hddVolume == 0)
            System.out.println("Жёсткий диск: " + "нет");
        else
            System.out.println("Жёсткий диск: " + hddVolume);
        
        if(ssdVolume == 0)
            System.out.println("Твёрдотельный диск: " + "нет");
        else
            System.out.println("Твёрдотельный диск: " + ssdVolume);
        
        System.out.println("Операционная система: " + osName);
        System.out.println("Цвет корпуса: " + color);
    }
}
