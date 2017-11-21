/**
 * Owner : Adedayo Matt
 * Date coded: December 25-27, 2015
 * 
 * PROGRAM SUMMARY: This program (Matt_Java_Calculator_V1.1.0) is a functional 
 * calculator built using javax.swing components, it performs the four basic 
 * arithmetic operations and several scientific functions which include Trigonometric
 * functions using the respective methods from the java.lang.Math class.
 * 
 * For help on how to run this code in another IDE,
 * contact the owner through the following channels;
 * ----------------------------------------------------
 * phone: +2348139004572
 * email: adedayomatt@gmail.com
 * facebook: www.facebook.com/kayode.adedayo1
 * ------------------------------------------------------
 */
package java_calculator;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Random;
public class calculatorv110 {
    
 /*
    Global Variables
 */
    private final JFrame frame;
    private final JTextField ScientificOperation;
    private JTextField display;
    private final JTextField displayresult;
    private final JButton equalsButton,point;
    JPanel numberButtonPanel,OperationPanel,displayPanel;
    JMenuItem Switch,about,Exit,settings,contact;
    Color buttonColor ;
    Color operationButtonColor ;
    Color scientificButtonColor ;
    Color NewButtonColor, NewOperationButtonColr, NewScientificButtonColor;
    String memory = "";
    String ongoing ="Last Operation";
    Font f12 = new Font("Arial", Font.BOLD, 15);
    double initial,result;
    final double E = 2.7182818284590452354;
    final double PI = 3.14159265358979323846;
    int operation;
       int X,Y;
  Random RN = new Random();
      double randomNumber = RN.nextDouble();
  /*
       End of Global Variable declarations
  */    
       //Constructors begins
      /**
      *           Constructor arguments definitions
      * @param NumberButtonColor gives the number buttons the defined color
      * @param OperationButtonColor gives the operation buttons like(+,-,*,/) the defined color
      * @param ScientificButtonColor gives the scientific function buttons the defined color
      * @param dimX sets the program horizontal dimension
      * @param dimY sets the program vertical dimension
      * 
      * When calling this constructor, define the program properties in the 
      * argument as arranged in the constructor.
      */  
      public calculatorv110(Color NumberButtonColor, Color OperationButtonColor,
              Color ScientificButtonColor, int dimX, int dimY){
     /*
          Attributing the properties to a global variable for use in other
          methods out of the constructor but in the same class calculatorv100
      */
      X = dimX;
      Y = dimY;
      buttonColor = NumberButtonColor;
      operationButtonColor = OperationButtonColor;
      scientificButtonColor = ScientificButtonColor;
     /*
        Making an object for the class eventHandler which implements ActionListener
     */
          eventHandler EH = new eventHandler();
      /*
        The main JFrame
     */    
          frame = new JFrame();
          frame.setTitle("Matt Java Calculator v1.1.0");
          frame.setLayout(new GridLayout(2,1));
     /*
          MenuBar and the menu's
     */     
          JMenuBar menu = new JMenuBar();
          JMenu options = new JMenu("options");
          JMenu Help = new JMenu("Help");
     /*
          JMenuItems  
      */    
          Switch = new JMenuItem("Switch to Basic");
           about = new JMenuItem("About Device");
           settings = new JMenuItem("Display Settings");
           Exit = new JMenuItem("Exit");
           contact = new JMenuItem("contacts");
      /*
           Adding JMenuItems to the JMenu's   
     */     
          options.add(Switch);
          options.add(about);
          options.add(settings);
          options.add(Exit);
          Help.add(contact);
      /*
          Adding actionListener to each JMenuItem 
     */    
          Switch.addActionListener(EH);
          about.addActionListener(EH);
          Exit.addActionListener(EH);
          settings.addActionListener(EH);
          contact.addActionListener(EH);
    /*
          Adding the JMenu's to the main JMenuBar
    */   
         menu.add(options);  menu.add(Help);
    /*
        *Now adding the JMenuBar to the main JFrame 
   */       
          frame.setJMenuBar(menu);
    /*
         This is the JTextField that displays the current operation when using the calculator     
   */      
          ScientificOperation = new JTextField(5);
          ScientificOperation.setText(ongoing);
          ScientificOperation.setEditable(false);
   /*
         This is the JTextField that displays the inputs when using the calculator     
   */      
          display = new JTextField(15);
          display.setBackground(Color.WHITE);
          display.setFont(f12);
          display.setHorizontalAlignment(JTextField.RIGHT);
          display.setEditable(false);
    /*
         This is the JTextField that displays the summary of  operations   
     */      
         displayresult = new JTextField(10);
         displayresult.setText(String.valueOf(0));
         displayresult.setHorizontalAlignment(JTextField.LEFT);
         displayresult.setEditable(false);
    /*
            The panel(x) where the three JTextField are added to is added to this 
            panel and the panel(y) where the scientific function buttons are added 
            to is also added to this panel
        */        
          displayPanel = new JPanel();
          displayPanel.setLayout(new GridLayout(2,1));
    
                
          JPanel x = new JPanel();
          x.setLayout(new GridLayout(3,1));
          x.add(ScientificOperation, BorderLayout.WEST);
          x.add(display, BorderLayout.WEST);
          x.add(displayresult, BorderLayout.WEST);
          
          
          JPanel y = new JPanel();
          y.setBackground(Color.PINK);
          
          OperationPanel = new JPanel();
          OperationPanel.setBackground(Color.PINK);
          OperationPanel.setLayout(new GridLayout(4,4,4,4));
          y.add(OperationPanel);
          
         
          
          displayPanel.add(x);displayPanel.add(y);
   /*
        Backspace button  
     */
          JButton BackSpace = new JButton("<<==C");
          BackSpace.setBackground(Color.white);
          BackSpace.setForeground(Color.red);
          BackSpace.addActionListener(
     new ActionListener(){
 @Override
 public void actionPerformed(ActionEvent e) {
     try{
     display.setText(display.getText().substring(0,display.getText().length()-1));
     }
     catch(StringIndexOutOfBoundsException error){
     }
 }
     } );
       /*
            Cancel button, it calls the method clearMemory() when invoked
            The method clearMemory() clears all the values from  last operation
        */    
          JButton CE = new JButton("CE");
          CE.setBackground(Color.white);
          CE.setForeground(Color.red);
          CE.addActionListener(
     new ActionListener(){
 @Override
 public void actionPerformed(ActionEvent e) {
                  clearMemory();
 
 }
     } );
     /*
         point(.) button 
      */
      point = new JButton (".");
      point.setFont(f12);
      point.setForeground(NumberButtonColor);
      point.addActionListener(
      new ActionListener(){
      public void actionPerformed(ActionEvent p){
      String temp = getValue();
      display.setText(temp + ".");
      }
      });
    /*
        Equals Button
     */  
          equalsButton = new JButton("=");
          equalsButton.setFont(f12);
          equalsButton.setForeground(Color.red);
    /*
          This numberButtonPanel is where all the number buttons are located
     */
          numberButtonPanel = new JPanel();
          numberButtonPanel.setBackground(Color.DARK_GRAY);
          numberButtonPanel.setLayout(new GridLayout(6,5,4,4));
          
          JButton power = new JButton("x^y");
          power.setBackground(ScientificButtonColor);
          power.addActionListener(
          new ActionListener(){
 @Override
          public void actionPerformed(ActionEvent e) {
           String input = getValue();
           try{
          initial = Double.parseDouble(input);
           }
           catch(NumberFormatException error){
           
           }
           ScientificOperation.setText(ongoing+"\t\t x^y");
           display.setText("");
           displayresult.setText(String.valueOf(initial) + "^");
           operation = 6;
          }}
          );
     /*
           S_Button(String,int) method is already defined 
     */     
  S_Button("sin",11);S_Button("cos",12);S_Button("tan",13);S_Button("log",10);
  S_Button("asin",14);S_Button("acos",15);S_Button("atan",16);S_Button("exp",17);
  constants(OperationPanel,"PI",PI); S_Button("^2",5);OperationPanel.add(power);
  constants(OperationPanel,"E",E);S_Button("1/x",9); S_Button("sqrt",7);
   constants(OperationPanel,"RND",randomNumber);S_Button("-/+",8);
  
          /*
         memoryButton(String,int) method is already defined 
      */ 
          memorybutton("M+",13); memorybutton("M-",14);
          memorybutton("ME",15);
          //adding the backspace button to the numberButtonPanel
          numberButtonPanel.add(BackSpace);
          
      /*
         button(int) method is already defined 
         OperationButton(String,int) method is already defined 
         All these occur in the numberButtonPanel
       */     
          button(1);button(2);button(3);OperationButton(numberButtonPanel,"+",1);
          button(4);button(5);button(6);OperationButton(numberButtonPanel,"-",2);
          button(7);button(8);button(9);OperationButton(numberButtonPanel,"*",3);
          numberButtonPanel.add(point);button(0);  OperationButton(numberButtonPanel,"/", 4);
          
           //adding equals button
          numberButtonPanel.add(equalsButton);
          //adding the cancel button
          numberButtonPanel.add(CE);
         
     /*
        empty buttons to fill up the the Grid Layout, method is defined down
        the lines
   */
          emptyButton(numberButtonPanel,"@matt");
          emptyButton(numberButtonPanel,"(c)");
          emptyButton(numberButtonPanel,"2015");
   
     /*
        displayPanel and numberButtonPanel are added to the main JFrame
    */  
         frame.add(displayPanel); 
         frame.add(numberButtonPanel);
    /*
         Main logics are carried out in the method MainOperation
      */       
      try{
      MainOperations();
          }
      /*
        Should there be any Exception while executing the method...
      */
          catch(Exception error){
          displayresult.setText("error");
          }
      /*
        main JFrame windows properties
      */
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(dimX,dimY);
      frame.setLocation(488, 200);
      frame.setVisible(true);
      frame.setResizable(false);
      }
 /*
      Main Operations Logic
      The equals buttton is assigned with what to do with the inputs when
      different operation and scientific operation buttons are invoked
  */
    final void MainOperations(){
           try{
      equalsButton.addActionListener(
      new ActionListener(){
      public void actionPerformed(ActionEvent e){
         double lastV = 0,degree ;
          if(display.getText().isEmpty()){
         
          }
          else{
              try{
     lastV = Double.parseDouble(getValue());
              }
              catch(NumberFormatException ev){
              displayresult.setText("invalid number");
              }
      switch(operation){
          case 0 :
              ScientificOperation.setText(ongoing);
              display.setText("");
              displayresult.setText(String.valueOf(0));
              break;
              /*
              Basic operations
              */
          case 1:
              result = initial + lastV;
              display.setText(String.valueOf(result));
                 displayresult.setText(String.valueOf(initial) + " + "
                    + String.valueOf(lastV) + " = " + String.valueOf(result));  
                    break;
          case 2:
            result = initial - lastV;
                        display.setText(String.valueOf(result));
                     displayresult.setText(String.valueOf(initial) + " - "
                    + String.valueOf(lastV) + " = " + String.valueOf(result));  
                   break;
          case 3:
           result = initial * lastV;
              display.setText(String.valueOf(result));
               displayresult.setText(String.valueOf(initial) + " * "
                  + String.valueOf(lastV) + " = " + String.valueOf(result));  
                    break;
          case 4:
              try{
              result = initial / lastV; 
                display.setText(String.valueOf(result));
                displayresult.setText(String.valueOf(initial) + " / "
                    + String.valueOf(lastV) + "= " + String.valueOf(result));  
           }
              catch(Exception event){
              displayresult.setText("syntax Error");
              }
                        break;
          case 5:
        result = lastV * lastV;
         displayresult.setText(String.valueOf(lastV)+"^2 = " 
                 + String.valueOf(result));  
         display.setText(String.valueOf(result));
                    break;
         case 6:
           result = Math.pow(initial,lastV);
        display.setText(String.valueOf(result));
        displayresult.setText(String.valueOf(initial)+"^" + lastV + " = " + 
                String.valueOf(result));
                    break;
          case 7:
        result = Math.sqrt(lastV);
        display.setText(String.valueOf(result));
         displayresult.setText("sqrt "+lastV + " = " + String.valueOf(result));
                    break;
    case 8:
        result = -1 * lastV;
       display.setText(String.valueOf(result));
         displayresult.setText(String.valueOf(result));
                    break;
        case 9:
        result = 1 / lastV;
        display.setText(String.valueOf(result));
         displayresult.setText("1/"+lastV + " = " + String.valueOf(result));
                 break;
    case 10:
   result = Math.log10(lastV);
    displayresult.setText("log" + String.valueOf(lastV) + "= "
            + String.valueOf(result));  
      display.setText(String.valueOf(result));
                    break;
    
       /*
              Trigonometric function operations are carried out here
              the value is first converted to radian
        */
         case 11:
    degree = Math.toRadians(lastV);
    result = Math.sin(degree);
    display.setText(String.format("%.4f",result));
    displayresult.setText("sin " + lastV + " = " + String.format("%.4f",result));
            break;
     case 12:
    degree = Math.toRadians(lastV);
    result = Math.cos(degree);
    display.setText(String.format("%.4f",result));
    displayresult.setText("cos " + lastV + " = " + String.format("%.4f",result));
                break;
    case 13:
    degree = Math.toRadians(lastV);
    result = Math.tan(degree);
    display.setText(String.format("%.4f",result));
    displayresult.setText("tan " + lastV + " = " + String.format("%.4f",result));
                    break;
     case 14:
        degree = Math.asin(lastV);
        result = Math.toDegrees(degree);
        display.setText(String.format("%.4f",result));
        displayresult.setText("arcsin " + lastV + " = " + 
                String.format("%.4f",result));
                    break;
         case 15:
        degree = Math.acos(lastV);
        result = Math.toDegrees(degree);
        display.setText(String.format("%.4f",result));
        displayresult.setText("arccos " + lastV + " = " + 
                String.format("%.4f",result));
                    break;
        case 16:
        degree = Math.atan(lastV);
        result = Math.toDegrees(degree);
        display.setText(String.format("%.4f",result));
        displayresult.setText("arctan " + lastV + " = " + 
                String.format("%.4f",result));
                    break;
        case 17:
        result = Math.exp(lastV);
        display.setText(String.format("%.4f",result));
        displayresult.setText("exp " + lastV + " = " + 
                String.format("%.4f",result));
                    break;
     
     default:
       int tempo = Integer.parseInt(display.getText());
       int a = tempo * 1;
        displayresult.setText(String.valueOf(a));
                break;
      }
      } }}
      );
   //End of equal button's ActionListener
     }
     catch(Exception errorMode){
 displayresult.setText("error404");
}
      }
/*
    End of Logic Operation
 */    
  /*
    Number Butttons and commands to display each value on each buttons
  */
      final void button(final int buttonName){
          
  JButton newButton = new JButton(String.valueOf(buttonName));
          newButton.setFont(f12);
          newButton.setForeground(buttonColor);
    numberButtonPanel.add(newButton);
try{
    newButton.addActionListener(
    new ActionListener(){
@Override
public void actionPerformed(ActionEvent e) {
     String temp = getValue();
   display.setText(temp + String.valueOf(buttonName));
}});
    }
catch(Exception errorMode){
 displayresult.setText("error404");
}
}
  /*
      operation Buttons
  */
 final void OperationButton(Container Parent,final String sign, final int todo){
          JButton newButton = new JButton(sign);
          newButton.setFont(f12);
          newButton.setForeground(operationButtonColor);
          newButton.addActionListener(
          new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e) {
                  ScientificOperation.setText(ongoing +"\t\t\t" + sign);
                if(!getValue().equals("")){
                    try{
                       initial = Double.parseDouble(getValue());
                    }
                    catch(Exception error){
                        displayresult.setText("[E]" + ongoing);
                    displayresult.setText("invalid digit");
                    }
                       operation = todo; 
                       clear(sign);
                }
                else{
                operation = 0;
                } } }
          );
 Parent.add(newButton);
      }
 /*
     This method returns the current digits on the input JTextField
   */
