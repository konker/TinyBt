package com.luxvelocitas.tinybt.node.condition;


import com.luxvelocitas.tinydatautils.DataBundle;
import com.luxvelocitas.tinybt.node.AbstractNode;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
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
