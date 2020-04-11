package com.jenkinsye;

import com.jenkinsye.bean.*;
import com.jenkinsye.service.MeargeService;
import com.jenkinsye.service.OutputToExcel;
import com.jenkinsye.util.HashMapBuildUtil;
import com.jenkinsye.util.ReadExcelUtil;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // 读文件
        System.out.println("读文件");
        List<Scfd> scfds = ReadExcelUtil.readScfdFromFile("/Users/YJJ/Desktop/FS_scfd.xlsx");
        List<Ins> ins = ReadExcelUtil.readInsFromFile("/Users/YJJ/Desktop/FS_ins.xlsx");
        List<Asset> assets = ReadExcelUtil.readAssetFromFile("/Users/YJJ/Desktop/FS_asset.xlsx");

        // 构建map
        System.out.println("构建map");
        HashMap<UniqueKey, Scfd> scfdHashMap = HashMapBuildUtil.buildScfdMap(scfds);
        HashMap<UniqueKey, Asset> assetHashMap = HashMapBuildUtil.buildAssetMap(assets);
        HashMap<UniqueKey, Ins> insHashMap = HashMapBuildUtil.buildInsMap(ins);

        System.out.println("开始merge");
        List<Result> results = MeargeService.merge(assetHashMap, insHashMap, scfdHashMap);

        results.sort(new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                if (o1.stkcd.equals(o2.stkcd)) {
                    return o1.accper.compareTo(o2.accper);
                }
                return o1.stkcd.compareTo(o2.stkcd);
            }
        });

        System.out.println("开始导出");
        OutputToExcel.writeToFile(results);

    }
}
