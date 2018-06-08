package Main;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class DatabaseInit {

    private static DatabaseInit instance = new DatabaseInit();
    private static Datastore datastore;

    public DatabaseInit(){
        final Morphia morphia = new Morphia();
        morphia.mapPackage("Model");
        datastore = morphia.createDatastore(new MongoClient(), "eProto");
    }

    public static Datastore getDatastore(){
        return datastore;
    }

}
