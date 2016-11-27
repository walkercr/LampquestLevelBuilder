package lampquest.dto;

import lampquest.model.StaticMonster;
import lampquest.model.StaticMonsterKey;

/**
 * Data transfer object for item level to mask model key attribute.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/26/2016
 */
public class StaticMonsterDto {
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
     * Constructs a new StaticMonsterDto with the given StaticMonster.
     * @param staticMonster a static monster entity
     */
    public StaticMonsterDto(StaticMonster staticMonster) {
        StaticMonsterKey key = staticMonster.getKey();
        this.monsterId = key.getMonsterId();
        this.monsterX = key.getMonsterX();
        this.monsterY = key.getMonsterY();
        this.dungeonId = key.getDungeonId();
        this.depth = key.getDepth();
    }

    /**
     * Returns the monster id.
     * @return monster id
     */
    public int getMonsterId() {
        return monsterId;
    }

    /**
     * Returns the monster x-position.
     * @return monster x-position
     */
    public int getMonsterX() {
        return monsterX;
    }

    /**
     * Returns the monster y-position.
     * @return monster y-position
     */
    public int getMonsterY() {
        return monsterY;
    }

    /**
     * Returns the dungeon id.
     * @return dungeon id
     */
    public int getDungeonId() {
        return dungeonId;
    }

    /**
     * Returns the dungeon depth.
     * @return dungeon depth
     */
    public int getDepth() {
        return depth;
    }
}
