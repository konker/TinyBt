package com.luxvelocitas.tinybt.node;


import org.slf4j.Logger;

import java.util.Date;

public class Wait<T> extends AbstractNode<T> implements INode<T> {
    protected final long mWaitMs;
    protected long mStartTime;

    public Wait(long waitMs) {
        super();
        mWaitMs = waitMs;
    }

    @Override
    public void reset() {
        mStartTime = (new Date()).getTime();
    }

    @Override
    public NodeState tick(Logger logger, T context) {
        long curTime = (new Date()).getTime();
        if ((curTime - mStartTime) >= mWaitMs) {
            return success();
        }
        return running();
    }
}
