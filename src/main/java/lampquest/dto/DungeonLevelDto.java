package lampquest.dto;

import lampquest.model.Room;

import java.util.List;
import java.util.SplittableRandom;

public class DungeonLevelDto {

    private int dungeonId;
    private int depth;
    private List<RoomDto> rooms;
    private String filename;

    public int getDungeonId() {
        return dungeonId;
    }

    public void setDungeonId(int dungeonId) {
        this.dungeonId = dungeonId;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
