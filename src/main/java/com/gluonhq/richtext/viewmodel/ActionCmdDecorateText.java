package com.gluonhq.richtext.viewmodel;

import javafx.beans.property.BooleanProperty;

class ActionCmdDecorateText implements ActionCmd {

    private final DecorateTextCmd decorationCmd;

    public ActionCmdDecorateText(DecorateTextCmd decorationCmd) {
        this.decorationCmd = decorationCmd;
        decorationCmd.state.addListener((o, ov, nv) -> {
            System.out.println("ActionCmdDecorateText: " + nv);
        });
    }

    @Override
    public void apply(RichTextAreaViewModel viewModel) {
        if (viewModel.isEditable()) {
            viewModel.getCommandManager().execute(decorationCmd);
        }
    }

    @Override
    public BooleanProperty getState(RichTextAreaViewModel viewModel) {
        return decorationCmd.state;
    }
}
