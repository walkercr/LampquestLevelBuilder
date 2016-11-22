package lampquest.dto;

/**
 * Data transfer object for a room contained in a dungeon level.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/2/2016
 */
public class RoomDto {

    /**
     * room id
     */
    private int roomId;
    /**
     * room start x-position
     */
    private int startX;
    /**
     * room start y-position
     */
    private int startY;

    /**
     * Constructs an empty RoomDto.
     */
    public RoomDto() {}

    /**
     * Constructs a RoomDto with the given input.
     *
     * @param roomId room id
     * @param startX room start x-position
     * @param startY room start y-position
     */
    public RoomDto(int roomId, int startX, int startY) {
        setRoomId(roomId);
        setStartX(startX);
        setStartY(startY);
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
