package lampquest.services;

import lampquest.dto.DungeonLevelDto;

/**
 * Lampquest levels service interface.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.1
 * @since 11/20/2016
 */
public interface ILampquestLevelsService {

    /**
     * Overwrites existing dungeon level with the given dungeon level.
     *
     * @param dungeonLevel the new dungeon level
     */

    void updateLevel(DungeonLevelDto dungeonLevel);
}
