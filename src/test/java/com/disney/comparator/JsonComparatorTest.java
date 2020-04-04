package com.disney.comparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.TestCase;

public class JsonComparatorTest extends TestCase {

	/**
	 * Tests that generated paths are correct for the path given
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	@Test
	public void testGeneratedPaths() throws JsonProcessingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		JsonComparator comparator = new JsonComparator();
		JsonNode jsonSource = mapper.readTree(this.getClass().getResourceAsStream("/json/jsonResource.json"));
		// JsonNode JsonDestination=
		// mapper.readTree(this.getClass().getResourceAsStream("/json/jsonDestination.json"));
		String[] paths = new String[] { "/descriptions/*/type" };
		String[] pathsExpected = new String[] { 
				"descriptions/shortDescription/type",
				"descriptions/shortDescriptionMobile/type", 
				"descriptions/entityCard1/type",
				"descriptions/entityCard2/type",
				"descriptions/entityCard3/type" };
		ArrayList<StringBuilder> result = comparator.generatePaths(paths[0], jsonSource);
		String[] resultArray = result.stream().map(String::new).toArray(String[]::new);
		assertTrue(Arrays.equals(resultArray, pathsExpected));

	}

}
