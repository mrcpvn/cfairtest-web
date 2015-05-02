package cfairtestweb.client;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import cfairtestweb.model.TradeData;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@Component
public class RestClient implements IRestClient{

	Client client = null;
	
	public RestClient(){
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		clientConfig.getProperties().put(
				ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
		client = Client.create(clientConfig);
	}

	@Override
	public String getLastTrade() {
		WebResource r = client.resource("http://cfairtest-mrcpvn.rhcloud.com/api/trade/last");
		ClientResponse response = r.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		return response.getEntity(String.class);
	}

	@Override
	public List<TradeData> getTradeStats() {
		WebResource r = client.resource("http://cfairtest-mrcpvn.rhcloud.com/api/trade/stats");
		ClientResponse response = r.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		return response.getEntity(new GenericType<List<TradeData>>(){});
	}
}
