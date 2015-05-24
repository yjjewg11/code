package com.company.ruanman.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.Constants;
import com.company.news.jsonform.TrainingPlanJsonform;
import com.company.news.rest.RestConstants;
import com.company.news.rest.util.TimeUtils;
import com.company.ruanman.httptest.AbstractHttpTest;
import com.company.ruanman.httptest.HttpUtils;
import com.company.ruanman.httptest.JSONUtils;
import com.company.ruanman.httptest.TestConstants;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

public class TraningPlanTest  extends AbstractHttpTest {
  
  public UserinfoTest user=new UserinfoTest();
  /**
   * run this testcase as a suite from the command line
   * @param args - ignored
   * @throws Exception 
   */
  public static void main(String args[]) throws Exception {
      junit.textui.TestRunner.run( suite() );
  }
  

  /**
   * supply this test cases as part of a suite
   * @return
   */
  public static Test suite() {
      return new TestSuite( TraningPlanTest.class );
  }
  
  
  /**
   * Verifies that submitting the login form without entering a name results in a page
   * containing the text "Login failed"
   **/
  public void testTraningPlanSaveSuccess() throws Exception {
      WebConversation     conversation = new WebConversation();
      //GetMethodWebRequest
      TrainingPlanJsonform form =new TrainingPlanJsonform();
      form.setExercise_mode(1);
      form.setEnd_time(TimeUtils.getCurrentTimestamp());
      form.setMap_coordinates("116.307629,40.058359");
      form.setPlace("东郊记忆");
      form.setRun_times(30);
      form.setPrice(50.2);
      form.setRunKM(20);
      form.setId(1l);
      form.setStart_time(TimeUtils.getCurrentTimestamp());
      String json=JSONUtils.getJsonString(form);
      HttpUtils.printjson(json);
      ByteArrayInputStream input=new ByteArrayInputStream(json.getBytes(Constants.Charset));
      PostMethodWebRequest  request = new PostMethodWebRequest( TestConstants.host+"rest/traningPlan/save.json"+user.addParameter_JSESSIONID(),input,TestConstants.contentType );
      request.setParameter(RestConstants.Return_JSESSIONID, user.getLoginSessionid());
      WebResponse response = tryGetResponse(conversation, request );
       
        HttpUtils.println(conversation, request, response);
        assertTrue( "登录-成功", response.getText().indexOf( "success" ) != -1 );
//      if (response.getContentType().equals("application/json")) {
//        String json = response.getText();
//        Map<String, String> map = new Gson().fromJson(json, new TypeToken<Map<String, String>>() {}.getType());
//        System.out.println(map.get("displayName")); // Benju
//       }
//
//      assertTrue( "Login not rejected", response.getText().indexOf( "Login failed" ) != -1 );
  }
}
