package com.company.pxmobile.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.SystemConstants;
import com.company.news.jsonform.TeachingPlanJsonform;
import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.JSONUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class PxTeachingPlanTest extends AbstractHttpTest {
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
		
		PxTeachingPlanTest o = new PxTeachingPlanTest();
		 o.nextListSuccess();
//	o.listAllByclassuuid();
//o.testListSuccess();
	//	o.testGetSuccess();
	}

	
	public void listAllByclassuuid() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/pxteachingplan/listAllByclassuuid.json");

		  request.setParameter("JSESSIONID",  user.getLoginSessionid());
		 request.setParameter("classuuid",  "1be24255-56eb-4a62-b518-aa78b8f6f208");
		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("列表-成功", response.getText().indexOf("success") != -1);

	}
	public void nextListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/pxteachingplan/nextList.json"+user.addParameter_JSESSIONID());
		
		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("列表-成功", response.getText().indexOf("success") != -1);

	}
	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(PxTeachingPlanTest.class);
	}




	
	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/pxteachingplan/list.json"+user.addParameter_JSESSIONID()
				+"&begDateStr=2015-09-25&endDateStr=2015-09-25&classuuid=classuuid1");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("列表-成功", response.getText().indexOf("success") != -1);

	}
	
	
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testAddSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		TeachingPlanJsonform t = new TeachingPlanJsonform();

		t.setAfternoon("aaaa");
		t.setClassuuid("51a05579-cf42-42aa-aafc-4ef0a520e1e8");
		t.setMorning("cccc");
		t.setPlandateStr("2015-06-18");
		

		String json = JSONUtils.getJsonString(t);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/teachingplan/save.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		
		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("增加-成功", response.getText().indexOf("success") != -1);

	}

	
	public void testDeleteSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest


		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/teachingplan/delete.json"+user.addParameter_JSESSIONID()
				+"&uuid=aeb7cedc-eed4-4c38-bf88-a723fd4f7a90");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}
	
	public void testGetSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/teachingplan/b0c2ae0b-0ab6-4d14-83bd-1907bc699eba.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}
}
