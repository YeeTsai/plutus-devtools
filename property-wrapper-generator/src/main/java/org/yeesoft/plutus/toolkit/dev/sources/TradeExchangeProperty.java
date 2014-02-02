package org.yeesoft.plutus.toolkit.dev.sources;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
public class TradeExchangeProperty implements Comparable<TradeExchangeProperty> {
	private final SimpleStringProperty brokerID;
	private final SimpleStringProperty investorID;
	private final SimpleStringProperty instrumentID;
	private final SimpleStringProperty orderRef;
	private final SimpleStringProperty userID;
	private final SimpleStringProperty exchangeID;
	private final SimpleStringProperty tradeID;
	private final SimpleStringProperty direction;
	private final SimpleStringProperty orderSysID;
	private final SimpleStringProperty participantID;
	private final SimpleStringProperty clientID;
	private final SimpleStringProperty tradingRole;
	private final SimpleStringProperty exchangeInstID;
	private final SimpleStringProperty offsetFlag;
	private final SimpleStringProperty hedgeFlag;
	private final SimpleDoubleProperty price;
	private final SimpleIntegerProperty volume;
	private final SimpleStringProperty tradeDate;
	private final SimpleStringProperty tradeTime;
	private final SimpleStringProperty tradeType;
	private final SimpleStringProperty priceSource;
	private final SimpleStringProperty traderID;
	private final SimpleStringProperty orderLocalID;
	private final SimpleStringProperty clearingPartID;
	private final SimpleStringProperty businessUnit;
	private final SimpleIntegerProperty sequenceNo;
	private final SimpleStringProperty tradingDay;
	private final SimpleIntegerProperty settlementID;
	private final SimpleIntegerProperty brokerOrderSeq;
	private final SimpleStringProperty tradeSource;
	public static Map<String, String> buildColumnMap() {
		Map<String, String> map = new  LinkedHashMap<String, String>();
		map.put("brokerID", "brokerID");
		map.put("investorID", "investorID");
		map.put("instrumentID", "instrumentID");
		map.put("orderRef", "orderRef");
		map.put("userID", "userID");
		map.put("exchangeID", "exchangeID");
		map.put("tradeID", "tradeID");
		map.put("direction", "direction");
		map.put("orderSysID", "orderSysID");
		map.put("participantID", "participantID");
		map.put("clientID", "clientID");
		map.put("tradingRole", "tradingRole");
		map.put("exchangeInstID", "exchangeInstID");
		map.put("offsetFlag", "offsetFlag");
		map.put("hedgeFlag", "hedgeFlag");
		map.put("price", "price");
		map.put("volume", "volume");
		map.put("tradeDate", "tradeDate");
		map.put("tradeTime", "tradeTime");
		map.put("tradeType", "tradeType");
		map.put("priceSource", "priceSource");
		map.put("traderID", "traderID");
		map.put("orderLocalID", "orderLocalID");
		map.put("clearingPartID", "clearingPartID");
		map.put("businessUnit", "businessUnit");
		map.put("sequenceNo", "sequenceNo");
		map.put("tradingDay", "tradingDay");
		map.put("settlementID", "settlementID");
		map.put("brokerOrderSeq", "brokerOrderSeq");
		map.put("tradeSource", "tradeSource");
		return map;
	}

	public static String hashMapKey(TradeExchange tradeExchange) {
		StringBuffer sb =  new StringBuffer();
		sb.append(tradeExchange.getOrderSysID());
		return sb.toString();
	}

