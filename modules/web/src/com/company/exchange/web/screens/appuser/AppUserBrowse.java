package com.company.exchange.web.screens.appuser;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.company.exchange.entity.AppUser;
import com.haulmont.reports.gui.actions.RunReportAction;

import javax.inject.Inject;

@UiController("exchange_AppUser.browse")
@UiDescriptor("app-user-browse.xml")
@LookupComponent("appUsersTable")
@LoadDataBeforeShow
public class AppUserBrowse extends StandardLookup<AppUser> {
    @Inject
    private Button usersReportBtn;

    @Subscribe
    public void onInit(InitEvent event) {
        usersReportBtn.setAction(new RunReportAction());
    }
}