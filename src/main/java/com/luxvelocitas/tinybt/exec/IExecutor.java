package com.luxvelocitas.tinybt.exec;

import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;


public interface IExecutor<T> {
    NodeState execute(INode<T> node, T context);
}
