package com.company.exchange.service;

import com.company.exchange.entity.AppUser;
import com.company.exchange.entity.Disk;
import com.company.exchange.entity.TakenItem;
import com.haulmont.cuba.core.TransactionalDataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.TimeSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;

@Service(TakenItemService.NAME)
public class TakenItemServiceBean implements TakenItemService {
    @Inject
    private Metadata metadata;
    @Inject
    private UserService userService;
    @Inject
    private TimeSource timeSource;
    @Inject
    private TransactionalDataManager transactionalDataManager;

    @Override
    public TakenItem createNewManagerTaken(Disk disk) {
        AppUser manager = userService.getOneManager();
        TakenItem takenItem = metadata.create(TakenItem.class);
        takenItem.setUser(manager);
        takenItem.setDisk(disk);
        return takenItem;
    }

    @Override
    public void retrieve(Disk disk) {
        TakenItem newTakenItem = diskToManager(disk);
        exchange(preparedToSoftDeleteTaken(disk), newTakenItem);
    }

    private TakenItem diskToManager(Disk disk) {
        AppUser manager = userService.getOneManager();
        return createTakenItem(disk, manager);
    }

    @Override
    public void take(Disk disk) {
        TakenItem newTakenItem = diskToCurrentUser(disk);
        exchange(preparedToSoftDeleteTaken(disk), newTakenItem);
    }

    private TakenItem diskToCurrentUser(Disk disk) {
        AppUser current = userService.currentUser();
        return createTakenItem(disk, current);
    }

    private TakenItem createTakenItem(Disk disk, AppUser user) {
        TakenItem newTakenItem = metadata.create(TakenItem.class);
        String loginCurrentUser = userService.currentUser().getLoginLowerCase();
        Date now = timeSource.currentTimestamp();

        newTakenItem.setUser(user);
        newTakenItem.setDisk(disk);
        newTakenItem.setCreatedBy(loginCurrentUser);
        newTakenItem.setCreateTs(now);
        newTakenItem.setUpdatedBy(loginCurrentUser);
        newTakenItem.setUpdateTs(now);
        return newTakenItem;
    }

    private TakenItem preparedToSoftDeleteTaken(Disk disk) {
        String loginCurrentUser = userService.currentUser().getLoginLowerCase();
        Date now = timeSource.currentTimestamp();
        TakenItem before = disk.getTakenItem();
        before.setDeleteTs(now);
        before.setDeletedBy(loginCurrentUser);
        return before;
    }

    @Transactional
    protected void exchange(TakenItem toSoftDelete, TakenItem newTakenItem) {
        transactionalDataManager.save(toSoftDelete);
        transactionalDataManager.save(newTakenItem);
    }
}