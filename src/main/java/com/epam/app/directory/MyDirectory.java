package com.epam.app.directory;

import com.epam.app.constant.Const;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyDirectory {
    private static Logger logger = LogManager.getLogger(MyDirectory.class);

    public static void main(String[] args) {
        Path f = Paths.get(Const.pathToDirectory);
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(f)) {
            for (Path child : dirStream) {
                logger.info(child.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
