package com.killeen.asynctesterclient;

import java.time.LocalTime;

import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Callback implements InvocationCallback<String> {
	final Logger LOG = LoggerFactory.getLogger(Callback.class);
	public Callback() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void completed(String response) {
		System.out.println(LocalTime.now()+ " We received a response " );
        System.out.println(response);
	}

	@Override
	public void failed(Throwable throwable) {
		System.out.println(LocalTime.now()+ " We received an error " + throwable.getMessage());
		throwable.printStackTrace();

	}

}
