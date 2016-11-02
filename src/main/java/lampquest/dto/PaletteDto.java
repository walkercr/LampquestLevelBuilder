package lampquest.dto;

import java.util.List;

import lampquest.model.Room;

public class PaletteDto {

    private DungeonDto dungeon;
    private List<Room> rooms;

    public PaletteDto(DungeonDto dungeon, List<Room> rooms) {
        this.dungeon = dungeon;
        this.rooms = rooms;
    }

    public DungeonDto getDungeon() {
        return dungeon;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
