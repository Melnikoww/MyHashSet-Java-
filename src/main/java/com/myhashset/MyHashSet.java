package com.myhashset;

public class MyHashSet<T> implements HashSetMethods<T> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Object[] array = new Object[INITIAL_CAPACITY];
    private int size = 0;

    public int getElementPosition(T value, int capacity) {
        return Math.abs(value.hashCode() % capacity);

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T value){
        if (size >= (array.length * LOAD_FACTOR)){
            resize(); 
        }

        boolean added = addMethod(value, array);

        if(added) {
            size++;
        }

        return added;
    }

    @SuppressWarnings("unchecked")
    private boolean addMethod(T value, Object[] dst) {
        int position = getElementPosition(value, dst.length);
        Entry<T> entry = new Entry<>(value, null);
        Entry<T> existedElement = (Entry<T>) dst[position];

        if (existedElement == null){
            dst[position] = entry;
            return true;
        }
        else {
            while(true){
                if (existedElement.value.equals(value)){
                    return false;
                } else {
                    if (existedElement.next == null){
                        existedElement.next = entry;
                        return true;
                    }
                    else {
                        existedElement = existedElement.next;
                    }
                }
            }
            
        }
    }

    @SuppressWarnings("unchecked")
    public void resize() {
        Object[] resizeArray = new Object[array.length * 2];

        for(Object o : array) {
            Entry<T> entry = (Entry<T>) o;
            while (entry != null) {
                addMethod(entry.value, resizeArray);
                entry = entry.next;
            }
        }

        array = resizeArray;
    }


    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(T value){
        int position = getElementPosition(value, array.length);

        if (array[position] == null) {
            return false;
        }
        else {
            Entry<T> prevLast = (Entry<T>) array[position];
            Entry<T> last = prevLast.next;
            if (prevLast.value.equals(value)){
                array[position] = last;
                size--;
                return true;
            }

            while (last != null){
                if (last.value.equals(value)){
                    prevLast.next = last.next;
                    size--;
                    return true;
                }
                else {
                    prevLast = last;
                    last = last.next;
                }
            }
        }

        return false;
    }

    @Override
    public void clear() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }


    @SuppressWarnings("unchecked")
    @Override
    public boolean contains(T value){
        int position = getElementPosition(value, array.length);

        Entry<T> cur = (Entry<T>) array[position];
        while (cur != null) {
            if (cur.value.equals(value)){
                return true;
            }
            cur = cur.next;
        }

        return false;
    }


    @SuppressWarnings("unchecked")
    @Override
    public Object[] toArray() {
        Object[] resultArray = new Object[size];
        int index = 0;

        for (Object o : array) {
            Entry<T> entry = (Entry<T>) o;
            while(entry != null){
                resultArray[index++] = entry.value;
                entry = entry.next;
            }
        }

        return resultArray;
    }

    private static class Entry<T> {
        private T value;
        private Entry<T> next;

        public Entry(T value, Entry<T> next) {
            this.value = value;
            this.next = next;
        }
    }
    
}