String getValue(){   
       return display.getText();
       }
  /*
     This method clears the current digit on the input JTextField then prepare  
     to receive the next digit to operate on after an
     operation button is invoked .
   */
void clear(String sign ){
 
    display.setText("");
    displayresult.setText(String.valueOf(initial) +" " + sign);
    }
/*
     This method clears the values ftrom the previous operation
     The "CE" button performs this
   */
void clearMemory(){
    result = 0; initial = 0;
    operation = 0;
if(!memory.equals("")){
    ScientificOperation.setText("[M+]" + ongoing);}
else{
    ScientificOperation.setText(ongoing);
        }
    display.setText("");
    displayresult.setText("0");
    }
/*
     The sqare root, power and +/- buttons and all scientific and trigonometric
     function buttons are called from here
   */
final void S_Button(final String op, final int action){
    JButton scientific = new JButton(op);
            scientific.setBackground(scientificButtonColor);
    try{
            scientific.addActionListener(
    new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent s){
         ScientificOperation.setText(ongoing +"\t\t\t"+ op);
            operation = action;
    }});
        }
    catch(Exception errorMode){
    
    }
    OperationPanel.add(scientific);
}
/*
    This method handles the memory buttons:
    M+ which get digit on the input JTextField and save in a memory
    M- which clear/reset the memory to 0
    ME which fetch and display the value saved last in the memory
*/
final void memorybutton(String name,final int x){
        JButton M = new JButton(name);
            numberButtonPanel.add(M);
        M.setBackground(Color.cyan);
        M.addActionListener(
    new ActionListener(){
public void actionPerformed(ActionEvent AE){
    switch(x){
        case 13:
          ScientificOperation.setText("[M+]" + ongoing);
            memory = String.valueOf(getValue());
                    break;
        case 14:
            ScientificOperation.setText("[M-]" + ongoing);
            memory = "";
                     break;
        case 15:
            ScientificOperation.setText("[ME]" + ongoing);
            display.setText(memory);
                         break;
        default:
            displayresult.setText("xyz");
                        }
                    }
                }
            );
          }
