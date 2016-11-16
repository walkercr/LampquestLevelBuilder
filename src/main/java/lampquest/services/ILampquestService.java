package lampquest.services;

import java.io.IOException;
import lampquest.dto.DungeonLevelDto;
import lampquest.dto.BulkDataDto;
import lampquest.dto.PageLoadDataDto;
import lampquest.exceptions.DungeonNotFoundException;

/**
 * Lampquest service interface
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public interface ILampquestService {

    /**
     * Returns a data transfer object containing all data needed to being a
     * session.
     *
     * @return all data needed to begin a session
     */
    PageLoadDataDto getPageLoadData();

    /**
     * Returns bulk data for the specified dungeon id.
     *
     * @param dungeonId the dungeon id of the intended dungeon
     *
     * @return bulk data for the specified dungeon id
     * @throws DungeonNotFoundException
     *     if the dungeonId is not found
     */
    BulkDataDto getBulkData(int dungeonId) throws DungeonNotFoundException;

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