	public static String hashMapKey(TradeExchangeProperty tradeExchangeProperty) {
		StringBuffer sb =  new StringBuffer();
		sb.append(tradeExchangeProperty.getOrderSysID());
		return sb.toString();
	}
	public TradeExchangeProperty(TradeExchange tradeExchange) {
		brokerID = new SimpleStringProperty(tradeExchange.getBrokerID());
		investorID = new SimpleStringProperty(tradeExchange.getInvestorID());
		instrumentID = new SimpleStringProperty(tradeExchange.getInstrumentID());
		orderRef = new SimpleStringProperty(tradeExchange.getOrderRef());
		userID = new SimpleStringProperty(tradeExchange.getUserID());
		exchangeID = new SimpleStringProperty(tradeExchange.getExchangeID());
		tradeID = new SimpleStringProperty(tradeExchange.getTradeID());
		direction = new SimpleStringProperty(tradeExchange.getDirection());
		orderSysID = new SimpleStringProperty(tradeExchange.getOrderSysID());
		participantID = new SimpleStringProperty(tradeExchange.getParticipantID());
		clientID = new SimpleStringProperty(tradeExchange.getClientID());
		tradingRole = new SimpleStringProperty(tradeExchange.getTradingRole());
		exchangeInstID = new SimpleStringProperty(tradeExchange.getExchangeInstID());
		offsetFlag = new SimpleStringProperty(tradeExchange.getOffsetFlag());
		hedgeFlag = new SimpleStringProperty(tradeExchange.getHedgeFlag());
		price = new SimpleDoubleProperty(tradeExchange.getPrice());
		volume = new SimpleIntegerProperty(tradeExchange.getVolume());
		tradeDate = new SimpleStringProperty(tradeExchange.getTradeDate());
		tradeTime = new SimpleStringProperty(tradeExchange.getTradeTime());
		tradeType = new SimpleStringProperty(tradeExchange.getTradeType());
		priceSource = new SimpleStringProperty(tradeExchange.getPriceSource());
		traderID = new SimpleStringProperty(tradeExchange.getTraderID());
		orderLocalID = new SimpleStringProperty(tradeExchange.getOrderLocalID());
		clearingPartID = new SimpleStringProperty(tradeExchange.getClearingPartID());
		businessUnit = new SimpleStringProperty(tradeExchange.getBusinessUnit());
		sequenceNo = new SimpleIntegerProperty(tradeExchange.getSequenceNo());
		tradingDay = new SimpleStringProperty(tradeExchange.getTradingDay());
		settlementID = new SimpleIntegerProperty(tradeExchange.getSettlementID());
		brokerOrderSeq = new SimpleIntegerProperty(tradeExchange.getBrokerOrderSeq());
		tradeSource = new SimpleStringProperty(tradeExchange.getTradeSource());
	}

	public void update(TradeExchangeProperty o) { 
		setBrokerID(o.getBrokerID());
		setInvestorID(o.getInvestorID());
		setInstrumentID(o.getInstrumentID());
		setOrderRef(o.getOrderRef());
		setUserID(o.getUserID());
		setExchangeID(o.getExchangeID());
		setTradeID(o.getTradeID());
		setDirection(o.getDirection());
		setOrderSysID(o.getOrderSysID());
		setParticipantID(o.getParticipantID());
		setClientID(o.getClientID());
		setTradingRole(o.getTradingRole());
		setExchangeInstID(o.getExchangeInstID());
		setOffsetFlag(o.getOffsetFlag());
		setHedgeFlag(o.getHedgeFlag());
		setPrice(o.getPrice());
		setVolume(o.getVolume());
		setTradeDate(o.getTradeDate());
		setTradeTime(o.getTradeTime());
		setTradeType(o.getTradeType());
		setPriceSource(o.getPriceSource());
		setTraderID(o.getTraderID());
		setOrderLocalID(o.getOrderLocalID());
		setClearingPartID(o.getClearingPartID());
		setBusinessUnit(o.getBusinessUnit());
		setSequenceNo(o.getSequenceNo());
		setTradingDay(o.getTradingDay());
		setSettlementID(o.getSettlementID());
		setBrokerOrderSeq(o.getBrokerOrderSeq());
		setTradeSource(o.getTradeSource());
	}

