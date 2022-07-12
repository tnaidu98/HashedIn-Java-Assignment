package com.demo.assignment;

import java.util.Date;
import java.util.List;

public interface NetflixService {

    public void readCSVDetails() throws Exception;

    public List<ShowDetails> getNRecordsOfType(int n, String type);

    public List<ShowDetails> getRecordsOfListedIn(String type, String listed_in);

    public List<ShowDetails> getRecordOfTypeAndCountry(String type, String country);

    public List<ShowDetails> getRecordsOfTypeInRange(String type, Date start_date, Date end_date);


}
