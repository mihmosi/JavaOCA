package JmProjects;

import JmProjects.Serialization_Alishev.Person;

import java.awt.print.PrinterIOException;
import java.io.*;
import java.util.Arrays;

public class Task_5_4_7 {
    public static class Animal implements Serializable {
        public Animal(String name) {
            this.name = name;
        }

        String name;
    }

    public static void main(String[] args) {
        byte[] intermediate = null;
        byte[] data = {-84, -19, 0, 5, 119, 4, 0, 0, 0, 1, 115, 114, 0, 12, 84, 97, 115, 107,  55, 36, 65, 110, 105, 109, 97, 108, 115, -72, 25, -96, 54, 17, -60, 35,  2, 0, 1, 76, 0, 4, 110, 97, 109, 101, 116, 0, 18, 76, 106, 97, 118, 97,  47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 120, 112,  116, 0, 3, 67, 97, 116};
        try (
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(output)) {

            oos.writeInt(3);
            oos.writeObject(new Animal("Dog"));
            oos.writeObject(new Animal("Cat"));
            oos.writeObject(new Animal("Mouse"));

            output.flush();
            intermediate = output.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(intermediate));
        Animal[] animals = deserializeAnimalArray(data);
        System.out.println(Arrays.toString(animals));

    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animal = null;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int size = ois.readInt();
            animal = new Animal[size];

            for (int i = 0; i < size; i++) {
                animal[i] = (Animal) ois.readObject();
            }

        } catch (ObjectStreamException | EOFException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animal;
    }

}
