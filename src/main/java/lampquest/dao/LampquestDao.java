package lampquest.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Data access object implementation for lampquest entities.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/19/2016
 */
public class LampquestDao<T> implements ILampquestDao<T> {

    /**
     * database session factory
     */
    protected final SessionFactory sessionFactory;
    /**
     * data access object entity class
     */
    protected final Class<T> entityClass;

    /**
     * Creates a new LampquestDao with the given database session factory
     * and entity class.
     *
     * @param sessionFactory database session factory
     * @param entityClass data access object entity class
     */
    public LampquestDao(SessionFactory sessionFactory, Class<T> entityClass) {
        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
    }

    /**
     * Returns all rows in the mapped entity class table.
     *
     * @return list of all rows in the table
     */
    @Override
    @Transactional
    public List<T> getAllRows() {

        // get all rows in the table
        @SuppressWarnings("unchecked")
        List<T> rows = sessionFactory.getCurrentSession()
                .createCriteria(entityClass).list();

        return rows;
    }
}
