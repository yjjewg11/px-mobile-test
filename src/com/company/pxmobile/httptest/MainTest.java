package com.company.pxmobile.httptest;


import com.company.pxmobile.httptest.test.AnnouncementsTest;
import com.company.pxmobile.httptest.test.ClassNewsTest;
import com.company.pxmobile.httptest.test.DianzanTest;
import com.company.pxmobile.httptest.test.MessageTest;
import com.company.pxmobile.httptest.test.ShareTest;
import com.company.pxmobile.httptest.test.UserinfoTest;

public class MainTest {

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    {
		{
			UserinfoTest.main(null);
			AnnouncementsTest o = new AnnouncementsTest();
			o.testListSuccess();
			o.testGetSuccess();
			
		}
		{
			
			ClassNewsTest o=new ClassNewsTest();
			o.testgetClassNewsByMy();
			
		}
		    
		{
			MessageTest o=new MessageTest();
			o.testsaveToTeacher();
			o.queryMyTimely();
			o.queryMessageByMy();
		}
		{
			 DianzanTest o=new DianzanTest();
			    o.testgetClassNewsByMy();
		}
		{
			ShareTest o = new ShareTest();
			o.testshare_getEmotSuccess();
		}


    }
  }
}
