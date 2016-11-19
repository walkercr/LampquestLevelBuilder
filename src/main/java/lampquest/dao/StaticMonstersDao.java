package lampquest.dao;

import lampquest.model.StaticMonster;
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
public class StaticMonstersDao implements IStaticMonstersDao {

    /**
     * Database session factory
     */
    private SessionFactory sessionFactory;

    /**
     * Creates a new StaticMonstersDao with the given database session factory.
     *
     * @param sessionFactory database session factory
     */
    public StaticMonstersDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Returns a list of all StaticMonsters rows containing the given dungeon id.
     *
     * @param dungeonId dungeon id of rows to be retrieved
     *
     * @return a list of all StaticMonsters rows containing the given dungeon id
     */
    @Override
    @Transactional
    public List<StaticMonster> getStaticMonsters(int dungeonId) {
        Session session = sessionFactory.getCurrentSession();

        @SuppressWarnings("JpaQlInspection")
        Query query = session.createQuery(
                "select sm " +
                "from StaticMonster sm " +
                "where sm.dungeonId = :dungeonId"
        ).setParameter("dungeonId", dungeonId);

        @SuppressWarnings("unchecked")
        List<StaticMonster> staticMonsters =  query.list();

        return staticMonsters;
    }

    /**
     * Deletes all StaticMonsters rows with the given dungeon id and level.
     *
     * @param dungeonId dungeon id of rows to be deleted
     * @param level level of rows to be deleted
     */
    @Override
    @Transactional
    public void deleteStaticMonsters(int dungeonId, int level) {
        Session session = sessionFactory.getCurrentSession();

        @SuppressWarnings("JpaQlInspection")
        Query query = session.createQuery(
                "delete StaticMonster sm " +
                "where sm.dungeonId = :dungeonId " +
                "and sm.depth = :level"
        );

        query.setParameter("dungeonId", dungeonId);
        query.setParameter("level", level);
        query.executeUpdate();
    }

    /**
     * Inserts the given StairsLevel objects into the StairsLevels table.
     *
     * @param staticMonsters StaticMonsters to be inserted
     */
    @Override
    @Transactional
    public void insertStaticMonsters(List<StaticMonster> staticMonsters) {
        Session session = sessionFactory.getCurrentSession();
        staticMonsters.forEach(session::save);
    }
}
