package Assignment1_TuTV_C0808L;

/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2009/7/20
 */

import java.lang.*;
import java.io.*;
class Clock implements Runnable
{
	private int hour;
	private int minute;
	private int second;
	public Clock(int h,int m,int s)
	{
		this.hour=h;
		this.minute=m;
		this.second=s;
	}
	public void setHour(int hour)
	{
		this.hour=hour;
	}
	public void setMinute(int minute)
	{
		this.minute=minute;
	}
	public void setSecond(int second)
	{
		this.second=second;
	}
	public int getHour()
	{
		return this.hour;
	}
	public int getMinute()
	{
		return this.minute;
	}
	public int getSecond()
	{
		return this.second;
	}
	public void run()
	{
			do
			{
				System.out.println("-"+this.hour+":"+this.minute+":"+this.second);
				if (this.second>=59)
				{
					this.second-=60;
					this.minute++;	
				}
				if (this.minute>=60) 
				{
					this.minute -= 60;
					this.hour++;
				}
				if (this.hour >=24) this.hour-=24;
				try
		          {
		                Thread.sleep(1000);		                	                     
		          }
		          catch(InterruptedException ie)
		          {
		          
		          }
				this.second++;										
			} while (true);
	}
	
}