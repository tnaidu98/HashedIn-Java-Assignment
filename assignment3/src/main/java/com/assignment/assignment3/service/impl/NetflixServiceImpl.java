package com.assignment.assignment3.service.impl;

import com.assignment.assignment3.entities.ShowDetails;
import com.assignment.assignment3.repositories.ShowDetailsRepository;
import com.assignment.assignment3.service.NetflixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NetflixServiceImpl implements NetflixService {

    @Autowired
    ShowDetailsRepository showDetailsRepository;

    public static List<ShowDetails> showDetailsList = new ArrayList<>();

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
                showDetails.setMovie_type(record[1]);
                showDetails.setTitle(record[2]);
                showDetails.setDirector(record[3]);
                showDetails.setShow_cast(record[4]);
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
        return showDetailsList.stream().filter(showDetails -> showDetails.getMovie_type().equals(type)).limit(n).collect(Collectors.toList());
    }

    @Override
    public List<ShowDetails> getRecordsOfListedIn(String type, String listed_in) {
        return showDetailsList.stream()
                .filter(showDetails -> showDetails.getListed_in().contains(listed_in) && showDetails.getMovie_type().equals(type)).collect(Collectors.toList());
    }

    @Override
    public List<ShowDetails> getRecordOfTypeAndCountry(String type, String country) {
        return showDetailsList.stream()
                .filter(showDetails -> showDetails.getMovie_type().equals(type) && showDetails.getCountry().equals(country)).collect(Collectors.toList());
    }

    @Override
    public List<ShowDetails> getRecordsOfTypeInRange(String type, Date start_date, Date end_date) {
        return showDetailsList.stream()
                .filter(showDetails -> showDetails.getMovie_type().equals(type) &&
                        showDetails.getDate_added() != null &&
                        showDetails.getDate_added().after(start_date) &&
                        showDetails.getDate_added().before(end_date)).collect(Collectors.toList());
    }

    @Override
    public String addShowDetailsToDB(List<ShowDetails> newShowDetailsList) {
        try{
            showDetailsRepository.saveAll(newShowDetailsList);
        }
        catch (Exception e){
            return String.valueOf(e);
        }

        return "Data added Successfully to DB";
    }

    @Override
    public List<ShowDetails> getShowDetails(String dataSource) {
        if (dataSource.equalsIgnoreCase("csv") ) {
            try {
                readCSVDetails();
            } catch (Exception e) {
                log.info(String.valueOf(e));
                return null;
            }

            return showDetailsList;
        }
        else if(dataSource.equalsIgnoreCase("db")) {
            return showDetailsRepository.findAll();
        }
        return null;
    }

    @Scheduled(fixedRate = 300000)
    public void SyncCSVDataToDB(){

        log.info("Syncing CSV Data to Database");

        try {
            readCSVDetails();
        } catch (Exception e) {
            log.info(String.valueOf(e));
        }

        List<ShowDetails> dbList = showDetailsRepository.findAll();

        List<ShowDetails> newCSVRecords = new ArrayList<>();

        for (ShowDetails i : showDetailsList) {
            if (dbList.contains(i)) {
                continue;
            } else {
                newCSVRecords.add(i);
            }
        }

        if(!newCSVRecords.isEmpty()){
            showDetailsRepository.saveAll(newCSVRecords); }
    }
}
