package rest;

import com.google.gson.Gson;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Created by timothy on 2018-02-09, rest.
 */
public class RestClient {
    private static Client client = ClientBuilder.newClient();
    private static Gson gson = new Gson();
}
