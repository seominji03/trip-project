package one.trip;

import one.trip.repository.JdbcTemplateMemberRepository;
import one.trip.repository.MemberRepository;
import one.trip.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
