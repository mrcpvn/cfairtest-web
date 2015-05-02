package cfairtestweb.client;

import java.util.List;

import cfairtestweb.model.TradeData;

public interface IRestClient {

	public String getLastTrade();
	
	public List<TradeData> getTradeStats();
}
