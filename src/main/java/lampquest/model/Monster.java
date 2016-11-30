package lampquest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Monsters entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
@Entity
@Table(name = "Monsters")
public class Monster {

    /**
     * monsterId column (primary key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int monsterId;
    /**
     * monsterName column
     */
    private String monsterName;
    /**
     * monsterChar column
     */
    private String monsterChar;
    /**
     * monsterColor column
     */
    private String monsterColor;
    /**
     * monsterHp column
     */
    private int monsterHp;
    /**
     * monsterSpeed column
     */
    private int monsterSpeed;
    /**
     * attacker column
     */
    private String attacker;
    /**
     * destructible column
     */
    private String destructible;
    /**
     * corpse column
     */
    private String corpse;
    /**
     * xp column
     */
    private String xp;
    /**
     * levelUp column
     */
    private String levelUp;
    /**
     * sight column
     */
    private String sight;
    /**
     * special column
     */
    private String special;
    /**
     * monsterAttack column
     */
    private int monsterAttack;
    /**
     * monsterVision column
     */
    private int monsterVision;
    /**
     * monsterDefense column
     */
    private int monsterDefense;

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
     * Returns the monster name.
     * @return monster name
     */
    public String getMonsterName() {
        return monsterName;
    }

    /**
     * Sets the monster name.
     * @param monsterName monster name
     */
    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    /**
     * Returns the monster character.
     * @return monster character
     */
    public String getMonsterChar() {
        return monsterChar;
    }

    /**
     * Sets the monster character.
     * @param monsterChar monster character
     */
    public void setMonsterChar(String monsterChar) {
        this.monsterChar = monsterChar;
    }

    /**
     * Returns the monster color.
     * @return monster color
     */
    public String getMonsterColor() {
        return monsterColor;
    }

    /**
     * Sets the monster color.
     * @param monsterColor monster color
     */
    public void setMonsterColor(String monsterColor) {
        this.monsterColor = monsterColor;
    }

    /**
     * Returns the monster hit points.
     * @return monster hit points
     */
    public int getMonsterHp() {
        return monsterHp;
    }

    /**
     * Sets the monster hit points.
     * @param monsterHp monster hit points
     */
    public void setMonsterHp(int monsterHp) {
        this.monsterHp = monsterHp;
    }

    /**
     * Returns the monster speed.
     * @return monster speed
     */
    public int getMonsterSpeed() {
        return monsterSpeed;
    }

    /**
     * Sets the monster speed.
     * @param monsterSpeed monster speed
     */
    public void setMonsterSpeed(int monsterSpeed) {
        this.monsterSpeed = monsterSpeed;
    }

    /**
     * Returns the attacker value (Y/N).
     * @return attacker value (Y/N)
     */
    public String getAttacker() {
        return attacker;
    }

    /**
     * Sets the attacker value (Y/N).
     * @param attacker attacker value (Y/N)
     */
    public void setAttacker(String attacker) {
        this.attacker = attacker;
    }

    /**
     * Returns the destructible value (Y/N).
     * @return destructible value (Y/N)
     */
    public String getDestructible() {
        return destructible;
    }

    /**
     * Sets the destructible value (Y/N).
     * @param destructible destructible value (Y/N)
     */
    public void setDestructible(String destructible) {
        this.destructible = destructible;
    }

    /**
     * Returns the corpse value (Y/N).
     * @return corpse value (Y/N)
     */
    public String getCorpse() {
        return corpse;
    }

    /**
     * Sets the corpse value (Y/N).
     * @param corpse corpse value (Y/N)
     */
    public void setCorpse(String corpse) {
        this.corpse = corpse;
    }

    /**
     * Returns the xp value (Y/N).
     * @return xp value (Y/N)
     */
    public String getXp() {
        return xp;
    }

    /**
     * Sets the xp value (Y/N).
     * @param xp xp value (Y/N)
     */
    public void setXp(String xp) {
        this.xp = xp;
    }

    /**
     * Returns the level up value (Y/N).
     * @return level up value (Y/N)
     */
    public String getLevelUp() {
        return levelUp;
    }

    /**
     * Sets the level up value (Y/N).
     * @param levelUp level up value (Y/N)
     */
    public void setLevelUp(String levelUp) {
        this.levelUp = levelUp;
    }

    /**
     * Returns the sight value (Y/N).
     * @return sight value (Y/N)
     */
    public String getSight() {
        return sight;
    }

    /**
     * Sets the sight value (Y/N).
     * @param sight sight value (Y/N)
     */
    public void setSight(String sight) {
        this.sight = sight;
    }

    /**
     * Returns the special value (Y/N).
     * @return special value value (Y/N)
     */
    public String getSpecial() {
        return special;
    }

    /**
     * Sets the special value (Y/N).
     * @param special special value (Y/N)
     */
    public void setSpecial(String special) {
        this.special = special;
    }

    /**
     * Returns the monster attack.
     * @return monster attack
     */
    public int getMonsterAttack() {
        return monsterAttack;
    }

    /**
     * Sets the monster attack.
     * @param monsterAttack monster attack
     */
    public void setMonsterAttack(int monsterAttack) {
        this.monsterAttack = monsterAttack;
    }

    /**
     * Returns the monster vision.
     * @return monster vision
     */
    public int getMonsterVision() {
        return monsterVision;
    }

    /**
     * Sets the monster vision.
     * @param monsterVision monster vision
     */
    public void setMonsterVision(int monsterVision) {
        this.monsterVision = monsterVision;
    }

    /**
     * Returns the monster defense.
     * @return monster defense
     */
    public int getMonsterDefense(){
        return monsterDefense;
    }

    /**
     * Sets the monster defense.
     * @param monsterDefense monster defense
     */
    public void setMonsterDefense(int monsterDefense) {
        this.monsterDefense = monsterDefense;
    }
}
