package com.luxvelocitas.tinybt.node;


import com.luxvelocitas.datautils.DataBundle;
import org.slf4j.Logger;

public class SuccessCondition extends Condition implements INode {
    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        return success();
    }
}
