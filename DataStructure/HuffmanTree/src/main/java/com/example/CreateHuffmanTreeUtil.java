package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CreateHuffmanTreeUtil {

    private final List<HuffmanTree> huffmanTreesList = new ArrayList<HuffmanTree>();

    public List<HuffmanTree> createHuffmanTree(int[] weight, int n) {
        if (n <= 1) {
            return null;
        }

        int m = 2 * n - 1;

        //初始化数据
        for (int i = 1; i <= m; ++i) {
            HuffmanTree HT = new HuffmanTree();

            HT.setParent(0);
            HT.setlChild(0);
            HT.setrChild(0);

            huffmanTreesList.add(HT);
        }

        //输入权值
        for (int i = 0; i < n; ++i) {
            huffmanTreesList.get(i).setWeight(weight[i]);
        }

        for (int i = n; i < m; ++i) {
            int[] hs = select(huffmanTreesList, i);

            huffmanTreesList.get(hs[0]).setParent(i + 1);
            huffmanTreesList.get(hs[1]).setParent(i + 1);

            huffmanTreesList.get(i).setlChild(hs[0] + 1);
            huffmanTreesList.get(i).setrChild(hs[1] + 1);

            huffmanTreesList.get(i).setWeight(huffmanTreesList.get(hs[0]).getWeight()
            + huffmanTreesList.get(hs[1]).getWeight());
        }

        return huffmanTreesList;
    }

    /**
     * 返回双亲结点为0，权值最小的两个下标
     * @param htList
     * @param n
     * @return
     */
    public int[] select(List<HuffmanTree> htList, int n) {
        int[] minWeight = new int[2];
        int[] location = new int[2];
        int weight;
        minWeight[0] = Integer.MAX_VALUE;
        minWeight[1] = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (htList.get(i).getParent() == 0) {
                weight = htList.get(i).getWeight();

                if (weight < minWeight[0]) {
                    minWeight[1] = minWeight[0];
                    location[1] = location[0];
                    minWeight[0] = weight;
                    location[0] = i;
                } else if (weight < minWeight[1]) {
                    minWeight[1] = weight;
                    location[1] = i;
                }
            }
        }

        return location;
    }

    /**
     * 计算哈夫曼编码
     * @param huffmanTreesList
     * @param n
     * @return
     */
    public List<char[]> createHuffmanCode(List<HuffmanTree> huffmanTreesList, int n) {
        List<char[]> huffmanCodeList = new LinkedList<>();
        char[] cd  = new char[n];
        int start , c;

        cd[n-1] = '\0';

        for (int i = 0; i < n; i++) {
            start = n - 1;
            c = i + 1;
            int f = huffmanTreesList.get(i).getParent() - 1;

            while (f >= 0) {
                --start;

                if (huffmanTreesList.get(f).getlChild() == c) {
                    cd[start] = '0';
                } else {
                    cd[start] = '1';
                }
                c = f + 1;
                f = huffmanTreesList.get(f).getParent() - 1;
            }
            char[] code = Arrays.copyOfRange(cd, start, cd.length - 1);
            huffmanCodeList.add(code);
        }

        return huffmanCodeList;
    }

    public static void main(String[] args) {
        CreateHuffmanTreeUtil htt = new CreateHuffmanTreeUtil();
        int[] weight = new int[]{5, 29, 7, 8, 14, 23, 3, 11};

        List<HuffmanTree> huffmanTree = htt.createHuffmanTree(weight, weight.length);

        for (HuffmanTree ht : huffmanTree) {
            System.out.println(ht.getWeight() + " " + ht.getParent() + " " + ht.getlChild() + " " + ht.getrChild());
        }

        List<char[]> huffmanCode = htt.createHuffmanCode(huffmanTree, weight.length);

        huffmanCode.forEach(System.out::println);
    }
}
