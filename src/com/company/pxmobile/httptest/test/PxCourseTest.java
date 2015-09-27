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


public class PxCourseTest extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
  /**
   * run this testcase as a suite from the command line
   * @param args - ignored
   * @throws Exception 
   */
  public static void main(String args[]) throws Exception {
    PxCourseTest o=new PxCourseTest();
    o.testlistByStudent();
   
  }
  
  /**
   * supply this test cases as part of a suite
   * @return
   */
  public static Test suite() {
      return new TestSuite( PxCourseTest.class );
  }
  

  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
  public void testlistByStudent() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/pxCourse/list.json" );
      request.setParameter("JSESSIONID",  user.getLoginSessionid());
      request.setParameter("JSESSIONID",  user.getLoginSessionid());
        WebResponse response = tryGetResponse(conversation, request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
  }
}