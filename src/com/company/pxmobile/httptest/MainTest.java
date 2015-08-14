package com.company.pxmobile.httptest;


import com.company.pxmobile.httptest.test.AnnouncementsTest;
import com.company.pxmobile.httptest.test.ClassNewsTest;
import com.company.pxmobile.httptest.test.CookbookPlanTest;
import com.company.pxmobile.httptest.test.DianzanTest;
import com.company.pxmobile.httptest.test.MessageTest;
import com.company.pxmobile.httptest.test.PushMessageTest;
import com.company.pxmobile.httptest.test.ShareTest;
import com.company.pxmobile.httptest.test.StudentSignRecordTest;
import com.company.pxmobile.httptest.test.UserinfoTest;

public class MainTest {

	
	public void doman() throws Exception{
		{
			UserinfoTest.main(null);
			AnnouncementsTest o = new AnnouncementsTest();
			o.testqueryMyAnnouncementsSuccess();
			o.testGetSuccess();
			
		}
	{
			
		CookbookPlanTest o = new CookbookPlanTest();
		o.testListSuccess();
		o.testGetSuccess();
			
		}
		{
			
			ClassNewsTest o=new ClassNewsTest();
			o.testgetClassNewsByMy();
			
		}
		    
		{
			MessageTest o=new MessageTest();
			//o.testsaveToTeacher();
//			o.queryMyTimely();
			o.queryMessageByMy();
		}
		{
			 DianzanTest o=new DianzanTest();
			    o.testgetClassNewsByMy();
		}
		{
			ShareTest o = new ShareTest();
			o.testshare_getEmotSuccess();
			o.testarticleList();
			o.testgetArticleJSON();
		}
		
		{
			PushMessageTest o = new PushMessageTest();
			o.queryMy();
		}
		{
			StudentSignRecordTest o = new StudentSignRecordTest();
			o.testqueryMySuccess();
		}
	}
  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    {
    	
    	int c=400;
    	//c=10;
    	for(int i=0;i<c;i++){
    		   Thread t = new Thread(new Runnable(){  
    	            public void run(){  
	    	           try {
						new MainTest().doman();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	            }});  
    	        t.start();  
    	}
		


    }
  }
}
