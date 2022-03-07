package com.gluonhq.richtext.viewmodel;

import static javafx.scene.text.FontWeight.BOLD;
import static javafx.scene.text.FontWeight.NORMAL;

public class DecorateTextBold extends DecorateTextCmd {

    boolean dirty = false;

    public DecorateTextBold() {
        state.addListener((o, ov, nv) -> {
            if (!dirty) {
                dirty = true;
                Decoration.getInstance().setFontWeight(nv ? BOLD : NORMAL);
                dirty = false;
            }
        });
        Decoration.getInstance().fontWeightProperty().addListener((o, ov, nv) -> {
            if (!dirty) {
                dirty = true;
                state.set(nv == BOLD);
                dirty = false;
            }
        });
    }
}
