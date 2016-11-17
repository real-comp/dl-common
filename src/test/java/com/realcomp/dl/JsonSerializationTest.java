package com.realcomp.dl;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class JsonSerializationTest{

    private static final Logger logger = Logger.getLogger(JsonSerializationTest.class.getName());

    @Test
    public void testSerialization() throws IOException{

        ObjectMapper jackson = new ObjectMapper();


        DLTransaction tx = new DLTransactionBuilder()
            .id("12345")
            .transactionDate("20160101")
            .type(DLTransactionType.UPDATE)
            .cardType(CardType.DL)
            .build();

        DLRecord dl = new DLRecord();
        dl.setCardType(CardType.DL);
        dl.setId("12345");
        dl.setLatestIssueDate("20160101");

        dl.addHistory(tx);

        String json = jackson.writeValueAsString(dl);
        logger.info(json);
        DLRecord copy = jackson.readValue(json, DLRecord.class);
        assertEquals(dl, copy);

        jackson = new ObjectMapper();
        jackson.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        jackson.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        json = jackson.writeValueAsString(dl);
        logger.info(json);
        copy = jackson.readValue(json, DLRecord.class);
        assertEquals(dl, copy);
    }
}
