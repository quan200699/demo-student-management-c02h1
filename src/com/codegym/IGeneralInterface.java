package com.codegym;

public interface IGeneralInterface<T> {
    void showAll();

    T create(T t);

    T update(int index, T t);

    void remove(int index);
}
