package lampquest.config;

import javax.sql.DataSource;

import java.io.IOException;
import java.util.Properties;

import lampquest.model.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lampquest.dao.*;
import lampquest.services.*;

@Configuration
@EnableTransactionManagement
public class DBConfig {
    
    @Bean
    public HibernateTransactionManager transactionManager() throws IOException {
        HibernateTransactionManager txMgr = new HibernateTransactionManager();
        txMgr.setSessionFactory(sessionFactory());
        txMgr.afterPropertiesSet();
        return txMgr;
    }
    
    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource());
        bean.setHibernateProperties(hibernateProperties());
        bean.setPackagesToScan("lampquest.model");
        bean.setAnnotatedClasses(
                Dungeon.class,
                Monster.class,
                Room.class,
                RoomLevel.class,
                StairsLevel.class,
                StaticMonster.class
        );
        bean.afterPropertiesSet();
        return bean.getObject();        
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/lampquest2_0");
        dataSource.setUsername("root");
        dataSource.setPassword("Caiden_14");
        return dataSource;
    }
    
    private static Properties hibernateProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect",
                          "org.hibernate.dialect.MySQL5Dialect");
        props.setProperty("hibernate.show_sql", "true");
        return props;
    }
    
    @Bean
    public IDungeonsDao dungeonsDao() throws IOException {
        return new DungeonsDao(sessionFactory());
    }
    
    @Bean
    public IRoomsDao roomsDao() throws IOException {
        return new RoomsDao(sessionFactory());
    }
    
    @Bean 
    public IRoomsLevelsDao roomsLevelsDao() throws IOException {
        return new RoomsLevelsDao(sessionFactory());
    }

    @Bean
    public IMonstersDao monstersDao() throws IOException {
        return new MonstersDao(sessionFactory());
    }

    @Bean
    public IStairsLevelsDao stairsLevelsDao() throws IOException {
        return new StairsLevelsDao(sessionFactory());
    }

    @Bean
    public IStaticMonstersDao staticMonstersDao() throws IOException {
        return new StaticMonstersDao(sessionFactory());
    }
    
    @Bean
    public ILampquestService lampquestService() throws IOException {
        LampquestService lampquestService = new LampquestService();
        lampquestService.setDungeonsDao(dungeonsDao());
        lampquestService.setRoomsDao(roomsDao());
        lampquestService.setRoomsLevelsDao(roomsLevelsDao());
        lampquestService.setMonstersDao(monstersDao());
        lampquestService.setStairsLevelsDao(stairsLevelsDao());
        lampquestService.setStaticMonstersDao(staticMonstersDao());
        return lampquestService;
    }
}
