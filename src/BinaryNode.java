/**
 * 
 * @author Ephraim Montag
 *
 */
public class BinaryNode {
   Object element;//holds data
   BinaryNode left,right;//two pointers
   BinaryNode(){//no argument constructor
      this(null);//calls 1 argument constructor
   }
   BinaryNode(Object e){
      this(e,null,null);//calls 3 argment constructor
   }
   BinaryNode(Object e, BinaryNode ln,BinaryNode rn){//3 argment constructor. sets values
      element=e;
      left=ln;
      right=rn;
   }
   static int nodeCount(BinaryNode n){//to count nodes
      if(n==null) return 0;
      return 1+nodeCount(n.left)+nodeCount(n.right);
   }
   static int height(BinaryNode n){//to count height of tree
      if(n==null) return 1;
      return 1+Math.max(height(n.left), height(n.right));
   }

}
