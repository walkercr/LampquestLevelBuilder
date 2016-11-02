package lampquest.dao;

import lampquest.model.Room;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Data access object implementation for the Rooms table.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public class RoomsDao implements IRoomsDao {

    /**
     * Database session factory
     */
    private SessionFactory sessionFactory;

    /**
     * Creates a new RoomsDaoImpl with the given database session factory.
     *
     * @param sessionFactory database session factory
     */
    public RoomsDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Returns a list of all rooms in the database.
     *
     * @return a list of all rooms in the database
     */
    @Override
    @Transactional
    public List<Room> getAllRooms() {
        @SuppressWarnings("unchecked")
        List<Room> rooms = sessionFactory.getCurrentSession()
                .createCriteria(Room.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        return rooms;
    }
}
