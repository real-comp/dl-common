package com.realcomp.dl;

import com.realcomp.address.Address;
import com.realcomp.address.RawAddress;
import com.realcomp.names.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.regex.Pattern;

public class DLRecord{

    private static final Pattern DATE_PATTERN = Pattern.compile("^[0-9]{8}$"); //YYYYMMDD

    private String guid;
    private String source;
    private CardType cardType;
    private String id;
    private String transactionDate;
    private Name name;
    private String dob;
    private String latestIssueDate;
    private String originalIssueDate;
    private RawAddress rawAddress;
    private Address address;
    private TreeSet<DLTransaction> history;
    private Map<String,String> attributes;

    public DLRecord(){
        id = "";
        cardType = cardType.DL;
        history = new TreeSet<>();
        attributes = new HashMap<>();
        source = "";
        guid = DriverLicenseGUID.generate(this);
    }

    public DLRecord(@NotNull String source, @NotNull CardType cardType, @NotNull String id){
        Objects.requireNonNull(id);
        Objects.requireNonNull(cardType);
        Objects.requireNonNull(source);
        this.source = source;
        this.cardType = cardType;
        this.id = id;
        history = new TreeSet<>();
        attributes = new HashMap<>();
        guid = DriverLicenseGUID.generate(this);
    }

    public DLRecord(@NotNull DLTransaction latest){
        Objects.requireNonNull(latest);
        id = latest.getId();
        source = latest.getSource();
        cardType = latest.getCardType();
        name = latest.getName();
        dob = latest.getDob();
        transactionDate = latest.getTransactionDate();
        latestIssueDate = latest.getIssueDate();
        originalIssueDate = latest.getIssueDate();
        rawAddress = latest.getRawAddress();
        address = latest.getAddress();
        history = new TreeSet<>();
        attributes = new HashMap<>();
        attributes.putAll(latest.getAttributes());
        guid = DriverLicenseGUID.generate(this);
    }

    @NotNull
    public String getGuid(){
        return guid;
    }

    public void setGuid(@NotNull String guid){
        Objects.requireNonNull(guid);
        this.guid = guid;
    }

    @NotNull
    public String getId(){
        return id;
    }

    public void setId(@NotNull String id){
        Objects.requireNonNull(id);
        this.id = id;
        guid = DriverLicenseGUID.generate(this);
    }

    @NotNull
    public CardType getCardType(){
        return cardType;
    }

    public void setCardType(@NotNull CardType cardType){
        Objects.requireNonNull(cardType);
        this.cardType = cardType;
    }

    @NotNull
    public String getSource(){
        return source;
    }

    public void setSource(@NotNull String source){
        Objects.requireNonNull(source);
        this.source = source;
        guid = DriverLicenseGUID.generate(this);
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

    public String getLatestIssueDate(){
        return latestIssueDate;
    }

    public void setLatestIssueDate(String latestIssueDate){
        if (latestIssueDate != null && !DATE_PATTERN.matcher(latestIssueDate).matches()){
            throw new IllegalArgumentException(
                    "latestIssueDate [" + latestIssueDate + "] does not match pattern YYYYMMDD");
        }
        this.latestIssueDate = latestIssueDate;
    }

    public String getOriginalIssueDate(){
        return originalIssueDate;
    }

    public void setOriginalIssueDate(String originalIssueDate){
        if (originalIssueDate != null && !DATE_PATTERN.matcher(originalIssueDate).matches()){
            throw new IllegalArgumentException(
                    "issueDate [" + originalIssueDate + "] does not match pattern YYYYMMDD");
        }
        this.originalIssueDate = originalIssueDate;
    }

    public String getTransactionDate(){
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate){
        if (transactionDate != null && !DATE_PATTERN.matcher(transactionDate).matches()){
            throw new IllegalArgumentException(
                    "transactionDate [" + transactionDate + "] does not match pattern YYYYMMDD");
        }
        this.transactionDate = transactionDate;
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

    @NotNull
    public Set<DLTransaction> getHistory(){
        return history;
    }

    public void setHistory(@NotNull Set<DLTransaction> history){
        Objects.requireNonNull(history);
        this.history = new TreeSet<>();
        this.history.addAll(history);
    }

    public void addHistory(@NotNull DLTransaction tx){
        Objects.requireNonNull(tx);
        this.history.add(tx);
    }


    @Override
    public String toString(){
        return "DLRecord{" +
                "guid='" + guid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof DLRecord)){
            return false;
        }

        DLRecord dlRecord = (DLRecord) o;

        if (guid != null ? !guid.equals(dlRecord.guid) : dlRecord.guid != null){
            return false;
        }
        if (source != null ? !source.equals(dlRecord.source) : dlRecord.source != null){
            return false;
        }
        if (cardType != dlRecord.cardType){
            return false;
        }
        if (id != null ? !id.equals(dlRecord.id) : dlRecord.id != null){
            return false;
        }
        if (transactionDate != null ? !transactionDate.equals(dlRecord.transactionDate) : dlRecord.transactionDate != null){
            return false;
        }
        if (name != null ? !name.equals(dlRecord.name) : dlRecord.name != null){
            return false;
        }
        if (dob != null ? !dob.equals(dlRecord.dob) : dlRecord.dob != null){
            return false;
        }
        if (latestIssueDate != null ? !latestIssueDate.equals(dlRecord.latestIssueDate) : dlRecord.latestIssueDate != null){
            return false;
        }
        if (originalIssueDate != null ? !originalIssueDate.equals(dlRecord.originalIssueDate) : dlRecord.originalIssueDate != null){
            return false;
        }
        if (rawAddress != null ? !rawAddress.equals(dlRecord.rawAddress) : dlRecord.rawAddress != null){
            return false;
        }
        if (address != null ? !address.equals(dlRecord.address) : dlRecord.address != null){
            return false;
        }
        if (history != null ? !history.equals(dlRecord.history) : dlRecord.history != null){
            return false;
        }
        return attributes != null ? attributes.equals(dlRecord.attributes) : dlRecord.attributes == null;

    }

    @Override
    public int hashCode(){
        int result = guid != null ? guid.hashCode() : 0;
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (latestIssueDate != null ? latestIssueDate.hashCode() : 0);
        result = 31 * result + (originalIssueDate != null ? originalIssueDate.hashCode() : 0);
        result = 31 * result + (rawAddress != null ? rawAddress.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (history != null ? history.hashCode() : 0);
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        return result;
    }
}
