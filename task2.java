import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*СДЕЛАЛ ФИЛИППОВ ИГОРЬ ГРУППА 3730
Пусть дан список сотрудников:
        Иван Иванов
        Светлана Петрова
        Кристина Белова
        Анна Мусина
        Анна Крутова
        Иван Юрин
        Петр Лыков
        Павел Чернов
        Петр Чернышов
        Мария Федорова
        Марина Светлова
        Мария Савина
        Мария Рыкова
        Марина Лугова
        Анна Владимирова
        Иван Мечников
        Петр Петин
        Иван Ежов
        Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.*/
public class task2 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = map(bigDate());
        myPrint(map);
    }


    public static LinkedList<String> bigDate() {
        LinkedList<String> list = new LinkedList<String>();
        String name;
        try {
            Scanner scanner = new Scanner(new File("names.txt"));

            while (scanner.hasNextLine()) {
                name = scanner.nextLine().trim();
                ArrayList<String> value = new ArrayList<>(List.of(name.split(" ")));
                list.add(value.get(0));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static HashMap<String, Integer> map(LinkedList<String> myList) {
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();
        String value;
        int count;
        for (int i = 0; i < myList.size(); i++) {
            value = myList.get(i);
            if (myMap.containsKey(value)) {
                myMap.put(value, myMap.get(value) + 1);
            } else {
                myMap.put(value, 1);
            }
        }
        return myMap;
    }

    public static void myPrint(HashMap<String, Integer> map) {
        int max;
        int count = 0;
        LinkedList<String> name = new LinkedList<String>(map.keySet());
        LinkedList<Integer> number = new LinkedList<Integer>(map.values());
        System.out.println(name + " " + number);
        for (int i = 0; i < number.size(); i++) {
            max = number.get(i);
            count = number.get(i);
            for (int j = 0; j < number.size(); j++) {
                if (max < number.get(j)) {
                    max = number.get(j);
                    count = j;
                }
            }
            System.out.println(name.get(count) + "=" + number.get(count));
            name.remove(count);
            number.remove(count);
        }
        for (int i = 0; i < name.size(); i++) {
            System.out.println(name.get(i) + "=" + number.get(i));
        }
    }
}


