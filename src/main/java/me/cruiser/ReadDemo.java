package me.cruiser;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("a.bin");
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            Object o = ois.readObject();
            System.out.println(o);
            ois.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
