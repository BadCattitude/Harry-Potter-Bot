package me.badcattitude.harrypotterbot.commands;

import net.dv8tion.jda.core.entities.Message;

/**
 * Basic ping command
 */
public class PingCommand extends Command {

    @Override
    public void execute(Message message, String[] args) {
        // reply with "Pong!"
        message.getChannel().sendMessage("Pong!").queue();
    }

    @Override
    public String getName() {
        return "ping";
    }

    // no extra aliases, so no need to override getAliases
}
