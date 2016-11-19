package lampquest.controllers;

import lampquest.dto.BulkDataDto;
import lampquest.dto.DungeonLevelDto;
import lampquest.dto.PageLoadDataDto;
import lampquest.exceptions.DungeonNotFoundException;
import lampquest.services.ILampquestService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The DungeonLevel controller.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
@RestController
public class LampquestController {

    /**
     * Service provider for the lampquest database
     */
    @Autowired
    private ILampquestService lampquestService;

    /**
     * Returns page load data needed to being a session.
     *
     * @return page load data needed to being a session
     */
    @RequestMapping(value = "/api/lampquest",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<PageLoadDataDto> getPageLoadData() {
        PageLoadDataDto pageLoadData = lampquestService.getPageLoadData();
        return new ResponseEntity<>(pageLoadData, HttpStatus.OK);
    }

    /**
     * Returns bulk data for the given dungeon id.
     *
     * @param id the dungeon id
     *
     * @return bulk data for the given dungeon id
     */
    @RequestMapping(value = "/api/lampquest/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<BulkDataDto> getPalette(@PathVariable("id") int id) {

        // retrieve/return a palette for the given id
        try {
            BulkDataDto bulkDataDto = lampquestService.getBulkData(id);
            return new ResponseEntity<>(bulkDataDto, HttpStatus.OK);

            // return not found status if no dungeon is found with the given id
        } catch (DungeonNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Adds a dungeon level to the database.
     *
     * @param dungeonLevelDto data transfer object containing the dungeon level
     *                        information
     *
     * @return created status code on creation, or internal server error status 
     *     code if I/O error occurs
     */
    @RequestMapping(value = "/api/lampquest",
                    method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addLevel(@RequestBody DungeonLevelDto dungeonLevelDto) {

        // update db to create the given dungeon level
        lampquestService.updateLevel(dungeonLevelDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

