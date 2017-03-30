package data;

import org.neo4j.driver.v1.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ebbe Nielsen on 30/03/2017.
 */
public class DataAccessorNeo4J {

    public long testConnection(String query) {
        long t1 = System.currentTimeMillis();
        Driver driver = GraphDatabase.driver( "bolt://176.23.60.139:7687", AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();
        StatementResult result = session.run(query);

        session.close();
        driver.close();

        return System.currentTimeMillis() - t1;
    }
}
