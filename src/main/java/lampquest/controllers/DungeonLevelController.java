package lampquest.controllers;

import lampquest.dto.DungeonLevelDto;
import lampquest.services.IDungeonLevelService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The DungeonLevel controller.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
@RestController
public class DungeonLevelController {

    /**
     * The dungeon level service used to add dungeon levels to the database.
     */
    @Autowired
    private IDungeonLevelService dungeonLevelService;

    /**
     * Adds a dungeon level to the database.
     *
     * @param dungeonLevelDto data transfer object containing the dungeon level
     *                        information
     *
     * @return created status code on creation, or internal server error status 
     *     code if I/O error occurs
     */
    @RequestMapping(value = "/api/dungeonLevel",
                    method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addLevel(@RequestBody DungeonLevelDto dungeonLevelDto) {

        // generate script to create new dungeon level - return created on success
        try {
            dungeonLevelService.scriptDungeonLevel(dungeonLevelDto);
            return new ResponseEntity<>(HttpStatus.CREATED);

        // return internal server error status code if I/O error occurs
        } catch (IOException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

