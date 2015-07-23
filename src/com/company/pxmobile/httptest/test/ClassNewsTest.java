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


public class ClassnewsTest extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
  /**
   * run this testcase as a suite from the command line
   * @param args - ignored
   * @throws Exception 
   */
  public static void main(String args[]) throws Exception {
      //junit.textui.TestRunner.run( suite() );
    ClassnewsTest o=new ClassnewsTest();
    o.testgetClassNewsByMy();
    //o.testgetUserInfoSuccess();
    //o.testLoginFailed();
   
  }
  
  /**
   * supply this test cases as part of a suite
   * @return
   */
  public static Test suite() {
      return new TestSuite( ClassnewsTest.class );
  }
  

  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
  public void testgetClassNewsByMy() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/classnews/getClassNewsByMy.json" );
      request.setParameter("JSESSIONID",  user.getLoginSessionid());
        WebResponse response = tryGetResponse(conversation, request );
//      WebForm loginForm = response.getForms()[0];
//      request = loginForm.getRequest();
//      response = conversation.getResponse( request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
//
//      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
  }
}
