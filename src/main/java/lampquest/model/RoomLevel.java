package lampquest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RoomsLevels entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/2/2016
 */
@Entity
@Table(name = "RoomsLevels")
public class RoomLevel {

    /**
     * roomPK column (primary key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomPK;
    /**
     * dungeonId column
     */
    private int dungeonId;
    /**
     * depth column
     */
    private int depth;
    /**
     * roomId column
     */
    private int roomId;
    /**
     * startX column
     */
    private int startX;
    /**
     * startY column
     */
    private int startY;

    /**
     * Constructs an empty RoomLevel.
     */
    public RoomLevel() {}

    /**
     * Constructs a RoomLevel with the given input.
     *
     * @param dungeonId dungeon id
     * @param depth dungeon depth
     * @param roomId room id
     * @param startX room start x-position
     * @param startY room start y-position
     */
    public RoomLevel(int dungeonId, int depth, int roomId, int startX, int startY) {
        setDungeonId(dungeonId);
        setDepth(depth);
        setRoomId(roomId);
        setStartX(startX);
        setStartY(startY);
    }

    /**
     * Returns the room primary key.
     * @return room primary key
     */
    public int getRoomPK() {
        return roomPK;
    }

    /**
     * Sets the room primary key.
     * @param roomPK room primary key
     */
    public void setRoomPK(int roomPK) {
        this.roomPK = roomPK;
    }

    /**
     * Returns the dungeon id of the room.
     * @return dungeon id
     */
    public int getDungeonId() {
        return dungeonId;
    }

    /**
     * Sets the dungeon id of the room.
     * @param dungeonId dungeon id
     */
    public void setDungeonId(int dungeonId) {
        this.dungeonId = dungeonId;
    }

    /**
     * Returns the depth.
     * @return depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Sets the depth.
     * @param depth depth
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Returns the room id.
     * @return room id
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * Sets the room id.
     * @param roomId room id
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    /**
     * Returns the room start x-position.
     * @return room start x-position
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Sets the room start x-position.
     * @param startX room start x-position
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * Returns the room start y-position.
     * @return room start y-position
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Sets the room start y-position.
     * @param startY room start y-position
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }
}
