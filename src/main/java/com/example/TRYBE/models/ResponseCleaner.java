package com.example.TRYBE.models;

public class ResponseCleaner {

    /**
     * Cleans the GPT response by removing markdown syntax such as ```json and ```
     * @param response The GPT response to be cleaned
     * @return Cleaned response string
     */
    public static String cleanGptResponse(String response) {
        if (response.startsWith("```json")) {
            response = response.substring(7); // ```json 제거
        }
        if (response.endsWith("```")) {
            response = response.substring(0, response.length() - 3); // ``` 제거
        }
        return response.trim();
    }
}