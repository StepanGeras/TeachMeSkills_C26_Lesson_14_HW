package com.teachmeskills.lesson14.check;

import com.teachmeskills.lesson14.log.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationCheck {

    public static boolean doValidationCheckDocNumber (String numberDocument) {

        Logger.executionLogger("Start validation check docnum");

        boolean count = false;

        Pattern pattern = Pattern.compile("^docnum([0-9a-zA-Z]{0,15})$");
        Matcher matcher = pattern.matcher(numberDocument);

        if (matcher.find()) {
            count = true;
        }

        Logger.executionLogger("End validation check docnum");

        return count;

    }

    public static boolean doValidationCheckContractNumber (String numberDocument) {

        Logger.executionLogger("Start validation check contract");

        boolean count = false;

        Pattern pattern = Pattern.compile("^contract([0-9a-zA-Z]{0,15})$");
        Matcher matcher = pattern.matcher(numberDocument);

        if (matcher.find()) {
            count = true;
        }

        Logger.executionLogger("End validation check contract");

        return count;

    }

}
