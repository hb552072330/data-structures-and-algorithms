package cn.baymax;

import com.xuanner.dt.Dt;
import com.xuanner.dt.lock.DtLock;

/**
 * @author zhanghongbing
 * @data 2022/7/21
 */
public class DtRedisLock {
    public static void main(String[] args) {
        DtLock dtLock = Dt.newDtLock("test", 60);

        String lockId = dtLock.tryLock();
        if(lockId !=null){
            dtLock.unLock(lockId);
        }
    }
}
