/**
 * Binary Tree class
 * @author Ephraim Montag
 *
 */
public class BinaryTree {
   private BinaryNode root;
   public BinaryTree(){//no argument constructor
      root=null;
   }
   public BinaryTree(Object k){//one argument constructor
      root=new BinaryNode(k);
   }
   public boolean isEmpty(){//tests if tree empty
      return root==null;
   }
   public void makeEmpty(){//make tree empty
      root=null;
   }
   public int nodeCount(){//counts nodes in tree
      return BinaryNode.nodeCount(root);
   }
   public int height(){//gets height of tree
      return BinaryNode.height(root);
   }
   public Object getRootObj(){//gets object in tree
      return root.element;
   }
   public void setRootObj(Object x){//sets object in tree
      root.element=x;
   }
   public BinaryTree getLeft(){//gets left pointer
      BinaryTree t=new BinaryTree();
      t.root=root.left;
      return t;
   }
   public void setLeft(BinaryTree t){//sets left pointer
      root.left=t.root;
   }
   public BinaryTree getRight(){//gets right pointer
      BinaryTree t=new BinaryTree();
      t.root=root.right;
      return t;
   }
   public void setRight(BinaryTree t){//sets right pointer
      root.right=t.root;
   }
   public static void inorder(BinaryTree t){//states tree inorder
      if(!t.isEmpty()){
         inorder(t.getLeft());
         System.out.println(t.getRootObj());
         inorder(t.getRight());
      }
   }
   /*inserts tree into another tree*/
   public static BinaryTree insert(BinaryTree t,Object x){
      if(t.isEmpty()) return new BinaryTree(x);
      else{
         if(((Integer)t.getRootObj()).intValue()<((Integer)x).intValue())
            t.setRight(insert(t.getRight(),x));
         else t.setLeft(insert(t.getLeft(),x));
         return t;
      }
   }

}
