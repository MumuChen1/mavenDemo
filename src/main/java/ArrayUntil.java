import java.util.*;

/**
 * @description:
 * @author: chenyan
 * @time: 2020/12/25 18:03
 */
public class ArrayUntil {
    public static void digitToCharacterConversion() {
        Map<String, List<String>> digitsMap = new HashMap<String, List<String>>();
        digitsMap.put("0", Arrays.asList(""));
        digitsMap.put("1", Arrays.asList(""));
        digitsMap.put("2", Arrays.asList("A", "B", "C"));
        digitsMap.put("3", Arrays.asList("D", "E", "F"));
        digitsMap.put("4", Arrays.asList("G", "H", "I"));
        digitsMap.put("5", Arrays.asList("J", "K", "L"));
        digitsMap.put("6", Arrays.asList("M", "N", "O"));
        digitsMap.put("7", Arrays.asList("P", "Q", "R", "S"));
        digitsMap.put("8", Arrays.asList("T", "U", "V"));
        digitsMap.put("9", Arrays.asList("W", "X", "Y", "Z"));

        System.out.println("Please input digits from 0 to 9:");
        Scanner input = new Scanner(System.in);
        String digits = "";
        while (true) {
            digits = input.next();
            if (!digits.matches("[0-9]{1,2}")) {
                System.out.println("Illegal input! Only 0-99 numbers can be entered, please re-enter：");
            } else {
                break;
            }
        }

        StringBuilder arrInput = new StringBuilder("Input:arr[] ={");
        String[] arrStr = digits.split("");
        List<String[]> dataList = new ArrayList<String[]>();

        for (int i = 0; i < arrStr.length; i++) {
            arrInput.append(arrStr[i]);
            if (i < arrStr.length - 1) {
                arrInput.append(",");
            }
            List<String> lettersList = digitsMap.get(arrStr[i]);
            if (lettersList.size() > 0) {
                String[] letterArr = (String[]) lettersList.toArray();
                dataList.add(letterArr);
            }
        }
        arrInput.append("}");
        List<String[]> resultList = makeupLetters(dataList, 0, null);
        System.out.println(arrInput.toString());
        System.out.print("Output:");
        for (int i = 0; i < resultList.size(); i++) {
            String[] letterArr = resultList.get(i);
            System.out.print(" ");
            for (String s : letterArr) {
                System.out.print(s);
            }
        }
        input.close();
    }
    private static List<String[]> makeupLetters(List<String[]> dataList, int index, List<String[]> resultList){
        if(index==dataList.size()){
            return resultList;
        }

        List<String[]> resultList0=new ArrayList<String[]>();
        if(index==0){
            String[] dataArr=dataList.get(0);
            for(String s : dataArr){
                resultList0.add(new String[]{s});
            }
        }else{
            String[] dataArr=dataList.get(index);
            for(String[] dataArr0: resultList){
                for(String s : dataArr){
                    String[] dataArrCopy=new String[dataArr0.length+1];
                    System.arraycopy(dataArr0, 0, dataArrCopy, 0, dataArr0.length);
                    dataArrCopy[dataArrCopy.length-1]=s;
                    resultList0.add(dataArrCopy);
                }
            }
        }
        return makeupLetters(dataList,++index,resultList0);
    }

}
