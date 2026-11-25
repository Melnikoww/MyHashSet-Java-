package com.myhashset;

public interface HashSetMethods<T> {
    boolean add(T value);
    boolean remove(T value);
    boolean contains(T value);
    boolean isEmpty();
    Object[] toArray();
    int getSize();
    void clear();
}
