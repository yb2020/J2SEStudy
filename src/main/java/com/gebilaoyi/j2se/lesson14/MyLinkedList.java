package com.gebilaoyi.j2se.lesson14;

import com.gebilaoyi.j2se.lesson13.MyListInterface;

/**
 * @author bingyi
 * @date 2022/7/9
 * J2SEStudy
 **/
public class MyLinkedList implements MyListInterface {
    LinkNode linkNode = null;
    private int position = 0;
    @Override
    public void add(String element) {
        LinkNode childLinkNode = linkNode;
        LinkNode preNode = null ;
        for(int i = 0; i <= position; i ++) {
            if(i < position) {
                preNode = childLinkNode;
                childLinkNode = childLinkNode.getNextNode() ;
            }else {
                if(linkNode == null) {
                    linkNode = new LinkNode();
                    linkNode.setNode(element);
                }else {
                    childLinkNode = new LinkNode();
                    childLinkNode.setNode(element);
                    preNode.setNextNode(childLinkNode);
                }
            }
        }
        position++;
    }

    @Override
    public void add(int index, String element) {
        LinkNode childLinkNode = linkNode;
        LinkNode preNode = null ;
        LinkNode nextNode = null ;
        for(int i = 0; i <= index; i ++) {
            if(i < index) {
                preNode = childLinkNode;
                childLinkNode = childLinkNode.getNextNode() ;
                if(childLinkNode != null) {
                    nextNode = childLinkNode.getNextNode();
                }
            }else {
                if(linkNode == null) {
                    linkNode = new LinkNode();
                    linkNode.setNode(element);
                }else {
                    if(nextNode != null) {
                        LinkNode insertNode = new LinkNode();
                        insertNode.setNode(element);
                        insertNode.setNextNode(childLinkNode);
                        preNode.setNextNode(insertNode);
                    }else {
                        childLinkNode = new LinkNode();
                        childLinkNode.setNode(element);
                        preNode.setNextNode(childLinkNode);
                    }

                }
            }
        }
        position++;
    }

    @Override
    public int size() {
        return position;
    }

    @Override
    public void remove(int index) {
        LinkNode childLinkNode = linkNode;
        LinkNode preNode = null ;
        LinkNode nextNode = null ;
        for(int i = 0; i <= index; i ++) {
            if(i < index) {
                preNode = childLinkNode ;
                childLinkNode = childLinkNode.getNextNode() ;
                if(childLinkNode != null) {
                    nextNode = childLinkNode.getNextNode();
                }
            }else {
                preNode.setNextNode(nextNode);
            }
        }

        position --;
    }

    @Override
    public String get(int index) {
        LinkNode rootNode = linkNode;
        for(int i = 0; i <= index; i ++) {
            LinkNode childLinkNode = rootNode;
            if(i < index) {
                rootNode = childLinkNode.getNextNode() ;
            }else {
                return childLinkNode.getNode();
            }
        }
        return null;
    }
}

class LinkNode {
    private String node;
    private LinkNode nextNode;

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public LinkNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkNode nextNode) {
        this.nextNode = nextNode;
    }

}