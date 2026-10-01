package ccsw.tutorialclient.client.model;

import ccsw.tutorialclient.common.pagination.PageableRequest;

public class ClientSearchDto {

    private PageableRequest pageable;

    public PageableRequest getPageable() {
        return pageable;
    }

    public void setPageable(PageableRequest pageable) {
        this.pageable = pageable;
    }
}
