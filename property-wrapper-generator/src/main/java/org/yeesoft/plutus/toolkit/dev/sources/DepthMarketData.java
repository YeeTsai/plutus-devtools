package org.yeesoft.plutus.toolkit.dev.sources;
//深度行情
public class DepthMarketData {
		private String tradingDay; //交易日
		private String instrumentID; //合约代码
		private String exchangeID; //交易所代码
		private String exchangeInstID; //合约在交易所的代码
		private double lastPrice; //最新价
		private double preSettlementPrice; //上次结算价
		private double preClosePrice; //昨收盘
		private double preOpenInterest; //昨持仓量
		private double openPrice; //今开盘
		private double highestPrice; //最高价
		private double lowestPrice; //最低价
		private int volume; //数量
		private double turnover; //成交金额
		private double openInterest; //持仓量
		private double closePrice; //今收盘
		private double settlementPrice; //本次结算价
		private double upperLimitPrice; //涨停板价
		private double lowerLimitPrice; //跌停板价
		private double preDelta; //昨虚实度
		private double currDelta; //今虚实度
		private String updateTime; //最后修改时间
		private int updateMillisec; //最后修改毫秒
		private double bidPrice1; //申买价一
		private int bidVolume1; //申买量一
		private double askPrice1; //申卖价一
		private int askVolume1; //申卖量一
		private double bidPrice2; //申买价二
		private int bidVolume2; //申买量二
		private double askPrice2; //申卖价二
		private int askVolume2; //申卖量二
		private double bidPrice3; //申买价三
		private int bidVolume3; //申买量三
		private double askPrice3; //申卖价三
		private int askVolume3; //申卖量三
		private double bidPrice4; //申买价四
		private int bidVolume4; //申买量四
		private double askPrice4; //申卖价四
		private int askVolume4; //申卖量四
		private double bidPrice5; //申买价五
		private int bidVolume5; //申买量五
		private double askPrice5; //申卖价五
		private int askVolume5; //申卖量五
		private double averagePrice; //当日均价
		private String actionDay; //业务日期
		public void setTradingDay(String tradingDay) {
			this.tradingDay = tradingDay;
		}
		public String getTradingDay() {
			return this.tradingDay;
		}

		public void setInstrumentID(String instrumentID) {
			this.instrumentID = instrumentID;
		}
		public String getInstrumentID() {
			return this.instrumentID;
		}

		public void setExchangeID(String exchangeID) {
			this.exchangeID = exchangeID;
		}
		public String getExchangeID() {
			return this.exchangeID;
		}

		public void setExchangeInstID(String exchangeInstID) {
			this.exchangeInstID = exchangeInstID;
		}
		public String getExchangeInstID() {
			return this.exchangeInstID;
		}

		public void setLastPrice(double lastPrice) {
			this.lastPrice = lastPrice;
		}
		public double getLastPrice() {
			return this.lastPrice;
		}

		public void setPreSettlementPrice(double preSettlementPrice) {
			this.preSettlementPrice = preSettlementPrice;
		}
		public double getPreSettlementPrice() {
			return this.preSettlementPrice;
		}

		public void setPreClosePrice(double preClosePrice) {
			this.preClosePrice = preClosePrice;
		}
		public double getPreClosePrice() {
			return this.preClosePrice;
		}

		public void setPreOpenInterest(double preOpenInterest) {
			this.preOpenInterest = preOpenInterest;
		}
		public double getPreOpenInterest() {
			return this.preOpenInterest;
		}

		public void setOpenPrice(double openPrice) {
			this.openPrice = openPrice;
		}
		public double getOpenPrice() {
			return this.openPrice;
		}

		public void setHighestPrice(double highestPrice) {
			this.highestPrice = highestPrice;
		}
		public double getHighestPrice() {
			return this.highestPrice;
		}

		public void setLowestPrice(double lowestPrice) {
			this.lowestPrice = lowestPrice;
		}
		public double getLowestPrice() {
			return this.lowestPrice;
		}

		public void setVolume(int volume) {
			this.volume = volume;
		}
		public int getVolume() {
			return this.volume;
		}

		public void setTurnover(double turnover) {
			this.turnover = turnover;
		}
		public double getTurnover() {
			return this.turnover;
		}

		public void setOpenInterest(double openInterest) {
			this.openInterest = openInterest;
		}
		public double getOpenInterest() {
			return this.openInterest;
		}

		public void setClosePrice(double closePrice) {
			this.closePrice = closePrice;
		}
		public double getClosePrice() {
			return this.closePrice;
		}

		public void setSettlementPrice(double settlementPrice) {
			this.settlementPrice = settlementPrice;
		}
		public double getSettlementPrice() {
			return this.settlementPrice;
		}

		public void setUpperLimitPrice(double upperLimitPrice) {
			this.upperLimitPrice = upperLimitPrice;
		}
		public double getUpperLimitPrice() {
			return this.upperLimitPrice;
		}

