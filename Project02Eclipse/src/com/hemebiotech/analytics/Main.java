package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String filePath = "Project02Eclipse/symptoms.txt";
        ISymptomReader reader = new ReadSymptomDataFromFile(filePath);
        ISymptomWriter writer = new WriteSymptomDataToFile();
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // get a list of the symptoms
        List<String> symptoms = counter.getSymptoms();
        // count symptoms
        Map<String, Integer> symptomCount = counter.countSymptoms(symptoms);
        // sort them
        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomCount);

        // write the results to output file
        writer.writeSymptoms(sortedSymptoms);

    }
}
