package com.github.kernel1947.jedis.command;

public interface ICommand {
	void execute(CommandContext ctx);
	String getCommand();
	String getHelp();
}
