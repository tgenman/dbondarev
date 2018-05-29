package ru.job4j.exchange;

import java.util.HashMap;
import java.util.Map;

/**
 * Modellig Exchange Market.
 */
public class ExchangeMarket {

    private final Map<String, MarketDepth> marketDepths = new HashMap<>();

    /**
     * Add request for cell or buy stocks.
     * @param book name of a company
     * @param actionOfRequest bid or ask
     * @param price for deal
     * @param volume for deal
     * @return int id
     */
    public int addRequest(final String book,
                          final Request.Action actionOfRequest,
                          final int price,
                          final int volume) {
        Request buffer = new Request(book, Request.Type.ADD, actionOfRequest, price, volume);
        if (marketDepths.containsKey(book)) {
            marketDepths.get(book).addRequest(buffer);
        } else {
            createNewMarketDepth(book).addRequest(buffer);
        }
        return buffer.getId();
    }

    /**
     * Delete request for cell or buy stocks.
     * @param id of request for deleting
     * @param book name of a company
     * @param actionOfRequest bid or ask
     * @return boolean of result (true if find and delete)
     */
    public boolean deleteRequest(final int id,
                                 final String book,
                                 final Request.Action actionOfRequest) {
        boolean result = false;
        if (marketDepths.containsKey(book)) {
            Request buffer = new Request(id, book, Request.Type.DELETE, actionOfRequest);
            result = marketDepths.get(book).removeRequest(buffer);
        }
        return result;
    }

    /**
     * Number of companies in the market.
     * @return int number.
     */
    public int getNumberMarketDepths() {
        return this.marketDepths.size();
    }

    /**
     * Get Market by name.
     * @param book name of company
     * @return Market Depth.
     */
    public MarketDepth getMarketDepths(final String book) {
        return this.marketDepths.get(book);
    }

    private MarketDepth createNewMarketDepth(final String book) {
        MarketDepth newMarketDepthByBook = new MarketDepth(book);
        marketDepths.put(book, newMarketDepthByBook);
        return newMarketDepthByBook;
    }


}
