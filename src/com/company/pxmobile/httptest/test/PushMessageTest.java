package com.company.pxmobile.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.SystemConstants;
import com.company.news.json.JSONUtils;
import com.company.news.jsonform.AnnouncementsJsonform;
import com.company.news.jsonform.MessageJsonform;
import com.company.news.jsonform.TeachingPlanJsonform;
import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class PushMessageTest  extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
	  /**
	   * run this testcase as a suite from the command line
	   * @param args - ignored
	   * @throws Exception 
	   */
	  public static void main(String args[]) throws Exception {
	      //junit.textui.TestRunner.run( suite() );
		  PushMessageTest o=new PushMessageTest();
	  //  o.testsaveToTeacher();
	   // o.queryMyTimely();
	    o.queryMy();
	    o.testreadSuccess();
	   
	  }
	  
	  /**
	   * supply this test cases as part of a suite
	   * @return
	   */
	  public static Test suite() {
	      return new TestSuite( PushMessageTest.class );
	  }
	  
	  
	  public void testreadSuccess() throws Exception {
			WebConversation conversation = new WebConversation();
			// GetMethodWebRequest
			TeachingPlanJsonform t = new TeachingPlanJsonform();


			String json = JSONUtils.getJsonString(t);
			HttpUtils.printjson(json);
			ByteArrayInputStream input = new ByteArrayInputStream(
					json.getBytes(SystemConstants.Charset));
			PostMethodWebRequest request = new PostMethodWebRequest(
					TestConstants.host + "rest/pushMessage/read.json"+user.addParameter_JSESSIONID()+"&uuid=123", input,
					TestConstants.contentType);

			
			WebResponse response = tryGetResponse(conversation, request);

			HttpUtils.println(conversation, request, response);
			assertTrue("增加-成功", response.getText().indexOf("success") != -1);

		}

	  /**
	   * Verifies that submitting the login form without entering a name results in a page
	   * containing the text "Login failed"
	   **/
	  public void queryMy() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/pushMessage/queryMy.json" );
	      request.setParameter("JSESSIONID",  user.getLoginSessionid());
		     
	      
	        WebResponse response = tryGetResponse(conversation, request );
	        HttpUtils.println(conversation, request, response);
	        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
	  }

}
