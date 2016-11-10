package lampquest.dto;

/**
 * Created by Craig on 11/9/2016.
 */
public class MonsterDto {
    private int monsterId;
    private int monsterX;
    private int monsterY;
    private int monsterZ;
    private boolean isBoss;

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

    public int getMonsterZ() {
        return monsterZ;
    }

    public void setMonsterZ(int monsterZ) {
        this.monsterZ = monsterZ;
    }

    public boolean isBoss() {
        return isBoss;
    }

    public void setBoss(boolean isBoss) {
        this.isBoss = isBoss;
    }
}
