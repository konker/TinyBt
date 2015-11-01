package com.luxvelocitas.tinybt;

import com.luxvelocitas.datautils.DataBundle;
import com.luxvelocitas.tinybt.exec.IExecutor;
import com.luxvelocitas.tinybt.exec.SimpleExecutor;
import com.luxvelocitas.tinybt.node.*;
import com.luxvelocitas.tinybt.node.composite.Sequence;
import com.luxvelocitas.tinybt.node.decorator.Invert;
import com.luxvelocitas.tinybt.node.decorator.Repeat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 */
public class App {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(App.class);

        logger.info("START");
        INode<DataBundle> root = new Root<DataBundle>(
            new Invert<DataBundle>(
                new Repeat<DataBundle>(3,
                    new Sequence<DataBundle>(
                        new Wait<DataBundle>(1000),
                        new Task<DataBundle>() {
                            @Override
                            public NodeState tick(Logger logger, DataBundle context) {
                                logger.info("TASK!");
                                return success();
                            }
                        }
                    )
                 )
            )
        );

        DataBundle context = new DataBundle();

        IExecutor<DataBundle> executor = new SimpleExecutor(logger);
        NodeState result = executor.execute(root, context);
        logger.info("END {}", result);
    }
}

