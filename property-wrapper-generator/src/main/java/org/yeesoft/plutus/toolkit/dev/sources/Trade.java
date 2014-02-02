package org.yeesoft.plutus.toolkit.dev.sources;
//成交
public class Trade {
		private String brokerID; //经纪公司代码
		private String investorID; //投资者代码
		private String instrumentID; //合约代码
		private String orderRef; //报单引用
		private String userID; //用户代码
		private String exchangeID; //交易所代码
		private String tradeID; //成交编号
		private String direction; //买卖方向
		private String orderSysID; //报单编号
		private String participantID; //会员代码
		private String clientID; //客户代码
		private String tradingRole; //交易角色
		private String exchangeInstID; //合约在交易所的代码
		private String offsetFlag; //开平标志
		private String hedgeFlag; //投机套保标志
		private double price; //价格
		private int volume; //数量
		private String tradeDate; //成交时期
		private String tradeTime; //成交时间
		private String tradeType; //成交类型
		private String priceSource; //成交价来源
		private String traderID; //交易所交易员代码
		private String orderLocalID; //本地报单编号
		private String clearingPartID; //结算会员编号
		private String businessUnit; //业务单元
		private int sequenceNo; //序号
		private String tradingDay; //交易日
		private int settlementID; //结算编号
		private int brokerOrderSeq; //经纪公司报单编号
		private String tradeSource; //成交来源
		public void setBrokerID(String brokerID) {
			this.brokerID = brokerID;
		}
		public String getBrokerID() {
			return this.brokerID;
		}

		public void setInvestorID(String investorID) {
			this.investorID = investorID;
		}
		public String getInvestorID() {
			return this.investorID;
		}

		public void setInstrumentID(String instrumentID) {
			this.instrumentID = instrumentID;
		}
		public String getInstrumentID() {
			return this.instrumentID;
		}

		public void setOrderRef(String orderRef) {
			this.orderRef = orderRef;
		}
		public String getOrderRef() {
			return this.orderRef;
		}

		public void setUserID(String userID) {
			this.userID = userID;
		}
		public String getUserID() {
			return this.userID;
		}

		public void setExchangeID(String exchangeID) {
			this.exchangeID = exchangeID;
		}
		public String getExchangeID() {
			return this.exchangeID;
		}

		public void setTradeID(String tradeID) {
			this.tradeID = tradeID;
		}
		public String getTradeID() {
			return this.tradeID;
		}

		public void setDirection(String direction) {
			this.direction = direction;
		}
		public String getDirection() {
			return this.direction;
		}

		public void setOrderSysID(String orderSysID) {
			this.orderSysID = orderSysID;
		}
		public String getOrderSysID() {
			return this.orderSysID;
		}

		public void setParticipantID(String participantID) {
			this.participantID = participantID;
		}
		public String getParticipantID() {
			return this.participantID;
		}

		public void setClientID(String clientID) {
			this.clientID = clientID;
		}
		public String getClientID() {
			return this.clientID;
		}

		public void setTradingRole(String tradingRole) {
			this.tradingRole = tradingRole;
		}
		public String getTradingRole() {
			return this.tradingRole;
		}

		public void setExchangeInstID(String exchangeInstID) {
			this.exchangeInstID = exchangeInstID;
		}
		public String getExchangeInstID() {
			return this.exchangeInstID;
		}

		public void setOffsetFlag(String offsetFlag) {
			this.offsetFlag = offsetFlag;
		}
		public String getOffsetFlag() {
			return this.offsetFlag;
		}

		public void setHedgeFlag(String hedgeFlag) {
			this.hedgeFlag = hedgeFlag;
		}
		public String getHedgeFlag() {
			return this.hedgeFlag;
		}

		public void setPrice(double price) {
			this.price = price;
		}
		public double getPrice() {
			return this.price;
		}

		public void setVolume(int volume) {
			this.volume = volume;
		}
		public int getVolume() {
			return this.volume;
		}

		public void setTradeDate(String tradeDate) {
			this.tradeDate = tradeDate;
		}
		public String getTradeDate() {
			return this.tradeDate;
		}

		public void setTradeTime(String tradeTime) {
			this.tradeTime = tradeTime;
		}
		public String getTradeTime() {
			return this.tradeTime;
		}

		public void setTradeType(String tradeType) {
			this.tradeType = tradeType;
		}
		public String getTradeType() {
			return this.tradeType;
		}

		public void setPriceSource(String priceSource) {
			this.priceSource = priceSource;
		}
		public String getPriceSource() {
			return this.priceSource;
		}

		public void setTraderID(String traderID) {
			this.traderID = traderID;
		}
		public String getTraderID() {
			return this.traderID;
		}

		public void setOrderLocalID(String orderLocalID) {
			this.orderLocalID = orderLocalID;
		}
		public String getOrderLocalID() {
			return this.orderLocalID;
		}

