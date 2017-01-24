package com.assignment.parser;


import com.assignment.Mocks;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class SentenceParserTest {

    @Test
    public void shouldReturnSentenceWithOrderedWords(){
        //given
        String cleanInputOne = Mocks.getCleanInputOne();
        String cleanInputTwo = Mocks.getCleanInputTwo();
        String cleanInputThree = Mocks.getCleanInputThree();

        //when
        SentenceParser parser = new SentenceParser();

        //then
        assertThat(parser.breakSentenceIntoOrderedWords(cleanInputOne), Matchers.equalTo(Mocks.getSentenceOne()));
        assertThat(parser.breakSentenceIntoOrderedWords(cleanInputTwo), Matchers.equalTo(Mocks.getSentenceTwo()));
        assertThat(parser.breakSentenceIntoOrderedWords(cleanInputThree), Matchers.equalTo(Mocks.getSentenceThree()));
    }
}
