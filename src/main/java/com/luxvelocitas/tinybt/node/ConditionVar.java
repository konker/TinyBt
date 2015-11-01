package com.luxvelocitas.tinybt.node;


import com.luxvelocitas.datautils.DataBundle;
import org.slf4j.Logger;

public class ConditionVar extends AbstractNode implements INode {
    protected final String mWaitKey;

    public ConditionVar(String waitKey) {
        super();
        mWaitKey = waitKey;
    }

    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        if (context.getBoolean(mWaitKey)) {
            return success();
        }
        else {
            return failure();
        }
    }
}
