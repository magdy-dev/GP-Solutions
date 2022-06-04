package com.magdy.model;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Deserialize {
    public static void deserializeFromXML() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
            xmlMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY,true);



            // deserialize from the XML into a Phone object
            List <Map>list = xmlMapper.readValue(new FileInputStream(("hotel.xml")), List.class);

            List<Hotel> hotels= list.stream()
                    .map(m ->{
                       Map a = (Map) m.get("Address");
                        Address address = new Address(
                                String.valueOf(a.get("AddressLine")),
                                String.valueOf( a.get("City")),
                                String.valueOf(a.get("Country")),
                                String.valueOf(a.get("State")));
                        return new Hotel(
                                String.valueOf(m.get("Price")),
                                String.valueOf(m.get("Name")),
                                address);
                    } )
                    .collect(Collectors.toList());

           List<Hotel> result= hotels.stream()
                    .filter(hotel ->hotel.getName().contains("Hilton")&& hotel.getAddress().getCity().contains("New York"))
                    .collect(Collectors.toList());
            String s = xmlMapper.writeValueAsString(new Hotels(result));

            Path path = Paths.get("output.xml");


            try {
                Files.write(path, s.getBytes(StandardCharsets.UTF_8));
            } catch (IOException ex) {
                // Handle exception
            }
            int x=0;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
