package com.hemebiotech.analytics;

import java.util.Map;

/**
 * This interface takes a list of items (symptoms),
 * -- & writes them as (key and value) in a file
 */
public interface ISymptomWriter {

    public void writeSymptoms( Map<String, Integer> symptoms );

}