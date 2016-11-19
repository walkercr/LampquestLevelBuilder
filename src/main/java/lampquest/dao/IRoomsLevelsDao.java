package lampquest.dao;

import lampquest.dto.RoomDto;
import lampquest.model.RoomLevel;

import java.util.List;

/**
 * Data access object interface for the RoomsLevels table.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/2/2016
 */
public interface IRoomsLevelsDao {

    /**
     * Returns a list of all RoomsLevels rows containing the given dungeon id.
     *
     * @param dungeonId dungeon id of rows to be retrieved
     *
     * @return a list of all RoomsLevels rows containing the given dungeon id
     */
    List<RoomLevel> getRoomsLevels(int dungeonId);

    void deleteRoomsLevels(int dungeonId, int level);
    void insertRoomsLevels(List<RoomLevel> rooms);
}
