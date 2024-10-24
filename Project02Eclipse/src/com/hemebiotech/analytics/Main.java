package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String filePath = "Project02Eclipse/symptoms.txt";
        ISymptomReader reader = new ReadSymptomDataFromFile(filePath);
        ISymptomWriter writer = new WriteSymptomDataToFile();
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = counter.getSymptoms();
        Map<String, Integer> symptomCount = counter.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomCount);

        writer.writeSymptoms(sortedSymptoms);

    }
}
