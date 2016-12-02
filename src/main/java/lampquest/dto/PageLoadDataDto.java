package lampquest.dto;

import lampquest.model.Dungeon;
import lampquest.model.Item;
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
     * list of available dungeons
     */
    private List<Dungeon> dungeons;
    /**
     * list of available rooms
     */
    private List<Room> rooms;
    /**
     * list of available monsters
     */
    private List<Monster> monsters;
    /**
     * list of available items
     */
    private List<Item> items;

    /**
     * Constructs a page load data DTO.
     *
     * @param dungeons list of available dungeons
     * @param rooms list of available rooms
     * @param monsters list of available monsters
     */
    public PageLoadDataDto(List<Dungeon> dungeons,
                           List<Room> rooms,
                           List<Monster> monsters,
                           List<Item> items) {
        this.dungeons = dungeons;
        this.rooms = rooms;
        this.monsters = monsters;
        this.items = items;
    }

    /**
     * Returns the available dungeons.
     *
     * @return list of available dungeons
     */
    public List<Dungeon> getDungeons() {
        return dungeons;
    }

    /**
     * Returns the available rooms.
     *
     * @return list of available rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Returns the available monsters.
     *
     * @return list of available monsters
     */
    public List<Monster> getMonsters() {
        return monsters;
    }

    /**
     * Returns the available items.
     *
     * @return list of available items
     */
    public List<Item> getItems() {
        return items;
    }
}
