package com.gluonhq.richtext.viewmodel;

import com.gluonhq.richtext.model.TextDecoration;
import javafx.beans.property.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Decoration {

    private Decoration() {}

    private static Decoration decoration;
    public static Decoration getInstance() {
        if (decoration == null) {
            decoration = new Decoration();
            decoration.update(TextDecoration.builder().presets().build());
        }
        return decoration;
    }
    
    public void update(TextDecoration textDecoration) {
        decoration.setBackground(textDecoration.getBackground());
        decoration.setForeground(textDecoration.getForeground());
        decoration.setFontFamily(textDecoration.getFontFamily());
        decoration.setFontSize(textDecoration.getFontSize());
        decoration.setFontWeight(textDecoration.getFontWeight());
        decoration.setFontPosture(textDecoration.getFontPosture());
    }

    public TextDecoration toTextDecoration() {
        return TextDecoration.builder()
                .background(decoration.getBackground())
                .foreground(decoration.getForeground())
                .fontFamily(decoration.getFontFamily())
                .fontSize(decoration.getFontSize())
                .fontWeight(decoration.getFontWeight())
                .fontPosture(decoration.getFontPosture())
                .build();
    }

    // foregroundProperty
    private final ObjectProperty<Color> foreground = new SimpleObjectProperty<>(this, "foreground");
    public final ObjectProperty<Color> foregroundProperty() {
       return foreground;
    }
    public final Color getForeground() {
       return foreground.get();
    }
    public final void setForeground(Color value) {
        foreground.set(value);
    }
    
    // backgroundProperty
    private final ObjectProperty<Color> background = new SimpleObjectProperty<>(this, "background");
    public final ObjectProperty<Color> backgroundProperty() {
       return background;
    }
    public final Color getBackground() {
       return background.get();
    }
    public final void setBackground(Color value) {
        background.set(value);
    }
    
    // fontFamilyProperty
    private final StringProperty fontFamily = new SimpleStringProperty(this, "fontFamily");
    public final StringProperty fontFamilyProperty() {
       return fontFamily;
    }
    public final String getFontFamily() {
       return fontFamily.get();
    }
    public final void setFontFamily(String value) {
        fontFamily.set(value);
    }
    
    // fontSizeProperty
    private final DoubleProperty fontSize = new SimpleDoubleProperty(this, "fontSize");
    public final DoubleProperty fontSizeProperty() {
       return fontSize;
    }
    public final double getFontSize() {
       return fontSize.get();
    }
    public final void setFontSize(double value) {
        fontSize.set(value);
    }
    
    // fontPostureProperty
    private final ObjectProperty<FontPosture> fontPosture = new SimpleObjectProperty<>(this, "fontPosture");
    public final ObjectProperty<FontPosture> fontPostureProperty() {
       return fontPosture;
    }
    public final FontPosture getFontPosture() {
       return fontPosture.get();
    }
    public final void setFontPosture(FontPosture value) {
        fontPosture.set(value);
    }
    
    // fontWeightProperty
    private final ObjectProperty<FontWeight> fontWeight = new SimpleObjectProperty<>(this, "fontWeight");
    public final ObjectProperty<FontWeight> fontWeightProperty() {
       return fontWeight;
    }
    public final FontWeight getFontWeight() {
       return fontWeight.get();
    }
    public final void setFontWeight(FontWeight value) {
        fontWeight.set(value);
    }
    
    
}
