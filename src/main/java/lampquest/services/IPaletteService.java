package lampquest.services;

import lampquest.dto.PaletteDto;
import lampquest.exceptions.DungeonNotFoundException;

/**
 * Service interface for obtaining a palette.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
public interface IPaletteService {

    /**
     * Returns the palette for the specified dungeon id.
     *
     * @param dungeonId the dungeon id of the intended dungeon
     *
     * @return a palette with the specified dungeons and the list of rooms
     * @throws DungeonNotFoundException
     *     if the dungeonId is not found
     */
    PaletteDto getPalette(int dungeonId) throws DungeonNotFoundException;
}
