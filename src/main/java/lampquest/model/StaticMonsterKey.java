package lampquest.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Composite key for StaticMonster entity object.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/18/2016
 */
@Embeddable
public class StaticMonsterKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * monster id (StaticMonsters monsterId column)
     */
    private int monsterId;
    /**
     * monster x-position (StaticMonsters monsterX column)
     */
    private int monsterX;
    /**
     * monster y-position (StaticMonsters monsterY column)
     */
    private int monsterY;
    /**
     * monster dungeon id (StaticMonsters dungeonId column)
     */
    private int dungeonId;
    /**
     * monster dungeon depth (StaticMonsters depth column)
     */
    private int depth;

    /**
     * Constructs an empty StaticMonsterKey.
     */
    public StaticMonsterKey() {}

    /**
     * Constructs a StaticMonsterKey with the given input.
     *
     * @param monsterId monster id
     * @param monsterX monster x-position
     * @param monsterY monster y-position
     * @param dungeonId monster dungeon id
     * @param depth monster dungeon depth
     */
    public StaticMonsterKey(int monsterId, int monsterX, int monsterY,
                            int dungeonId, int depth) {
        setMonsterId(monsterId);
        setMonsterX(monsterX);
        setMonsterY(monsterY);
        setDungeonId(dungeonId);
        setDepth(depth);
    }

    /**
     * Returns the monster id.
     * @return monster id
     */
    public int getMonsterId() {
        return monsterId;
    }

    /**
     * Sets the monster id
     * @param monsterId monster id
     */
    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    /**
     * Returns the monster x-position.
     * @return monster x-position
     */
    public int getMonsterX() {
        return monsterX;
    }

    /**
     * Sets the monster x-position.
     * @param monsterX monster x-position
     */
    public void setMonsterX(int monsterX) {
        this.monsterX = monsterX;
    }

    /**
     * Returns the monster y-position.
     * @return monster y-position
     */
    public int getMonsterY() {
        return monsterY;
    }

    /**
     * Sets the monster y-position.
     * @param monsterY monster y-position
     */
    public void setMonsterY(int monsterY) {
        this.monsterY = monsterY;
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
     * Returns the dungeon depth.
     * @return dungeon depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Sets the dungeon depth.
     * @param depth dungeon depth
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Compares this and the given object for equality.
     * @param obj object to be compared
     * @return true for identical shallow comparison, otherwise false
     */
    @Override
    public boolean equals(Object obj) {

        // return false if given object is not a StaticMonsterKey
        if (!(obj instanceof StaticMonsterKey)) {
            return false;
        }

        // otherwise, return boolean result of shallow comparison
        StaticMonsterKey key = (StaticMonsterKey) obj;
        return (monsterId == key.monsterId)
                && (monsterX == key.monsterX)
                && (monsterY == key.monsterY)
                && (dungeonId == key.dungeonId)
                && (depth == key.depth);
    }

    /**
     * Returns a computed hash code for this StaticMonsterKey.
     * @return hash code
     */
    @Override
    public int hashCode() {
        return 13 * monsterId + 17 * monsterX + 23 * monsterY
                + 31 * dungeonId + 37 * depth;
    }
}
