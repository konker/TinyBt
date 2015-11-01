package com.luxvelocitas.tinybt.node;


import com.luxvelocitas.datautils.DataBundle;
import org.slf4j.Logger;

import java.util.Date;

public class WaitForVar extends AbstractNode implements INode {
    protected final String mWaitKey;
    protected long mStartTime;

    public WaitForVar(String waitKey) {
        super();
        mWaitKey = waitKey;
    }

    @Override
    public void reset() {
        super.reset();
        mStartTime = (new Date()).getTime();
    }

    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        long curTime = (new Date()).getTime();
        if ((curTime - mStartTime) >= context.getLong(mWaitKey)) {
            return success();
        }
        return running();
    }
}
