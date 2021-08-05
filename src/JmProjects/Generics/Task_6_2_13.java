package JmProjects.Generics;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*Реализуйте метод, вычисляющий симметрическую разность двух множеств.
Метод должен возвращать результат в виде нового множества. Изменять
переданные в него множества не допускается.
Пример
Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.*/
public class Task_6_2_13 {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> c = new HashSet<>(set1);     // создаем копию
        c.addAll(set2);                     // в нее копируем второе множество и удаляются дубликаты
        Set<T> temp = new HashSet<>(set1);  // копируем первое мнжество
        temp.retainAll(set2);               // удаляем из temp элементы set2
        c.removeAll(temp);                  //
        return c;
    }

    public static void main(String[] args) {

        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);

        HashSet<Integer> s2 = new HashSet<>();
        s2.add(0);
        s2.add(1);
        s2.add(2);

        Set<Integer> result = symmetricDifference(s1, s2);
        System.out.println(result);
    }
}
