package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;
import io.zipcoder.utils.match.Match;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryReporter {
    private final String originalFileText;
    ItemParser parser = new ItemParser();
    Map<String, Integer> itemCount = new HashMap<>();
    Map<Double, String> itemPrice = new HashMap<>();


    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
        getReportData();
    }

    @Override
    public String toString() {

        return null;
    }

    public String getReportData() {
        Integer milkCnt = 0, breadCnt = 0, cookiesCnt = 0, applesCnt = 0;
        String strCookies = "cookies", strBread = "bread", strMilk = "milk", strApples = "apples";


        List<Item> list;

        try {
            list = parser.parseItemList(originalFileText);

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equals(strMilk)){
                    milkCnt++;
                    itemCountUpdate(strMilk,milkCnt);
                    itemPriceUpdate(list.get(i).getPrice(), strMilk);
                }

                if (list.get(i).getName().equals(strBread)){
                    breadCnt++;
                    itemCountUpdate(strBread,breadCnt);
                    itemPriceUpdate(list.get(i).getPrice(),strBread);
                }

                if (list.get(i).getName().equals(strCookies)){
                    cookiesCnt++;
                    itemCountUpdate(strCookies,cookiesCnt);
                    itemPriceUpdate(list.get(i).getPrice(),strCookies);
                }

                if (list.get(i).getName().equals(strApples)) {
                    applesCnt++;
                    itemCountUpdate(strApples, applesCnt);
                    itemPriceUpdate(list.get(i).getPrice(),strApples);
                }
            }

            System.out.println(itemCount.entrySet());
            System.out.println(itemPrice.entrySet());


        } catch (ItemParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void itemCountUpdate(String item, Integer count){
        itemCount.put(item,count);
    }

    public void itemPriceUpdate(Double price,String item){
        itemPrice.put(price,item);
    }


    public Map<String, Integer> getItemCount() {
        return itemCount;
    }

    public Map<Double, String> getItemPrice() {
        return itemPrice;
    }

}
