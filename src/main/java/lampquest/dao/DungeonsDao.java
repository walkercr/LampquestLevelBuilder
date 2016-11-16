package lampquest.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import lampquest.model.Dungeon;

import java.util.List;

/**
 * Data access object implementation for the Dungeons table.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public class DungeonsDao implements IDungeonsDao {

    /**
     * Database session factory
     */
    private SessionFactory sessionFactory;

    /**
     * Creates a new DungeonsDaoImpl with the given database session factory.
     *
     * @param sessionFactory database session factory
     */
    public DungeonsDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Returns a list of the dungeons in the database.
     *
     * @return list of dungeons in database
     */
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Dungeon> getAllDungeons() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Dungeon.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }

    /**
     * Returns the dungeon associated with the given id
     *
     * @param dungeonId the dungeon id of the intended dungeon
     *
     * @return the dungeon associated with the given id
     */
    @Override
    @Transactional
    public Dungeon getDungeon(int dungeonId) {
        return sessionFactory.getCurrentSession().get(Dungeon.class, dungeonId);
    }
}
