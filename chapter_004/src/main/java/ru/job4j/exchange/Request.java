package ru.job4j.exchange;

import java.util.Objects;

/**
 * Request for exchange market.
 */
public class Request implements Comparable<Request> {

    private static int counterID = 0;

    private final int id;

    private final String book;

    private final Type typeOfRequest;

    private final Action actionOfRequest;

    private final int price;

    private int volume;

    /**
     * Constructor for Add.
     * @param book name of company
     * @param typeOfRequest Type
     * @param actionOfRequest Action
     * @param price int
     * @param volume int
     */
    Request(final String book,
            final Type typeOfRequest,
            final Action actionOfRequest,
            final int price,
            final int volume) {
        this.id = counterID++;
        this.book = book;
        this.typeOfRequest = typeOfRequest;
        this.actionOfRequest = actionOfRequest;
        this.price = price;
        this.volume = volume;
    }

    /**
     * Constructor for Delete.
     * @param id of request
     * @param book name of company
     * @param typeOfRequest Type
     * @param actionOfRequest Action
     */
    Request(final int id,
            final String book,
            final Type typeOfRequest,
            final Action actionOfRequest) {
        this.id = id;
        this.book = book;
        this.typeOfRequest = typeOfRequest;
        this.actionOfRequest = actionOfRequest;
        this.price = 0;
        this.volume = 0;
    }

    /**
     * Getter Id.
     * @return int id
     */
    int getId() {
        return id;
    }

    /**
     * Getter name of company.
     * @return String name
     */
    String getBook() {
        return book;
    }

    /**
     * Getter Type of Request.
     * @return Type
     */
    Type getTypeOfRequest() {
        return typeOfRequest;
    }

    /**
     * Getter Action of Request.
     * @return Action
     */
    Action getActionOfRequest() {
        return actionOfRequest;
    }

    /**
     * Getter for Price.
     * @return int price
     */
    int getPrice() {
        return price;
    }

    /**
     * Getter for Volume.
     * @return int Volume
     */
    int getVolume() {
        return volume;
    }

    /**
     * Getter for Volume.
     * @param volume int of new Volume
     */
    void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int compareTo(Request o) {
        int inputPrice = o.getPrice();
        int result;
        if (this.price < inputPrice) {
            result = 1;
        } else if (this.price == inputPrice) {
            result = 0;
        } else {
            result = -1;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Request{"
                + "id=" + id
                + ", book='" + book + '\''
                + ", typeOfRequest=" + typeOfRequest
                + ", actionOfRequest=" + actionOfRequest
                + ", price=" + price
                + ", volume=" + volume
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id == request.id
                && Objects.equals(book, request.book)
                && typeOfRequest == request.typeOfRequest
                && actionOfRequest == request.actionOfRequest;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, book, typeOfRequest, actionOfRequest);
    }

    /**
     * Action of Request.
     */
    public enum Action {
        /**
         * Bid for buying.
         */
        BID,

        /**
         * Ask for buying.
         */
        ASK
    }

    /**
     * Type of Request.
     */
    public enum Type {
        /**
         * Add request.
         */
        ADD,

        /**
         * Delete request.
         */
        DELETE
    }

}