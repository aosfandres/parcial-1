package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {

	public static void main(String[] args) throws InterruptedException {
		            
		
        int maxPrim = 100;
        PrimeFinder[] hilos = new PrimeFinder[4];// alamacenarhilos 
        
        PrimesResultSet prs = new PrimesResultSet("john");
        
        for (int i = 0; i < 3; i++) {
        	Integer primer = 1 + i * (maxPrim / 4);
            Integer fin;
            if(i != 3){
                 fin = (1 + (i+1) * (maxPrim / 4)) - 1;
            }else{
                fin = maxPrim;
            }
        	
            hilos[i] = new PrimeFinder(new BigInteger(Integer.toString(primer)), new BigInteger(Integer.toString(fin)), prs);
            hilos[i].start();
        }

        for (int i = 0; i < 3; i++) {
            hilos[i].join();
                       
        }
        
        System.out.println("Prime numbers found:");
        System.out.println(prs.getPrimes());

            
            /*while(task_not_finished){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        System.out.println("Idle CPU ");
                    }
                    else{
                        System.out.println("User working again!");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
            
	}
	
}


