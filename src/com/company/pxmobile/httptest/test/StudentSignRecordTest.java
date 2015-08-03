package com.company.pxmobile.httptest.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class StudentSignRecordTest extends AbstractHttpTest {
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
		
		StudentSignRecordTest o = new StudentSignRecordTest();
		// o.testRegSuccess();
		o.testqueryMySuccess();
        //o.testSaveSuccess();
		//o.testGetSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(StudentSignRecordTest.class);
	}




	
	
	public void testqueryMySuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/studentSignRecord/queryMy.json"+user.addParameter_JSESSIONID()//+"&studentuuid=123"
				);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构-成功", response.getText().indexOf("success") != -1);

	}
	

}
