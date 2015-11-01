package com.luxvelocitas.tinybt.node.composite;


import com.luxvelocitas.tinybt.node.AbstractNode;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;

public class Selector<T> extends AbstractNode<T> implements INode<T> {
    public Selector(INode<T>... children) {
        super(children);
    }

    @Override
    public NodeState tick(Logger logger, T context) {
        for (Integer i : mChildrenIndex) {
            INode<T> node = mChildren.get(i);

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
