package com.teachmeskills.lesson14.check;

import com.teachmeskills.lesson14.log.Logger;

import java.io.File;
import java.util.Scanner;

public class CheckPathInputFile {

    public static String pathInputFile () {

        Logger.executionLogger("Check path to input file");

        Scanner scanner = new Scanner(System.in);

        String pathFileNumberDocument = "";

        boolean path = true;

        while (path) {
            System.out.println("Enter the path to input file");

            String pathFile = scanner.nextLine();

            File file = new File(pathFile);

            if (file.exists()) {
                pathFileNumberDocument = pathFileNumberDocument + pathFile;
                path = false;
            }

        }

        return pathFileNumberDocument;

    }

}
