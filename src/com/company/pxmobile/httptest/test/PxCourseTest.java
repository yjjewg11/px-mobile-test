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
//    o.testqueryByPage();
    o.testhotByPage();
    o.testGet();
   
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
   * http://120.25.212.44/px-mobile/rest/pxCourse/queryByPage.json
   * ?pageNo=1&mappoint=30.603341%2C103.985898&teacheruuid=&groupuuid=&type=4

   **/
  
  public void testhotByPage() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/pxCourse/hotByPage.json" );
      request.setParameter("JSESSIONID",  user.getLoginSessionid());
      request.setParameter("pageNo",  "1");
//      request.setParameter("map_point",  "-1.0%2C-1.0");
//      request.setParameter("map_point",  "103.985898%2C30.603341");
      request.setParameter("sort",  "distance");
        WebResponse response = tryGetResponse(conversation, request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
  }
  
  public void testqueryByPage() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/pxCourse/queryByPage.json" );
      request.setParameter("JSESSIONID",  user.getLoginSessionid());
//      request.setParameter("map_point",  "-1.0%2C-1.0");
//      request.setParameter("map_point",  "103.985898%2C30.603341");
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
      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/pxCourse/2ef50331-dbe6-4279-9c82-f51d87d2a8bc.json"+user.addParameter_JSESSIONID() );
//      request.setParameter("JSESSIONID",  user.getLoginSessionid());
//      request.setParameter("mappoint",  "1,1");
        WebResponse response = tryGetResponse(conversation, request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
  }
}
