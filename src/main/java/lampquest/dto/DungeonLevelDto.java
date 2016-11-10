package lampquest.dto;

import java.util.List;

public class DungeonLevelDto {

    private int dungeonId;
    private int depth;
    private List<RoomDto> rooms;
    private List<MonsterDto> monsters;
    private List<StairsDto> stairs;
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

    public List<MonsterDto> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<MonsterDto> monsters) {
        this.monsters = monsters;
    }

    public List<StairsDto> getStairs() {
        return stairs;
    }

    public void setStairs(List<StairsDto> stairs) {
        this.stairs = stairs;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
