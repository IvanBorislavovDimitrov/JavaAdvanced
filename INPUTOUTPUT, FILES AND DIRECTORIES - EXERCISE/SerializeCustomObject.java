package exercises.solutions;

import java.io.*;

public class SerializeCustomObject {

    private static final String FILE_OUTPUT_NAME = "src\\exercises\\Exercises_Resources\\customObject.bin";

    public static void main(String[] args) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_OUTPUT_NAME));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_OUTPUT_NAME))) {

            Bitch pepa = new Bitch("Pepa debelata", 20, 100, 150, "0899131324");

            objectOutputStream.writeObject(pepa);

            Bitch nekva = (Bitch) objectInputStream.readObject();

            System.out.println(nekva);
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Bitch implements Serializable {
    private String name;
    private int age;
    private int height;
    private int weight;
    private String phoneNumber;

    public Bitch() {
    }

    public Bitch(String name, int age, int height, int weight, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("Sexy: %s\nage: %d\nheight: %d\nwidth: %d\nphone number: %s\n",
                this.getName(), this.getAge(), this.getHeight(), this.getWeight(), this.getPhoneNumber());
    }
}
