package com.assignment.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;



@XmlRootElement
public class Text {
    public static final String ELEMENT_SENTENCE = "sentence";

    private List<Sentence> sentences;

    public Text(){
    }

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }


    @XmlElement(name = ELEMENT_SENTENCE)
    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }


    @Override
    public String toString() {
        return "Text{" +
                "sentences=" + sentences +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;

        Text text = (Text) o;

        return getSentences().equals(text.getSentences());

    }

    @Override
    public int hashCode() {
        return getSentences().hashCode();
    }
}
