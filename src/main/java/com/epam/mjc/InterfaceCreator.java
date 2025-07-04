package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {

            for (String str : x) {
                int firstCharacter = str.codePointAt(0);
                if (!Character.isUpperCase(firstCharacter)) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> additionList = new ArrayList<>();
            for(Integer num: x){
                if(num%2 == 0){
                    additionList.add(num);
                }
            }
            x.addAll(additionList);

        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();

            for(String sentence: values){
                String[] words = sentence.trim().split("\\s+");
                boolean moreThen3Word = words.length > 3;
                if(Character.isUpperCase(sentence.codePointAt(0)) &&( sentence.charAt(sentence.length() -1) == '.') && moreThen3Word ){
                    result.add(sentence);
                }
            }
            return  result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> result = new HashMap<>();
            for(String s : x){
                result.put(s, s.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2)->{
            List<Integer> result = new ArrayList<>(list1);
            result.addAll(list2);

            return result;
        };
    }
}
