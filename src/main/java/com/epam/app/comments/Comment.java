package com.epam.app.comments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Comment {
    private static Logger logger = LogManager.getLogger(Comment.class);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        logger.info("enter path to file");
        logger.info(findCommentsInFile(bufferRead.readLine()).toString());
    }

    private static StringBuilder findCommentsInFile(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder anotherString = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(s)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("//")) {
                    stringBuilder.append(line.substring(line.indexOf("//")).trim()).append('\n');
                }
                anotherString.append(line);
            }
            while (anotherString.toString().contains("/*") && anotherString.toString().contains("*/") && !anotherString.toString().startsWith("//")) {
                stringBuilder.append(anotherString.substring(anotherString.toString().indexOf("/*"), anotherString.toString().indexOf("*/") + 2)).append('\n');
                anotherString.delete(anotherString.toString().indexOf("/*"), anotherString.toString().indexOf("*/") + 2);
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return stringBuilder;
    }

}


