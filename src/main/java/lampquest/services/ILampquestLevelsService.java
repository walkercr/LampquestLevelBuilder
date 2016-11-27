package lampquest.services;

import lampquest.dto.DungeonLevelDto;
import lampquest.dto.SelectedDungeonDataDto;

/**
 * Lampquest levels service interface.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.1
 * @since 11/20/2016
 */
public interface ILampquestLevelsService {

    /**
     * Retrieves and returns the data associated with the selected dungeon.
     *
     * @param dungeonId id of the selected dungeon
     *
     * @return selected dungeon data
     */
    SelectedDungeonDataDto getSelectedDungeonData(int dungeonId);

    /**
     * Overwrites existing dungeon level with the given dungeon level.
     *
     * @param dungeonLevel the new dungeon level
     */

    void updateLevel(DungeonLevelDto dungeonLevel);
}
