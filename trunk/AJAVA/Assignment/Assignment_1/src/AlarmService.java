package Assignment1_TuTV_C0808L;

/**
 * @(#)Text2.java
 *
 *
 * @author 
 * @version 1.00 2009/7/20
 */

import java.lang.*;
import java.io.*;
class AlarmService extends Thread
{
	Clock clock;
	Alarm alarm;
	public AlarmService(Clock clock,Alarm alarm)
	{
		this.clock=clock;
		this.alarm=alarm;
		System.out.println("Creat a new Clock :"+clock.getHour()+":"+clock.getMinute()+":"+clock.getSecond());
		System.out.println("Creat a new Alarm :"+alarm.getHour()+":"+alarm.getMinute()+"; ring "+alarm.getTimes()+" times");
		System.out.println("Creat a new AlarmService that is a daemon thread");
		System.out.println("The Clock is running...");
		System.out.println("An Alarm Service is running...");
		new Thread(clock).start();
				
	}
	public Boolean check(int cH,int cM,int cS,int aH,int aM,int t)
	{
		int h,m,s,temp;
	//	System.out.println(cH+":"+cM+":"+cS+":"+t);
		temp=t;
		s=temp%60;
		temp=temp/60;
		m=temp%60;
		h=(temp/60);
		if (((cH+h)==aH)&&((cM+m)==aM)&&(cS==s))
			return true;
		else return false;
	}
	public void run()
	{		
		int times =alarm.getTimes();
		do
		{
			
			if (check(clock.getHour(),clock.getMinute(),clock.getSecond(),alarm.getHour(),alarm.getMinute(),alarm.getTimes()-times)&&(times>0))
			{
					System.out.println(alarm.getMsg()+(alarm.getTimes()-times+1));
					times--;
			}     
			try
		    {
		          Thread.sleep(501);		                	                     
		    }
		    catch(InterruptedException ie)
		    {}        
		} while (true);
		
	}
}