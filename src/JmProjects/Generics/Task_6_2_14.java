package JmProjects.Generics;

import java.util.*;

/*Напишите программу, которая прочитает из System.in последовательность целых чисел,
 разделенных пробелами, затем удалит из них все числа, стоящие на четных позициях,
 и затем выведет получившуюся последовательность в обратном порядке в System.out.
Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
Все import объявлены за вас.
Пример ввода: 1 2 3 4 5 6 7 8 9 10
Пример вывода: 10 8 6 4 2
Требования:
1. Необходимо наличие метода public static void main(String[] args)
2. Программа должна читать данные из консоли
3. Программа должна выводить текст в консоль

как в задачк 5.3.12  */
public class Task_6_2_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> arDek = new ArrayDeque();
        int count = 0;
        try {
            while (sc.hasNext()) {
                count++;
                if (count % 2 == 0) {
                    arDek.addFirst(sc.nextInt());
                } else {
                    sc.next();
                }
            }
        } catch (NumberFormatException e) {
        }
        Iterator<Integer> it = arDek.iterator();
        while (!arDek.isEmpty()) { // Обрабатываем элементы
            System.out.print(arDek.pop() + " ");
        }

//        while (sc.hasNext()) {
//            arDek.addFirst(sc.nextInt());
//            for (int i = 0; i < arDek.size(); i++) {
//                if (arDek.iterator().hasNext() & i % 2 ==0) {
//                    sb.append(arDek.poll()).append(" ");
//                    arDek.remove(i + 1);
//                    System.out.println(i);
//                }
//            }
//        }
//        System.out.print(sb);
//        while (sc.hasNext()) {
//            arDek.addFirst(sc.nextInt());
//        }
//        Iterator<Integer> it = arDek.descendingIterator();
//        while (it.hasNext()) {
//            count++;
//            if (count % 2 == 0) {
//                it.remove();
//            } else {
//                System.out.print(it.next() + " ");
//            }
//        }
//        for (int i = 0; i <= arDek.size(); i++) {
//            if (i % 2 != 0) {
//                System.out.print(arDek.getFirst());
//            }
//        }
//        List<Integer> list = new ArrayList<>(arDek);
//        for (int i = 0; i < list.size(); i++) {
//
//            if (list.iterator().hasNext()) {
//                sb.append(list.get(i)).append(" ");
//            }
//            list.remove(i + 1);
//        }
//        if (sb.length() > 0) {
//            System.out.println(sb.deleteCharAt(sb.length() - 1));
//        }
    }
}
