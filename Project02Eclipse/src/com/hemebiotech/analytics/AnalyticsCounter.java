package com.hemebiotech.analytics;

import java.util.*;
import java.util.stream.Collectors;

public class AnalyticsCounter {
	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
	//                                       newly written part
	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
	// declare variables
	private ISymptomReader reader;
	private ISymptomWriter writer;

	// _______________________________________________________
	// #1 : constructor -- takes both interfaces (read and write) as arguments
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	// _______________________________________________________
	// #2 : getSymptoms -- gets the list from input file
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	// _______________________________________________________
	// #3 : countSymptoms -- count occurrences
	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		// create an instance of a map using hashing to access data quickly
		Map<String, Integer> map = new HashMap<>();

		// loop on each map's key (symptom) to count how many duplicates are found
		for (String symptom : symptoms) {

			// add to the map : the name of the symptom,
			map.put(symptom,
					// get the value associated with the symptom, and increment each time it's found
					map.getOrDefault(symptom, 0) + 1);
		}
		// return the new map with count number
		return map;
	}

	// _______________________________________________________
	// #4 : sortSymptoms -- alphabetically
	public Map<String, Integer> sortSymptoms (Map<String, Integer> symptoms) {

		// create another map where I store sorted symptoms
		Map<String, Integer> sortedSymptoms = symptoms.entrySet()
														// convert map entries to a sequence of elements
														.stream()
														// sort entries (by symptom) from low-high (alphabetical)
														.sorted(Map.Entry.comparingByKey())
														// collect the sorted stream, and puts it into a map
														.collect(Collectors.toMap(
																// key of map 1 is the same as key of map 2
																	Map.Entry::getKey,
																	// value of map 1 is the same as value of map 2
																	Map.Entry::getValue,
																	// merging values when duplicates are found
																	(oldValue, newValue) -> oldValue,
																	// create a has map to store results
																	LinkedHashMap::new
																)
														);
		return sortedSymptoms;
	}

	// _______________________________________________________
	// #5 : writeSymptoms
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try {
			// use interface function writeSymptoms
			writer.writeSymptoms(symptoms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
	//                                             older code
	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
	/*
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
	 */
}
