package cine;

import org.flywaydb.core.Flyway;
import org.springframework.boot.test.mock.web.SpringBootMockServletContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;


@Configuration
@ComponentScan("cine")
public class ApplicationMock {

    @Bean
    public DataSource h2DataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean(initMethod = "migrate")
    Flyway flyway(DataSource dataSource) throws IOException {
        return Flyway.configure().locations("filesystem:../src/main/resources","filesystem:src/test/resources").baselineOnMigrate(true)
                .dataSource(dataSource).load();

    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
	
}
