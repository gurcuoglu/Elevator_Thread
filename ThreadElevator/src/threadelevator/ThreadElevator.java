package threadelevator;

import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ThreadElevator {

   
    public static void main(String[] args) {
        // TODO code application logic here
        
        data grn = new data();
        data ckn = new data();
        data toplam = new data();
        
        data kat0 = new data();
        data kat1 = new data();
        data kat2 = new data();
        data kat3 = new data();
        data kat4 = new data();
        
        data kuyruk0 = new data();
        data kuyruk1 = new data();
        data kuyruk2 = new data();
        data kuyruk3 = new data();
        data kuyruk4 = new data();
        
        data asansör1 = new data();
        data asansör2 = new data();
        data asansör3 = new data();
        data asansör4 = new data();
        data asansör5 = new data();
        
       
        int kuyruk[][] = new int[4][1];
        
       
        giris g = new giris(grn,toplam,kat0,kat1,kat2,kat3,kat4,kuyruk0,kuyruk1,kuyruk2,kuyruk3,kuyruk4,kuyruk);
        cikis c = new cikis(ckn,toplam,kat0,kat1,kat2,kat3,kat4,kuyruk0,kuyruk1,kuyruk2,kuyruk3,kuyruk4);
        kontrol k=new kontrol(toplam,kat0, kat1, kat2, kat3, kat4,kuyruk0, kuyruk1, kuyruk2, kuyruk3, kuyruk4,asansör1, asansör2, asansör3, asansör4, asansör5);
        asansör a=new asansör(toplam,kat0, kat1, kat2, kat3, kat4,kuyruk0, kuyruk1, kuyruk2, kuyruk3, kuyruk4,asansör1, asansör2, asansör3, asansör4, asansör5,kuyruk);
        Yazi y=new Yazi(toplam,kat0, kat1, kat2, kat3, kat4,kuyruk0, kuyruk1, kuyruk2, kuyruk3, kuyruk4,asansör1, asansör2, asansör3, asansör4, asansör5,kuyruk);
        
        g.start();
        c.start();
        k.start();
        a.start();
        y.start();
        
        
//        for(;;){
//            if(kuyruk[0][0]>=0){
//                System.out.println(kuyruk[0][0]+" "+kuyruk[1][0]+" "+kuyruk[2][0]+" "+kuyruk[3][0]);
//            }
//        }
//        
    }   
    
}



class giris extends Thread{
    data grn;
    data toplam;
    data kat0;
    data kat1;
    data kat2;
    data kat3;
    data kat4;
    data kuyruk0;
    data kuyruk1;
    data kuyruk2;
    data kuyruk3;
    data kuyruk4;
    int [][] kuyruk ;
    Random r=new Random(); 

  
    
    
    public giris(data grn,data toplam,
                 data kat0,data kat1,data kat2,data kat3,data kat4,
                 data kuyruk0,data kuyruk1,data kuyruk2,data kuyruk3,data kuyruk4,int[][] kuyruk){
        this.grn=grn;
        this.toplam=toplam;
        this.kat0=kat0;
        this.kat1=kat1;
        this.kat2=kat2;
        this.kat3=kat3;
        this.kat4=kat4;
        this.kuyruk0=kuyruk0;
        this.kuyruk1=kuyruk1;
        this.kuyruk2=kuyruk2;
        this.kuyruk3=kuyruk3;
        this.kuyruk4=kuyruk4;
        this.kuyruk=kuyruk;
        
    }

   
    @Override
    public void run(){
        
        for(;;){
            int sayac=0;
            int sayac2=0;
            int a=r.nextInt(10)+1;//giren random müşteri
            try{
                   kat0.kat = a;
                   
                synchronized(toplam){
                grn.giren=a;
                toplam.avmToplam=toplam.avmToplam+a;
                
                
        }
               synchronized(kuyruk){
            while(a!=0){
           //kuyruklara 
           int c = r.nextInt(a+1); //kat1
           int d = r.nextInt(a+1); //kat2
           int e = r.nextInt(a+1); //kat3
           int f = r.nextInt(a+1); //kat4
           
           
           if(c+d+e+f==a){
            kuyruk[0][0] = c; //kat1 
            kuyruk[1][0] = d; //kat2
            kuyruk[2][0] = e; //kat3
            kuyruk[3][0] = f; //kat4
            a=0;
            kuyruk0.kat=kuyruk0.kat+c+d+e+f;
           }
            }
            
          
            
            }
        
                giris.sleep(500);
    }
    catch(Exception e){
        System.out.println("hata");
    }
    }
}}

