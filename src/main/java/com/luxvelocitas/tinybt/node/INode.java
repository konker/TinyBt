package com.luxvelocitas.tinybt.node;

import com.luxvelocitas.datautils.DataBundle;
import org.slf4j.Logger;

/**
 * The base interface for a node in a TinyBt behaviour tree.
 * Nodes can be one of three basic types:
 *  - Task:      a leaf node which performs a domain-specfic task
 *  - Selector:  a node which succeeds if one of its children succeds (OR)
 *  - Sequence:  a node which fails if any of its children fail (AND)
 *  - Decorator: a node which has one child, and which can transform the child's result
 *
 * A node can be in one of three states:
 *  - RUNNING: the node is still performing its action
 *  - SUCCESS: the node has succeeded
 *  - FAILURE: the node has failed
 *
 * The behaviour tree naively traverses the tree recursively, evaluating the
 * nodes based on ticks, or single units of abstract time.
 *
*/
public interface INode {
    void init();
    void reset();

    /**
     * Perform the action of the node
     *
     * @param context  The execution context for the node
     * @return  The node's state after completing what its task
     */
    NodeState tick(Logger logger, DataBundle context);

    void addChild(INode child);

    NodeState getState();

    NodeState state(NodeState state);
    NodeState success();
    NodeState failure();
    NodeState running();

    //[FIXME: this is kind of an implementation detail?]
    void _check();
}
