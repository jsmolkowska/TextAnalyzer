package com.assignment.serializer;

import com.assignment.model.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


public class XMLSerializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(XMLSerializer.class);

    public void serialize(Text text, String filePath) throws JAXBException {

        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Text.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File(filePath);
            jaxbMarshaller.marshal(text, file);

            LOGGER.info("XML file created successfully.");

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
