package com.assignment.serializer;

import com.assignment.model.Text;
import com.assignment.model.Sentence;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;


public class CSVSerializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CSVSerializer.class);

    public static final String COLUMN_PREFIX = "Word ";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String SENTENCE_PREFIX = "Sentence ";

    public void serialize(Text text, String fileName) throws IOException {

        FileWriter fileWriter;
        CSVPrinter csvPrinter;

        //Create the CSVFormat object
        CSVFormat csvFormat = CSVFormat.DEFAULT
                                .withRecordSeparator(NEW_LINE_SEPARATOR)
                                .withHeader(prepareHeader(text));


        try {
            //initialize FileWriter object
            fileWriter = new FileWriter(fileName);

            //initialize CSVPrinter object
            csvPrinter = new CSVPrinter(fileWriter, csvFormat);

            ListIterator iterator = text.getSentences().listIterator();

            while (iterator.hasNext()) {
                Sentence sentence = (Sentence) iterator.next();

                List record = new ArrayList();
                record.add(SENTENCE_PREFIX + iterator.nextIndex());
                record.addAll(sentence.getWords());
                csvPrinter.printRecord(record);
            }

            csvPrinter.flush();

            LOGGER.info("CSV file created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private String[] prepareHeader(Text textIn){
        int noColumns = 0;

        if (textIn.getSentences() != null){
            noColumns = Collections.max(textIn.getSentences()).getWords().size();
        }

        List<String> headerColumnsName = new ArrayList<>();
        headerColumnsName.add("");
        for (int i = 1; i <= noColumns; i++){
            headerColumnsName.add(COLUMN_PREFIX + i);
        }

        String[] header = new String[headerColumnsName.size()];
        header = headerColumnsName.toArray(header);

        //String[] header = headerColumnsName.stream().toArray(String[]::new);

        return header;
    }

}
