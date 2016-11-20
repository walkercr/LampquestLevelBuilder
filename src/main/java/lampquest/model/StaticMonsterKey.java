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

    private int monsterId;
    private int monsterX;
    private int monsterY;
    private int dungeonId;
    private int depth;

    public StaticMonsterKey() {}

    public StaticMonsterKey(int monsterId, int monsterX, int monsterY,
                            int dungeonId, int depth) {
        this.monsterId = monsterId;
        this.monsterX = monsterX;
        this.monsterY = monsterY;
        this.dungeonId = dungeonId;
        this.depth = depth;
    }

    public int getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    public int getMonsterX() {
        return monsterX;
    }

    public void setMonsterX(int monsterX) {
        this.monsterX = monsterX;
    }

    public int getMonsterY() {
        return monsterY;
    }

    public void setMonsterY(int monsterY) {
        this.monsterY = monsterY;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StaticMonsterKey)) {
            return false;
        }
        StaticMonsterKey key = (StaticMonsterKey) obj;

        return (monsterId == key.monsterId) && (monsterX == key.monsterX)
                && (monsterY == key.monsterY) && (dungeonId == key.dungeonId)
                && (depth == key.depth);
    }

    @Override
    public int hashCode() {
        return 13 * monsterId + 17 * monsterX + 23 * monsterY
                + 31 * dungeonId + 37 * depth;
    }
}
