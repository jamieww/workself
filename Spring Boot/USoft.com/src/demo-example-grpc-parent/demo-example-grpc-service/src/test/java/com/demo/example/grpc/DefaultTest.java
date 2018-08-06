/**
 *
 */
package com.demo.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.Test;

/**
 *
 */
public class DefaultTest {

	protected ManagedChannel grpcChannel;

	public DefaultTest() {
		String host = "127.0.0.1";
		grpcChannel = ManagedChannelBuilder.forAddress(host, 28800).usePlaintext().build();
	}

	@Test
	public void test() {
		System.out.println(97 + 102 + 105 + 94 + 82 + 60 + 90 * 0.7 + 84 * 0.3 + 84 * 0.3 + 98 * 0.3);
	}
}
