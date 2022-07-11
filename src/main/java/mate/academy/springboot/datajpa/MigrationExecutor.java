package mate.academy.springboot.datajpa;

import org.flywaydb.core.Flyway;

public class MigrationExecutor {
    public void migrate() {
        String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC";
        String user = "root";
        String password = "";

        Flyway flyway = Flyway.configure().dataSource(url, user, password ).load();
        flyway.migrate();
    }
}
