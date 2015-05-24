package com.company.news.usershow;

/**
 * Created by Administrator on 2015/5/21.
 */
public class TrainingPlanUsershow {
    //订单状态：0：未发布，1：发布，2：已接单，3：待支付，4：完成,5:关闭。
    static  public String  changeByStatus(Integer o){
        String s="";
        switch (o){
            case 0:s="未发布";break;
            case 1:s="发布";break;
            case 2:s="已接单";break;
            case 3:s="待支付";break;
            case 4:s="完成";break;
            case 5:s="关闭";break;
        }
     return s;
    }
}
