package lampquest.services;

import java.io.IOException;
import java.io.PrintWriter;

import lampquest.dao.IDungeonsDao;
import lampquest.dao.IMonstersDao;
import lampquest.dao.IRoomsDao;
import lampquest.dao.IRoomsLevelsDao;
import lampquest.dto.BulkDataDto;
import lampquest.dto.DungeonLevelDto;
import lampquest.dto.RoomDto;
import lampquest.exceptions.DungeonNotFoundException;
import lampquest.model.Dungeon;

/**
 * Service class implementation for adding a dungeon level.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public class LampquestService implements ILampquestService {

    /**
     * Data access object for the Dungeons table
     */
    private IDungeonsDao dungeonsDao;
    /**
     * Data access object for the Rooms table
     */
    private IRoomsDao roomsDao;
    /**
     * Data access object for the RoomsLevels table
     */
    private IRoomsLevelsDao roomsLevelsDao;
    /**
     * Data access object for the Monsters table
     */
    private IMonstersDao monstersDao;

    /**
     * Creates a new palette service implementation with the given dungeons and
     * rooms data access objects.
     *
     * @param dungeonsDao data access object for the Dungeons table
     * @param roomsDao data access object for the Rooms table
     */
    public LampquestService(IDungeonsDao dungeonsDao,
                            IRoomsDao roomsDao,
                            IRoomsLevelsDao roomsLevelsDao,
                            IMonstersDao monstersDao) {

        this.dungeonsDao = dungeonsDao;
        this.roomsDao = roomsDao;
        this.roomsLevelsDao = roomsLevelsDao;
        this.monstersDao = monstersDao;
    }

    /**
     * Returns bulk data for the specified dungeon id.
     *
     * @param dungeonId the dungeon id of the intended dungeon
     *
     * @return bulk data for the specified dungeon id
     * @throws DungeonNotFoundException
     *     if the dungeonId is not found
     */
    @Override
    public BulkDataDto getBulkData(int dungeonId)
            throws DungeonNotFoundException {

        // retrieve the dungeon associated with the given id
        Dungeon dungeon = dungeonsDao.getDungeon(dungeonId);

        // throw exception if the given id is not associated with any dungeon
        if (dungeon == null) {
            throw new DungeonNotFoundException("Dungeon id does not exist");
        }

        // create and return the palette
        return new BulkDataDto(dungeon,
                roomsDao.getAllRooms(),
                roomsLevelsDao.getRoomsLevels(dungeonId),
                monstersDao.getAllMonsters());
    }

    /**
     * Generates a SQL script to add the given dungeon level to the database.
     *
     * @param dungeonLevelDto data transfer object containing the dungeon level
     *                        information
     *                        
     * @throws IOException
     *     if an I/O error occurs
     */
    public void scriptDungeonLevel(DungeonLevelDto dungeonLevelDto) 
                                   throws IOException {

        String insert = "INSERT INTO RoomsLevels (dungeonId, depth, "
                        + "roomId, startX, startY) VALUES (";
        String comma = ", ";
        String endStatement = ");";

        // generate dungeon level script
        try (PrintWriter out = new PrintWriter(dungeonLevelDto.getFilename())) {
            int dungeonId = dungeonLevelDto.getDungeonId();
            int depth = dungeonLevelDto.getDepth();

            for (RoomDto room : dungeonLevelDto.getRooms()) {
                out.println(
                        new StringBuilder(insert)
                                .append(dungeonId).append(comma)
                                .append(depth).append(comma)
                                .append(room.getRoomId()).append(comma)
                                .append(room.getStartX()).append(comma)
                                .append(room.getStartY()).append(endStatement)
                                .toString()
                );
            }
        }
    }
}

