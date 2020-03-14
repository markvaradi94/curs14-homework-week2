package ro.fasttrackit.curs14.homework.week2.exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuoteReader {

    public List<Quote> readQuotes() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("C:\\fasttrack\\curs14\\curs14-code\\src\\ro\\fasttrackit\\curs14\\homework\\week2\\exercise\\quotes.txt"));
        List<Quote> quotes = new ArrayList<>();
        int idNumber = 1;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            quotes.add(new Quote(readQuote(line).getAuthor(), readQuote(line).getQuote(), idNumber));
            idNumber++;
        }
        return quotes;
    }

    private Quote readQuote(String line) {
        String[] quote = line.split("~");
        return new Quote(quote[0], quote[1]);
    }
}
