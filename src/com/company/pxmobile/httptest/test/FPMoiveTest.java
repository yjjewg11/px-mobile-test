package com.company.pxmobile.httptest.test;

import java.io.ByteArrayInputStream;
import java.io.File;

import junit.framework.Test;
import junit.framework.TestSuite;
import net.sf.json.JSONObject;

import com.company.news.SystemConstants;
import com.company.news.json.JSONUtils;
import com.company.news.jsonform.FPFamilyMembersJsonform;
import com.company.news.jsonform.FPMovieJsonform;
import com.company.news.jsonform.FPPhotoItemJsonform;
import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;


public class FPMoiveTest extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
	  
  /**
   * run this testcase as a suite from the command line
   * @param args - ignored
   * @throws Exception 
   */
  public static void main(String args[]) throws Exception {
      //junit.textui.TestRunner.run( suite() );
    FPMoiveTest o=new FPMoiveTest();
    o.testdelete();
//    o.testSaveSuccess();
//    o.testExtra();
//   o.queryOfIncrement();
  // o.queryOfUpdate();
   
  }
  
  /**
   * supply this test cases as part of a suite
   * @return
   */
  public static Test suite() {
      return new TestSuite( FPMoiveTest.class );
  }
  
	  
	  public void testqueryForMovieUuid() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	     // WebRequest  request = new GetMethodWebRequest( "http://120.25.212.44/px-rest/rest/userinfo/getUserinfo.json" );
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/fPPhotoItem/queryForMovieUuid.json" );
	      setCookieBySessionid(request, user.getLoginSessionid());
	      //  request.setParameter("JSESSIONID",  this.sessionid);
	      request.setParameter("movie_uuid",  "1");
	      request.setParameter("movie_uuid",  "a21c1650-154a-4b58-83ae-6b5e9d31d0b9");
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
		 * Verifies that submitting the login form without entering a name results
		 * in a page containing the text "Login failed"
		 **/
		public void testSaveSuccess() throws Exception {
			WebConversation conversation = new WebConversation();
			// GetMethodWebRequest

			FPMovieJsonform s = new FPMovieJsonform();
			s.setUuid("a21c1650-154a-4b58-83ae-6b5e9d31d0b9");
			s.setPhoto_uuids("98513a24-d9e3-44a7-97d2-83489419a0fe,9c418b58-c2e2-473b-a3bf-7919fab8a47b");
			s.setTitle("1");
			
			String json = JSONUtils.getJsonString(s);
			HttpUtils.printjson(json);
			ByteArrayInputStream input = new ByteArrayInputStream(
					json.getBytes(SystemConstants.Charset));
			PostMethodWebRequest request = new PostMethodWebRequest(
					TestConstants.host + "rest/fPMovie/save.json"+user.addParameter_JSESSIONID(), input,
					TestConstants.contentType);

			WebResponse response = tryGetResponse(conversation, request);

			HttpUtils.println(conversation, request, response);
			assertTrue("增加-成功", response.getText().indexOf("success") != -1);

		}
	  public void testGet() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/fPMovie/get.json" );
	      this.setCookieBySessionid(request, user.getLoginSessionid());
	      request.setParameter("uuid", "a21c1650-154a-4b58-83ae-6b5e9d31d0b9");
		     
	      WebResponse response = tryGetResponse(conversation, request );
//	      WebForm loginForm = response.getForms()[0];
//	      request = loginForm.getRequest();
//	      response = conversation.getResponse( request );
	        HttpUtils.println(conversation, request, response);
	        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
	//
//	      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
	  }
	  
	  public void testdelete() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new PostMethodWebRequest( TestConstants.host+"rest/fPMovie/delete.json" );
	      request.setParameter("JSESSIONID",  user.getLoginSessionid());
	      request.setParameter("uuid",  "1");
	        WebResponse response = tryGetResponse(conversation, request );
	        HttpUtils.println(conversation, request, response);
	        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
	  }
	  
}
