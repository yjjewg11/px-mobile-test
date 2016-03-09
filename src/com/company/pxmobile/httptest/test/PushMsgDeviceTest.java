package com.company.pxmobile.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.SystemConstants;
import com.company.news.json.JSONUtils;
import com.company.news.jsonform.PushMsgDeviceJsonform;
import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

public class PushMsgDeviceTest  extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
	  /**
	   * run this testcase as a suite from the command line
	   * @param args - ignored
	   * @throws Exception 
	   */
	  public static void main(String args[]) throws Exception {
	      //junit.textui.TestRunner.run( suite() );
		  PushMsgDeviceTest o=new PushMsgDeviceTest();
	    o.testsave();
	    //o.testLoginFailed();
	   
	  }
	  
	  /**
	   * supply this test cases as part of a suite
	   * @return
	   */
	  public static Test suite() {
	      return new TestSuite( PushMsgDeviceTest.class );
	  }
	  
	
	  /**
	   * Verifies that submitting the login form without entering a name results in a page
	   * containing the text "Login failed"
	   **/
	  public void testsave() throws Exception {
		  WebConversation conversation = new WebConversation();
			// GetMethodWebRequest

		  PushMsgDeviceJsonform form = new PushMsgDeviceJsonform();
			form.setDevice_id("123");
			form.setDevice_type("ios");
			form.setStatus(2);
			String json = JSONUtils.getJsonString(form);
			HttpUtils.printjson(json);
			ByteArrayInputStream input = new ByteArrayInputStream(
					json.getBytes(SystemConstants.Charset));
			PostMethodWebRequest request = new PostMethodWebRequest(
					TestConstants.host + "rest/pushMsgDevice/save.json"+user.addParameter_JSESSIONID(), input,
					TestConstants.contentType);

			WebResponse response = tryGetResponse(conversation, request);

			HttpUtils.println(conversation, request, response);
			assertTrue("-成功", response.getText().indexOf("success") != -1);
//	      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
	  }
}
