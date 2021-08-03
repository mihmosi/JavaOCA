package JmProjects.Generics;

import java.util.Objects;
import java.util.Optional;

/*   Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару
элементов разных типов и не запрещающий элементам принимать значение null.
     Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также
 статический фабричный метод of(). Конструктор должен быть закрытым (private).*/
public class Task_6_1_12 {
    //Реализуй этот класс
    public static class Pair<T, V> {

        private T first;
        private V second;

        public static <T, V> Pair<T, V> of(T value1, V value2) {
            return new Pair<>(value1, value2);
        }

        private Pair(T first, V second) {
            this.first = first;
            this. second = second;
        }


        public T getFirst() {

            return first;
        }

        public V getSecond() {

            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
    }
}
