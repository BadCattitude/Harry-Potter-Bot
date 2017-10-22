package me.badcattitude.harrypotterbot;

import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class Main {
    // Entrypoint
    public static void main(String[] args) throws LoginException, InterruptedException, RateLimitedException {
        // Create bot instance
        new HPBot();
    }
}
