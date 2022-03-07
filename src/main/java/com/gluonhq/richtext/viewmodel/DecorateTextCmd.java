package com.gluonhq.richtext.viewmodel;

import com.gluonhq.richtext.model.TextDecoration;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.Objects;

public abstract class DecorateTextCmd extends AbstractEditCmd {

    BooleanProperty state = new SimpleBooleanProperty();

    TextDecoration getDecoration() {
        return Decoration.getInstance().toTextDecoration();
    }

    @Override
    public void doRedo(RichTextAreaViewModel viewModel) {
        state.set(!state.get());
        Objects.requireNonNull(viewModel).decorate(getDecoration());
    }

    @Override
    public void doUndo(RichTextAreaViewModel viewModel) {
        Objects.requireNonNull(viewModel).undoDecoration();
    }
}
