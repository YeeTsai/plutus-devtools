package org.yeesoft.plutus.toolkit.dev.sources;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
public class DepthMarketDataExchangeProperty implements Comparable<DepthMarketDataExchangeProperty> {
	private final SimpleStringProperty tradingDay;
	private final SimpleStringProperty instrumentID;
	private final SimpleStringProperty exchangeID;
	private final SimpleStringProperty exchangeInstID;
	private final SimpleDoubleProperty lastPrice;
	private final SimpleDoubleProperty preSettlementPrice;
	private final SimpleDoubleProperty preClosePrice;
	private final SimpleDoubleProperty preOpenInterest;
	private final SimpleDoubleProperty openPrice;
	private final SimpleDoubleProperty highestPrice;
	private final SimpleDoubleProperty lowestPrice;
	private final SimpleIntegerProperty volume;
	private final SimpleDoubleProperty turnover;
	private final SimpleDoubleProperty openInterest;
	private final SimpleDoubleProperty closePrice;
	private final SimpleDoubleProperty settlementPrice;
	private final SimpleDoubleProperty upperLimitPrice;
	private final SimpleDoubleProperty lowerLimitPrice;
	private final SimpleDoubleProperty preDelta;
	private final SimpleDoubleProperty currDelta;
	private final SimpleStringProperty updateTime;
	private final SimpleIntegerProperty updateMillisec;
	private final SimpleDoubleProperty bidPrice1;
	private final SimpleIntegerProperty bidVolume1;
	private final SimpleDoubleProperty askPrice1;
	private final SimpleIntegerProperty askVolume1;
	private final SimpleDoubleProperty bidPrice2;
	private final SimpleIntegerProperty bidVolume2;
	private final SimpleDoubleProperty askPrice2;
	private final SimpleIntegerProperty askVolume2;
	private final SimpleDoubleProperty bidPrice3;
	private final SimpleIntegerProperty bidVolume3;
	private final SimpleDoubleProperty askPrice3;
	private final SimpleIntegerProperty askVolume3;
	private final SimpleDoubleProperty bidPrice4;
	private final SimpleIntegerProperty bidVolume4;
	private final SimpleDoubleProperty askPrice4;
	private final SimpleIntegerProperty askVolume4;
	private final SimpleDoubleProperty bidPrice5;
	private final SimpleIntegerProperty bidVolume5;
	private final SimpleDoubleProperty askPrice5;
	private final SimpleIntegerProperty askVolume5;
	private final SimpleDoubleProperty averagePrice;
	private final SimpleStringProperty actionDay;
	public static Map<String, String> buildColumnMap() {
		Map<String, String> map = new  LinkedHashMap<String, String>();
		map.put("tradingDay", "tradingDay");
		map.put("instrumentID", "instrumentID");
		map.put("exchangeID", "exchangeID");
		map.put("exchangeInstID", "exchangeInstID");
		map.put("lastPrice", "lastPrice");
		map.put("preSettlementPrice", "preSettlementPrice");
		map.put("preClosePrice", "preClosePrice");
		map.put("preOpenInterest", "preOpenInterest");
		map.put("openPrice", "openPrice");
		map.put("highestPrice", "highestPrice");
		map.put("lowestPrice", "lowestPrice");
		map.put("volume", "volume");
		map.put("turnover", "turnover");
		map.put("openInterest", "openInterest");
		map.put("closePrice", "closePrice");
		map.put("settlementPrice", "settlementPrice");
		map.put("upperLimitPrice", "upperLimitPrice");
		map.put("lowerLimitPrice", "lowerLimitPrice");
		map.put("preDelta", "preDelta");
		map.put("currDelta", "currDelta");
		map.put("updateTime", "updateTime");
		map.put("updateMillisec", "updateMillisec");
		map.put("bidPrice1", "bidPrice1");
		map.put("bidVolume1", "bidVolume1");
		map.put("askPrice1", "askPrice1");
		map.put("askVolume1", "askVolume1");
		map.put("bidPrice2", "bidPrice2");
		map.put("bidVolume2", "bidVolume2");
		map.put("askPrice2", "askPrice2");
		map.put("askVolume2", "askVolume2");
		map.put("bidPrice3", "bidPrice3");
		map.put("bidVolume3", "bidVolume3");
		map.put("askPrice3", "askPrice3");
		map.put("askVolume3", "askVolume3");
		map.put("bidPrice4", "bidPrice4");
		map.put("bidVolume4", "bidVolume4");
		map.put("askPrice4", "askPrice4");
		map.put("askVolume4", "askVolume4");
		map.put("bidPrice5", "bidPrice5");
		map.put("bidVolume5", "bidVolume5");
		map.put("askPrice5", "askPrice5");
		map.put("askVolume5", "askVolume5");
		map.put("averagePrice", "averagePrice");
		map.put("actionDay", "actionDay");
		return map;
	}

