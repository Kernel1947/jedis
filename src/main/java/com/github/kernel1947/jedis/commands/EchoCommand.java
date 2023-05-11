package com.github.kernel1947.jedis.commands;

import com.github.kernel1947.jedis.command.CommandContext;
import com.github.kernel1947.jedis.command.ICommand;
import com.github.kernel1947.jedis.server.Encode;
import com.github.kernel1947.jedis.server.Message;

public class EchoCommand implements ICommand {
	@Override
	public void execute(CommandContext ctx) {
		if(ctx.getArgs().size() == 1)
			ctx.getReply().reply(String.join(" ", ctx.getArgs()), Encode.BULK_STRING);
		else
			ctx.getReply().reply(Message.wrongArgumentCount(ctx.getCmd()), Encode.ERROR);
	}

	@Override
	public String getCommand() {
		return "echo";
	}

	@Override
	public String getHelp() {
		return "Echos Message";
	}
}
