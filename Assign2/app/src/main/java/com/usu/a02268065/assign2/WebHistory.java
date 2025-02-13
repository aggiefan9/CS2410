package com.usu.a02268065.assign2;

public class WebHistory {
    private class WebHistoryNode {
        String url;
        WebHistoryNode next;
        WebHistoryNode prev;
        WebHistoryNode(String url) {
            this.url = url;
        }
    }
    WebHistoryNode current;

    public WebHistory() {
        this.current = null;
    }
    public void insert(String url) {
        if (this.current == null) {
            this.current = new WebHistoryNode(url);
        } else {
            WebHistoryNode node = new WebHistoryNode(url);
            this.current.next = node;
            node.prev = this.current;
            this.current = node;
        }
    }

    public String forward() {
        if (this.current.next == null) {
            return this.current.url;
        }
        this.current = this.current.next;
        return this.current.url;
    }
    public String back() {
        if (this.current.prev == null) {
            return this.current.url;
        }
        this.current = this.current.prev;
        return this.current.url;
    }
}
