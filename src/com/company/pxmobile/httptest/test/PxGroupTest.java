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


public class PxGroupTest extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
  /**
   * run this testcase as a suite from the command line
   * @param args - ignored
   * @throws Exception 
   */
  public static void main(String args[]) throws Exception {
    PxGroupTest o=new PxGroupTest();
    o.testpxlistByPage();
    //o.testGet();
   
  }
  
  /**
   * supply this test cases as part of a suite
   * @return
   */
  public static Test suite() {
      return new TestSuite( PxGroupTest.class );
  }
  

  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
  public void testpxlistByPage() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      //http://120.25.212.44/px-mobile/rest/group/pxlistByPage.json?pageNo=1&map_point=30.603341%2C103.985898
      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/group/pxlistByPage.json" );
      request.setParameter("JSESSIONID",  user.getLoginSessionid());
      request.setParameter("map_point",  "30.603341%2C103.985898");
      request.setParameter("sort",  "distance");
        WebResponse response = tryGetResponse(conversation, request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
  }
  

  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
  public void testGet() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/pxCourse/ba60043b-564b-445f-b78b-d49e2719c079.json"+user.addParameter_JSESSIONID() );
//      request.setParameter("JSESSIONID",  user.getLoginSessionid());
//      request.setParameter("mappoint",  "1,1");
        WebResponse response = tryGetResponse(conversation, request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
  }
}
