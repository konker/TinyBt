package com.luxvelocitas.tinybt.node.decorator;

import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;


public class Fail<T> extends AbstractDecorator<T> implements INode<T> {
    public Fail(INode<T> child) {
        super(child);
    }

    @Override
    public NodeState tick(Logger logger, T context) {
        mChildren.get(0).tick(logger, context);
        return failure();
    }
}
