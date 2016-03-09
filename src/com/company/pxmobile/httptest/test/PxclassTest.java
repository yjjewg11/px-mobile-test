package com.company.pxmobile.httptest.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;


public class PxclassTest extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
  /**
   * run this testcase as a suite from the command line
   * @param args - ignored
   * @throws Exception 
   */
  public static void main(String args[]) throws Exception {
    PxclassTest o=new PxclassTest();
   // o.listMyChildClassByPage();
   o.testlistclassTeacher();
  }
  
  /**
   * supply this test cases as part of a suite
   * @return
   */
  public static Test suite() {
      return new TestSuite( PxclassTest.class );
  }

	public void testlistclassTeacher() throws Exception {
		
		
		 WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/pxclass/listclassTeacher.json" );
	      request.setParameter("JSESSIONID",  user.getLoginSessionid());
	     request.setParameter("classuuid",  "1be24255-56eb-4a62-b518-aa78b8f6f208");
	      
	      
	        WebResponse response = tryGetResponse(conversation, request );
	        HttpUtils.println(conversation, request, response);
	        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
	        

	}
  public void listMyChildClassByPage() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/pxclass/listMyChildClassByPage.json" );
      request.setParameter("JSESSIONID",  user.getLoginSessionid());
     request.setParameter("isdisable",  "0");
      
      
        WebResponse response = tryGetResponse(conversation, request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
  }
  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
  public void testlistByStudent() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/pxclass/listByStudent.json" );
      request.setParameter("JSESSIONID",  user.getLoginSessionid());
      request.setParameter("student_uuid",  "49fda47a-c224-41e8-8ad4-53dbef749edf");
      
      
      
        WebResponse response = tryGetResponse(conversation, request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
  }
  
  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
  public void testlistByuuids() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/pxclass/listByuuids.json" );
      request.setParameter("JSESSIONID",  user.getLoginSessionid());
      request.setParameter("uuids",  "063ca1ab-426c-4576-a405-da6fb7e7ab9f,063ca1ab-426c-4576-a405-da6fb7e7ab9f");
      
      
        WebResponse response = tryGetResponse(conversation, request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
  }
}
