package connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author alan
 */
public class ConexaoAzure {

    private JdbcTemplate connectionAz;

    public ConexaoAzure() {

        BasicDataSource dataSource = new BasicDataSource();

        //driver do banco usado --- pesquisar qual o do mysql
        dataSource​.setDriverClassName("com.microsoft.sqlserver."
                + "jdbc.SQLServerDriver");
        dataSource​.setUrl(
                "jdbc:sqlserver://database-stabillis.database.windows"
                + ".net:1433;database=database-stabillis;"
                + "user=admin-stabillis@database-stabillis;"
                + "password=#Gfgrupo6;encrypt=true;"
                + "trustServerCertificate=false;"
                + "hostNameInCertificate=*.database.windows.net;"
                + "loginTimeout=30;");
        dataSource​.setUsername("admin-stabillis");
        dataSource​.setPassword("#Gfgrupo6");

        this.connectionAz = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConnection() {
        return connectionAz;
    }
}
