package com.luxvelocitas.tinybt.node.composite;


import com.luxvelocitas.tinydatautils.DataBundle;
import com.luxvelocitas.tinybt.node.AbstractNode;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;

public class Selector extends AbstractNode implements INode {
    public Selector(INode... children) {
        super(children);
    }

    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        for (Integer i : mChildrenIndex) {
            INode node = mChildren.get(i);

            switch (node.tick(logger, context)) {
                case RUNNING:
                    return running();
                case SUCCESS:
                    return success();
            }
        }
        return failure();
    }
}
