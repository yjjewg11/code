package com.company.news.service;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import net.sf.json.JSONObject;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.company.news.ContentTypeConstants;
import com.company.news.ProjectProperties;
import com.company.news.SystemConstants;
import com.company.news.commons.util.FileUtils;
import com.company.news.commons.util.UUIDGenerator;
import com.company.news.entity.UploadFile;
import com.company.news.entity.User;
import com.company.news.form.UploadFileForm;
import com.company.news.rest.RestConstants;
import com.company.news.rest.util.RestUtil;
import com.company.news.rest.util.SmbFileUtil;
import com.company.news.vo.ResponseMessage;
import com.company.web.listener.SessionListener;
import com.sobey.tp.utils.TimeUtils;

/**
 * 文件上传
 * @author Administrator
 *
 */
@Service
public class UploadFileService extends AbstractServcice {
    private static Logger logger = LoggerFactory.getLogger(UploadFileService.class);
    /**
     * 上载附件
     * @param model
     * @param request
     * @return
     */
    public ModelMap uploadImg(UploadFileForm upladFileForm,CommonsMultipartFile file,ModelMap model, HttpServletRequest request) {
        model.clear();
        ResponseMessage responseMessage = RestUtil.addResponseMessageForModelMap(model);
        User userInfo = SessionListener.getUserInfoBySession(request);
        String guid=new UUIDGenerator().generate().toString();
        try {
            String uploadPath =ProjectProperties.getProperty("UploadFilePath", "H:/runman_upload/");
            String fileName=file.getOriginalFilename();
              uploadPath+=upladFileForm.getType()+"/";
              FileUtils.createDirIfNoExists(uploadPath);
              fileName=userInfo.getId()+"_"+upladFileForm.getType()+"_"+guid+"."+SystemConstants.UploadFile_imgtype;
           // FileUtils.saveFile(file.getInputStream(), uploadPath,fileName);
           if(!FileUtils.makeThumbnail(file.getInputStream(), uploadPath,fileName)){
             responseMessage.setStatus(RestConstants.Return_ResponseMessage_failed);
             responseMessage.setMessage("上载文件保存失败!");
             model.addAttribute(RestConstants.Return_ResponseMessage, responseMessage);
             return model;
           }
           //上传头像,身份证，马拉松认证唯一。其他情况新建
           UploadFile uploadFile =null;
           String oldFile=null;
           if(Integer.valueOf(1).equals(upladFileForm.getDeleteOldFile())){
             String hql="from UploadFile where type='"+upladFileForm.getType()+"' and create_userid= " +userInfo.getId();
             List queryList=this.nSimpleHibernateDao.getHibernateTemplate().find(hql);
             if(queryList.size()>0){
               uploadFile =(UploadFile) queryList.get(0);
             }
           }
          
           //新建
           if(uploadFile==null){
             uploadFile =new UploadFile();
           }else{
             oldFile=uploadFile.getFile_path();
           }
           //每次都更新guid
           uploadFile.setGuid(guid);
            uploadFile.setType(upladFileForm.getType());
            uploadFile.setFile_size(file.getSize());
            uploadFile.setCreate_userid(userInfo.getId());
            uploadFile.setCreate_time(TimeUtils.getCurrentTimestamp());
            uploadFile.setFile_path(uploadPath+fileName);
            uploadFile.setContent_type(file.getContentType());
            this.nSimpleHibernateDao.save(uploadFile);
            
            //更新用户头像访问地址
            String uploadFilePath_url= ProjectProperties.getProperty("uploadFilePath_url", "rest/uploadFile/getImgFile.json?guid=")+uploadFile.getGuid();
          
            //业务数据，关联用户保存
            if(SystemConstants.UploadFile_type_myhead.equals(uploadFile.getType())){
              userInfo.setHead_imgurl(uploadFilePath_url);
              this.nSimpleHibernateDao.save(userInfo);
            }else if(SystemConstants.UploadFile_type_identity_card.equals(uploadFile.getType())){
              userInfo.setIdentity_card_imgurl(uploadFilePath_url);
              this.nSimpleHibernateDao.save(userInfo);
            }else if(SystemConstants.UploadFile_type_marathon.equals(uploadFile.getType())){
              userInfo.setMarathon_imgurl(uploadFilePath_url);
              this.nSimpleHibernateDao.save(userInfo);
            }
            
            model.addAttribute("imgurl",uploadFilePath_url);
            
            //oldFile需要删除好似，才不会null，删除原文件。
            if(oldFile!=null){
               this.logger.info("delete old img File="+oldFile);
              if (SmbFileUtil.isSmbFileFormat(oldFile)) {
                String username=ProjectProperties.getProperty("UploadFilePath_username", "runman");
                String password=ProjectProperties.getProperty("UploadFilePath_password", "Ruanman2015");
                FileUtils.deletesmbFile(oldFile, username, password);
              }else{
                FileUtils.deleteFile(oldFile);
                
              }
            }
//          if (isImage(description)) {
//              makeThumbnail(files.getInputStream(), uploadPath, uploadFile.getTitle());
//          }
//          model.addAttribute("attachmentId", uploadFile.getId());
        } catch (Exception e) {
            logger.error("", e);
            responseMessage.setStatus(RestConstants.Return_ResponseMessage_failed);
            responseMessage.setMessage("上载文件失败!");
            model.addAttribute(RestConstants.Return_ResponseMessage, responseMessage);
        }
        return model;
    }

