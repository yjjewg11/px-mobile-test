package com.company.pxmobile.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.SystemConstants;
import com.company.news.jsonform.ClassRegJsonform;
import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.JSONUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
/**
 * 共享部分测试
 * @author liumingquan
 *
 */
public class ShareTest extends AbstractHttpTest {
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
		
		ShareTest o = new ShareTest();
		o.getHtmlTitle();
//		o.testpxbenefitList();
//		o.testgetPxbenefitJSON();
		//o.testshare_getEmotSuccess();
		//o.testarticleList();
		//o.testgetArticleJSON();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(ShareTest.class);
	}

	public void testpxbenefitList() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/share/pxbenefitList.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构列表-成功", response.getText().indexOf("success") != -1);

	}
	public void testgetPxbenefitJSON() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/share/getPxbenefitJSON.json"+user.addParameter_JSESSIONID()+"&uuid=0398e4af-52d2-41e8-95d3-b70cc8d54cbb");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构列表-成功", response.getText().indexOf("success") != -1);

	}
	public void testarticleList() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/share/articleList.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构列表-成功", response.getText().indexOf("success") != -1);

	}
	public void testgetArticleJSON() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/share/getArticleJSON.json"+user.addParameter_JSESSIONID()+"&uuid=282af78e-898b-452e-9c8b-d802d70c4246");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构列表-成功", response.getText().indexOf("success") != -1);

	}
	
	public void getAnnUrlJSON() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/share/getAnnUrlJSON.json?uuid=225d1b35-4fc2-4db1-9a26-9dc7aabdc30c");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构列表-成功", response.getText().indexOf("success") != -1);

	}
	
	public void getArticleUrlJSON() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/share/getArticleUrlJSON.json?uuid=225d1b35-4fc2-4db1-9a26-9dc7aabdc30c");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构列表-成功", response.getText().indexOf("success") != -1);

	}

	public void testshare_getEmotSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/share/getEmot.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构列表-成功", response.getText().indexOf("success") != -1);

	}
	
	public void testshare_getCourseType() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/share/getCourseType.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构列表-成功", response.getText().indexOf("success") != -1);

	}
	public void getHtmlTitle() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/share/getHtmlTitle.json");
		request.setParameter("url", "https://community.ibeiliao.com/share/post/000I0001/0000CVWd000I0001");
		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构列表-成功", response.getText().indexOf("success") != -1);

	}
	

}
