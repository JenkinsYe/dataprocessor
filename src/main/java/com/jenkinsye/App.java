package com.jenkinsye;

import com.jenkinsye.bean.*;
import com.jenkinsye.service.MeargeService;
import com.jenkinsye.service.OutputToExcel;
import com.jenkinsye.util.HashMapBuildUtil;
import com.jenkinsye.util.ReadExcelUtil;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        List<Shanxifusheng> list = ReadExcelUtil.readShanxifushengFromFile("/Users/YJJ/Desktop/2019年序时账.xls");
        List<Shanxifusheng> result = new ArrayList<>();
        String flag = null;
        System.out.println("total: " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("No." + i);
            Shanxifusheng shanxifusheng = list.get(i);
            if (!shanxifusheng.kmmc.contains("原材料")) {
                continue;
            }
            if (shanxifusheng.digest.contains("估")) {
                continue;
            }
            if (shanxifusheng.digest.contains("预")) {
                continue;
            }
            if (shanxifusheng.digest.contains("结转")) {
                continue;
            }
            if (shanxifusheng.digest.contains("暂")) {
                continue;
            }
            if (shanxifusheng.digest.contains("冲销")) {
                continue;
            }
            if (shanxifusheng.jf != null && shanxifusheng.jf > 100000) {
                result.add(shanxifusheng);
            }
        }

        List<ArrayList<Shanxifusheng>> orderList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            orderList.add(new ArrayList<>());
        }
        for (Shanxifusheng shanxifusheng : result) {
            int month = Integer.parseInt(shanxifusheng.date.substring(5, 7));
            orderList.get(month-1).add(shanxifusheng);
        }
        List<Shanxifusheng> outputList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            orderList.get(i).sort(new Comparator<Shanxifusheng>() {
                @Override
                public int compare(Shanxifusheng o1, Shanxifusheng o2) {
                    if (o2.jf > o1.jf) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
            outputList.add(orderList.get(i).get(i%3));
            outputList.add(orderList.get(i).get(i%3 + 1));
        }


        OutputToExcel.writeShanxifushengToFile(outputList);

    }

    public static boolean isLegal(List<KeyVariable> list) {
        HashSet<Integer> set = new HashSet<>();
        boolean flag = false;
        for (KeyVariable keyVariable : list) {
            Integer year = getYear(keyVariable.accper);
            if (year == 13 || year == 12) {
                flag = true;
            }
            if (year >= 14) {
                set.add(year);
            }
        }
        return flag && set.size() >= 3;
    }

    public static Integer getYear(String date) {
        return Integer.parseInt(date.substring(2, 4));
    }
}
