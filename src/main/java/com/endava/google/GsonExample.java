package com.endava.google;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GsonExample {

    private static final Logger LOGGER = LogManager.getLogger(GsonExample.class);

    public static void main(String[] args) {

        Payment p = new Payment();
        p.setAmount(100.0);
        p.setCurrency("RON");
        p.setCardNumber("1234543215678");
        p.setCustomerName("Ion Ion");


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //serializare -> tojson
        String json = gson.toJson(p);
        LOGGER.info("\n{}", json);

        //deserializare -> from json

        Payment dP = gson.fromJson(json, Payment.class);
        //vreau sa vad daca ce am deserializat este la fel cu ce am serializat initial
        LOGGER.info(p.equals(dP));

        LOGGER.info(dP.getCardNumber());

    }
}
