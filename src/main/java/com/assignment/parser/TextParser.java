package com.assignment.parser;

import com.assignment.parser.processor.CommaProcessor;
import com.assignment.parser.processor.RedundantSignsProcessor;
import com.assignment.parser.processor.SpaceProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class TextParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextParser.class);

    private static final String[] ABBREVIATIONS = {
            "Dr." , "Prof." , "Mr." , "Mrs." , "Ms." , "Jr."
    };

    public static List<String> breakSentences(String text){
        List<String> sentenceList = new ArrayList<>();
        BreakIterator breakIterator = BreakIterator.getSentenceInstance(Locale.ENGLISH);
        breakIterator.setText(text);

        int start = breakIterator.first();
        int end = breakIterator.next();
        int tempStart = start;

        //cleaning the text
        CommaProcessor cp = new CommaProcessor();
        RedundantSignsProcessor rdp = new RedundantSignsProcessor();
        SpaceProcessor sp = new SpaceProcessor();

        while (end != BreakIterator.DONE) {
            String sentence = text.substring(start, end);

            if (!(hasAbbreviation(sentence))) {
                sentence = text.substring(tempStart, end);
                tempStart = end;

                //cleaning the text
                sentence = cp.process(sentence);
                sentence = rdp.process(sentence);
                sentence = sp.process(sentence);

                sentenceList.add(sentence);
            }
            start = end;
            end = breakIterator.next();
        }

        return sentenceList;
    }



    private static boolean hasAbbreviation(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return false;
        }
        for (String word : ABBREVIATIONS) {
            if (sentence.contains(word)) {
                return true;
            }
        }
        return false;
    }

}
