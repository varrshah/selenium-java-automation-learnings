import java.util.ArrayList;

public class CoreJava {
    public static void main(String[] args)
    {
        //Datatypes --> int, string,char,double,boolean
        //Variables --> mynum,website,letter,dec,myCard

        int mynum = 5;
        String website = "Google";
        char letter = 'r';
        double dec = 6.23;
        boolean myCard = true;

        System.out.println(mynum+" is the value of mynum");  //+ is for concatenation
        System.out.println(website);

        //Arrays
        int[] arr = new int[5];  //[] declares array, new is operator
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        arr[3]=4;
        arr[4]=5;

        //simple way to declare the values if known
        int[] arr2 = {1,2,3,4,5,6,7,8,9,10,122};

        //forloop
        for(int i=0; i< arr.length; i++)
        {
            System.out.println(arr[i]);
        }

        for(int i=0; i<arr2.length; i++)
        {
            System.out.println(arr2[i]);
        }

        //String for loop
        String[] name = {"java","selenium","project"};
        for(int i=0; i<name.length; i++)
        {
            System.out.println(name[i]);
        }

        //enhanced for loop
        for(String s: name)
        {
            System.out.println(s);
        }

        //using conditional statements inside the loops
        //check if array is a multiple of 2

        for(int i=0; i<arr2.length; i++)
        {
            if (arr2[i] % 2 == 0)
            {
                System.out.println(arr2[i]);
            }
           else
            {
                System.out.println(arr2[i] +"is not a multiple of 2");
            }
        }

        //Arraylist
        ArrayList<String> a = new ArrayList<String>();
        a.add("one");
        a.add("two");
        a.add("three");
        a.add("four");
        System.out.println(a.get(3));


        //String is an object that represents a sequence of characters
        String s = "Selenium Java Project";  //String literal

        //allocating new memory
        String s2 = new String("Welcome");

       /* String[] splittedString = s.split(" ");
        System.out.println(splittedString[0]);
        System.out.println(splittedString[1]);
        System.out.println(splittedString[2]); */

        String[] splittedString = s.split("Java");
        System.out.println(splittedString[0]);
        System.out.println(splittedString[1]);
        System.out.println(splittedString[1].trim());  //trim() is to trim the white spaces

       /* for(int i=0; i<s.length(); i++)
        {
            System.out.println(s.charAt(i));         //charAt() will give the character at ith position
        }  */

        //print the characters in reverse order
        for(int i=s.length()-1; i>=0; i--)
        {
            System.out.println(s.charAt(i));
        }

    }
}
