package com.github.kernel1947.jedis.server;

public interface IEncoder {
	String encode(String data, Encode encode);
}
