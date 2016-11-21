package lampquest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RoomsLevels entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/2/2016
 */
@Entity
@Table(name = "StairsLevels")
public class StairsLevel {

    /**
     * stairsX column
     */
    private int stairsX;
    /**
     * stairsY column
     */
    private int stairsY;
    /**
     * stairsZ column
     */
    private int stairsZ;
    /**
     * dungeonId column
     */
    private int dungeonId;
    /**
     * stairsPK column (primary key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stairsPK;

    /**
     * Constructs an empty StairsLevel.
     */
    public StairsLevel() {}

    /**
     * Constructs a StairsLevel with the given input.
     *
     * @param stairsX stairs x-position
     * @param stairsY stairs y-position
     * @param stairsZ stairs z-position
     * @param dungeonId dungeon id
     */
    public StairsLevel(int stairsX, int stairsY, int stairsZ, int dungeonId) {
        setStairsX(stairsX);
        setStairsY(stairsY);
        setStairsZ(stairsZ);
        setDungeonId(dungeonId);
    }

    /**
     * Returns the stairs x-position.
     * @return stairs x-position
     */
    public int getStairsX() {
        return stairsX;
    }

    /**
     * Sets the stairs x-position.
     * @param stairsX stairs x-position
     */
    public void setStairsX(int stairsX) {
        this.stairsX = stairsX;
    }

    /**
     * Returns the stairs y-position.
     * @return stairs y-position
     */
    public int getStairsY() {
        return stairsY;
    }

    /**
     * Sets the stairs y-position.
     * @param stairsY stairs y-position
     */
    public void setStairsY(int stairsY) {
        this.stairsY = stairsY;
    }

    /**
     * Returns the stairs z-position.
     * @return stairs z-position
     */
    public int getStairsZ() {
        return stairsZ;
    }

    /**
     * Sets the stairs z-position.
     * @param stairsZ stairs z-position
     */
    public void setStairsZ(int stairsZ) {
        this.stairsZ = stairsZ;
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
     * Returns the stairs primary key.
     * @return stairs primary key
     */
    public int getStairsPK() {
        return stairsPK;
    }

    /**
     * Sets the stairs primary key.
     * @param stairsPK stairs primary key
     */
    public void setStairsPK(int stairsPK) {
        this.stairsPK = stairsPK;
    }
}
