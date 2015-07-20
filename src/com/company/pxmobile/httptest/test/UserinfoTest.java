package com.company.pxmobile.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;
import net.sf.json.JSONObject;

import com.company.news.SystemConstants;
import com.company.news.jsonform.ParentRegJsonform;
import com.company.news.jsonform.UserRegJsonform;
import com.company.news.rest.util.MD5Until;
import com.company.pxmobile.httptest.AbstractHttpTest;
import com.company.pxmobile.httptest.HttpUtils;
import com.company.pxmobile.httptest.JSONUtils;
import com.company.pxmobile.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;


public class UserinfoTest extends AbstractHttpTest {
  
  public String sessionid=null;
  
  public String getLoginSessionid() throws Exception {
    if(this.sessionid==null){
      testLoginSuccess();
    }
    return sessionid;
  }
  //13628037996,13628037994
  static public String tel="13628037995";
  /**
   * run this testcase as a suite from the command line
   * @param args - ignored
   * @throws Exception 
   */
  public static void main(String args[]) throws Exception {
      //junit.textui.TestRunner.run( suite() );
    UserinfoTest o=new UserinfoTest();
    o.testAddSuccess();
    o.testLoginSuccess();
//    o.testgetUserInfoSuccess();
    //o.testLoginFailed();
    //o.testUpdateSuccess();
    o.testlistByMyChildrenuccess();
   
  }
  
  /**
   * supply this test cases as part of a suite
   * @return
   */
  public static Test suite() {
      return new TestSuite( UserinfoTest.class );
  }
  

  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
  public void testRegSuccess() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      ParentRegJsonform form =new ParentRegJsonform();

      form.setTel(tel);
      String password="123456";
      form.setPassword(MD5Until.getMD5String(password));
      form.setType(2);
  
      String json=JSONUtils.getJsonString(form);
      HttpUtils.printjson(json);
      ByteArrayInputStream input=new ByteArrayInputStream(json.getBytes(SystemConstants.Charset));
      PostMethodWebRequest  request = new PostMethodWebRequest( TestConstants.host+"rest/userinfo/reg.json",input,TestConstants.contentType );

      WebResponse response = tryGetResponse(conversation, request );
       
      HttpUtils.println(conversation, request, response);
      assertTrue( "注册-成功", response.getText().indexOf( "success" ) != -1 );
      
  }

  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
  public void testLoginFailed() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      WebRequest  request = new PostMethodWebRequest( TestConstants.host+"rest/userinfo/login.json?loginname="+"xxx"+"&password="+MD5Until.getMD5String("123456") );
        WebResponse response = tryGetResponse(conversation, request );
//      WebForm loginForm = response.getForms()[0];
//      request = loginForm.getRequest();
//      response = conversation.getResponse( request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-失败", response.getText().indexOf( "failed" ) != -1 );
        }
  

  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
  public void testLoginSuccess() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      WebRequest  request = new PostMethodWebRequest( TestConstants.host+"rest/userinfo/login.json?loginname="+tel+"&password="+MD5Until.getMD5String("123456") );
        WebResponse response = tryGetResponse(conversation, request );
//      WebForm loginForm = response.getForms()[0];
//      request = loginForm.getRequest();
//      response = conversation.getResponse( request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
        
        
      if (response.getContentType().equals("application/json")) {
        JSONObject jsonObject = JSONObject.fromObject(response.getText());
        this.sessionid=(String)jsonObject.get("JSESSIONID");
        //System.out.println("JSESSIONID="+this.sessionid); // Benju
       }
//
//      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
  }
  
  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
  public void testgetUserInfoSuccess() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/userinfo/getUserinfo.json" );
      request.setParameter("JSESSIONID",  this.sessionid);
        WebResponse response = tryGetResponse(conversation, request );
//      WebForm loginForm = response.getForms()[0];
//      request = loginForm.getRequest();
//      response = conversation.getResponse( request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
        
        
      if (response.getContentType().equals("application/json")) {
        JSONObject jsonObject = JSONObject.fromObject(response.getText());
        this.sessionid=(String)jsonObject.get("JSESSIONID");
        System.out.println("JSESSIONID="+this.sessionid); // Benju
       }
//
//      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
  }
  
  
  public void testlistByMyChildrenuccess() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      WebRequest  request = new GetMethodWebRequest( TestConstants.host+"rest/student/listByMyChildren.json" );
      request.setParameter("JSESSIONID",  this.getLoginSessionid());
        WebResponse response = tryGetResponse(conversation, request );
//      WebForm loginForm = response.getForms()[0];
//      request = loginForm.getRequest();
//      response = conversation.getResponse( request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
        
        
      if (response.getContentType().equals("application/json")) {
        JSONObject jsonObject = JSONObject.fromObject(response.getText());
        this.sessionid=(String)jsonObject.get("JSESSIONID");
        System.out.println("JSESSIONID="+this.getLoginSessionid()); // Benju
       }
//
//      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
  }
  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
  public void testlogoutSuccess() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      WebRequest  request = new PostMethodWebRequest( TestConstants.host+"rest/userinfo/logout.json"+this.addParameter_JSESSIONID());
        WebResponse response = tryGetResponse(conversation, request );
//      WebForm loginForm = response.getForms()[0];
//      request = loginForm.getRequest();
//      response = conversation.getResponse( request );
        HttpUtils.println(conversation, request, response);
        assertTrue( "成功", response.getText().indexOf( "success" ) != -1 );
  }
  public String addParameter_JSESSIONID() throws Exception {
    return "?JSESSIONID="+this.getLoginSessionid();
  }

  public void setSessionid(String sessionid) {
    this.sessionid = sessionid;
  }
  
  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
  public void testAddSuccess() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      UserRegJsonform form =new UserRegJsonform();
      form.setName("jbb");
      form.setGroup_uuid("testuuid");
      form.setTel(tel);
      String password="123456";
      form.setPassword(MD5Until.getMD5String(password));
      form.setType(0);
  
      String json=JSONUtils.getJsonString(form);
      HttpUtils.printjson(json);
      ByteArrayInputStream input=new ByteArrayInputStream(json.getBytes(SystemConstants.Charset));
      PostMethodWebRequest  request = new PostMethodWebRequest( TestConstants.host+"rest/userinfo/reg.json",input,TestConstants.contentType );

      WebResponse response = tryGetResponse(conversation, request );
       
      HttpUtils.println(conversation, request, response);
      assertTrue( "新增-成功", response.getText().indexOf( "status" ) != -1 );
      
  }
  
  
  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/group/list.json"+this.addParameter_JSESSIONID()+"&groupuuid=004739cb-856b-4fd0-bfa2-8f352561ebf7");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("列表-成功", response.getText().indexOf("success") != -1);

	}
	
	
	public void testUpdateSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		String disable="1";
			String useruuid="a72b47d9-ee14-4edc-8f3b-7d034da39715";
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/userinfo/updateDisable.json"+this.addParameter_JSESSIONID()+
				"&useruuids="+useruuid+"&disable="+disable);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("修改-成功", response.getText().indexOf("success") != -1);

	}
}
