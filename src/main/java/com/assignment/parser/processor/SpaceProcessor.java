package com.assignment.parser.processor;


public class SpaceProcessor implements Processor {

    @Override
    public String process(String input) {

        return input.replaceAll("\\s{2,}+", " ").trim();
    }
}

