package ro.fasttrackit.curs14.homework.week2.extramile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ShortInfo extends CountryFileReader implements CountryDetails {

    @Override
    public void printDetails() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\fasttrack\\curs14\\curs14-code\\src\\ro\\fasttrackit\\curs14\\homework\\week2\\extramile\\ShortCountryInformation"));
        for (Country country : readCountries()) {
            writer.write(country.getName() + " has population of "
                    + country.getPopulation() + " on area "
                    + country.getArea() + " km2 and has capital " + country.getCapital() + ".");
            writer.newLine();
        }
        writer.close();
    }
}
