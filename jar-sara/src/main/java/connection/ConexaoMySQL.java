package connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author alan
 */
public class ConexaoMySQL {

    private JdbcTemplate connectionMySql;

    public ConexaoMySQL() {
        BasicDataSource dataSource = new BasicDataSource();

        //driver do banco usado --- pesquisar qual o do mysql
        dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource​.setUrl("jdbc:mysql://localhost:3306/stabillis");
        dataSource​.setUsername("root");
        dataSource​.setPassword("rq@ln082@");

        this.connectionMySql = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConnection() {
        return connectionMySql;
    }
}
