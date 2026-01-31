import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Longest_string {

    
 public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
    Node head = new Node(s.charAt(0));
    int max =0;
    for (int i = 1; i <s.length(); i++) {
        if(head.contains(head, s.charAt(i)) ){
            head.add(new Node(s.charAt(i)));
            
            // 
            // 
            
            head.removeUptoChar(s.charAt(i));
            if(max < head.length()){
                max = head.length();
            }
           
        }else{
            head.add(new Node(s.charAt(i)));
            max++;
        }
    };
  return max;
    }
    public static void main(String[] args) {
        Longest_string ls = new Longest_string();
        String s = "abcabcbb";
        System.out.println(ls.lengthOfLongestSubstring(s));
       
}
public class Node {
    char data;
    Node next;
    public Node() {
    }
    public Node(char data, Longest_string.Node next) {
        this.data = data;
        this.next = next;
    }
    public Node(char data) {
        this.data = data;
    }
    // function to check this node contains a repeated character
    public boolean contains(Node node , char c) {
        // if node checking is null return false
        if(node == null) return false;
        // if data matches return true
        if(node.data == c) return true;
        if(node.next != null) {
            return contains(node.next , c);
        }
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
    public Node removeUptoChar( char data) {
    // if(this == null) return ;
    // if(this.next == null) return ;
    // if(this.data != c){
    //     this.data = this.next.data;
    //     this.next = this.next.next;
    //     removeUptoChar(c);
    //   }

    //   if(this.data == c){
    //     this.data = this.next.data;
    //     this.next = this.next.next;
    //     return ;
    //   }

    if(this == null) return null;
    if(this.data != data)return this.next.removeUptoChar(data);
    if(this.data == data){
        if(this.next != null){
        return this.next;
    }else{
        return null;
    }
    }
    return null;
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