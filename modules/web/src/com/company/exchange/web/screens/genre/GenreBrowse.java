package com.company.exchange.web.screens.genre;

import com.haulmont.cuba.gui.screen.*;
import com.company.exchange.entity.Genre;

@UiController("exchange_Genre.browse")
@UiDescriptor("genre-browse.xml")
@LookupComponent("genresTable")
@LoadDataBeforeShow
public class GenreBrowse extends StandardLookup<Genre> {
}