package lampquest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rooms entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
@Entity
@Table(name = "Rooms")
public class Room {

    /**
     * roomId column (primary key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;
    /**
     * roomName column
     */
    private String roomName;
    /**
     * roomWidth column
     */
    private int roomWidth;
    /**
     * roomHeight column
     */
    private int roomHeight;

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
     * Returns the room name.
     * @return room name
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Sets the room name.
     * @param roomName room name
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * Returns the room width.
     * @return room width
     */
    public int getRoomWidth() {
        return roomWidth;
    }

    /**
     * Sets the room width.
     * @param roomWidth room width
     */
    public void setRoomWidth(int roomWidth) {
        this.roomWidth = roomWidth;
    }

    /**
     * Returns the room height.
     * @return room height
     */
    public int getRoomHeight() {
        return roomHeight;
    }

    /**
     * Sets the room height.
     * @param roomHeight room height
     */
    public void setRoomHeight(int roomHeight) {
        this.roomHeight = roomHeight;
    }
}

