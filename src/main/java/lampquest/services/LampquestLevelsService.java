package lampquest.services;

import lampquest.dao.IDungeonsDao;
import lampquest.dao.ILampquestLevelsDao;
import lampquest.dto.*;
import lampquest.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Lampquest levels service implementation.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.1
 * @since 11/20/2016
 */
public class LampquestLevelsService implements ILampquestLevelsService {
    /**
     * Data access object for the Dungeons table
     */
    private IDungeonsDao dungeonsDao;
    /**
     * Data access object for the RoomsLevels table
     */
    private ILampquestLevelsDao<RoomLevel> roomsLevelsDao;
    /**
     * Data access object for the StairsLevels table
     */
    private ILampquestLevelsDao<StairsLevel> stairsLevelsDao;
    /**
     * Data access object for the StaticMonsters table
     */
    private ILampquestLevelsDao<StaticMonster> staticMonstersDao;
    /**
     * Data access object for the ItemsLevels table
     */
    private ILampquestLevelsDao<ItemLevel> itemsLevelsDao;

    /**
     * Constructs a new LampquestLevelsService with the required data access
     * objects.
     *
     * @param dungeonsDao data access object for the Dungeons table
     * @param roomsLevelsDao data access object for the RoomsLevels table
     * @param stairsLevelsDao data access object for the StairsLevels table
     * @param staticMonstersDao data access object for the StaticMonsters table
     * @param itemsLevelsDao data access object for the ItemsLevels table
     */
    public LampquestLevelsService(IDungeonsDao dungeonsDao,
                                  ILampquestLevelsDao<RoomLevel> roomsLevelsDao,
                                  ILampquestLevelsDao<StairsLevel> stairsLevelsDao,
                                  ILampquestLevelsDao<StaticMonster> staticMonstersDao,
                                  ILampquestLevelsDao<ItemLevel> itemsLevelsDao) {

        this.dungeonsDao = dungeonsDao;
        this.roomsLevelsDao = roomsLevelsDao;
        this.stairsLevelsDao = stairsLevelsDao;
        this.staticMonstersDao = staticMonstersDao;
        this.itemsLevelsDao = itemsLevelsDao;
    }

    /**
     * Retrieves and returns the data associated with the selected dungeon.
     *
     * @param dungeonId id of the selected dungeon
     *
     * @return selected dungeon data
     */
    @Override
    public SelectedDungeonDataDto getSelectedDungeonData(int dungeonId) {

        // convert item levels to dto to mask hibernate key features
        List<ItemLevelDto> itemLevels = new ArrayList<>();
        for (ItemLevel il : itemsLevelsDao.getRows(dungeonId)) {
            if (il != null) {
                itemLevels.add(new ItemLevelDto(il));
            }
        }

        // retrieve room levels and stairs levels - no need to convert
        List<RoomLevel> roomLevels = roomsLevelsDao.getRows(dungeonId);
        List<StairsLevel> stairsLevels = stairsLevelsDao.getRows(dungeonId);

        // convert static monsters to dto to mask hibernate key features
        List<StaticMonsterDto> staticMonsters = new ArrayList<>();
        for (StaticMonster sm : staticMonstersDao.getRows(dungeonId)) {
            if (sm != null) {
                staticMonsters.add(new StaticMonsterDto(sm));
            }
        }

        // create and return a new selected dungeon data dto
        return new SelectedDungeonDataDto(itemLevels, roomLevels,
                                          stairsLevels, staticMonsters);
    }

    /**
     * Overwrites existing dungeon level with the given dungeon level.
     *
     * @param dungeonLevel the new dungeon level
     */
    @Override
    public void updateLevel(DungeonLevelDto dungeonLevel) {

        // store common dungeon id and level
        int dungeonId = dungeonLevel.getDungeonId();
        int level = dungeonLevel.getLevel();

        // overwrite existing dungeon level with the given dungeon level
        updateStairsLevels(dungeonLevel.getStairs(), dungeonId, level);
        updateRoomsLevels(dungeonLevel.getRooms(), dungeonId, level);
        updateStaticMonsters(dungeonLevel.getMonsters(), dungeonId, level);
        updateItemsLevels(dungeonLevel.getItems(), dungeonId, level);
    }

