package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePath;

	public ReadSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public List<String> getSymptoms() {

		ArrayList<String> result = new ArrayList<>();

		if (filePath != null)
		{
			try {
				FileReader fileReader = new FileReader(filePath);
				BufferedReader reader = new BufferedReader(fileReader);
				String line = reader.readLine();
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return result;
	}

}
