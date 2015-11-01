package com.luxvelocitas.tinybt.node;


import com.luxvelocitas.datautils.DataBundle;
import org.slf4j.Logger;

public class DummyTask extends Task implements INode {
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
