package ro.fasttrackit.curs14.homework.week2.extramile;

import java.io.IOException;

public class CountryInfo {
    private final CountryDetails countryDetails;

    public CountryInfo(CountryDetails countryDetails) {
        this.countryDetails = countryDetails;
    }

    public void showInfo() throws IOException {
        this.countryDetails.printDetails();
    }
}
