package com.luxvelocitas.tinybt.node.decorator;

import com.luxvelocitas.tinybt.node.AbstractNode;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;


public abstract class AbstractDecorator<T> extends AbstractNode<T> implements INode<T> {

    public AbstractDecorator(INode<T> child) {
        super();
        addChild(child);
    }

    @Override
    public NodeState tick(Logger logger, T context) {
        return mChildren.get(0).tick(logger, context);
    }
}
