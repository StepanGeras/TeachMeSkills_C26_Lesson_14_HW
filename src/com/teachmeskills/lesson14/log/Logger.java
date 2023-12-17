package com.teachmeskills.lesson14.log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Logger {

    public static String PATH_EXECUTION_LOG = "/Users/stepan_gerasimovich/Desktop/Task/1/TeachMeSkills_C26_Lesson_14_HW/file/execution_log.txt";
    public static String PATH_ERROR_LOG = "/Users/stepan_gerasimovich/Desktop/Task/1/TeachMeSkills_C26_Lesson_14_HW/file/error_log.txt";

    public static void executionLogger (String message) {
        try {
            Files.write(Paths.get(PATH_EXECUTION_LOG), (message + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {

        }
    }

    public static void errorLogger (String message, Exception errorMessage) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(message + "\n");

            StackTraceElement[] stackTraceElements = errorMessage.getStackTrace();

            for (StackTraceElement element: stackTraceElements) {
                stringBuilder.append(element.toString() + "\n");
            }

            Files.write(Paths.get(PATH_ERROR_LOG), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {

        }
    }

}
