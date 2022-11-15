package com.endava.google;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class JackonExample {

    public static final Logger LOGGER  = LogManager.getLogger(JackonExample.class);

    public static void main(String[] args) throws JsonProcessingException {

        Payment p = new Payment();
        p.setAmount(100.0);
        p.setCurrency("RON");
        p.setCardNumber("1234543215678");
        p.setCustomerName("Ion Ion");

        ObjectMapper objMapper = new ObjectMapper();
        //serializare
        String json = objMapper.writeValueAsString(p);
        LOGGER.info(json);

        //deserializare

        Payment dP = objMapper.readValue(json, Payment.class);
        LOGGER.info(dP.equals(p));
    }
}
