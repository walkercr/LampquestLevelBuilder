package lampquest.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import lampquest.dao.*;
import lampquest.dto.*;
import lampquest.exceptions.DungeonNotFoundException;
import lampquest.model.*;

/**
 * Lampquest service implementation
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
     * Data access object for the StairsLevels table
     */
    private IStairsLevelsDao stairsLevelsDao;
    /**
     * Data access object for the StaticMonsters table
     */
    private IStaticMonstersDao staticMonstersDao;

    public void setDungeonsDao(IDungeonsDao dungeonsDao) {
        this.dungeonsDao = dungeonsDao;
    }

    public void setRoomsDao(IRoomsDao roomsDao) {
        this.roomsDao = roomsDao;
    }

    public void setRoomsLevelsDao(IRoomsLevelsDao roomsLevelsDao) {
        this.roomsLevelsDao = roomsLevelsDao;
    }

    public void setMonstersDao(IMonstersDao monstersDao) {
        this.monstersDao = monstersDao;
    }

    public void setStairsLevelsDao(IStairsLevelsDao stairsLevelsDao) {
        this.stairsLevelsDao = stairsLevelsDao;
    }

    public void setStaticMonstersDao(IStaticMonstersDao staticMonstersDao) {
        this.staticMonstersDao = staticMonstersDao;
    }

    /**
     * Returns a data transfer object containing all data needed to being a
     * session.
     *
     * @return all data needed to begin a session
     */
    public PageLoadDataDto getPageLoadData() {
        List<Dungeon> dungeons = dungeonsDao.getAllDungeons();
        List<Room> rooms = roomsDao.getAllRooms();
        List<Monster> monsters = monstersDao.getAllMonsters();

        /* Need to add items when task 12 is finished */

        return new PageLoadDataDto(dungeons, rooms, monsters);
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
    /* MARK FOR DELETION */
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

    public void updateLevel(DungeonLevelDto dungeonLevel) {
        int dungeonId = dungeonLevel.getDungeonId();
        int level = dungeonLevel.getDepth();

        updateStairsLevels(dungeonLevel.getStairs(), dungeonId, level);
        updateRoomsLevels(dungeonLevel.getRooms(), dungeonId, level);
        updateMonsters(dungeonLevel.getMonsters(), dungeonId, level);
    }

    private void updateStairsLevels(List<StairsDto> stairs, int dungeonId,
                                    int level) {

        if ((stairs != null) && (!stairs.isEmpty())) {
            stairsLevelsDao.deleteStairsLevels(dungeonId, level);

            List<StairsLevel> stairsLevels = new ArrayList<>(stairs.size());
            for (StairsDto dto : stairs) {
                stairsLevels.add(new StairsLevel(
                        dto.getStairsX(), dto.getStairsY(), dungeonId, level)
                );
            }
            stairsLevelsDao.insertStairsLevels(stairsLevels);
        }
    }

    private void updateRoomsLevels(List<RoomDto> rooms, int dungeonId,
                                   int level) {

        if ((rooms != null) && (!rooms.isEmpty())) {
            roomsLevelsDao.deleteRoomsLevels(dungeonId, level);

            List<RoomLevel> roomsLevels = new ArrayList<>(rooms.size());
            for (RoomDto dto : rooms) {
                roomsLevels.add(new RoomLevel(dungeonId, level, dto.getRoomId(),
                        dto.getStartX(), dto.getStartY()));
            }
            roomsLevelsDao.insertRoomsLevels(roomsLevels);
        }
    }

    private void updateMonsters(List<MonsterDto> monsters, int dungeonId,
                                int level) {

        if ((monsters != null) && (!monsters.isEmpty())) {
            List<StaticMonster> staticMonsters = new ArrayList<>(monsters.size());
            MonsterDto boss = null;

            for (MonsterDto dto : monsters) {
                if (dto.isBoss()) {
                    boss = dto;
                } else {
                    staticMonsters.add(new StaticMonster(
                            dto.getMonsterId(),
                            dto.getMonsterX(),
                            dto.getMonsterY(),
                            dungeonId,
                            level
                    ));
                }
            }

            if (!staticMonsters.isEmpty()) {
                staticMonstersDao.deleteStaticMonsters(dungeonId, level);
                staticMonstersDao.insertStaticMonsters(staticMonsters);
            }

            if (boss != null) {
                dungeonsDao.updateBoss(dungeonId, boss.getMonsterId(),
                        boss.getMonsterX(), boss.getMonsterY(), level);
            }
        }
    }
}