	public void update(TradeExchange o) { 
		setBrokerID(o.getBrokerID());
		setInvestorID(o.getInvestorID());
		setInstrumentID(o.getInstrumentID());
		setOrderRef(o.getOrderRef());
		setUserID(o.getUserID());
		setExchangeID(o.getExchangeID());
		setTradeID(o.getTradeID());
		setDirection(o.getDirection());
		setOrderSysID(o.getOrderSysID());
		setParticipantID(o.getParticipantID());
		setClientID(o.getClientID());
		setTradingRole(o.getTradingRole());
		setExchangeInstID(o.getExchangeInstID());
		setOffsetFlag(o.getOffsetFlag());
		setHedgeFlag(o.getHedgeFlag());
		setPrice(o.getPrice());
		setVolume(o.getVolume());
		setTradeDate(o.getTradeDate());
		setTradeTime(o.getTradeTime());
		setTradeType(o.getTradeType());
		setPriceSource(o.getPriceSource());
		setTraderID(o.getTraderID());
		setOrderLocalID(o.getOrderLocalID());
		setClearingPartID(o.getClearingPartID());
		setBusinessUnit(o.getBusinessUnit());
		setSequenceNo(o.getSequenceNo());
		setTradingDay(o.getTradingDay());
		setSettlementID(o.getSettlementID());
		setBrokerOrderSeq(o.getBrokerOrderSeq());
		setTradeSource(o.getTradeSource());
	}

	public SimpleStringProperty brokerIDProperty() {
		return brokerID;
	}
	public String getBrokerID() {
		return brokerID.get();
	}

	public void setBrokerID(String brokerID) {
		this.brokerID.set(brokerID);
	}

	public SimpleStringProperty investorIDProperty() {
		return investorID;
	}
	public String getInvestorID() {
		return investorID.get();
	}

