import java.util.*;

/*Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 СДЕЛАЛ ФИЛИППОВ ИГОРЬ ГРУППА 3730*/
public class task1 {
    public static LinkedList<String> list() {
        LinkedList<String> myList = new LinkedList<>();

        return myList;
    }

    public static void main(String[] args) {
        Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();

        while (true) {
            System.out.println("Введите имя абонента:");
            String name = myScan();
            if (name.equals("exit")) return;
            System.out.println("Введите номер абонента:");
            String phone = myScan();
            if (!map.containsKey(name)) {
                map.put(name, new LinkedList<>());
                map.get(name).add(phone);
            } else {
                map.get(name).add(phone);
            }

            System.out.println(map);
            System.out.println("Чтобы выйти введите exit:");
        }
    }


    public static String myScan() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}

