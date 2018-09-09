/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gojekminiapps;

import java.util.Scanner;

/**
 *
 * @author Sanstation
 */
public class GoJekMiniApps {
 static Scanner sc = new Scanner(System.in);
    static int DriverCurrentPosI,DriverCurrentPosJ;
    //Noding
    public static char[][] Node(int a){
        char [][]arr = new char[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
               arr[i][j]='*';
            }
        }
        return arr;
    }  
    //getter
    public static int getSelisihI(char[][] temp,int a){
        int tempDriver=0;
        int tempPassenger=0;
        int tempAll;
        for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                     if(temp[i][j]=='D'){
                       tempDriver=i;
                       break;
                     }
                }
        }
        
        for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                     if(temp[i][j]=='Y'){
                       tempPassenger=i;
                       break;
                     }
                }
        }
        
        return tempAll = tempPassenger-tempDriver;
    }
    public static int getSelisihJ(char[][] temp,int a){
        int tempDriver=0;
        int tempPassenger=0;
        int tempAll;
        for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                     if(temp[i][j]=='D'){
                       tempDriver=j;
                       break;
                     }
                }
        }
        
        for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                     if(temp[i][j]=='Y'){
                       tempPassenger=j;
                       break;
                     }
                }
        }
        
        return tempAll = tempPassenger-tempDriver;
    }
    public static String PosDriver(char[][] temp,int a){
        for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                     if(temp[i][j]=='D'){
                        return "Your Driver is On [ "+i+","+j+" ]";
                        
                     }
                }
        }
        return "No Driver Found";
    }
    public static String PosPassenger(char[][]temp,int a){
        for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                     if(temp[i][j]=='Y'){
                        return "Your Position is On [ "+i+","+j+" ]";
                        
                     }
                }
        }
        return "Please Set Your Position";
    }
    //Start instead
    
    public static void passengerInput() throws InterruptedException{
        System.out.println("SELAMAT DATANG DI APLIKASI GOJEK MINI APPS BY SANSTATION");
        System.out.println("Berapa Radius Map Yang Anda Inginkan ?");
        System.out.print("Input : ");
        int MapRad = sc.nextInt(); 

        mapFirst(MapRad,MapRad);
        
        System.out.println("Input Dimana Posisi Anda Sekarang ");
        System.out.print("Input X: ");
        int x=sc.nextInt();
        System.out.print("Input Y: ");
        int y=sc.nextInt();
        
        showMap(MapRad,x,y);
    }
    public static void mapFirst(int x,int y){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print("[ "+i+","+j+" ]");
            }
            System.out.println("");
        }
    }
    
    public static void showMap(int a,int x,int y) throws InterruptedException{
        int drivePosI =(int)(Math.random()*((a-0)))+0;
        int drivePosJ = (int)(Math.random()*((a-0)))+0;
        
        int PassPosI = x;
        int PassPosJ = y;
         Thread.sleep(2000);
        
        char[][] temp = Node(a);
        
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if(i==drivePosI & j==drivePosJ){
                    temp[i][j]='D';
                    
                }
                if(i==PassPosI&j==PassPosJ){
                    temp[i][j]='Y';  
                }
                System.out.print(" [ "+temp[i][j]+" ] ");
            }
            
            System.out.println("");
        }
         System.out.println(PosDriver(temp,a));
         System.out.println(PosPassenger(temp,a));
         System.out.println("Distance Different Between You And Driver "+getSelisihI(temp,a)+","+getSelisihJ(temp,a));
         DriverGoing(temp,a,drivePosI,drivePosJ);
         
         
         
    }
    public static void DriverGoing(char[][] temp,int a,int drivePosI,int drivePosJ) throws InterruptedException{
        int tempI=getSelisihI(temp, a);
        int tempJ= getSelisihJ(temp,a);
        System.out.println("Driver Picking You Up At A Few Minutes...\n");
        // Thread.sleep(3000);
        char way ='#'; 
        int tempDrivePosI = drivePosI;
        int tempDrivePosJ = drivePosJ;
        char[][] tempPos =  new char[a][a];
        
        DriverCurrentPosI = drivePosI;
        DriverCurrentPosJ = drivePosJ;
        
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                tempPos[i][j]=temp[i][j];
            }
        }
        
        if(tempI>0){
            System.out.println("Kebawah "+ Math.abs(tempI)+" Kali");
            tempPos[DriverCurrentPosI][DriverCurrentPosJ] ='*';
            tempPos[DriverCurrentPosI+tempI][DriverCurrentPosJ]='D';
            
            DriverCurrentPosI +=tempI;
            
            for (int i = 0; i < a; i++) {
             for (int j = 0; j < a; j++) {
                 System.out.print(" ["+tempPos[i][j]+"] ");
             }
             System.out.println("");
            } 
        }
        if(tempI<0){
            System.out.println("Keatas "+ Math.abs(tempI)+" Kali");
            tempPos[DriverCurrentPosI][DriverCurrentPosJ] ='*';
            tempPos[DriverCurrentPosI+tempI][DriverCurrentPosJ]='D';
            
            DriverCurrentPosI+=tempI;
            
            for (int i = 0; i < a; i++) {
             for (int j = 0; j < a; j++) {
                 System.out.print(" ["+tempPos[i][j]+"] ");
             }
             System.out.println("");
            } 
        }
        if(tempJ>0){
             System.out.println("Kekanan "+ Math.abs(tempJ)+" Kali");
             
            tempPos[DriverCurrentPosI][DriverCurrentPosJ] ='*';
            tempPos[DriverCurrentPosI][DriverCurrentPosJ+tempJ]='D';
            
            DriverCurrentPosJ+=tempJ;
            
            for (int i = 0; i < a; i++) {
             for (int j = 0; j < a; j++) {
                 System.out.print(" ["+tempPos[i][j]+"] ");
             }
             System.out.println("");
            }
        }
        if(tempJ<0){
             System.out.println("Kekiri "+ Math.abs(tempJ)+" Kali");
        
            tempPos[DriverCurrentPosI][DriverCurrentPosJ] ='*';
            tempPos[DriverCurrentPosI][DriverCurrentPosJ+tempJ]='D';
            
            DriverCurrentPosJ+=tempJ;
            for (int i = 0; i < a; i++) {
             for (int j = 0; j < a; j++) {
                 System.out.print(" ["+tempPos[i][j]+"] ");
             }
             System.out.println("");
            }
        }
        
        if(tempI ==1 &tempJ==1){
            System.out.println("Driver At 0,0 position or Driver Not Found");
        }
        
        System.out.println("Driver Arrived");
    }
    
    public static void main(String[] args) throws InterruptedException {
       
       passengerInput();        
    }
    
}
