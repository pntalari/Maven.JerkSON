package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {

    String delimiter = "[:|\\^|\\%|\\*|@|;]";

    String pattern = "naMe" + delimiter + "(\\w+)" + delimiter +
            "price" + delimiter + "(\\d+.\\d*)" + delimiter +
            "type" + delimiter + "(\\w+)" + delimiter +
            "expiration" + delimiter + "(\\d{1,2}/\\d{1,2}/\\d{2,4})##";

    public ItemParser() {
    }

    public List<Item> parseItemList(String valueToParse) throws ItemParseException {
        List<Item> itemList = new ArrayList<>();
        String[] arr = valueToParse.split("##");

        for (int i = 0; i < arr.length; i++) {
            try {
                itemList.add(parseSingleItem(arr[i]+"##"));
            } catch (ItemParseException e) {
                e.printStackTrace();
            }
        }
        return itemList;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        Item item;
        try {

            Pattern thePattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = thePattern.matcher(singleItem);

            matcher.find();
            matcher.group(1);
            matcher.group(2);
            matcher.group(3);
            matcher.group(4);

             item = new Item(matcher.group(1).toLowerCase(), Double.valueOf(matcher.group(2)),
                    matcher.group(3).toLowerCase(), matcher.group(4));
        }
        catch (Exception e){
            throw new ItemParseException();
        }
        return item;

    }

}
