package com.assignment.parser.processor;



public class RedundantSignsProcessor implements Processor{

    @Override
    public String process(String input) {

        return input.replaceAll("[\\.\\?\\!\\s]+$", "").replaceAll("[\\-\\:]", "").replaceAll("\\t", " ");
    }
}
