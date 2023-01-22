

import java.awt.CardLayout;
import java.awt.Color;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ADMIN
 */

public class Home extends javax.swing.JFrame {
    private static String[] rName = new String[100];
    private static int[] rExist = new int[100];
    private static int[] rType = new int[100];
    private static String[] oName = new String[100];
    private static int[] oExist = new int[100];
    private static int[] oState = new int[100];
    private static int[] oType = new int[100];
    private static final int n=10;
    private static final int m=20;
    private static int x=0;
    private static String namereceived;
    private static String roomName;
    private static int roomType;
    private static String outletName;
    private static int outletType;
    private static JButton[] room = new JButton[10];
    private static JButton[] appliance = new JButton[10];
    private static int loadroom;
    private static int rCount;
    private static int[] oCount = new int[10];
    private static String user = " ";
    Date date = Calendar.getInstance().getTime();  
                DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");  
                String strDate = dateFormat.format(date);      
    
    public Home() {
        initComponents();
        cardLayout = (CardLayout) mainPanel.getLayout();
        if(user.equalsIgnoreCase(" "))
        {
            cardLayout.show(mainPanel,"userReg");
            hiUser.setText("Hi,"+user);
        }
        else{
            
            hiUser.setText("Hi,"+user);
        }
        room[0] = room1;
        room[1] = room2;
        room[2] = room3;
        room[3] = room4;
        room[4] = room5;
        room[5] = room6;
        room[6] = room7;
        room[7] = room8;
        room[8] = room9;
        room[9] = room10;
        for(int i=0;i<n;i++)
        {
            room[i].setVisible(false);
        }
        for(int i=0;i<rCount;i++)
        {
            room[i].setVisible(true);
            room[i].setText(rName[i]);
        }
        for(int i=0;i<n;i++)//set color based on room type
        {
            if(rType[i]==0)//bedroom
            {
                //room[i].setForeground(Color.blue);
                room[i].setIcon(new javax.swing.ImageIcon("Img//bed.png"));
            }
            else if(rType[i]==1)//bathroom
            {
                //room[i].setForeground(Color.white);
                room[i].setIcon(new javax.swing.ImageIcon("Img//bath.png"));
            }
            else if(rType[i]==2)//kitchen
            {
                //room[i].setForeground(Color.yellow);
                room[i].setIcon(new javax.swing.ImageIcon("Img//kitchen.png"));
            }
            else if(rType[i]==3)//living room
            {
                //room[i].setForeground(Color.red);
                room[i].setIcon(new javax.swing.ImageIcon("Img//living.png"));
            }
            else if(rType[i]==4)//other
            {
                //room[i].setForeground(Color.black);
                room[i].setIcon(new javax.swing.ImageIcon("Img//other.png"));
            }
        }
        appliance[0] = appliance1;
        appliance[1] = appliance2;
        appliance[2] = appliance3;
        appliance[3] = appliance4;
        appliance[4] = appliance5;
        appliance[5] = appliance6;
        appliance[6] = appliance7;
        appliance[7] = appliance8;
        appliance[8] = appliance9;
        appliance[9] = appliance10;
        addRoom.setIcon(new javax.swing.ImageIcon("Img//add.png"));
        addRoom1.setIcon(new javax.swing.ImageIcon("Img//add.png"));
        Return.setIcon(new javax.swing.ImageIcon("Img//back.png"));
        Return1.setIcon(new javax.swing.ImageIcon("Img//back.png"));
        Return2.setIcon(new javax.swing.ImageIcon("Img//back.png"));
        Date.setText(strDate);
    }
    
    public static void getData()//load data from file
    {
        try
            {
                FileReader read1 = new FileReader("room.txt");
                BufferedReader in1 = new BufferedReader(read1);
                FileReader read2 = new FileReader("outlet.txt");
                BufferedReader in2 = new BufferedReader(read2);
                FileReader read3 = new FileReader("user.txt");
                BufferedReader in3 = new BufferedReader(read3);
                
                for(int i= 0; i<n; i++)
                    {   
                        String inData1 = in1.readLine();
                        StringTokenizer st1 = new StringTokenizer(inData1, ",");
                        rName[i] = st1.nextToken();
                        String temp1 = st1.nextToken();
                        rExist[i] = Integer.parseInt(temp1);
                        if(rExist[i]==1)
                        {
                            rCount+=1;
                        }
                        String temp2 = st1.nextToken();
                        rType[i] = Integer.parseInt(temp2);
                    }
                for(int j=0; j<m; j++)
                    {
                        String inData2 = in2.readLine();
                        StringTokenizer st2 = new StringTokenizer(inData2, ",");
                        oName[j] = st2.nextToken();
                        String temp1 = st2.nextToken();
                        oExist[j] = Integer.parseInt(temp1);
                        String temp2 = st2.nextToken();
                        oState[j] = Integer.parseInt(temp2);
                        String temp3 = st2.nextToken();
                        oType[j] = Integer.parseInt(temp3);
                        if(oExist[j]==1)
                        {if(j>=0 && j<10)
                        {
                            oCount[0]++;
                        }
                        else if(j>=10 && j<20)
                        {
                            oCount[1]++;
                        }
                        }
                    }
                String inData3 = in3.readLine();
                        StringTokenizer st3 = new StringTokenizer(inData3, ",");
                        user = st3.nextToken();
                in1.close();
                in2.close();
                in3.close();
            }
        catch(FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            }
 
        catch(EOFException eof) {
            System.out.println(eof.getMessage());
            }

         catch(IOException io) {
            System.out.println(io.getMessage());
            }  
    }
    
    public static void showData()//for testing only
    {
        for(int i= 0; i<n; i++)
        {
            System.out.println("\nRoom: "+rName[i] + rExist[i]+rType[i]);
        }
        for(int j=0; j<n; j++)
            {
                System.out.println("\nOutlet: "+oName[j] + oExist[j] + oState[j]+oType[j]);
            }
        System.out.println(namereceived);
        
    }
    
