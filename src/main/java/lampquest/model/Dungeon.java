package lampquest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dungeons entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
@Entity
@Table(name = "Dungeons")
public class Dungeon {

    /**
     * dungeonId column (primary key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dungeonId;
    /**
     * dungeonName column
     */
    private String dungeonName;
    /**
     * dungeonWidth column
     */
    private int dungeonWidth;
    /**
     * dungeonHeight column
     */
    private int dungeonHeight;
    /**
     * dungeonDepth column
     */
    private int dungeonDepth;
    /**
     * playerX column
     */
    private int playerX;
    /**
     * playerY column
     */
    private int playerY;
    /**
     * boss column
     */
    private int boss;
    /**
     * bossX column
     */
    private int bossX;
    /**
     * bossY column
     */
    private int bossY;
    /**
     * bossZ column
     */
    private int bossZ;
    /**
     * description column
     */
    private String description;

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
     * Returns the dungeon name.
     * @return dungeon name
     */
    public String getDungeonName() {
        return dungeonName;
    }

    /**
     * Sets the dungeon name.
     * @param dungeonName dungeon name
     */
    public void setDungeonName(String dungeonName) {
        this.dungeonName = dungeonName;
    }

    /**
     * Returns the dungeon width.
     * @return dungeon width
     */
    public int getDungeonWidth() {
        return dungeonWidth;
    }

    /**
     * Sets the dungeon width.
     * @param dungeonWidth dungeon width
     */
    public void setDungeonWidth(int dungeonWidth) {
        this.dungeonWidth = dungeonWidth;
    }

    /**
     * Returns the dungeon height.
     * @return dungeon height
     */
    public int getDungeonHeight() {
        return dungeonHeight;
    }

    /**
     * Sets the dungeon height.
     * @param dungeonHeight dungeon height
     */
    public void setDungeonHeight(int dungeonHeight) {
        this.dungeonHeight = dungeonHeight;
    }

    /**
     * Returns the dungeon depth.
     * @return dungeon depth
     */
    public int getDungeonDepth() {
        return dungeonDepth;
    }

    /**
     * Sets the dungeon depth.
     * @param dungeonDepth dungeon depth
     */
    public void setDungeonDepth(int dungeonDepth) {
        this.dungeonDepth = dungeonDepth;
    }

    /**
     * Returns the player x-position.
     * @return player x-position
     */
    public int getPlayerX() {
        return playerX;
    }

    /**
     * Sets the player x-position.
     * @param playerX player x-position
     */
    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    /**
     * Returns the player y-position.
     * @return player y-position
     */
    public int getPlayerY() {
        return playerY;
    }

    /**
     * Sets the player y-position.
     * @param playerY player y-position
     */
    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    /**
     * Returns the boss (monster id)
     * @return boss (monster id)
     */
    public int getBoss() {
        return boss;
    }

    /**
     * Sets the boss (monster id).
     * @param boss boss (monster id)
     */
    public void setBoss(int boss) {
        this.boss = boss;
    }

    /**
     * Returns the boss x-position.
     * @return boss x-position
     */
    public int getBossX() {
        return bossX;
    }

    /**
     * Sets the boss x-position.
     * @param bossX boss x-position
     */
    public void setBossX(int bossX) {
        this.bossX = bossX;
    }

    /**
     * Returns the boss y-position.
     * @return boss y-position
     */
    public int getBossY() {
        return bossY;
    }

    /**
     * Sets the boss y-position.
     * @param bossY boss y-position
     */
    public void setBossY(int bossY) {
        this.bossY = bossY;
    }

    /**
     * Returns the boss z-position.
     * @return boss z-position
     */
    public int getBossZ() {
        return bossZ;
    }

    /**
     * Sets the boss z-position.
     * @param bossZ boss z-position
     */
    public void setBossZ(int bossZ) {
        this.bossZ = bossZ;
    }

    /**
     * Returns the description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the dungeon description.
     * @param description dungeon description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}

