package com;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CardnumberGene {
	public static String cardnumber;
	Calendar calendar;
	//自动生成卡号,使  用util.Date类生成
		public String geneCard(String birthday){
			Date nowTime = new Date();
			SimpleDateFormat matter1 = new SimpleDateFormat("yyyyMMdd");
			String str = matter1.format(nowTime);
			//System.out.println(str+birthday);
			return str+birthday;
		}
		//校验生成最后一位
		public String getCheck(String cardnumber){
			char c[] = cardnumber.toCharArray();
			int a[] = new int[c.length+1];
			for(int i = 0; i < c.length;i++)
			{
				
				if(c.length%2 == 0){
					if(i%2 == 1)
					{
						String b = String.valueOf(c[i]);
						int d = Integer.parseInt(b)*2;
						if(d > 9)
							{   
								a[i] = 1+d-10;
							}
						else
							a[i] = d;
					}
					else
						{a[i] = Integer.parseInt(String.valueOf(c[i]));
						}
				}
				else
				{
					if(i%2 == 1)
					{
						String b = String.valueOf(c[i]);
						int d = Integer.parseInt(b)*2;
						if(d > 9)
							a[i] = 1+d-10;
						else
							a[i] = d;
					}
					else
						{a[i] = Integer.parseInt(String.valueOf(c[i]));
						}
				}
			}
			int sumdigit = 0;
			for(int i = 0;i<a.length;i++)
			{
				sumdigit += a[i];
			}
			int x = (sumdigit*9)%10;
			a[a.length-1] = x;
			String p = cardnumber+x;
			return p;
		}
}