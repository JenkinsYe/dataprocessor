package com.jenkinsye.bean;

/**
 * @author YJJ
 * @Date: Created in 12:49 2020-04-11
 */
public class UniqueKey {
    public String stkcd;

    public String accper;

    public UniqueKey(String stkcd, String accper) {
        this.stkcd = stkcd;
        this.accper = accper;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + stkcd.hashCode();
        result = result * 31 + accper.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (!(other instanceof  UniqueKey))
            return false;
        UniqueKey key = (UniqueKey) other;
        return key.accper.equals(accper) && key.stkcd.equals(stkcd);
    }
}
