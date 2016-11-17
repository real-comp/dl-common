package com.realcomp.dl;

import org.junit.Test;

import static org.junit.Assert.fail;

public class DLTransactionTest{

    @Test
    public void testTransactionDate(){

        DLTransaction tx = new DLTransaction();
        tx.setTransactionDate("20160101");

        try{
            tx.setTransactionDate("");
            fail("should have thrown IAE");
        }
        catch(IllegalArgumentException ok){}

        try{
            tx.setTransactionDate("1234567");
            fail("should have thrown IAE");
        }
        catch(IllegalArgumentException ok){}

        try{
            tx.setTransactionDate("123456789");
            fail("should have thrown IAE");
        }
        catch(IllegalArgumentException ok){}

        try{
            tx.setTransactionDate("A2345678");
            fail("should have thrown IAE");
        }
        catch(IllegalArgumentException ok){}

    }


    @Test
    public void testIssueDate(){

        DLTransaction tx = new DLTransaction();
        tx.setIssueDate("20160101");
        tx.setIssueDate(null);

        try{
            tx.setIssueDate("");
            fail("should have thrown IAE");
        }
        catch(IllegalArgumentException ok){}


        try{
            tx.setIssueDate("1234567");
            fail("should have thrown IAE");
        }
        catch(IllegalArgumentException ok){}

        try{
            tx.setIssueDate("123456789");
            fail("should have thrown IAE");
        }
        catch(IllegalArgumentException ok){}

        try{
            tx.setIssueDate("A2345678");
            fail("should have thrown IAE");
        }
        catch(IllegalArgumentException ok){}

    }


    @Test
    public void testDOB(){

        DLTransaction tx = new DLTransaction();
        tx.setDob("20160101");
        tx.setDob(null);

        try{
            tx.setDob("");
            fail("should have thrown IAE");
        }
        catch(IllegalArgumentException ok){}


        try{
            tx.setDob("1234567");
            fail("should have thrown IAE");
        }
        catch(IllegalArgumentException ok){}

        try{
            tx.setDob("123456789");
            fail("should have thrown IAE");
        }
        catch(IllegalArgumentException ok){}

        try{
            tx.setDob("A2345678");
            fail("should have thrown IAE");
        }
        catch(IllegalArgumentException ok){}

    }

}