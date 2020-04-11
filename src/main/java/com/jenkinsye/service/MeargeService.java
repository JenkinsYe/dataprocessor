package com.jenkinsye.service;

import com.jenkinsye.bean.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YJJ
 * @Date: Created in 13:05 2020-04-11
 */
public class MeargeService {

    public static List<Result> merge(HashMap<UniqueKey, Asset> assetHashMap,
                                     HashMap<UniqueKey, Ins> insHashMap,
                                     HashMap<UniqueKey, Scfd> scfdHashMap) {
        List<Result> results = new ArrayList<>();
        int count = 0;
        for (UniqueKey key : assetHashMap.keySet()) {
            System.out.println(count++);
            // 三者都有
            if (insHashMap.containsKey(key) && scfdHashMap.containsKey(key)) {
                Result result = new Result();
                result.accper = key.accper;
                result.stkcd = key.stkcd;

                // scfd
                result.cfo = scfdHashMap.get(key).cfo;

                // ins
                Ins ins = insHashMap.get(key);
                result.operating1 = ins.operating1;
                result.operating2 = ins.operating2;
                result.netp = ins.netp;

                // asset
                Asset asset = assetHashMap.get(key);
                result.ta = asset.ta;
                result.stb = asset.stb;
                result.ltb = asset.ltb;
                result.tl = asset.tl;
                results.add(result);
            }
        }
        return results;
    }
}
