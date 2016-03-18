package com.luxvelocitas.tinybt.node.task;


import com.luxvelocitas.tinydatautils.DataBundle;
import com.luxvelocitas.tinybt.node.AbstractNode;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;

public abstract class AbstractTask extends AbstractNode implements INode {
    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        return mState;
    }
}
