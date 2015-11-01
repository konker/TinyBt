package com.luxvelocitas.tinybt.node;


import org.slf4j.Logger;

public class Root<T> extends AbstractNode<T> implements INode<T> {
    public Root(INode<T>... children) {
        super(children);
    }

    @Override
    public NodeState tick(Logger logger, T context) {
        return state(mChildren.get(0).tick(logger, context));
    }
}
