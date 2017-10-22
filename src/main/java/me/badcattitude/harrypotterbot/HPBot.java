package me.badcattitude.harrypotterbot;

import me.badcattitude.harrypotterbot.commands.Command;
import me.badcattitude.harrypotterbot.commands.PingCommand;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to hold JDA, commands, and the bot prefix
 */
class HPBot {

    // JDA of this bot
    private JDA jda;
    // bot's commands mapped to their aliases
    // e.g. "ping" -> PingCommand
    final Map<String, Command> COMMANDS;

    // default prefix
    final String PREFIX = "hp!";

    HPBot() throws LoginException, InterruptedException, RateLimitedException {
        jda = new JDABuilder(AccountType.BOT)
                .setToken("MzY4NTQ5NDE1MzM5OTUwMDgw.DM60MA.d76kBXu30Ge_gGFhurVdT1oZ8Bs")
                .addEventListener(new CommandListener(this))
                .buildBlocking();

        Map<String, Command> tempMap = new HashMap<>();

        // for every registered command...
        for (Command c : new Command[] {new PingCommand()}) {
            // for every alias of each command...
            for (String a : c.getAliases()) {
                // map the command to that alias
                tempMap.put(a, c);
            }
        }

        // make the command map immutable so it can't be changed later
        COMMANDS = Collections.unmodifiableMap(tempMap);
    }
}
