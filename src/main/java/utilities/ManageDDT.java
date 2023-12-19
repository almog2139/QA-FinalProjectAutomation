package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps {

    /*
        Method Name:getDataObject
        Method Description: method get data object
        Method Return:String

     */
    @DataProvider(name = "data-provider-employeesId")
    public Object[][] getDataObject() {
        System.out.println(getData("DDTFile"));
        return getDataFromCsv(getData("DDTFile"));
    }

    /*
     Method Name:readCSV
     Method Description: method get csv file  and read data for him
     Method Parameters:String
     Method Return:Object

  */
    public static List<String> readCSV(String csvFile) {
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /*
       Method Name:getDataFromCsv
       Method Description: method get data from employeesId.csv file
       Method Parameters:String
       Method Return:Object

    */
    public static Object[][] getDataFromCsv(String filePath) {
        Object[][] data = new Object[Integer.parseInt(getData("DDTRows"))][Integer.parseInt(getData("DDTColums"))];
        List<String> csvData = readCSV(filePath);
        for (int i = 0; i < csvData.size(); i++) {
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];

        }
        return data;
    }
}
