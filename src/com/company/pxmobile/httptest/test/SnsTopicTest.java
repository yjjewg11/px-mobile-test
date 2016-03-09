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


public class SnsTopicTest extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
  /**
   * run this testcase as a suite from the command line
   * @param args - ignored
   * @throws Exception 
   */
  public static void main(String args[]) throws Exception {
    SnsTopicTest o=new SnsTopicTest();
//    o.testqueryByPage();
    o.testhotByPage();
   
  }
  
  /**
   * supply this test cases as part of a suite
   * @return
   */
  public static Test suite() {
      return new TestSuite( SnsTopicTest.class );
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
      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/snsTopic/hotByPage.json" );
      request.setParameter("JSESSIONID",  user.getLoginSessionid());
      request.setParameter("pageNo",  "1");
//      request.setParameter("map_point",  "-1.0%2C-1.0");
//      request.setParameter("map_point",  "103.985898%2C30.603341");
      request.setParameter("sort",  "distance");
        WebResponse response = tryGetResponse(conversation, request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
  }
  
}
