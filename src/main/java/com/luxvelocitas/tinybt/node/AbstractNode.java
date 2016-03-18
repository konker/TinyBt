package com.luxvelocitas.tinybt.node;

import java.util.LinkedList;
import java.util.List;


public abstract class AbstractNode implements INode {
    protected NodeState mState;
    protected List<INode> mChildren;
    protected int[] mChildrenIndex;

    private boolean _mTopLevelInitCalled;
    private boolean _mTopLevelResetCalled;

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
        _mTopLevelInitCalled = true;
    }

    // [FIXME: this should not be public]
    @Override
    public void _check() {
        // [FIXME: better exception]
        if (!_mTopLevelInitCalled) {
            throw new RuntimeException("Must call super.init if you override init: " + getClass());
        }
        // [FIXME: better exception]
        if (!_mTopLevelResetCalled) {
            throw new RuntimeException("Must call super.reset if you override reset: " + getClass());
        }

        for (INode node : mChildren) {
            node._check();
        }
    }

    @Override
    public void reset() {
        for (INode node : mChildren) {
            node.reset();
        }

        running();
        _mTopLevelResetCalled = true;
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
    public void addChildren(INode... children) {
        for (int i=0; i<children.length; i++) {
            mChildren.add(children[i]);
        }
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
