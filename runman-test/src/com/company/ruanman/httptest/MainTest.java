package com.company.ruanman.httptest;

import com.company.ruanman.httptest.test.TrainingCourseTest;
import com.company.ruanman.httptest.test.UploadFileTest;
import com.company.ruanman.httptest.test.UserinfoTest;

public class MainTest {

  /**
   * @param args
   * @throws Exception 
   */
  public static void main(String[] args) throws Exception {
    {
    UserinfoTest o=new UserinfoTest();
    o.testLoginFailed();
    o.testLoginSuccess();
    o.testgetUserInfoSuccess();
     o.testUserModifySuccess();
    o.testlogoutSuccess();
    
    }
    
    {
      TrainingCourseTest o=new TrainingCourseTest();
      o.testTrainingCourseGetSuccess();
      o.testTrainingCourseSaveSuccess();
      o.testTrainingCourseMySuccess();
      o.testTrainingCoursequeryPublishSuccess();
    }
    
    {
      UploadFileTest o=new UploadFileTest();
      o.testuploadMyheadImg();
      o.testdownSuccess();
      o.testuploadIdentityCardImg();
      o.testdownSuccess();
      o.testuploadMarathonImg();
      o.testdownSuccess();
    }

  }

}
