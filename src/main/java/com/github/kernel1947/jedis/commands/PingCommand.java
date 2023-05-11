package com.github.kernel1947.jedis.commands;

import com.github.kernel1947.jedis.command.CommandContext;
import com.github.kernel1947.jedis.command.ICommand;
import com.github.kernel1947.jedis.server.Encode;
import com.github.kernel1947.jedis.server.Message;

public class PingCommand implements ICommand {
	@Override
	public void execute(CommandContext ctx) {
		if(ctx.getArgs().isEmpty())
			ctx.getReply().reply("PONG", Encode.SIMPLE_STRING);
		else if(ctx.getArgs().size() == 1)
			ctx.getReply().reply(String.join(" ", ctx.getArgs()), Encode.BULK_STRING);
		else
			ctx.getReply().reply(Message.wrongArgumentCount(ctx.getCmd()), Encode.ERROR);
	}

	@Override
	public String getCommand() {
		return "ping";
	}

	@Override
	public String getHelp() {
		return "Test Connection";
	}
}
