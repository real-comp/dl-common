package com.realcomp.dl;

import com.realcomp.address.Address;
import com.realcomp.address.RawAddress;
import com.realcomp.names.Name;

import java.util.Map;

public class DLTransactionBuilder{


    private DLTransaction tx;

    public DLTransactionBuilder(){
        tx = new DLTransaction();
    }

    public DLTransactionBuilder type(DLTransactionType type){
        tx.setType(type);
        return this;
    }

    public DLTransactionBuilder id(String id){
        tx.setId(id);
        return this;
    }

    public DLTransactionBuilder cardType(CardType type){
        tx.setCardType(type);
        return this;
    }

    public DLTransactionBuilder source(String source){
        tx.setSource(source);
        return this;
    }

    public DLTransactionBuilder transactionDate(String transactionDate){
        tx.setTransactionDate(transactionDate);
        return this;
    }

    public DLTransactionBuilder name(Name name){
        tx.setName(name);
        return this;
    }

    public DLTransactionBuilder dob(String dob){
        tx.setDob(dob);
        return this;
    }
    public DLTransactionBuilder issueDate(String issueDate){
        tx.setIssueDate(issueDate);
        return this;
    }

    public DLTransactionBuilder rawAddress(RawAddress raw){
        tx.setRawAddress(raw);
        return this;
    }

    public DLTransactionBuilder address(Address address){
        tx.setAddress(address);
        return this;
    }

    public DLTransactionBuilder attributes(Map<String,String> attributes){
        tx.setAttributes(attributes);
        return this;
    }

    public DLTransaction build(){
        return new DLTransaction(tx);
    }
}
