package lampquest.dto;

import lampquest.model.Dungeon;

public class DungeonDto {

    private int dungeonId;
    private String dungeonName;
    private int dungeonWidth;
    private int dungeonHeight;
    private int dungeonDepth;

    public DungeonDto(Dungeon dungeon) {
        this.dungeonId = dungeon.getDungeonId();
        this.dungeonName = dungeon.getDungeonName();
        this.dungeonWidth = dungeon.getDungeonWidth();
        this.dungeonHeight = dungeon.getDungeonHeight();
        this.dungeonDepth = dungeon.getDungeonDepth();
    }

    public int getDungeonId() {
        return dungeonId;
    }

    public String getDungeonName() {
        return dungeonName;
    }

    public int getDungeonWidth() {
        return dungeonWidth;
    }

    public int getDungeonHeight() {
        return dungeonHeight;
    }

    public int getDungeonDepth() {
        return dungeonDepth;
    }
}
