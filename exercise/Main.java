package ro.fasttrackit.curs14.homework.week2.exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        QuoteReader quoteReader = new QuoteReader();
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\fasttrack\\curs14\\curs14-code\\src\\ro\\fasttrackit\\curs14\\homework\\week2\\exercise\\output"));
        List<Quote> quotes = quoteReader.readQuotes();

        QuoteService quoteService = new QuoteService(quotes);
        final String randomAuthor = quoteService.randomQuoteObject().getAuthor();

        writer.write(printList(quoteService.getAllQuotes()));
        writer.write(printList(quoteService.getQuotesForAuthor(randomAuthor)));
        writer.write(printList(quoteService.quotesByAuthor(randomAuthor)));
        writer.write(printList(quoteService.getAuthors()));

        Random random1 = new Random();
        int number = random1.nextInt(quotes.size() - 1);
        quoteService.setFavourite(number);
        number = random1.nextInt(quotes.size() - 1);
        quoteService.setFavourite(number);
        number = random1.nextInt(quotes.size() - 1);
        quoteService.setFavourite(number);
        writer.write(printList(quoteService.getFavouriteQuotes()));

        writer.newLine();
        writer.write(quoteService.getRandomQuote());
        writer.close();
    }

    public static <T> String printList(List<T> list) {
        StringBuilder result = new StringBuilder();
        result.append("\n");
        for (Object object : list) {
            result.append(object).append("\n");
        }
        result.append("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        return result.toString();
    }
}
