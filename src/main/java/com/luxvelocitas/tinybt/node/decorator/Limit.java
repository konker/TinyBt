package com.luxvelocitas.tinybt.node.decorator;

import com.luxvelocitas.datautils.DataBundle;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;


public class Limit extends AbstractDecorator implements INode {
    protected int mMax;
    protected int mCountDown;

    public Limit(int max, INode child) {
        super(child);
        mMax = max;
    }

    @Override
    public void init() {
        super.init();
        mCountDown = mMax;
    }

    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        INode child = mChildren.get(0);

        if (mCountDown > 0) {
            mCountDown--;
            return child.tick(logger, context);
        }
        return failure();
    }
}
