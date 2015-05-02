package cfairtestweb.client;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Component
public class RestClient implements IRestClient{

	Client client = Client.create();

	@Override
	public String getLastTrade() {
		WebResource r = client.resource("http://cfairtest-mrcpvn.rhcloud.com/api/trade/last");
		ClientResponse response = r.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		return response.getEntity(String.class);
	}
}
