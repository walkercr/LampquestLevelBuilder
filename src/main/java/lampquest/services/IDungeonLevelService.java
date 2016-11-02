package lampquest.services;

import java.io.IOException;
import lampquest.dto.DungeonLevelDto;

/**
 * Service interface for adding a dungeon level.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public interface IDungeonLevelService {

    /**
     * Generates a SQL script to add the given dungeon level to the database.
     *
     * @param dungeonLevelDto data transfer object containing the dungeon level
     *                        information
     *                        
     * @throws IOException
     *     if an I/O error occurs
     */
    void scriptDungeonLevel(DungeonLevelDto dungeonLevelDto) throws IOException;
}
