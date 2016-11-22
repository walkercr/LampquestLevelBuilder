package lampquest.dao;

import lampquest.model.Dungeon;

/**
 * Data access object interface for the Dungeon entity.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public interface IDungeonsDao extends ILampquestDao<Dungeon> {

    /**
     * Updates boss-specific values for the dungeon with the given dungeon id.
     *
     * @param dungeonId dungeon id of dungeon to be updated
     * @param boss update value of boss
     * @param bossX update value of bossX
     * @param bossY update value of bossY
     * @param bossZ update value of bossZ
     */
    void updateBoss(int dungeonId, int boss, int bossX, int bossY, int bossZ);
}