class cikis extends Thread{
    data ckn;
    data toplam;
    data kat0;
    data kat1;
    data kat2;
    data kat3;
    data kat4;
    data kuyruk0;
    data kuyruk1;
    data kuyruk2;
    data kuyruk3;
    data kuyruk4; 
    Random r=new Random(); 
    
    
    public cikis(data ckn,data toplam,
                 data kat0,data kat1,data kat2,data kat3,data kat4,
                 data kuyruk0,data kuyruk1,data kuyruk2,data kuyruk3,data kuyruk4){
        this.ckn=ckn;
        this.toplam=toplam;
         this.kat0=kat0;
        this.kat1=kat1;
        this.kat2=kat2;
        this.kat3=kat3;
        this.kat4=kat4;
        this.kuyruk0=kuyruk0;
        this.kuyruk1=kuyruk1;
        this.kuyruk2=kuyruk2;
        this.kuyruk3=kuyruk3;
        this.kuyruk4=kuyruk4;
    }
    public void run(){
        for(;;){
            try{
       if(kat1.kat>0){
           
           int b=r.nextInt(kat1.kat)+1;
            kuyruk1.kat=b;
            kat1.kat=kat1.kat-kuyruk1.kat;
            
       }
            if(kat2.kat>0){
                
             int g=r.nextInt(kat2.kat)+1;
            kuyruk2.kat=g;
            kat2.kat=kat2.kat-kuyruk2.kat;
            
       }
          if(kat3.kat>0){
              
            int h=r.nextInt(kat3.kat)+1;
            kuyruk3.kat=h;
            kat3.kat=kat3.kat-kuyruk3.kat;
            
       }
           if(kat4.kat>0){
               
           int j=r.nextInt(kat4.kat)+1;
            kuyruk4.kat=j;
            kat4.kat=kat4.kat-kuyruk4.kat;
       }
            
       
         
                synchronized(toplam){
                
                if(toplam.avmToplam>=kat1.kat){
                toplam.avmToplam=toplam.avmToplam-kuyruk1.kat-kuyruk2.kat-kuyruk3.kat-kuyruk4.kat;
                ckn.cikan=kuyruk1.kat+kuyruk2.kat+kuyruk3.kat+kuyruk4.kat;
                }
                else{
                    toplam.avmToplam=0;
                    ckn.cikan=0;
                }
                
            }
                
           
             
                cikis.sleep(1000);
                
        }catch(Exception e){
        System.out.println("hata");
    }
        }
    
}}

class kontrol extends Thread {
    
    
    data toplam;
    data kat0;
    data kat1;
    data kat2;
    data kat3;
    data kat4;
    data kuyruk0;
    data kuyruk1;
    data kuyruk2;
    data kuyruk3;
    data kuyruk4;
    data asansör1;
    data asansör2;
    data asansör3;
    data asansör4;
    data asansör5;
    
   // int [][] kuyruk ;
    
    public kontrol(data toplam,
                 data kat0,data kat1,data kat2,data kat3,data kat4,
                 data kuyruk0,data kuyruk1,data kuyruk2,data kuyruk3,data kuyruk4,
                 data asansör1,data asansör2,data asansör3,data asansör4,data asansör5){
        
        this.toplam=toplam;
         this.kat0=kat0;
        this.kat1=kat1;
        this.kat2=kat2;
        this.kat3=kat3;
        this.kat4=kat4;
        this.kuyruk0=kuyruk0;
        this.kuyruk1=kuyruk1;
        this.kuyruk2=kuyruk2;
        this.kuyruk3=kuyruk3;
        this.kuyruk4=kuyruk4;
        this.asansör1=asansör1;
        this.asansör2=asansör2;
        this.asansör3=asansör3;
        this.asansör4=asansör4;
        this.asansör5=asansör5;
    }
    
    public void run(){
        //KUYRUK İÇİN TİMER LAZIM. 1700 MS 
        for(;;){
        try{
        int aktifsayisi=1;
        int aktifsayisi2=1;
        int k=kuyruk0.kat+kuyruk1.kat+kuyruk2.kat+kuyruk3.kat+kuyruk4.kat;
        
        
        if(k>20){
            aktifsayisi=2;
            aktifsayisi2=2;
        }
         if(k>40){
            aktifsayisi=3;
            aktifsayisi2=3;}
         if(k>60){
            aktifsayisi=4;
            aktifsayisi2=4;}
         if(k>80){
            aktifsayisi=5;
            aktifsayisi2=5;}
            
        
        
        
        
        if(k>20 && k<=40){
            
         
        while(aktifsayisi==1){
            
            if(asansör2.aktif==false){
                asansör2.aktif=true;
                aktifsayisi--;
                continue;
            }  
            
            else if(asansör3.aktif==false){
                asansör3.aktif=true;
                aktifsayisi--;
                continue;
            }  
            else if(asansör4.aktif==false){
                asansör4.aktif=true;
                aktifsayisi--;
                continue;
            }  
            else  if(asansör5.aktif==false){
                asansör5.aktif=true;
                aktifsayisi--;
                continue;
            }  
        }             
    }
               
        if(k>40 && k<=60){
           
            while(aktifsayisi==1){
            
            if(asansör2.aktif==false){
                asansör2.aktif=true;
                aktifsayisi--;
                continue;
            }  
            
            else if(asansör3.aktif==false){
                asansör3.aktif=true;
                aktifsayisi--;
                continue;
            }  
           else if(asansör4.aktif==false){
                asansör4.aktif=true;
                aktifsayisi--;
                continue;
            }  
           else if(asansör5.aktif==false){
                asansör5.aktif=true;
                aktifsayisi--;
                continue;
            }  
        }  
    }
        if(k>60&& k<=80){
            
            while(aktifsayisi==1){
            
            if(asansör2.aktif==false){
                asansör2.aktif=true;
                aktifsayisi--;
                continue;
            }  
            
            else if(asansör3.aktif==false){
                asansör3.aktif=true;
                aktifsayisi--;
                continue;
            }  
            else if(asansör4.aktif==false){
                asansör4.aktif=true;
                aktifsayisi--;
                continue;
            }  
            else  if(asansör5.aktif==false){
                asansör5.aktif=true;
                aktifsayisi--;
                continue;
            }  
        }  
            
    }
        if(k>80){
            
            while(aktifsayisi==1){
            
            if(asansör2.aktif==false){
                asansör2.aktif=true;
                aktifsayisi--;
                continue;
            }  
            
            else if(asansör3.aktif==false){
                asansör3.aktif=true;
                aktifsayisi--;
                continue;
            }  
            else if(asansör4.aktif==false){
                asansör4.aktif=true;
                aktifsayisi--;
                continue;
            }  
            else if(asansör5.aktif==false){
                asansör5.aktif=true;
                aktifsayisi--;
                continue;
            }  
        }  
            
    }
        
        
        if(aktifsayisi2==1){
            asansör2.aktif=false;
            asansör3.aktif=false;
            asansör4.aktif=false;
            asansör5.aktif=false;
            
        }
        
          if(aktifsayisi2==2){         
            asansör3.aktif=false;
            asansör4.aktif=false;
            asansör5.aktif=false;
              
        }
        
          if(aktifsayisi2==3){
            
            asansör4.aktif=false;
            asansör5.aktif=false;
             
        }
            if(aktifsayisi2==4){
            
            asansör5.aktif=false;
            
        }
                   cikis.sleep(100);
                
        }catch(Exception e){
        System.out.println("hata");
    }
        }
    }
    
    
}

