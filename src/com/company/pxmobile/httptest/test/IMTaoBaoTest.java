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


public class IMTaoBaoTest extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
  /**
   * run this testcase as a suite from the command line
   * @param args - ignored
   * @throws Exception 
   */
  public static void main(String args[]) throws Exception {
      //junit.textui.TestRunner.run( suite() );
    IMTaoBaoTest o=new IMTaoBaoTest();
  //  o.testSaveSuccess();
    o.testgetMyLoginUser();
   
  }
  
  /**
   * supply this test cases as part of a suite
   * @return
   */
  public static Test suite() {
      return new TestSuite( IMTaoBaoTest.class );
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
		s.setUuid("f5027a6f-fe18-4954-ba47-a48c3ef1c1ce");
		String json = JSONUtils.getJsonString(s);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/fpFamilyPhotoCollection/save.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("增加-成功", response.getText().indexOf("success") != -1);

	}
	
	  /**
	   * Verifies that submitting the login form without entering a name results in a page
	   * containing the text "Login failed"
	   **/
	  public void testgetMyLoginUser() throws Exception {
	      WebConversation     conversation = new WebConversation();
	      //GetMethodWebRequest
	      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/im/getMyLoginUser.json" );
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
