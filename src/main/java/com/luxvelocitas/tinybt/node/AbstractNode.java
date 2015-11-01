package com.luxvelocitas.tinybt.node;

import java.util.LinkedList;
import java.util.List;


public abstract class AbstractNode implements INode {
    protected NodeState mState;
    protected List<INode> mChildren;
    protected int[] mChildrenIndex;

    public AbstractNode() {
        mChildren = new LinkedList<INode>();
    }

    public AbstractNode(INode... children) {
        mChildren = new LinkedList<INode>();
        for (int i=0; i<children.length; i++) {
            mChildren.add(children[i]);
        }
    }

    @Override
    public void init() {
        mChildrenIndex = new int[mChildren.size()];
        initIndex();

        for (INode node : mChildren) {
            node.init();
        }

        reset();
    }

    @Override
    public void reset() {
        for (INode node : mChildren) {
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
    public void addChild(INode child) {
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
