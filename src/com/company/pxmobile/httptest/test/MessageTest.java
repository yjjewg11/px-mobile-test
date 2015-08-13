package com.company.pxmobile.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.SystemConstants;
import com.company.news.json.JSONUtils;
import com.company.news.jsonform.AnnouncementsJsonform;
import com.company.news.jsonform.MessageJsonform;
import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class MessageTest  extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
	  /**
	   * run this testcase as a suite from the command line
	   * @param args - ignored
	   * @throws Exception 
	   */
	  public static void main(String args[]) throws Exception {
	      //junit.textui.TestRunner.run( suite() );
		  MessageTest o=new MessageTest();
	    o.testsaveToTeacher();
	   // o.queryMyTimely();
	  //  o.queryMessageByMy();
	    o.testsaveTosaveToLeader();
	    //o.testLoginFailed();
	   
	  }
	  
	  /**
	   * supply this test cases as part of a suite
	   * @return
	   */
	  public static Test suite() {
	      return new TestSuite( MessageTest.class );
	  }
	  
	  

	  /**
	   * Verifies that submitting the login form without entering a name results in a page
	   * containing the text "Login failed"
	   **/
//	  public void queryMyTimely() throws Exception {
//	      WebConversation     conversation = new WebConversation();
//	      //GetMethodWebRequest
//	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/message/queryMyTimely.json" );
//	      request.setParameter("JSESSIONID",  user.getLoginSessionid());
//	        WebResponse response = tryGetResponse(conversation, request );
////	      WebForm loginForm = response.getForms()[0];
////	      request = loginForm.getRequest();
////	      response = conversation.getResponse( request );
//	        HttpUtils.println(conversation, request, response);
//	        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
//	//
////	      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
//	  }

	  /**
	   * Verifies that submitting the login form without entering a name results in a page
	   * containing the text "Login failed"
	   **/
	  public void queryMessageByMy() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/message/queryByTeacher.json" );
	      request.setParameter("JSESSIONID",  user.getLoginSessionid());
	      request.setParameter("uuid",  "75581b37-49e8-47dc-822c-872747449c57");
		     
	      
	        WebResponse response = tryGetResponse(conversation, request );
//	      WebForm loginForm = response.getForms()[0];
//	      request = loginForm.getRequest();
//	      response = conversation.getResponse( request );
	        HttpUtils.println(conversation, request, response);
	        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
	//
//	      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
	  }

	  /**
	   * Verifies that submitting the login form without entering a name results in a page
	   * containing the text "Login failed"
	   **/
	  public void testsaveToTeacher() throws Exception {
		  WebConversation conversation = new WebConversation();
			// GetMethodWebRequest

			MessageJsonform form = new MessageJsonform();
			form.setMessage("<p>老师你好</p>");
			form.setRevice_useruuid("f14a41fb-22da-48e2-b0b2-22b2ca40d46b");
			String json = JSONUtils.getJsonString(form);
			HttpUtils.printjson(json);
			ByteArrayInputStream input = new ByteArrayInputStream(
					json.getBytes(SystemConstants.Charset));
			PostMethodWebRequest request = new PostMethodWebRequest(
					TestConstants.host + "rest/message/saveToTeacher.json"+user.addParameter_JSESSIONID(), input,
					TestConstants.contentType);

			WebResponse response = tryGetResponse(conversation, request);

			HttpUtils.println(conversation, request, response);
			assertTrue("-成功", response.getText().indexOf("success") != -1);
//	      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
	  }
	  public void testsaveTosaveToLeader() throws Exception {
		  WebConversation conversation = new WebConversation();
			// GetMethodWebRequest

			MessageJsonform form = new MessageJsonform();
			form.setMessage("<p>老师你好</p>");
			form.setRevice_useruuid("group_wj1");
			String json = JSONUtils.getJsonString(form);
			HttpUtils.printjson(json);
			ByteArrayInputStream input = new ByteArrayInputStream(
					json.getBytes(SystemConstants.Charset));
			PostMethodWebRequest request = new PostMethodWebRequest(
					TestConstants.host + "rest/message/saveToLeader.json"+user.addParameter_JSESSIONID(), input,
					TestConstants.contentType);

			WebResponse response = tryGetResponse(conversation, request);

			HttpUtils.println(conversation, request, response);
			assertTrue("-成功", response.getText().indexOf("success") != -1);
//	      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
	  }
}
