package com.luxvelocitas.tinybt.node;


import com.luxvelocitas.datautils.DataBundle;
import org.slf4j.Logger;

public class DummyTask extends Task implements INode {
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void reset() {
        super.reset();
    }

    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        logger.info("DUMMY");
        return success();
    }
}
