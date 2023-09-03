package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import data.services.FacilityDataService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import services.BookingDAO;
import services.FacilityDAO;
import services.MemberDAO;
import services.SQLScriptLoader;
import services.impl.jpa.BookingJPADAO;
import services.impl.jpa.FacilityJPADAO;
import services.impl.jpa.MemberJPADAO;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class SpringApplicationContext {

    @Bean
    public FacilityDataService facilityDataServiceBean(SessionFactory sf, FacilityDAO dao) {
        return new FacilityDataService(dao, sf);
    }

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public DataSource mainDataSource() throws SQLException, IOException {
        DriverManagerDataSource ds = new DriverManagerDataSource("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "user", "user");
        return ds;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource ds){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(ds);
        localSessionFactoryBean.setPackagesToScan("datamodel");
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }

    @Bean
    public MemberDAO MemberDAOBean(SessionFactory sf) {
        return new MemberJPADAO(sf);
    }

    @Bean
    public FacilityDAO facilityDAOBean(SessionFactory sf) {
        return new FacilityJPADAO(sf);
    }

    @Bean
    public BookingDAO bookingDAOBean(SessionFactory sf) {
        return new BookingJPADAO(sf);
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // Add more configuration if needed
        return objectMapper;
    }

}
