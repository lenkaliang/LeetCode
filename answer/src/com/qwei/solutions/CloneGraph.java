package com.qwei.solutions;

import com.qwei.javabasics.UnderstandHashcode;
import com.qwei.utils.UndirectedGraphNode;

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * Detailed description: https://leetcode.com/problems/clone-graph/?tab=Description
 */
public class CloneGraph {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
      return node;
    }

    // DFS
    Queue<UndirectedGraphNode> queue = new LinkedList<>();
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    queue.offer(node);

    UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    map.put(node, newNode);

    while (!queue.isEmpty()) {
      UndirectedGraphNode currNode = queue.poll();
      List<UndirectedGraphNode> neighbors = currNode.neighbors;

      // put all neibors to cloned node's neighbors
      for (UndirectedGraphNode oneNeighbor : neighbors) {
        // if this neighbor is a new node which needs to be processed, means map doesn't contain it
        if (map.containsKey(oneNeighbor)) {     // this one neighbor has been processed previously
          map.get(currNode).neighbors.add(map.get(oneNeighbor));  // 在当前node的clone node的neighbors里面为其添加oneNeighbor的克隆版
        } else {
          // if this node is not in Map, means this node has never been processed previously
          UndirectedGraphNode clonedNode = new UndirectedGraphNode(oneNeighbor.label);
          map.get(currNode).neighbors.add(clonedNode);            // 和34行一样，在克隆的node的neighbors里面添加oneNeighbor的克隆版
          map.put(oneNeighbor, clonedNode);
          queue.add(oneNeighbor);
        }
      }
    }

    return newNode;
  }
}
