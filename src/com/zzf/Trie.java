package com.zzf;

import java.util.*;

/**
 * 我司常常要实现输入联想功能，比如，现有学校数据
 * collegeData={ "Swiss Federal Institute of Technology in Zurich": ["swiss", "ethz", "eth", "zurich", "federal", "eidgenossische", "technology"],
 * "Technical University of Berlin": ["technical", "berlin"]}
 * 意思是： “Swiss Federal Institute of Technology in Zurich” 是这所学校的标准名称，这所学校和它冒号后面的词相关；"Technical University of Berlin"
 * 这所学校和"technical", "berlin"这两个词相关。
 *
 * 1. 用户输入3个和3个以上字母时，应该联想提示相关的学校。例如，键入"tech"，应该提示上面两所学校；键入"tech ber"，应该提示上面的第二所学校。键入“chn”，应该什么都不提示，即，不考虑字母在中间的情况。
 * 2. 学校和关键词关联数据相对固定，不需要实时更新。
 * 3. 内存足够存下所有关联的数据。
 *
 * 要求查找速度最快，用什么算法实现？
 */

class Trie {
    private Trie[] children;
    private boolean isEnd;
    private Set<String> schoolNameList;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
        schoolNameList = new HashSet<>();
    }

    public void insert(String word, String schoolName) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
            if (i > 1) {
                node.schoolNameList.add(schoolName);
            }
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public Set<String> startsWithSchool(String prefix) {
        Set<String> result = new HashSet<>();
        List<String> prefixList = Arrays.asList(prefix.split(" "));
        HashMap<String, Integer> map = new HashMap<>();
        for (String prefixStr : prefixList) {
            Set<String> setString = searchPrefix(prefixStr).schoolNameList;
            Iterator<String> iterator = setString.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                if (map.containsKey(next)) {
                    map.put(next, map.get(next) + 1);
                } else {
                    map.put(next, 1);
                }
            }
        }
        for(Map.Entry entry : map.entrySet()){
            if(prefixList.size() == Integer.valueOf(entry.getValue().toString())){
                result.add(entry.getKey().toString());
            }
        }
        return result;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return new Trie();
            }
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("swiss", "Swiss Federal Institute of Technology in Zurich");
        trie.insert("ethz", "Swiss Federal Institute of Technology in Zurich");
        trie.insert("eth", "Swiss Federal Institute of Technology in Zurich");
        trie.insert("zurich", "Swiss Federal Institute of Technology in Zurich");
        trie.insert("federal", "Swiss Federal Institute of Technology in Zurich");
        trie.insert("eidgenossische", "Swiss Federal Institute of Technology in Zurich");
        trie.insert("technology", "Swiss Federal Institute of Technology in Zurich");
        trie.insert("technical", "Technical University of Berlin");
        trie.insert("berlin", "Technical University of Berlin");
        long startCyclic = System.currentTimeMillis();
        System.out.println(trie.startsWithSchool("tech"));
        long endCyclic = System.currentTimeMillis();
        System.out.println();
        System.out.println("字典树查找：" + (endCyclic - startCyclic) + "毫秒");
        System.out.println(trie.startsWithSchool("tech ber"));
        System.out.println(trie.startsWithSchool("chn"));

    }
}