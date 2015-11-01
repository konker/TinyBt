package com.luxvelocitas.tinybt.node;


import com.luxvelocitas.datautils.DataBundle;
import org.slf4j.Logger;

public abstract class Task extends AbstractNode implements INode {
    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        return mState;
    }
}
