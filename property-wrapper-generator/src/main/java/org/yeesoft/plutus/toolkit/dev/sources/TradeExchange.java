package org.yeesoft.plutus.toolkit.dev.sources;

public class TradeExchange {
	private String brokerID;
	private String investorID;
	private String instrumentID;
	private String orderRef;
	private String userID;
	private String exchangeID;
	private String tradeID;
	private String direction;
	private String orderSysID;
	private String participantID;
	private String clientID;
	private String tradingRole;
	private String exchangeInstID;
	private String offsetFlag;
	private String hedgeFlag;
	private double price;
	private int volume;
	private String tradeDate;
	private String tradeTime;
	private String tradeType;
	private String priceSource;
	private String traderID;
	private String orderLocalID;
	private String clearingPartID;
	private String businessUnit;
	private int sequenceNo;
	private String tradingDay;
	private int settlementID;
	private int brokerOrderSeq;
	private String tradeSource;

	public String getBrokerID() {
		return this.brokerID;
	}

	public void setBrokerID(String brokerID) {
		this.brokerID = brokerID;
	}

	public String getInvestorID() {
		return this.investorID;
	}

	public void setInvestorID(String investorID) {
		this.investorID = investorID;
	}

	public String getInstrumentID() {
		return this.instrumentID;
	}

	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}

	public String getOrderRef() {
		return this.orderRef;
	}

	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getExchangeID() {
		return this.exchangeID;
	}

	public void setExchangeID(String exchangeID) {
		this.exchangeID = exchangeID;
	}

	public String getTradeID() {
		return this.tradeID;
	}

	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getOrderSysID() {
		return this.orderSysID;
	}

	public void setOrderSysID(String orderSysID) {
		this.orderSysID = orderSysID;
	}

	public String getParticipantID() {
		return this.participantID;
	}

	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}

	public String getClientID() {
		return this.clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getTradingRole() {
		return this.tradingRole;
	}

	public void setTradingRole(String tradingRole) {
		this.tradingRole = tradingRole;
	}

	public String getExchangeInstID() {
		return this.exchangeInstID;
	}

	public void setExchangeInstID(String exchangeInstID) {
		this.exchangeInstID = exchangeInstID;
	}

	public String getOffsetFlag() {
		return this.offsetFlag;
	}

	public void setOffsetFlag(String offsetFlag) {
		this.offsetFlag = offsetFlag;
	}

	public String getHedgeFlag() {
		return this.hedgeFlag;
	}

	public void setHedgeFlag(String hedgeFlag) {
		this.hedgeFlag = hedgeFlag;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getTradeDate() {
		return this.tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getTradeTime() {
		return this.tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getTradeType() {
		return this.tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getPriceSource() {
		return this.priceSource;
	}

	public void setPriceSource(String priceSource) {
		this.priceSource = priceSource;
	}

	public String getTraderID() {
		return this.traderID;
	}

	public void setTraderID(String traderID) {
		this.traderID = traderID;
	}

	public String getOrderLocalID() {
		return this.orderLocalID;
	}

	public void setOrderLocalID(String orderLocalID) {
		this.orderLocalID = orderLocalID;
	}

	public String getClearingPartID() {
		return this.clearingPartID;
	}

	public void setClearingPartID(String clearingPartID) {
		this.clearingPartID = clearingPartID;
	}

	public String getBusinessUnit() {
		return this.businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public int getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getTradingDay() {
		return this.tradingDay;
	}

	public void setTradingDay(String tradingDay) {
		this.tradingDay = tradingDay;
	}

	public int getSettlementID() {
		return this.settlementID;
	}

	public void setSettlementID(int settlementID) {
		this.settlementID = settlementID;
	}

	public int getBrokerOrderSeq() {
		return this.brokerOrderSeq;
	}

	public void setBrokerOrderSeq(int brokerOrderSeq) {
		this.brokerOrderSeq = brokerOrderSeq;
	}

	public String getTradeSource() {
		return this.tradeSource;
	}

	public void setTradeSource(String tradeSource) {
		this.tradeSource = tradeSource;
	}

	public static TradeExchange from(Trade trade) {
		TradeExchange tradeExchange = new TradeExchange();
		tradeExchange.setBrokerID(trade.getBrokerID());
		tradeExchange.setInvestorID(trade.getInvestorID());
		tradeExchange.setInstrumentID(trade.getInstrumentID());
		tradeExchange.setOrderRef(trade.getOrderRef());
		tradeExchange.setUserID(trade.getUserID());
		tradeExchange.setExchangeID(trade.getExchangeID());
		tradeExchange.setTradeID(trade.getTradeID());
		tradeExchange.setDirection(trade.getDirection());
		tradeExchange.setOrderSysID(trade.getOrderSysID());
		tradeExchange.setParticipantID(trade.getParticipantID());
		tradeExchange.setClientID(trade.getClientID());
		tradeExchange.setTradingRole(trade.getTradingRole());
		tradeExchange.setExchangeInstID(trade.getExchangeInstID());
		tradeExchange.setOffsetFlag(trade.getOffsetFlag());
		tradeExchange.setHedgeFlag(trade.getHedgeFlag());
		tradeExchange.setPrice(trade.getPrice());
		tradeExchange.setVolume(trade.getVolume());
		tradeExchange.setTradeDate(trade.getTradeDate());
		tradeExchange.setTradeTime(trade.getTradeTime());
		tradeExchange.setTradeType(trade.getTradeType());
		tradeExchange.setPriceSource(trade.getPriceSource());
		tradeExchange.setTraderID(trade.getTraderID());
		tradeExchange.setOrderLocalID(trade.getOrderLocalID());
		tradeExchange.setClearingPartID(trade.getClearingPartID());
		tradeExchange.setBusinessUnit(trade.getBusinessUnit());
		tradeExchange.setSequenceNo(trade.getSequenceNo());
		tradeExchange.setTradingDay(trade.getTradingDay());
		tradeExchange.setSettlementID(trade.getSettlementID());
		tradeExchange.setBrokerOrderSeq(trade.getBrokerOrderSeq());
		tradeExchange.setTradeSource(trade.getTradeSource());
		return tradeExchange;
	}
}
