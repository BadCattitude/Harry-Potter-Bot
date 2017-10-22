package me.badcattitude.harrypotterbot;

import me.badcattitude.harrypotterbot.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Arrays;

/**
 * Listens for messages with commands
 */
class CommandListener extends ListenerAdapter {

    // the HPBot instance for accessing the prefix and commands
    private final HPBot parent;

    CommandListener(HPBot parent) {
        this.parent = parent;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        // ignore bots
        if (e.getAuthor().isBot()) return;

        String[] parts = e.getMessage().getContent().substring(parent.PREFIX.length()).split(" ");

        // ignore messages that don't start with the prefix
        if (!parts[0].startsWith(parent.PREFIX)) return;

        String command = parts[0].toLowerCase();

        // see if there is a command called `command`
        Command toExecute = parent.COMMANDS.get(command);

        // if there is, execute it
        if (toExecute != null) {
            toExecute.execute(e.getMessage(),
                    // if there is more than one word, the args should be every word after the command, otherwise an empty array
                    parts.length > 1 ? Arrays.copyOfRange(parts, 1, parts.length): new String[0]);
        }
    }
}