		public void setClearingPartID(String clearingPartID) {
			this.clearingPartID = clearingPartID;
		}
		public String getClearingPartID() {
			return this.clearingPartID;
		}

		public void setBusinessUnit(String businessUnit) {
			this.businessUnit = businessUnit;
		}
		public String getBusinessUnit() {
			return this.businessUnit;
		}

		public void setSequenceNo(int sequenceNo) {
			this.sequenceNo = sequenceNo;
		}
		public int getSequenceNo() {
			return this.sequenceNo;
		}

		public void setTradingDay(String tradingDay) {
			this.tradingDay = tradingDay;
		}
		public String getTradingDay() {
			return this.tradingDay;
		}

		public void setSettlementID(int settlementID) {
			this.settlementID = settlementID;
		}
		public int getSettlementID() {
			return this.settlementID;
		}

		public void setBrokerOrderSeq(int brokerOrderSeq) {
			this.brokerOrderSeq = brokerOrderSeq;
		}
		public int getBrokerOrderSeq() {
			return this.brokerOrderSeq;
		}

		public void setTradeSource(String tradeSource) {
			this.tradeSource = tradeSource;
		}
		public String getTradeSource() {
			return this.tradeSource;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("\n");
			sb.append("brokerID [ 经纪公司代码 ] : ");
			sb.append(brokerID);
			sb.append("\n");
			sb.append("investorID [ 投资者代码 ] : ");
			sb.append(investorID);
			sb.append("\n");
			sb.append("instrumentID [ 合约代码 ] : ");
			sb.append(instrumentID);
			sb.append("\n");
			sb.append("orderRef [ 报单引用 ] : ");
			sb.append(orderRef);
			sb.append("\n");
			sb.append("userID [ 用户代码 ] : ");
			sb.append(userID);
			sb.append("\n");
			sb.append("exchangeID [ 交易所代码 ] : ");
			sb.append(exchangeID);
			sb.append("\n");
			sb.append("tradeID [ 成交编号 ] : ");
			sb.append(tradeID);
			sb.append("\n");
			sb.append("direction [ 买卖方向 ] : ");
			sb.append(direction);
			sb.append("\n");
			sb.append("orderSysID [ 报单编号 ] : ");
			sb.append(orderSysID);
			sb.append("\n");
			sb.append("participantID [ 会员代码 ] : ");
			sb.append(participantID);
			sb.append("\n");
			sb.append("clientID [ 客户代码 ] : ");
			sb.append(clientID);
			sb.append("\n");
			sb.append("tradingRole [ 交易角色 ] : ");
			sb.append(tradingRole);
			sb.append("\n");
			sb.append("exchangeInstID [ 合约在交易所的代码 ] : ");
			sb.append(exchangeInstID);
			sb.append("\n");
			sb.append("offsetFlag [ 开平标志 ] : ");
			sb.append(offsetFlag);
			sb.append("\n");
			sb.append("hedgeFlag [ 投机套保标志 ] : ");
			sb.append(hedgeFlag);
			sb.append("\n");
			sb.append("price [ 价格 ] : ");
			sb.append(price);
			sb.append("\n");
			sb.append("volume [ 数量 ] : ");
			sb.append(volume);
			sb.append("\n");
			sb.append("tradeDate [ 成交时期 ] : ");
			sb.append(tradeDate);
			sb.append("\n");
			sb.append("tradeTime [ 成交时间 ] : ");
			sb.append(tradeTime);
			sb.append("\n");
			sb.append("tradeType [ 成交类型 ] : ");
			sb.append(tradeType);
			sb.append("\n");
			sb.append("priceSource [ 成交价来源 ] : ");
			sb.append(priceSource);
			sb.append("\n");
			sb.append("traderID [ 交易所交易员代码 ] : ");
			sb.append(traderID);
			sb.append("\n");
			sb.append("orderLocalID [ 本地报单编号 ] : ");
			sb.append(orderLocalID);
			sb.append("\n");
			sb.append("clearingPartID [ 结算会员编号 ] : ");
			sb.append(clearingPartID);
			sb.append("\n");
			sb.append("businessUnit [ 业务单元 ] : ");
			sb.append(businessUnit);
			sb.append("\n");
			sb.append("sequenceNo [ 序号 ] : ");
			sb.append(sequenceNo);
			sb.append("\n");
			sb.append("tradingDay [ 交易日 ] : ");
			sb.append(tradingDay);
			sb.append("\n");
			sb.append("settlementID [ 结算编号 ] : ");
			sb.append(settlementID);
			sb.append("\n");
			sb.append("brokerOrderSeq [ 经纪公司报单编号 ] : ");
			sb.append(brokerOrderSeq);
			sb.append("\n");
			sb.append("tradeSource [ 成交来源 ] : ");
			sb.append(tradeSource);
			sb.append("\n");
			return sb.toString();
		}
}
