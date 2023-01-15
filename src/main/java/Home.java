
import java.awt.CardLayout;
import java.awt.Color;
import java.io.*;
import java.util.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ADMIN
 */

public class Home extends javax.swing.JFrame {
    public static String[] rName = new String[100];
    public static int[] rExist = new int[100];
    public static int[] rType = new int[100];
    public static String[] oName = new String[100];
    public static int[] oExist = new int[100];
    public static int[] oState = new int[100];
    public static int[] oType = new int[100];
    public static final int n=10;
    public static final int m=20;
    public static int x=0;
    public static String textreceived;
    public static String roomName;
    public static int roomType;
    public static String outletName;
    public static int outletType;
    public static JButton[] room = new JButton[10];
    public static JButton[] appliance = new JButton[10];
    public static int loadroom;
    public static int rCount;
    public static int[] oCount = new int[10];
    public static Color bg;
    
    public Home() {
        initComponents();
        cardLayout = (CardLayout) mainPanel.getLayout();
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
                room[i].setForeground(Color.blue);
                room[i].setIcon(new javax.swing.ImageIcon("Img//off.png"));
            }
            else if(rType[i]==1)//bathroom
            {
                room[i].setForeground(Color.white);
                room[i].setIcon(new javax.swing.ImageIcon("Img//on.png"));
            }
            else if(rType[i]==2)//other
            {
                room[i].setForeground(Color.black);
                room[i].setIcon(new javax.swing.ImageIcon("Img//off.png"));
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
        
        
    }
    
    public static void getData()//load data from file
    {
        try
            {
                FileReader read1 = new FileReader("room.txt");
                BufferedReader in1 = new BufferedReader(read1);
                FileReader read2 = new FileReader("outlet.txt");
                BufferedReader in2 = new BufferedReader(read2);
                
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
                in1.close();
                in2.close();
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
    
    /*public static void getApplianceData()
    {
        try
            {   FileReader read1 = new FileReader("outlet.txt");
                BufferedReader in1 = new BufferedReader(read1);
                FileReader read2 = new FileReader("room2.txt");
                BufferedReader in2 = new BufferedReader(read2);
                
                
                for(int j=0; j<n; j++)
                    {
                        String inData1 = in1.readLine();
                        StringTokenizer st1 = new StringTokenizer(inData1, ",");
                        oName[j] = st1.nextToken();
                        String temp1 = st1.nextToken();
                        oState[j] = Integer.parseInt(temp1);
                    }
                for(int j=0; j<n; j++)
                    {
                        String inData2 = in2.readLine();
                        StringTokenizer st2 = new StringTokenizer(inData2, ",");
                        oName[j] = st2.nextToken();
                        String temp2 = st2.nextToken();
                        oState[j] = Integer.parseInt(temp2);
                    }
                in1.close();
                in2.close();
                
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
    }*/
    
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
        System.out.println(textreceived);
        
    }
    
    /*public static void loadRoom()
    {
        for(int i=0;i<n;i++)
        {
            if(rType[i]==0)
            {
                appliance[i-x].setForeground(Color.blue);
            }
            else if(rType[i]==1)
            {
                appliance[i-x].setForeground(Color.white);
            }
            else if(rType[i]==2)
            {
                appliance[i-x].setForeground(Color.black);
            }
            else if(rType[i]==3)
            {
                appliance[i-x].setForeground(Color.pink);
            }
        }
    }*/
    ///appliance[i].setIcon(new javax.swing.ImageIcon("Img//on.png"));
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
        /*for(int i=x;i<x+n;i++)
        {
            if(oState[i]==1)
            {
                appliance[i-x].setBackground(Color.green);
                appliance[i].setIcon(new javax.swing.ImageIcon("Img//on.png"));
            }
            else
            {
                appliance[i-x].setBackground(Color.red);
                appliance[i].setIcon(new javax.swing.ImageIcon("Img//off.png"));
                
            }
            }*/
        for(int i=x;i<x+n;i++)
        {
            if(oType[i]==0)//fan
            {
                appliance[i-x].setForeground(Color.blue);
                if(oState[i]==1)
            {
                appliance[i-x].setBackground(Color.green);
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//on.png"));
            }
            else
            {
                appliance[i-x].setBackground(Color.red);
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//off.png"));
                
            }
            }
            else if(oType[i]==1)//lamp
            {
                appliance[i-x].setForeground(Color.white);
                if(oState[i]==1)
            {
                appliance[i-x].setBackground(Color.green);
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//on.png"));
            }
            else
            {
                appliance[i-x].setBackground(Color.red);
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//off.png"));
                
            }
            }
            else if(oType[i]==2)//ac
            {
                appliance[i-x].setForeground(Color.black);
                if(oState[i]==1)
            {
                appliance[i-x].setBackground(Color.green);
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//on.png"));
            }
            else
            {
                appliance[i-x].setBackground(Color.red);
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//off.png"));
                
            }
            }
            else if(oType[i]==3)//other
            {
                appliance[i-x].setForeground(Color.pink);
                if(oState[i]==1)
            {
                appliance[i-x].setBackground(Color.green);
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//on.png"));
            }
            else
            {
                appliance[i-x].setBackground(Color.red);
                appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//off.png"));
                
            }
            }
        }
    }
    
