package org.example;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import reactor.core.publisher.Mono;

/**
 * Mati agachate a comerme las bolas
 *
 */
public class App 
{


    public static void main( String[] args )
    {
        String token = System.getenv("DISCORD_TOKEN");
        if(token == null || token.isEmpty()){
            System.err.println("El token de Discord no esta configurado pa");
            return;
        }

        Bot bot = new Bot(token);
        Mono<Void> login = bot.start()
        .then(MessageHandler.handleMessages(bot.getGateWay()));

        login.block();
    }

    
}
