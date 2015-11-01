package com.luxvelocitas.tinybt.node.decorator;

import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;


public class Repeat<T> extends AbstractDecorator<T> implements INode<T> {
    protected int mMax;
    protected int mCountDown;

    public Repeat(INode<T> child) {
        super(child);
        mMax = -1;
    }

    public Repeat(INode<T> child, int max) {
        super(child);
        mMax = max;
    }

    @Override
    public void reset() {
        mCountDown = mMax;
    }

    @Override
    public NodeState tick(Logger logger, T context) {
        INode<T> child = mChildren.get(0);
        NodeState childState = child.tick(logger, context);
        switch (childState) {
            case FAILURE:
            case RUNNING:
                return state(childState);

            case SUCCESS:
                // Repeat, if mMax == -1, this will go on forever
                mCountDown--;
                if (mCountDown != 0) {
                    child.reset();
                    return running();
                }
        }
        return success();
    }
}
