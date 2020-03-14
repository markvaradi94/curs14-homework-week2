package ro.fasttrackit.curs14.homework.week2.exercise;

import java.util.*;

public class QuoteService {
    private final List<Quote> quotes;

    public QuoteService(List<Quote> quotes) {
        this.quotes = quotes == null ? new ArrayList<>() : quotes;
    }

    public List<Quote> getAllQuotes() {
        return quotes;
    }

    public List<Quote> getQuotesForAuthor(String author) {
        List<Quote> result = new ArrayList<>();
        for (Quote quote : getAllQuotes()) {
            if (authorFound(quote, author)) {
                result.add(quote);
            }
        }
        return result;
    }

    private boolean authorFound(Quote quote, String author) {
        return quote.getAuthor().equalsIgnoreCase(author);
    }

    public List<String> getAuthors() {
        HashSet<String> authorsSet = new HashSet<>();
        for (Quote quote : getAllQuotes()) {
            authorsSet.add(quote.getAuthor());
        }
        List<String> authors = new ArrayList<>(authorsSet);
        Collections.sort(authors);
        return authors;
    }

    public Quote getQuoteByIdNumber(int id) {
        for (Quote quote : getAllQuotes()) {
            if (sameId(quote, id)) {
                return quote;
            }
        }
        return null;
    }

    private boolean sameId(Quote quote, int id) {
        return quote.getId() == id;
    }

    private void setQuoteAsFavourite(Quote quote) {
        quote.setFavourite(true);
    }

    public boolean setFavourite(int id) {
        Quote quote = getQuoteByIdNumber(id) == null ? new Quote("quote not found", "quote not found") : getQuoteByIdNumber(id);
        setQuoteAsFavourite(quote);
        return quote.isFavourite();
    }

    public List<Quote> getFavouriteQuotes() {
        List<Quote> favourites = new ArrayList<>();
        for (Quote quote : getAllQuotes()) {
            if (quote.isFavourite()) {
                favourites.add(quote);
            }
        }
        return favourites;
    }

    private int getMaxIdNumber() {
        return this.quotes.size();
    }

    public String getRandomQuote() {
        Random random = new Random();
        int quoteId = random.nextInt(getMaxIdNumber() - 1);
        return Objects.requireNonNull(getQuoteByIdNumber(quoteId)).getQuote();
    }

    public Quote randomQuoteObject() {
        Random random = new Random();
        int quoteId = random.nextInt(getMaxIdNumber() - 1);
        return getQuoteByIdNumber(quoteId);
    }

    public List<String> quotesByAuthor(String author) {
        List<Quote> quotesForAuthor = getQuotesForAuthor(author);
        HashSet<String> quoteSet = new HashSet<>();
        for (Quote quote : quotesForAuthor) {
            quoteSet.add(quote.getQuote());
        }
        List<String> quotes = new ArrayList<>(quoteSet);
        Collections.sort(quotes);
        return quotes;
    }

    private Set<String> quotesSet() {
        Set<String> quoteSet = new HashSet<>();
        for (Quote quote : getAllQuotes()) {
            quoteSet.add(quote.getQuote());
        }
        return quoteSet;
    }

    private List<String> uniqueQuotes() {
        return new ArrayList<>(quotesSet());
    }

    public String writePoem(int numberOfPoemLines) {
        List<String> quotes = new ArrayList<>(uniqueQuotes());
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberOfPoemLines; i++) {
            int number = random.nextInt(quotes.size() - 1);
            stringBuilder.append(quotes.get(number)).append("\n");
        }
        return stringBuilder.toString();
    }
}
