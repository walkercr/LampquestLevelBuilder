package lampquest.controllers;

import lampquest.dto.DungeonLevelDto;
import lampquest.dto.PageLoadDataDto;
import lampquest.services.ILampquestLevelsService;
import lampquest.services.ILampquestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The DungeonLevel controller.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.1
 * @since 10/12/2016
 */
@RestController
public class LampquestController {

    /**
     * Service provider for non-level specific lampquest entities
     */
    @Autowired
    private ILampquestService lampquestService;
    /**
     * Service provider for level-specific lampquest entities
     */
    @Autowired
    private ILampquestLevelsService lampquestLevelsService;

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
    public ResponseEntity<Void>
            updateLevel(@RequestBody DungeonLevelDto dungeonLevelDto) {

        // update db to create the given dungeon level
        lampquestLevelsService.updateLevel(dungeonLevelDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