    /**
     *下载附件
     * @param guid
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     * 
     * Status Code
     * 
response header:  
200 OK
Content-Disposition
: 
attachment; filename=4_headimg_402886fc4d606189014d6061892b0000.jpg
Content-Type
: 
application/octet-stream;charset=UTF-8
Date
: 
Sun, 17 May 2015 05:52:13 GMT
Server
: 
Apache-Coyote/1.1
Transfer-Encoding
: 
chunked
     */
    public void down(String guid, HttpServletResponse response,String contentType) throws Exception {
//      ResponseMessage responseMessage = RestUtil.addResponseMessageForModelMap(model);
//      User userInfo = SessionListener.getUserInfoBySession(request);
      String hql="from UploadFile where  guid='"+guid+"'";
      UploadFile uploadFile=(UploadFile)this.nSimpleHibernateDao.getObjectByAttribute(UploadFile.class, "guid", guid);
      if(uploadFile==null){
        this.logger.info("uploadFile record is empty!");
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      }
      boolean result = getStream(uploadFile.getFile_path(), response,contentType);
      if (!result) {
        this.logger.info("file not found.may be delete!");
          response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      }
    }

 


  

    /**
     * 删除附件
     * @param uuid
     * @param request
     * @param model
     * @return
     */
    public ModelMap delete(String uuid, HttpServletRequest request, ModelMap model) {
        ResponseMessage responseMessage = RestUtil.addResponseMessageForModelMap(model);
        try {
            UploadFile uploadFile = (UploadFile) this.nSimpleHibernateDao.getObjectById(getEntityClass(),
                    Long.valueOf(uuid));
            
            //先删除数据库，再删除文件
            if (uploadFile == null) {
                responseMessage.setStatus(RestConstants.Return_ResponseMessage_failed);
                responseMessage.setMessage("数据不存在！");
                model.addAttribute(RestConstants.Return_ResponseMessage, responseMessage);
            }
            String path=uploadFile.getFile_path();
            this.nSimpleHibernateDao.deleteObjectById(getEntityClass(), Long.valueOf(uuid));
            try {
                if (SmbFileUtil.isSmbFileFormat(path)) {
                    SmbFile file = new SmbFile(path);
                    file.delete();
                } else {
                    File file = new File(path);
                    file.delete();
                }
            } catch (Exception e) {
                logger.error("删除附件失败", e);
            }
            
        } catch (Exception e) {
            logger.error("", e);
            responseMessage.setStatus(RestConstants.Return_ResponseMessage_failed);
            responseMessage.setMessage("删除附件失败!");
            model.addAttribute(RestConstants.Return_ResponseMessage, responseMessage);
        }
        return model;
    }

    /**
     * 读取文件流并保存到response
     * @param request
     * @param response
     * @param actionerrors
     * @param downInfo
     * @return
     * @see 
     * 
     * @throws Exception
     */
    protected boolean getStream(String filePath, HttpServletResponse response,String contentType) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("getStreamInfo(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse) - start");
        }
        
        String fileName=FilenameUtils.getName(filePath);
        char fileSplit;
        
        //"image/gif"
        if(contentType!=null){
          response.setContentType(contentType);
      }else{
          response.setContentType("application/x-msdownload;");
      }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename="
                + fileName);
        this.logger.info("Down file path:" + filePath);
        if (SmbFileUtil.isSmbFileFormat(filePath)) {
            SmbFile file = null;
            file = new SmbFile(filePath);
            if (file.isDirectory() && file.exists()) {
                // 兼容以前模式,如果是文件夹,则需要加文件名
                filePath = SmbFileUtil.connectedPathFileName(filePath, fileName);
                file = new SmbFile(filePath);
            }
            if (!file.exists()) {
                this.logger.error("down file is not exsist!path=" + filePath);
                return false;
            }
            // 获取文件输入流
            SmbFileInputStream fis = null;
            BufferedInputStream stream = null;

            try {
                fis = new SmbFileInputStream(file);
                stream = new BufferedInputStream(fis);
                org.apache.commons.io.IOUtils.copy(stream, response.getOutputStream());
            } catch (Exception e) {
                logger.error("", e);
                return false;
            } finally {
                if (stream != null) {
                    stream.close();
                }
            }
        } else {
            File file = null;
            file = new File(filePath);
            if ( file.exists()&&file.isDirectory()) {
                // 兼容以前模式,如果是文件夹,则需要加文件名
//                filePath = SmbFileUtil.connectedPathFileName(filePath, fileName);
                file = new File(filePath);
            }
            if (!file.exists()) {
                this.logger.error("down file is not exsist!path=" + filePath);
                return false;
            }
            // 获取文件输入流
            FileInputStream fis = null;
            BufferedInputStream stream = null;
            try {
                fis = new FileInputStream(file);
                stream = new BufferedInputStream(fis);
                org.apache.commons.io.IOUtils.copy(stream, response.getOutputStream());
            } catch (Exception e) {
                logger.error("", e);
                return false;
            } finally {
                if (stream != null) {
                    stream.close();
                }
            }
        }
        if (logger.isDebugEnabled()) {
            logger.debug("getStreamInfo(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse) - end");
        }
        return true;
    }

   

    /**
     * 判断上载的附件是否为图片
     * @param description
     * @return
     */
    private boolean isImage(String description) {
        JSONObject jsonObject = JSONObject.fromObject(description);
        if ("jpg".equalsIgnoreCase(jsonObject.get("type").toString())) {
            return true;
        }
        
        if ("png".equalsIgnoreCase(jsonObject.get("type").toString())) {
            return true;
        }
        
        if ("bmp".equalsIgnoreCase(jsonObject.get("type").toString())) {
            return true;
        }
        return false;
    }

  @Override
  public Class getEntityClass() {
    // TODO Auto-generated method stub
    return UploadFile.class;
  }


}