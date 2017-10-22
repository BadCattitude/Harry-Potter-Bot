package me.badcattitude.harrypotterbot.commands;

import net.dv8tion.jda.core.entities.Message;

/**
 * A generic command
 */
abstract public class Command {

    /**
     * Execute this command
     * @param message The message that triggered this command
     * @param args The arguments passed to this command. Should not include the command name itself
     */
    public abstract void execute(Message message, String[] args);

    /**
     * Get the name of this command
     *
     * This should return a lower case string of length > 0
     * @return The name of this command
     */
    public abstract String getName();

    /**
     * Get the aliases of this command
     *
     * By default, this returns an array of the command name
     * @return The aliases of this command
     */
    public String[] getAliases() {
        return new String[] {getName()};
    }
}
