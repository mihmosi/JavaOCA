package MyExperiments;

// страница 511
public class Gen<T> {
    T ob; //объявить объект типа Т

    // Предать конструктору ссылку на объект
    Gen(T o) {
        ob = o;
    }

    // Вернуть объект из метода
    T getOb() {
        return ob;
    }

    // Отобразить тип Т
    void showType() {
        System.out.println("Тип Т - это " + ob.getClass().getName());
    }
}

class GenDemo {
    public static void main(String[] args) {
        /* Создать обобшенную ссылку на цклочисленное
         * значение*/
        Gen<Integer> iOb;
        /* Создать объект типа Gen<Integer> и привоить ссылку
         * на него переменной iOb
         * обратить внимание на автоупаковку  при инкупсуляции
         * значения 88 в объекте типа Integer */
        iOb = new Gen<Integer>(88);
        /*Отобразить тип ланных, используемых в объекте */
        iOb.showType();
        int v = iOb.getOb();

        System.out.println("значение: " + v);
        System.out.println();
        // создать оъъект типа Gen для строк
        Gen<String> strObj = new Gen<>("Тестирвание обобшений");
        /* Отобразить тип ланных, используемых в объекте */
        iOb.showType();
        /* Получить значение из объекта  приведение типа
         * не требуется */
        String str = strObj.getOb();
        System.out.println("значение: " + str);
    }
}
