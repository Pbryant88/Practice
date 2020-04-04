package com.disney.comparator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author AGUIL084
 *
 */
public class JsonComparator {

	private static final String WILDCARD = "*";
	private static final String NO_VALUE_PRESENT = "CONTENT DOESN'T EXIST";
	private static ConnectionHelper connectionHelper;
	{
		connectionHelper = ConnectionHelper.getInstance();

	}

	ObjectMapper mapper = new ObjectMapper();

	/**
	 * 
	 * @param urlSource
	 * @param urlDestination
	 * @param paths
	 * @return
	 * @throws Exception
	 */
	public String compare(String urlSource, String urlDestination, String[] paths) throws Exception {

		StringBuilder result = new StringBuilder();
		if (paths.length == 0) {
			return result.append("paths array is empty. Please specify json pointers").toString();
		}
		if (StringUtils.isEmpty(urlSource) || StringUtils.isEmpty(urlDestination)) {
			return result.append("url1 or url2 is empty. Please enter all parameters").toString();
		}

		String json1 = connectionHelper.sendGet(urlSource);
		String json2 = connectionHelper.sendGet(urlDestination);

		JsonNode node1 = null;
		JsonNode node2 = null;

		try {
			node1 = mapper.readTree(json1);
			node2 = mapper.readTree(json2);
		} catch (JsonParseException e) {
			// System.out.println("error processing json");
			return result.append("Json Format in url1 or url2 is invalid").toString();
		}

		result.append(this.compareJsons(node1, node2, paths));

		return result.toString();
	}

	/**
	 * Compares the content of 2 nodes againts a list of json paths
	 * 
	 * @param node1
	 * @param node2
	 * @param paths
	 * @return
	 */
	StringBuilder compareJsons(JsonNode node1, JsonNode node2, String[] paths) {

		StringBuilder result = new StringBuilder();
		ArrayList<StringBuilder> generatedPaths;

		for (int i = 0; i < paths.length; i++) {

			generatedPaths = this.generatePaths(paths[i], node1);
			result = result.append(this.compareContent(generatedPaths, node1, node2));

		}
		return result;

	}

	/**
	 * Shows the content on source and destination node
	 * 
	 * @param generatedPaths
	 * @param node1
	 * @param node2
	 * @return
	 */
	private StringBuilder compareContent(ArrayList<StringBuilder> generatedPaths, JsonNode node1, JsonNode node2) {

		String valueinSource;
		String valueinDestination;
		StringBuilder content = new StringBuilder();
		for (StringBuilder path : generatedPaths) {
			JsonNode sourceNode = node1.at("/" + path.toString());
			JsonNode destinatinNode = node2.at("/" + path.toString());

			if (sourceNode.isMissingNode()) {
				valueinSource = JsonComparator.NO_VALUE_PRESENT;
			} else {
				valueinSource = node1.at("/" + path.toString()).toString();
			}
			if (destinatinNode.isMissingNode()) {
				valueinDestination = JsonComparator.NO_VALUE_PRESENT;
			} else {
				valueinDestination = node2.at("/" + path.toString()).toString();
			}

			boolean stringsAreEqual = valueinDestination.equals(valueinDestination);
			content.append("[").append(path).append(",").append(valueinSource).append(",").append(valueinDestination)
					.append(",").append(stringsAreEqual).append("]\n");
		}
		return content;
	}

	/**
	 * Generates paths for a given path and a sourceNode
	 * 
	 * @param path
	 * @param sourceNode
	 * @return
	 */
	public ArrayList<StringBuilder> generatePaths(String path, JsonNode sourceNode) {

		ArrayList<StringBuilder> generatedPaths = new ArrayList<StringBuilder>();
		// if no wildcard present just return the same path
		if (!path.contains(JsonComparator.WILDCARD)) {
			generatedPaths.add(new StringBuilder(path));
			return generatedPaths;
		}

		String[] pathProperties = path.split("/");
		String currentProperty;

		for (int i = 1; i < pathProperties.length; i++) {

			// path property can be variable or static property
			currentProperty = pathProperties[i];

			if (currentProperty.equals(JsonComparator.WILDCARD)) {
				generatedPaths = this.processWildcards(generatedPaths, sourceNode);
			} else {
				this.processStaticProperty(generatedPaths, currentProperty);

			}

		}

		return generatedPaths;

	}

	/**
	 * Adds new paths when a static property is found
	 * 
	 * @param generatedPaths
	 * @param currentProperty
	 */
	private void processStaticProperty(ArrayList<StringBuilder> generatedPaths, String currentProperty) {

		// first property in the path always is static and must be added the first time
		// only
		if (generatedPaths.isEmpty()) {
			generatedPaths.add(new StringBuilder(currentProperty));
		}

		if (generatedPaths.size() > 1) {
			for (StringBuilder pathaux : generatedPaths) {
				pathaux.append("/" + currentProperty);

			}
		}
	}

	/**
	 * generates paths when a wildcard is found
	 * 
	 * @param generatedPaths
	 * @param sourceNode
	 * @return
	 */
	public ArrayList<StringBuilder> processWildcards(ArrayList<StringBuilder> generatedPaths, JsonNode sourceNode) {

		StringBuilder pathfromVariables = new StringBuilder();

		ArrayList<StringBuilder> generatedPathsForIteration = new ArrayList<StringBuilder>();
		// go trough all generated paths for that node and find children

		for (StringBuilder existingPath : generatedPaths) {

			Iterator<Map.Entry<String, JsonNode>> fields = sourceNode.at("/" + existingPath.toString()).fields();
			while (fields.hasNext()) {
				pathfromVariables = new StringBuilder();
				pathfromVariables.append(existingPath.toString());
				Map.Entry<String, JsonNode> field = fields.next();
				pathfromVariables.append("/" + field.getKey());
				generatedPathsForIteration.add(pathfromVariables);
			}
		}
		return generatedPathsForIteration;

	}

	public static void main(String[] args) throws Exception {

		JsonComparator comparator = new JsonComparator();

		String[] paths = new String[] { "/webLinks/dlrDetails/analyticsTrackPromoImpressions", "/descriptions/*/type" };
		String[] paths2 = new String[] { "/descriptions/*/type", "/descriptions/*/sections/body" };
		// String[] paths2 = new String[] { "/descriptions/*/sections/body" };
		String result = comparator.compare(
				"http://api-qa.wdpro.disney.go.com:48084/content-service/environments/preview/entities/alice-in-wonderland;type=urlFriendly",
				"http://ecm-services-west-qa.starwave.com/content-service/environments/preview/entities/alice-in-wonderland;type=urlFriendly",
				paths2);
		System.out.println(result);

	}

}
