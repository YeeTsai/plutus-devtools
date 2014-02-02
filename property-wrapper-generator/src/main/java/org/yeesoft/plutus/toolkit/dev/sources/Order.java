package org.yeesoft.plutus.toolkit.dev.sources;
//报单
public class Order {
		private String brokerID; //经纪公司代码
		private String investorID; //投资者代码
		private String instrumentID; //合约代码
		private String orderRef; //报单引用
		private String userID; //用户代码
		private String orderPriceType; //报单价格条件
		private String direction; //买卖方向
		private String combOffsetFlag; //组合开平标志
		private String combHedgeFlag; //组合投机套保标志
		private double limitPrice; //价格
		private int volumeTotalOriginal; //数量
		private String timeCondition; //有效期类型
		private String gTDDate; //GTD日期
		private String volumeCondition; //成交量类型
		private int minVolume; //最小成交量
		private String contingentCondition; //触发条件
		private double stopPrice; //止损价
		private String forceCloseReason; //强平原因
		private int isAutoSuspend; //自动挂起标志
		private String businessUnit; //业务单元
		private int requestID; //请求编号
		private String orderLocalID; //本地报单编号
		private String exchangeID; //交易所代码
		private String participantID; //会员代码
		private String clientID; //客户代码
		private String exchangeInstID; //合约在交易所的代码
		private String traderID; //交易所交易员代码
		private int installID; //安装编号
		private String orderSubmitStatus; //报单提交状态
		private int notifySequence; //报单提示序号
		private String tradingDay; //交易日
		private int settlementID; //结算编号
		private String orderSysID; //报单编号
		private String orderSource; //报单来源
		private String orderStatus; //报单状态
		private String orderType; //报单类型
		private int volumeTraded; //今成交数量
		private int volumeTotal; //剩余数量
		private String insertDate; //报单日期
		private String insertTime; //委托时间
		private String activeTime; //激活时间
		private String suspendTime; //挂起时间
		private String updateTime; //最后修改时间
		private String cancelTime; //撤销时间
		private String activeTraderID; //最后修改交易所交易员代码
		private String clearingPartID; //结算会员编号
		private int sequenceNo; //序号
		private int frontID; //前置编号
		private int sessionID; //会话编号
		private String userProductInfo; //用户端产品信息
		private String statusMsg; //状态信息
		private int userForceClose; //用户强评标志
		private String activeUserID; //操作用户代码
		private int brokerOrderSeq; //经纪公司报单编号
		private String relativeOrderSysID; //相关报单
		private int zCETotalTradedVolume; //郑商所成交数量
		private int isSwapOrder; //互换单标志
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

		public void setOrderPriceType(String orderPriceType) {
			this.orderPriceType = orderPriceType;
		}
		public String getOrderPriceType() {
			return this.orderPriceType;
		}

		public void setDirection(String direction) {
			this.direction = direction;
		}
		public String getDirection() {
			return this.direction;
		}

		public void setCombOffsetFlag(String combOffsetFlag) {
			this.combOffsetFlag = combOffsetFlag;
		}
		public String getCombOffsetFlag() {
			return this.combOffsetFlag;
		}

		public void setCombHedgeFlag(String combHedgeFlag) {
			this.combHedgeFlag = combHedgeFlag;
		}
		public String getCombHedgeFlag() {
			return this.combHedgeFlag;
		}

		public void setLimitPrice(double limitPrice) {
			this.limitPrice = limitPrice;
		}
		public double getLimitPrice() {
			return this.limitPrice;
		}

		public void setVolumeTotalOriginal(int volumeTotalOriginal) {
			this.volumeTotalOriginal = volumeTotalOriginal;
		}
		public int getVolumeTotalOriginal() {
			return this.volumeTotalOriginal;
		}

		public void setTimeCondition(String timeCondition) {
			this.timeCondition = timeCondition;
		}
		public String getTimeCondition() {
			return this.timeCondition;
		}

		public void setGTDDate(String gTDDate) {
			this.gTDDate = gTDDate;
		}
		public String getGTDDate() {
			return this.gTDDate;
		}

		public void setVolumeCondition(String volumeCondition) {
			this.volumeCondition = volumeCondition;
		}
		public String getVolumeCondition() {
			return this.volumeCondition;
		}

		public void setMinVolume(int minVolume) {
			this.minVolume = minVolume;
		}
		public int getMinVolume() {
			return this.minVolume;
		}

