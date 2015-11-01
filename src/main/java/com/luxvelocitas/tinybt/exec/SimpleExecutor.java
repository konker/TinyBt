package com.luxvelocitas.tinybt.exec;


import com.luxvelocitas.datautils.DataBundle;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;
import org.slf4j.Logger;


public class SimpleExecutor implements IExecutor<DataBundle> {
    protected final Logger mLogger;

    public SimpleExecutor(Logger logger) {
        mLogger = logger;
    }

    @Override
    public NodeState execute(INode<DataBundle> node, DataBundle context) {
        node.init();

        do {
            mLogger.info("Executor Will tick.. {}", node.getState());
            node.tick(mLogger, context);

            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (node.getState() == NodeState.RUNNING);

        return node.getState();
    }
}
