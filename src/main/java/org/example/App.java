package org.example;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
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
        App app = new App();
        app.run();
    }
    public void run(){
        DiscordClient client = DiscordClient.create(System.getenv("DISCORD_TOKEN"));
        


        //Metodo inutil que devuelve el nombre del bot y su # (No tengo ide de como usar expresiones lambda)
        Mono<Void> login = client.withGateway((GatewayDiscordClient gateway) -> 
        gateway.on(ReadyEvent.class, event ->
        Mono.fromRunnable(() -> {
            final User self = event.getSelf();

        System.out.printf("Iniciado sesion con %s#%s%n", self.getUsername(), self.getDiscriminator());
        })));
        login.block();




    }
}
