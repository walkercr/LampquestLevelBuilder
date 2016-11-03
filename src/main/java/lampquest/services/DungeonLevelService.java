package lampquest.services;

import java.io.IOException;
import java.io.PrintWriter;

import lampquest.dto.DungeonLevelDto;
import lampquest.dto.RoomDto;

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

        String insert = "INSERT INTO RoomsLevels (dungeonId, depth, "
                        + "roomId, startX, startY) VALUES (";
        String comma = ", ";
        String endStatement = ");";

        // generate dungeon level script
        try (PrintWriter out = new PrintWriter(dungeonLevelDto.getFilename())) {
            int dungeonId = dungeonLevelDto.getDungeonId();
            int depth = dungeonLevelDto.getDepth();

            for (RoomDto room : dungeonLevelDto.getRooms()) {
                out.println(
                        new StringBuilder(insert)
                                .append(dungeonId).append(comma)
                                .append(depth).append(comma)
                                .append(room.getRoomId()).append(comma)
                                .append(room.getStartX()).append(comma)
                                .append(room.getStartY()).append(endStatement)
                                .toString()
                );
            }
        }
    }
}

