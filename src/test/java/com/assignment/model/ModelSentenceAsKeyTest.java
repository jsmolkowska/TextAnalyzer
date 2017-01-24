package com.assignment.model;


import com.assignment.Mocks;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThat;

public class ModelSentenceAsKeyTest {
    public static final String ONE_STRING = "one string";

    @Test
    public void shouldUseSentenceAsKey(){
        //given
        Map<Sentence, String> sentenceAsKeyMap = new HashMap<>();

        //when
        Sentence sentenceOne = Mocks.getSentenceOne();
        sentenceAsKeyMap.put(sentenceOne, ONE_STRING);

        //then
        assertThat(sentenceAsKeyMap.get(sentenceOne), Matchers.equalTo(ONE_STRING));
    }

    @Test
    public void shouldUseTextAsKey(){
        //given
        Map<Text, String> textAsKeyMap = new HashMap<>();

        //when
        Text text = Mocks.simpleInputText();
        textAsKeyMap.put(text, ONE_STRING);

        //then
        assertThat(textAsKeyMap.get(text), Matchers.equalTo(ONE_STRING));
    }
}
