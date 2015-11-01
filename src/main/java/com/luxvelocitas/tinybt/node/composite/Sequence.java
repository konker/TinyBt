package com.luxvelocitas.tinybt.node.composite;


import com.luxvelocitas.datautils.DataBundle;
import com.luxvelocitas.tinybt.node.AbstractNode;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;

public class Sequence extends AbstractNode implements INode {
    public Sequence(INode... children) {
        super(children);
    }

    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        for (Integer i : mChildrenIndex) {
            INode node = mChildren.get(i);

            switch (node.tick(logger, context)) {
                case RUNNING:
                    return running();
                case FAILURE:
                    return failure();
            }
        }
        return success();
    }
}
