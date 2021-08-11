package JmProjects.StreamAPI;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*собираешь стрим в коллекцию сортируешь правилом компаратора прилетающего в метод,
берешь первый, последний элементы как мин и макс, если в коллекции нет элементов
возвращаешь нул в консьюмере
Запустить стрим, отсортировать, собрать в коллекцию. Проверить, не пусто ли в коллекции.
 В минМаксКонсьюмер добавить первый и последний элемент коллекции

 Изучите как использовать Comparator co sream'ом и как обернуть stream в list.
  Все! Задача будет решена!

 Напишите метод, находящий в стриме минимальный и максимальный элементы
в соответствии порядком, заданным Comparator'ом.
Найденные минимальный и максимальный элементы передайте в minMaxConsumer
следующим образом:
minMaxConsumer.accept(min, max);
Если стрим не содержит элементов, то вызовите:

minMaxConsumer.accept(null, null);
Требования:
1. Должен быть метод public <T> void findMinMax(Stream<? extends T> stream,
 Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer)
2. Метод должен находить минимум и максимум в потоке, с помощью order.
3. Полученные данные должны быть записаны minMaxConsumer, согласно условию*/
public class Task_7_2_11 {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer)
    {
//       stream.filter((a,b)-> a == stream.min(order), b == stream.max(order).);
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2", "3", "1", "-78", "678");
        findMinMax(stream, String::compareTo, (a, b) -> System.out.println(a + " " + b));
    }

}
