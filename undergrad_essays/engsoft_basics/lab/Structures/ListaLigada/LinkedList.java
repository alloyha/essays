/**
 * DataGUI - PMR2300
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 */

public class LinkedList { 
    LLNode firstNode;
    
    public void insert(String s) {
        firstNode = new LLNode(s, firstNode);
    }
    
    public void removeTop() {
        if (firstNode != null) 
            firstNode = firstNode.nextNode;
    }
    
    public void removeBottom() {
        LLNode p = firstNode;
        if (p == null) 
            return;
        LLNode n = firstNode.nextNode;
        if (n == null) {
            firstNode = null;
            return;
        }
        while (true) {
            LLNode aux = n;
            n = n.nextNode;
            if (n == null) {
                p.nextNode = null;
                return;
            } else
                p = aux;
        }
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (LLNode n = firstNode; n != null; n=n.nextNode) {
            sb.append(n.content);
            sb.append("\n");
        }
        return(sb.toString());
    }
}

class LLNode {
    String content;
    LLNode nextNode;
    
    LLNode(String s, LLNode n) {
        content = s;
        nextNode = n;
    }
}