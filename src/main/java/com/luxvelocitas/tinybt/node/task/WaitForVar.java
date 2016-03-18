package com.luxvelocitas.tinybt.node.task;


import com.luxvelocitas.tinydatautils.DataBundle;
import com.luxvelocitas.tinybt.node.AbstractNode;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
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
