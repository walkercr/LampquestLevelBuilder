package lampquest.dto;

/**
 * Data transfer object for a monster contained in a dungeon level.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/9/2016
 */
public class MonsterDto {

    /**
     * monster id
     */
    private int monsterId;
    /**
     * monster x-position
     */
    private int monsterX;
    /**
     * monster y-position
     */
    private int monsterY;
    /**
     * flag indicating that monster is or is not a dungeon boss
     */
    private boolean isBoss;

    /**
     * Constructs an empty MonsterDto.
     */
    public MonsterDto() {}

    /**
     * Constructs a MonsterDto with the given input.
     *
     * @param monsterId monster id
     * @param monsterX monster x-position
     * @param monsterY monster y-position
     * @param isBoss true if monster is a dungeon boss, otherwise false
     */
    public MonsterDto(int monsterId, int monsterX, int monsterY, boolean isBoss) {
        setMonsterId(monsterId);
        setMonsterX(monsterX);
        setMonsterY(monsterY);
        setIsBoss(isBoss);
    }

    /**
     * Returns the monster id.
     * @return monster id
     */
    public int getMonsterId() {
        return monsterId;
    }

    /**
     * Sets the monster id.
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
     * Returns a boolean value indicating that this monster is or is not a
     * dungeon boss.
     * @return true if monster is a dungeon boss, otherwise false
     */
    public boolean isBoss() {
        return isBoss;
    }

    /**
     * Sets a flag indicating that this monster is or is not a dungeon boss.
     * @param isBoss flag indicating if monster is a dungeon boss
     */
    public void setIsBoss(boolean isBoss) {
        this.isBoss = isBoss;
    }
}
