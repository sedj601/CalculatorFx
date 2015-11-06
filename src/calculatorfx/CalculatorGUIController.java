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
package calculatorfx;

import CalculatorEngine.CalculatorEngine;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

/**
 * FXML Controller class
 *
 * @author sedj601
 */
public class CalculatorGUIController implements Initializable 
{
    final static boolean DISABLE= true;
    final static boolean ENABLE = false;
    final static String PATTERN = "#,##0.####";
    final Tooltip tooltip = new Tooltip();
    final Tooltip tooltip2 = new Tooltip();
    
    String expression = "";
    String backEndExpression = "";
    double answer = 0;
    boolean isOperationPressed = false;
    CalculatorEngine calculatorEngine;   
    DecimalFormat decimalFormat;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        calculatorEngine = new CalculatorEngine();
        decimalFormat = new DecimalFormat(PATTERN);
        disableOperation(DISABLE);         
    }    
    
    public void btn0OnMouseClicked()
    {
        expression += "0";
        backEndExpression += "0";
        tfDisplay.setText(backEndExpression);
        
        if(isOperationPressed)
        {
            disableOperation(DISABLE);
        }
        else
        {
            disableOperation(ENABLE);
        }
    }
    
    public void btn1OnMouseClicked()
    {
        expression += "1";
        backEndExpression += "1";
        tfDisplay.setText(backEndExpression);
        if(isOperationPressed)
        {
            disableOperation(DISABLE);
        }
        else
        {
            disableOperation(ENABLE);
        }
    }
    
    public void btn2OnMouseClicked()
    {
        expression += "2";
        backEndExpression += "2";
        tfDisplay.setText(backEndExpression);
        if(isOperationPressed)
        {
            disableOperation(DISABLE);
        }
        else
        {
            disableOperation(ENABLE);
        }
    }
    
    public void btn3OnMouseClicked()
    {
        expression += "3";
        backEndExpression += "3";
        tfDisplay.setText(backEndExpression);
        if(isOperationPressed)
        {
            disableOperation(DISABLE);
        }
        else
        {
            disableOperation(ENABLE);
        }
    }
    
    public void btn4OnMouseClicked()
    {
        expression += "4";
        backEndExpression += "4";
        tfDisplay.setText(backEndExpression);
        disableOperation(ENABLE);
    }
    public void btn5OnMouseClicked()
    {
        expression += "5";
        backEndExpression += "5";
        tfDisplay.setText(backEndExpression);
        if(isOperationPressed)
        {
            disableOperation(DISABLE);
        }
        else
        {
            disableOperation(ENABLE);
        }
    }
    public void btn6OnMouseClicked()
    {
        expression += "6";
        backEndExpression += "6";
        tfDisplay.setText(backEndExpression);
        if(isOperationPressed)
        {
            disableOperation(DISABLE);
        }
        else
        {
            disableOperation(ENABLE);
        }
    }
    
    public void btn7OnMouseClicked()
    {
        expression += "7";
        backEndExpression += "7";
        tfDisplay.setText(backEndExpression);
        if(isOperationPressed)
        {
            disableOperation(DISABLE);
        }
        else
        {
            disableOperation(ENABLE);
        }
    }
    
    public void btn8OnMouseClicked()
    {
        expression += "8";
        backEndExpression += "8";
        tfDisplay.setText(backEndExpression);
        if(isOperationPressed)
        {
            disableOperation(DISABLE);
        }
        else
        {
            disableOperation(ENABLE);
        }
    }
    
    public void btn9OnMouseClicked()
    {
        expression += "9";
        backEndExpression += "9";
        tfDisplay.setText(backEndExpression);
        if(isOperationPressed)
        {
            disableOperation(DISABLE);
        }
        else
        {
            disableOperation(ENABLE);
        }
    }
    
    public void btnMultiplicationSignOnMouseClicked()
    {
        expression += " x ";
        backEndExpression = ""; 
        disableDecimalSign(ENABLE);
        disableOperation(DISABLE);
        isOperationPressed = true;
    }
    
    public void btnDivisionSignOnMouseClicked()
    {
        expression += " / ";
        backEndExpression = "";
        disableDecimalSign(ENABLE);
        disableOperation(DISABLE);
        isOperationPressed = true;
    }
    
    public void btnAdditionSignOnMouseClicked()
    {
        expression += " + ";
        backEndExpression = "";
        disableDecimalSign(ENABLE);
        disableOperation(DISABLE);
        isOperationPressed = true;
    }
    
    public void btnSubtractionSignOnMouseClicked()
    {
        expression += " - ";
        backEndExpression = "";
        disableDecimalSign(ENABLE);
        disableOperation(DISABLE);
        isOperationPressed = true;
    }
    
    public void btnDecimalSignOnMouseClicked()
    {
        expression += ".";
        backEndExpression += ".";
        tfDisplay.setText(backEndExpression);
        disableDecimalSign(DISABLE);
        
    }
    
    public void btnEqualSignOnMouseClicked()
    {   
        try
        {
            calculatorEngine.parseExpression(expression);
            answer = calculatorEngine.processExpression();
            
            if(answer != Double.POSITIVE_INFINITY)//used to catch dividing by zero
            {
                backEndExpression = "";
                expression = "";
                decimalFormat.setMaximumIntegerDigits(13);
                decimalFormat.setMaximumFractionDigits(4);
                String output = decimalFormat.format(answer);                
                if(output.length() < 22)
                {
                    tfDisplay.setText(output);
                    disableDecimalSign(ENABLE);
                    disableOperation(DISABLE);
                    isOperationPressed = false;
                }
                else
                {
                    tfDisplay.setText("Error! To many digits");
                    expression = "";
                    backEndExpression = "";
                    answer = 0;      
                    isOperationPressed = false;        
                    disableDecimalSign(ENABLE);
                    disableOperation(DISABLE);
                }                
            }
            else
            {      
                tfDisplay.setText("Error! Division by zero");            
                expression = "";
                backEndExpression = "";
                answer = 0;         
                isOperationPressed = false;
            }   
        }
        catch(NoSuchElementException e)
        {
            //System.out.println("error caught");
            tfDisplay.setText(backEndExpression);
        }        
    }    
    
    public void lblExitOnMouseClicked()
    {
        System.exit(1);
    }
    
    public void lblResetOnMouseClicked()
    {
        resetCalculator();
    }
    
    public void disableDigits(boolean control)
    {
        btn0.setDisable(control);
        btn1.setDisable(control);
        btn2.setDisable(control);
        btn3.setDisable(control);
        btn4.setDisable(control);
        btn5.setDisable(control);
        btn6.setDisable(control);
        btn7.setDisable(control);
        btn8.setDisable(control);
        btn9.setDisable(control);
    }
    
    public void disableOperation(boolean control)
    {
        btnMultiplicationSign.setDisable(control);
        btnDivisionSign.setDisable(control);
        btnAdditionSign.setDisable(control);
        btnSubtractionSign.setDisable(control);
    }
    
    public void disableDecimalSign(boolean control)
    {
        btnDecimalSign.setDisable(control);
    }
    
    public void lblExitOnMouseEntered()
    {
        tooltip.setText("Exit");  
        lblExit.setTooltip(tooltip);
    }
    
    public void lblResetOnMouseEntered()
    {
        tooltip2.setText("Reset");    
        lblReset.setTooltip(tooltip2);
    }
    
    private void resetCalculator()
    {
        expression = "";
        backEndExpression = "";
        answer = 0;   
        tfDisplay.setText("");
        isOperationPressed = false;        
        disableDecimalSign(ENABLE);
        disableOperation(DISABLE);
    }
    
    @FXML
    Label lblExit;
    @FXML
    Label lblReset;
    @FXML
    TextField tfDisplay;  
    @FXML
    Button btn0;
    @FXML
    Button btn1;
    @FXML
    Button btn2;
    @FXML
    Button btn3;
    @FXML
    Button btn4;
    @FXML
    Button btn5;
    @FXML
    Button btn6;
    @FXML
    Button btn7;
    @FXML
    Button btn8;
    @FXML
    Button btn9;
    @FXML
    Button btnMultiplicationSign;
    @FXML
    Button btnDivisionSign;
    @FXML
    Button btnAdditionSign;
    @FXML
    Button btnSubtractionSign;
    @FXML
    Button btnDecimalSign;    
    @FXML
    Button btnEqualSign;
}
