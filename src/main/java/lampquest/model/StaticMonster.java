package lampquest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * StaticMonsters entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 101/18/2016
 */
@Entity
@Table(name = "StaticMonsters")
public class StaticMonster {

    @Id
    private int monsterId;
    private int monsterX;
    private int monsterY;
    private int dungeonId;
    private int depth;

    public StaticMonster() {}

    public StaticMonster(int monsterId, int monsterX, int monsterY,
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
}
