package com.luxvelocitas.tinybt.node.composite;


import com.luxvelocitas.tinybt.node.AbstractNode;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;

public class Sequence<T> extends AbstractNode<T> implements INode<T> {
    public Sequence(INode<T>... children) {
        super(children);
    }

    @Override
    public NodeState tick(Logger logger, T context) {
        for (Integer i : mChildrenIndex) {
            logger.debug("Sequence::tick, {}", i);
            INode<T> node = mChildren.get(i);

            switch (node.tick(logger, context)) {
                case RUNNING:
                    logger.debug("R");
                    return running();
                case FAILURE:
                    logger.debug("F");
                    return failure();
            }
        }
        logger.debug("S");
        return success();
    }
}
