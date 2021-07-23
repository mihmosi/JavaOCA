package Zaur.Lesson27;

/**
 * Создайте статический класс Car, чтобы объекты этого типа можно было
 * использовать в try-with-resources.
 * <p>
 * Метод close() должен выводить на экран фразу "Машина закрывается...".
 * <p>
 * Try должен ловить все непроверяемые исключения и игнорировать их.
 * <p>
 * В методе main в блоке try вызови метод drive(). Метод drive должен выводить
 * на экран сообщение "Машина поехала."
 * <p>
 * Требования:
 * 1. Решение должно содержать статический класс Car.
 * 2. Решение должно содержать метод main.
 * 3. В решение должен использоваться try с ресурсами.
 */
public class Test12 {
    public static class Car implements AutoCloseable {
        public void close() {
            System.out.println("Машина закрывается...");
        }

        public static void drive() {
            System.out.println("Машина поехала.");
        }

        public static void main(String... args) {
            try (Car car = new Car()) {
                Car.drive();
            } catch (RuntimeException e) {
            }
        }
    }
}
