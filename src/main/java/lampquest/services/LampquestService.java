package lampquest.services;

import java.util.List;
import lampquest.dao.IDungeonsDao;
import lampquest.dao.ILampquestDao;
import lampquest.dto.PageLoadDataDto;
import lampquest.model.Dungeon;
import lampquest.model.Monster;
import lampquest.model.Room;

/**
 * Lampquest service implementation
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.1
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
    private ILampquestDao<Room> roomsDao;
    /**
     * Data access object for the Monsters table
     */
    private ILampquestDao<Monster> monstersDao;

    /**
     * Constructs a new LampquestService with the required data access objects.
     *
     * @param dungeonsDao data access object for the Dungeons table
     * @param roomsDao data access object for the Rooms table
     * @param monstersDao data access object for the Monsters table
     */
    public LampquestService(IDungeonsDao dungeonsDao,
                            ILampquestDao<Room> roomsDao,
                            ILampquestDao<Monster> monstersDao) {

        this.dungeonsDao = dungeonsDao;
        this.roomsDao = roomsDao;
        this.monstersDao = monstersDao;
    }

    /**
     * Returns a data transfer object containing all data needed to being a
     * session.
     *
     * @return all data needed to begin a session
     */
    @Override
    public PageLoadDataDto getPageLoadData() {
        List<Dungeon> dungeons = dungeonsDao.getAllRows();
        List<Room> rooms = roomsDao.getAllRows();
        List<Monster> monsters = monstersDao.getAllRows();

        /* Need to add items when task 12 is finished */

        return new PageLoadDataDto(dungeons, rooms, monsters);
    }
}

