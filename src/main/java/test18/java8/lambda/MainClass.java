package test18.java8.lambda;

import com.google.common.collect.Lists;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/11/18
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {

    public static void main(String[] args) {

        // sample1 线程Thread
        new Thread() {
            @Override
            public void run() {
                System.out.println("old......");
            }
        }.start();

        new Thread(()-> System.out.println("new ....")).start();

        // sample2
        // 旧的事件监听代码
        JButton show = new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click...........");
            }
        });
        // 新的方法
        show.addActionListener((e)->{
            System.out.println("new ................");
        });

        // sample3
        // 旧的方法
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            //System.out.println(feature);
        }
        // 新的
        features.forEach(n-> System.out.println(n));
        // 更短的打印
        features.forEach(System.out::println);

        // sample4
        List<String> languages = Arrays.asList("Java","Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which start with J");
        filter(languages, (str)->((String)str).startsWith("J"));
        filterBetter(languages, (str)->((String)str).startsWith("J"));

        // sample5
        // 将两个或多个predicate合并为一个
        Predicate<String> startWithJ = (n) ->n.startsWith("J");
        Predicate<String> givenLength = (n) ->n.length()==4;
        languages.stream()
                .filter(Objects::nonNull)       //过滤非空
                .filter(startWithJ.and(givenLength))
                .forEach(System.out::println);

        // sample6
        List<Integer> costBeforeTax = Arrays.asList(100,200,300,400,500);
        for (Integer cost:costBeforeTax) {
            double price = cost + .12*cost;
            //System.out.println(price);
        }

        costBeforeTax.stream()
                .map(cost->cost+.12*cost)
                .forEach(System.out::println);

        // 使用reduce
        double total = costBeforeTax.stream()
                .map(cost->cost+.12*cost)
                .reduce((sum,cost)->sum+cost)       //reduce求和 ,需要配合map中cost
                .get();     //获取值
        System.out.println(total);

        //sample7
        List<String> strList = Arrays.asList("abc","" , "bcd","" , "defg", "jk");
        List<String> filtered = strList
                .stream()
                .filter(x->x.length()>2)
                .collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);

        //sample8
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);

        //9
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);


        //例10、计算集合元素的最大值、最小值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());

    }

    public static void filter(List<String> names, Predicate condition) {
        for(String name:names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    public static void filterBetter(List<String> names, Predicate condition) {
        names.stream()
                .filter(name->(condition.test(name)))
                .forEach(name-> System.out.println(name + ""));
    }

}
