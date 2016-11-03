package lampquest.dao;

import lampquest.model.RoomLevel;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * Returns a list of all RoomsLevels rows containing the given dungeon id.
     *
     * @param dungeonId dungeon id of rows to be retrieved
     *
     * @return a list of all RoomsLevels rows containing the given dungeon id
     */
    @Override
    @Transactional
    @SuppressWarnings({"unchecked", "JpaQlInspection"})
    public List<RoomLevel> getRoomsLevels(int dungeonId) {
        return sessionFactory.getCurrentSession()
                .createQuery(
                        "select rl " +
                        "from RoomLevel rl " +
                        "where rl.dungeonId = :dungeonId"
                ).setParameter("dungeonId", dungeonId)
                .list();
    }
}