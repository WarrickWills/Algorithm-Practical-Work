package data.structures.and.algrithms.practical;

import java.util.Stack;

/**
 * Edited by Warrick Wills - 13831575
 */

/* Question 1: Deteching if all brackets in the given string are matching
 */
public class ExpProcessor {

    /**
     * You need to complete this method using the Stack data structure
     */
    public static void bracket(String str) 
    {
        /////write your code below
        boolean matching = true;
        boolean isBracket = true;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) 
        {
            char c = str.charAt(i);
            
            if(c == ' ')
                continue;
            
            if(c != '{' && c != '(' && c != '[' && c != '<' && c != '}' && c != ')' && c != ']' && c != '>') 
            {
                isBracket = false;
                break;
            }
 
            if(c == '{' || c == '(' || c == '['|| c == '<')
                stack.push(c);

            if(c == '}' || c == ')' || c == ']'|| c == '>') 
            {
                if(stack.isEmpty()) 
                    matching = false;

                if(c == '}' && stack.peek() == '{' || c == ')' && stack.peek() == '(' || c == ']' && stack.peek() == '[' || c == '>' && stack.peek() == '<')
                    stack.pop();
                else
                    matching = false;
            }

        }
        
        if(!stack.isEmpty())
            matching = false;

        if(isBracket == false )
            System.out.println("Invalid String");
        else if (matching == false)
            System.out.println("The brackets are not matching"); 
        else
            System.out.println("The brackets are matching");
    }
/////Write your code above

//You should not modify the main method in anyway    
    public static void main(String[] args) {
        bracket("((((()()()");
        bracket("{((<>))[][](())}");
        bracket("<(())()()(( )))");
        bracket("([<>][[{ }] ])");
        bracket("((<<))>>");
        bracket("(a)");

        /**Expected Output:
        *The parentheses are not matching
        *The parentheses are matching
        *The parentheses are not matching
        *The parentheses are matching
        *The parentheses are not matching
        *Invalid String
        */
    }
}
