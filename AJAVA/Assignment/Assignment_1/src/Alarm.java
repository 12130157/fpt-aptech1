package Assignment1_TuTV_C0808L;


/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2009/7/20
 */

class Alarm
{
	private int hour;
	private int minute;
	private int times;
	private String msg=new String();
	
	public void setHour(int hour)
	{
		this.hour = hour;
	}
	public int getHour()
	{
		return this.hour;
	}
	public int getMinute()
	{
		return this.minute;
	}
	public void setMinute(int minute)
	{
		this.minute = minute;
	}
	public void setTimes(int times)
	{
		this.times=times;
	}
	public int getTimes()
	{
		return this.times;
	}
	public void setMsg(String msg)
	{
		this.msg =msg;
	}
	public String getMsg()
	{
		return this.msg;
	}
	public Alarm(String msg,int times,int h,int m)
	{
			this.msg=msg;
			this.times=times;
			this.hour=h;
			this.minute=m;
	}
}