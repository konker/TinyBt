package com.luxvelocitas.tinybt.node.decorator;

import com.luxvelocitas.datautils.DataBundle;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;


public class Succeed extends AbstractDecorator implements INode {
    public Succeed(INode child) {
        super(child);
    }

    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        mChildren.get(0).tick(logger, context);
        return success();
    }
}
