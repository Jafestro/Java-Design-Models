package Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class APIClientFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName) throws IOException {
        String json = getJsonFromApi(urlString);
        return extractAttributeFromJson(json, attributeName);
    }

    private String getJsonFromApi(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }

    private String extractAttributeFromJson(String json, String attributeName) throws IllegalArgumentException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            if (jsonObject.containsKey(attributeName)) {
                return (String) jsonObject.get(attributeName);
            } else {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in the JSON response.");
            }
        } catch (org.json.simple.parser.ParseException e) {
            throw new IllegalArgumentException("Invalid JSON format.", e);
        }
    }

}
