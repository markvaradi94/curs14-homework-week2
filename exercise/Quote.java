package ro.fasttrackit.curs14.homework.week2.exercise;

import java.util.Objects;

public class Quote {
    private final String author;
    private final String quote;
    private final int id;
    private boolean favourite;

    public Quote(String author, String quote, int id, boolean favourite) {
        this.author = author;
        this.quote = quote;
        this.id = id;
        this.favourite = favourite;
    }

    public Quote(String author, String quote, int id) {
        this(author, quote, id, false);
    }

    public Quote(String author, String quote) {
        this(author, quote, 0, false);
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuote() {
        return quote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote1 = (Quote) o;
        return id == quote1.id &&
                favourite == quote1.favourite &&
                Objects.equals(author, quote1.author) &&
                Objects.equals(quote, quote1.quote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, quote, id, favourite);
    }

    @Override
    public String toString() {
        return "Quote {" + "id = " + id +
                ", author = " + author +
                ", quote = " + quote +
                ", favourite = " + favourite + "}";
    }
}