    /**
     * Overwrites existing StairsLevels rows with the given dungeon id and
     * level with the given stairs.
     *
     * @param stairs stairs to be written to database
     * @param dungeonId dungeon id associated with given stairs
     * @param level dungeon level associated with given stairs
     */
    private void updateStairsLevels(List<StairsDto> stairs, int dungeonId,
                                    int level) {

        // update if stairs contains data
        if ((stairs != null) && (!stairs.isEmpty())) {

            // delete existing StairsLevels for dungeon id and level
            stairsLevelsDao.deleteRows(dungeonId, level);

            // convert stairs dto objects to StairsLevel entity objects
            List<StairsLevel> stairsLevels = new ArrayList<>(stairs.size());
            stairs.forEach(s -> stairsLevels.add(
                    new StairsLevel(s.getStairsX(), s.getStairsY(),
                                    level, dungeonId)
            ));

            // insert new StairsLevels rows
            stairsLevelsDao.insertRows(stairsLevels);
        }
    }

    /**
     * Overwrites existing RoomsLevels rows with the given dungeon id and level
     * with the given rooms.
     *
     * @param rooms rooms to be written to database
     * @param dungeonId dungeon id associated with given rooms
     * @param level dungeon level associated with given rooms
     */
    private void updateRoomsLevels(List<RoomDto> rooms, int dungeonId,
                                   int level) {

        // update if rooms contains data
        if ((rooms != null) && (!rooms.isEmpty())) {

            // delete existing RoomsLevels for dungeon id and level
            roomsLevelsDao.deleteRows(dungeonId, level);

            // convert rooms dto objects to RoomLevel entity objects
            List<RoomLevel> roomsLevels = new ArrayList<>(rooms.size());
            rooms.forEach(r -> roomsLevels.add(
                    new RoomLevel(dungeonId, level, r.getRoomId(),
                                  r.getStartX(), r.getStartY())
            ));

            // insert new RoomsLevels rows
            roomsLevelsDao.insertRows(roomsLevels);
        }
    }

    /**
     * Overwrites existing StaticMonsters with the given dungeon id and level
     * with the given monsters, and/or updates specified dungeon boss if the
     * given monsters contains a boss.
     *
     * @param monsters monsters to be written to database
     * @param dungeonId dungeon id associated with given monsters
     * @param level dungeon level associated with given monsters
     */
    private void updateStaticMonsters(List<MonsterDto> monsters, int dungeonId,
                                      int level) {

        // update if monsters contains data
        if ((monsters != null) && (!monsters.isEmpty())) {
            List<StaticMonster> staticMonsters = new ArrayList<>(monsters.size());

            // process each monster dto
            for (MonsterDto monster : monsters) {

                // if monster is a boss, update dungeon boss
                if (monster.isBoss()) {
                    dungeonsDao.updateBoss(dungeonId, monster.getMonsterId(),
                            monster.getMonsterX(), monster.getMonsterY(), level);

                // otherwise, convert monster to a StaticMonster entity and add
                // it to the list of static monsters to be inserted
                } else {
                    int mId = monster.getMonsterId();
                    int mX = monster.getMonsterX();
                    int mY = monster.getMonsterY();
                    staticMonsters.add(new StaticMonster(
                            new StaticMonsterKey(mId, mX, mY, dungeonId, level)
                    ));
                }
            }

            // if staticMonsters contains data, delete existing StaticMonsters
            // rows, then insert the new StaticMonsters
            if (!staticMonsters.isEmpty()) {
                staticMonstersDao.deleteRows(dungeonId, level);
                staticMonstersDao.insertRows(staticMonsters);
            }
        }
    }

    /**
     * Overwrites existing ItemsLevels rows with the given dungeon id and level
     * with the given items.
     *
     * @param items items to be written to ItemsLevels table
     * @param dungeonId dungeon id associated with given items
     * @param level dungeon level associated with given items
     */
    private void updateItemsLevels(List<ItemDto> items, int dungeonId,
                                   int level) {

        // update if items contains data
        if ((items != null) && (!items.isEmpty())) {

            // delete existing ItemsLevels rows for dungeon id and level
            itemsLevelsDao.deleteRows(dungeonId, level);

            // convert items to ItemLevel entity objects
            List<ItemLevel> itemsLevels = new ArrayList<>(items.size());
            for (ItemDto item : items) {
                ItemLevelKey key = new ItemLevelKey(item.getItemId(), dungeonId,
                        item.getItemX(), item.getItemY(), level);
                itemsLevels.add(new ItemLevel(key, item.getNumberInstances()));
            }

            // insert new ItemsLevels rows
            itemsLevelsDao.insertRows(itemsLevels);
        }
    }
}
