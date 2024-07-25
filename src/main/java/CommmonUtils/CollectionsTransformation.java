package CommmonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsTransformation {

    /**
     * Converts a Cucumber DataTable into a Map where each key is a column header
     * and each value is a list of column values.
     *
     * @param table the DataTable to be converted
     * @return a Map with column headers as keys and lists of column values as values
     */
    public static Map<String, List<String>> dataTableToMapOfList(io.cucumber.datatable.DataTable table) {
        // Convert the DataTable to a list of lists of strings
        List<List<String>> data = table.asLists(String.class);

        // Extract the first row as table headers
        List<String> tableHeaders = data.get(0);

        // Initialize the map to store the result
        Map<String, List<String>> map = new HashMap<>();

        // Iterate over each header
        for (int i = 0; i < tableHeaders.size(); i++) {
            String header = tableHeaders.get(i);
            List<String> list = new ArrayList<>();

            // Iterate over each row starting from the second row
            for (int j = 1; j < data.size(); j++) {
                list.add(data.get(j).get(i));
            }

            // Put the header and its corresponding list into the map
            map.put(header, list);
        }

        // Return the resulting map
        return map;
    }


}
