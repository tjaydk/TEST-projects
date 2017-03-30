package main;

import data.DataAccessor;

/**
 * Created by Emil on 28-03-2017.
 */
public class Main {

    public static void main(String[] args) {
        DataAccessor dataAccessor = new DataAccessor();
        dataAccessor.testQuery("SELECT u1.node_id, u1.name, u1.job, u1.birthday FROM t_user u1 JOIN t_endorsement e ON u1.node_id = e.target_node_id WHERE e.source_node_id = (SELECT (u.node_id) FROM t_user u WHERE u.name = 'Junko Heiney')");
    }

}
