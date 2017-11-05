package me.badcattitude.harrypotterbot;

import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class Main {
    // Entrypoint
    public static void main(String[] args) throws LoginException, InterruptedException, RateLimitedException {
        if (args.length < 1) {
            System.out.println("You must provide a token as a command-line argument!");
            return 1;
        }
        // Create bot instance
        new HPBot(args[0]);
    }
}
