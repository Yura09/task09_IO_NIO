package com.epam.app.serialization;

import com.epam.app.constant.Const;
import com.epam.app.serialization.sport.Human;
import com.epam.app.serialization.sport.Sportsmen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Human> list = Arrays.asList(new Human("Yura", 18),
                new Sportsmen("Misha", 20, "Box", 8),
                new Sportsmen("Kolya", 19, "footballer", 11));
        writeObject(list);
        logger.info(readObject());
    }

    private static void writeObject(List<Human> list) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(Const.pathToFile))) {
            for (Human human : list) {
                outputStream.writeObject(human);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private static List<Human> readObject() {

        List<Human> list = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(Const.pathToFile);
             ObjectInputStream ois = new ObjectInputStream(file)) {

            boolean isExist = true;
            while (isExist) {
                if (file.available() != 0) {
                    Human obj = (Human) ois.readObject();
                    list.add(obj);
                } else {
                    isExist = false;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