	public static String hashMapKey(DepthMarketDataExchange depthMarketDataExchange) {
		StringBuffer sb =  new StringBuffer();
		sb.append(depthMarketDataExchange.getInstrumentID());
		return sb.toString();
	}

	public static String hashMapKey(DepthMarketDataExchangeProperty depthMarketDataExchangeProperty) {
		StringBuffer sb =  new StringBuffer();
		sb.append(depthMarketDataExchangeProperty.getInstrumentID());
		return sb.toString();
	}
	public DepthMarketDataExchangeProperty(DepthMarketDataExchange depthMarketDataExchange) {
		tradingDay = new SimpleStringProperty(depthMarketDataExchange.getTradingDay());
		instrumentID = new SimpleStringProperty(depthMarketDataExchange.getInstrumentID());
		exchangeID = new SimpleStringProperty(depthMarketDataExchange.getExchangeID());
		exchangeInstID = new SimpleStringProperty(depthMarketDataExchange.getExchangeInstID());
		lastPrice = new SimpleDoubleProperty(depthMarketDataExchange.getLastPrice());
		preSettlementPrice = new SimpleDoubleProperty(depthMarketDataExchange.getPreSettlementPrice());
		preClosePrice = new SimpleDoubleProperty(depthMarketDataExchange.getPreClosePrice());
		preOpenInterest = new SimpleDoubleProperty(depthMarketDataExchange.getPreOpenInterest());
		openPrice = new SimpleDoubleProperty(depthMarketDataExchange.getOpenPrice());
		highestPrice = new SimpleDoubleProperty(depthMarketDataExchange.getHighestPrice());
		lowestPrice = new SimpleDoubleProperty(depthMarketDataExchange.getLowestPrice());
		volume = new SimpleIntegerProperty(depthMarketDataExchange.getVolume());
		turnover = new SimpleDoubleProperty(depthMarketDataExchange.getTurnover());
		openInterest = new SimpleDoubleProperty(depthMarketDataExchange.getOpenInterest());
		closePrice = new SimpleDoubleProperty(depthMarketDataExchange.getClosePrice());
		settlementPrice = new SimpleDoubleProperty(depthMarketDataExchange.getSettlementPrice());
		upperLimitPrice = new SimpleDoubleProperty(depthMarketDataExchange.getUpperLimitPrice());
		lowerLimitPrice = new SimpleDoubleProperty(depthMarketDataExchange.getLowerLimitPrice());
		preDelta = new SimpleDoubleProperty(depthMarketDataExchange.getPreDelta());
		currDelta = new SimpleDoubleProperty(depthMarketDataExchange.getCurrDelta());
		updateTime = new SimpleStringProperty(depthMarketDataExchange.getUpdateTime());
		updateMillisec = new SimpleIntegerProperty(depthMarketDataExchange.getUpdateMillisec());
		bidPrice1 = new SimpleDoubleProperty(depthMarketDataExchange.getBidPrice1());
		bidVolume1 = new SimpleIntegerProperty(depthMarketDataExchange.getBidVolume1());
		askPrice1 = new SimpleDoubleProperty(depthMarketDataExchange.getAskPrice1());
		askVolume1 = new SimpleIntegerProperty(depthMarketDataExchange.getAskVolume1());
		bidPrice2 = new SimpleDoubleProperty(depthMarketDataExchange.getBidPrice2());
		bidVolume2 = new SimpleIntegerProperty(depthMarketDataExchange.getBidVolume2());
		askPrice2 = new SimpleDoubleProperty(depthMarketDataExchange.getAskPrice2());
		askVolume2 = new SimpleIntegerProperty(depthMarketDataExchange.getAskVolume2());
		bidPrice3 = new SimpleDoubleProperty(depthMarketDataExchange.getBidPrice3());
		bidVolume3 = new SimpleIntegerProperty(depthMarketDataExchange.getBidVolume3());
		askPrice3 = new SimpleDoubleProperty(depthMarketDataExchange.getAskPrice3());
		askVolume3 = new SimpleIntegerProperty(depthMarketDataExchange.getAskVolume3());
		bidPrice4 = new SimpleDoubleProperty(depthMarketDataExchange.getBidPrice4());
		bidVolume4 = new SimpleIntegerProperty(depthMarketDataExchange.getBidVolume4());
		askPrice4 = new SimpleDoubleProperty(depthMarketDataExchange.getAskPrice4());
		askVolume4 = new SimpleIntegerProperty(depthMarketDataExchange.getAskVolume4());
		bidPrice5 = new SimpleDoubleProperty(depthMarketDataExchange.getBidPrice5());
		bidVolume5 = new SimpleIntegerProperty(depthMarketDataExchange.getBidVolume5());
		askPrice5 = new SimpleDoubleProperty(depthMarketDataExchange.getAskPrice5());
		askVolume5 = new SimpleIntegerProperty(depthMarketDataExchange.getAskVolume5());
		averagePrice = new SimpleDoubleProperty(depthMarketDataExchange.getAveragePrice());
		actionDay = new SimpleStringProperty(depthMarketDataExchange.getActionDay());
	}

