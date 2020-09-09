import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = args[0];
        String secondWordList = args[1];

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行
        System.out.println(result);
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        String[] array1 = firstWordList.split(",");//["apple","juice","mother","people","beautiful","apple","dog"]
        String[] array2 = secondWordList.split(",");//["cat","baby","smile","good","apple","beautiful","Dog","nice"]

        List<String> list1 = Arrays.asList(array1).stream()
                .distinct()
                .map(word -> word.toUpperCase())
                .collect(Collectors.toList());
        List<String> list2 = Arrays.asList(array2).stream()
                .distinct()
                .map(word -> word.toUpperCase())
                .collect(Collectors.toList());

        List<String> overlapped = list1.stream()
                .filter(word -> list2.contains(word))
                .collect(Collectors.toList());

        return overlapped.stream()
                .map(word -> String.join(" ", word.split("")))
                .sorted()
                .collect(Collectors.toList());
    }
}
