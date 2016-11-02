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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dungeonId;

    private String dungeonName;
    private int dungeonWidth;
    private int dungeonHeight;
    private int dungeonDepth;
    private int playerX;
    private int playerY;
    private int boss;
    private int bossX;
    private int bossY;
    private int bossZ;
    private String description;

    public int getDungeonId() {
        return dungeonId;
    }

    public String getDungeonName() {
        return dungeonName;
    }

    public int getDungeonWidth() {
        return dungeonWidth;
    }

    public int getDungeonHeight() {
        return dungeonHeight;
    }

    public int getDungeonDepth() {
        return dungeonDepth;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public int getBoss() {
        return boss;
    }

    public int getBossX() {
        return bossX;
    }

    public int getBossY() {
        return bossY;
    }

    public int getBossZ() {
        return bossZ;
    }

    public String getDescription() {
        return description;
    }
}

