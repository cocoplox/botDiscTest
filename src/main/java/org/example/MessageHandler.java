package org.example;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public class MessageHandler {

    public static Mono<Void> handleMessages(GatewayDiscordClient gateway) {
        return gateway.on(MessageCreateEvent.class, event -> {
            Message mensaje = event.getMessage();
            
            if (mensaje.getContent().equalsIgnoreCase("!ping")) {
                return mensaje.getChannel()
                    .flatMap(canal -> canal.createMessage("pong!"));
            }
            return Mono.empty();
        }).then();
     }
}
