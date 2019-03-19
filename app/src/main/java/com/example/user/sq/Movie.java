package com.example.user.sq;

public class Movie {

    private String moviename;
    private String mvieYear;
    private int movieid;

    public Movie(String moviename, String mvieYear, int movieid) {
        this.moviename = moviename;
        this.mvieYear = mvieYear;
        this.movieid = movieid;
    }

    public Movie() {
    }

    public Movie(String moviename, String mvieYear) {
        this.moviename = moviename;
        this.mvieYear = mvieYear;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getMvieYear() {
        return mvieYear;
    }

    public void setMvieYear(String mvieYear) {
        this.mvieYear = mvieYear;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }
}