	public void update(DepthMarketDataExchangeProperty o) { 
		setTradingDay(o.getTradingDay());
		setInstrumentID(o.getInstrumentID());
		setExchangeID(o.getExchangeID());
		setExchangeInstID(o.getExchangeInstID());
		setLastPrice(o.getLastPrice());
		setPreSettlementPrice(o.getPreSettlementPrice());
		setPreClosePrice(o.getPreClosePrice());
		setPreOpenInterest(o.getPreOpenInterest());
		setOpenPrice(o.getOpenPrice());
		setHighestPrice(o.getHighestPrice());
		setLowestPrice(o.getLowestPrice());
		setVolume(o.getVolume());
		setTurnover(o.getTurnover());
		setOpenInterest(o.getOpenInterest());
		setClosePrice(o.getClosePrice());
		setSettlementPrice(o.getSettlementPrice());
		setUpperLimitPrice(o.getUpperLimitPrice());
		setLowerLimitPrice(o.getLowerLimitPrice());
		setPreDelta(o.getPreDelta());
		setCurrDelta(o.getCurrDelta());
		setUpdateTime(o.getUpdateTime());
		setUpdateMillisec(o.getUpdateMillisec());
		setBidPrice1(o.getBidPrice1());
		setBidVolume1(o.getBidVolume1());
		setAskPrice1(o.getAskPrice1());
		setAskVolume1(o.getAskVolume1());
		setBidPrice2(o.getBidPrice2());
		setBidVolume2(o.getBidVolume2());
		setAskPrice2(o.getAskPrice2());
		setAskVolume2(o.getAskVolume2());
		setBidPrice3(o.getBidPrice3());
		setBidVolume3(o.getBidVolume3());
		setAskPrice3(o.getAskPrice3());
		setAskVolume3(o.getAskVolume3());
		setBidPrice4(o.getBidPrice4());
		setBidVolume4(o.getBidVolume4());
		setAskPrice4(o.getAskPrice4());
		setAskVolume4(o.getAskVolume4());
		setBidPrice5(o.getBidPrice5());
		setBidVolume5(o.getBidVolume5());
		setAskPrice5(o.getAskPrice5());
		setAskVolume5(o.getAskVolume5());
		setAveragePrice(o.getAveragePrice());
		setActionDay(o.getActionDay());
	}

