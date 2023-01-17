package com.company.exchange.web.screens.appuser;

import com.haulmont.cuba.gui.screen.*;
import com.company.exchange.entity.AppUser;

@UiController("exchange_AppUser.browse")
@UiDescriptor("app-user-browse.xml")
@LookupComponent("appUsersTable")
@LoadDataBeforeShow
public class AppUserBrowse extends StandardLookup<AppUser> {
}