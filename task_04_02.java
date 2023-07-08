import java.util.LinkedList;

public class task_04_02 {
    public static void main(String[] args) {
        LinkedList<String> queue = GetList();
        System.out.println("Initial queue: " + queue);

        queue = Enqueue(queue, "десять");
        System.out.println("Enqueue() --> " + queue);

        MyType t = Dequeue(queue);
        System.out.println("Dequeue() --> " + t.getItem());
        System.out.println("Dequeue() -->" + t.getList());
        queue = t.getList();

        t = First(queue);
        System.out.println("First() --> " + t.getItem());
        System.out.println("First() --> " + t.getList());
    }

    /** Возвращает типовой список. */
    static LinkedList<String> GetList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("раз");
        list.add("два");
        list.add("три");
        list.add("четыре");
        list.add("пять");
        return list;
    }

    /** Помещает элемент в конец очереди. */
    public static LinkedList<String> Enqueue(LinkedList<String> list, String item) {
        list.add(item);
        return list;
    }

    /** Возвращает первый элемент из очереди и удаляет его. */
    public static MyType Dequeue(LinkedList<String> list) {
        MyType t = new MyType();
        t.setItem(list.getFirst());
        list.removeFirst();
        t.setList(list);
        return t;
    }
    
    /** Возвращает первый элемент из очереди, не удаляя его.*/
    public static MyType First(LinkedList<String> list) {
        MyType t = new MyType();
        t.setItem(list.getFirst());
        t.setList(list);
        return t;
    }
}

class MyType {
        private LinkedList<String> _list;
        private String _item;

        public LinkedList<String> getList() {
            return _list;
        }

        public void setList(LinkedList<String> value) {
            _list = value;
        }

        public String getItem() {
            return _item;
        }

        public void setItem(String value) {
            _item = value;
        }
    }
