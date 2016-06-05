package com.company.pxmobile.httptest.test;

import java.io.ByteArrayInputStream;
import java.io.File;

import junit.framework.Test;
import junit.framework.TestSuite;
import net.sf.json.JSONObject;

import com.company.news.SystemConstants;
import com.company.news.json.JSONUtils;
import com.company.news.jsonform.FPPhotoItemJsonform;
import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;


public class FPPhotoItemTest extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
	  
  /**
   * run this testcase as a suite from the command line
   * @param args - ignored
   * @throws Exception 
   */
  public static void main(String args[]) throws Exception {
      //junit.textui.TestRunner.run( suite() );
    FPPhotoItemTest o=new FPPhotoItemTest();
//    o.testqueryForMovieUuid();
   // o.testdeleteFavorites();
//    o.testExtra();
    o.testdelete();
    //o.testSaveSuccess();
//   o.queryOfIncrement();
  // o.queryOfUpdate();
   
  }
  
  /**
   * supply this test cases as part of a suite
   * @return
   */
  public static Test suite() {
      return new TestSuite( FPPhotoItemTest.class );
  }
  
  public void testupload() throws Exception {
		String url = TestConstants.host + "rest/fPPhotoItem/upload.json"
				+ user.addParameter_JSESSIONID();
		uploadImg(url);
	}

  public void uploadImg(String url) throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		File file = new File("C:/Users/liumingquan/Pictures/6176b05e-4fdf-4963-a340-abd06c332d42_134x100.jpg");

		// WebForm webForm=new WebForm();

		PostMethodWebRequest request = new PostMethodWebRequest(url, true);
		request.selectFile("file", file);
		request.setParameter("family_uuid", "2be0f0bd-989b-4616-9bc3-66d6c5fe9a92");
		request.setParameter("address", "123");
		request.setParameter("noet", "1234");
		WebResponse response = tryGetResponse(conversation, request);
		HttpUtils.println(conversation, request, response);
		
		assertTrue("成功", response.getText().indexOf("success") != -1);
		if (response.getContentType().equals("application/json")) {
			JSONObject jsonObject = JSONObject.fromObject(response.getText());
		}
	}
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testSaveSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		FPPhotoItemJsonform s = new FPPhotoItemJsonform();
		s.setUuid("1");
		s.setNote("123");
		s.setAddress("tt");

		String json = JSONUtils.getJsonString(s);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/fPPhotoItem/save.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("增加-成功", response.getText().indexOf("success") != -1);

	}
	
	  /**
	   * Verifies that submitting the login form without entering a name results in a page
	   * containing the text "Login failed"
	   **/
	  public void testQueryMy() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/fPPhotoItem/queryMy.json" );
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
	  /**
	   * Verifies that submitting the login form without entering a name results in a page
	   * containing the text "Login failed"
	   **/
	  public void queryOfUpdate() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/fPPhotoItem/queryOfUpdate.json" );
	      request.setParameter("JSESSIONID",  user.getLoginSessionid());
	      request.setParameter("maxTime",  "2016-01-20-10-11-22");
	      request.setParameter("minTime",  "2016-01-10-10-11-22");
	      request.setParameter("family_uuid",  "2be0f0bd-989b-4616-9bc3-66d6c5fe9a92");
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
	  public void queryOfIncrement() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      
	      //http://120.25.212.44/px-mobile/rest/fPPhotoItem/queryOfIncrement.json
	      //?maxTime=2016-01-30-20-40-25
	      //&minTime=&
	      //family_uuid=2be0f0bd-989b-4616-9bc3-66d6c5fe9a92
	      //&updateTime=2016-03-09-04-31-18
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/fPPhotoItem/queryOfIncrement.json" );
	      request.setParameter("JSESSIONID",  user.getLoginSessionid());
	      request.setParameter("maxTime",  "2016-01-30-20-40-25");
	      //request.setParameter("minTime",  "2016-01-10-10-11-22");
	     request.setParameter("updateTime",  "2016-03-09-04-31-18");//127
	      request.setParameter("family_uuid",  "2be0f0bd-989b-4616-9bc3-66d6c5fe9a92");
		    
	     
//	      request.setParameter("family_uuid",  "f7317682-70aa-4ce1-9ce3-34925c1617b3");//44
	      request.setParameter("pageNo",  "1");
	        WebResponse response = tryGetResponse(conversation, request );
//	      WebForm loginForm = response.getForms()[0];
//	      request = loginForm.getRequest();
//	      response = conversation.getResponse( request );
	        HttpUtils.println(conversation, request, response);
	        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
	//
//	      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
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
	  
	  
	  
	  public void testGet() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/fPPhotoItem/1.json" );
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
	  
	  
	  public void testExtra() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/fPPhotoItem/extra.json" );
	      request.setParameter("JSESSIONID",  user.getLoginSessionid());
	      request.setParameter("uuid", TestConstants.FPPhotoItem_uuid);
		     
	      WebResponse response = tryGetResponse(conversation, request );
//	      WebForm loginForm = response.getForms()[0];
//	      request = loginForm.getRequest();
//	      response = conversation.getResponse( request );
	        HttpUtils.println(conversation, request, response);
	        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
	//
//	      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
	  }
	  
	  public void testaddFavorites() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new PostMethodWebRequest( TestConstants.host+"rest/fPPhotoItem/addFavorites.json" );
	      request.setParameter("JSESSIONID",  user.getLoginSessionid());
	      request.setParameter("uuid",  "1");
	        WebResponse response = tryGetResponse(conversation, request );
	        HttpUtils.println(conversation, request, response);
	        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
	  }
	  
	  public void testdeleteFavorites() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new PostMethodWebRequest( TestConstants.host+"rest/fPPhotoItem/deleteFavorites.json" );
	      request.setParameter("JSESSIONID",  user.getLoginSessionid());
	      request.setParameter("uuid",  "1");
	        WebResponse response = tryGetResponse(conversation, request );
	        HttpUtils.println(conversation, request, response);
	        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
	  }
	  
	  public void testdelete() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new PostMethodWebRequest( TestConstants.host+"rest/fPPhotoItem/delete.json" );
	      request.setParameter("JSESSIONID",  user.getLoginSessionid());
	      request.setParameter("uuid",  "1");
	        WebResponse response = tryGetResponse(conversation, request );
	        HttpUtils.println(conversation, request, response);
	        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
	  }
	  
}
