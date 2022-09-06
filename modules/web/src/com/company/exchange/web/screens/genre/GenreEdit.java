package com.company.exchange.web.screens.genre;

import com.haulmont.cuba.gui.screen.*;
import com.company.exchange.entity.Genre;

@UiController("exchange_Genre.edit")
@UiDescriptor("genre-edit.xml")
@EditedEntityContainer("genreDc")
@LoadDataBeforeShow
public class GenreEdit extends StandardEditor<Genre> {
}