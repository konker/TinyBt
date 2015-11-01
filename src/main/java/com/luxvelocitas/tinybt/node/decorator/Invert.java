package com.luxvelocitas.tinybt.node.decorator;

import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;


public class Invert<T> extends AbstractDecorator<T> implements INode<T> {
    public Invert(INode<T> child) {
        super(child);
    }

    @Override
    public NodeState tick(Logger logger, T context) {
        NodeState childState = mChildren.get(0).tick(logger, context);
        switch (childState) {
            case FAILURE:
                return success();

            case SUCCESS:
                return failure();
        }
        return childState;
    }
}
