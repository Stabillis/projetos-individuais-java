package connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jonatas
 */
public class ConexaoEC2 {

    private JdbcTemplate connectionEc2;

    public ConexaoEC2() {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource​.setUrl("jdbc:mysql://Stabillis/stabillis");
        dataSource​.setUsername("root");
        dataSource​.setPassword("urubu100");

        this.connectionEc2 = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConnection() {
        return connectionEc2;
    }
}
