package lampquest.dto;

import lampquest.model.Dungeon;
import lampquest.model.Monster;
import lampquest.model.Room;

import java.util.List;

/**
 * Data transfer object for page load data.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/15/2016
 */
public class PageLoadDataDto {
    /**
     * all available dungeons
     */
    private List<Dungeon> dungeons;
    /**
     * all available rooms
     */
    private List<Room> rooms;
    /**
     * all available monsters
     */
    private List<Monster> monsters;

    /* Need to add list of Items when Items entity and DAO are written */
    // private List<Item> items;

    /**
     * Constructs a page load data DTO.
     *
     * @param dungeons available dungeons
     * @param rooms available rooms
     * @param monsters available monsters
     */
    public PageLoadDataDto(List<Dungeon> dungeons,
                           List<Room> rooms,
                           List<Monster> monsters) {
        this.dungeons = dungeons;
        this.rooms = rooms;
        this.monsters = monsters;
    }

    /**
     * Returns the available dungeons.
     *
     * @return available dungeons
     */
    public List<Dungeon> getDungeons() {
        return dungeons;
    }

    /**
     * Returns the available rooms.
     *
     * @return available rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Returns the available monsters.
     *
     * @return available monsters
     */
    public List<Monster> getMonsters() {
        return monsters;
    }
}
