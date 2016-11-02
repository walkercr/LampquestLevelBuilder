package lampquest.services;

import java.io.IOException;
import lampquest.dto.DungeonLevelDto;

/**
 * Service class implementation for adding a dungeon level.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public class DungeonLevelService implements IDungeonLevelService {

    /**
     * Generates a SQL script to add the given dungeon level to the database.
     *
     * @param dungeonLevelDto data transfer object containing the dungeon level
     *                        information
     *                        
     * @throws IOException
     *     if an I/O error occurs
     */
    public void scriptDungeonLevel(DungeonLevelDto dungeonLevelDto) 
                                   throws IOException {
        // generate dungeon level script
    }
}

