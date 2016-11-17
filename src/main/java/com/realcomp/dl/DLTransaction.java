package com.realcomp.dl;

import com.realcomp.address.Address;
import com.realcomp.address.RawAddress;
import com.realcomp.names.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;


public class DLTransaction implements Comparable<DLTransaction>{

    private static final Pattern DATE_PATTERN = Pattern.compile("^[0-9]{8}$"); //YYYYMMDD

    @NotNull
    private DLTransactionType type;

    @NotNull
    private String id;

    @NotNull
    private CardType CardType;

    @NotNull
    private String source;

    /**
     * The date this transaction occurred.
     */
    @NotNull
    private String transactionDate;

    private Name name;
    private String dob;

    /**
     * The date this id/dl was issued to the holder
     */
    private String issueDate;
    private RawAddress rawAddress;
    private Address address;
    private Map<String,String> attributes;

    public DLTransaction(){
        id = "";
        type = DLTransactionType.UPDATE;
        CardType = CardType.DL;
        attributes = new HashMap<>();
        transactionDate = "00000000";
        source = "";
    }


    public DLTransaction(@NotNull DLTransaction copy){
        Objects.requireNonNull(copy);
        this.id = copy.id;
        this.type = copy.type;
        this.CardType = copy.CardType;
        this.source = copy.source;
        this.transactionDate = copy.transactionDate;
        this.name = copy.name == null ? null : new Name(copy.name);
        this.dob = copy.dob;
        this.issueDate = copy.issueDate;
        this.rawAddress = copy.rawAddress == null ? null : new RawAddress(copy.rawAddress);
        this.address = copy.address == null ? null : new Address(copy.address);
        attributes = new HashMap<>();
        this.attributes.putAll(copy.attributes);
    }

    @NotNull
    public String getId(){
        return id;
    }

    public void setId(@NotNull String id){
        Objects.requireNonNull(id);
        this.id = id;
    }

    @NotNull
    public DLTransactionType getType(){
        return type;
    }

    public void setType(@NotNull DLTransactionType type){
        Objects.requireNonNull(type);
        this.type = type;
    }

    @NotNull
    public CardType getCardType(){
        return CardType;
    }

    public void setCardType(@NotNull CardType cardType){
        Objects.requireNonNull(cardType);
        this.CardType = cardType;
    }

    @NotNull
    public String getSource(){
        return source;
    }

    public void setSource(@NotNull String source){
        Objects.requireNonNull(source);
        this.source = source;
    }

    @Nullable
    public String getDob(){
        return dob;
    }

    public void setDob(String dob){
        if (dob != null && !DATE_PATTERN.matcher(dob).matches()){
            throw new IllegalArgumentException(
                    "dob [" + dob + "] does not match pattern YYYYMMDD");
        }
        this.dob = dob;
    }

    @Nullable
    public String getTransactionDate(){
        return transactionDate;
    }

    public void setTransactionDate(@NotNull String transactionDate){
        Objects.requireNonNull(transactionDate);
        if (!DATE_PATTERN.matcher(transactionDate).matches()){
            throw new IllegalArgumentException(
                    "transactionDate [" + transactionDate + "] does not match pattern YYYYMMDD");
        }
        this.transactionDate = transactionDate;
    }

    @Nullable
    public RawAddress getRawAddress(){
        return rawAddress;
    }

    public void setRawAddress(RawAddress rawAddress){
        this.rawAddress = rawAddress;
    }

    @Nullable
    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    @Nullable
    public Name getName(){
        return name;
    }

    public void setName(Name name){
        this.name = name;
    }

    public String getIssueDate(){
        return issueDate;
    }

    public void setIssueDate(String issueDate){
        if (issueDate != null && !DATE_PATTERN.matcher(issueDate).matches()){
            throw new IllegalArgumentException(
                    "issueDate [" + issueDate + "] does not match pattern YYYYMMDD");
        }
        this.issueDate = issueDate;
    }

    @NotNull
    public Map<String, String> getAttributes(){
        return attributes;
    }


    public void setAttributes(@NotNull Map<String, String> attributes){
        Objects.requireNonNull(attributes);
        this.attributes = attributes;
    }

    public String setAttribute(@NotNull String key, String value){
        Objects.requireNonNull(key);
        return attributes.put(key, value);
    }

    @Override
    public String toString(){
        return "DLTransaction{" +
                "type=" + type +
                ", id='" + id + '\'' +
                ", CardType=" + CardType +
                '}';
    }

    @Override
    public int compareTo(@NotNull DLTransaction other){
        return transactionDate.compareTo(other.transactionDate);
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof DLTransaction)){
            return false;
        }

        DLTransaction that = (DLTransaction) o;

        if (type != that.type){
            return false;
        }
        if (!id.equals(that.id)){
            return false;
        }
        if (CardType != that.CardType){
            return false;
        }
        if (!source.equals(that.source)){
            return false;
        }
        if (!transactionDate.equals(that.transactionDate)){
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null){
            return false;
        }
        if (dob != null ? !dob.equals(that.dob) : that.dob != null){
            return false;
        }
        if (issueDate != null ? !issueDate.equals(that.issueDate) : that.issueDate != null){
            return false;
        }
        if (rawAddress != null ? !rawAddress.equals(that.rawAddress) : that.rawAddress != null){
            return false;
        }
        if (address != null ? !address.equals(that.address) : that.address != null){
            return false;
        }
        return attributes != null ? attributes.equals(that.attributes) : that.attributes == null;

    }

    @Override
    public int hashCode(){
        int result = type.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + CardType.hashCode();
        result = 31 * result + source.hashCode();
        result = 31 * result + transactionDate.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (issueDate != null ? issueDate.hashCode() : 0);
        result = 31 * result + (rawAddress != null ? rawAddress.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        return result;
    }
}
