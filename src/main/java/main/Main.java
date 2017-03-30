package main;

import data.DataAccessor;
import data.DataAccessorNeo4J;

/**
 * Created by Emil on 28-03-2017.
 */
public class Main {

    public static void main(String[] args) {
        DataAccessor dataAccessor = new DataAccessor();
        DataAccessorNeo4J neo = new DataAccessorNeo4J();

        System.out.println("--------------MYSQL--------------");
        System.out.println("Start of database: " + dataAccessor.testQuery("SELECT u.name FROM t_user u WHERE u.name = 'Junko Heiney'"));
        System.out.println("Depth 1: " + dataAccessor.testQuery("SELECT u1.node_id, u1.name, u1.job, u1.birthday FROM t_user u1 JOIN t_endorsement e ON u1.node_id = e.target_node_id WHERE e.source_node_id = (SELECT (u.node_id) FROM t_user u WHERE u.name = 'Junko Heiney')"));
        System.out.println("Depth 2: " + dataAccessor.testQuery("SELECT  u2.node_id, u2.name, u2.birthday, u2.job FROM t_user u2 join t_endorsement e1 on u2.node_id = e1.target_node_id WHERE e1.source_node_id IN (SELECT u1.node_id FROM t_user u1 JOIN t_endorsement e ON u1.node_id = e.target_node_id WHERE e.source_node_id = (SELECT (u.node_id) FROM t_user u WHERE u.name = 'Junko Heiney'));"));
        System.out.println("Depth 3: " + dataAccessor.testQuery("SELECT u3.node_id, u3.name, u3.job, u3.birthday FROM t_user u3 JOIN t_endorsement e2 on u3.node_id = e2.target_node_id WHERE e2.source_node_id IN (SELECT  u2.node_id FROM t_user u2 JOIN t_endorsement e1 on u2.node_id = e1.target_node_id WHERE e1.source_node_id IN (SELECT u1.node_id FROM t_user u1 JOIN t_endorsement e ON u1.node_id = e.target_node_id WHERE e.source_node_id = (SELECT (u.node_id) FROM t_user u WHERE u.name = 'Junko Heiney')));"));
//        System.out.println("Depth 4: " + dataAccessor.testQuery("SELECT u4.node_id, u4.name, u4.job, u4.birthday FROM t_user u4 JOIN t_endorsement e3 ON u4.node_id = e3.target_node_id WHERE e3.source_node_id in(SELECT u3.node_id FROM t_user u3 JOIN t_endorsement e2 on u3.node_id = e2.target_node_id WHERE e2.source_node_id IN (SELECT  u2.node_id FROM t_user u2 JOIN t_endorsement e1 on u2.node_id = e1.target_node_id WHERE e1.source_node_id IN (SELECT u1.node_id FROM t_user u1 JOIN t_endorsement e ON u1.node_id = e.target_node_id WHERE e.source_node_id = (SELECT (u.node_id) FROM t_user u WHERE u.name = 'Junko Heiney'))));"));
//        System.out.println("Depth 5: " + dataAccessor.testQuery("SELECT u5.node_id, u5.name, u5.job, u5.birthday FROM t_user u5\n JOIN t_endorsement e4 ON u5.node_id = e4.target_node_id WHERE e4.source_node_id IN (SELECT u4.node_id FROM t_user u4 JOIN t_endorsement e3 on u4.node_id = e3.target_node_id WHERE e3.source_node_id in(SELECT u3.node_id FROM t_user u3 JOIN t_endorsement e2 on u3.node_id = e2.target_node_id WHERE e2.source_node_id IN (SELECT  u2.node_id FROM t_user u2 JOIN t_endorsement e1 on u2.node_id = e1.target_node_id WHERE e1.source_node_id IN (SELECT u1.node_id FROM t_user u1 JOIN t_endorsement e ON u1.node_id = e.target_node_id WHERE e.source_node_id = (SELECT (u.node_id) FROM t_user u WHERE u.name = 'Junko Heiney')))));"));

        System.out.println("--------------NEO4J--------------");
        System.out.println("Start of database: " + neo.testConnection("MATCH (me {name:\"Junko Heiney\"})-[:ENDORSES]->(other) RETURN other"));
        System.out.println("Depth 1: " + neo.testConnection("MATCH (me {name:\"Junko Heiney\"})-[:ENDORSES]->(other) RETURN other"));
        System.out.println("Depth 2: " + neo.testConnection("MATCH (me {name:\"Junko Heiney\"})-[:ENDORSES*2]->(other)RETURN other"));
        System.out.println("Depth 3: " + neo.testConnection("MATCH (me {name:\"Junko Heiney\"})-[:ENDORSES*3]->(other)RETURN other"));
//        System.out.println("Depth 4: " + neo.testConnection("MATCH (me {name:\"Junko Heiney\"})-[:ENDORSES*4]->(other)RETURN other"));
//        System.out.println("Depth 5: " + neo.testConnection("MATCH (me {name:\"Junko Heiney\"})-[:ENDORSES*5]->(other)RETURN other"));
    }

}
