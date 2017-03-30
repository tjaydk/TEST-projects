package main;

import data.DataAccessorMySQL;
import data.DataAccessorNeo4J;

public class Main {

    public static void main(String[] args) {
        DataAccessorMySQL mySQL = new DataAccessorMySQL();
        DataAccessorNeo4J neo4J = new DataAccessorNeo4J();

        System.out.println("Running queries ...\n");

        System.out.println("MySQL - Junko Heiny: " + mySQL.testQuery("SELECT u.name FROM t_user u WHERE u.name = 'Junko Heiney'"));
        System.out.println("MySQL - Endorsements (Depth 1): " + mySQL.testQuery("SELECT u1.node_id, u1.name, u1.job, u1.birthday FROM t_user u1 JOIN t_endorsement e1 ON u1.node_id = e1.target_node_id INNER JOIN (SELECT node_id FROM t_user ORDER BY RAND() LIMIT 20) AS i ON e1.source_node_id = i.node_id;"));
        System.out.println("MySQL - Endorsements (Depth 2): " + mySQL.testQuery("SELECT u2.node_id, u2.name, u2.job, u2.birthday FROM t_user u2 JOIN t_endorsement e2 ON u2.node_id = e2.target_node_id WHERE e2.source_node_id IN (SELECT u1.node_id FROM t_user u1 JOIN t_endorsement e1 ON u1.node_id = e1.target_node_id INNER JOIN (SELECT node_id FROM t_user ORDER BY RAND() LIMIT 20) AS i ON e1.source_node_id = i.node_id);"));
        System.out.println("MySQL - Endorsements (Depth 3): " + mySQL.testQuery("SELECT u3.node_id, u3.name, u3.job, u3.birthday FROM t_user u3 JOIN t_endorsement e3 ON u3.node_id = e3.target_node_id WHERE e3.source_node_id IN (SELECT u2.node_id FROM t_user u2 JOIN t_endorsement e2 ON u2.node_id = e2.target_node_id WHERE e2.source_node_id IN (SELECT u1.node_id FROM t_user u1 JOIN t_endorsement e1 ON u1.node_id = e1.target_node_id INNER JOIN (SELECT node_id FROM t_user ORDER BY RAND() LIMIT 20) AS i ON e1.source_node_id = i.node_id));") + "\n");

        System.out.println("Neo4j - Junko Heiny: " + neo4J.testConnection("START p=node(*) MATCH (p:Person), (p{name: \"Junko Heiney\"}) RETURN p"));
        System.out.println("Neo4j - Endorsements (Depth 1): " + neo4J.testConnection("START u=node(*) MATCH (u:Person) WITH u, rand() AS number ORDER BY number LIMIT 20 MATCH(u)-[:ENDORSES]->(other) RETURN other"));
        System.out.println("Neo4j - Endorsements (Depth 2): " + neo4J.testConnection("START u=node(*) MATCH (u:Person) WITH u, rand() AS number ORDER BY number LIMIT 20 MATCH(u)-[:ENDORSES]->(other)-[:ENDORSES]->(other2) RETURN other2"));
        System.out.println("Neo4j - Endorsements (Depth 3): " + neo4J.testConnection("START u=node(*) MATCH (u:Person) WITH u, rand() AS number ORDER BY number LIMIT 20 MATCH(u)-[:ENDORSES]->(other)-[:ENDORSES]->(other2)-[:ENDORSES]->(other3) RETURN other3") + "\n");

        System.err.println("Depth 4 and 5, caused a memory overflow with Neo4j on our Virtual Machine with 12 gigabytes of distributed RAM.");
        System.err.println("We have left these out of the program, for that reason.");

    }

}
