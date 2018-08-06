/**
 *
 */
package com.demo.example.rest;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 */
public class DefaultTest {
	protected CloseableHttpClient httpClient;
	protected String baseUrl = "";

	public DefaultTest() {
		baseUrl = "http://127.0.0.1:28810";
		httpClient = HttpClients.createDefault();
	}

}
