package connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author alan
 */
public class ConexaoEC2 {

    private JdbcTemplate connectionEc2;

    public ConexaoEC2() {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource​.setUrl("jdbc:mysql://0.0.0.0:3306/"
                + "stabillis?autoReconnect=true&useSSL=false");
        dataSource​.setUsername("root");
        dataSource​.setPassword("urubu100");

        this.connectionEc2 = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConnection() {
        return connectionEc2;
    }
}
