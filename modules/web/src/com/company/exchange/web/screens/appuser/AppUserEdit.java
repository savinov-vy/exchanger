package com.company.exchange.web.screens.appuser;

import com.haulmont.cuba.gui.screen.*;
import com.company.exchange.entity.AppUser;

@UiController("exchange_AppUser.edit")
@UiDescriptor("app-user-edit.xml")
@EditedEntityContainer("appUserDc")
@LoadDataBeforeShow
public class AppUserEdit extends StandardEditor<AppUser> {
}