package lampquest.services;

import lampquest.dao.IDungeonsDao;
import lampquest.dao.IRoomsDao;
import lampquest.dto.DungeonDto;
import lampquest.dto.PaletteDto;
import lampquest.exceptions.DungeonNotFoundException;
import lampquest.model.Dungeon;

/**
 * Service class implementation for obtaining a specified palette.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public class PaletteService implements IPaletteService {

    /**
     * Data access object for the Dungeons table
     */
    private IDungeonsDao dungeonsDao;
    /**
     * Data access object for the Rooms table
     */
    private IRoomsDao roomsDao;

    /**
     * Creates a new palette service implementation with the given dungeons and
     * rooms data access objects.
     *
     * @param dungeonsDao data access object for the Dungeons table
     * @param roomsDao data access object for the Rooms table
     */
    public PaletteService(IDungeonsDao dungeonsDao, IRoomsDao roomsDao) {
        this.dungeonsDao = dungeonsDao;
        this.roomsDao = roomsDao;
    }

    /**
     * Returns the palette for the specified dungeon id.
     *
     * @param dungeonId the dungeon id of the intended dungeon
     *
     * @return a palette with the specified dungeons and the list of rooms
     * @throws DungeonNotFoundException
     *     if the dungeonId is not found
     */
    @Override
    public PaletteDto getPalette(int dungeonId)
                                 throws DungeonNotFoundException {

        // retrieve the dungeon associated with the given id
        Dungeon dungeon = dungeonsDao.getDungeon(dungeonId);

        // throw exception if the given id is not associated with any dungeon
        if (dungeon == null) {
            throw new DungeonNotFoundException("Dungeon id does not exist");
        }

        // create and return the palette
        return new PaletteDto(new DungeonDto(dungeon), roomsDao.getAllRooms());
    }
}
