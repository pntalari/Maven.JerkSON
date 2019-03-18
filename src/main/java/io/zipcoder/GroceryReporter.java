package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;

public class GroceryReporter {
    private final String originalFileText;
    ItemParser parser = new ItemParser();

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    @Override
    public String toString() {
        List<Item> list = new ArrayList<>();
        try {
            parser.parseItemList(originalFileText);



        } catch (ItemParseException e) {
            e.printStackTrace();
        }


        return null;
    }
}
