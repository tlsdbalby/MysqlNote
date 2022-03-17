package study.section.two;

public class TestCPUSpeed {
    public static void main(String[] args) {
        long originN = 10000;
        long timeDes = 0;
        while (true){
            long startTimestamp = System.currentTimeMillis();
//            Method1(originN);
//            Method2(originN);
            Method3(originN);
            timeDes = System.currentTimeMillis() - startTimestamp;
//            System.out.println(timeDes);
            if(Math.abs(timeDes - 1000) < 50){
//                System.out.println("O(n)时间复杂度算法计算耗时约为1s（" + timeDes + "ms）的数据规模为" + originN);
//                System.out.println("O(n^2)时间复杂度算法计算耗时约为1s（" + timeDes + "ms）的数据规模为" + originN);
                System.out.println("O(nlogn)时间复杂度算法计算耗时约为1s（" + timeDes + "ms）的数据规模为" + originN);
                break;
            }
            // 当耗时小于1000ms时数据规模扩大，当大于1000ms时数据规模缩小，直到落在1000+-50ms范围内
            if (timeDes > 1000)
                originN =(long)(originN * 0.75);
            else originN *= 2;
        }

    }

    private static void Method1(long n){
        long k = 0;
        for (long i = 0; i < n; i++) {
            k++;
        }
    }

    private static void Method2(long n){
        long k = 0;
        for (long i = 0; i < n; i++) {
            for (long j = 0; j < n; j++) {
                k++;
            }
        }
    }

    private static void Method3(long n){
        long k = 0;
        for (long i = 0; i < n; i++) {
            for (long j = 1; j < n; j*=2) {
                k++;
            }
        }
    }
}
