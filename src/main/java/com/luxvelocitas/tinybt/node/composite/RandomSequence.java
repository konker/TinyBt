package com.luxvelocitas.tinybt.node.composite;

import com.luxvelocitas.datautils.Util;
import com.luxvelocitas.tinybt.node.INode;
import org.slf4j.Logger;


public class RandomSequence<T> extends Sequence<T> implements INode<T> {
    public RandomSequence(INode<T>... children) {
        super(children);
    }

    @Override
    public void init() {
        super.init();
        Util.shuffleIntArrayInPlace(mChildrenIndex);
    }
}
