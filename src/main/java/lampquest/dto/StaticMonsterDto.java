package lampquest.dto;

import lampquest.model.StaticMonster;
import lampquest.model.StaticMonsterKey;

/**
 * Data transfer object for static monster to mask model key attribute.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 11/26/2016
 */
public class StaticMonsterDto {
    /**
     * static monster id
     */
    private int monsterId;
    /**
     * static monster x-position
     */
    private int monsterX;
    /**
     * static monster y-position
     */
    private int monsterY;
    /**
     * dungeon id of dungeon containing static monster
     */
    private int dungeonId;
    /**
     * dungeon depth where static monster is located
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
     * Returns the static monster id.
     * @return static monster id
     */
    public int getMonsterId() {
        return monsterId;
    }

    /**
     * Returns the static monster x-position.
     * @return static monster x-position
     */
    public int getMonsterX() {
        return monsterX;
    }

    /**
     * Returns the static monster y-position.
     * @return static monster y-position
     */
    public int getMonsterY() {
        return monsterY;
    }

    /**
     * Returns the dungeon id containing the static monster.
     * @return dungeon id containing the static monster
     */
    public int getDungeonId() {
        return dungeonId;
    }

    /**
     * Returns the dungeon depth where the static monster is located.
     * @return dungeon depth where static monster is located
     */
    public int getDepth() {
        return depth;
    }
}
