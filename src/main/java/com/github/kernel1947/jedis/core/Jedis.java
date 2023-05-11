package com.github.kernel1947.jedis.core;

import com.github.kernel1947.jedis.server.JedisServer;
import org.apache.commons.cli.*;

public class Jedis {
    public static void main(String[] args) throws ParseException {
		String host = "localhost";
		int port = 6379;

		Options	options = new Options();
		options.addOption("help", "help", false, "help");
		options.addOption("host", "host", true, "host");
		options.addOption("port", "port", true, "port");

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(options, args);

		if (cmd.hasOption("help")) {
			System.out.println(options);
			return;
		}

		if (cmd.hasOption("host"))
			host = cmd.getOptionValue("host");

		if (cmd.hasOption("port"))
			port = Integer.parseInt(cmd.getOptionValue("port"));

		JedisServer server = new JedisServer(host, port);
		server.run();
    }
}
