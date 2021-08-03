package JmProjects.Generics;

import java.util.Arrays;

/*    Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение.
   Создайте класс DynamicArray, который хранит в себе массив, и имеет методы для
 добавления void add(T el), void remove(int index) удаления и извлечения
  T get(int index) из него элементов, при переполнении текущего массива,
   должен создаваться новый, большего размера.
    Для возможности работы с различными классами DynamicArray должен быть дженериком.
Для решения задачи можно воспользоваться методами из класса java.util.Arrays.
 Импорт этого класса уже объявлен в тестирующей системе. Добавлять его явно не нужно */
public class Task_6_1_13 {
    public static class DynamicArray<T> {
        int size = 0;
        T[] arr = (T[]) new Object[size]; // который хранит в себе массив


        // методы для добавления el в массив
        public void add(T el) {
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[size++] = el;
        }

        // методы для удаления
        public void remove(int removedIdx) {
            System.arraycopy(arr, removedIdx + 1, arr, removedIdx, (arr.length - 1) - removedIdx);
        }

        // методы для извлечения
        public T get(int index) {
            return arr[index];
        }
    }


    public static void main(String[] args) {
        DynamicArray array = new DynamicArray<>();
        int count = 0;
        while (count < 20) {
            System.out.println();
            array.add("One");
            array.remove(1);
            System.out.println(array.get(count));
            System.out.println();
            count++;
        }

//        public class DynamicArray<T> {
//            //You realization here
//
//            public int size() {
//                return size;
//            }
//
//            public int length() {
//                return arr.length;
//            }
//        }
//
//        Ещё:
//        arr[size++] = el;
    }
}
