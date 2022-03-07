package com.gluonhq.richtext.action;

import com.gluonhq.richtext.RichTextArea;
import com.gluonhq.richtext.RichTextAreaSkin;
import com.gluonhq.richtext.viewmodel.ActionCmd;
import com.gluonhq.richtext.viewmodel.RichTextAreaViewModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Skin;

import java.util.Objects;
import java.util.function.Function;

class BasicAction implements Action {

    private RichTextAreaViewModel viewModel;
    private final Function<Action, ActionCmd> actionCmdFunction;

    private final BooleanProperty disabledImplProperty = new SimpleBooleanProperty(this, "disabledImpl", false);
    private final BooleanProperty stateImplProperty = new SimpleBooleanProperty(this, "stateImpl", false);

    public BasicAction(RichTextArea control, Function<Action, ActionCmd> actionCmdFunction) {
        this.actionCmdFunction = Objects.requireNonNull(actionCmdFunction);
        if (control.getSkin() != null) {
            initialize(control.getSkin());
        } else {
            control.skinProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    if (control.getSkin() != null) {
                        initialize(control.getSkin());
                        control.skinProperty().removeListener(this);
                    }
                }
            });
        }
    }

    private void initialize(Skin<?> skin) {
        if (!(skin instanceof RichTextAreaSkin)) {
            return;
        }
        viewModel = ((RichTextAreaSkin) skin).getViewModel();
        BooleanBinding disabledBinding = getActionCmd().getDisabledBinding(viewModel);
        BooleanProperty state = getActionCmd().getState(viewModel);
        if (disabledBinding != null) {
            disabledImplProperty.bind(disabledBinding);
        }
        if (state != null) {
            state.bind(stateImplProperty);
        }
    }

    private ActionCmd getActionCmd() {
        return actionCmdFunction.apply(this);
    }

    @Override
    public void execute(ActionEvent event) {
        getActionCmd().apply(viewModel);
    }

    @Override
    public ReadOnlyBooleanProperty disabledProperty() {
        return disabledImplProperty;
    }

    @Override
    public BooleanProperty stateProperty() {
        return stateImplProperty;
    }
}

