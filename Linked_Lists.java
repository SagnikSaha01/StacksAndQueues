LISP.java:
---------
import java.util.Scanner;

public class LISP {
    public static void main(String[] args) {
        
        Scanner in = new Scanner (System.in);
        Scanner option = new Scanner (System.in);
        System.out.println("Do you want a stack or queue? s=stack, q=queue");
        String choice = in.nextLine();
        boolean dataStructure = false;
        LinkedList myList = null;
        String data = "queue";
        if(choice.equals("s")){
            dataStructure = true;
            data = "stack";
        }
        int select = 0;
        int counter = 1;
       
        while (select != 6){
             System.out.println("Pick an option:");
        System.out.println("1 = Push, 2 = Pop, 3 = Display, 4 = Check in list, 5 = Reverse, 6 = Quit");
        System.out.println("You have currently selected a " + data);
        select = option.nextInt();       
            if(select == 1){
                System.out.println("Please enter your value");
                int val = in.nextInt();
                if(counter == 1){
                   myList = new LinkedList(val); 
                   counter++;
                }else{
                    if(myList == null){
                        myList = new LinkedList(val);
                    }else{
                   myList.push(val);
                    }
                }
                System.out.println("Sucessfully pushed value into the data strucutre");
            }else if(select == 2){
                if(counter == 1){
                    System.out.println("No values in the " + data + " to pop");
                }else{
               myList.pop(dataStructure); 
                System.out.println("Sucessfully popped value from the data structure");
                }
            }else if(select == 3){
                if(counter == 1){
                    System.out.println("No list to display");
                }else{
                myList.show();
                }
            }else if(select == 4){
                if(counter == 1){
                   System.out.println("No values to search for in the " + data); 
                }else{
               System.out.println("Enter the value you want to search for:");
               int val = in.nextInt();
               if(myList.checkList(val) == false){
                   System.out.println("That value was not found in the " + data);
               }
             }
            }else if(select == 5){
                if(counter == 1){
                    System.out.println("No values to reverse");
                }else{
                    if(myList == null){
                        System.out.println("No values to reverse");
                    }else{
                myList = myList.reverse();
                    }
                }
                
            }else if(select != 6){
                
                System.out.println("That is not a valid option");
            }
            
            
            
        }
        
        
        
        
    }
}

LinkedList.java:
---------------
public class LinkedList {
   public Node head;
   public int listCount; 
   
   public LinkedList(int d){
       
       head = new Node (d);
       
   }
   public void show(){
       
       Node current = head;
      if(current == null){
         System.out.println("There is no list to display"); 
      }else{ 
          System.out.println("Here is your list");
       while (current.next != null){
           System.out.print(current.data + " --> ");
           current = current.next;
          
       }
       System.out.println(current.data);
      }
       
   } 
   
    public boolean insertSort(int d){
      Node current = head;    
      Node newNode = new Node (d);
    if(current == null || head.data >= newNode.data){
        newNode.next = head;
        head = newNode;
    }else{
        while(current.next != null && current.next.data < newNode.data ){
            current=current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
      return true;  
    }
    public int length(){
        int counter = 0;
        Node current = head;
        while(current != null){
            current = current.next;
            counter++;
            
        }
        return counter;
    }
    
    public boolean deleteVal(int d){
        Node current = head;
        Node previous = head;
        boolean isInList = false;
       if(current.data == d ){
           if(current.next != null){
           head = current.next;
           isInList = true;
           }else{
               isInList = true;
               head = null;
           }
       }else{
        while(current.next != null ){
            if(current.data == d || isInList == true){
             
                 isInList = true;
                current.data = current.next.data;
                
                }
                previous = current;
                 current = current.next;
            }
       }
       if(current.data == d){
           isInList = true;
       }
       if(isInList){
        previous.next = null;
       }
        return isInList;
    }
    public void pop(boolean dataStructure){
        Node current = head;
        Node previous = head;
        if(dataStructure){
            if(current.next == null){
               head = null; 
            }else{
            while(current.next != null){
               previous = current;
               current = current.next;
            }
            previous.next = null;
        }
        }else{
           if(current.next != null){
           head = current.next;
           }else{
               head = null;
           }
       }
        
        
    }
    public boolean push(int newData){
        Node end = new Node(newData);
        Node current = head;
        if(current == null){
         head = end;   
        }else{
        while(current.next != null){
            current = current.next;
        }
        current.next = end;
        }
        return true;
    } 
    
    public LinkedList reverse(){
        Node current = head;
        LinkedList reveresedList = null;
        if(current == null){
            System.out.println("No values to reverse");
        }else{
            reveresedList = new LinkedList(current.data);
        while(current.next != null){
            Node begin = new Node(current.next.data);
            begin.next = reveresedList.head;
            reveresedList.head = begin;

            current = current.next;
            
        }
    }
       return reveresedList;
    }
    
    public boolean checkList(int c){
         Node current = head;
         boolean isInList = false;
         int counter = 1;
         int place = 0;
         if(current == null){
             System.out.println("No list to check");
         }else{
          while(current != null){
            if(current.data == c && isInList == false){
                isInList = true;
                place = counter;
            }
            current = current.next;
            counter++;
          }
         }
          if(isInList){
          System.out.println("Your value is in spot: "+ place);
          }
        return isInList;
    }
    
    //add tail
  /* public boolean push(int newData){
        Node end = new Node(newData);
        Node current = head;
        if(current == null){
         head = end;   
        }else{
        while(current.next != null){
            current = current.next;
        }
        current.next = end;
        }
        return true;
    }  
    */
    /*  public boolean delHead(){
        
        Node temp = head;
        head =  temp.next;
        return true;
    }
    */
    /*   public boolean delEnd(){
        Node current = head;
        Node prev = head;
        while(current.next !=null){
            prev = current;
            current = current.next;
        }
        prev.next = null;
        return true;
    }
    */
    
   /* public boolean addBegin(int d){
        
        Node begin = new Node(d);
        begin.next = head;
        head = begin;
        
        return true;
    }*/
}

Node.java:
---------
public class Node {
   
   int data;
   Node next = null;
   public Node(int d){
       
       data = d;
   }
}

