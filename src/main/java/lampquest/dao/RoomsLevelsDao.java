package lampquest.dao;

import org.hibernate.SessionFactory;

/**
 * Data access object implementation for the RoomsLevels table.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public class RoomsLevelsDao implements IRoomsLevelsDao {

    /**
     * Database session factory
     */
    private SessionFactory sessionFactory;

    /**
     * Creates a new RoomsLevelsDaoImpl with the given database session factory.
     *
     * @param sessionFactory database session factory
     */
    public RoomsLevelsDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}