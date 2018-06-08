package Main;

import Model.Database;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {

    public static final String BASE_URI = "http://localhost:8085/" ;

    public static HttpServer startServer(){
        final ResourceConfig rc = new ResourceConfig().packages("Main").register(DeclarativeLinkingFeature.class).packages("org.glassfish.jersey.examples.linking").register(RestError.class).register(new CORSFilter());

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException{


        final HttpServer server = startServer();

        System.out.println(String.format("Jersey app started with WADL avalaible at" + "%sapplication.wadl\nHit Enter to stop it...", BASE_URI));
        System.in.read();
        server.shutdownNow();


    }

}
