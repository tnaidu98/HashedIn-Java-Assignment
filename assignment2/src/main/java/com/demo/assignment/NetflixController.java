package com.demo.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class NetflixController{

    @Autowired
    private NetflixService netflixService;

    @GetMapping("/tvshows")
    public ResponseEntity<List<ShowDetails>> listTVShows(@RequestParam(defaultValue = "empty") String count,
                                         @RequestParam(defaultValue = "empty") String movieType,
                                         @RequestParam(defaultValue = "empty") String country,
                                         @RequestParam(defaultValue = "empty") String start_date,
                                         @RequestParam(defaultValue = "empty") String end_date,
                                         @RequestHeader(name="X-Auth-Token",required=true) String token,
                                         HttpServletResponse response, HttpServletRequest request) throws Exception {

        if(token == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        long time = System.currentTimeMillis();
        netflixService.readCSVDetails();

        if (!count.equals("empty")) {
            response.setHeader("X-TIME-TO-EXECUTE",String.valueOf(System.currentTimeMillis() - time));
            return new ResponseEntity<>(netflixService.getNRecordsOfType(Integer.valueOf(count),"TV Show"),HttpStatus.OK);
        }
        else if (!movieType.equals("empty")) {
            response.setHeader("X-TIME-TO-EXECUTE",String.valueOf(System.currentTimeMillis() - time));
            return new ResponseEntity<>(netflixService.getRecordsOfListedIn("TV Show",movieType),HttpStatus.OK);
        }
        else if (!country.equals("empty")) {
            response.setHeader("X-TIME-TO-EXECUTE",String.valueOf(System.currentTimeMillis() - time));
            return new ResponseEntity<>(netflixService.getRecordOfTypeAndCountry("TV Show",country),HttpStatus.OK);
        }
        else if (!start_date.equals("empty") && !end_date.equals("empty")) {
            response.setHeader("X-TIME-TO-EXECUTE",String.valueOf(System.currentTimeMillis() - time));
            return new ResponseEntity<>(netflixService.getRecordsOfTypeInRange("TV Show",new SimpleDateFormat("dd-MMM-yy").parse(start_date),new SimpleDateFormat("dd-MMM-yy").parse(end_date)),HttpStatus.OK);
        }

        return null;
    }



}
