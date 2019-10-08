package com.epam.app.comparing;

import com.epam.app.constant.Const;
import com.epam.app.serialization.Main;
import com.epam.app.serialization.sport.Human;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;

public class Example {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            logger.info("usual reader time: " + getUsualReaderTime());
            logger.info("buffered reader time: " + getBufferedReaderTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getBufferedReaderTime() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(Const.pathToBigFile));
        long start = System.currentTimeMillis();
        int data = bufferedInputStream.read();
        while (data != -1) {
            data = bufferedInputStream.read();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long getUsualReaderTime() throws IOException {
        InputStream inputStream = new FileInputStream(Const.pathToBigFile);
        long start = System.currentTimeMillis();
        int data = inputStream.read();
        while (data != -1) {
            data = inputStream.read();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static void writeObject(List<Human> list) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("human.txt"))) {
            for (Human human : list) {
                outputStream.writeObject(human);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
