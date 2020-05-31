package com.evoluum.challengeDev.view;

import java.util.List;

public abstract class AbstractCsvView<T> implements FileInterface<T> {

    @SuppressWarnings("rawtypes")
    public abstract AbstractCsvView addInfo(List<T> info);
}
