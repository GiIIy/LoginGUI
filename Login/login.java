import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;


public class login {

    private JFrame frame;
    private JPanel panel;
    private JTextField usertf;
    private JPasswordField passtf;
    private JLabel username;
    private JLabel password;
    private JButton login;
    private JButton register;
    

    public login(){

        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        
        panel = new JPanel();

        frame.add(panel);
        
        panel.setLayout(null);

        username = new JLabel("Username");
        username.setBounds(10, 20, 80, 25);
        
        usertf = new JTextField(10);
        usertf.setBounds(100, 20, 165, 25);


        password = new JLabel("Password");
        password.setBounds(10, 50, 80, 25);

        passtf = new JPasswordField(10);
        passtf.setBounds(100, 50, 165, 25);
        
        login = new JButton("Login");
        login.setBounds(20, 80, 80, 25);
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String user = usertf.getText();
                String pass = passtf.getText();

                usertf.setText("");
                passtf.setText("");

                
                
                try {
                    File myObj = new File("loginInfo.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                      String data = myReader.nextLine();
                        if (data.equals(user + "," + pass)){
                            JOptionPane.showMessageDialog(null, "Login Successful: Welcome " + user);
                            break;
                        }
                        else if(data.equals(user + "," + pass) == false && myReader.hasNextLine() == true){
                            continue;
                        }else{
                            JOptionPane.showMessageDialog(null, "Login Failed: Incorrect Username or Password");
                        }
                    }
                    myReader.close();
                  } catch (FileNotFoundException f) {
                    System.out.println("An error occurred.");
                    f.printStackTrace();}
            }
        });
        
        register = new JButton("Register");
        register.setBounds(110, 80, 100, 25);
        register.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String user = usertf.getText();
                String pass = passtf.getText();

                usertf.setText("");
                passtf.setText(""); 
                
                
                try {
                    File myObj = new File("loginInfo.txt");
                    Scanner myReader = new Scanner(myObj);

                    while (myReader.hasNextLine()) {
                      String data = myReader.nextLine();
                      String userTest = data.split(",")[0];


                      if (user.equals(userTest)){
                          JOptionPane.showMessageDialog(null, "Username already exists");
                          break;
                          
                      }else if(user.equals(userTest) == false && myReader.hasNextLine() == true){
                          continue;
                        }else{
                            if(user.equals("") || pass.equals("")){
                                JOptionPane.showMessageDialog(null, "Username or Password cannot be empty");
                                break;

                            }else{
                            try{
                                FileWriter myWriter = new FileWriter("loginInfo.txt", true);
                                myWriter.write(user + "," + pass + "\n");
                                myWriter.close();
                                JOptionPane.showMessageDialog(null, "Registration Successful");
                                break;}
                            catch (IOException f) {
                        }}
                      
                    }}}catch (FileNotFoundException f) {
                        System.out.println("An error occurred.");
                        f.printStackTrace();
                      }
                    
    }
    
                     
});

        panel.add(username);
        panel.add(usertf);
        panel.add(password);
        panel.add(passtf);
        panel.add(login);
        panel.add(register);
        
        frame.setVisible(true);

    }
         
    public static void main(String[] args) {
        
        new login();

    }}