    public static void loadAppliance()
    {
        for(int i=x;i<x+n;i++)
        {
            if(oExist[i]==1)
            {
                appliance[i-x].setVisible(true);
                appliance[i-x].setText(oName[i]);
            }
            else appliance[i-x].setVisible(false);
        }
        for(int i=x;i<x+n;i++)
        {
            if(oType[i]==0)//fan
            {
                appliance[i-x].setForeground(Color.blue);
                if(oState[i]==1)
            {
                appliance[i-x].setBackground(new Color(0,0,0));
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//fan.png"));
            }
            else
            {
                appliance[i-x].setBackground(new Color(255,255,255));
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//fanoff.png"));
                
            }
            }
            else if(oType[i]==1)//lamp
            {
                appliance[i-x].setForeground(Color.blue);
                if(oState[i]==1)
            {
                appliance[i-x].setBackground(new Color(0,0,0));
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//lamp.png"));
            }
            else
            {
                appliance[i-x].setBackground(new Color(255,255,255));
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//lampoff.png"));
                
            }
            }
            else if(oType[i]==2)//ac
            {
                appliance[i-x].setForeground(Color.black);
                if(oState[i]==1)
            {
                appliance[i-x].setBackground(new Color(0,0,0));
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//ac.png"));
            }
            else
            {
                appliance[i-x].setBackground(new Color(255,255,255));
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//acoff.png"));
                
            }
            }
            else if(oType[i]==3)//other
            {
                appliance[i-x].setForeground(Color.pink);
                if(oState[i]==1)
            {
                appliance[i-x].setBackground(new Color(0,0,0));
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//other.png"));
            }
            else
            {
                appliance[i-x].setBackground(new Color(255,255,255));
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//otheroff.png"));
                
            }
            }
        }
    }
    
    public static void switchState(int i)
    {
        i+=x;
        
        if(oState[i]==1)//turn off
        {
            oState[i]=0;
            appliance[i-x].setBackground(new Color(255,255,255));

            if(oType[i]==0)//fan
            {
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//fanoff.png"));
                
            }
            else if(oType[i]==1)//lamp
            {
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//lampoff.png"));
                
            }
            else if(oType[i]==2)//ac
            {
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//acoff.png"));
                
            }
            else if(oType[i]==3)//other
            {
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//otheroff.png"));
            }
        }
        else if(oState[i]==0)//turn on
        {
            oState[i]=1;
            appliance[i-x].setBackground(new Color(0,0,0));

            if(oType[i]==0)//fan
            {
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//fan.png"));
                
            }
            else if(oType[i]==1)//lamp
            {
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//lamp.png"));
                
            }
            else if(oType[i]==2)//ac
            {
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//ac.png"));
                
            }
            else if(oType[i]==3)//other
            {
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//other.png"));
            }
        }
    }
    
    public static void updateUser()
    {   
        try
            {
            FileWriter writer = new FileWriter("user.txt");
            PrintWriter out = new PrintWriter( writer);
            out.println(user);
            out.close();
        }
         catch(FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            }
 
        catch(EOFException eof) {
            System.out.println(eof.getMessage());
            }

         catch(IOException io) {
            System.out.println(io.getMessage());
            }
    }
    
