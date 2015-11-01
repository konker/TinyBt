package com.luxvelocitas.tinybt.node.decorator;

import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;


public class Limit<T> extends AbstractDecorator<T> implements INode<T> {
    protected int mMax;
    protected int mCountDown;

    public Limit(INode<T> child, int max) {
        super(child);
        mMax = max;
        mCountDown = mMax;
    }

    @Override
    public NodeState tick(Logger logger, T context) {
        if (mCountDown > 0) {
            mCountDown--;
            return mChildren.get(0).tick(logger, context);
        }
        return failure();
    }
}