class asansör extends Thread{

    data toplam;
    data kat0;
    data kat1;
    data kat2;
    data kat3;
    data kat4;
    data kuyruk0;
    data kuyruk1;
    data kuyruk2;
    data kuyruk3;
    data kuyruk4;
    data asansör1;
    data asansör2;
    data asansör3;
    data asansör4;
    data asansör5;
    int [][] kuyruk ;
    
   public asansör(data toplam,
                 data kat0,data kat1,data kat2,data kat3,data kat4,
                 data kuyruk0,data kuyruk1,data kuyruk2,data kuyruk3,data kuyruk4,
                 data asansör1,data asansör2,data asansör3,data asansör4,data asansör5,int [][] kuyruk){
       this.toplam=toplam;
       this.kat0=kat0;
       this.kat1=kat1;
       this.kat2=kat2;
       this.kat3=kat3;
       this.kat4=kat4;
       this.kuyruk0=kuyruk0;
       this.kuyruk1=kuyruk1;
       this.kuyruk2=kuyruk2;
       this.kuyruk3=kuyruk3;
       this.kuyruk4=kuyruk4;
       this.asansör1=asansör1;
       this.asansör2=asansör2;
       this.asansör3=asansör3;
       this.asansör4=asansör4;
       this.asansör5=asansör5;
       this.kuyruk=kuyruk;  
   }
   
