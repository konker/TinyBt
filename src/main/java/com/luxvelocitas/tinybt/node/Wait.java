package com.luxvelocitas.tinybt.node;


import com.luxvelocitas.datautils.DataBundle;
import org.slf4j.Logger;

import java.util.Date;

public class Wait extends AbstractNode implements INode {
    protected final long mWaitMs;
    protected long mStartTime;

    public Wait(long waitMs) {
        super();
        mWaitMs = waitMs;
    }

    @Override
    public void reset() {
        super.reset();
        mStartTime = (new Date()).getTime();
    }

    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        long curTime = (new Date()).getTime();
        if ((curTime - mStartTime) >= mWaitMs) {
            return success();
        }
        return running();
    }
}
