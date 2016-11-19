package lampquest.dao;

import lampquest.model.StairsLevel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Data access object implementation for the StairsLevels table.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/18/2016
 */
public class StairsLevelsDao implements IStairsLevelsDao {

    /**
     * Database session factory
     */
    private SessionFactory sessionFactory;

    /**
     * Creates a new StairsLevelsDao with the given database session factory.
     *
     * @param sessionFactory database session factory
     */
    public StairsLevelsDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Returns a list of all StairsLevels rows containing the given dungeon id.
     *
     * @param dungeonId dungeon id of rows to be retrieved
     *
     * @return a list of all StairsLevels rows containing the given dungeon id
     */
    @Override
    @Transactional
    public List<StairsLevel> getStairsLevels(int dungeonId) {
        Session session = sessionFactory.getCurrentSession();

        @SuppressWarnings("JpaQlInspection")
        Query query = session.createQuery(
                "select sl " +
                "from StairsLevel sl " +
                "where sl.dungeonId = :dungeonId"
        ).setParameter("dungeonId", dungeonId);

        @SuppressWarnings("unchecked")
        List<StairsLevel> stairsLevels =  query.list();

        return stairsLevels;
    }

    /**
     * Deletes all StairsLevels rows with the given dungeon id and level.
     *
     * @param dungeonId dungeon id of rows to be deleted
     * @param level level of rows to be deleted
     */
    @Override
    @Transactional
    public void deleteStairsLevels(int dungeonId, int level) {
        Session session = sessionFactory.getCurrentSession();

        @SuppressWarnings("JpaQlInspection")
        Query query = session.createQuery(
                "delete StairsLevel sl " +
                "where sl.dungeonId = :dungeonId " +
                "and sl.stairsZ = :level"
        );

        query.setParameter("dungeonId", dungeonId);
        query.setParameter("level", level);
        query.executeUpdate();
    }

    /**
     * Inserts the given StairsLevel objects into the StairsLevels table.
     *
     * @param stairs StairsLevel's to be inserted
     */
    @Override
    @Transactional
    public void insertStairsLevels(List<StairsLevel> stairs) {
        Session session = sessionFactory.getCurrentSession();
        stairs.forEach(session::save);
    }
}
