package Zaur.Lesson27.Lambda;

import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.function.Consumer;

public class Test_3 {
    // в методе создали реализацию метода создания ArrayList -а
    public static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier) {
        ArrayList<Car> a1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            a1.add(carSupplier.get()); // с помощью метода get() сапплаера создаем три авто в Аррей лист
        }
        return a1;
    }
// применение метода Consumer для Car - связываем объект и Consumer
    public static void changeCar(Car car, Consumer<Car> carConsumer) {
        carConsumer.accept(car);
    }

    public static void main(String[] args) {
        //метод будет вызываться и возвращать все в аррей лист
        ArrayList<Car> ourCars = createThreeCars(() ->
                new Car("NissaTilda", "Silver Metallic", 1.6));
        System.out.println("Our cars: " + ourCars);
// вызов с реализацией метода accept() Cunsumer определяек какие изменения
        changeCar(ourCars.get(0)
                , car -> {
                    car.color = "red";
                    car.engine = 2.4;
                    System.out.println("upgraded car: " + car);
                });
        System.out.println("Our cars: " + ourCars);
    }

}

class Car {
    String model;
    String color;
    double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("model='").append(model).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", engine=").append(engine);
        sb.append('}');
        return sb.toString();
    }
}