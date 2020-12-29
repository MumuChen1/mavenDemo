
import java.util.*;

/**
 * @description:
 * @author: chenyan
 * @time: 2020/12/25 18:03
 */
public class LetterCombinationUntil {
    public static List<String> digitToCharacterConversion(Integer[] arrInteger) {
        HashMap<Integer, List<String>> digitsMap = new HashMap<Integer, List<String>>();
        digitsMap.put(0, Arrays.asList(""));
        digitsMap.put(1, Arrays.asList(""));
        digitsMap.put(2, Arrays.asList("A", "B", "C"));
        digitsMap.put(3, Arrays.asList("D", "E", "F"));
        digitsMap.put(4, Arrays.asList("G", "H", "I"));
        digitsMap.put(5, Arrays.asList("J", "K", "L"));
        digitsMap.put(6, Arrays.asList("M", "N", "O"));
        digitsMap.put(7, Arrays.asList("P", "Q", "R", "S"));
        digitsMap.put(8, Arrays.asList("T", "U", "V"));
        digitsMap.put(9, Arrays.asList("W", "X", "Y", "Z"));

        StringBuilder arrInput = new StringBuilder("Input:arr[] ={");
        //All alphabetic sets of numeric transformations
        List<String[]> dataList = new ArrayList<String[]>();
        //A set of all letters converted from 1-digit numbers
        List<String[]> oneDigitLists = new ArrayList<String[]>();

        //A set of all letters converted from 2-digit numbers
        List<String[]> twoDigitLists = new ArrayList<String[]>();

        //1、Converting numbers into letters
        for (int i = 0; i < arrInteger.length; i++) {
            arrInput.append(arrInteger[i]);
            if (i < arrInteger.length - 1) {
                arrInput.append(",");
            }

            List<String> lettersList = digitsMap.get(arrInteger[i]);
            //In the case of a 2-digit number that needs to be handled separately, the element is neither 1 nor 0, and the number of mapped letters is not found
            if (lettersList == null && !(arrInteger[i].intValue() == 0)
                    && !(arrInteger[i].intValue() == 1)) {
                //Get the 2-digit letter combination
                List<String> singleDigitList = digitsMap.get(arrInteger[i] / 1 % 10);
                List<String> tenFiguresList = digitsMap.get(arrInteger[i] / 10 % 10);

                List<List<String>> twoDigitList = new ArrayList<List<String>>();
                twoDigitList.add(singleDigitList);
                twoDigitList.add(tenFiguresList);
                List<String[]> twoDigitCombination = listConversionArray(twoDigitList);
                //2、Deal with the combination of two digits first
                List<String[]> twoList = makeupLetters(twoDigitCombination, 0, null);
                String combinationStr = conversionToStr(twoList);
                String[] combinationArrays = combinationStr.split(",");

                twoDigitLists.add(combinationArrays);
                dataList.addAll(twoDigitLists);
            }
            if (lettersList != null && !lettersList.isEmpty()) {
                List<List<String>> oneDigitList = new ArrayList<List<String>>();
                oneDigitList.add(lettersList);
                oneDigitLists = listConversionArray(oneDigitList);
                dataList.addAll(oneDigitLists);
            }

        }

        arrInput.append("}");
        //2、Various cases in which letters may be combined
        List<String[]> resultList = makeupLetters(dataList, 0, null);
        List<String> returnList = new ArrayList<String>();
        System.out.println("\n" + arrInput.toString());
        String combinationStr = conversionToStr(resultList);
        returnList.add(combinationStr);

        return returnList;
    }

    public static String conversionToStr(List<String[]> arrayList) {
        String combinationStr = "";
        for (int j = 0; j < arrayList.size(); j++) {
            combinationStr = combinationStr + Arrays.toString(arrayList.get(j)).replace("[", "")
                    .replace("]", "")
                    .replace(",", "")
                    .replaceAll(" ", "").trim();
            if (j != arrayList.size() - 1) {
                combinationStr = combinationStr + ",";
            }
        }
        return combinationStr;
    }

    public static List<String[]> listConversionArray(List<List<String>> lettersList) {
        List<String[]> returnList = new ArrayList<String[]>();
        if (lettersList != null && !lettersList.isEmpty()) {
            for (List<String> letter : lettersList) {
                String[] letterArr = (String[]) letter.toArray();
                returnList.add(letterArr);
            }
        }
        return returnList;
    }

    private static List<String[]> makeupLetters(List<String[]> dataList, int index, List<String[]> resultList) {
        if (index == dataList.size()) {
            return resultList;
        }

        List<String[]> resultList0 = new ArrayList<String[]>();
        if (index == 0) {
            String[] dataArr = dataList.get(0);
            for (String s : dataArr) {
                resultList0.add(new String[]{s});
            }
        } else {
            String[] dataArr = dataList.get(index);
            for (String[] dataArr0 : resultList) {
                for (String s : dataArr) {
                    String[] dataArrCopy = new String[dataArr0.length + 1];
                    System.arraycopy(dataArr0, 0, dataArrCopy, 0, dataArr0.length);
                    dataArrCopy[dataArrCopy.length - 1] = s;
                    resultList0.add(dataArrCopy);
                }
            }
        }
        return makeupLetters(dataList, ++index, resultList0);
    }

}
