package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    public void writeSymptoms(Map<String, Integer> symptoms) {

        // use try to handle exceptions
        try (FileWriter writer = new FileWriter("result.out"))
        {
            // loop on each entry of the list
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {

                // retrieve key and value
                String symptom = entry.getKey();
                Integer nbOccurrence = entry.getValue();

                // write them in the result file
                writer.write(symptom + " " + nbOccurrence + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
