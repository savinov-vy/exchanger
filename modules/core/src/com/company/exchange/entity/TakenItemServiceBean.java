package com.company.exchange.entity;

import com.company.exchange.service.UserService;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(TakenItemService.NAME)
public class TakenItemServiceBean implements TakenItemService {
    private static final Logger log = LoggerFactory.getLogger(TakenItemServiceBean.class);

    @Inject
    private Metadata metadata;
    @Inject
    private DataManager dataManager;
    @Inject
    private UserService userService;

    @Override
    public TakenItem createNewManagerTaken(Disk disk) {
        AppUser manager = userService.getOneManager();
        TakenItem takenItem = metadata.create(TakenItem.class);
        takenItem.setUser(manager);
        takenItem.setDisk(disk);
        try {
            dataManager.commit(new CommitContext(takenItem));
        } catch (Exception e) {
            log.warn("Created new takenItem not successfully. Exception with message: " + e.getMessage());
        }
        return takenItem;
    }
}