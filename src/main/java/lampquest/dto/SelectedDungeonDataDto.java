package lampquest.dto;

import lampquest.model.RoomLevel;
import lampquest.model.StairsLevel;
import java.util.List;

/**
 * Data transfer object for the data associated with a selected dungeon.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/22/2016
 */
public class SelectedDungeonDataDto {

    /**
     * dirt levels for the selected dungeon
     */
    private List<DirtLevelDto> dirtLevels;
    /**
     * items levels for the selected dungeon
     */
    private List<ItemLevelDto> itemLevels;
    /**
     * rooms levels for the selected dungeon
     */
    private List<RoomLevel> roomLevels;
    /**
     * stairs levels for the selected dungeon
     */
    private List<StairsLevel> stairsLevels;
    /**
     * static monsters for the selected dungeon
     */
    private List<StaticMonsterDto> staticMonsters;

    /**
     * Constructs a SelectedDungeonDataDto with the given input.
     *
     * @param dirtLevels dirt levels for the selected dungeon
     * @param itemLevels items levels for the selected dungeon
     * @param roomLevels rooms levels for the selected dungeon
     * @param stairsLevels stairs levels for the selected dungeon
     * @param staticMonsters static monsters for the selected dungeon
     */
    public SelectedDungeonDataDto(List<DirtLevelDto> dirtLevels,
                                  List<ItemLevelDto> itemLevels,
                                  List<RoomLevel> roomLevels,
                                  List<StairsLevel> stairsLevels,
                                  List<StaticMonsterDto> staticMonsters) {
        this.dirtLevels = dirtLevels;
        this.itemLevels = itemLevels;
        this.roomLevels = roomLevels;
        this.stairsLevels = stairsLevels;
        this.staticMonsters = staticMonsters;
    }

    /**
     * Returns the list of dirt levels for the selected dungeon.
     * @return list of dirt levels
     */
    public List<DirtLevelDto> getDirtLevels() {
        return dirtLevels;
    }

    /**
     * Returns the list of items levels for the selected dungeon.
     * @return list of items levels
     */
    public List<ItemLevelDto> getItemLevels() {
        return itemLevels;
    }

    /**
     * Returns the list of rooms levels for the selected dungeon.
     * @return list of rooms levels
     */
    public List<RoomLevel> getRoomLevels() {
        return roomLevels;
    }

    /**
     * Returns the list of stairs levels for the selected dungeon.
     * @return list of stairs levels
     */
    public List<StairsLevel> getStairsLevels() {
        return stairsLevels;
    }

    /**
     * Returns the list of static monsters for the selected dungeon.
     * @return list of static monsters
     */
    public List<StaticMonsterDto> getStaticMonsters() {
        return staticMonsters;
    }
}
