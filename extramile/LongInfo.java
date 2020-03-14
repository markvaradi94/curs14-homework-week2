package ro.fasttrackit.curs14.homework.week2.extramile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LongInfo extends CountryFileReader implements CountryDetails {

    @Override
    public void printDetails() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\fasttrack\\curs14\\curs14-code\\src\\ro\\fasttrackit\\curs14\\homework\\week2\\extramile\\LongCountryInformation"));
        for (Country country : readCountries()) {
            writer.write("The country of " + country.getName() + " has capital in " + country.getCapital()
                    + " with a population of " + country.getPopulation()
                    + " on an area of " + country.getArea() + " km2.");
            writer.newLine();
        }
        writer.close();
    }
}
