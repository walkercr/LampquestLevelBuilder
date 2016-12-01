package lampquest.controllers;

import lampquest.dto.DungeonLevelDto;
import lampquest.dto.PageLoadDataDto;
import lampquest.dto.SelectedDungeonDataDto;
import lampquest.services.ILampquestLevelsService;
import lampquest.services.ILampquestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Lampquest API controller.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.1
 * @since 10/12/2016
 */
@RestController
public class LampquestController {

    /**
     * Service provider for non-level-specific lampquest requests
     */
    private ILampquestService lampquestService;
    /**
     * Service provider for level-specific lampquest requests
     */
    private ILampquestLevelsService lampquestLevelsService;

    /**
     * Constructs a new LampquestController with the given service providers.
     *
     * @param lampquestService non-level-specific service provider
     * @param lampquestLevelsService level-specific service provider
     */
    @Autowired
    public LampquestController(ILampquestService lampquestService,
                               ILampquestLevelsService lampquestLevelsService) {
        this.lampquestService = lampquestService;
        this.lampquestLevelsService = lampquestLevelsService;
    }

    /**
     * Returns page load data needed to being a session.
     *
     * @return page load data needed to being a session
     */
    @RequestMapping(value = "/api/lampquest",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<PageLoadDataDto> getPageLoadData() {

        // fetch and return page load data
        PageLoadDataDto pageLoadData = lampquestService.getPageLoadData();
        return new ResponseEntity<>(pageLoadData, HttpStatus.OK);
    }

    /**
     * Returns the selected dungeon data for the dungeon with the given id.
     *
     * @param id selected dungeon id
     *
     * @return selected dungeon data associated with dungeon levels
     */
    @RequestMapping(value = "/api/lampquest/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<SelectedDungeonDataDto>
            getSelectedDungeonData(@PathVariable("id") int id) {

        SelectedDungeonDataDto selectedDungeonData =
                lampquestLevelsService.getSelectedDungeonData(id);

        return new ResponseEntity<>(selectedDungeonData, HttpStatus.OK);
    }

    /**
     * Updates a lampquest dungeon level.
     *
     * @param dungeonLevelDto the new dungeon level
     *
     * @return created status code on creation
     */
    @RequestMapping(value = "/api/lampquest",
                    method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateLevel(
            @RequestBody DungeonLevelDto dungeonLevelDto) {

        // update db to create the given dungeon level
        lampquestLevelsService.updateLevel(dungeonLevelDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

