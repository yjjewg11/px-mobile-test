package com.company.pxmobile.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.SystemConstants;
import com.company.news.jsonform.BaseReplyJsonform;
import com.company.news.jsonform.ClassNewsReplyJsonform;
import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.JSONUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class BaseReplyTest extends AbstractHttpTest {
	static public Integer type=22;
	static public String rel_uuid="rel_uuid";
	
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
		
		BaseReplyTest o = new BaseReplyTest();
		 //o.testDeleteSuccess();
		o.testAddSuccess();
		o.testListSuccess();
		//o.testUpdateSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(BaseReplyTest.class);
	}

	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testAddSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		BaseReplyJsonform form = new BaseReplyJsonform();
		//form.setNewsuuid("8076abe8-c5b7-430d-ab6e-dbe441dbf64e");
		form.setContent("第一条回复额111");
		form.setRel_uuid(rel_uuid);
		form.setType(type);


		String json = JSONUtils.getJsonString(form);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/baseReply/save.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}
	
	
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testUpdateSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		BaseReplyJsonform form = new BaseReplyJsonform();
		//form.setNewsuuid("8076abe8-c5b7-430d-ab6e-dbe441dbf64e");
		form.setContent("第一条回复额111");
		form.setRel_uuid("123");
		form.setType(type);

		String json = JSONUtils.getJsonString(form);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/baseReply/save.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);
	}

	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/baseReply/queryByRel_uuid.json"+user.addParameter_JSESSIONID()
				+"&pageNo=1&pageSize=10&rel_uuid="+rel_uuid+"&type="+type);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("列表-成功", response.getText().indexOf("success") != -1);

	}
	
	

	
	
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testDeleteSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/reply/delete.json"+user.addParameter_JSESSIONID()+
				"&uuid=d7a0140f-2547-45f1-97b0-1ea7eb7a9045");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("删除-成功", response.getText().indexOf("success") != -1);

	}
	

}
