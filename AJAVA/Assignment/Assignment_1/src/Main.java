package Assignment1_TuTV_C0808L;

/**
 * @(#)Assignment_1.java
 *
 * Assignment_1 application
 *
 * @author 
 * @version 1.00 2009/7/20
 */
 
public class Main {
    
    public static void main(String[] args) {
    	
    	// TODO, add your application code
		int cHour,cMinute,cSecond,aHour,aMinute,aTimes;
		String aMsg = new String();
		cHour=1;
		cMinute=59;
		cSecond=57;
		aHour=2;
		aMinute=0;
		aTimes=5;
		aMsg="ring ring ring...";
		Clock clock = new Clock(cHour,cMinute,cSecond);
		Alarm alarm = new Alarm(aMsg,aTimes,aHour,aMinute);
		if (aTimes<=0)
		{
			System.out.println("Times of Alarm ~0.Nothing to do!!!");
		}
		else
		{
			AlarmService as = new AlarmService(clock,alarm);
			as.setDaemon(true);
			as.start(); 
		}
    }
}
