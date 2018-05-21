package ru.job4j.exchange;

import java.util.Set;
import java.util.TreeSet;

/**
 * Heap of requests 0f one company.
 */
public class MarketDepth {

    private final String name;

    private final Set<Request> bidSet;

    private final Set<Request> askSet;

    /**
     * Constructor with name of company.
     * @param name of company
     */
    MarketDepth(String name) {
        this.name = name;
        this.bidSet =  new TreeSet<>();
        this.askSet = new TreeSet<>();
    }

    /**
     * Add request.
     * @param request request
     */
    void addRequest(final Request request) {
        if (request.getActionOfRequest() == Request.Action.BID) {
            this.addRequestToBidSet(request);
        } else {
            this.addRequestToAskSet(request);
        }
    }

    /**
     * Remove request.
     * @param request request
     * @return true if request has been deleted
     */
    boolean removeRequest(final Request request) {
        boolean result = false;
        Request buffer = null;
        if (request.getActionOfRequest() == Request.Action.BID) {
            for (Request current : this.bidSet) {
                if (current.getId() == request.getId()) {
                    buffer = current;
                }
            }
            if (buffer != null) {
                result = bidSet.remove(buffer);
            }
        } else {
            for (Request current : this.askSet) {
                if (current.getId() == request.getId()) {
                    buffer = current;
                }
            }
            if (buffer != null) {
                result = askSet.remove(buffer);
            }
        }
        return result;
    }

    /**
     * Getter for name of Market Depth.
     * @return name
     */
    String getName() {
        return name;
    }

    /**
     * Getter for set of bid.
     * @return set of bid
     */
    Set<Request> getBidSet() {
        return this.bidSet;
    }

    /**
     * Getter for set of ask.
     * @return set of ask
     */
    Set<Request> getAskSet() {
        return this.askSet;
    }

    /**
     * Getter amount of requests in the Market Depth.
     * @return int
     */
    int getSizeOfMarketDepth() {
        return this.askSet.size() + this.bidSet.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getName()).append("\n")
                .append("for sale | price | for buy").append("\n");
        for (Request current : this.bidSet) {
            stringBuilder.append(String.format("   %d    |  %d  |  \n", current.getVolume(), current.getPrice()));
        }
        for (Request current : this.askSet) {
            stringBuilder.append(String.format("         |  %d  | %d \n", current.getPrice(), current.getVolume()));
        }
        return stringBuilder.toString();
    }

    private void addRequestToBidSet(final Request request) {
        for (Request currentAskRequest : this.askSet) {
            if (request.getPrice() <= currentAskRequest.getPrice()) {
                request.setVolume(
                        request.getVolume() - amountOfDeal(request, currentAskRequest));
                currentAskRequest.setVolume(
                        currentAskRequest.getVolume() - amountOfDeal(request, currentAskRequest));

                if (currentAskRequest.getVolume() == 0)  {
                    this.askSet.remove(currentAskRequest);
                }
                break;
            }
        }
        if (request.getVolume() > 0) {
            this.bidSet.add(request);
        }

    }

    private void addRequestToAskSet(final Request request) {
        for (Request currentBidRequest : this.bidSet) {
            if (request.getPrice() >= currentBidRequest.getPrice()) {
                int amountOfDeal = amountOfDeal(request, currentBidRequest);
                request.setVolume(
                        request.getVolume() - amountOfDeal);
                currentBidRequest.setVolume(
                        currentBidRequest.getVolume() - amountOfDeal);
                if (currentBidRequest.getVolume() == 0)  {
                    this.bidSet.remove(currentBidRequest);
                }
                break;
            }
        }
        if (request.getVolume() > 0) {
            this.askSet.add(request);
        }
    }

    private int amountOfDeal(final Request forAdd, final Request current) {
        if (forAdd.getVolume() >= current.getVolume()) {
            return current.getVolume();
        } else {
            return forAdd.getVolume();
        }
    }
}
