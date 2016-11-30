package lampquest.dto;

import lampquest.model.DirtLevel;
import lampquest.model.DirtLevelKey;

/**
 * Data transfer object for dirt level to mask model key attribute.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/26/2016
 */
public class DirtLevelDto {
    /**
     * dirt x-coordinate
     */
    private int dirtX;
    /**
     * dirt y-coordinate
     */
    private int dirtY;
    /**
     * dirt z-coordinate
     */
    private int dirtZ;
    /**
     * dungeon id of dungeon containing this dirt
     */
    private int dungeonId;

    /**
     * Creates a new DirtLevelDto with the given DirtLevel.
     * @param dirtLevel a dirt level entity
     */
    public DirtLevelDto(DirtLevel dirtLevel) {
        DirtLevelKey key = dirtLevel.getKey();
        this.dirtX = key.getDirtX();
        this.dirtY = key.getDirtY();
        this.dirtZ = key.getDirtZ();
        this.dungeonId = key.getDungeonId();
    }

    /**
     * Returns the dirt x-coordinate.
     * @return dirt x-coordinate
     */
    public int getDirtX() {
        return dirtX;
    }

    /**
     * Returns the dirt y-coordinate.
     * @return dirt y-coordinate
     */
    public int getDirtY() {
        return dirtY;
    }

    /**
     * Returns the dirt z-coordinate.
     * @return dirt z-coordinate
     */
    public int getDirtZ() {
        return dirtZ;
    }

    /**
     * Returns the dungeon id of the dungeon where this dirt is contained.
     * @return dungeon id of dungeon containing this dirt
     */
    public int getDungeonId() {
        return dungeonId;
    }
}
