package com.ivantulev.store;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ivantulev.store.web.rest.Body;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { StoreApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StoreApplicationTests {

	@Autowired
	Environment environment;

	@Test
	public void contextLoads() throws RestClientException, URISyntaxException, JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		Body body = new Body();
		body.setItemType("Car");
		body.setPrice(100);
		body.setUserId("1");
		String port = environment.getProperty("local.server.port");
		ResponseEntity<String> res = restTemplate.postForEntity(new URI("http://localhost:" + port + "/discount"), body, String.class);
		assertEquals(" Your price: 70.0", res.getBody());
	}

}
