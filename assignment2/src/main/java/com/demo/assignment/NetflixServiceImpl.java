package com.demo.assignment;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NetflixServiceImpl implements NetflixService{

    List<ShowDetails> showDetailsList = new ArrayList<>();

    String line = "";

    @Override
    public void readCSVDetails() throws Exception{

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("/Users/tnaidu/Desktop/netflix_titles.csv"));
            line = br.readLine();
            while ((line = br.readLine()) != null)
            {
                String[] record = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");

                ShowDetails showDetails = new ShowDetails();
                showDetails.setShow_id(record[0]);
                showDetails.setType(record[1]);
                showDetails.setTitle(record[2]);
                showDetails.setDirector(record[3]);
                showDetails.setCast(record[4]);
                showDetails.setCountry(record[5]);
                showDetails.setDate_added(record[6].isEmpty() ? null : new SimpleDateFormat("dd-MMM-yy").parse(record[6]));
                showDetails.setRelease_year(Integer.parseInt(record[7]));
                showDetails.setRating(record[8]);
                showDetails.setDuration(record[9]);
                showDetails.setListed_in(record[10]);
                showDetails.setDescription(record[11]);

                showDetailsList.add(showDetails);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public List<ShowDetails> getNRecordsOfType(int n, String type) {
        return showDetailsList.stream().filter(showDetails -> showDetails.getType().equals(type)).limit(n).collect(Collectors.toList());
    }

    @Override
    public List<ShowDetails> getRecordsOfListedIn(String type, String listed_in) {
        return showDetailsList.stream()
                .filter(showDetails -> showDetails.getListed_in().contains(listed_in) && showDetails.getType().equals(type)).collect(Collectors.toList());
    }

    @Override
    public List<ShowDetails> getRecordOfTypeAndCountry(String type, String country) {
        return showDetailsList.stream()
                .filter(showDetails -> showDetails.getType().equals(type) && showDetails.getCountry().equals(country)).collect(Collectors.toList());
    }

    @Override
    public List<ShowDetails> getRecordsOfTypeInRange(String type, Date start_date, Date end_date) {
        return showDetailsList.stream()
                .filter(showDetails -> showDetails.getType().equals(type) &&
                        showDetails.getDate_added() != null &&
                        showDetails.getDate_added().after(start_date) &&
                        showDetails.getDate_added().before(end_date)).collect(Collectors.toList());
    }
}
