package list.action;

import exceptions.ArrayIndexException;
import exceptions.NotFoundException;
import interfaces.StringListInterface;
import list.constructor.StringList;

import java.util.Arrays;
import java.util.Objects;


public abstract class Action implements StringListInterface {
    private Integer size;
    private String[] array;


    @Override
    public String add(String item) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length - 1] = item;
        array = newArray;
        setSize(array.length);
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index > array.length) {
            throw new ArrayIndexException("Индекс превышает размер массива");
        }
        String[] newArray = new String[array.length + 1];
        if (index >= 0) System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = item;
        if (array.length + 1 - (index + 1) >= 0)
            System.arraycopy(array, index + 1 - 1, newArray, index + 1,
                    array.length + 1 - (index + 1));
        array = newArray;
        setSize(array.length);
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index > array.length) {
            throw new ArrayIndexException("Индекс превышает размер массива");
        }
        array[index] = item;
        setSize(array.length);
        return item;
    }

    @Override
    public String remove(String item) {
        String[] newArray = new String[array.length - 1];
        int targetNum = 0;
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            String target = array[i];
            if (Objects.equals(target, item)) {
                array[i] = null;
                targetNum = i;
                check = true;
            }
        }
        if (!check) {
            throw new NotFoundException("Элемент не найден");
        }
        System.arraycopy(array, 0, newArray, 0, targetNum);
        if (newArray.length - targetNum >= 0)
            System.arraycopy(array, targetNum + 1, newArray, targetNum, newArray.length - targetNum);
        array = newArray;
        setSize(array.length);
        return item;
    }

    @Override
    public String remove(int index) {
        String[] newArray = new String[array.length - 1];
        if (index > array.length) {
            throw new NotFoundException("Элемент не найден");
        }
        String target = array[index];
        array[index] = null;
        System.arraycopy(array, 0, newArray, 0, index);
        if (newArray.length - index >= 0) System.arraycopy(array, index + 1,
                newArray, index, newArray.length - index);
        array = newArray;
        setSize(array.length);
        return target;
    }

    @Override
    public boolean contains(String item) {
        boolean check = false;
        for (String target : array) {
            if (Objects.equals(target, item)) {
                check = true;
                break;
            }
        }
        return check;
    }

    @Override
    public int indexOf(String item) {
        int targetNum = 0;
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            String target = array[i];
            if (Objects.equals(target, item)) {
                check = true;
                targetNum = i;
            }
        }
        if (!check) {
            return -1;
        } else {
            return targetNum;
        }
    }

    @Override
    public int lastIndexOf(String item) {
        String target = array[array.length - 1];
        if (Objects.equals(target, item)) {
            return array.length - 1;
        } else {
            return -1;
        }
    }

    @Override
    public String get(int index) {
        if (index > array.length) {
            throw new ArrayIndexException("Индекс больше размера массива");
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NotFoundException("передан null");
        }
        return Arrays.equals(array, otherList.getArray());
    }

    @Override
    public int size() {
        return getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public void clear() {
        while (array.length > 0) {
            remove(array.length - 1);
        }
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    protected int getSize() {
        if (this.size == null) {
            setSize(0);
        }
        return size;
    }

    protected void setSize(Integer size) {
        this.size = size;
    }

    protected String[] getArray() {
        return array;
    }

    protected void setArray(String[] array) {
        this.array = array;
    }

    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Action action = (Action) object;
        return Objects.equals(size, action.size) && Arrays.equals(array, action.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
