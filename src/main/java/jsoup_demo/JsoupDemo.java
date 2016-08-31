package jsoup_demo;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created by wangzz on 2016/8/11.
 */
public class JsoupDemo {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\韩都衣舍.html");
        Document doc = Jsoup.parse(file, "utf-8");
        //Document doc = Jsoup.connect("https://rate.taobao.com/user-rate-UvCxGOmHuOF8u.htm").get();

        //String scoreDomId = "li.J_RateInfoTrigger div.item-scrib em:eq(1)";
        String scoreDomId = "div.J_TBR_MonthInfo_Summary";
        int index = 0;
        String attrName = "title";
        Elements elements = doc.select(scoreDomId);
        for (Element element : elements) {
            //System.out.println(element.attr("title"));
            //System.out.println(element.text());
            System.out.println(element.toString());
        }
        //Elements trs = doc.select("tr.J_TBR_MonthInfo_SummaryTR td");

        /*//拼装实体
        StoreExpandInfo storeExpandInfo = new StoreExpandInfo();

        //店铺评分字段拼装
        Element descriptionMatchScoreEl = doc.select(scoreDomId).get(index);
        if (EmptyUtil.isNotEmpty(attrName)) {
            String attr = descriptionMatchScoreEl.attr(attrName);
            //只留数字
            attr = attr.replaceAll("[^\\d.]", "");
            storeExpandInfo.setDescriptionMatchScore(attr);
        } else {
            storeExpandInfo.setDescriptionMatchScore(descriptionMatchScoreEl.text());
        }
        Element sellerMannerScoreEl = doc.select(scoreDomId).get(1);
        storeExpandInfo.setSellerMannerScore(sellerMannerScoreEl.attr(attrName));
        Element logisticsMannerScoreEl = doc.select(scoreDomId).get(2);
        storeExpandInfo.setLogisticsMannerScore(logisticsMannerScoreEl.attr(attrName));
        //店铺比较字段拼装
        String compareDomId = "li.J_RateInfoTrigger div.item-scrib em:eq(2)";
        Element descriptionMatchCompareEl = doc.select(compareDomId).get(0);
        storeExpandInfo.setDescriptionMatchCompare(descriptionMatchCompareEl.text());
        Element sellerMannerCompareEl = doc.select(compareDomId).get(1);
        storeExpandInfo.setSellerMannerCompare(sellerMannerCompareEl.text());
        Element logisticsMannerCompareEl = doc.select(compareDomId).get(2);
        storeExpandInfo.setLogisticsMannerCompare(logisticsMannerCompareEl.text());


        System.out.println(storeExpandInfo.toString());*/


        //String title = doc.title();
        //System.out.println(title);
        /*Elements em2 = doc.select("li.J_RateInfoTrigger div.item-scrib em:eq(2)");
        for (Element li : em2) {
            //System.out.println(li.attr("title"));
            System.out.println(li.text());
        }
        Elements trs = doc.select("tr.J_TBR_MonthInfo_SummaryTR td");*/

        // a with href
        //Elements links = doc.select("a[href]");
        // img with src ending .png
        //Elements pngs = doc.select("img[src$=.png]");
        //Element masthead = doc.select("div.masthead").first();
        // div with class=masthead
        //Elements resultLinks = doc.select("h3.r > a"); // direct a after h3

    }

}
