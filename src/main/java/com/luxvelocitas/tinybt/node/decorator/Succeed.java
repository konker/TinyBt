package com.luxvelocitas.tinybt.node.decorator;

import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;


public class Succeed<T> extends AbstractDecorator<T> implements INode<T> {
    public Succeed(INode<T> child) {
        super(child);
    }

    @Override
    public NodeState tick(Logger logger, T context) {
        mChildren.get(0).tick(logger, context);
        return success();
    }
}
