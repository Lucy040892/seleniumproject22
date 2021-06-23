package com.cybertek.tests.day12_actions_upload_jsexecutor;

/*
    We will create similar logic we created in Driver utility class.
    But it will be for a String.
*/

public class Singleton {

    //Create private constructor
    private Singleton(){}

    //By making the String word private,
    // we will ensure we create access only through our getter method
    private static String word;

    //We allow user to access to 'word' in the way we want them to have
    public static String getWord(){

        if(word==null){
            System.out.println("First time call. Word object is null." +
                    "Assigning value to it now");
            word = "something";
        }else {
            System.out.println("Word already has a value.");
        }

        return word;

    }




}