		public void setContingentCondition(String contingentCondition) {
			this.contingentCondition = contingentCondition;
		}
		public String getContingentCondition() {
			return this.contingentCondition;
		}

		public void setStopPrice(double stopPrice) {
			this.stopPrice = stopPrice;
		}
		public double getStopPrice() {
			return this.stopPrice;
		}

		public void setForceCloseReason(String forceCloseReason) {
			this.forceCloseReason = forceCloseReason;
		}
		public String getForceCloseReason() {
			return this.forceCloseReason;
		}

		public void setIsAutoSuspend(int isAutoSuspend) {
			this.isAutoSuspend = isAutoSuspend;
		}
		public int getIsAutoSuspend() {
			return this.isAutoSuspend;
		}

		public void setBusinessUnit(String businessUnit) {
			this.businessUnit = businessUnit;
		}
		public String getBusinessUnit() {
			return this.businessUnit;
		}

		public void setRequestID(int requestID) {
			this.requestID = requestID;
		}
		public int getRequestID() {
			return this.requestID;
		}

		public void setOrderLocalID(String orderLocalID) {
			this.orderLocalID = orderLocalID;
		}
		public String getOrderLocalID() {
			return this.orderLocalID;
		}

		public void setExchangeID(String exchangeID) {
			this.exchangeID = exchangeID;
		}
		public String getExchangeID() {
			return this.exchangeID;
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

		public void setExchangeInstID(String exchangeInstID) {
			this.exchangeInstID = exchangeInstID;
		}
		public String getExchangeInstID() {
			return this.exchangeInstID;
		}

		public void setTraderID(String traderID) {
			this.traderID = traderID;
		}
		public String getTraderID() {
			return this.traderID;
		}

		public void setInstallID(int installID) {
			this.installID = installID;
		}
		public int getInstallID() {
			return this.installID;
		}

		public void setOrderSubmitStatus(String orderSubmitStatus) {
			this.orderSubmitStatus = orderSubmitStatus;
		}
		public String getOrderSubmitStatus() {
			return this.orderSubmitStatus;
		}

		public void setNotifySequence(int notifySequence) {
			this.notifySequence = notifySequence;
		}
		public int getNotifySequence() {
			return this.notifySequence;
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

		public void setOrderSysID(String orderSysID) {
			this.orderSysID = orderSysID;
		}
		public String getOrderSysID() {
			return this.orderSysID;
		}

		public void setOrderSource(String orderSource) {
			this.orderSource = orderSource;
		}
		public String getOrderSource() {
			return this.orderSource;
		}

		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
		}
		public String getOrderStatus() {
			return this.orderStatus;
		}

		public void setOrderType(String orderType) {
			this.orderType = orderType;
		}
		public String getOrderType() {
			return this.orderType;
		}

		public void setVolumeTraded(int volumeTraded) {
			this.volumeTraded = volumeTraded;
		}
		public int getVolumeTraded() {
			return this.volumeTraded;
		}

		public void setVolumeTotal(int volumeTotal) {
			this.volumeTotal = volumeTotal;
		}
		public int getVolumeTotal() {
			return this.volumeTotal;
		}

		public void setInsertDate(String insertDate) {
			this.insertDate = insertDate;
		}
		public String getInsertDate() {
			return this.insertDate;
		}

		public void setInsertTime(String insertTime) {
			this.insertTime = insertTime;
		}
		public String getInsertTime() {
			return this.insertTime;
		}

		public void setActiveTime(String activeTime) {
			this.activeTime = activeTime;
		}
		public String getActiveTime() {
			return this.activeTime;
		}

		public void setSuspendTime(String suspendTime) {
			this.suspendTime = suspendTime;
		}
		public String getSuspendTime() {
			return this.suspendTime;
		}

		public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		}
		public String getUpdateTime() {
			return this.updateTime;
		}

		public void setCancelTime(String cancelTime) {
			this.cancelTime = cancelTime;
		}
		public String getCancelTime() {
			return this.cancelTime;
		}

		public void setActiveTraderID(String activeTraderID) {
			this.activeTraderID = activeTraderID;
		}
		public String getActiveTraderID() {
			return this.activeTraderID;
		}

		public void setClearingPartID(String clearingPartID) {
			this.clearingPartID = clearingPartID;
		}
		public String getClearingPartID() {
			return this.clearingPartID;
		}

