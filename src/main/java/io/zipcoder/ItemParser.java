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
        List<Item> list = new ArrayList<>();
        // Map<key, value> - should be in " "
        // K:V - colon seperated
        // KV, KV -
        // (\\D+)(\\d)(\\wx)
    }

    public List<Item> parseItemList(String valueToParse) {
        List<Item> itemList = new ArrayList<>();

        return null;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        Pattern thePattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = thePattern.matcher(singleItem);

        matcher.find();
        matcher.group(1);
        matcher.group(2);
        matcher.group(3);
        matcher.group(4);

        Item item = new Item(matcher.group(1).toLowerCase(), Double.parseDouble(matcher.group(2)),
                matcher.group(3).toLowerCase(), matcher.group(4));

        return item;

    }

}