/*
constant butttons like Exponential are called from here
*/
final void constants(Container parent, final String cons, final double value){
        JButton constantButton = new JButton(cons);
                constantButton.setBackground(scientificButtonColor);
                constantButton.addActionListener(
                        new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent s){
         ScientificOperation.setText(ongoing +"\t\t\t"+ cons);
            display.setText(String.valueOf(value));
            displayresult.setText(cons+ " = " + String.valueOf(value) );
    }});
                parent.add(constantButton);
        }
/*
emptyButton() method only create an button without any functionality
*/
final void emptyButton(Container where,String anything){
        JButton empty = new JButton(anything);
        empty.setBackground(Color.DARK_GRAY);
        empty.setForeground(Color.MAGENTA);
            where.add(empty);
}
/*
     This method allows the user to configure the appearance of the application
   */
void settingsMethod(){
    
        final JFrame settingsFrame = new JFrame();
                settingsFrame.setTitle("display settings");
                settingsFrame.setLayout(new GridLayout(2,1));
                
            JPanel panel1 = new JPanel();
                    panel1.setLayout(new GridLayout(1,2));

            JPanel panel2 = new JPanel();
                    panel2.setLayout(new FlowLayout());

            JPanel options = new JPanel();
                    options.setLayout(new GridLayout(4,1));
                    
            JPanel sample = new JPanel();
                   sample.setLayout(new GridLayout(4,1));

            JButton BC = new JButton("Number Button Color");
            JButton BOC = new JButton("Oeration Button Color");
            JButton SBC = new JButton("Scientific Button Color");
            JButton resize = new JButton("change size");
            
            options.add(BC); options.add(BOC); 
            options.add(SBC);options.add(resize);

        final JTextField buttonColorSample = new JTextField(5);
        buttonColorSample.setBackground(buttonColor);
        
        final JTextField operationColorSample = new JTextField(5);
        operationColorSample.setBackground(operationButtonColor);
        
         final JTextField SColorSample = new JTextField(5);
         SColorSample.setBackground(scientificButtonColor);

        JPanel resizingPanel = new JPanel();
               resizingPanel.setLayout(new GridLayout(1,0,2,5));

        final JTextField dimX = new JTextField(5);
            dimX.setEditable(false);
            dimX.setText(String.valueOf(X));
            
        final JTextField dimY = new JTextField(5);
            dimY.setEditable(false);
            dimY.setText(String.valueOf(Y));

        resizingPanel.add(dimX); resizingPanel.add(dimY);

        sample.add(buttonColorSample);
        sample.add(operationColorSample);
        sample.add(SColorSample); 
        sample.add(resizingPanel);


    BC.addActionListener(
        new ActionListener(){
@Override
public void actionPerformed(ActionEvent q){
    
    NewButtonColor =JColorChooser.showDialog(null, "choose color",NewButtonColor);
        buttonColorSample.setBackground(NewButtonColor);
        }});
    
    BOC.addActionListener(
        new ActionListener(){
@Override
public void actionPerformed(ActionEvent q){
    
    NewOperationButtonColr =JColorChooser.showDialog(null, "choose color",NewOperationButtonColr);
    operationColorSample.setBackground(NewOperationButtonColr);
        }});
    
    SBC.addActionListener(
        new ActionListener(){
@Override
public void actionPerformed(ActionEvent q){
    
    NewScientificButtonColor =JColorChooser.showDialog(null, "choose color",NewScientificButtonColor);
    SColorSample.setBackground(NewScientificButtonColor);
    }});

     resize.addActionListener(
         new ActionListener(){
@Override
public void actionPerformed(ActionEvent q){
        dimX.setEditable(true);
        dimY.setEditable(true);
 }});

panel1.add(options);panel1.add(sample);

    JButton finishButton = new JButton("finish");
    finishButton.addActionListener(
        new ActionListener(){
@Override
public void actionPerformed(ActionEvent q){
    int newdimX = Integer.parseInt(dimX.getText());
    int newdimY = Integer.parseInt(dimY.getText());
    frame.dispose();
  settingsFrame.dispose();
  JOptionPane.showMessageDialog(null, "done","completed",JOptionPane.INFORMATION_MESSAGE);
  /*
     Now rerun with the configured settings
   */
  calculatorv110 device = new calculatorv110(buttonColorSample.getBackground(),
          operationColorSample.getBackground(),SColorSample.getBackground(), newdimX, newdimY);
}});

        JButton defaultSetting = new JButton("restore deafault");
            defaultSetting .addActionListener(
                new ActionListener(){
@Override
public void actionPerformed(ActionEvent q){
        frame.dispose();
        settingsFrame.dispose();
  /*
    run with the default settings
  */
    calculatorv110 v110 = new calculatorv110(Color.BLUE, Color.RED, Color.GREEN, 320, 550);
}});
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());
            buttonPanel.add(finishButton);
            buttonPanel.add(defaultSetting);
        panel2.add(buttonPanel);
        
        
    settingsFrame.add(panel1);
    settingsFrame.add(panel2);
    
        settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingsFrame.setSize(300, 300);
        settingsFrame.setLocation(488, 250);
        settingsFrame.setVisible(true);
        settingsFrame.setResizable(false);
}
  /*
     This class handles ActionListener
   */
public class eventHandler implements ActionListener{
 @Override
 public void actionPerformed(ActionEvent e){
     
      if(e.getSource()==settings)
                 settingsMethod();
            
     else if(e.getSource() == Switch){
          frame.dispose();
      calculatorv100 v100 = new calculatorv100(Color.BLUE, Color.RED, 300, 400);
      }
      else if(e.getSource() == about)
         JOptionPane.showMessageDialog(frame, "Device information\nDeveloper:"
              + " Adedayo Matt\nversion 1.1.0", "about", JOptionPane.INFORMATION_MESSAGE);
             else if(e.getSource()==Exit)  
                 System.exit(0);
             else if(e.getSource()==contact)
              JOptionPane.showMessageDialog(frame, "Incase any problem or enquiry, please contact the "
                      + "\nowner through the following channels\n"
                      + "\nphone: +2348139004572"
                      + "\nemail: adedayomatt@gmail.com"
                      + "\nfacebook: www.facebook.com/kayode.adedayo1", "contacts", JOptionPane.INFORMATION_MESSAGE);
 }
      }
}