		public void setSequenceNo(int sequenceNo) {
			this.sequenceNo = sequenceNo;
		}
		public int getSequenceNo() {
			return this.sequenceNo;
		}

		public void setFrontID(int frontID) {
			this.frontID = frontID;
		}
		public int getFrontID() {
			return this.frontID;
		}

		public void setSessionID(int sessionID) {
			this.sessionID = sessionID;
		}
		public int getSessionID() {
			return this.sessionID;
		}

		public void setUserProductInfo(String userProductInfo) {
			this.userProductInfo = userProductInfo;
		}
		public String getUserProductInfo() {
			return this.userProductInfo;
		}

		public void setStatusMsg(String statusMsg) {
			this.statusMsg = statusMsg;
		}
		public String getStatusMsg() {
			return this.statusMsg;
		}

		public void setUserForceClose(int userForceClose) {
			this.userForceClose = userForceClose;
		}
		public int getUserForceClose() {
			return this.userForceClose;
		}

		public void setActiveUserID(String activeUserID) {
			this.activeUserID = activeUserID;
		}
		public String getActiveUserID() {
			return this.activeUserID;
		}

		public void setBrokerOrderSeq(int brokerOrderSeq) {
			this.brokerOrderSeq = brokerOrderSeq;
		}
		public int getBrokerOrderSeq() {
			return this.brokerOrderSeq;
		}

		public void setRelativeOrderSysID(String relativeOrderSysID) {
			this.relativeOrderSysID = relativeOrderSysID;
		}
		public String getRelativeOrderSysID() {
			return this.relativeOrderSysID;
		}

		public void setZCETotalTradedVolume(int zCETotalTradedVolume) {
			this.zCETotalTradedVolume = zCETotalTradedVolume;
		}
		public int getZCETotalTradedVolume() {
			return this.zCETotalTradedVolume;
		}

