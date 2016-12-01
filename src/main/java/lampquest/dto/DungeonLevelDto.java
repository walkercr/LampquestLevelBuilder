package lampquest.dto;

import java.util.List;

/**
 * Data transfer object for a complete dungeon level.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/22/2016
 */
public class DungeonLevelDto {

    /**
     * dungeon id
     */
    private int dungeonId;
    /**
     * dungeon level
     */
    private int level;
    /**
     * list of dungeon level rooms
     */
    private List<RoomDto> rooms;
    /**
     * list of dungeon level monsters (static monsters and/or dungeon boss)
     */
    private List<MonsterDto> monsters;
    /**
     * list of dungeon level stairs
     */
    private List<StairsDto> stairs;
    /**
     * list of dungeon level items
     */
    private List<ItemDto> items;

    /**
     * Returns the dungeon id.
     * @return dungeon id
     */
    public int getDungeonId() {
        return dungeonId;
    }

    /**
     * Sets the dungeon id.
     * @param dungeonId dungeon id
     */
    public void setDungeonId(int dungeonId) {
        this.dungeonId = dungeonId;
    }

    /**
     * Returns the dungeon level.
     * @return dungeon level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the dungeon level.
     * @param level dungeon level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Returns the dungeon level rooms.
     * @return list of dungeon level rooms
     */
    public List<RoomDto> getRooms() {
        return rooms;
    }

    /**
     * Sets the dungeon level rooms.
     * @param rooms list of dungeon level rooms
     */
    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }

    /**
     * Returns the dungeon level monsters (static monsters and/or dungeon boss).
     * @return list of dungeon level monsters
     */
    public List<MonsterDto> getMonsters() {
        return monsters;
    }

    /**
     * Sets the dungeon level monsters (static monsters and/or dungeon boss).
     * @param monsters list of dungeon level monsters
     */
    public void setMonsters(List<MonsterDto> monsters) {
        this.monsters = monsters;
    }

    /**
     * Returns the dungeon level stairs.
     * @return list of dungeon level stairs
     */
    public List<StairsDto> getStairs() {
        return stairs;
    }

    /**
     * Sets the dungeon level stairs.
     * @param stairs list of dungeon level stairs
     */
    public void setStairs(List<StairsDto> stairs) {
        this.stairs = stairs;
    }

    /**
     * Returns the dungeon level items.
     * @return list of dungeon level items
     */
    public List<ItemDto> getItems() {
        return items;
    }

    /**
     * Sets the dungeon level items.
     * @param items list of dungeon level items
     */
    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
