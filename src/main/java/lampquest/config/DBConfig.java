package lampquest.config;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lampquest.dao.*;
import lampquest.model.*;
import lampquest.services.*;

/**
 * Database configuration.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
@Configuration
@EnableTransactionManagement
public class DBConfig {

    /**
     * Returns a hibernate transaction manager that manages database
     * transactions.
     * @return hibernate transaction manager
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public HibernateTransactionManager transactionManager() throws IOException {
        HibernateTransactionManager txMgr = new HibernateTransactionManager();
        txMgr.setSessionFactory(sessionFactory());
        txMgr.afterPropertiesSet();
        return txMgr;
    }

    /**
     * Returns a session factory that provides database sessions.
     * @return session factory
     * @throws IOException if an I/O error occurs
     */
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
                StaticMonster.class,
                DirtLevel.class,
                ItemLevel.class
        );
        bean.afterPropertiesSet();
        return bean.getObject();        
    }

    /**
     * Returns a data source used to access the database.
     * @return database data source
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/lampquest2_0");
        dataSource.setUsername("root");
        dataSource.setPassword("Caiden_14");
        return dataSource;
    }

    /**
     * Returns hibernate properties specific to application database.
     * @return hibernate properties
     */
    private static Properties hibernateProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect",
                          "org.hibernate.dialect.MySQL5Dialect");
        props.setProperty("hibernate.show_sql", "true");
        return props;
    }

    /**
     * Returns a data access object for the Dungeons table.
     * @return Dungeons data access object
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public IDungeonsDao dungeonsDao() throws IOException {
        return new DungeonsDao(sessionFactory());
    }

    /**
     * Returns a data access object for the Rooms table.
     * @return Rooms data access object
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public ILampquestDao<Room> roomsDao() throws IOException {
        return new LampquestDao<>(sessionFactory(), Room.class);
    }

    /**
     * Returns a data access object for the RoomsLevels table.
     * @return RoomsLevels data access object
     * @throws IOException if an I/O error occurs
     */
    @Bean 
    public ILampquestLevelsDao<RoomLevel> roomsLevelsDao() throws IOException {

        final String mappedEntity = "RoomLevel";
        final String dungeonIdRef = "dungeonId";
        final String levelRef = "depth";

        return new LampquestLevelsDao<>(sessionFactory(), RoomLevel.class,
                                        mappedEntity, dungeonIdRef, levelRef);
    }

    /**
     * Returns a data access object for the Monsters table.
     * @return Monsters data access object
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public ILampquestDao<Monster> monstersDao() throws IOException {
        return new LampquestDao<>(sessionFactory(), Monster.class);
    }

    /**
     * Returns a data access object for the StairsLevels table.
     * @return StairsLevels data access object
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public ILampquestLevelsDao<StairsLevel> stairsLevelsDao()
            throws IOException {

        final String mappedEntity = "StairsLevel";
        final String dungeonIdRef = "dungeonId";
        final String levelRef = "stairsZ";

        return new LampquestLevelsDao<>(sessionFactory(), StairsLevel.class,
                                        mappedEntity, dungeonIdRef, levelRef);
    }

    /**
     * Returns a data access object for the StaticMonsters table.
     * @return StaticMonsters data access object
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public ILampquestLevelsDao<StaticMonster> staticMonstersDao()
            throws IOException {

        final String mappedEntity = "StaticMonster";
        final String dungeonIdRef = "key.dungeonId";
        final String levelRef = "key.depth";

        return new LampquestLevelsDao<>(sessionFactory(), StaticMonster.class,
                                        mappedEntity, dungeonIdRef, levelRef);
    }

    /**
     * Returns a data access object for the DirtLevels table.
     * @return DirtLevels data access object
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public ILampquestLevelsDao<DirtLevel> dirtLevelsDao()
            throws IOException {

        final String mappedEntity = "DirtLevel";
        final String dungeonIdRef = "key.dungeonId";
        final String levelRef = "key.dirtZ";

        return new LampquestLevelsDao<>(sessionFactory(), DirtLevel.class,
                                        mappedEntity, dungeonIdRef, levelRef);
    }

    /**
     * Returns a data access object for the ItemsLevels table.
     * @return ItemsLevels data access object
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public ILampquestLevelsDao<ItemLevel> itemsLevelsDao() throws IOException {

        final String mappedEntity = "ItemLevel";
        final String dungeonIdRef = "key.dungeonId";
        final String levelRef = "key.itemZ";

        return new LampquestLevelsDao<>(sessionFactory(), ItemLevel.class,
                                        mappedEntity, dungeonIdRef, levelRef);
    }

    /**
     * Returns a non-level-specific lampquest service provider used to service
     * Lampquest API requests.
     * @return non-level-specific lampquest service provider
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public ILampquestService lampquestService() throws IOException {
        return new LampquestService(dungeonsDao(), roomsDao(), monstersDao());
    }

    /**
     * Returns a level-specific lampquest service provider used to service
     * Lampquest API requests.
     * @return level-specific lampquest service provider
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public ILampquestLevelsService lampquestLevelsService() throws IOException {
        return new LampquestLevelsService(
                dungeonsDao(),
                roomsLevelsDao(),
                stairsLevelsDao(),
                staticMonstersDao(),
                dirtLevelsDao(),
                itemsLevelsDao()
        );
    }
}
