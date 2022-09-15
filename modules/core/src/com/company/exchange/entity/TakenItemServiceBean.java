package com.company.exchange.entity;

import com.company.exchange.service.UserService;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.UserSessionSource;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(TakenItemService.NAME)
public class TakenItemServiceBean implements TakenItemService {
    @Inject
    private Metadata metadata;
    @Inject
    private UserService userService;
    @Inject
    private UserSessionSource userSessionSource;

    @Override
    public TakenItem setManagerTaken(Disk disk) {
        AppUser manager = userService.getOneManager();
        TakenItem takenItem = metadata.create(TakenItem.class);
        takenItem.setUser(manager);
        takenItem.setDisk(disk);
        return takenItem;
    }

    @Override
    public TakenItem setCurrentUserTaken(Disk disk) {
        AppUser current = (AppUser) userSessionSource.getUserSession().getUser();
        TakenItem takenItem = metadata.create(TakenItem.class);
        takenItem.setUser(current);
        takenItem.setDisk(disk);
        return takenItem;
    }
}