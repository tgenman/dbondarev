package ru.job4j.exchange;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test ExchangeMarket class.
 */
public class ExchangeMarketTest {

    @Test
    public void testWhenAddsRequestThenRequestAddsAndCreateNewMarketDepth() {
        ExchangeMarket testInstance = new ExchangeMarket();

        testInstance.addRequest("MIT", Request.Action.ASK, 100, 10);
        testInstance.addRequest("MIT", Request.Action.BID, 900, 10);

        assertEquals(1, testInstance.getNumberMarketDepths());
    }

    @Test
    public void testWhenDeleteRequestThenRequesDeleted() {
        ExchangeMarket testInstance = new ExchangeMarket();

        testInstance.addRequest("MIT", Request.Action.ASK, 100, 10);
        testInstance.addRequest("MIT", Request.Action.BID, 900, 10);
        int idOne = testInstance.addRequest("MIT", Request.Action.ASK, 120, 10);
        int idTwo = testInstance.addRequest("MIT", Request.Action.BID, 910, 10);

        assertEquals(4, testInstance.getMarketDepths().get(0).getSizeOfMarketDepth());
        assertEquals(2, testInstance.getMarketDepths().get(0).getAskSet().size());
        assertEquals(2, testInstance.getMarketDepths().get(0).getBidSet().size());

        testInstance.deleteRequest(idOne, "MIT", Request.Action.ASK);
        testInstance.deleteRequest(idTwo, "MIT", Request.Action.BID);

        assertEquals(2, testInstance.getMarketDepths().get(0).getSizeOfMarketDepth());
        assertEquals(1, testInstance.getMarketDepths().get(0).getAskSet().size());
        assertEquals(1, testInstance.getMarketDepths().get(0).getBidSet().size());
    }

    @Test
    public void testWhenAddAppropriateAskRequestBiggerBid() {
        ExchangeMarket testInstance = new ExchangeMarket();

        testInstance.addRequest("MIT", Request.Action.BID, 90, 10);
        testInstance.addRequest("MIT", Request.Action.BID, 105, 10);

        assertEquals(2, testInstance.getMarketDepths().get(0).getSizeOfMarketDepth());
        assertEquals(2, testInstance.getMarketDepths().get(0).getBidSet().size());

        testInstance.addRequest("MIT", Request.Action.ASK, 100, 25);

        assertEquals(2, testInstance.getMarketDepths().get(0).getSizeOfMarketDepth());
        assertEquals(1, testInstance.getMarketDepths().get(0).getBidSet().size());
        assertEquals(1, testInstance.getMarketDepths().get(0).getAskSet().size());
    }

    @Test
    public void testWhenAddAppropriateAskRequestLowerBid() {
        ExchangeMarket testInstance = new ExchangeMarket();

        testInstance.addRequest("MIT", Request.Action.BID, 90, 25);
        testInstance.addRequest("MIT", Request.Action.BID, 105, 25);

        assertEquals(2, testInstance.getMarketDepths().get(0).getSizeOfMarketDepth());
        assertEquals(2, testInstance.getMarketDepths().get(0).getBidSet().size());

        testInstance.addRequest("MIT", Request.Action.ASK, 100, 10);

        assertEquals(2, testInstance.getMarketDepths().get(0).getSizeOfMarketDepth());
        assertEquals(2, testInstance.getMarketDepths().get(0).getBidSet().size());
        assertEquals(0, testInstance.getMarketDepths().get(0).getAskSet().size());
    }

    @Test
    public void testWhenAddAppropriateBidRequestBiggerAsk() {
        ExchangeMarket testInstance = new ExchangeMarket();

        testInstance.addRequest("MIT", Request.Action.ASK, 90, 25);
        testInstance.addRequest("MIT", Request.Action.ASK, 105, 10);

        assertEquals(2, testInstance.getMarketDepths().get(0).getSizeOfMarketDepth());
        assertEquals(2, testInstance.getMarketDepths().get(0).getAskSet().size());

        testInstance.addRequest("MIT", Request.Action.BID, 100, 25);

        assertEquals(2, testInstance.getMarketDepths().get(0).getSizeOfMarketDepth());
        assertEquals(1, testInstance.getMarketDepths().get(0).getBidSet().size());
        assertEquals(1, testInstance.getMarketDepths().get(0).getAskSet().size());
    }

    @Test
    public void testWhenAddAppropriateBidRequestLowerAsk() {
        ExchangeMarket testInstance = new ExchangeMarket();

        testInstance.addRequest("MIT", Request.Action.ASK, 90, 25);
        testInstance.addRequest("MIT", Request.Action.ASK, 105, 25);

        assertEquals(2, testInstance.getMarketDepths().get(0).getSizeOfMarketDepth());
        assertEquals(2, testInstance.getMarketDepths().get(0).getAskSet().size());

        testInstance.addRequest("MIT", Request.Action.BID, 100, 10);

        assertEquals(2, testInstance.getMarketDepths().get(0).getSizeOfMarketDepth());
        assertEquals(0, testInstance.getMarketDepths().get(0).getBidSet().size());
        assertEquals(2, testInstance.getMarketDepths().get(0).getAskSet().size());
    }

    @Test
    public void testWhenAddDifferentMarketDepthsAndExchangeMarketCreateThem() {
        ExchangeMarket testInstance = new ExchangeMarket();

        testInstance.addRequest("MIT", Request.Action.ASK, 90, 25);
        testInstance.addRequest("Harvard", Request.Action.ASK, 105, 25);

        assertEquals(2, testInstance.getMarketDepths().size());
    }
}