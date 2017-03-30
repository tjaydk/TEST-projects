package data;

import org.neo4j.driver.v1.*;

import java.util.ArrayList;
import java.util.List;

public class DataAccessorNeo4J {

    public String testConnection(String query) {
        long t1 = System.currentTimeMillis();
        Driver driver = GraphDatabase.driver( "bolt://localhost:7687", AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();
        StatementResult result = session.run(query);

        session.close();
        driver.close();

        return (System.currentTimeMillis() - t1) + " ms";
    }
}