	public void update(DepthMarketDataExchange o) { 
		setTradingDay(o.getTradingDay());
		setInstrumentID(o.getInstrumentID());
		setExchangeID(o.getExchangeID());
		setExchangeInstID(o.getExchangeInstID());
		setLastPrice(o.getLastPrice());
		setPreSettlementPrice(o.getPreSettlementPrice());
		setPreClosePrice(o.getPreClosePrice());
		setPreOpenInterest(o.getPreOpenInterest());
		setOpenPrice(o.getOpenPrice());
		setHighestPrice(o.getHighestPrice());
		setLowestPrice(o.getLowestPrice());
		setVolume(o.getVolume());
		setTurnover(o.getTurnover());
		setOpenInterest(o.getOpenInterest());
		setClosePrice(o.getClosePrice());
		setSettlementPrice(o.getSettlementPrice());
		setUpperLimitPrice(o.getUpperLimitPrice());
		setLowerLimitPrice(o.getLowerLimitPrice());
		setPreDelta(o.getPreDelta());
		setCurrDelta(o.getCurrDelta());
		setUpdateTime(o.getUpdateTime());
		setUpdateMillisec(o.getUpdateMillisec());
		setBidPrice1(o.getBidPrice1());
		setBidVolume1(o.getBidVolume1());
		setAskPrice1(o.getAskPrice1());
		setAskVolume1(o.getAskVolume1());
		setBidPrice2(o.getBidPrice2());
		setBidVolume2(o.getBidVolume2());
		setAskPrice2(o.getAskPrice2());
		setAskVolume2(o.getAskVolume2());
		setBidPrice3(o.getBidPrice3());
		setBidVolume3(o.getBidVolume3());
		setAskPrice3(o.getAskPrice3());
		setAskVolume3(o.getAskVolume3());
		setBidPrice4(o.getBidPrice4());
		setBidVolume4(o.getBidVolume4());
		setAskPrice4(o.getAskPrice4());
		setAskVolume4(o.getAskVolume4());
		setBidPrice5(o.getBidPrice5());
		setBidVolume5(o.getBidVolume5());
		setAskPrice5(o.getAskPrice5());
		setAskVolume5(o.getAskVolume5());
		setAveragePrice(o.getAveragePrice());
		setActionDay(o.getActionDay());
	}

	public SimpleStringProperty tradingDayProperty() {
		return tradingDay;
	}
	public String getTradingDay() {
		return tradingDay.get();
	}

	public void setTradingDay(String tradingDay) {
		this.tradingDay.set(tradingDay);
	}

	public SimpleStringProperty instrumentIDProperty() {
		return instrumentID;
	}
	public String getInstrumentID() {
		return instrumentID.get();
	}

	public void setInstrumentID(String instrumentID) {
		this.instrumentID.set(instrumentID);
	}

	public SimpleStringProperty exchangeIDProperty() {
		return exchangeID;
	}
	public String getExchangeID() {
		return exchangeID.get();
	}

	public void setExchangeID(String exchangeID) {
		this.exchangeID.set(exchangeID);
	}

	public SimpleStringProperty exchangeInstIDProperty() {
		return exchangeInstID;
	}
	public String getExchangeInstID() {
		return exchangeInstID.get();
	}

	public void setExchangeInstID(String exchangeInstID) {
		this.exchangeInstID.set(exchangeInstID);
	}

	public SimpleDoubleProperty lastPriceProperty() {
		return lastPrice;
	}
	public double getLastPrice() {
		return lastPrice.get();
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice.set(lastPrice);
	}

	public SimpleDoubleProperty preSettlementPriceProperty() {
		return preSettlementPrice;
	}
	public double getPreSettlementPrice() {
		return preSettlementPrice.get();
	}

	public void setPreSettlementPrice(double preSettlementPrice) {
		this.preSettlementPrice.set(preSettlementPrice);
	}

	public SimpleDoubleProperty preClosePriceProperty() {
		return preClosePrice;
	}
	public double getPreClosePrice() {
		return preClosePrice.get();
	}

	public void setPreClosePrice(double preClosePrice) {
		this.preClosePrice.set(preClosePrice);
	}

	public SimpleDoubleProperty preOpenInterestProperty() {
		return preOpenInterest;
	}
	public double getPreOpenInterest() {
		return preOpenInterest.get();
	}

	public void setPreOpenInterest(double preOpenInterest) {
		this.preOpenInterest.set(preOpenInterest);
	}

	public SimpleDoubleProperty openPriceProperty() {
		return openPrice;
	}
	public double getOpenPrice() {
		return openPrice.get();
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice.set(openPrice);
	}

	public SimpleDoubleProperty highestPriceProperty() {
		return highestPrice;
	}
	public double getHighestPrice() {
		return highestPrice.get();
	}

	public void setHighestPrice(double highestPrice) {
		this.highestPrice.set(highestPrice);
	}

