package com.magdy.model;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SerializeToXML {
    public static void serializeToXML() {

        try {
            XmlMapper xmlMapper = new XmlMapper();
            // serialize our Object into XML string
            String xmlString = null;

            xmlString = xmlMapper.writeValueAsString(new Hotel("20", "halton", null));

            // write to the console
            System.out.println(xmlString);

            // write XML string to file
            File xmlOutput = new File("serialized.xml");
            FileWriter fileWriter = null;

            fileWriter = new FileWriter(xmlOutput);

            fileWriter.write(xmlString);

            fileWriter.close();

            // handle exception
        } catch (IOException e) {
            // handle exception
        }
    }

}