    public static void updateRoom()
    {   
        for(int i=0;i<rCount;i++)
        {
            rExist[i]=1;
        }
        try
            {
            FileWriter writer = new FileWriter("room.txt");
            PrintWriter out = new PrintWriter( writer);
            for(int j=0; j<n; j++)
            {
                out.println(rName[j] +","+ rExist[j] +","+ rType[j]);
            }
            out.close();
        }
         catch(FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            }
 
        catch(EOFException eof) {
            System.out.println(eof.getMessage());
            }

         catch(IOException io) {
            System.out.println(io.getMessage());
            }
    }
    public static void updateAppliance()
    {   
        try
            {
            FileWriter writer = new FileWriter("outlet.txt");
            PrintWriter out = new PrintWriter( writer);
            for(int j=0; j<m; j++)
            {
                out.println(oName[j] +","+ oExist[j] +","+ oState[j] +","+ oType[j]);
            }
            out.close();
        }
         catch(FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            }
 
        catch(EOFException eof) {
            System.out.println(eof.getMessage());
            }

         catch(IOException io) {
            System.out.println(io.getMessage());
            }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        HomeScreen = new javax.swing.JPanel();
        homeTop = new javax.swing.JPanel();
        addRoom = new javax.swing.JButton();
        hiUser = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        scrollRoom = new javax.swing.JScrollPane();
        roomList = new javax.swing.JPanel();
        room1 = new javax.swing.JButton();
        room2 = new javax.swing.JButton();
        room3 = new javax.swing.JButton();
        room4 = new javax.swing.JButton();
        room5 = new javax.swing.JButton();
        room6 = new javax.swing.JButton();
        room7 = new javax.swing.JButton();
        room8 = new javax.swing.JButton();
        room9 = new javax.swing.JButton();
        room10 = new javax.swing.JButton();
        Room = new javax.swing.JPanel();
        roomTop = new javax.swing.JPanel();
        dispRoomName = new javax.swing.JLabel();
        addRoom1 = new javax.swing.JButton();
        Return = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        scrollRoom1 = new javax.swing.JScrollPane();
        roomList2 = new javax.swing.JPanel();
        appliance1 = new javax.swing.JButton();
        appliance2 = new javax.swing.JButton();
        appliance3 = new javax.swing.JButton();
        appliance4 = new javax.swing.JButton();
        appliance5 = new javax.swing.JButton();
        appliance6 = new javax.swing.JButton();
        appliance7 = new javax.swing.JButton();
        appliance8 = new javax.swing.JButton();
        appliance9 = new javax.swing.JButton();
        appliance10 = new javax.swing.JButton();
        roomReg = new javax.swing.JPanel();
        roomRegTop = new javax.swing.JPanel();
        Return1 = new javax.swing.JButton();
        dispRoomName1 = new javax.swing.JLabel();
        receiveRoom = new javax.swing.JTextField();
        confirmAdd = new javax.swing.JButton();
        cancelAdd = new javax.swing.JButton();
        bed = new javax.swing.JRadioButton();
        bath = new javax.swing.JRadioButton();
        otherroom = new javax.swing.JRadioButton();
        living = new javax.swing.JRadioButton();
        kitchen = new javax.swing.JRadioButton();
        applianceReg = new javax.swing.JPanel();
        applianceTop = new javax.swing.JPanel();
        Return2 = new javax.swing.JButton();
        dispRoomName3 = new javax.swing.JLabel();
        receiveoutlet = new javax.swing.JTextField();
        confirmAdd1 = new javax.swing.JButton();
        cancelAdd1 = new javax.swing.JButton();
        fan = new javax.swing.JRadioButton();
        lamp = new javax.swing.JRadioButton();
        otherappliance = new javax.swing.JRadioButton();
        ac = new javax.swing.JRadioButton();
        userReg = new javax.swing.JPanel();
        roomRegTop1 = new javax.swing.JPanel();
        Return3 = new javax.swing.JButton();
        dispRoomName2 = new javax.swing.JLabel();
        dispRoomName4 = new javax.swing.JLabel();
        dispRoomName5 = new javax.swing.JLabel();
        dispRoomName6 = new javax.swing.JLabel();
        getname = new javax.swing.JTextField();
        confirmAdd2 = new javax.swing.JButton();
        cancelAdd2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 1000));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(337, 600));
        mainPanel.setLayout(new java.awt.CardLayout());

        HomeScreen.setBackground(new java.awt.Color(255, 255, 255));
        HomeScreen.setPreferredSize(new java.awt.Dimension(337, 600));

        homeTop.setBackground(new java.awt.Color(255, 255, 255));

        addRoom.setBackground(new java.awt.Color(255, 255, 255));
        addRoom.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        addRoom.setToolTipText("");
        addRoom.setAlignmentX(0.5F);
        addRoom.setBorder(null);
        addRoom.setBorderPainted(false);
        addRoom.setContentAreaFilled(false);
        addRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addRoom.setMaximumSize(new java.awt.Dimension(70, 70));
        addRoom.setPreferredSize(new java.awt.Dimension(70, 70));
        addRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomActionPerformed(evt);
            }
        });

        hiUser.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        hiUser.setForeground(new java.awt.Color(0, 0, 0));
        hiUser.setText("Hi, [User]");

        Date.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Date.setForeground(new java.awt.Color(0, 0, 0));
        Date.setText(Integer.toString(rCount)
        );

        javax.swing.GroupLayout homeTopLayout = new javax.swing.GroupLayout(homeTop);
        homeTop.setLayout(homeTopLayout);
        homeTopLayout.setHorizontalGroup(
            homeTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeTopLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(homeTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hiUser)
                    .addComponent(Date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        homeTopLayout.setVerticalGroup(
            homeTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeTopLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(homeTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(homeTopLayout.createSequentialGroup()
                        .addComponent(hiUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Date)))
                .addGap(17, 17, 17))
        );

        scrollRoom.setBorder(null);
        scrollRoom.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollRoom.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollRoom.setPreferredSize(new java.awt.Dimension(337, 482));
        scrollRoom.setWheelScrollingEnabled(false);

        roomList.setBackground(new java.awt.Color(255, 255, 255));
        roomList.setPreferredSize(new java.awt.Dimension(337, 482));

        room1.setBackground(new java.awt.Color(0, 0, 0));
        room1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        room1.setForeground(new java.awt.Color(255, 255, 255));
        room1.setText("room1");
        room1.setBorder(null);
        room1.setBorderPainted(false);
        room1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        room1.setIconTextGap(0);
        room1.setMaximumSize(new java.awt.Dimension(125, 80));
        room1.setMinimumSize(new java.awt.Dimension(125, 80));
        room1.setPreferredSize(new java.awt.Dimension(125, 80));
        room1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        room1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        room1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room1ActionPerformed(evt);
            }
        });

        room2.setBackground(new java.awt.Color(0, 0, 0));
        room2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        room2.setForeground(new java.awt.Color(255, 255, 255));
        room2.setText("room2");
        room2.setBorder(null);
        room2.setBorderPainted(false);
        room2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        room2.setIconTextGap(0);
        room2.setMaximumSize(new java.awt.Dimension(125, 80));
        room2.setMinimumSize(new java.awt.Dimension(125, 80));
        room2.setPreferredSize(new java.awt.Dimension(125, 80));
        room2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        room2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        room2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room2ActionPerformed(evt);
            }
        });

        room3.setBackground(new java.awt.Color(0, 0, 0));
        room3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        room3.setForeground(new java.awt.Color(255, 255, 255));
        room3.setText("room3");
        room3.setBorder(null);
        room3.setBorderPainted(false);
        room3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        room3.setIconTextGap(0);
        room3.setMaximumSize(new java.awt.Dimension(125, 80));
        room3.setMinimumSize(new java.awt.Dimension(125, 80));
        room3.setPreferredSize(new java.awt.Dimension(125, 80));
        room3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        room3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        room3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room3ActionPerformed(evt);
            }
        });

        room4.setBackground(new java.awt.Color(0, 0, 0));
        room4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        room4.setForeground(new java.awt.Color(255, 255, 255));
        room4.setText("room4");
        room4.setBorder(null);
        room4.setBorderPainted(false);
        room4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        room4.setIconTextGap(0);
        room4.setMaximumSize(new java.awt.Dimension(125, 80));
        room4.setMinimumSize(new java.awt.Dimension(125, 80));
        room4.setPreferredSize(new java.awt.Dimension(125, 80));
        room4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        room4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        room4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room4ActionPerformed(evt);
            }
        });

        room5.setBackground(new java.awt.Color(0, 0, 0));
        room5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        room5.setForeground(new java.awt.Color(255, 255, 255));
        room5.setText("room5");
        room5.setBorder(null);
        room5.setBorderPainted(false);
        room5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        room5.setIconTextGap(0);
        room5.setMaximumSize(new java.awt.Dimension(125, 80));
        room5.setMinimumSize(new java.awt.Dimension(125, 80));
        room5.setPreferredSize(new java.awt.Dimension(125, 80));
        room5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        room5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        room5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room5ActionPerformed(evt);
            }
        });

        room6.setBackground(new java.awt.Color(0, 0, 0));
        room6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        room6.setForeground(new java.awt.Color(255, 255, 255));
        room6.setText("room6");
        room6.setBorder(null);
        room6.setBorderPainted(false);
        room6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        room6.setIconTextGap(0);
        room6.setMaximumSize(new java.awt.Dimension(125, 80));
        room6.setMinimumSize(new java.awt.Dimension(125, 80));
        room6.setPreferredSize(new java.awt.Dimension(125, 80));
        room6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        room6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        room6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room6ActionPerformed(evt);
            }
        });

        room7.setBackground(new java.awt.Color(0, 0, 0));
        room7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        room7.setForeground(new java.awt.Color(255, 255, 255));
        room7.setText("room7");
        room7.setBorder(null);
        room7.setBorderPainted(false);
        room7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        room7.setIconTextGap(0);
        room7.setMaximumSize(new java.awt.Dimension(125, 80));
        room7.setMinimumSize(new java.awt.Dimension(125, 80));
        room7.setPreferredSize(new java.awt.Dimension(125, 80));
        room7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        room7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        room7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room7ActionPerformed(evt);
            }
        });

        room8.setBackground(new java.awt.Color(0, 0, 0));
        room8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        room8.setForeground(new java.awt.Color(255, 255, 255));
        room8.setText("room8");
        room8.setBorder(null);
        room8.setBorderPainted(false);
        room8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        room8.setIconTextGap(0);
        room8.setMaximumSize(new java.awt.Dimension(125, 80));
        room8.setMinimumSize(new java.awt.Dimension(125, 80));
        room8.setPreferredSize(new java.awt.Dimension(125, 80));
        room8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        room8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        room8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room8ActionPerformed(evt);
            }
        });

        room9.setBackground(new java.awt.Color(0, 0, 0));
        room9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        room9.setForeground(new java.awt.Color(255, 255, 255));
        room9.setText("room9");
        room9.setBorder(null);
        room9.setBorderPainted(false);
        room9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        room9.setIconTextGap(0);
        room9.setMaximumSize(new java.awt.Dimension(125, 80));
        room9.setMinimumSize(new java.awt.Dimension(125, 80));
        room9.setPreferredSize(new java.awt.Dimension(125, 80));
        room9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        room9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        room9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room9ActionPerformed(evt);
            }
        });

        room10.setBackground(new java.awt.Color(0, 0, 0));
        room10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        room10.setForeground(new java.awt.Color(255, 255, 255));
        room10.setText("room10");
        room10.setBorder(null);
        room10.setBorderPainted(false);
        room10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        room10.setIconTextGap(0);
        room10.setMaximumSize(new java.awt.Dimension(125, 80));
        room10.setMinimumSize(new java.awt.Dimension(125, 80));
        room10.setPreferredSize(new java.awt.Dimension(125, 80));
        room10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        room10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        room10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roomListLayout = new javax.swing.GroupLayout(roomList);
        roomList.setLayout(roomListLayout);
        roomListLayout.setHorizontalGroup(
            roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomListLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(room5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(room7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(room1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(room3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(room8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(room2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(room6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(room10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(room4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111))
        );
        roomListLayout.setVerticalGroup(
            roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomListLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(room2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(room5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(room8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        scrollRoom.setViewportView(roomList);
        roomList.getAccessibleContext().setAccessibleName("roomList");

        javax.swing.GroupLayout HomeScreenLayout = new javax.swing.GroupLayout(HomeScreen);
        HomeScreen.setLayout(HomeScreenLayout);
        HomeScreenLayout.setHorizontalGroup(
            HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeScreenLayout.createSequentialGroup()
                        .addComponent(scrollRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(HomeScreenLayout.createSequentialGroup()
                        .addComponent(homeTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        HomeScreenLayout.setVerticalGroup(
            HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))
        );

        scrollRoom.getAccessibleContext().setAccessibleName("scrollRoom");

        mainPanel.add(HomeScreen, "homescreen");
        HomeScreen.getAccessibleContext().setAccessibleName("homescreen");

        Room.setBackground(new java.awt.Color(255, 255, 255));
        Room.setPreferredSize(new java.awt.Dimension(337, 600));

        roomTop.setBackground(new java.awt.Color(255, 255, 255));

        dispRoomName.setBackground(new java.awt.Color(153, 255, 51));
        dispRoomName.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        dispRoomName.setForeground(new java.awt.Color(0, 0, 0));
        dispRoomName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dispRoomName.setText("[roomname]");
        dispRoomName.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        addRoom1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        addRoom1.setAlignmentX(0.5F);
        addRoom1.setBorder(null);
        addRoom1.setContentAreaFilled(false);
        addRoom1.setMaximumSize(new java.awt.Dimension(70, 70));
        addRoom1.setPreferredSize(new java.awt.Dimension(70, 70));
        addRoom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoom1ActionPerformed(evt);
            }
        });

        Return.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        Return.setAlignmentX(0.5F);
        Return.setBorderPainted(false);
        Return.setContentAreaFilled(false);
        Return.setMaximumSize(new java.awt.Dimension(70, 70));
        Return.setPreferredSize(new java.awt.Dimension(70, 70));
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel1");

        javax.swing.GroupLayout roomTopLayout = new javax.swing.GroupLayout(roomTop);
        roomTop.setLayout(roomTopLayout);
        roomTopLayout.setHorizontalGroup(
            roomTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomTopLayout.createSequentialGroup()
                .addGroup(roomTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomTopLayout.createSequentialGroup()
                        .addComponent(Return, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2))
                    .addGroup(roomTopLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(dispRoomName)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addRoom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        roomTopLayout.setVerticalGroup(
            roomTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomTopLayout.createSequentialGroup()
                .addGroup(roomTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomTopLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(roomTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Return, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dispRoomName))
                    .addGroup(roomTopLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(addRoom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        scrollRoom1.setBackground(new java.awt.Color(255, 255, 255));
        scrollRoom1.setBorder(null);
        scrollRoom1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollRoom1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollRoom1.setPreferredSize(new java.awt.Dimension(337, 482));

        roomList2.setBackground(new java.awt.Color(255, 255, 255));
        roomList2.setPreferredSize(new java.awt.Dimension(300, 500));

        appliance1.setBackground(new java.awt.Color(0, 0, 0));
        appliance1.setForeground(new java.awt.Color(255, 255, 255));
        appliance1.setText("lamp1");
        appliance1.setFocusPainted(false);
        appliance1.setFocusable(false);
        appliance1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appliance1.setIconTextGap(0);
        appliance1.setMaximumSize(new java.awt.Dimension(125, 80));
        appliance1.setMinimumSize(new java.awt.Dimension(125, 80));
        appliance1.setPreferredSize(new java.awt.Dimension(125, 80));
        appliance1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        appliance1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        appliance1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance1ActionPerformed(evt);
            }
        });

        appliance2.setBackground(new java.awt.Color(0, 0, 0));
        appliance2.setForeground(new java.awt.Color(255, 255, 255));
        appliance2.setText("lamp2");
        appliance2.setFocusPainted(false);
        appliance2.setFocusable(false);
        appliance2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appliance2.setIconTextGap(0);
        appliance2.setMaximumSize(new java.awt.Dimension(125, 80));
        appliance2.setMinimumSize(new java.awt.Dimension(125, 80));
        appliance2.setPreferredSize(new java.awt.Dimension(125, 80));
        appliance2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        appliance2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        appliance2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance2ActionPerformed(evt);
            }
        });

        appliance3.setBackground(new java.awt.Color(0, 0, 0));
        appliance3.setForeground(new java.awt.Color(255, 255, 255));
        appliance3.setText("lamp3");
        appliance3.setFocusPainted(false);
        appliance3.setFocusable(false);
        appliance3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appliance3.setIconTextGap(0);
        appliance3.setMaximumSize(new java.awt.Dimension(125, 80));
        appliance3.setMinimumSize(new java.awt.Dimension(125, 80));
        appliance3.setPreferredSize(new java.awt.Dimension(125, 80));
        appliance3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        appliance3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        appliance3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance3ActionPerformed(evt);
            }
        });

        appliance4.setBackground(new java.awt.Color(0, 0, 0));
        appliance4.setForeground(new java.awt.Color(255, 255, 255));
        appliance4.setText("lamp4");
        appliance4.setFocusPainted(false);
        appliance4.setFocusable(false);
        appliance4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appliance4.setIconTextGap(0);
        appliance4.setMaximumSize(new java.awt.Dimension(125, 80));
        appliance4.setMinimumSize(new java.awt.Dimension(125, 80));
        appliance4.setPreferredSize(new java.awt.Dimension(125, 80));
        appliance4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        appliance4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        appliance4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance4ActionPerformed(evt);
            }
        });

        appliance5.setBackground(new java.awt.Color(0, 0, 0));
        appliance5.setForeground(new java.awt.Color(255, 255, 255));
        appliance5.setText("lamp5");
        appliance5.setFocusPainted(false);
        appliance5.setFocusable(false);
        appliance5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appliance5.setIconTextGap(0);
        appliance5.setMaximumSize(new java.awt.Dimension(125, 80));
        appliance5.setMinimumSize(new java.awt.Dimension(125, 80));
        appliance5.setPreferredSize(new java.awt.Dimension(125, 80));
        appliance5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        appliance5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        appliance5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance5ActionPerformed(evt);
            }
        });

        appliance6.setBackground(new java.awt.Color(0, 0, 0));
        appliance6.setForeground(new java.awt.Color(255, 255, 255));
        appliance6.setText("lamp6");
        appliance6.setFocusPainted(false);
        appliance6.setFocusable(false);
        appliance6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appliance6.setIconTextGap(0);
        appliance6.setMaximumSize(new java.awt.Dimension(125, 80));
        appliance6.setMinimumSize(new java.awt.Dimension(125, 80));
        appliance6.setPreferredSize(new java.awt.Dimension(125, 80));
        appliance6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        appliance6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        appliance6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance6ActionPerformed(evt);
            }
        });

        appliance7.setBackground(new java.awt.Color(0, 0, 0));
        appliance7.setForeground(new java.awt.Color(255, 255, 255));
        appliance7.setText("lamp7");
        appliance7.setFocusPainted(false);
        appliance7.setFocusable(false);
        appliance7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appliance7.setIconTextGap(0);
        appliance7.setMaximumSize(new java.awt.Dimension(125, 80));
        appliance7.setMinimumSize(new java.awt.Dimension(125, 80));
        appliance7.setPreferredSize(new java.awt.Dimension(125, 80));
        appliance7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        appliance7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        appliance7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance7ActionPerformed(evt);
            }
        });

        appliance8.setBackground(new java.awt.Color(0, 0, 0));
        appliance8.setForeground(new java.awt.Color(255, 255, 255));
        appliance8.setText("lamp8");
        appliance8.setFocusPainted(false);
        appliance8.setFocusable(false);
        appliance8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appliance8.setIconTextGap(0);
        appliance8.setMaximumSize(new java.awt.Dimension(125, 80));
        appliance8.setMinimumSize(new java.awt.Dimension(125, 80));
        appliance8.setPreferredSize(new java.awt.Dimension(125, 80));
        appliance8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        appliance8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        appliance8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance8ActionPerformed(evt);
            }
        });

        appliance9.setBackground(new java.awt.Color(0, 0, 0));
        appliance9.setForeground(new java.awt.Color(255, 255, 255));
        appliance9.setText("lamp9");
        appliance9.setFocusPainted(false);
        appliance9.setFocusable(false);
        appliance9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appliance9.setIconTextGap(0);
        appliance9.setMaximumSize(new java.awt.Dimension(125, 80));
        appliance9.setMinimumSize(new java.awt.Dimension(125, 80));
        appliance9.setPreferredSize(new java.awt.Dimension(125, 80));
        appliance9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        appliance9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        appliance9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance9ActionPerformed(evt);
            }
        });

        appliance10.setBackground(new java.awt.Color(0, 0, 0));
        appliance10.setForeground(new java.awt.Color(255, 255, 255));
        appliance10.setText("lamp10");
        appliance10.setFocusPainted(false);
        appliance10.setFocusable(false);
        appliance10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appliance10.setIconTextGap(0);
        appliance10.setMaximumSize(new java.awt.Dimension(125, 80));
        appliance10.setMinimumSize(new java.awt.Dimension(125, 80));
        appliance10.setPreferredSize(new java.awt.Dimension(125, 80));
        appliance10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        appliance10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        appliance10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roomList2Layout = new javax.swing.GroupLayout(roomList2);
        roomList2.setLayout(roomList2Layout);
        roomList2Layout.setHorizontalGroup(
            roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomList2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(appliance9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appliance7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appliance5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appliance3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appliance1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(appliance8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appliance4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appliance2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appliance6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appliance10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        roomList2Layout.setVerticalGroup(
            roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomList2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(appliance1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appliance2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomList2Layout.createSequentialGroup()
                        .addComponent(appliance4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appliance6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appliance8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomList2Layout.createSequentialGroup()
                        .addComponent(appliance3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appliance5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appliance7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appliance9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appliance10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrollRoom1.setViewportView(roomList2);

        javax.swing.GroupLayout RoomLayout = new javax.swing.GroupLayout(Room);
        Room.setLayout(RoomLayout);
        RoomLayout.setHorizontalGroup(
            RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RoomLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(roomTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(scrollRoom1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        RoomLayout.setVerticalGroup(
            RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roomTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollRoom1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(Room, "room");
        Room.getAccessibleContext().setAccessibleName("room");

        roomReg.setBackground(new java.awt.Color(255, 255, 255));
        roomReg.setPreferredSize(new java.awt.Dimension(337, 600));

        roomRegTop.setBackground(new java.awt.Color(255, 255, 255));

        Return1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        Return1.setAlignmentX(0.5F);
        Return1.setBorderPainted(false);
        Return1.setContentAreaFilled(false);
        Return1.setMaximumSize(new java.awt.Dimension(70, 70));
        Return1.setPreferredSize(new java.awt.Dimension(70, 70));
        Return1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Return1ActionPerformed(evt);
            }
        });

        dispRoomName1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        dispRoomName1.setForeground(new java.awt.Color(0, 0, 0));
        dispRoomName1.setText("Room Name:");

        javax.swing.GroupLayout roomRegTopLayout = new javax.swing.GroupLayout(roomRegTop);
        roomRegTop.setLayout(roomRegTopLayout);
        roomRegTopLayout.setHorizontalGroup(
            roomRegTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomRegTopLayout.createSequentialGroup()
                .addGroup(roomRegTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomRegTopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Return1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomRegTopLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(dispRoomName1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roomRegTopLayout.setVerticalGroup(
            roomRegTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomRegTopLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Return1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dispRoomName1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        receiveRoom.setBackground(new java.awt.Color(204, 204, 204));
        receiveRoom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        receiveRoom.setForeground(new java.awt.Color(0, 0, 0));
        receiveRoom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        receiveRoom.setText("[ENTER ROOM NAME]");
        receiveRoom.setBorder(null);
        receiveRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiveRoomActionPerformed(evt);
            }
        });

        confirmAdd.setBackground(new java.awt.Color(0, 0, 0));
        confirmAdd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        confirmAdd.setForeground(new java.awt.Color(255, 255, 255));
        confirmAdd.setText("Confirm");
        confirmAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAddActionPerformed(evt);
            }
        });

        cancelAdd.setBackground(new java.awt.Color(0, 0, 0));
        cancelAdd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cancelAdd.setForeground(new java.awt.Color(255, 255, 255));
        cancelAdd.setText("Cancel");
        cancelAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddActionPerformed(evt);
            }
        });

        bed.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bed.setForeground(new java.awt.Color(0, 0, 0));
        bed.setText("Bedroom");
        bed.setBorder(null);
        bed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedActionPerformed(evt);
            }
        });

        bath.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bath.setForeground(new java.awt.Color(0, 0, 0));
        bath.setText("Bathroom");

        otherroom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        otherroom.setForeground(new java.awt.Color(0, 0, 0));
        otherroom.setText("Other");

        living.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        living.setForeground(new java.awt.Color(0, 0, 0));
        living.setText("Living Room");

        kitchen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        kitchen.setForeground(new java.awt.Color(0, 0, 0));
        kitchen.setText("Kitchen");

        javax.swing.GroupLayout roomRegLayout = new javax.swing.GroupLayout(roomReg);
        roomReg.setLayout(roomRegLayout);
        roomRegLayout.setHorizontalGroup(
            roomRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roomRegTop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roomRegLayout.createSequentialGroup()
                .addGroup(roomRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomRegLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(roomRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bed)
                            .addComponent(receiveRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bath)
                            .addComponent(living)
                            .addComponent(kitchen)
                            .addComponent(otherroom)))
                    .addGroup(roomRegLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(cancelAdd)
                        .addGap(48, 48, 48)
                        .addComponent(confirmAdd)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        roomRegLayout.setVerticalGroup(
            roomRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomRegLayout.createSequentialGroup()
                .addComponent(roomRegTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receiveRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kitchen)
                .addGap(3, 3, 3)
                .addComponent(living)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otherroom)
                .addGap(36, 36, 36)
                .addGroup(roomRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelAdd)
                    .addComponent(confirmAdd))
                .addGap(182, 182, 182))
        );

        mainPanel.add(roomReg, "roomReg");
        roomReg.getAccessibleContext().setAccessibleName("roomReg");

        applianceReg.setBackground(new java.awt.Color(255, 255, 255));
        applianceReg.setPreferredSize(new java.awt.Dimension(337, 600));

        applianceTop.setBackground(new java.awt.Color(255, 255, 255));

        Return2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        Return2.setAlignmentX(0.5F);
        Return2.setBorderPainted(false);
        Return2.setContentAreaFilled(false);
        Return2.setMaximumSize(new java.awt.Dimension(70, 70));
        Return2.setPreferredSize(new java.awt.Dimension(70, 70));
        Return2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Return2ActionPerformed(evt);
            }
        });

        dispRoomName3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dispRoomName3.setForeground(new java.awt.Color(0, 0, 0));
        dispRoomName3.setText("Appliance Name:");

        javax.swing.GroupLayout applianceTopLayout = new javax.swing.GroupLayout(applianceTop);
        applianceTop.setLayout(applianceTopLayout);
        applianceTopLayout.setHorizontalGroup(
            applianceTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, applianceTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Return2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(402, 402, 402))
            .addGroup(applianceTopLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(dispRoomName3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        applianceTopLayout.setVerticalGroup(
            applianceTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, applianceTopLayout.createSequentialGroup()
                .addComponent(Return2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dispRoomName3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        receiveoutlet.setBackground(new java.awt.Color(204, 204, 204));
        receiveoutlet.setForeground(new java.awt.Color(0, 0, 0));
        receiveoutlet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        receiveoutlet.setText("[ENTER APPLIANCE NAME]");
        receiveoutlet.setBorder(null);
        receiveoutlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiveoutletActionPerformed(evt);
            }
        });

        confirmAdd1.setBackground(new java.awt.Color(0, 0, 0));
        confirmAdd1.setForeground(new java.awt.Color(255, 255, 255));
        confirmAdd1.setText("Confirm");
        confirmAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAdd1ActionPerformed(evt);
            }
        });

        cancelAdd1.setBackground(new java.awt.Color(0, 0, 0));
        cancelAdd1.setForeground(new java.awt.Color(255, 255, 255));
        cancelAdd1.setText("Cancel");
        cancelAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAdd1ActionPerformed(evt);
            }
        });

        fan.setForeground(new java.awt.Color(0, 0, 0));
        fan.setText("Fan");

        lamp.setForeground(new java.awt.Color(0, 0, 0));
        lamp.setText("Lamp");
        lamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lampActionPerformed(evt);
            }
        });

        otherappliance.setForeground(new java.awt.Color(0, 0, 0));
        otherappliance.setText("Others");
        otherappliance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherapplianceActionPerformed(evt);
            }
        });

        ac.setForeground(new java.awt.Color(0, 0, 0));
        ac.setText("AC");
        ac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout applianceRegLayout = new javax.swing.GroupLayout(applianceReg);
        applianceReg.setLayout(applianceRegLayout);
        applianceRegLayout.setHorizontalGroup(
            applianceRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(applianceRegLayout.createSequentialGroup()
                .addGroup(applianceRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(applianceTop, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(applianceRegLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(applianceRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fan)
                            .addComponent(receiveoutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lamp)
                            .addComponent(otherappliance)
                            .addComponent(ac)))
                    .addGroup(applianceRegLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(cancelAdd1)
                        .addGap(47, 47, 47)
                        .addComponent(confirmAdd1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        applianceRegLayout.setVerticalGroup(
            applianceRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(applianceRegLayout.createSequentialGroup()
                .addComponent(applianceTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(receiveoutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lamp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otherappliance)
                .addGap(18, 18, 18)
                .addGroup(applianceRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelAdd1)
                    .addComponent(confirmAdd1))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        mainPanel.add(applianceReg, "applianceReg");
        applianceReg.getAccessibleContext().setAccessibleName("applianceReg");

        userReg.setBackground(new java.awt.Color(255, 255, 255));
        userReg.setPreferredSize(new java.awt.Dimension(337, 600));

        roomRegTop1.setBackground(new java.awt.Color(255, 255, 255));

        Return3.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        Return3.setAlignmentX(0.5F);
        Return3.setBorderPainted(false);
        Return3.setContentAreaFilled(false);
        Return3.setMaximumSize(new java.awt.Dimension(70, 70));
        Return3.setPreferredSize(new java.awt.Dimension(70, 70));
        Return3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Return3ActionPerformed(evt);
            }
        });

        dispRoomName2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        dispRoomName2.setForeground(new java.awt.Color(0, 0, 0));
        dispRoomName2.setText("Welcome to");

        dispRoomName4.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        dispRoomName4.setForeground(new java.awt.Color(0, 0, 0));
        dispRoomName4.setText("Enter Name:");

        dispRoomName5.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        dispRoomName5.setForeground(new java.awt.Color(0, 0, 0));
        dispRoomName5.setText("[app name]");

        dispRoomName6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        dispRoomName6.setForeground(new java.awt.Color(0, 0, 0));
        dispRoomName6.setText("Register Now");

        javax.swing.GroupLayout roomRegTop1Layout = new javax.swing.GroupLayout(roomRegTop1);
        roomRegTop1.setLayout(roomRegTop1Layout);
        roomRegTop1Layout.setHorizontalGroup(
            roomRegTop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomRegTop1Layout.createSequentialGroup()
                .addGroup(roomRegTop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomRegTop1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Return3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dispRoomName2))
                    .addGroup(roomRegTop1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(roomRegTop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dispRoomName6)
                            .addComponent(dispRoomName4)
                            .addComponent(dispRoomName5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roomRegTop1Layout.setVerticalGroup(
            roomRegTop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomRegTop1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(roomRegTop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dispRoomName2)
                    .addComponent(Return3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dispRoomName5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(dispRoomName6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dispRoomName4))
        );

        getname.setBackground(new java.awt.Color(204, 204, 204));
        getname.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getname.setForeground(new java.awt.Color(0, 0, 0));
        getname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getname.setBorder(null);
        getname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getnameActionPerformed(evt);
            }
        });

        confirmAdd2.setBackground(new java.awt.Color(0, 0, 0));
        confirmAdd2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        confirmAdd2.setForeground(new java.awt.Color(255, 255, 255));
        confirmAdd2.setText("Confirm");
        confirmAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAdd2ActionPerformed(evt);
            }
        });

        cancelAdd2.setBackground(new java.awt.Color(0, 0, 0));
        cancelAdd2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cancelAdd2.setForeground(new java.awt.Color(255, 255, 255));
        cancelAdd2.setText("Cancel");
        cancelAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAdd2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userRegLayout = new javax.swing.GroupLayout(userReg);
        userReg.setLayout(userRegLayout);
        userRegLayout.setHorizontalGroup(
            userRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roomRegTop1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(userRegLayout.createSequentialGroup()
                .addGroup(userRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userRegLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(cancelAdd2)
                        .addGap(48, 48, 48)
                        .addComponent(confirmAdd2))
                    .addGroup(userRegLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(getname, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        userRegLayout.setVerticalGroup(
            userRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userRegLayout.createSequentialGroup()
                .addComponent(roomRegTop1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(getname, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(userRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelAdd2)
                    .addComponent(confirmAdd2))
                .addGap(215, 215, 215))
        );

        mainPanel.add(userReg, "userReg");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("mainFrame");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomActionPerformed
        cardLayout.show(mainPanel,"roomReg");
        addRoom.setOpaque(false);
    }//GEN-LAST:event_addRoomActionPerformed

    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        updateAppliance();
        cardLayout.show(mainPanel,"homescreen");
    }//GEN-LAST:event_ReturnActionPerformed

    private void appliance1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliance1ActionPerformed
        int i=0;
        switchState(i); 
    }//GEN-LAST:event_appliance1ActionPerformed

    private void addRoom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoom1ActionPerformed
        cardLayout.show(mainPanel,"applianceReg");
    }//GEN-LAST:event_addRoom1ActionPerformed

    private void appliance3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliance3ActionPerformed
       int i=2;
        switchState(i); 
    }//GEN-LAST:event_appliance3ActionPerformed

    private void appliance5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliance5ActionPerformed
        int i=4;
        switchState(i); 
    }//GEN-LAST:event_appliance5ActionPerformed

    private void appliance7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliance7ActionPerformed
        int i=6;
        switchState(i); 
    }//GEN-LAST:event_appliance7ActionPerformed

    private void appliance9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliance9ActionPerformed
       int i=8;
        switchState(i); 
    }//GEN-LAST:event_appliance9ActionPerformed

    private void Return1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Return1ActionPerformed
        cardLayout.show(mainPanel,"homescreen");
    }//GEN-LAST:event_Return1ActionPerformed

    private void receiveRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiveRoomActionPerformed

    }//GEN-LAST:event_receiveRoomActionPerformed

    private void receiveoutletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiveoutletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receiveoutletActionPerformed

    private void lampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lampActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lampActionPerformed

    private void otherapplianceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherapplianceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otherapplianceActionPerformed

    private void acActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acActionPerformed

    private void confirmAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAdd1ActionPerformed
        outletName=receiveoutlet.getText();
        if(fan.isSelected())
        {
            outletType=0;
        }
        if(lamp.isSelected())
        {
            outletType=1;
        }
        if(ac.isSelected())
        {
            outletType=2;
        }
        if(otherappliance.isSelected())
        {
            outletType=3;
        }
        if(x==0)
        {
            oExist[oCount[0]]=1;
            oName[oCount[0]]=outletName;
            oType[oCount[0]]=outletType;
            oCount[0]++;
        }
        setVisible(false);
        updateAppliance();
        new Home().setVisible(true);
        cardLayout.show(mainPanel,"room");
    }//GEN-LAST:event_confirmAdd1ActionPerformed

    private void appliance2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliance2ActionPerformed
        int i=1;
        switchState(i); 
    }//GEN-LAST:event_appliance2ActionPerformed

    private void confirmAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAddActionPerformed
        roomName = receiveRoom.getText();
        if(bed.isSelected())
        {
            roomType=0;
        }
        if(bath.isSelected())
        {
            roomType=1;
        }
        if(kitchen.isSelected())
        {
            roomType=2;
        }
        if(living.isSelected())
        {
            roomType=3;
        }
        if(otherroom.isSelected())
        {
            roomType=4;
        }
        rName[rCount]=roomName;
        rType[rCount]=roomType;
        rCount+=1;
        setVisible(false);
        updateRoom();
        new Home().setVisible(true);
    }//GEN-LAST:event_confirmAddActionPerformed

    private void room9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room9ActionPerformed
        x=80;
        dispRoomName.setText(rName[8]);
        loadAppliance();
        cardLayout.show(mainPanel,"room");
        jLabel2.setText(Integer.toString(x));
    }//GEN-LAST:event_room9ActionPerformed

    private void room7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room7ActionPerformed
        x=60;
        dispRoomName.setText(rName[6]);
        loadAppliance();
        cardLayout.show(mainPanel,"room");
        jLabel2.setText(Integer.toString(x));
    }//GEN-LAST:event_room7ActionPerformed

    private void room5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room5ActionPerformed
        x=40;
        dispRoomName.setText(rName[4]);
        loadAppliance();
        cardLayout.show(mainPanel,"room");
        jLabel2.setText(Integer.toString(x));
    }//GEN-LAST:event_room5ActionPerformed

    private void room3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room3ActionPerformed
        x=20;
        dispRoomName.setText(rName[2]);
        loadAppliance();
        cardLayout.show(mainPanel,"room");
        jLabel2.setText(Integer.toString(x));
    }//GEN-LAST:event_room3ActionPerformed

    private void room2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room2ActionPerformed
        x=10;
        dispRoomName.setText(rName[1]);
        loadAppliance();
        cardLayout.show(mainPanel,"room");
        jLabel2.setText(Integer.toString(oCount[0])+", "+Integer.toString(oCount[1]));
    }//GEN-LAST:event_room2ActionPerformed

    private void room1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room1ActionPerformed
        x=0;
        dispRoomName.setText(rName[0]);
        loadAppliance();
        cardLayout.show(mainPanel,"room");
        jLabel2.setText(Integer.toString(x));
    }//GEN-LAST:event_room1ActionPerformed

    private void appliance4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliance4ActionPerformed
       int i=3;
       switchState(i); 
    }//GEN-LAST:event_appliance4ActionPerformed

    private void appliance6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliance6ActionPerformed
        int i=5;
        switchState(i); 
    }//GEN-LAST:event_appliance6ActionPerformed

    private void appliance8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliance8ActionPerformed
        int i=7;
        switchState(i); 
    }//GEN-LAST:event_appliance8ActionPerformed

    private void appliance10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliance10ActionPerformed
        int i=9;
        switchState(i); 
    }//GEN-LAST:event_appliance10ActionPerformed

    private void room4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room4ActionPerformed
        x=30;
        dispRoomName.setText(rName[3]);
        loadAppliance();
        cardLayout.show(mainPanel,"room");
        jLabel2.setText(Integer.toString(x));
    }//GEN-LAST:event_room4ActionPerformed

    private void room6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room6ActionPerformed
        x=50;
        dispRoomName.setText(rName[5]);
        loadAppliance();
        cardLayout.show(mainPanel,"room");
        jLabel2.setText(Integer.toString(x));
    }//GEN-LAST:event_room6ActionPerformed

    private void room8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room8ActionPerformed
        x=70;
        dispRoomName.setText(rName[7]);
        loadAppliance();
        cardLayout.show(mainPanel,"room");
        jLabel2.setText(Integer.toString(x));
    }//GEN-LAST:event_room8ActionPerformed

    private void room10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room10ActionPerformed
        x=90;
        dispRoomName.setText(rName[9]);
        loadAppliance();
        cardLayout.show(mainPanel,"room");
        jLabel2.setText(Integer.toString(x));
    }//GEN-LAST:event_room10ActionPerformed

    private void bedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bedActionPerformed

    private void Return2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Return2ActionPerformed
        cardLayout.show(mainPanel,"room");
    }//GEN-LAST:event_Return2ActionPerformed

    private void confirmAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAdd2ActionPerformed
        namereceived = getname.getText();
        user = namereceived;
        setVisible(false);
        updateUser();
        new Home().setVisible(true);
    }//GEN-LAST:event_confirmAdd2ActionPerformed

    private void getnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getnameActionPerformed

    private void Return3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Return3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Return3ActionPerformed

    private void cancelAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAdd2ActionPerformed
        cardLayout.show(mainPanel,"room");
    }//GEN-LAST:event_cancelAdd2ActionPerformed

    private void cancelAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAdd1ActionPerformed
        cardLayout.show(mainPanel,"room");
    }//GEN-LAST:event_cancelAdd1ActionPerformed

    private void cancelAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddActionPerformed
        cardLayout.show(mainPanel,"room");
    }//GEN-LAST:event_cancelAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                getData();
                showData();
                
                new Home().setVisible(true);
        
            }
        });
    }
    
    private final CardLayout cardLayout;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JPanel HomeScreen;
    private javax.swing.JButton Return;
    private javax.swing.JButton Return1;
    private javax.swing.JButton Return2;
    private javax.swing.JButton Return3;
    private javax.swing.JPanel Room;
    private javax.swing.JRadioButton ac;
    private javax.swing.JButton addRoom;
    private javax.swing.JButton addRoom1;
    private javax.swing.JButton appliance1;
    private javax.swing.JButton appliance10;
    private javax.swing.JButton appliance2;
    private javax.swing.JButton appliance3;
    private javax.swing.JButton appliance4;
    private javax.swing.JButton appliance5;
    private javax.swing.JButton appliance6;
    private javax.swing.JButton appliance7;
    private javax.swing.JButton appliance8;
    private javax.swing.JButton appliance9;
    private javax.swing.JPanel applianceReg;
    private javax.swing.JPanel applianceTop;
    private javax.swing.JRadioButton bath;
    private javax.swing.JRadioButton bed;
    private javax.swing.JButton cancelAdd;
    private javax.swing.JButton cancelAdd1;
    private javax.swing.JButton cancelAdd2;
    private javax.swing.JButton confirmAdd;
    private javax.swing.JButton confirmAdd1;
    private javax.swing.JButton confirmAdd2;
    private javax.swing.JLabel dispRoomName;
    private javax.swing.JLabel dispRoomName1;
    private javax.swing.JLabel dispRoomName2;
    private javax.swing.JLabel dispRoomName3;
    private javax.swing.JLabel dispRoomName4;
    private javax.swing.JLabel dispRoomName5;
    private javax.swing.JLabel dispRoomName6;
    private javax.swing.JRadioButton fan;
    private javax.swing.JTextField getname;
    private javax.swing.JLabel hiUser;
    private javax.swing.JPanel homeTop;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton kitchen;
    private javax.swing.JRadioButton lamp;
    private javax.swing.JRadioButton living;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton otherappliance;
    private javax.swing.JRadioButton otherroom;
    private javax.swing.JTextField receiveRoom;
    private javax.swing.JTextField receiveoutlet;
    private javax.swing.JButton room1;
    private javax.swing.JButton room10;
    private javax.swing.JButton room2;
    private javax.swing.JButton room3;
    private javax.swing.JButton room4;
    private javax.swing.JButton room5;
    private javax.swing.JButton room6;
    private javax.swing.JButton room7;
    private javax.swing.JButton room8;
    private javax.swing.JButton room9;
    private javax.swing.JPanel roomList;
    private javax.swing.JPanel roomList2;
    private javax.swing.JPanel roomReg;
    private javax.swing.JPanel roomRegTop;
    private javax.swing.JPanel roomRegTop1;
    private javax.swing.JPanel roomTop;
    private javax.swing.JScrollPane scrollRoom;
    private javax.swing.JScrollPane scrollRoom1;
    private javax.swing.JPanel userReg;
    // End of variables declaration//GEN-END:variables

}