    public void run(){
        //600ms 1 kat için
        asansör1.kapasite=10;
        asansör2.kapasite=10;
        asansör3.kapasite=10;
        asansör4.kapasite=10;
        asansör5.kapasite=10;
        int m=0,n=0,p=0,t=0;
        
        
        
        
    for(;;){
        try{
        asansör1.mod=1;
        asansör2.mod=0;
        asansör3.mod=0;
        asansör4.mod=0;
        asansör5.mod=0;
        asansör2.hedef=0;
        asansör3.hedef=0;
        asansör4.hedef=0;
        asansör5.hedef=0;
        
            if(kuyruk0.kat>0){
                
                asansör1.yön=1;
                if(asansör1.kat!=0){
                    int y=asansör1.kat*200;
                    TimeUnit.MILLISECONDS.sleep(y);
                    asansör1.kat=0;
                }
               if(asansör1.kapasite>=kuyruk0.kat){
                   asansör1.kapasite=asansör1.kapasite-kuyruk0.kat;
               }
               else{
                   asansör1.kapasite=0;
                   kuyruk0.kat-=10;
               }
               if(kuyruk[0][0]>0){
                   int r=(1-asansör1.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör1.hedef=1;
                   asansör1.kat=1;
                   asansör1.kapasite=asansör1.kapasite+kuyruk[0][0];
                   kat1.kat=kat1.kat+kuyruk[0][0];
               }
                
               if(kuyruk[1][0]>0){
                   int r=(2-asansör1.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör1.kat=2;
                   asansör1.hedef=2;
                   asansör1.kapasite=asansör1.kapasite+kuyruk[1][0];
                   kat2.kat=kat2.kat+kuyruk[1][0];
               }
                
               if(kuyruk[2][0]>0){
                   int r=(3-asansör1.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör1.kat=3;
                   asansör1.hedef=3;
                   asansör1.kapasite=asansör1.kapasite+kuyruk[2][0];
                   kat3.kat=kat3.kat+kuyruk[2][0];
               }
                
               if(kuyruk[3][0]>0){
                   int r=(4-asansör1.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör1.kat=4;
                   asansör1.hedef=4;
                   asansör1.kapasite=asansör1.kapasite+kuyruk[3][0];
                   kat4.kat=kat4.kat+kuyruk[3][0];
               }
               
            }
            
            if(kuyruk1.kat+kuyruk2.kat+kuyruk3.kat+kuyruk4.kat>0){
                if(kuyruk4.kat>0){
                    int r=(4-asansör1.kat)*200;
                    TimeUnit.MILLISECONDS.sleep(r);
                    asansör1.kat=4;
                    asansör1.hedef=3;
                    asansör1.yön=0;
                    if(asansör1.kapasite>=kuyruk4.kat){
                    asansör1.kapasite=asansör1.kapasite-kuyruk4.kat;
                    kuyruk4.kat=0;
                   }
                    else{
                        asansör1.kapasite=10;
                        kuyruk4.kat-=10;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör1.kat-=1;
                }
                
                
                if(kuyruk3.kat>0){
                    asansör1.hedef=2;
                    if(asansör1.kapasite>=kuyruk3.kat){
                    asansör1.kapasite=asansör1.kapasite-kuyruk3.kat;
                    kuyruk3.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör1.kat-kuyruk3.kat);
                           asansör1.kapasite=0;
                           kuyruk3.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör1.kat-=1;
                    //asansör olduğu kattan 3 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                if(kuyruk2.kat>0){
                    asansör1.hedef=1;
                    if(asansör1.kapasite>=kuyruk2.kat){
                    asansör1.kapasite=asansör1.kapasite-kuyruk2.kat;
                    kuyruk2.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör1.kat-kuyruk2.kat);
                           asansör1.kapasite=0;
                           kuyruk2.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör1.kat-=1;
                    ////asansör olduğu kattan 2 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                if(kuyruk1.kat>0){
                    asansör1.hedef=0;
                    if(asansör1.kapasite>=kuyruk1.kat){
                    asansör1.kapasite=asansör1.kapasite-kuyruk1.kat;
                    kuyruk1.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör1.kat-kuyruk1.kat);
                           asansör1.kapasite=0;
                           kuyruk1.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör1.kat-=1;
                    ////asansör olduğu kattan 1 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                
                toplam.avmToplam=toplam.avmToplam-(10-asansör1.kapasite);
                asansör1.kapasite=10;
                asansör1.kat=0;
                asansör1.mod=0;
            }
         /////////////////////////////////////////////////////////////////222222222222222222222222222222222222222222222
         if(asansör2.aktif==true){
             
             asansör2.mod=1;
             if(kuyruk0.kat>0){
                 asansör2.hedef=1;
                asansör2.yön=1;
                if(asansör2.kat!=0){
                    int y=asansör2.kat*200;
                    TimeUnit.MILLISECONDS.sleep(y);
                    asansör2.kat=0;
                }
               if(asansör2.kapasite>=kuyruk0.kat){
                   asansör2.kapasite=asansör2.kapasite-kuyruk0.kat;
               }
               else{
                   asansör2.kapasite=0;
                   kuyruk0.kat-=10;
               }
               if(kuyruk[0][0]>0){
                   asansör2.hedef=2;
                   int r=(1-asansör2.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör2.kat=1;
                   asansör2.kapasite=asansör2.kapasite+kuyruk[0][0];
                   kat1.kat=kat1.kat+kuyruk[0][0];
               }
                
               if(kuyruk[1][0]>0){
                   asansör2.hedef=3;
                   int r=(2-asansör2.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör2.kat=2;
                   asansör2.kapasite=asansör2.kapasite+kuyruk[1][0];
                   kat2.kat=kat2.kat+kuyruk[1][0];
               }
                
               if(kuyruk[2][0]>0){
                   asansör2.hedef=3;
                   int r=(3-asansör2.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör2.kat=3;
                   asansör2.kapasite=asansör2.kapasite+kuyruk[2][0];
                   kat3.kat=kat3.kat+kuyruk[2][0];
               }
                
               if(kuyruk[3][0]>0){
                   asansör2.hedef=4;
                   int r=(4-asansör2.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör2.kat=4;
                   asansör2.kapasite=asansör2.kapasite+kuyruk[3][0];
                   kat4.kat=kat4.kat+kuyruk[3][0];
               }
               
            }
            
            if(kuyruk1.kat+kuyruk2.kat+kuyruk3.kat+kuyruk4.kat>0){
                if(kuyruk4.kat>0){
                    asansör2.hedef=3;
                    int r=(4-asansör2.kat)*200;
                    TimeUnit.MILLISECONDS.sleep(r);
                    asansör2.kat=4;
                    asansör2.yön=0;
                    if(asansör2.kapasite>=kuyruk4.kat){
                    asansör2.kapasite=asansör2.kapasite-kuyruk4.kat;
                    kuyruk4.kat=0;
                   }
                    else{
                        asansör2.kapasite=10;
                        kuyruk4.kat-=10;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör2.kat-=1;
                }
                
                
                if(kuyruk3.kat>0){
                    asansör2.hedef=2;
                    if(asansör2.kapasite>=kuyruk3.kat){
                    asansör2.kapasite=asansör2.kapasite-kuyruk3.kat;
                    kuyruk3.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör2.kat-kuyruk3.kat);
                           asansör2.kapasite=0;
                           kuyruk3.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör2.kat-=1;
                    //asansör olduğu kattan 3 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                if(kuyruk2.kat>0){
                    asansör2.hedef=1;
                    if(asansör2.kapasite>=kuyruk2.kat){
                    asansör2.kapasite=asansör2.kapasite-kuyruk2.kat;
                    kuyruk2.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör2.kat-kuyruk2.kat);
                           asansör2.kapasite=0;
                           kuyruk2.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör2.kat-=1;
                    ////asansör olduğu kattan 2 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                if(kuyruk1.kat>0){
                    asansör2.hedef=0;
                    if(asansör2.kapasite>=kuyruk1.kat){
                    asansör2.kapasite=asansör2.kapasite-kuyruk1.kat;
                    kuyruk1.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör2.kat-kuyruk1.kat);
                           asansör2.kapasite=0;
                           kuyruk1.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör2.kat-=1;
                    ////asansör olduğu kattan 1 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                
                toplam.avmToplam=toplam.avmToplam-(10-asansör2.kapasite);
                asansör2.kapasite=10;
                asansör2.kat=0;
                asansör2.mod=0;
            }
         }
         //////////////////////////////////////////////////////////////////////////33333333333333333333333333333333333333333333333
            if(asansör3.aktif==true){
             
             asansör3.mod=1;
             if(kuyruk0.kat>0){
                 asansör3.hedef=1;
                asansör3.yön=1;
                if(asansör3.kat!=0){
                    int y=asansör3.kat*200;
                    TimeUnit.MILLISECONDS.sleep(y);
                    asansör3.kat=0;
                }
               if(asansör3.kapasite>=kuyruk0.kat){
                   asansör3.kapasite=asansör3.kapasite-kuyruk0.kat;
               }
               else{
                   asansör3.kapasite=0;
                   kuyruk0.kat-=10;
               }
               if(kuyruk[0][0]>0){
                   asansör3.hedef=2;
                   int r=(1-asansör3.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör3.kat=1;
                   asansör3.kapasite=asansör3.kapasite+kuyruk[0][0];
                   kat1.kat=kat1.kat+kuyruk[0][0];
               }
                
               if(kuyruk[1][0]>0){
                   asansör3.hedef=3;
                   int r=(2-asansör3.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör3.kat=2;
                   asansör3.kapasite=asansör3.kapasite+kuyruk[1][0];
                   kat2.kat=kat2.kat+kuyruk[1][0];
               }
                
               if(kuyruk[2][0]>0){
                   asansör3.hedef=3;
                   int r=(3-asansör3.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör3.kat=3;
                   asansör3.kapasite=asansör3.kapasite+kuyruk[2][0];
                   kat3.kat=kat3.kat+kuyruk[2][0];
               }
                
               if(kuyruk[3][0]>0){
                   asansör3.hedef=4;
                   int r=(4-asansör3.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör3.kat=4;
                   asansör3.kapasite=asansör3.kapasite+kuyruk[3][0];
                   kat4.kat=kat4.kat+kuyruk[3][0];
               }
               
            }
            
            if(kuyruk1.kat+kuyruk2.kat+kuyruk3.kat+kuyruk4.kat>0){
                if(kuyruk4.kat>0){
                    asansör3.hedef=3;
                    int r=(4-asansör3.kat)*200;
                    TimeUnit.MILLISECONDS.sleep(r);
                    asansör3.kat=4;
                    asansör3.yön=0;
                    if(asansör3.kapasite>=kuyruk4.kat){
                    asansör3.kapasite=asansör3.kapasite-kuyruk4.kat;
                    kuyruk4.kat=0;
                   }
                    else{
                        asansör3.kapasite=10;
                        kuyruk4.kat-=10;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör3.kat-=1;
                }
                
                
                if(kuyruk3.kat>0){
                    asansör3.hedef=2;
                    if(asansör3.kapasite>=kuyruk3.kat){
                    asansör3.kapasite=asansör3.kapasite-kuyruk3.kat;
                    kuyruk3.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör3.kat-kuyruk3.kat);
                           asansör3.kapasite=0;
                           kuyruk3.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör3.kat-=1;
                    //asansör olduğu kattan 3 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                if(kuyruk2.kat>0){
                    asansör3.hedef=1;
                    if(asansör3.kapasite>=kuyruk2.kat){
                    asansör3.kapasite=asansör3.kapasite-kuyruk2.kat;
                    kuyruk2.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör3.kat-kuyruk2.kat);
                           asansör3.kapasite=0;
                           kuyruk2.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör3.kat-=1;
                    ////asansör olduğu kattan 2 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                if(kuyruk1.kat>0){
                    asansör3.hedef=0;
                    if(asansör3.kapasite>=kuyruk1.kat){
                    asansör3.kapasite=asansör3.kapasite-kuyruk1.kat;
                    kuyruk1.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör3.kat-kuyruk1.kat);
                           asansör3.kapasite=0;
                           kuyruk1.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör3.kat-=1;
                    ////asansör olduğu kattan 1 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                
                toplam.avmToplam=toplam.avmToplam-(10-asansör3.kapasite);
                asansör3.kapasite=10;
                asansör3.kat=0;
                asansör3.mod=0;
            }
         }
            /////////////////////////////////////////////////////////////////////////44444444444444444444444444444444444444444444
           if(asansör4.aktif==true){
             
             asansör4.mod=1;
             if(kuyruk0.kat>0){
                 asansör4.hedef=1;
                asansör4.yön=1;
                if(asansör4.kat!=0){
                    int y=asansör4.kat*200;
                    TimeUnit.MILLISECONDS.sleep(y);
                    asansör4.kat=0;
                }
               if(asansör4.kapasite>=kuyruk0.kat){
                   asansör4.kapasite=asansör4.kapasite-kuyruk0.kat;
               }
               else{
                   asansör4.kapasite=0;
                   kuyruk0.kat-=10;
               }
               if(kuyruk[0][0]>0){
                   asansör4.hedef=2;
                   int r=(1-asansör4.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör4.kat=1;
                   asansör4.kapasite=asansör4.kapasite+kuyruk[0][0];
                   kat1.kat=kat1.kat+kuyruk[0][0];
               }
                
               if(kuyruk[1][0]>0){
                   asansör4.hedef=3;
                   int r=(2-asansör4.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör4.kat=2;
                   asansör4.kapasite=asansör4.kapasite+kuyruk[1][0];
                   kat2.kat=kat2.kat+kuyruk[1][0];
               }
                
               if(kuyruk[2][0]>0){
                   asansör4.hedef=3;
                   int r=(3-asansör4.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör4.kat=3;
                   asansör4.kapasite=asansör4.kapasite+kuyruk[2][0];
                   kat3.kat=kat3.kat+kuyruk[2][0];
               }
                
               if(kuyruk[3][0]>0){
                   asansör4.hedef=4;
                   int r=(4-asansör4.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör4.kat=4;
                   asansör4.kapasite=asansör4.kapasite+kuyruk[3][0];
                   kat4.kat=kat4.kat+kuyruk[3][0];
               }
               
            }
            
            if(kuyruk1.kat+kuyruk2.kat+kuyruk3.kat+kuyruk4.kat>0){
                if(kuyruk4.kat>0){
                    asansör4.hedef=3;
                    int r=(4-asansör4.kat)*200;
                    TimeUnit.MILLISECONDS.sleep(r);
                    asansör4.kat=4;
                    asansör4.yön=0;
                    if(asansör4.kapasite>=kuyruk4.kat){
                    asansör4.kapasite=asansör4.kapasite-kuyruk4.kat;
                    kuyruk4.kat=0;
                   }
                    else{
                        asansör4.kapasite=10;
                        kuyruk4.kat-=10;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör4.kat-=1;
                }
                
                
                if(kuyruk3.kat>0){
                    asansör4.hedef=2;
                    if(asansör4.kapasite>=kuyruk3.kat){
                    asansör4.kapasite=asansör4.kapasite-kuyruk3.kat;
                    kuyruk3.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör4.kat-kuyruk3.kat);
                           asansör4.kapasite=0;
                           kuyruk3.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör4.kat-=1;
                    //asansör olduğu kattan 3 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                if(kuyruk2.kat>0){
                    asansör4.hedef=1;
                    if(asansör4.kapasite>=kuyruk2.kat){
                    asansör4.kapasite=asansör4.kapasite-kuyruk2.kat;
                    kuyruk2.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör4.kat-kuyruk2.kat);
                           asansör4.kapasite=0;
                           kuyruk2.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör4.kat-=1;
                    ////asansör olduğu kattan 2 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                if(kuyruk1.kat>0){
                    asansör4.hedef=0;
                    if(asansör4.kapasite>=kuyruk1.kat){
                    asansör4.kapasite=asansör4.kapasite-kuyruk1.kat;
                    kuyruk1.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör4.kat-kuyruk1.kat);
                           asansör4.kapasite=0;
                           kuyruk1.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör4.kat-=1;
                    ////asansör olduğu kattan 1 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                
                toplam.avmToplam=toplam.avmToplam-(10-asansör4.kapasite);
                asansör4.kapasite=10;
                asansör4.kat=0;
                asansör4.mod=0;
            }
         }
            ///////////////////////////////////////////////////////////555555555555555555555555555555555555
            if(asansör5.aktif==true){
             
             asansör5.mod=1;
             if(kuyruk0.kat>0){
                 asansör5.hedef=1;
                asansör5.yön=1;
                if(asansör5.kat!=0){
                    int y=asansör5.kat*200;
                    TimeUnit.MILLISECONDS.sleep(y);
                    asansör5.kat=0;
                }
               if(asansör5.kapasite>=kuyruk0.kat){
                   asansör5.kapasite=asansör5.kapasite-kuyruk0.kat;
               }
               else{
                   asansör5.kapasite=0;
                   kuyruk0.kat-=10;
               }
               if(kuyruk[0][0]>0){
                   asansör5.hedef=2;
                   int r=(1-asansör5.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör5.kat=1;
                   asansör5.kapasite=asansör5.kapasite+kuyruk[0][0];
                   kat1.kat=kat1.kat+kuyruk[0][0];
               }
                
               if(kuyruk[1][0]>0){
                   asansör5.hedef=3;
                   int r=(2-asansör5.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör5.kat=2;
                   asansör5.kapasite=asansör5.kapasite+kuyruk[1][0];
                   kat2.kat=kat2.kat+kuyruk[1][0];
               }
                
               if(kuyruk[2][0]>0){
                   asansör5.hedef=3;
                   int r=(3-asansör5.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör5.kat=3;
                   asansör5.kapasite=asansör5.kapasite+kuyruk[2][0];
                   kat3.kat=kat3.kat+kuyruk[2][0];
               }
                
               if(kuyruk[3][0]>0){
                   asansör5.hedef=4;
                   int r=(4-asansör5.kat)*200;
                   TimeUnit.MILLISECONDS.sleep(r);
                   asansör5.kat=4;
                   asansör5.kapasite=asansör5.kapasite+kuyruk[3][0];
                   kat4.kat=kat4.kat+kuyruk[3][0];
               }
               
            }
            
            if(kuyruk1.kat+kuyruk2.kat+kuyruk3.kat+kuyruk4.kat>0){
                if(kuyruk4.kat>0){
                    asansör5.hedef=3;
                    int r=(4-asansör5.kat)*200;
                    TimeUnit.MILLISECONDS.sleep(r);
                    asansör5.kat=4;
                    asansör5.yön=0;
                    if(asansör5.kapasite>=kuyruk4.kat){
                    asansör5.kapasite=asansör5.kapasite-kuyruk4.kat;
                    kuyruk4.kat=0;
                   }
                    else{
                        asansör5.kapasite=10;
                        kuyruk4.kat-=10;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör5.kat-=1;
                }
                
                
                if(kuyruk3.kat>0){
                    asansör5.hedef=2;
                    if(asansör5.kapasite>=kuyruk3.kat){
                    asansör5.kapasite=asansör5.kapasite-kuyruk3.kat;
                    kuyruk3.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör5.kat-kuyruk3.kat);
                           asansör5.kapasite=0;
                           kuyruk3.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör5.kat-=1;
                    //asansör olduğu kattan 3 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                if(kuyruk2.kat>0){
                    asansör5.hedef=1;
                    if(asansör5.kapasite>=kuyruk2.kat){
                    asansör5.kapasite=asansör5.kapasite-kuyruk2.kat;
                    kuyruk2.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör5.kat-kuyruk2.kat);
                           asansör5.kapasite=0;
                           kuyruk2.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör5.kat-=1;
                    ////asansör olduğu kattan 2 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                if(kuyruk1.kat>0){
                    asansör5.hedef=0;
                    if(asansör5.kapasite>=kuyruk1.kat){
                    asansör5.kapasite=asansör5.kapasite-kuyruk1.kat;
                    kuyruk1.kat=0;
                   }
                    else{
                        
                           int r= -1*(asansör5.kat-kuyruk1.kat);
                           asansör5.kapasite=0;
                           kuyruk1.kat-=r;
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                    asansör5.kat-=1;
                    ////asansör olduğu kattan 1 e gidecek kapasitesi var mı onu kontrol etcek ve alabildiği müşteriyi alcak//asansör.kat-1//kattaki kuyruğu azalt
                }
                
                toplam.avmToplam=toplam.avmToplam-(10-asansör5.kapasite);
                asansör5.kapasite=10;
                asansör5.kat=0;
                asansör5.mod=0;
            }
         }
            TimeUnit.MILLISECONDS.sleep(1);
    }
    catch(Exception e){
        
    }
     }
    }   
}
class Yazi extends Thread{
    data toplam;
    data kat0;
    data kat1;
    data kat2;
    data kat3;
    data kat4;
    data kuyruk0;
    data kuyruk1;
    data kuyruk2;
    data kuyruk3;
    data kuyruk4;
    data asansör1;
    data asansör2;
    data asansör3;
    data asansör4;
    data asansör5;
    int [][] kuyruk ;
public Yazi(data toplam,
                 data kat0,data kat1,data kat2,data kat3,data kat4,
                 data kuyruk0,data kuyruk1,data kuyruk2,data kuyruk3,data kuyruk4,
                 data asansör1,data asansör2,data asansör3,data asansör4,data asansör5,int [][] kuyruk){
       this.toplam=toplam;
       this.kat0=kat0;
       this.kat1=kat1;
       this.kat2=kat2;
       this.kat3=kat3;
       this.kat4=kat4;
       this.kuyruk0=kuyruk0;
       this.kuyruk1=kuyruk1;
       this.kuyruk2=kuyruk2;
       this.kuyruk3=kuyruk3;
       this.kuyruk4=kuyruk4;
       this.asansör1=asansör1;
       this.asansör2=asansör2;
       this.asansör3=asansör3;
       this.asansör4=asansör4;
       this.asansör5=asansör5;
       this.kuyruk=kuyruk;  
   }
   
    public void run(){
    for(;;){
        try{
        System.out.println("/////////////////////////////////////////////////////////////////////////////////");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////");
        System.out.println("0. floor :\t queue : "+kuyruk0.kat);
        System.out.println("1. floor :"+kat1.kat+"\t queue : "+kuyruk1.kat);
        System.out.println("2. floor :"+kat2.kat+"\t queue : "+kuyruk2.kat);
        System.out.println("3. floor :"+kat3.kat+"\t queue : "+kuyruk3.kat);
        System.out.println("4. floor :"+kat4.kat+"\t queue : "+kuyruk4.kat);
        System.out.println("*");
        System.out.println("0. floor :[["+kuyruk[0][0]+",1], ["+kuyruk[1][0]+",2], ["+kuyruk[2][0]+",3], ["+kuyruk[3][0]+",4]]");
        System.out.println("1.floor  :[["+kuyruk1.kat+",0]]");
        System.out.println("2.floor  :[["+kuyruk2.kat+",0]]");
        System.out.println("3.floor  :[["+kuyruk3.kat+",0]]");
        System.out.println("4.floor  :[["+kuyruk4.kat+",0]]");
            System.out.println("---------ASANSÖRLER-------");
            System.out.println("-------------------------------------");
            System.out.println("Asansör1");
            if(asansör1.aktif==false){
            System.out.println("aktiflik : true");}
            else{
                System.out.println("aktiflik : false");
            }
            if(asansör1.mod==0){
            System.out.println("mod : Beklemede ");}
            else{
                System.out.println("mod : Çalışıyor");
            }
            System.out.println("kat : "+asansör1.kat);
            System.out.println("hedef : "+ asansör1.hedef);
            
            
            if(asansör1.yön==1){
                System.out.println("yön : yukarı");
            }
            else {              
            System.out.println("yön : aşağı");
            }
            System.out.println("kapasite : "+ 10);
            System.out.println("county inside : "+ (10- asansör1.kapasite));
            System.out.println("[("+kuyruk[0][0] +",1 )(," + kuyruk [1][0] + ",2 )(,"+kuyruk[2][0]+",3 )("+kuyruk[3][0]+",3 )]");
            /////////////////////////////////////////////////////////////////////////////////////////2222222222222222222222
            System.out.println("-------------------------------------");
            System.out.println("Asansör2");
            if(asansör2.aktif==true){
            System.out.println("aktiflik : true");}
            else{
                System.out.println("aktiflik : false");
            }
            if(asansör2.mod==0){
            System.out.println("mod : Beklemede ");}
            else{
                System.out.println("mod : Çalışıyor");
            }
            System.out.println("kat : "+asansör2.kat);
            System.out.println("hedef : "+ asansör2.hedef);
            
            
            if(asansör2.yön==0){
                System.out.println("yön : yukarı");
            }
            else {              
            System.out.println("yön : aşağı");
            }
            System.out.println("kapasite : "+ 10);
            System.out.println("county inside : "+ (10- asansör2.kapasite));
            System.out.println("[]");
            
            //////////////////////////////////////3333333333333333333333333333333333333333333333333333333
            
            System.out.println("-------------------------------------");
            System.out.println("Asansör3");
            if(asansör3.aktif==true){
            System.out.println("aktiflik : true");}
            else{
                System.out.println("aktiflik : false");
            }
            if(asansör3.mod==0){
            System.out.println("mod : Beklemede ");}
            else{
                System.out.println("mod : Çalışıyor");
            }
            System.out.println("kat : "+asansör3.kat);
            System.out.println("hedef : "+ asansör3.hedef);
            
            
            if(asansör3.yön==0){
                System.out.println("yön : yukarı");
            }
            else {              
            System.out.println("yön : aşağı");
            }
            System.out.println("kapasite : "+ 10);
            System.out.println("county inside : "+ (10- asansör3.kapasite));
            System.out.println("[]");
            
            //////////////////////////////////////////////////////////44444444444444444444444444444444444
            
            System.out.println("-------------------------------------");
            System.out.println("Asansör4");
            if(asansör4.aktif==true){
            System.out.println("aktiflik : true");}
            else{
                System.out.println("aktiflik : false");
            }
            if(asansör4.mod==0){
            System.out.println("mod : Beklemede ");}
            else{
                System.out.println("mod : Çalışıyor");
            }
            System.out.println("kat : "+asansör4.kat);
            System.out.println("hedef : "+ asansör4.hedef);
            
            
            if(asansör4.yön==0){
                System.out.println("yön : yukarı");
            }
            else {              
            System.out.println("yön : aşağı");
            }
            System.out.println("kapasite : "+ 10);
            System.out.println("county inside : "+ (10- asansör4.kapasite));
            System.out.println("[]");
            ////////////////////////////////////////////////////////////////5555555555555555555555555555555555555
            
            System.out.println("-------------------------------------");
            System.out.println("Asansör5");
            if(asansör5.aktif==true){
            System.out.println("aktiflik : true");}
            else{
                System.out.println("aktiflik : false");
            }
            if(asansör5.mod==0){
            System.out.println("mod : Beklemede ");}
            else{
                System.out.println("mod : Çalışıyor");
            }
            System.out.println("kat : "+asansör5.kat);
            System.out.println("hedef : "+ asansör5.hedef);
            
            
            if(asansör5.yön==0){
                System.out.println("yön : yukarı");
            }
            else {              
            System.out.println("yön : aşağı");
            }
            System.out.println("kapasite : "+ 10);
            System.out.println("county inside : "+ (10- asansör5.kapasite));
            System.out.println("[]");
            
            
        Yazi.sleep(100);
        }
    catch(Exception e){
        System.out.println("hata987546");
    }
    
    }
        
    
}
}

class data{
    int giren;
    int cikan;
    boolean flag;
    int avmToplam;
    int kat;
    int asansör;
    int hedef;
    int yön;
    int kapasite;
    int kisisayisi;
    boolean aktif;
    int mod;
    
}