package exercises.solutions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {

    private static final String FILE_OUTPUT_NAME = "src\\exercises\\Exercises_Resources\\serializeArrayList.bin";

    public static void main(String[] args) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_OUTPUT_NAME));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_OUTPUT_NAME))) {
            List<String> someNames =  new ArrayList<>();
            someNames.add("Petko");
            someNames.add("Mardata");
            someNames.add("Mozakat");
            someNames.add("Dedeto");

            objectOutputStream.writeObject(someNames);

            List<String> sameNames = (List<String>) objectInputStream.readObject();
            System.out.println(sameNames);
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