		public void setIsSwapOrder(int isSwapOrder) {
			this.isSwapOrder = isSwapOrder;
		}
		public int getIsSwapOrder() {
			return this.isSwapOrder;
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
			sb.append("orderPriceType [ 报单价格条件 ] : ");
			sb.append(orderPriceType);
			sb.append("\n");
			sb.append("direction [ 买卖方向 ] : ");
			sb.append(direction);
			sb.append("\n");
			sb.append("combOffsetFlag [ 组合开平标志 ] : ");
			sb.append(combOffsetFlag);
			sb.append("\n");
			sb.append("combHedgeFlag [ 组合投机套保标志 ] : ");
			sb.append(combHedgeFlag);
			sb.append("\n");
			sb.append("limitPrice [ 价格 ] : ");
			sb.append(limitPrice);
			sb.append("\n");
			sb.append("volumeTotalOriginal [ 数量 ] : ");
			sb.append(volumeTotalOriginal);
			sb.append("\n");
			sb.append("timeCondition [ 有效期类型 ] : ");
			sb.append(timeCondition);
			sb.append("\n");
			sb.append("gTDDate [ GTD日期 ] : ");
			sb.append(gTDDate);
			sb.append("\n");
			sb.append("volumeCondition [ 成交量类型 ] : ");
			sb.append(volumeCondition);
			sb.append("\n");
			sb.append("minVolume [ 最小成交量 ] : ");
			sb.append(minVolume);
			sb.append("\n");
			sb.append("contingentCondition [ 触发条件 ] : ");
			sb.append(contingentCondition);
			sb.append("\n");
			sb.append("stopPrice [ 止损价 ] : ");
			sb.append(stopPrice);
			sb.append("\n");
			sb.append("forceCloseReason [ 强平原因 ] : ");
			sb.append(forceCloseReason);
			sb.append("\n");
			sb.append("isAutoSuspend [ 自动挂起标志 ] : ");
			sb.append(isAutoSuspend);
			sb.append("\n");
			sb.append("businessUnit [ 业务单元 ] : ");
			sb.append(businessUnit);
			sb.append("\n");
			sb.append("requestID [ 请求编号 ] : ");
			sb.append(requestID);
			sb.append("\n");
			sb.append("orderLocalID [ 本地报单编号 ] : ");
			sb.append(orderLocalID);
			sb.append("\n");
			sb.append("exchangeID [ 交易所代码 ] : ");
			sb.append(exchangeID);
			sb.append("\n");
			sb.append("participantID [ 会员代码 ] : ");
			sb.append(participantID);
			sb.append("\n");
			sb.append("clientID [ 客户代码 ] : ");
			sb.append(clientID);
			sb.append("\n");
			sb.append("exchangeInstID [ 合约在交易所的代码 ] : ");
			sb.append(exchangeInstID);
			sb.append("\n");
			sb.append("traderID [ 交易所交易员代码 ] : ");
			sb.append(traderID);
			sb.append("\n");
			sb.append("installID [ 安装编号 ] : ");
			sb.append(installID);
			sb.append("\n");
			sb.append("orderSubmitStatus [ 报单提交状态 ] : ");
			sb.append(orderSubmitStatus);
			sb.append("\n");
			sb.append("notifySequence [ 报单提示序号 ] : ");
			sb.append(notifySequence);
			sb.append("\n");
			sb.append("tradingDay [ 交易日 ] : ");
			sb.append(tradingDay);
			sb.append("\n");
			sb.append("settlementID [ 结算编号 ] : ");
			sb.append(settlementID);
			sb.append("\n");
			sb.append("orderSysID [ 报单编号 ] : ");
			sb.append(orderSysID);
			sb.append("\n");
			sb.append("orderSource [ 报单来源 ] : ");
			sb.append(orderSource);
			sb.append("\n");
			sb.append("orderStatus [ 报单状态 ] : ");
			sb.append(orderStatus);
			sb.append("\n");
			sb.append("orderType [ 报单类型 ] : ");
			sb.append(orderType);
			sb.append("\n");
			sb.append("volumeTraded [ 今成交数量 ] : ");
			sb.append(volumeTraded);
			sb.append("\n");
			sb.append("volumeTotal [ 剩余数量 ] : ");
			sb.append(volumeTotal);
			sb.append("\n");
			sb.append("insertDate [ 报单日期 ] : ");
			sb.append(insertDate);
			sb.append("\n");
			sb.append("insertTime [ 委托时间 ] : ");
			sb.append(insertTime);
			sb.append("\n");
			sb.append("activeTime [ 激活时间 ] : ");
			sb.append(activeTime);
			sb.append("\n");
			sb.append("suspendTime [ 挂起时间 ] : ");
			sb.append(suspendTime);
			sb.append("\n");
			sb.append("updateTime [ 最后修改时间 ] : ");
			sb.append(updateTime);
			sb.append("\n");
			sb.append("cancelTime [ 撤销时间 ] : ");
			sb.append(cancelTime);
			sb.append("\n");
			sb.append("activeTraderID [ 最后修改交易所交易员代码 ] : ");
			sb.append(activeTraderID);
			sb.append("\n");
			sb.append("clearingPartID [ 结算会员编号 ] : ");
			sb.append(clearingPartID);
			sb.append("\n");
			sb.append("sequenceNo [ 序号 ] : ");
			sb.append(sequenceNo);
			sb.append("\n");
			sb.append("frontID [ 前置编号 ] : ");
			sb.append(frontID);
			sb.append("\n");
			sb.append("sessionID [ 会话编号 ] : ");
			sb.append(sessionID);
			sb.append("\n");
			sb.append("userProductInfo [ 用户端产品信息 ] : ");
			sb.append(userProductInfo);
			sb.append("\n");
			sb.append("statusMsg [ 状态信息 ] : ");
			sb.append(statusMsg);
			sb.append("\n");
			sb.append("userForceClose [ 用户强评标志 ] : ");
			sb.append(userForceClose);
			sb.append("\n");
			sb.append("activeUserID [ 操作用户代码 ] : ");
			sb.append(activeUserID);
			sb.append("\n");
			sb.append("brokerOrderSeq [ 经纪公司报单编号 ] : ");
			sb.append(brokerOrderSeq);
			sb.append("\n");
			sb.append("relativeOrderSysID [ 相关报单 ] : ");
			sb.append(relativeOrderSysID);
			sb.append("\n");
			sb.append("zCETotalTradedVolume [ 郑商所成交数量 ] : ");
			sb.append(zCETotalTradedVolume);
			sb.append("\n");
			sb.append("isSwapOrder [ 互换单标志 ] : ");
			sb.append(isSwapOrder);
			sb.append("\n");
			return sb.toString();
		}
}
