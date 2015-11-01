package com.luxvelocitas.tinybt.node.decorator;

import com.luxvelocitas.datautils.DataBundle;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;


public class Invert extends AbstractDecorator implements INode {
    public Invert(INode child) {
        super(child);
    }

    @Override
    public NodeState tick(Logger logger, DataBundle context) {
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
