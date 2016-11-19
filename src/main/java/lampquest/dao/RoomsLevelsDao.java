package lampquest.dao;

import lampquest.model.RoomLevel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
     * Creates a new RoomsLevelsDao with the given database session factory.
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
    public List<RoomLevel> getRoomsLevels(int dungeonId) {
        Session session = sessionFactory.getCurrentSession();

        @SuppressWarnings("JpaQlInspection")
        Query query = session.createQuery(
                "select rl " +
                "from RoomLevel rl " +
                "where rl.dungeonId = :dungeonId"
        ).setParameter("dungeonId", dungeonId);

        @SuppressWarnings("unchecked")
        List<RoomLevel> rooms = query.list();

        return rooms;
    }

    /**
     * Deletes all RoomsLevels rows with the given dungeon id and level.
     *
     * @param dungeonId dungeon id of rows to be deleted
     * @param level level of rows to be deleted
     */
    @Override
    @Transactional
    public void deleteRoomsLevels(int dungeonId, int level) {
        Session session = sessionFactory.getCurrentSession();

        @SuppressWarnings("JpaQlInspection")
        Query query = session.createQuery(
                "delete RoomLevel rl " +
                "where rl.dungeonId = :dungeonId " +
                "and rl.depth = :level"
        );

        query.setParameter("dungeonId", dungeonId);
        query.setParameter("level", level);
        query.executeUpdate();
    }

    /**
     * Inserts the given RoomLevel rows into the RoomsLevels table.
     *
     * @param rooms RoomsLevels to be inserted
     */
    @Override
    @Transactional
    public void insertRoomsLevels(List<RoomLevel> rooms) {
        Session session = sessionFactory.getCurrentSession();
        rooms.forEach(session::save);
    }
}