package list.constructor;

import list.action.Action;

public class StringList extends Action {
    public StringList(String[] array) {
        if (array.length > getSize()) {
            super.setSize(array.length);
            super.setArray(array);
        }
    }
}