package com.assignment.assignment3.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "showdetails")
public class ShowDetails {
    @Id
    @Column(name = "show_id")
    private String show_id;
    @Column(name = "movie_type")
    private String movie_type;
    @Column(name = "title")
    private String title;
    @Column(name = "director")
    private String director;
    @Column(name = "show_cast", length = 1024)
    private String show_cast;
    @Column(name = "country", length = 1024)
    private String country;
    @Column(name = "date_added")
    private Date date_added;
    @Column(name = "release_year")
    private int release_year;
    @Column(name = "rating")
    private String rating;
    @Column(name = "duration")
    private String duration;
    @Column(name = "listed_in")
    private String listed_in;
    @Column(name = "description", length = 1024)
    private String description;

}
