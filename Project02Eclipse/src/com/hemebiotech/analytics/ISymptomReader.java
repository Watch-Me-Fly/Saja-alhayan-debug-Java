package com.hemebiotech.analytics;

import java.util.List;

/**
 * -- will read symptom data from a source
 * -- the return value from the operation is a raw list of strings,
 * -- may contain many duplications, not in order
 * -- The implementation does not need to order the list
 * -- If no data is available, return an empty List
 */
public interface ISymptomReader {

	List<String> getSymptoms ();

}
