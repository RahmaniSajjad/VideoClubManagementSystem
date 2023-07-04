package project;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LendMovies {
    private Movie movie;
    private ClubManager clubManager;
    private Customer customer;
    private final String TIME;

    {
        TIME = new SimpleDateFormat("yyyy/MM/dd - HH:mm:ss").format(Calendar.getInstance().getTime());
        /*
            https://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java/5175900
         */
    }

    public LendMovies(Movie movie, ClubManager clubManager, Customer customer) {
        this.movie = movie;
        this.clubManager = clubManager;
        this.customer = customer;
    }

    @Override
    public String toString() {
        if (VideoClubManager.isEnLang) {
            return
                    "|---> Borrower : " + customer +
                            "\n\t\tLender : " + clubManager +
                            "\n\t\tMovie : " + movie +
                            "\n\t\tTime : " + TIME + " <---|\n"
                    ;
        } else {
            return
                    "|---> امانت گیرنده : " + customer +
                            "\n\t\tامانت دهنده : " + clubManager +
                            "\n\t\tفیلم : " + movie +
                            "\n\t\tزمان : " + TIME + " <---|\n"
                    ;
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ClubManager getClubManager() {
        return clubManager;
    }

    public void setClubManager(ClubManager clubManager) {
        this.clubManager = clubManager;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