	public SimpleDoubleProperty lowestPriceProperty() {
		return lowestPrice;
	}
	public double getLowestPrice() {
		return lowestPrice.get();
	}

	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice.set(lowestPrice);
	}

	public SimpleIntegerProperty volumeProperty() {
		return volume;
	}
	public int getVolume() {
		return volume.get();
	}

	public void setVolume(int volume) {
		this.volume.set(volume);
	}

	public SimpleDoubleProperty turnoverProperty() {
		return turnover;
	}
	public double getTurnover() {
		return turnover.get();
	}

	public void setTurnover(double turnover) {
		this.turnover.set(turnover);
	}

	public SimpleDoubleProperty openInterestProperty() {
		return openInterest;
	}
	public double getOpenInterest() {
		return openInterest.get();
	}

	public void setOpenInterest(double openInterest) {
		this.openInterest.set(openInterest);
	}

	public SimpleDoubleProperty closePriceProperty() {
		return closePrice;
	}
	public double getClosePrice() {
		return closePrice.get();
	}

	public void setClosePrice(double closePrice) {
		this.closePrice.set(closePrice);
	}

	public SimpleDoubleProperty settlementPriceProperty() {
		return settlementPrice;
	}
	public double getSettlementPrice() {
		return settlementPrice.get();
	}

	public void setSettlementPrice(double settlementPrice) {
		this.settlementPrice.set(settlementPrice);
	}

	public SimpleDoubleProperty upperLimitPriceProperty() {
		return upperLimitPrice;
	}
	public double getUpperLimitPrice() {
		return upperLimitPrice.get();
	}

	public void setUpperLimitPrice(double upperLimitPrice) {
		this.upperLimitPrice.set(upperLimitPrice);
	}

	public SimpleDoubleProperty lowerLimitPriceProperty() {
		return lowerLimitPrice;
	}
	public double getLowerLimitPrice() {
		return lowerLimitPrice.get();
	}

	public void setLowerLimitPrice(double lowerLimitPrice) {
		this.lowerLimitPrice.set(lowerLimitPrice);
	}

	public SimpleDoubleProperty preDeltaProperty() {
		return preDelta;
	}
	public double getPreDelta() {
		return preDelta.get();
	}

	public void setPreDelta(double preDelta) {
		this.preDelta.set(preDelta);
	}

	public SimpleDoubleProperty currDeltaProperty() {
		return currDelta;
	}
	public double getCurrDelta() {
		return currDelta.get();
	}

	public void setCurrDelta(double currDelta) {
		this.currDelta.set(currDelta);
	}

	public SimpleStringProperty updateTimeProperty() {
		return updateTime;
	}
	public String getUpdateTime() {
		return updateTime.get();
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime.set(updateTime);
	}

	public SimpleIntegerProperty updateMillisecProperty() {
		return updateMillisec;
	}
	public int getUpdateMillisec() {
		return updateMillisec.get();
	}

	public void setUpdateMillisec(int updateMillisec) {
		this.updateMillisec.set(updateMillisec);
	}

	public SimpleDoubleProperty bidPrice1Property() {
		return bidPrice1;
	}
	public double getBidPrice1() {
		return bidPrice1.get();
	}

	public void setBidPrice1(double bidPrice1) {
		this.bidPrice1.set(bidPrice1);
	}

	public SimpleIntegerProperty bidVolume1Property() {
		return bidVolume1;
	}
	public int getBidVolume1() {
		return bidVolume1.get();
	}

	public void setBidVolume1(int bidVolume1) {
		this.bidVolume1.set(bidVolume1);
	}

	public SimpleDoubleProperty askPrice1Property() {
		return askPrice1;
	}
	public double getAskPrice1() {
		return askPrice1.get();
	}

	public void setAskPrice1(double askPrice1) {
		this.askPrice1.set(askPrice1);
	}

	public SimpleIntegerProperty askVolume1Property() {
		return askVolume1;
	}
	public int getAskVolume1() {
		return askVolume1.get();
	}

	public void setAskVolume1(int askVolume1) {
		this.askVolume1.set(askVolume1);
	}

	public SimpleDoubleProperty bidPrice2Property() {
		return bidPrice2;
	}
	public double getBidPrice2() {
		return bidPrice2.get();
	}

	public void setBidPrice2(double bidPrice2) {
		this.bidPrice2.set(bidPrice2);
	}

	public SimpleIntegerProperty bidVolume2Property() {
		return bidVolume2;
	}
	public int getBidVolume2() {
		return bidVolume2.get();
	}

	public void setBidVolume2(int bidVolume2) {
		this.bidVolume2.set(bidVolume2);
	}

	public SimpleDoubleProperty askPrice2Property() {
		return askPrice2;
	}
	public double getAskPrice2() {
		return askPrice2.get();
	}

	public void setAskPrice2(double askPrice2) {
		this.askPrice2.set(askPrice2);
	}

	public SimpleIntegerProperty askVolume2Property() {
		return askVolume2;
	}
	public int getAskVolume2() {
		return askVolume2.get();
	}

	public void setAskVolume2(int askVolume2) {
		this.askVolume2.set(askVolume2);
	}

	public SimpleDoubleProperty bidPrice3Property() {
		return bidPrice3;
	}
	public double getBidPrice3() {
		return bidPrice3.get();
	}

	public void setBidPrice3(double bidPrice3) {
		this.bidPrice3.set(bidPrice3);
	}

	public SimpleIntegerProperty bidVolume3Property() {
		return bidVolume3;
	}
	public int getBidVolume3() {
		return bidVolume3.get();
	}

	public void setBidVolume3(int bidVolume3) {
		this.bidVolume3.set(bidVolume3);
	}

	public SimpleDoubleProperty askPrice3Property() {
		return askPrice3;
	}
	public double getAskPrice3() {
		return askPrice3.get();
	}

	public void setAskPrice3(double askPrice3) {
		this.askPrice3.set(askPrice3);
	}

	public SimpleIntegerProperty askVolume3Property() {
		return askVolume3;
	}
	public int getAskVolume3() {
		return askVolume3.get();
	}

	public void setAskVolume3(int askVolume3) {
		this.askVolume3.set(askVolume3);
	}

	public SimpleDoubleProperty bidPrice4Property() {
		return bidPrice4;
	}
	public double getBidPrice4() {
		return bidPrice4.get();
	}

	public void setBidPrice4(double bidPrice4) {
		this.bidPrice4.set(bidPrice4);
	}

	public SimpleIntegerProperty bidVolume4Property() {
		return bidVolume4;
	}
	public int getBidVolume4() {
		return bidVolume4.get();
	}

	public void setBidVolume4(int bidVolume4) {
		this.bidVolume4.set(bidVolume4);
	}

	public SimpleDoubleProperty askPrice4Property() {
		return askPrice4;
	}
	public double getAskPrice4() {
		return askPrice4.get();
	}

	public void setAskPrice4(double askPrice4) {
		this.askPrice4.set(askPrice4);
	}

	public SimpleIntegerProperty askVolume4Property() {
		return askVolume4;
	}
	public int getAskVolume4() {
		return askVolume4.get();
	}

	public void setAskVolume4(int askVolume4) {
		this.askVolume4.set(askVolume4);
	}

	public SimpleDoubleProperty bidPrice5Property() {
		return bidPrice5;
	}
	public double getBidPrice5() {
		return bidPrice5.get();
	}

	public void setBidPrice5(double bidPrice5) {
		this.bidPrice5.set(bidPrice5);
	}

	public SimpleIntegerProperty bidVolume5Property() {
		return bidVolume5;
	}
	public int getBidVolume5() {
		return bidVolume5.get();
	}

	public void setBidVolume5(int bidVolume5) {
		this.bidVolume5.set(bidVolume5);
	}

	public SimpleDoubleProperty askPrice5Property() {
		return askPrice5;
	}
	public double getAskPrice5() {
		return askPrice5.get();
	}

	public void setAskPrice5(double askPrice5) {
		this.askPrice5.set(askPrice5);
	}

	public SimpleIntegerProperty askVolume5Property() {
		return askVolume5;
	}
	public int getAskVolume5() {
		return askVolume5.get();
	}

	public void setAskVolume5(int askVolume5) {
		this.askVolume5.set(askVolume5);
	}

	public SimpleDoubleProperty averagePriceProperty() {
		return averagePrice;
	}
	public double getAveragePrice() {
		return averagePrice.get();
	}

	public void setAveragePrice(double averagePrice) {
		this.averagePrice.set(averagePrice);
	}

	public SimpleStringProperty actionDayProperty() {
		return actionDay;
	}
	public String getActionDay() {
		return actionDay.get();
	}

	public void setActionDay(String actionDay) {
		this.actionDay.set(actionDay);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (obj.getClass() == DepthMarketDataExchangeProperty.class) {
			DepthMarketDataExchangeProperty s = (DepthMarketDataExchangeProperty)obj;
			return new EqualsBuilder()
					.append(this.getInstrumentID(), s.getInstrumentID())
					.isEquals();
		}
		return false;
	}

	@Override
	public int compareTo(DepthMarketDataExchangeProperty o) {
		return new CompareToBuilder()
				.append(this.getInstrumentID(), o.getInstrumentID())
				.toComparison();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getInstrumentID())
				.hashCode();
	}
}
