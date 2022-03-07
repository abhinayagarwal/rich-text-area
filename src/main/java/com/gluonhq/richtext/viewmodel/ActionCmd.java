package com.gluonhq.richtext.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;

public interface ActionCmd {

    void apply(RichTextAreaViewModel viewModel);

    default BooleanBinding getDisabledBinding(RichTextAreaViewModel viewModel) {
        return null;
    }

    default BooleanProperty getState(RichTextAreaViewModel viewModel) {
        return null;
    }
}
