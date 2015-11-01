package com.luxvelocitas.tinybt.node.composite;

import com.luxvelocitas.datautils.Util;
import com.luxvelocitas.tinybt.node.INode;


public class RandomSelector extends Selector implements INode {
    public RandomSelector(INode... children) {
        super(children);
    }

    @Override
    public void init() {
        super.init();
        Util.shuffleIntArrayInPlace(mChildrenIndex);
    }
}
