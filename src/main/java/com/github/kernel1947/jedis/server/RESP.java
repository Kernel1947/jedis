package com.github.kernel1947.jedis.server;

public class RESP {
	public static String nullBulkString() {
		return "$-1\r\n";
	}
}
