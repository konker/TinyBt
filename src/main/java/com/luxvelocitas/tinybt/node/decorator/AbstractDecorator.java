package com.luxvelocitas.tinybt.node.decorator;

import com.luxvelocitas.tinydatautils.DataBundle;
import com.luxvelocitas.tinybt.node.AbstractNode;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;


public abstract class AbstractDecorator extends AbstractNode implements INode {

    public AbstractDecorator(INode child) {
        super();
        addChild(child);
    }

    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        return mChildren.get(0).tick(logger, context);
    }

    @Override
    public void addChildren(INode... children) {
        throw new RuntimeException("Cannot add multiple children to Decorator");
    }
}
