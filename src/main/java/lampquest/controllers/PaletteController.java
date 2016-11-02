package lampquest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lampquest.dto.PaletteDto;
import lampquest.exceptions.DungeonNotFoundException;
import lampquest.services.IPaletteService;

/**
 * The Palette controller.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
@RestController
public class PaletteController {

    /**
     * The palette service used to obtain a given palette.
     */
    @Autowired
    private IPaletteService paletteService;

    /**
     * Returns a palette for the given dungeon id.
     *
     * @param id the dungeon id
     *
     * @return a palette for the given dungeon id, consisting of the dungeon
     *     and a list of all rooms in the database
     */
    @RequestMapping(value = "/api/palette/{id}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<PaletteDto> getPalette(@PathVariable("id") int id) {
        
        // retrieve/return a palette for the given id
        try {
            PaletteDto paletteDto = paletteService.getPalette(id);
            return new ResponseEntity<>(paletteDto, HttpStatus.OK);

        // return not found status if no dungeon is found with the given id
        } catch (DungeonNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
