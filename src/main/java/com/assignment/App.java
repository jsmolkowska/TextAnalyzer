package com.assignment;

import com.assignment.model.Sentence;
import com.assignment.model.Text;
import com.assignment.parser.SentenceParser;
import com.assignment.parser.TextParser;
import com.assignment.reader.TextReader;
import com.assignment.serializer.CSVSerializer;
import com.assignment.serializer.XMLSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws JAXBException, IOException {
        LOGGER.info("Start program...");

        String textIn = TextReader.readText();
        List<String> sentences = TextParser.breakSentences(textIn);

        SentenceParser sentenceParser = new SentenceParser();
        Text text = new Text();

        List<Sentence> listSentencesWords = new ArrayList<>();
        for (String sentence : sentences){
            listSentencesWords.add(sentenceParser.breakSentenceIntoOrderedWords(sentence));
        }

        text.setSentences(listSentencesWords);

        String XMLfile = "fileOUT.xml";
        XMLSerializer xmlSerializer = new XMLSerializer();
        xmlSerializer.serialize(text, XMLfile);

        String CSVfile = "fileOUT.csv";
        CSVSerializer csvSerializer = new CSVSerializer();
        csvSerializer.serialize(text, CSVfile);

        LOGGER.info("The program is over.");
    }
}
