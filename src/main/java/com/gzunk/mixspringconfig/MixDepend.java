package com.gzunk.mixspringconfig;

import java.util.Map;

/**
 * Class that accesses an XML defined resource.
 */
public class MixDepend {

    /**
     * Resource that will be populated from XML.
     */
    private final Map<String, String> data;

    /**
     * Constructor.
     * @param pmData - the data taken from XML.
     */
    public MixDepend(final Map<String, String> pmData) {
        this.data = pmData;
    }

    /**
     * Fetch the value within the map.
     * @param value the key to fetch.
     * @return the value in the map.
     */
    String getValue(final String value) {
        return data.get(value);
    }
}
