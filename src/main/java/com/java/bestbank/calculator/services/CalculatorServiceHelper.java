package com.java.bestbank.calculator.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.java.bestbank.calculator.model.CalculatorRequest;
import com.java.bestbank.calculator.model.CalculatorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CalculatorServiceHelper {

    private static final Gson gson = new GsonBuilder().create();

    public static ResponseEntity<CalculatorResponse> prepareResponseForCompoundInterest(double compoundInterest) {
        CalculatorResponse response = new CalculatorResponse();
        response.setCompoundInterest(compoundInterest);

        return new ResponseEntity<CalculatorResponse>(response, HttpStatus.OK);
    }

    public static ResponseEntity<CalculatorResponse> prepareResponseForSimpleInterest(double simpleInterest) {
        CalculatorResponse response = new CalculatorResponse();
        response.setSimpleInterest(simpleInterest);

        return new ResponseEntity<CalculatorResponse>(response, HttpStatus.OK);
    }

    public static CalculatorRequest convertJsonToRequest (String calcRequest) {
        CalculatorRequest request = gson.fromJson(calcRequest, CalculatorRequest.class);
        System.out.println(request);
        return request;
    }
    public static String convertResponseToJson (CalculatorResponse response) {
        String responseJson = gson.toJson(response);
        System.out.println(responseJson);
        return responseJson;
    }
}
