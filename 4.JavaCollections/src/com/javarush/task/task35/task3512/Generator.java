package com.javarush.task.task35.task3512;

public class Generator<T> {

    Class<T> classT;

    public Generator(Class<T> classT) {
        this.classT = classT;
    }

    T newInstance() throws Exception {
        return this.classT.newInstance();
    }
}
