package lampquest.model;

import javax.persistence.*;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int monsterId;

    private String monsterName;
    private String monsterChar;
    private String monsterColor;
    private int monsterHp;
    private int monsterSpeed;
    private String attacker;
    private String destructible;
    private String corpse;
    private String xp;
    private String levelUp;
    private String sight;
    private String special;
    private int monsterAttack;
    private int monsterVision;
    private int monsterDefense;

    public int getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getMonsterChar() {
        return monsterChar;
    }

    public void setMonsterChar(String monsterChar) {
        this.monsterChar = monsterChar;
    }

    public String getMonsterColor() {
        return monsterColor;
    }

    public void setMonsterColor(String monsterColor) {
        this.monsterColor = monsterColor;
    }

    public int getMonsterHp() {
        return monsterHp;
    }

    public void setMonsterHp(int monsterHp) {
        this.monsterHp = monsterHp;
    }

    public int getMonsterSpeed() {
        return monsterSpeed;
    }

    public void setMonsterSpeed(int monsterSpeed) {
        this.monsterSpeed = monsterSpeed;
    }

    public String getAttacker() {
        return attacker;
    }

    public void setAttacker(String attacker) {
        this.attacker = attacker;
    }

    public String getDestructible() {
        return destructible;
    }

    public void setDestructible(String destructible) {
        this.destructible = destructible;
    }

    public String getCorpse() {
        return corpse;
    }

    public void setCorpse(String corpse) {
        this.corpse = corpse;
    }

    public String getXp() {
        return xp;
    }

    public void setXp(String xp) {
        this.xp = xp;
    }

    public String getLevelUp() {
        return levelUp;
    }

    public void setLevelUp(String levelUp) {
        this.levelUp = levelUp;
    }

    public String getSight() {
        return sight;
    }

    public void setSight(String sight) {
        this.sight = sight;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public int getMonsterAttack() {
        return monsterAttack;
    }

    public void setMonsterAttack(int monsterAttack) {
        this.monsterAttack = monsterAttack;
    }

    public int getMonsterVision() {
        return monsterVision;
    }

    public void setMonsterVision(int monsterVision) {
        this.monsterVision = monsterVision;
    }

    public int getMonsterDefense(){
        return monsterDefense;
    }

    public void setMonsterDefense(int monsterDefense) {
        this.monsterDefense = monsterDefense;
    }
}