    public static void switchState(int i)
    {
        i+=x;
        if(oState[i]==1)
        {
            oState[i]=0;
            appliance[i-x].setBackground(Color.red);
            appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//off.png"));
        }
        else if(oState[i]==0)
        {
            oState[i]=1;
            appliance[i-x].setBackground(Color.green);
            appliance[i-x].setIcon(new javax.swing.ImageIcon("Img//on.png"));
        }
    }
    
    /*public static int getIndex(int x)
    {
        return x;
    }*/
    /*public static void addRoom(String name,int type)
    {
        
    }*/
    
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
        jLabel1 = new javax.swing.JLabel();
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
        applianceReg = new javax.swing.JPanel();
        applianceTop = new javax.swing.JPanel();
        Return2 = new javax.swing.JButton();
        dispRoomName3 = new javax.swing.JLabel();
        receiveoutlet = new javax.swing.JTextField();
        confirmAdd1 = new javax.swing.JButton();
        cancelAdd1 = new javax.swing.JButton();
        dispRoomName2 = new javax.swing.JLabel();
        fan = new javax.swing.JRadioButton();
        lamp = new javax.swing.JRadioButton();
        otherappliance = new javax.swing.JRadioButton();
        ac = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 1000));

        mainPanel.setPreferredSize(new java.awt.Dimension(337, 600));
        mainPanel.setLayout(new java.awt.CardLayout());

        HomeScreen.setPreferredSize(new java.awt.Dimension(337, 600));

        addRoom.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        addRoom.setText("+");
        addRoom.setAlignmentX(0.5F);
        addRoom.setMaximumSize(new java.awt.Dimension(70, 70));
        addRoom.setPreferredSize(new java.awt.Dimension(70, 70));
        addRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomActionPerformed(evt);
            }
        });

        hiUser.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        hiUser.setText("Hi, [User]");

        jLabel1.setText(Integer.toString(rCount)
        );

        javax.swing.GroupLayout homeTopLayout = new javax.swing.GroupLayout(homeTop);
        homeTop.setLayout(homeTopLayout);
        homeTopLayout.setHorizontalGroup(
            homeTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeTopLayout.createSequentialGroup()
                .addGroup(homeTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeTopLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(hiUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeTopLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)))
                .addComponent(addRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        homeTopLayout.setVerticalGroup(
            homeTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(hiUser)
                .addGap(17, 17, 17))
        );

        scrollRoom.setBorder(null);
        scrollRoom.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollRoom.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollRoom.setPreferredSize(new java.awt.Dimension(337, 482));

        room1.setText("room1");
        room1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        room1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        room1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        room1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                room1StateChanged(evt);
            }
        });
        room1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room1ActionPerformed(evt);
            }
        });
        room1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                room1PropertyChange(evt);
            }
        });

        room2.setText("room2");
        room2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        room2.setIconTextGap(0);
        room2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room2ActionPerformed(evt);
            }
        });

        room3.setText("room3");
        room3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room3ActionPerformed(evt);
            }
        });

        room4.setText("room4");

        room5.setText("room5");
        room5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room5ActionPerformed(evt);
            }
        });

        room6.setText("room6");

        room7.setText("room7");
        room7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room7ActionPerformed(evt);
            }
        });

        room8.setText("room8");

        room9.setText("room9");
        room9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room9ActionPerformed(evt);
            }
        });

        room10.setText("room10");

        javax.swing.GroupLayout roomListLayout = new javax.swing.GroupLayout(roomList);
        roomList.setLayout(roomListLayout);
        roomListLayout.setHorizontalGroup(
            roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomListLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomListLayout.createSequentialGroup()
                        .addComponent(room9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(room10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomListLayout.createSequentialGroup()
                        .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(room5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(room6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roomListLayout.createSequentialGroup()
                        .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(room3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(room4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roomListLayout.setVerticalGroup(
            roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(room3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(room5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(room7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(room9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        scrollRoom.setViewportView(roomList);
        roomList.getAccessibleContext().setAccessibleName("roomList");

        javax.swing.GroupLayout HomeScreenLayout = new javax.swing.GroupLayout(HomeScreen);
        HomeScreen.setLayout(HomeScreenLayout);
        HomeScreenLayout.setHorizontalGroup(
            HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeScreenLayout.createSequentialGroup()
                .addGroup(HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeScreenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(homeTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(scrollRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        HomeScreenLayout.setVerticalGroup(
            HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        scrollRoom.getAccessibleContext().setAccessibleName("scrollRoom");

        mainPanel.add(HomeScreen, "homescreen");
        HomeScreen.getAccessibleContext().setAccessibleName("homescreen");

        Room.setPreferredSize(new java.awt.Dimension(337, 600));

        dispRoomName.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dispRoomName.setText("[Room]");

        addRoom1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        addRoom1.setText("+");
        addRoom1.setAlignmentX(0.5F);
        addRoom1.setMaximumSize(new java.awt.Dimension(70, 70));
        addRoom1.setPreferredSize(new java.awt.Dimension(70, 70));
        addRoom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoom1ActionPerformed(evt);
            }
        });

        Return.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        Return.setText("<");
        Return.setAlignmentX(0.5F);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomTopLayout.createSequentialGroup()
                        .addContainerGap(80, Short.MAX_VALUE)
                        .addComponent(dispRoomName)
                        .addGap(46, 46, 46))
                    .addGroup(roomTopLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Return, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addComponent(addRoom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roomTopLayout.setVerticalGroup(
            roomTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomTopLayout.createSequentialGroup()
                .addGroup(roomTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomTopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Return, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomTopLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(dispRoomName)
                .addContainerGap())
            .addGroup(roomTopLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(addRoom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrollRoom1.setBorder(null);
        scrollRoom1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollRoom1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollRoom1.setPreferredSize(new java.awt.Dimension(337, 482));

        roomList2.setPreferredSize(new java.awt.Dimension(300, 500));

        appliance1.setText("lamp1");
        appliance1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance1ActionPerformed(evt);
            }
        });

        appliance2.setBackground(bg);
        appliance2.setText("lamp2");
        appliance2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance2ActionPerformed(evt);
            }
        });

        appliance3.setText("lamp3");
        appliance3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance3ActionPerformed(evt);
            }
        });

        appliance4.setText("lamp4");

        appliance5.setText("lamp5");
        appliance5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance5ActionPerformed(evt);
            }
        });

        appliance6.setText("lamp6");

        appliance7.setText("lamp8");

        appliance8.setText("lamp7");
        appliance8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance8ActionPerformed(evt);
            }
        });

        appliance9.setText("lamp9");
        appliance9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appliance9ActionPerformed(evt);
            }
        });

        appliance10.setText("lamp10");

        javax.swing.GroupLayout roomList2Layout = new javax.swing.GroupLayout(roomList2);
        roomList2.setLayout(roomList2Layout);
        roomList2Layout.setHorizontalGroup(
            roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomList2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomList2Layout.createSequentialGroup()
                        .addComponent(appliance1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(appliance2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomList2Layout.createSequentialGroup()
                        .addComponent(appliance3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(appliance4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomList2Layout.createSequentialGroup()
                        .addComponent(appliance5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(appliance6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomList2Layout.createSequentialGroup()
                        .addComponent(appliance8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(appliance7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomList2Layout.createSequentialGroup()
                        .addComponent(appliance9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(appliance10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roomList2Layout.setVerticalGroup(
            roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomList2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appliance1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appliance2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appliance3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appliance4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appliance5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appliance6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appliance8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appliance7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appliance9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appliance10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
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
                    .addComponent(scrollRoom1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
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

        roomReg.setPreferredSize(new java.awt.Dimension(337, 600));

        Return1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        Return1.setText("<");
        Return1.setAlignmentX(0.5F);
        Return1.setMaximumSize(new java.awt.Dimension(70, 70));
        Return1.setPreferredSize(new java.awt.Dimension(70, 70));
        Return1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Return1ActionPerformed(evt);
            }
        });

        dispRoomName1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dispRoomName1.setText("Room Name:");

        javax.swing.GroupLayout roomRegTopLayout = new javax.swing.GroupLayout(roomRegTop);
        roomRegTop.setLayout(roomRegTopLayout);
        roomRegTopLayout.setHorizontalGroup(
            roomRegTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomRegTopLayout.createSequentialGroup()
                .addGroup(roomRegTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomRegTopLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(dispRoomName1))
                    .addGroup(roomRegTopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Return1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roomRegTopLayout.setVerticalGroup(
            roomRegTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomRegTopLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Return1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dispRoomName1)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        receiveRoom.setText("[ENTER ROOM NAME]");
        receiveRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiveRoomActionPerformed(evt);
            }
        });

        confirmAdd.setText("confirm");
        confirmAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAddActionPerformed(evt);
            }
        });

        cancelAdd.setText("cancel");

        bed.setText("bedroom");

        bath.setText("bathroom");

        otherroom.setText("Others");

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
                            .addComponent(otherroom)))
                    .addGroup(roomRegLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(cancelAdd)
                        .addGap(47, 47, 47)
                        .addComponent(confirmAdd)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        roomRegLayout.setVerticalGroup(
            roomRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomRegLayout.createSequentialGroup()
                .addComponent(roomRegTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(receiveRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otherroom)
                .addGap(69, 69, 69)
                .addGroup(roomRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelAdd)
                    .addComponent(confirmAdd))
                .addGap(182, 182, 182))
        );

        mainPanel.add(roomReg, "roomReg");
        roomReg.getAccessibleContext().setAccessibleName("roomReg");

        applianceReg.setPreferredSize(new java.awt.Dimension(337, 600));

        Return2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        Return2.setText("<");
        Return2.setAlignmentX(0.5F);
        Return2.setMaximumSize(new java.awt.Dimension(70, 70));
        Return2.setPreferredSize(new java.awt.Dimension(70, 70));
        Return2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Return2ActionPerformed(evt);
            }
        });

        dispRoomName3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dispRoomName3.setText("Appliance Name:");

        javax.swing.GroupLayout applianceTopLayout = new javax.swing.GroupLayout(applianceTop);
        applianceTop.setLayout(applianceTopLayout);
        applianceTopLayout.setHorizontalGroup(
            applianceTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, applianceTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Return2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282))
            .addGroup(applianceTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(applianceTopLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(dispRoomName3)
                    .addContainerGap(66, Short.MAX_VALUE)))
        );
        applianceTopLayout.setVerticalGroup(
            applianceTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, applianceTopLayout.createSequentialGroup()
                .addComponent(Return2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(applianceTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, applianceTopLayout.createSequentialGroup()
                    .addContainerGap(72, Short.MAX_VALUE)
                    .addComponent(dispRoomName3)
                    .addGap(10, 10, 10)))
        );

        receiveoutlet.setText("[ENTER APPLIANCE NAME]");
        receiveoutlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiveoutletActionPerformed(evt);
            }
        });

        confirmAdd1.setText("confirm");
        confirmAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAdd1ActionPerformed(evt);
            }
        });

        cancelAdd1.setText("cancel");

        dispRoomName2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dispRoomName2.setText("Type:");

        fan.setText("Fan");

        lamp.setText("Lamp");
        lamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lampActionPerformed(evt);
            }
        });

        otherappliance.setText("Others");
        otherappliance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherapplianceActionPerformed(evt);
            }
        });

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
            .addComponent(applianceTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(applianceRegLayout.createSequentialGroup()
                .addGroup(applianceRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(applianceRegLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(applianceRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fan)
                            .addComponent(receiveoutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dispRoomName2)
                            .addComponent(lamp)
                            .addComponent(otherappliance)
                            .addComponent(ac)))
                    .addGroup(applianceRegLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(cancelAdd1)
                        .addGap(47, 47, 47)
                        .addComponent(confirmAdd1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        applianceRegLayout.setVerticalGroup(
            applianceRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(applianceRegLayout.createSequentialGroup()
                .addComponent(applianceTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(receiveoutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(dispRoomName2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lamp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otherappliance)
                .addGap(53, 53, 53)
                .addGroup(applianceRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelAdd1)
                    .addComponent(confirmAdd1))
                .addGap(131, 131, 131))
        );

        mainPanel.add(applianceReg, "applianceReg");
        applianceReg.getAccessibleContext().setAccessibleName("applianceReg");

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
        // TODO add your handling code here:
    }//GEN-LAST:event_appliance3ActionPerformed

    private void appliance5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliance5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appliance5ActionPerformed

    private void appliance8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliance8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appliance8ActionPerformed

    private void appliance9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appliance9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appliance9ActionPerformed

    private void Return1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Return1ActionPerformed
        cardLayout.show(mainPanel,"homescreen");
    }//GEN-LAST:event_Return1ActionPerformed

    private void room9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_room9ActionPerformed

    private void room7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_room7ActionPerformed

    private void room5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_room5ActionPerformed

    private void room3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room3ActionPerformed
       /*rExist[2]=0;
       setVisible(false);
       update();*/
    }//GEN-LAST:event_room3ActionPerformed

    private void room1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room1ActionPerformed
        x=0;
        loadAppliance();
        cardLayout.show(mainPanel,"room");
        jLabel2.setText(Integer.toString(x));
    }//GEN-LAST:event_room1ActionPerformed

    private void receiveRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiveRoomActionPerformed

    }//GEN-LAST:event_receiveRoomActionPerformed

    private void Return2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Return2ActionPerformed
        cardLayout.show(mainPanel,"room");
    }//GEN-LAST:event_Return2ActionPerformed

    private void receiveoutletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiveoutletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receiveoutletActionPerformed

    private void room2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room2ActionPerformed
        x=10;
        loadAppliance();
        cardLayout.show(mainPanel,"room");
        jLabel2.setText(Integer.toString(oCount[0])+", "+Integer.toString(oCount[1]));
    }//GEN-LAST:event_room2ActionPerformed

    private void room1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_room1StateChanged
        
    }//GEN-LAST:event_room1StateChanged

    private void room1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_room1PropertyChange
        
    }//GEN-LAST:event_room1PropertyChange

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
        if(otherroom.isSelected())
        {
            roomType=2;
        }
        rName[rCount]=roomName;
        rType[rCount]=roomType;
        rCount+=1;
        setVisible(false);
        updateRoom();
        new Home().setVisible(true);
    }//GEN-LAST:event_confirmAddActionPerformed

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
    private javax.swing.JPanel HomeScreen;
    private javax.swing.JButton Return;
    private javax.swing.JButton Return1;
    private javax.swing.JButton Return2;
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
    private javax.swing.JButton confirmAdd;
    private javax.swing.JButton confirmAdd1;
    private javax.swing.JLabel dispRoomName;
    private javax.swing.JLabel dispRoomName1;
    private javax.swing.JLabel dispRoomName2;
    private javax.swing.JLabel dispRoomName3;
    private javax.swing.JRadioButton fan;
    private javax.swing.JLabel hiUser;
    private javax.swing.JPanel homeTop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton lamp;
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
    private javax.swing.JPanel roomTop;
    private javax.swing.JScrollPane scrollRoom;
    private javax.swing.JScrollPane scrollRoom1;
    // End of variables declaration//GEN-END:variables

  /*  private static class ColorButton extends JButton {

        public void paintComponent(Graphics g) {
            Color bg;
            if(isSelected())
            {
                bg = Color.red;
            }
            else
            {
                bg = Color.green;
            }
            setBackground(bg);
            super.paintComponent(g);
        }
    }*/
}
