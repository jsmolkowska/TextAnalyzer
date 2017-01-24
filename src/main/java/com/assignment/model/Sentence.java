package com.assignment.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Sentence implements Comparable<Sentence> {

    public static final String ELEMENT_WORD = "word";

    private List<String> words;

    public Sentence() {
        this.words = new ArrayList<>();
    }

    public Sentence(List<String> words) {
        this.words = words;
    }


    @XmlElement(name = ELEMENT_WORD)
    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }


    @Override
    public int compareTo(Sentence o) {
        if (this.getWords().size() > o.getWords().size()) {
            return 1;
        } else if (this.getWords().size() < o.getWords().size()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "words=" + words +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;

        Sentence sentence = (Sentence) o;

        return getWords().equals(sentence.getWords());
    }

    @Override
    public int hashCode() {
        return getWords().hashCode();
    }
}
