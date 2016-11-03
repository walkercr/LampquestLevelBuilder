package lampquest.dto;

import java.util.List;

import lampquest.model.Room;
import lampquest.model.RoomLevel;

public class PaletteDto {

    private DungeonDto dungeon;
    private List<Room> rooms;
    private List<RoomLevel> roomLevels;

    public PaletteDto(DungeonDto dungeon, List<Room> rooms,
                      List<RoomLevel> roomLevels) {
        this.dungeon = dungeon;
        this.rooms = rooms;
        this.roomLevels = roomLevels;
    }

    public DungeonDto getDungeon() {
        return dungeon;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<RoomLevel> getRoomLevels() {
        return roomLevels;
    }
}
