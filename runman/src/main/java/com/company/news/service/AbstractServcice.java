package com.company.news.service;

import java.sql.Timestamp;
import java.util.Properties;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.company.news.dao.NSimpleHibernateDao;
import com.company.news.json.NpmsDateMorpher;
import com.company.news.springMVC.JsonDateValueProcessor;

public abstract class AbstractServcice {
  public static final String ID_SPLIT_MARK = ",";
  protected static Logger logger = LoggerFactory.getLogger(AbstractServcice.class);
  @Autowired
  @Qualifier("NSimpleHibernateDao")
  protected NSimpleHibernateDao nSimpleHibernateDao;
  /**
   * 数据库实体
   * @return
   */
  public abstract Class getEntityClass();
  
  /**
   * 
   * @param bodyJson
   * @param clazz
   * @param model
   * @return
   * @throws Exception
   */
  public static Object bodyJsonToFormObject(String bodyJson,Class clazz) throws Exception{
  

//    return JSONUtils.jsonToObject(bodyJson, clazz);
    JSONObject jsonObject = null;
//    JsonConfig jsonConfig = new JsonConfig();
//    jsonConfig.registerJsonValueProcessor(java.util.Date.class, new JsonDateValueProcessor() );
//    jsonConfig.registerJsonValueProcessor(Timestamp.class, new JsonDateValueProcessor() );
//    
//  //  jsonObject = JSONObject.fromObject(bodyJson, jsonConfig);
//    JSONUtils.getMorpherRegistry().registerMorpher(
//      new NpmsDateMorpher(new String[] {"yyyy-MM-dd HH:mm:ss" }));
    jsonObject = JSONObject.fromObject(bodyJson);
    return  JSONObject.toBean(jsonObject,clazz);
//    return JSONObject.toBean(jsonObject, clazz);
  }

  public static Properties bodyJsonToProperties(String bodyJson) throws Exception{
//    return (Properties)JSONUtils.jsonToObject(bodyJson, Properties.class);
    JSONObject jsonObject = null;
    JsonConfig jsonConfig = new JsonConfig();
//    jsonConfig.registerDefaultValueProcessor(java.util.Date.class, new JsonDateValueProcessor() );
//    jsonObject = JSONObject.toBean(bodyJson, jsonConfig);//fromObject(bodyJson);
    jsonObject = JSONObject.fromObject(bodyJson);
    return (Properties)JSONObject.toBean(jsonObject, Properties.class);
  }

}
