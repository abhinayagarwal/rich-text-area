package com.gluonhq.richtext.model;

import javafx.beans.property.ReadOnlyIntegerProperty;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface TextBuffer {

    int getTextLength();
    ReadOnlyIntegerProperty textLengthProperty();
    String getText();
    String getText(int start, int end);

    void insert( String text, int insertPosition );
    void append( String text );
    void delete( final int deletePosition, int length );
    void decorate(int start, int end, TextDecoration textDecoration);

    void undo();
    void redo();

    void walkFragments(BiConsumer<String, TextDecoration> onFragment);

    void addChangeListener(Consumer<TextBuffer.Event> listener);
    void removeChangeListener(Consumer<TextBuffer.Event> listener);


    interface Event {}

    class InsertEvent implements Event {

        private final String text;
        private final int position;

        InsertEvent(String text, int position ) {
            this.text = text;
            this.position = position;
        }

        public String getText() {
            return text;
        }

        public int getPosition() {
            return position;
        }
    }

    class DeleteEvent implements Event {

        private final int position;
        private final int length;

        DeleteEvent(int position, int length ) {
            this.position = position;
            this.length = length;
        }

        public int getPosition() {
            return position;
        }

        public int getLength() {
            return length;
        }
    }

    class DecorateEvent implements Event {

        private final int start;
        private final int end;
        private final TextDecoration decoration;

        DecorateEvent(int start, int end, TextDecoration decoration) {
            this.start = start;
            this.end = end;
            this.decoration = decoration;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public TextDecoration getDecoration() {
            return decoration;
        }
    }

}

