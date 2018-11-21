package Classes;

import Interfaces.IArrayIterator;

public class ArrayIterator<T> implements IArrayIterator<T> {

    private T[] myArray;
    private int currentIndex;

    public ArrayIterator(T[] _myArray) {
        myArray = _myArray;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        if (currentIndex == myArray.length)
            return false;
        return true;
    }

    @Override
    public T next() {
        return myArray[currentIndex++];
    }
}
