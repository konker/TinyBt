package com.luxvelocitas.tinybt.node;


import com.luxvelocitas.tinydatautils.DataBundle;
import org.slf4j.Logger;

public class Root extends AbstractNode implements INode {
    public Root(INode... children) {
        super(children);
    }

    @Override
    public NodeState tick(Logger logger, DataBundle context) {
        return state(mChildren.get(0).tick(logger, context));
    }
}
