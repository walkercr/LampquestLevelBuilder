package lampquest.dao;

import lampquest.model.Monster;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Data access object implementation for the Monsters table.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/9/2016
 */
public class MonstersDao implements IMonstersDao {

    /**
     * Database session factory
     */
    private SessionFactory sessionFactory;

    /**
     * Creates a new RoomsDaoImpl with the given database session factory.
     *
     * @param sessionFactory database session factory
     */
    public MonstersDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Returns a list of all monsters in the database.
     *
     * @return a list of all monsters in the database
     */
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Monster> getAllMonsters() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Monster.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
