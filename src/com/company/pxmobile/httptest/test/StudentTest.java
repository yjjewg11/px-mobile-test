package com.company.pxmobile.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.SystemConstants;
import com.company.news.json.JSONUtils;
import com.company.news.jsonform.StudentJsonform;
import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class StudentTest extends AbstractHttpTest {
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
		
		StudentTest o = new StudentTest();
		 o.testAddSuccess();
		//o.testMyListSuccess();
      //  o.testSaveSuccess();
//		o.getClassHeaderTeacher();
       // o.testSaveSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(StudentTest.class);
	}



	
	
	public void getClassHeaderTeacher() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/student/getClassHeaderTeacher.json"+user.addParameter_JSESSIONID()
				+"&classuuid=e1591749-3551-410d-91e3-b6f3151fdeae");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构-成功", response.getText().indexOf("success") != -1);

	}
	

	
	
	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/student/getStudentByClassuuid.json"+user.addParameter_JSESSIONID()
				+"&classuuid=e1591749-3551-410d-91e3-b6f3151fdeae");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构-成功", response.getText().indexOf("success") != -1);

	}
	
	public void testGetSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/student/6828eb86-c345-4af2-9fa5-02b4b35d29b2.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}
	
	
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testSaveSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		StudentJsonform s = new StudentJsonform();

		s.setName("成都市青羊区1");
		s.setClassuuid("e1591749-3551-410d-91e3-b6f3151fdeae");
		s.setUuid("6b7e972c-432d-4ad7-bba2-abda8863c9a1");
		s.setNickname("小甜甜");
		s.setHeadimg("http://120.25.248.31/px-rest/rest/uploadFile/getImgFile.json?uuid=d8a08ca3-b823");
		String json = JSONUtils.getJsonString(s);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/student/save.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("增加-成功", response.getText().indexOf("success") != -1);

	}
	

	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testAddSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		StudentJsonform s = new StudentJsonform();

		s.setName("成都市青羊区1");
		s.setClassuuid("e1591749-3551-410d-91e3-b6f3151fdeae");
		//s.setUuid("6b7e972c-432d-4ad7-bba2-abda8863c9a1");
		s.setNickname("小甜甜");
		s.setMa_tel("13628037994");
		s.setHeadimg("http://120.25.248.31/px-rest/rest/uploadFile/getImgFile.json?uuid=d8a08ca3-b823");
		String json = JSONUtils.getJsonString(s);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/student/add.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("增加-成功", response.getText().indexOf("success") != -1);

	}

}
