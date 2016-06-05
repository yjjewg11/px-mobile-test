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


public class UserThirdWeixinQQTest extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
  /**
   * run this testcase as a suite from the command line
   * @param args - ignored
   * @throws Exception 
   */
  public static void main(String args[]) throws Exception {
      //junit.textui.TestRunner.run( suite() );
    UserThirdWeixinQQTest o=new UserThirdWeixinQQTest();
  //  o.testSaveSuccess();
    o.testAccess_token();
   
  }
  
  /**
   * supply this test cases as part of a suite
   * @return
   */
  public static Test suite() {
      return new TestSuite( UserThirdWeixinQQTest.class );
  }
  


  
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testSaveSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		FPFamilyPhotoCollectionJsonform s = new FPFamilyPhotoCollectionJsonform();

		s.setTitle("7996家庭相册");

		String json = JSONUtils.getJsonString(s);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/fpFamilyPhotoCollection/save.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		request.setParameter("code", "OezXcEiiBSKSxW0eoylIeLALYYBatjv307wIvicRaf92ygZ8VCJCvhr40dqfcrGe3eJxh31cDK44fP3JCG7nPEF-bVfDMJw3K_u5plliQZ9EqdyQ4fEr5xcztfz4WGDv8RCQ6JOp-ozFw6UR-5E6yg");
		
		request.setParameter("appid", "wx6699cf8b21e12618-bVfDMJw3K_u5plliQZ9EqdyQ4fEr5xcztfz4WGDv8RCQ6JOp-ozFw6UR-5E6yg");
		
		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("增加-成功", response.getText().indexOf("success") != -1);

	}
	
	  /**
	   * Verifies that submitting the login form without entering a name results in a page
	   * containing the text "Login failed"
	   **/
	  public void testAccess_token() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/userThirdLoginWenXin/access_token.json" );
	      request.setParameter("access_token", "OezXcEiiBSKSxW0eoylIeLALYYBatjv307wIvicRaf92ygZ8VCJCvhr40dqfcrGe6jF8D7YjG1DDQ8c_od0JaSKUZAEEzQkeyizbzDIBTmwGgYK5llWZthPCiB4izERzuqj5whKmcR7Zuh8MAL_hwQ");
			
			request.setParameter("appid", "wx6699cf8b21e12618");
			request.setParameter("openid", "oshPAv6p5Hs8iSL-3pcr4cSuVgJw");
			
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
	  public void testQuery() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/fPMovie/query.json" );
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
