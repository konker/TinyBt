package com.luxvelocitas.tinybt;

import com.luxvelocitas.datautils.DataBundle;
import com.luxvelocitas.tinybt.exec.IExecutor;
import com.luxvelocitas.tinybt.exec.SimpleExecutor;
import com.luxvelocitas.tinybt.node.*;
import com.luxvelocitas.tinybt.node.composite.Sequence;
import com.luxvelocitas.tinybt.node.decorator.Invert;
import com.luxvelocitas.tinybt.node.decorator.Limit;
import com.luxvelocitas.tinybt.node.decorator.Repeat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 */
public class App {
    public static void main(String[] args) {
        // Set up the behaviour tree
        INode root = new Root(
            new Invert(
                new Repeat(-1,
                    new Sequence(
                        new WaitForVar("fooMs"),
                        new Limit(4,
                            new DummyTask("I AM DUMMY")
                        )
                     )
                )
            )
        );

        // Create a logger
        Logger logger = LoggerFactory.getLogger(App.class);

        // Set up a context object
        DataBundle context = new DataBundle();
        context.putLong("fooMs", 1500);

        // Execute the tree
        IExecutor executor = new SimpleExecutor(logger);
        NodeState result = executor.execute(root, context);

        logger.info("END {}", result);
    }
}

