package com.assignment.reader;

import com.assignment.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TextReader {

    public static String readText() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();

        String currentLine;
        String textString = "";

        System.out.println("Enter some text. Enter '" + Constant.STOP_READING_TEXT + "' to quite.");

        try {
            while ((currentLine = bufferedReader.readLine()) != null && !currentLine.equals(Constant.STOP_READING_TEXT)){
                if (!currentLine.isEmpty()) {
                    currentLine = currentLine.concat(" ").replaceAll("\\.", "\\. ");
                    text.append(currentLine);
                }
            }
            textString = text.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return textString;
    }

}
