package com.teachmeskills.lesson14.numberfile;

import com.teachmeskills.lesson14.check.ValidationCheck;
import com.teachmeskills.lesson14.log.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Scanner;

public class ReadingNumberFile {

    public static String PATH_INVALID_NUMBER = "/Users/stepan_gerasimovich/Desktop/Task/1/TeachMeSkills_C26_Lesson_14_HW/file/invalid_number.txt";
    public static String PATH_DOCNUM = "/Users/stepan_gerasimovich/Desktop/Task/1/TeachMeSkills_C26_Lesson_14_HW/file/docnum.txt";
    public static String PATH_CONTRACT = "/Users/stepan_gerasimovich/Desktop/Task/1/TeachMeSkills_C26_Lesson_14_HW/file/contract.txt";

    public static void inputNumberFile() {

        try {
            Scanner scanner = new Scanner(System.in);

            Logger.executionLogger(new Date(),"Enter the path to the file");

            System.out.println("Enter the path to input file");

            String pathFile = scanner.nextLine();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (ValidationCheck.doValidationCheckDocNumber(line)) {
                    Logger.executionLogger(new Date(),"Document number is correct");
                    Files.write(Paths.get(PATH_DOCNUM), (line + "\n").getBytes(), StandardOpenOption.APPEND);
                } else if (ValidationCheck.doValidationCheckContractNumber(line)) {
                    Files.write(Paths.get(PATH_CONTRACT), (line + "\n").getBytes(), StandardOpenOption.APPEND);
                    Logger.executionLogger(new Date(),"Document number is correct");
                } else {
                    Files.write(Paths.get(PATH_INVALID_NUMBER), (line + "\n").getBytes(), StandardOpenOption.APPEND);
                    Logger.executionLogger(new Date(),"Document number does not correct");
                }
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            Logger.errorLogger(new Date(),"Wrong file path", e);
        } catch (IOException e) {
            Logger.errorLogger(new Date(),"Write error", e);
        }

    }
}
