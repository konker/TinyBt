package com.luxvelocitas.tinybt.node.condition;


import com.luxvelocitas.tinydatautils.DataBundle;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;

public class SuccessCondition extends AbstractCondition implements INode {
    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        return success();
    }
}
