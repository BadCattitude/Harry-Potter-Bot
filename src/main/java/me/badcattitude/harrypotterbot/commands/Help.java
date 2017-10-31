package me.badcattitude.harrypotterbot.commands;

import net.dv8tion.jda.core.entities.Message;


public class Help extends Command {

    @Override
    public void execute(Message message, String[] args) {
        // reply with "Pong!"
        
        String website = "";
        message.getChannel().sendMessage("Here is a list of commands: " + website).queue();
    }

    @Override
    public String getName() {
        return "help";
    }

    // no extra aliases, so no need to override getAliases
}
