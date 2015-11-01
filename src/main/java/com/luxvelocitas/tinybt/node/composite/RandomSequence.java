package com.luxvelocitas.tinybt.node.composite;

import com.luxvelocitas.datautils.Util;
import com.luxvelocitas.tinybt.node.INode;


public class RandomSequence extends Sequence implements INode {
    public RandomSequence(INode... children) {
        super(children);
    }

    @Override
    public void init() {
        super.init();
        Util.shuffleIntArrayInPlace(mChildrenIndex);
    }
}