		public void setLowerLimitPrice(double lowerLimitPrice) {
			this.lowerLimitPrice = lowerLimitPrice;
		}
		public double getLowerLimitPrice() {
			return this.lowerLimitPrice;
		}

		public void setPreDelta(double preDelta) {
			this.preDelta = preDelta;
		}
		public double getPreDelta() {
			return this.preDelta;
		}

		public void setCurrDelta(double currDelta) {
			this.currDelta = currDelta;
		}
		public double getCurrDelta() {
			return this.currDelta;
		}

		public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		}
		public String getUpdateTime() {
			return this.updateTime;
		}

		public void setUpdateMillisec(int updateMillisec) {
			this.updateMillisec = updateMillisec;
		}
		public int getUpdateMillisec() {
			return this.updateMillisec;
		}

		public void setBidPrice1(double bidPrice1) {
			this.bidPrice1 = bidPrice1;
		}
		public double getBidPrice1() {
			return this.bidPrice1;
		}

		public void setBidVolume1(int bidVolume1) {
			this.bidVolume1 = bidVolume1;
		}
		public int getBidVolume1() {
			return this.bidVolume1;
		}

		public void setAskPrice1(double askPrice1) {
			this.askPrice1 = askPrice1;
		}
		public double getAskPrice1() {
			return this.askPrice1;
		}

		public void setAskVolume1(int askVolume1) {
			this.askVolume1 = askVolume1;
		}
		public int getAskVolume1() {
			return this.askVolume1;
		}

		public void setBidPrice2(double bidPrice2) {
			this.bidPrice2 = bidPrice2;
		}
		public double getBidPrice2() {
			return this.bidPrice2;
		}

		public void setBidVolume2(int bidVolume2) {
			this.bidVolume2 = bidVolume2;
		}
		public int getBidVolume2() {
			return this.bidVolume2;
		}

		public void setAskPrice2(double askPrice2) {
			this.askPrice2 = askPrice2;
		}
		public double getAskPrice2() {
			return this.askPrice2;
		}

		public void setAskVolume2(int askVolume2) {
			this.askVolume2 = askVolume2;
		}
		public int getAskVolume2() {
			return this.askVolume2;
		}

		public void setBidPrice3(double bidPrice3) {
			this.bidPrice3 = bidPrice3;
		}
		public double getBidPrice3() {
			return this.bidPrice3;
		}

		public void setBidVolume3(int bidVolume3) {
			this.bidVolume3 = bidVolume3;
		}
		public int getBidVolume3() {
			return this.bidVolume3;
		}

		public void setAskPrice3(double askPrice3) {
			this.askPrice3 = askPrice3;
		}
		public double getAskPrice3() {
			return this.askPrice3;
		}

		public void setAskVolume3(int askVolume3) {
			this.askVolume3 = askVolume3;
		}
		public int getAskVolume3() {
			return this.askVolume3;
		}

		public void setBidPrice4(double bidPrice4) {
			this.bidPrice4 = bidPrice4;
		}
		public double getBidPrice4() {
			return this.bidPrice4;
		}

		public void setBidVolume4(int bidVolume4) {
			this.bidVolume4 = bidVolume4;
		}
		public int getBidVolume4() {
			return this.bidVolume4;
		}

		public void setAskPrice4(double askPrice4) {
			this.askPrice4 = askPrice4;
		}
		public double getAskPrice4() {
			return this.askPrice4;
		}

		public void setAskVolume4(int askVolume4) {
			this.askVolume4 = askVolume4;
		}
		public int getAskVolume4() {
			return this.askVolume4;
		}

		public void setBidPrice5(double bidPrice5) {
			this.bidPrice5 = bidPrice5;
		}
		public double getBidPrice5() {
			return this.bidPrice5;
		}

		public void setBidVolume5(int bidVolume5) {
			this.bidVolume5 = bidVolume5;
		}
		public int getBidVolume5() {
			return this.bidVolume5;
		}

		public void setAskPrice5(double askPrice5) {
			this.askPrice5 = askPrice5;
		}
		public double getAskPrice5() {
			return this.askPrice5;
		}

		public void setAskVolume5(int askVolume5) {
			this.askVolume5 = askVolume5;
		}
		public int getAskVolume5() {
			return this.askVolume5;
		}

		public void setAveragePrice(double averagePrice) {
			this.averagePrice = averagePrice;
		}
		public double getAveragePrice() {
			return this.averagePrice;
		}

		public void setActionDay(String actionDay) {
			this.actionDay = actionDay;
		}
		public String getActionDay() {
			return this.actionDay;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("\n");
			sb.append("tradingDay [ 交易日 ] : ");
			sb.append(tradingDay);
			sb.append("\n");
			sb.append("instrumentID [ 合约代码 ] : ");
			sb.append(instrumentID);
			sb.append("\n");
			sb.append("exchangeID [ 交易所代码 ] : ");
			sb.append(exchangeID);
			sb.append("\n");
			sb.append("exchangeInstID [ 合约在交易所的代码 ] : ");
			sb.append(exchangeInstID);
			sb.append("\n");
			sb.append("lastPrice [ 最新价 ] : ");
			sb.append(lastPrice);
			sb.append("\n");
			sb.append("preSettlementPrice [ 上次结算价 ] : ");
			sb.append(preSettlementPrice);
			sb.append("\n");
			sb.append("preClosePrice [ 昨收盘 ] : ");
			sb.append(preClosePrice);
			sb.append("\n");
			sb.append("preOpenInterest [ 昨持仓量 ] : ");
			sb.append(preOpenInterest);
			sb.append("\n");
			sb.append("openPrice [ 今开盘 ] : ");
			sb.append(openPrice);
			sb.append("\n");
			sb.append("highestPrice [ 最高价 ] : ");
			sb.append(highestPrice);
			sb.append("\n");
			sb.append("lowestPrice [ 最低价 ] : ");
			sb.append(lowestPrice);
			sb.append("\n");
			sb.append("volume [ 数量 ] : ");
			sb.append(volume);
			sb.append("\n");
			sb.append("turnover [ 成交金额 ] : ");
			sb.append(turnover);
			sb.append("\n");
			sb.append("openInterest [ 持仓量 ] : ");
			sb.append(openInterest);
			sb.append("\n");
			sb.append("closePrice [ 今收盘 ] : ");
			sb.append(closePrice);
			sb.append("\n");
			sb.append("settlementPrice [ 本次结算价 ] : ");
			sb.append(settlementPrice);
			sb.append("\n");
			sb.append("upperLimitPrice [ 涨停板价 ] : ");
			sb.append(upperLimitPrice);
			sb.append("\n");
			sb.append("lowerLimitPrice [ 跌停板价 ] : ");
			sb.append(lowerLimitPrice);
			sb.append("\n");
			sb.append("preDelta [ 昨虚实度 ] : ");
			sb.append(preDelta);
			sb.append("\n");
			sb.append("currDelta [ 今虚实度 ] : ");
			sb.append(currDelta);
			sb.append("\n");
			sb.append("updateTime [ 最后修改时间 ] : ");
			sb.append(updateTime);
			sb.append("\n");
			sb.append("updateMillisec [ 最后修改毫秒 ] : ");
			sb.append(updateMillisec);
			sb.append("\n");
			sb.append("bidPrice1 [ 申买价一 ] : ");
			sb.append(bidPrice1);
			sb.append("\n");
			sb.append("bidVolume1 [ 申买量一 ] : ");
			sb.append(bidVolume1);
			sb.append("\n");
			sb.append("askPrice1 [ 申卖价一 ] : ");
			sb.append(askPrice1);
			sb.append("\n");
			sb.append("askVolume1 [ 申卖量一 ] : ");
			sb.append(askVolume1);
			sb.append("\n");
			sb.append("bidPrice2 [ 申买价二 ] : ");
			sb.append(bidPrice2);
			sb.append("\n");
			sb.append("bidVolume2 [ 申买量二 ] : ");
			sb.append(bidVolume2);
			sb.append("\n");
			sb.append("askPrice2 [ 申卖价二 ] : ");
			sb.append(askPrice2);
			sb.append("\n");
			sb.append("askVolume2 [ 申卖量二 ] : ");
			sb.append(askVolume2);
			sb.append("\n");
			sb.append("bidPrice3 [ 申买价三 ] : ");
			sb.append(bidPrice3);
			sb.append("\n");
			sb.append("bidVolume3 [ 申买量三 ] : ");
			sb.append(bidVolume3);
			sb.append("\n");
			sb.append("askPrice3 [ 申卖价三 ] : ");
			sb.append(askPrice3);
			sb.append("\n");
			sb.append("askVolume3 [ 申卖量三 ] : ");
			sb.append(askVolume3);
			sb.append("\n");
			sb.append("bidPrice4 [ 申买价四 ] : ");
			sb.append(bidPrice4);
			sb.append("\n");
			sb.append("bidVolume4 [ 申买量四 ] : ");
			sb.append(bidVolume4);
			sb.append("\n");
			sb.append("askPrice4 [ 申卖价四 ] : ");
			sb.append(askPrice4);
			sb.append("\n");
			sb.append("askVolume4 [ 申卖量四 ] : ");
			sb.append(askVolume4);
			sb.append("\n");
			sb.append("bidPrice5 [ 申买价五 ] : ");
			sb.append(bidPrice5);
			sb.append("\n");
			sb.append("bidVolume5 [ 申买量五 ] : ");
			sb.append(bidVolume5);
			sb.append("\n");
			sb.append("askPrice5 [ 申卖价五 ] : ");
			sb.append(askPrice5);
			sb.append("\n");
			sb.append("askVolume5 [ 申卖量五 ] : ");
			sb.append(askVolume5);
			sb.append("\n");
			sb.append("averagePrice [ 当日均价 ] : ");
			sb.append(averagePrice);
			sb.append("\n");
			sb.append("actionDay [ 业务日期 ] : ");
			sb.append(actionDay);
			sb.append("\n");
			return sb.toString();
		}
}
