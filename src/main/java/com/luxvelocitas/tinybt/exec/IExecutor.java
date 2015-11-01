package com.luxvelocitas.tinybt.exec;

import com.luxvelocitas.datautils.DataBundle;
import com.luxvelocitas.tinybt.node.INode;
import com.luxvelocitas.tinybt.node.NodeState;


public interface IExecutor {
    NodeState execute(INode node, DataBundle context);
}
