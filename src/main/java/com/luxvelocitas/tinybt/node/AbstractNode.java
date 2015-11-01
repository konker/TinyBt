package com.luxvelocitas.tinybt.node;

import org.slf4j.Logger;

import java.util.LinkedList;
import java.util.List;


public abstract class AbstractNode<T> implements INode<T> {
    protected NodeState mState;
    protected List<INode<T>> mChildren;
    protected int[] mChildrenIndex;

    public AbstractNode() {
        mChildren = new LinkedList<INode<T>>();
    }

    public AbstractNode(INode<T>... children) {
        mChildren = new LinkedList<INode<T>>();
        for (int i=0; i<children.length; i++) {
            mChildren.add(children[i]);
        }
    }

    @Override
    public void init() {
        mChildrenIndex = new int[mChildren.size()];
        initIndex();

        for (INode<T> node : mChildren) {
            node.init();
        }

        reset();
    }

    @Override
    public void reset() {
        for (INode<T> node : mChildren) {
            node.reset();
        }

        running();
    }

    @Override
    public NodeState state(NodeState state) {
        mState = state;
        return mState;
    }

    @Override
    public NodeState success() {
        mState = NodeState.SUCCESS;
        return mState;
    }

    @Override
    public NodeState failure() {
        mState = NodeState.FAILURE;
        return mState;
    }

    @Override
    public NodeState running() {
        mState = NodeState.RUNNING;
        return mState;
    }

    @Override
    public void addChild(INode<T> child) {
        mChildren.add(child);
    }

    @Override
    public NodeState getState() {
        return mState;
    }

    protected void initIndex() {
        for (int i=0; i<mChildren.size(); i++) {
            mChildrenIndex[i] = i;
        }
    }
}
