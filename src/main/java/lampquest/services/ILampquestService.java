package lampquest.services;

import lampquest.dto.PageLoadDataDto;

/**
 * Lampquest service interface
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.1
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
}
