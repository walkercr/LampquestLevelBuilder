package lampquest.dao;

import java.util.List;
import lampquest.model.Room;

/**
 * Data access object interface for the Rooms table.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public interface IRoomsDao {

    /**
     * Returns a list of all rooms in the database.
     *
     * @return a list of all rooms in the database
     */
    List<Room> getAllRooms();
}
