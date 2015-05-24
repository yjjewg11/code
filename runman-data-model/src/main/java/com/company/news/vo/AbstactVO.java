package com.company.news.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/5/21.
 */
public class AbstactVO implements Serializable {

    static public void main(String[] d){
       String  path="\\\\vsd/ddd/d/dd/";
        String isAvidPathMatch="\\vsd/";
        boolean dd=false;
        if(path!=null&&path.indexOf(isAvidPathMatch)>=0){
            dd= true;
        }
        System.out.printf("dd==="+dd);
    }
}
