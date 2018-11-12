
//class  WordsCount 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;


public class WordsCount {
public static void main(String arg[]) {
String fileName = "D://Desktop/poem.txt";
readFile(fileName);
} 


private static void readFile(String fileName ){
int wordCount = 0; // 用于统计单词的总个数
Map<String, Integer> map = new HashMap<String, Integer>();// 用于统计各个单词的个数，排序
File myFile=new File(fileName);
    if(!myFile.exists())
    { 
        System.err.println("Can't Find " + fileName);
    }


    try 
    {
        BufferedReader in = new BufferedReader(new FileReader(myFile));
        String str,myStr="";
        while ((str = in.readLine()) != null) 
        {
        myStr += str; 
        
    } 
StringTokenizer token = new StringTokenizer(myStr);// 这个类会将字符串分解成一个个的标记
while (token.hasMoreTokens()) { // 循环遍历
wordCount++;
String word = token.nextToken(", ?.!:\"\"''\n"); // 按照, ? .! : ""'' \n去分割
if (map.containsKey(word)) { // HashMap不允许key重复
int count = map.get(word);
map.put(word, count + 1); // 如果HashMap已有这个单词，则设置它的数量加1
} else
map.put(word, 1); // 如果没有这个单词，则新填入，数量为1
}
System.out.println("总共单词数：" + wordCount);
sort(map); // 调用排序的方法，排序并输出！
        
        in.close();
    } 
    catch (IOException e) 
    {
        e.getStackTrace();
    }

}


private static void isPrint(int wordsNum,List<Map.Entry<String, Integer>>  inList){
for (int i = 0; i < wordsNum; i++) { // 输出
Entry<String, Integer> id = inList.get(i);
System.out.println(id.getKey() + ":" + id.getValue());
}
}
}