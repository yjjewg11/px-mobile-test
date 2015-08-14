package com.company.pxmobile.httptest.test;

import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class SmsTest extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
/**
 * run this testcase as a suite from the command line
 * @param args - ignored
 * @throws Exception 
 */
public static void main(String args[]) throws Exception {
    //junit.textui.TestRunner.run( suite() );
	SmsTest o=new SmsTest();
  o.testsendCode();
  //o.testgetUserInfoSuccess();
  //o.testLoginFailed();
 
}

/**
 * Verifies that submitting the login form without entering a name results in a page
 * containing the text "Login failed"
 **/
public void testsendCode() throws Exception {
    WebConversation     conversation = new WebConversation();
    //GetMethodWebRequest
    WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/sms/sendCode.json" );
   // request.setParameter("JSESSIONID",  user.getLoginSessionid());
    request.setParameter("tel",  "13628037994");
    request.setParameter("type",  "2");
    WebResponse response = tryGetResponse(conversation, request );
    HttpUtils.println(conversation, request, response);
    assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );

	}

}
