package lampquest.dto;

import java.util.List;

import lampquest.model.Dungeon;
import lampquest.model.Monster;
import lampquest.model.Room;
import lampquest.model.RoomLevel;

public class BulkDataDto {

    private Dungeon dungeon;
    private List<Room> rooms;
    private List<RoomLevel> roomLevels;
    private List<Monster> monsters;

    public BulkDataDto(Dungeon dungeon, List<Room> rooms,
                       List<RoomLevel> roomLevels, List<Monster> monsters) {
        this.dungeon = dungeon;
        this.rooms = rooms;
        this.roomLevels = roomLevels;
        this.monsters = monsters;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<RoomLevel> getRoomLevels() {
        return roomLevels;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
}
