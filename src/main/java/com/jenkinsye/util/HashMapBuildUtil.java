package com.jenkinsye.util;

import com.jenkinsye.bean.Asset;
import com.jenkinsye.bean.Ins;
import com.jenkinsye.bean.Scfd;
import com.jenkinsye.bean.UniqueKey;

import java.util.HashMap;
import java.util.List;

/**
 * @author YJJ
 * @Date: Created in 13:00 2020-04-11
 */
public class HashMapBuildUtil {

    public static HashMap<UniqueKey, Asset> buildAssetMap(List<Asset> list) {
        HashMap<UniqueKey, Asset> resultMap = new HashMap<>();
        for (Asset asset : list) {
            UniqueKey key = new UniqueKey(asset.stkcd, asset.accper);
            resultMap.put(key, asset);
        }
        return resultMap;
    }

    public static HashMap<UniqueKey, Ins> buildInsMap(List<Ins> list) {
        HashMap<UniqueKey, Ins> resultMap = new HashMap<>();
        for (Ins ins : list) {
            UniqueKey key = new UniqueKey(ins.stkcd, ins.accper);
            resultMap.put(key, ins);
        }
        return resultMap;
    }

    public static HashMap<UniqueKey, Scfd> buildScfdMap(List<Scfd> list) {
        HashMap<UniqueKey, Scfd> resultMap = new HashMap<>();
        for (Scfd scfd : list) {
            UniqueKey key = new UniqueKey(scfd.stkcd, scfd.accper);
            resultMap.put(key, scfd);
        }
        return resultMap;
    }
}
