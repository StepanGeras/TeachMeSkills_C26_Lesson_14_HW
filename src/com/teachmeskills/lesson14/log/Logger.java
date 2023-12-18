package com.teachmeskills.lesson14.log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class Logger {

    public static String PATH_EXECUTION_LOG = "/Users/stepan_gerasimovich/Desktop/Task/1/TeachMeSkills_C26_Lesson_14_HW/log/execution_log.txt";
    public static String PATH_ERROR_LOG = "/Users/stepan_gerasimovich/Desktop/Task/1/TeachMeSkills_C26_Lesson_14_HW/log/error_log.txt";

    public static void executionLogger (Date date, String message) {
        try {
            Files.write(Paths.get(PATH_EXECUTION_LOG), (date + " " + message + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ignored) {

        }
    }

    public static void errorLogger (Date date, String message, Exception errorMessage) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(date).append(" ").append(message).append("\n");

            StackTraceElement[] stackTraceElements = errorMessage.getStackTrace();

            for (StackTraceElement element: stackTraceElements) {
                stringBuilder.append(element.toString()).append("\n");
            }

            Files.write(Paths.get(PATH_ERROR_LOG), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);

        } catch (IOException ignored) {

        }
    }

}
