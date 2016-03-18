package com.luxvelocitas.tinybt.node.task;


import com.luxvelocitas.tinydatautils.DataBundle;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import com.luxvelocitas.tinybt.node.task.AbstractTask;
import org.slf4j.Logger;

public class DummyTask extends AbstractTask implements INode {
    private String mMessage;

    public DummyTask(String message) {
        mMessage = message;
    }

    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        logger.info(mMessage);
        return success();
    }
}
