package com.company.pxmobile.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.SystemConstants;
import com.company.news.json.JSONUtils;
import com.company.news.jsonform.FPFamilyPhotoCollectionJsonform;
import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;


public class EZCameraTest extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
  /**
   * run this testcase as a suite from the command line
   * @param args - ignored
   * @throws Exception 
   */
  public static void main(String args[]) throws Exception {
      //junit.textui.TestRunner.run( suite() );
    EZCameraTest o=new EZCameraTest();
  //  o.testSaveSuccess();
    o.testgetAccessToken();
   o.testgetCameraList();
  }
  
  /**
   * supply this test cases as part of a suite
   * @return
   */
  public static Test suite() {
      return new TestSuite( EZCameraTest.class );
  }
  


	
	  /**
	   * Verifies that submitting the login form without entering a name results in a page
	   * containing the text "Login failed"
	   **/
	  public void testgetCameraList() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/eZCamera/getCameraList.json" );
	      request.setParameter("JSESSIONID",  user.getLoginSessionid());
	        WebResponse response = tryGetResponse(conversation, request );
//	      WebForm loginForm = response.getForms()[0];
//	      request = loginForm.getRequest();
//	      response = conversation.getResponse( request );
	        HttpUtils.println(conversation, request, response);
	        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
	//
//	      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
	  }
	  
	  public void testgetAccessToken() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/eZCamera/getAccessToken.json" );
	      request.setParameter("JSESSIONID",  user.getLoginSessionid());
	        WebResponse response = tryGetResponse(conversation, request );
//	      WebForm loginForm = response.getForms()[0];
//	      request = loginForm.getRequest();
//	      response = conversation.getResponse( request );
	        HttpUtils.println(conversation, request, response);
	        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
	//
//	      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
	  }
	  
}
