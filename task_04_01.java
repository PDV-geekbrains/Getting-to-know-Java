import java.util.LinkedList;

public class task_04_01 {
    public static void main(String[] args) {
        LinkedList<Integer> list = GetLinkedList();
        System.out.println("Initial list: " + list);

        list = ReverseList(list);
        System.out.println("Reverse list: " + list);
    }

    /** Возвращает двусвязный список. */
    static LinkedList<Integer> GetLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }

    /** Возвращает список элементов выстроенных
     *  в обратном порядке.
     */
    static LinkedList<Integer> ReverseList(LinkedList<Integer> list) {
        int length = list.size();
        for (int i = 0; i < length; i++) {
            list.addLast(list.get(length - 1 - i));
            list.remove(length - 1 - i);
        }
        return list;
    }
}
