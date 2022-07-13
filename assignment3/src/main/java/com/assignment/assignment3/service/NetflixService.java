package com.assignment.assignment3.service;

import com.assignment.assignment3.entities.ShowDetails;

import java.util.Date;
import java.util.List;

public interface NetflixService {
    public void readCSVDetails() throws Exception;

    public List<ShowDetails> getNRecordsOfType(int n, String type);

    public List<ShowDetails> getRecordsOfListedIn(String type, String listed_in);

    public List<ShowDetails> getRecordOfTypeAndCountry(String type, String country);

    public List<ShowDetails> getRecordsOfTypeInRange(String type, Date start_date, Date end_date);

    public String addShowDetailsToDB(List<ShowDetails> newShowDetailsList);

    public List<ShowDetails> getShowDetails(String dataSource);

}
