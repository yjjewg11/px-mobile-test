package com.company.pxmobile.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.SystemConstants;
import com.company.news.jsonform.CookbookPlanJsonform;
import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.JSONUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class CookbookPlanTest extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
	/**
	 * run this testcase as a suite from the command line
	 * 
	 * @param args
	 *            - ignored
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		// junit.textui.TestRunner.run( suite() );
		
		CookbookPlanTest o = new CookbookPlanTest();
		// o.testRegSuccess();
//		o.testAddSuccess();
//o.testGroupListSuccess();
		//o.testGetSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(CookbookPlanTest.class);
	}




	
	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/cookbookplan/list.json"+user.addParameter_JSESSIONID()
				+"&begDateStr=2015-06-10&endDateStr=2015-08-20&groupuuid=ef3fd53f-03f7-42d6-8258-969a4a980f58");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("列表-成功", response.getText().indexOf("success") != -1);

	}
	
	
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
//	public void testAddSuccess() throws Exception {
//		WebConversation conversation = new WebConversation();
//		// GetMethodWebRequest
//
//		CookbookPlanJsonform form = new CookbookPlanJsonform();
//
//		form.setGroupuuid("group_wj1");
//		form.setPlandateStr("2015-06-13");
//		form.setTime_1("7e74cf4a-cb9b-4007-ad44-d27a4136b66b");
//
//		String json = JSONUtils.getJsonString(form);
//		HttpUtils.printjson(json);
//		ByteArrayInputStream input = new ByteArrayInputStream(
//				json.getBytes(SystemConstants.Charset));
//		PostMethodWebRequest request = new PostMethodWebRequest(
//				TestConstants.host + "rest/cookbookplan/save.json"+user.addParameter_JSESSIONID(), input,
//				TestConstants.contentType);
//
//		WebResponse response = tryGetResponse(conversation, request);
//
//		HttpUtils.println(conversation, request, response);
//		assertTrue("增加-成功", response.getText().indexOf("success") != -1);
//
//	}

	
//	public void testDeleteSuccess() throws Exception {
//		WebConversation conversation = new WebConversation();
//		// GetMethodWebRequest
//
//
//		PostMethodWebRequest request = new PostMethodWebRequest(
//				TestConstants.host + "rest/cookbookplan/delete.json"+user.addParameter_JSESSIONID()
//				+"&uuid=aeb7cedc-eed4-4c38-bf88-a723fd4f7a90");
//
//		WebResponse response = tryGetResponse(conversation, request);
//
//		HttpUtils.println(conversation, request, response);
//		assertTrue("成功", response.getText().indexOf("success") != -1);
//
//	}
	
	public void testGetSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/cookbookplan/0c74bc8e-fe71-42cc-b504-1a5a8cb27245.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}
}
