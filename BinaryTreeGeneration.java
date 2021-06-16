//////////////////////////////
//Matt Wang
//Binary tree Generation
//////////////////////////////
/*
 * 1.Array-based
 * 2.Reference-based
 */
import java.util.*;
class BinaryTreeGeneration { 
    static int root = 0; 
    static Object[] str = new Object[10]; 
      
    /*create root*/
    public void Root(String key) 
    { 
        str[0] = key; 
    } 
  
    /*create left son of root*/
    public void set_Left(String key, int root) 
    { 
        int t = (root * 2) + 1; 
  
        if(str[root] == null){ 
            System.out.printf("Can't set child at %d, no parent found\n",t); 
        }else{ 
            str[t] = key; 
        } 
    } 
  
    /*create right son of root*/
    public void set_Right(String key, int root) 
    { 
        int t = (root * 2) + 2; 
  
        if(str[root] == null){ 
            System.out.printf("Can't set child at %d, no parent found\n",t); 
        }else{ 
            str[t] = key; 
        } 
    } 
  
    public void print_Tree() 
    { 
    	System.out.print("Built Tree: ");
        for (int i = 0; i < 10; i++) { 
            if (str[i] != null) 
                System.out.print(str[i]); 
            else
                System.out.print("-"); 
              
        } 
    }
    public static void main(String[] args) 
    { 
        BinaryTreeGeneration obj = new BinaryTreeGeneration(); 
        obj.Root("0"); 
        obj.set_Left("1", 0); 
        obj.set_Right("2", 0); 
        obj.set_Left("3", 1); 
        obj.set_Right("4", 1); 
        obj.set_Left("5", 2); 
        obj.print_Tree(); 
    } 
} 	
