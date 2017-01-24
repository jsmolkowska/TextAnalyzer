package com.assignment.parser;

import com.assignment.model.Sentence;
import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SentenceParser {

    public Sentence breakSentenceIntoOrderedWords(String sentence){
        List<String> wordsList = new ArrayList<>();

        if (sentence.isEmpty())
            return new Sentence(wordsList);

        Splitter niceSpaceSplitter = Splitter.on(' ').omitEmptyStrings().trimResults();
        Iterable<String> tokens = niceSpaceSplitter.split(sentence);
        for (String token: tokens){
            wordsList.add(token);
        }

        Collections.sort(wordsList, String.CASE_INSENSITIVE_ORDER);

        return new Sentence(wordsList);
    }

}