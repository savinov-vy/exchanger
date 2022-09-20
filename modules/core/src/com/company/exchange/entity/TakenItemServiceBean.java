package com.company.exchange.entity;

import com.company.exchange.service.TakenItemService;
import com.company.exchange.service.UserService;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.core.global.View;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Service(TakenItemService.NAME)
public class TakenItemServiceBean implements TakenItemService {
    @Inject
    private Metadata metadata;
    @Inject
    private UserService userService;
    @Inject
    private UserSessionSource userSessionSource;
    @Inject
    private DataManager dataManager;

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

    @Override
    public void setDeleteBeforeTakenItem(Disk disk) {
        Date newTakenItemCreated = disk.getTakenItem().getCreateTs();
        List<TakenItem> list = dataManager.load(TakenItem.class)
                .query("select e from exchange_TakenItem e where e.disk=:disk " +
                        "and e.createTs < :newTakenItemCreated")
                .parameter("disk", disk)
                .parameter("newTakenItemCreated", newTakenItemCreated)
                .view(View.BASE)
                .list();

        if (!list.isEmpty()) {
            CommitContext commitContext = new CommitContext();
            commitContext.setRemoveInstances(list);
            dataManager.commit(commitContext);
        }
    }

}