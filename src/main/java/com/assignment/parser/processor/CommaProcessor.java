package com.assignment.parser.processor;


public class CommaProcessor implements Processor{

    @Override
    public String process(String input) {

        return input.replaceAll(",","");
    }
}
