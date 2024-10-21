package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    public void writeSymptoms(Map<String, Integer> symptoms) {

        try (FileWriter writer = new FileWriter("result.out"))
        {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {

                String symptom = entry.getKey();
                Integer nbOccurrence = entry.getValue();

                writer.write(symptom + " " + nbOccurrence + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
