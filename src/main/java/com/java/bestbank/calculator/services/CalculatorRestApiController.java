package com.java.bestbank.calculator.services;

import com.java.bestbank.calculator.core.Calculator;
import com.java.bestbank.calculator.core.CalculatorImpl;
import com.java.bestbank.calculator.core.FXCalculator;
import com.java.bestbank.calculator.core.FXCalculatorImpl;
import com.java.bestbank.calculator.model.CalculatorRequest;
import com.java.bestbank.calculator.model.CalculatorResponse;
import com.java.bestbank.calculator.model.Currency;
import com.java.bestbank.calculator.model.ReturnsCalculatorBean;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController
public class CalculatorRestApiController {
    private static final String resp_tamplate = "Compound Interest Return is %s";
    private static final Calculator calculator = new CalculatorImpl();
    private static final FXCalculator fxcalculator=new FXCalculatorImpl();
    private static final Logger LOGGER = Logger.getLogger(CalculatorRestApiController.class.getName());

    @RequestMapping(value = "/compoundService", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public String calculateCompundInterestReturnService(@RequestBody String calculatorRequest) {
        CalculatorRestApiController.LOGGER.info("Compound Service Return Input Parameters-------------START");
        CalculatorRestApiController.LOGGER.info("JSON Request -    " + calculatorRequest);
        CalculatorRequest request=CalculatorServiceHelper.convertJsonToRequest(calculatorRequest);
        CalculatorRestApiController.LOGGER.info("After Request Conversion  -    " + request.getCalculatorBean().toString());
        //TODO: Request parameter validation, Service gateway design, proper exception handling, authentication and authorization

        double principal=request.getCalculatorBean().getPrincipal();
        int time=request.getCalculatorBean().getTime();
        double interestrate=request.getCalculatorBean().getInterestrate();
        int numberofTime=request.getCalculatorBean().getNumberofTime();
        double compountInterest = calculator.calculateCompundInterestReturn(principal, time, interestrate, numberofTime);
        compountInterest=fxcalculator.calculate(Currency.GBP.name(), Currency.USD.name(), compountInterest);
        CalculatorResponse response=new CalculatorResponse();
        response.setCompoundInterest(compountInterest);
        String jsonResponse=CalculatorServiceHelper.convertResponseToJson(response);
        CalculatorRestApiController.LOGGER.info("Compound Service Return Input Parameters-------------END");
        return String.format(resp_tamplate, jsonResponse);
    }

    @RequestMapping(value = "/simpleInterestService", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public String calculateSimpleInterestReturnService(@RequestBody String calculatorRequest) {
        CalculatorRestApiController.LOGGER.info("Simple Service Return Input Parameters-------------START");
        CalculatorRestApiController.LOGGER.info("JSON Request -    " + calculatorRequest);
        CalculatorRequest request=CalculatorServiceHelper.convertJsonToRequest(calculatorRequest);
        CalculatorRestApiController.LOGGER.info("After Request Conversion  -    " + request.getCalculatorBean().toString());
        //TODO: Request parameter validation, Service gateway design, proper exception handling, authentication and authorization

        double principal=request.getCalculatorBean().getPrincipal();
        double interestrate=request.getCalculatorBean().getInterestrate();
        int numberofTime=request.getCalculatorBean().getNumberofTime();
        double simpleInterest = calculator.calculateSimpleInterestReturn(principal, interestrate, numberofTime);
        simpleInterest=fxcalculator.calculate(Currency.GBP.name(), Currency.USD.name(), simpleInterest);
        CalculatorResponse response=new CalculatorResponse();
        response.setSimpleInterest(simpleInterest);
        String jsonResponse=CalculatorServiceHelper.convertResponseToJson(response);
        CalculatorRestApiController.LOGGER.info("Simple Service Return Input Parameters-------------END");
        return String.format(resp_tamplate, jsonResponse);
    }

    @RequestMapping("/compoundServiceQuery")
    public String calculateCompundInterestReturnServiceQuery(double principal, int time, double interestrate, int numberofTime) {

        LOGGER.info("Compound Service Return Input Parameters-------------START");
        LOGGER.info("principal -    " + principal);
        LOGGER.info("time -         " + time);
        LOGGER.info("interestrate - " + interestrate);
        LOGGER.info("numberofTime - " + numberofTime);
        LOGGER.info("Compound Service Return Input Parameters-------------END");
        double compountInterest = calculator.calculateCompundInterestReturn(principal, time, interestrate, numberofTime);
        return String.format(resp_tamplate, compountInterest);
    }

    @RequestMapping("/simpleInterestServiceQuery")
    public String calculateSimpleInterestReturnServiceQuery(double principal, double interestrate, int numberofTime) {

        LOGGER.info("Simple Service Return Input Parameters-------------START");
        LOGGER.info("principal -    " + principal);
        LOGGER.info("interestrate - " + interestrate);
        LOGGER.info("numberofTime - " + numberofTime);
        LOGGER.info("Compound Service Return Input Parameters-------------END");
        double compountInterest = calculator.calculateSimpleInterestReturn(principal, interestrate, numberofTime);
        return String.format(resp_tamplate, compountInterest);
    }
}
