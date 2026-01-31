import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Longest_string {

    
 public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
    Node head = new Node(s.charAt(0));
    int max =1;
    for (int i = 1; i <s.length(); i++) {
        if(head.contains( new Node(s.charAt(i)) ) ){
            head.add(new Node(s.charAt(i)));
            head.removeUptoChar(new Node(s.charAt(i)));
            if(max >= head.length()){
                continue;
            }else{
                max = head.length();
            }
        }else{
            System.out.println("add ["+s.charAt(i)+"] "+head.prettyNodePrint(head,""));
            head.add(new Node(s.charAt(i)));
            if(max >= head.length()){
                continue;
            }else{
                max = head.length();        
            }
        }
    };
  return max;
    }
    public static void main(String[] args) {
        Longest_string ls = new Longest_string();
        String s = "pwwkew";
        System.out.println(ls.lengthOfLongestSubstring(s));
       
}
public class Node {
    char data;
    Node next;
    public Node() {
    }
    public Node(char data, Node next) {
        this.data = data;
        this.next = next;
    }
    public Node(char data) {
        this.data = data;
    }
    // function to check this node contains a repeated character
    public boolean contains(Node node ) {
        // if node checking is null return false
        if(node == null) return false;
        // if data matches return true
        return containsRecur(this,node);
    }
    // functionc to recursively check contains
    public boolean containsRecur(Node node_check,Node data){
        if(node_check == null) return false;
        if(node_check.data == data.data) return true;
        if(node_check.data != data.data)return containsRecur(node_check.next,data);
        return false;
    }
    // function to add a new node at the end
    public void add(Node node ) {

        // if(this.data)
        if (this.next == null) {
            this.next = node;
        }else
        {
            this.next.add(node);
        }
    }
    // functinc to remove nodes from start to given character
    public void removeUptoChar( Node node) {
    if(this == null) return ;
    if(this.next == null) return ;
    if(this.data != node.data){
        this.data = this.next.data;
        this.next = this.next.next;
        removeUptoChar(node);
      }
    else {
        this.data = this.next.data;
        this.next = this.next.next;
        return;

     
      }

  
    }
    //functionc to get length of Node 
    public int length() {
        if(this == null) return 0;
        return 1 + (this.next == null ? 0 : this.next.length());
    }

      public String prettyNodePrint(Node node , String result ){      
        if(node == null) return result;
        result += node.data  ;
        return  prettyNodePrint(node.next, result + " -> ") ;
    }
}

}