package ro.fasttrackit.curs14.homework.week2.extramile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CountryDetails shortInfo = new ShortInfo();
        CountryDetails longInfo = new LongInfo();
        CountryInfo shortVersion = new CountryInfo(shortInfo);
        CountryInfo longVersion = new CountryInfo(longInfo);
        shortVersion.showInfo();
        longVersion.showInfo();
    }
}
