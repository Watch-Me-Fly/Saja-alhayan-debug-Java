package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePath;

	public ReadSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public List<String> getSymptoms() {

		// create a list of results
		ArrayList<String> result = new ArrayList<>();

		if (filePath != null)
		{
			try {
				// create a file reader
				FileReader fileReader = new FileReader(filePath);
				// wrap file reader in bufferReader for efficient Reading
				BufferedReader reader = new BufferedReader(fileReader);
				// read the file line by line
				String line = reader.readLine();
				// loop on each line to add it to resultList
				while (line != null) {
					// System.out.println(line);
					result.add(line);
					line = reader.readLine();
				}
				// close the buffer
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return result;
	}

}
