package com.assignment;


import com.assignment.model.Sentence;
import com.assignment.model.Text;

import java.util.Arrays;

public class Mocks {
    private Mocks(){
    }

    public static String getInputOne(){
        return "Mary had a little lamb.";
    }

    public static String getCleanInputOne(){
        return "Mary had a little lamb";
    }

    public static String getInputTwo(){
        return "Peter called for the wolf, and Aesop came.";
    }

    public static String getCleanInputTwo(){
        return "Peter called for the wolf and Aesop came";
    }

    public static String getInputThree(){
        return "Cinderella likes shoes.";
    }

    public static String getCleanInputThree(){
        return "Cinderella likes shoes";
    }

    public static Text simpleInputText() {
        return new Text(Arrays.asList(getSentenceOne(), getSentenceTwo(), getSentenceThree()));
    }

    public static Sentence getSentenceOne() {
        return getSentenceWords("a", "had", "lamb", "little", "Mary");
    }

    public static Sentence getSentenceTwo() {
        return getSentenceWords("Aesop", "and", "called", "came", "for", "Peter", "the", "wolf");
    }

    public static Sentence getSentenceThree() {
        return getSentenceWords("Cinderella", "likes", "shoes");
    }

    public static Sentence getSentenceWords(String... words) {
        return new Sentence(Arrays.asList(words));
    }
}
