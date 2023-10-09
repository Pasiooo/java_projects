import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class Kalkulator implements ActionListener{
    
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10]; // Delkaracja 10 przycisków na liczby
    JButton[] functionButtons = new JButton[10]; // Deklaracja 8 przycisków na funkcje
    JButton addButton, subButton, mulButton, divButton, negButton;
    JButton decButton, equButton, delButton, clrButton, powButton;
    JPanel panel;

    Font myfont = new Font("Minecraft Ten", Font.PLAIN, 18);

    double num1=0, num2=0, result;
    char operator;

    Kalkulator(){

        // kalkulator 
        frame = new JFrame("Kalkulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        // wyświetlacz u góry
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myfont);
        textfield.setEditable(false);

        // Przysicki funkcyjne
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");
        negButton = new JButton("+/-");
        powButton = new JButton("pow");

        // dodanie ich do tablicy
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = powButton;

        // Danie im własności przycisków
        for (JButton el : functionButtons){
            el.addActionListener(this);
            el.setFont(myfont);
            el.setFocusable(false);
        }

        // Danie własności przyciskom liczbowym
        for (int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
        }

        // Panel przycisków
        panel = new JPanel();
        panel.setBounds(40, 100, 320, 400);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        // Zerowy rzad
        panel.add(clrButton);
        panel.add(delButton);
        panel.add(powButton);
        panel.add(addButton);

        // Pierwszy rząd
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);

        // Drugi rząd
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);

        // Trzeci rząd
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);

        // Czwarty rząd
        panel.add(negButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);
        
        
        // widocznosc
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new Kalkulator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Sprawdzanie czy został naciśnięty przycisk liczby
        for (int i = 0; i < 10; i++){
            if (e.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));;
            }
        }

        // Przecinek
        if (e.getSource() == decButton){
            String s = textfield.getText();
            if(!s.contains("."))
                textfield.setText(textfield.getText().concat("."));
        }

        // Suma
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }

        // Odejmowanie
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }

        // Mnozenie
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }

        // Dzielenie
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        // Rowna się liczące wynik
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textfield.getText());
            
            switch (operator){
                case'+':
                    result = num1+num2;
                    break;
                case'-':
                    result = num1-num2;
                    break;
                case'*':
                    result = num1*num2;
                    break;
                case'/':
                    result = num1/num2;
                    break;
            }
            int resultInt = (int)result;
            if (resultInt == result)
                textfield.setText(String.valueOf(resultInt));
            else
                textfield.setText(String.valueOf(result));
            num1=result;
        }

        // Usuwanie całości
        if(e.getSource() == clrButton){
            textfield.setText("");
        }

        // Usuwanie jednej liczby
        if(e.getSource() == delButton){
            String liczby = textfield.getText();
            String s = "";
            for (int i = 0; i < liczby.length() - 1; i++){
                s = s + liczby.charAt(i);
            }
            textfield.setText(s);
        }   
        
        // Zmiana znaku
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textfield.getText());
            int tempInt = (int)temp;
            if (tempInt == temp)
                textfield.setText(String.valueOf(tempInt * (-1)));
            else
                textfield.setText(String.valueOf(temp * (-1)));
        }  

        // Kwadrat
        if(e.getSource() == powButton){
            double temp = Double.parseDouble(textfield.getText());
            temp = Math.pow(temp, 2);
            int tempInt = (int)temp;
            if (tempInt == temp)
                textfield.setText(String.valueOf(tempInt));
            else
                textfield.setText(String.valueOf(temp));
        } 
    }
}
