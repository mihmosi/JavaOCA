package JmProjects.StreamAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

/*Напишите программу, читающую из System.in текст в кодировке UTF-8,
 подсчитывающую в нем частоту появления слов, и в конце выводящую 10
 наиболее часто встречающихся слов.
   Словом будем считать любую непрерывную последовательность символов,
 состоящую только из букв и цифр. Например, в строке "Мама мыла раму
  33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
    Подсчет слов должен выполняться без учета регистра, т.е. "МАМА",
"мама" и "Мама" — это одно и то же слово. Выводите слова в нижнем регистре.
    Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
    Если в тексте некоторые слова имеют одинаковую частоту, т.е. их
нельзя однозначно упорядочить только по частоте, то дополнительно
 упорядочите слова с одинаковой частотой в лексикографическом порядке.
   Задача имеет красивое решение через стримы без циклов и условных
операторов. Попробуйте придумать его.
1. Считали строку
2. Сделали форматирование: все в нижний регистр, заменить знаки препинания и другие
 на пробел (.map(...)).
3. Сплитом разбить строку по словам(Внимание: после замены возможны случаи многократных пробелов,
 учтите это), получится масив строк  и превратить это в стрим(.flatMap(...))
4. Собрать новый список в виде мапы, где ключ - слово, значение - кол-во его использований
 в с исходной строке(счетчик) (.collect(...))
5. получить стрим из мапы (.entrySet().stream())
6. Отсортировать лексикографически, по ключу, что бы при одинаковых значениях выводилось
 по алфавиту(.sorted(...))
7. Отсортировать с компаратором по значению мапы. Не забудьте перевернуть что бы от большего
к меньшему(.sorted(Comparator(...).reversed()))
8. Получить из мапы стрим ключей и задать лимит на 10 (.map(...).limit(10))
9. Вывести в консоль (.forEach(...))
10. Оберните в try */
public class Task_7_2_12 {
    public static void main(String[] args) throws Exception {

        HashMap<String, Integer> result = new HashMap<>();
        new BufferedReader(new BufferedReader(
                new InputStreamReader(System.in, java.nio.charset.StandardCharsets.UTF_8)))
                .lines()
                .flatMap(l -> Stream.of(l.split("[\\p{Punct}\\s]+")))
                .map(String::toLowerCase)
                .forEach(word -> {
                    if (result.containsKey(word)) result.put(word, result.get(word) + 1);
                    else result.put(word, 1);
                });

        result.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    if (e1.getValue().equals(e2.getValue())) {
                        return e1.getKey().compareTo(e2.getKey());
                    } else {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                })
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));

    }

}
