/*
Copyright (c) <2015> <Sedrick Jefferson>



Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:



The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.



THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package CalculatorEngine;

import java.util.Scanner;

/**
 *
 * @author sedj601
 */
public class CalculatorEngine 
{
    private Scanner input;
    private double answer, var1, var2;
    private String expression, operation;      
    boolean isEqualPressed = false;
    boolean isDecimalPressed = false;
    boolean isOperationPressed = false;
    
    public CalculatorEngine()
    {
        answer = var1 = var2 = 0;
        expression = operation = "";
    }
    
    public void parseExpression(String expression)
    {
        this.expression = expression;
        input = new Scanner(this.expression);
        var1 = input.nextDouble();
        operation = input.next();
        var2 = input.nextDouble();       
    }
    
    public double processExpression() 
    {
        switch(operation)
        {
            case "x":
                answer = multiplication();
                break;
            case "/":
                answer = division();
                break;
            case "+":
                answer = addition();
                break;
            case "-":
                answer = subtraction();
                break;                
        }
        return answer;
    }
    
    public void setIsEqualPressed(boolean isEqualPressed)
    {
        this.isEqualPressed = isEqualPressed;
    }
    
    public boolean isEqualPressed()
    {
        return isEqualPressed;
    }
    
    public void setIsDecimalPressed(boolean isDecimalPressed)
    {
        this.isDecimalPressed = isDecimalPressed;
    }
    
    public boolean isDecimalPressed()
    {
        return isDecimalPressed;
    }
    
    public void setIsOperationPressed(boolean isOperationPressed)
    {
        this.isOperationPressed = isOperationPressed;
    }
    
    public boolean isOperationPressed()
    {
        return isOperationPressed;
    }
    
    private double subtraction()
    {        
        return var1 - var2;
    }
    
    private double addition()
    {       
        return var1 + var2;
    }
    
    private double multiplication()
    {        
        return var1 * var2;
    }
    
    /**
     *
     * @param expression
     * @return
     */
    private double division() 
    {        
        //System.out.println(var1/var2);
        return var1 / var2;        
    }
}
