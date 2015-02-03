package utils;

import com.mongodb.Mongo;
import models.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;

/**
 * Created by Quentin on 01/02/15.
 */
public class MongoHelper {

    private static final Logger logger = LoggerFactory.getLogger(MongoHelper.class);

    public static Datastore getDatastore() {
        Datastore ds = null;
        Morphia morphia = new Morphia();
        try {
            Mongo mongo = new Mongo("localhost", 27017);
            morphia.map(User.class);
            ds = morphia.createDatastore(mongo, "BDD_PLAY");
            logger.info("Database : ok");
        } catch (UnknownHostException e) {
            logger.error("Database : ko");
            logger.error(e.getMessage());
        }
        return ds;
    }

}
