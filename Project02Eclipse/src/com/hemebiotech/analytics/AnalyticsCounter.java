package com.hemebiotech.analytics;

import java.util.*;
import java.util.stream.Collectors;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		Map<String, Integer> map = new HashMap<>();

		for (String symptom : symptoms) {

			map.put(symptom,
					map.getOrDefault(symptom, 0) + 1);
		}
		return map;
	}

	public Map<String, Integer> sortSymptoms (Map<String, Integer> symptoms) {

		Map<String, Integer> sortedSymptoms = symptoms.entrySet()
														.stream()
														.sorted(Map.Entry.comparingByKey())
														.collect(Collectors.toMap(
																	Map.Entry::getKey,
																	Map.Entry::getValue,
																	(oldValue, newValue) -> oldValue,
																	LinkedHashMap::new
																)
														);
		return sortedSymptoms;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		try {
			writer.writeSymptoms(symptoms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
