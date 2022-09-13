package com.company.exchange.entity;

import com.company.exchange.service.UserService;
import com.haulmont.cuba.core.global.Metadata;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(TakenItemService.NAME)
public class TakenItemServiceBean implements TakenItemService {

    @Inject
    private Metadata metadata;
    @Inject
    private UserService userService;

    @Override
    public TakenItem createNewManagerTaken(Disk disk) {
        AppUser manager = userService.getOneManager();
        TakenItem takenItem = metadata.create(TakenItem.class);
        takenItem.setUser(manager);
        takenItem.setDisk(disk);
        return takenItem;
    }
}