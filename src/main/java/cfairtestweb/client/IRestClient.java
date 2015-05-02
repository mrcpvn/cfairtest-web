package cfairtestweb.client;

import java.util.List;

import cfairtestweb.model.TradeData;
import cfairtestweb.model.TradeModel;

public interface IRestClient {

	public TradeModel getLastTrade();
	
	public List<TradeData> getTradeStats();
}