	public void setInvestorID(String investorID) {
		this.investorID.set(investorID);
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

	public SimpleStringProperty orderRefProperty() {
		return orderRef;
	}
	public String getOrderRef() {
		return orderRef.get();
	}

	public void setOrderRef(String orderRef) {
		this.orderRef.set(orderRef);
	}

	public SimpleStringProperty userIDProperty() {
		return userID;
	}
	public String getUserID() {
		return userID.get();
	}

	public void setUserID(String userID) {
		this.userID.set(userID);
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

	public SimpleStringProperty tradeIDProperty() {
		return tradeID;
	}
	public String getTradeID() {
		return tradeID.get();
	}

	public void setTradeID(String tradeID) {
		this.tradeID.set(tradeID);
	}

	public SimpleStringProperty directionProperty() {
		return direction;
	}
	public String getDirection() {
		return direction.get();
	}

	public void setDirection(String direction) {
		this.direction.set(direction);
	}

	public SimpleStringProperty orderSysIDProperty() {
		return orderSysID;
	}
	public String getOrderSysID() {
		return orderSysID.get();
	}

	public void setOrderSysID(String orderSysID) {
		this.orderSysID.set(orderSysID);
	}

	public SimpleStringProperty participantIDProperty() {
		return participantID;
	}
	public String getParticipantID() {
		return participantID.get();
	}

	public void setParticipantID(String participantID) {
		this.participantID.set(participantID);
	}

	public SimpleStringProperty clientIDProperty() {
		return clientID;
	}
	public String getClientID() {
		return clientID.get();
	}

	public void setClientID(String clientID) {
		this.clientID.set(clientID);
	}

	public SimpleStringProperty tradingRoleProperty() {
		return tradingRole;
	}
	public String getTradingRole() {
		return tradingRole.get();
	}

	public void setTradingRole(String tradingRole) {
		this.tradingRole.set(tradingRole);
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

	public SimpleStringProperty offsetFlagProperty() {
		return offsetFlag;
	}
	public String getOffsetFlag() {
		return offsetFlag.get();
	}

	public void setOffsetFlag(String offsetFlag) {
		this.offsetFlag.set(offsetFlag);
	}

	public SimpleStringProperty hedgeFlagProperty() {
		return hedgeFlag;
	}
	public String getHedgeFlag() {
		return hedgeFlag.get();
	}

	public void setHedgeFlag(String hedgeFlag) {
		this.hedgeFlag.set(hedgeFlag);
	}

	public SimpleDoubleProperty priceProperty() {
		return price;
	}
	public double getPrice() {
		return price.get();
	}

	public void setPrice(double price) {
		this.price.set(price);
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

	public SimpleStringProperty tradeDateProperty() {
		return tradeDate;
	}
	public String getTradeDate() {
		return tradeDate.get();
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate.set(tradeDate);
	}

	public SimpleStringProperty tradeTimeProperty() {
		return tradeTime;
	}
	public String getTradeTime() {
		return tradeTime.get();
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime.set(tradeTime);
	}

	public SimpleStringProperty tradeTypeProperty() {
		return tradeType;
	}
	public String getTradeType() {
		return tradeType.get();
	}

	public void setTradeType(String tradeType) {
		this.tradeType.set(tradeType);
	}

	public SimpleStringProperty priceSourceProperty() {
		return priceSource;
	}
	public String getPriceSource() {
		return priceSource.get();
	}

	public void setPriceSource(String priceSource) {
		this.priceSource.set(priceSource);
	}

	public SimpleStringProperty traderIDProperty() {
		return traderID;
	}
	public String getTraderID() {
		return traderID.get();
	}

	public void setTraderID(String traderID) {
		this.traderID.set(traderID);
	}

	public SimpleStringProperty orderLocalIDProperty() {
		return orderLocalID;
	}
	public String getOrderLocalID() {
		return orderLocalID.get();
	}

	public void setOrderLocalID(String orderLocalID) {
		this.orderLocalID.set(orderLocalID);
	}

	public SimpleStringProperty clearingPartIDProperty() {
		return clearingPartID;
	}
	public String getClearingPartID() {
		return clearingPartID.get();
	}

	public void setClearingPartID(String clearingPartID) {
		this.clearingPartID.set(clearingPartID);
	}

	public SimpleStringProperty businessUnitProperty() {
		return businessUnit;
	}
	public String getBusinessUnit() {
		return businessUnit.get();
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit.set(businessUnit);
	}

	public SimpleIntegerProperty sequenceNoProperty() {
		return sequenceNo;
	}
	public int getSequenceNo() {
		return sequenceNo.get();
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo.set(sequenceNo);
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

	public SimpleIntegerProperty settlementIDProperty() {
		return settlementID;
	}
	public int getSettlementID() {
		return settlementID.get();
	}

	public void setSettlementID(int settlementID) {
		this.settlementID.set(settlementID);
	}

	public SimpleIntegerProperty brokerOrderSeqProperty() {
		return brokerOrderSeq;
	}
	public int getBrokerOrderSeq() {
		return brokerOrderSeq.get();
	}

	public void setBrokerOrderSeq(int brokerOrderSeq) {
		this.brokerOrderSeq.set(brokerOrderSeq);
	}

	public SimpleStringProperty tradeSourceProperty() {
		return tradeSource;
	}
	public String getTradeSource() {
		return tradeSource.get();
	}

	public void setTradeSource(String tradeSource) {
		this.tradeSource.set(tradeSource);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (obj.getClass() == TradeExchangeProperty.class) {
			TradeExchangeProperty s = (TradeExchangeProperty)obj;
			return new EqualsBuilder()
					.append(this.getOrderSysID(), s.getOrderSysID())
					.isEquals();
		}
		return false;
	}

	@Override
	public int compareTo(TradeExchangeProperty o) {
		return new CompareToBuilder()
				.append(this.getOrderSysID(), o.getOrderSysID())
				.toComparison();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getOrderSysID())
				.hashCode();
	}
}
