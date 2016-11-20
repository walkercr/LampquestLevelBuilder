package lampquest.services;

import lampquest.dto.DungeonLevelDto;
import lampquest.dto.PageLoadDataDto;

/**
 * Created by Craig on 11/20/2016.
 */
public interface ILampquestLevelsService {

    /**
     * Overwrites existing dungeon level with the given dungeon level.
     *
     * @param dungeonLevel the new dungeon level
     */

    void updateLevel(DungeonLevelDto dungeonLevel);
}
