package org.example;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.DiscordObject;
import reactor.core.publisher.Mono;

public class Bot {
    private final DiscordClient client;
    private GatewayDiscordClient gateway;

    public Bot(String token){
        this.client = DiscordClient.create(token);
    }
    public Mono<Void> start(){
        GatewayDiscordClient gateway = client.login().block();
        if(gateway != null){
            return gateway.onDisconnect();
        }
        return Mono.empty();
    }
    public GatewayDiscordClient getGateWay(){
        if(gateway == null){
            throw new IllegalStateException("El gateway no se ha inicializadp");
        }
        return gateway;
    }
}
