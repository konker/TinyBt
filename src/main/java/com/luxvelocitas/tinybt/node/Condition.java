package com.luxvelocitas.tinybt.node;


import org.slf4j.Logger;

public abstract class Condition<T> extends AbstractNode<T> implements INode<T> {
    @Override
    public NodeState tick(Logger logger, T context) {
        return failure();
    }
}
