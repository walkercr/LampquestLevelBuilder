package lampquest.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Composite key for DirtLevel entity object.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/18/2016
 */
@Embeddable
public class DirtLevelKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * dungeon id (DirtLevels dungeonId column)
     */
    private int dungeonId;
    /**
     * dirt x-position (DirtLevels dirtX column)
     */
    private int dirtX;
    /**
     * dirt y-position (DirtLevels dirtY column)
     */
    private int dirtY;
    /**
     * dirt z-position (DirtLevels dirtZ column)
     */
    private int dirtZ;

    /**
     * Constructs an empty DirtLevelKey.
     */
    public DirtLevelKey() {}

    /**
     * Constructs a DirtLevelKey with the given input.
     *
     * @param dungeonId dungeon id
     * @param dirtX dirt x-position
     * @param dirtY dirt y-position
     * @param dirtZ dirt z-position
     */
    public DirtLevelKey(int dungeonId, int dirtX, int dirtY, int dirtZ) {
        setDungeonId(dungeonId);
        setDirtX(dirtX);
        setDirtY(dirtY);
        setDirtZ(dirtZ);
    }

    /**
     * Returns the dungeon id.
     * @return dungeon id
     */
    public int getDungeonId() {
        return dungeonId;
    }

    /**
     * Sets the dungeon id.
     * @param dungeonId dungeon id
     */
    public void setDungeonId(int dungeonId) {
        this.dungeonId = dungeonId;
    }

    /**
     * Returns the dirt x-position.
     * @return dirt x-position
     */
    public int getDirtX() {
        return dirtX;
    }

    /**
     * Sets the dirt x-position.
     * @param dirtX dirt x-position
     */
    public void setDirtX(int dirtX) {
        this.dirtX = dirtX;
    }

    /**
     * Returns the dirt y-position.
     * @return dirt y-position
     */
    public int getDirtY() {
        return dirtY;
    }

    /**
     * Sets the dirt y-position.
     * @param dirtY dirt y-position
     */
    public void setDirtY(int dirtY) {
        this.dirtY = dirtY;
    }

    /**
     * Returns the dirt z-position.
     * @return dirt z-position
     */
    public int getDirtZ() {
        return dirtZ;
    }

    /**
     * Sets the dirt z-position.
     * @param dirtZ dirt z-position
     */
    public void setDirtZ(int dirtZ) {
        this.dirtZ = dirtZ;
    }

    /**
     * Compares this and the given object for equality.
     * @param obj object to be compared
     * @return true for identical shallow comparison, otherwise false
     */
    @Override
    public boolean equals(Object obj) {

        // return false if given object is not a DirtLevelKey
        if (!(obj instanceof DirtLevelKey)) {
            return false;
        }

        // otherwise, return boolean result of shallow comparison
        DirtLevelKey key = (DirtLevelKey) obj;
        return (dungeonId == key.dungeonId) && (dirtX == key.dirtX)
                && (dirtY == key.dirtY) && (dirtZ == key.dirtZ);
    }

    /**
     * Returns a computed hash code for this DirtLevelKey.
     * @return hash code
     */
    @Override
    public int hashCode() {
        return 13 * dungeonId + 17 * dirtX + 23 * dirtY + 31 * dirtZ;
    }
}
