package com.restapi.facturacion_backend.presentation.util.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    /**
     * Generates a ResponseEntity with a custom message, HTTP status, and response object.
     *
     * @param message     The custom message to include in the response.
     * @param status      The HTTP status code for the response.
     * @param responseObj The response object to be included in the response body.
     * @return A ResponseEntity<Object> containing the provided message, status code, and response object.
     */
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<>(map, status);
    }

    /**
     * Generates a ResponseEntity with the provided HTTP status and response object.
     *
     * @param status      The HTTP status code for the response.
     * @param responseObj The response object to be included in the response body.
     * @return A ResponseEntity<Object> containing the status code and response object.
     */
    public static ResponseEntity<Object> generateResponse(HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<>(map, status);
    }

    /**
     * Generates a ResponseEntity with a custom message and HTTP status, along with an empty response object.
     *
     * @param message The custom message to include in the response.
     * @param status  The HTTP status code for the response.
     * @return A ResponseEntity<Object> containing the provided message, status code, and an empty response object.
     */
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", new ArrayList<>());

        return new ResponseEntity<>(map, status);
    }
}
