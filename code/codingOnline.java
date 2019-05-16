public class codingOnline {
}

整数乘积
        题目：给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)

        import java.util.Scanner;
        import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] array= new long[n];
        for(int i=0;i<n;i++){
            array[i] = scan.nextInt();
        }
        System.out.print(getLargeExp(array,n));
    }
    static long getLargeExp(long[] array,int n){
        long max1=0,max2=0,max3=0,min1=0,min2=0;
        for(int i=0;i<n;i++){
            if(array[i]!=0){
                if(array[i]>max1){
                    max3=max2;
                    max2=max1;
                    max1=array[i];
                }
                else if(array[i]>max2){
                    max3=max2;
                    max2=array[i];
                }
                else if (array[i]>max3){
                    max3=array[i];
                }
                else if(array[i]<min2){
                    min1=min2;
                    min2=array[i];
                }
                else if(array[i]<min1){
                    min1=array[i];
                }
            }
        }
        return max1*max2*max3>max1*min1*min2?max1*max2*max3:max1*min1*min2;
    }

}

六一儿童节
        题目：六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。

        1
        2
        3
        4
        5
        6
        7
        8
        9
        10
        11
        12
        13
        14
        15
        16
        17
        18
        19
        20
        21
        22
        23
        24
        25
        26
        27
        28
        29
        30
        31
        32
        33
        34
        35	import java.util.Arrays;
        import java.util.Scanner; public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// n个学生
        int[] h = new int[n];// 学生
        for (int i = 0; i < h.length; i++) {
            h[i] = sc.nextInt();
        }

        int m = sc.nextInt();// m个巧克力
        int[] w = new int[m];// 巧克力
        for (int i = 0; i < w.length; i++) {
            w[i] = sc.nextInt();
        }

        Arrays.sort(w);// 巧克力排序
        Arrays.sort(h);// 学生排序

        int stuStart = 0;
        int count = 0;
        for (int i = 0; i < w.length; i++) {
            if (w[i] < h[stuStart]) {// 如果最小的巧克力比最小的学生要的小,那么跳出去下一个巧克力
                continue;
            } else {// 如果最小的巧克力比最小的学生要的大
                count++;// 那就把这个糖果给他,count加1
                stuStart++;// 给他后,把最小的学生加一个
                if (stuStart == n) {// 如果最后一个学生都有糖了,就不找了,break掉
                    break;
                }
            }
        }
        System.out.println(count);
    }
}



1
        2
        3
        4
        5
        6
        7
        8
        9
        10
        11
        12
        13
        14
        15
        16
        17
        18
        19	    /*

    m为巧克力个数，n为学生个数

    h[i] 表示第i颗巧克力分别的大小

    w[j] 表示第j个同学要求的巧克力大小，当h[i]>=w[j]时才会上台表演

    对h[i],w[j]由小到大排序后比较

    */

        for(i=0; i<m&&j<n; i++) {
        if(h[i] >= w[j]) {
        res++;
        j++;
        }
        }
        System.out.println(res);
        大整数相乘（字符串相乘）
        import java.util.Scanner;
/**
 •	Created by linjian on 17/8/5.
 */
public class Main {
    public static void main(String[] args) {
•	 Scanner scanner = new Scanner(System.in);
•	 String num1 = scanner.next();
•	 String num2 = scanner.next();
•	 System.out.println(multiply(num1,num2));
    }
    public static String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        // even 99 * 99 is < 10000, so maximaly 4 digits
        int[] d = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                d[i + j] += a * b;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.length; i++) {
            int digit = d[i] % 10;
            int carry = d[i] / 10;
            sb.insert(0, digit);
            if (i < d.length - 1)
                d[i + 1] += carry;
        }
        //trim starting zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}


彩色的砖块
        小易有一些彩色的砖块。每种颜色由一个大写字母表示。各个颜色砖块看起来都完全一样。现在有一个给定的字符串s,s中每个字符代表小易的某个砖块的颜色。小易想把他所有的砖块排成一行。如果最多存在一对不同颜色的相邻砖块,那么这行砖块就很漂亮的。请你帮助小易计算有多少种方式将他所有砖块排成漂亮的一行。(如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的。)
        例如: s = "ABAB",那么小易有六种排列的结果:
        "AABB","ABAB","ABBA","BAAB","BABA","BBAA"
        其中只有"AABB"和"BBAA"满足最多只有一对不同颜色的相邻砖块。

        3
        4
        5
        6
        7
        8
        9
        10
        11
        12
        13
        14
        15
        16
        17
        18
        19
        20
        21
        22
        23	package sort;

        import java.util.HashSet;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        // 用hashSet记录字符串中有几种字符
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            hashSet.add(string.substring(i, i + 1));
            // 如果一旦有两种以上的字符就输出0
            if (hashSet.size() > 2) {
                System.out.println(0);
                return;
            }
        }
        // 有两种字符就输出2，有一种字符就输出1
        System.out.println(hashSet.size());
    }
}


1
        2
        3
        4
        5
        6
        7	s = raw_input()
        if len(set(s)) == 2:
        print 2
        elif len(set(s)) == 1:
        print 1
        else:
        print 0

        等差数列
        如果一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d, 这里的d也可以是负数和零,我们就称数列S为等差数列。
        小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。小易允许在数列上做交换任意两个位置的数值的操作,并且交换操作允许交换多次。但是有些数列通过交换还是不能变成等差数列,小易需要判别一个数列是否能通过交换操作变成等差数列

        import java.util.Scanner;
        import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for(int i = 0; i < num ;i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        //需要定义一个布尔变量标记是否成功
        boolean flag = true;
        int d = arr[1] - arr[0];
        for(int i = 2;i<arr.length;i++){
            if(arr[i] - arr[i-1] != d){

                flag = false;
            }
        }
        if(flag){
            System.out.println("Possible");
        }else{
            System.out.println("Impossible");
        }

    }
}


交错01串


        如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: "1","10101","0101010"都是交错01串。
        小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。

        思路：遍历一遍数组记录最长的01交错子串长度就完了
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String str = in.next();
            int maxLen = 1;
            int len = 1;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i - 1) != str.charAt(i)) {
                    len++;
                    if (len > maxLen) {
                        maxLen = len;
                    }
                } else {
                    len = 1;
                }
            }
            System.out.println(maxLen);
        }
    }
}

操作序列
        小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
        1、将a_i放入b序列的末尾
        2、逆置b序列
        小易需要你计算输出操作n次之后的b序列。

        链接：https://www.nowcoder.com/questionTerminal/b53bda356a494154b6411d80380295f5?source=relative
        来源：牛客网
        1
        2
        3
        4
        5
        6
        7
        8
        9
        10
        11
        12
        13
        14
        15
        16
        17
        18
        19
        20
        21
        22
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            for (int i = n - 1; i >= 0; i -= 2) {     // 前一半从最后一个数开始以2为步长递减
                System.out.print(nums[i] + " ");
            }
            for (int i = n % 2; i < n - 2; i += 2) {  // 后一半根据整数个数的奇偶，分别从第二个或第一个数开始以2为步长递增
                System.out.print(nums[i] + " ");
            }
            System.out.print(nums[n - 2]);  // 最后一个数
        }
    }
}

链接：https://www.nowcoder.com/questionTerminal/b53bda356a494154b6411d80380295f5?source=relative
        来源：牛客网
//规律题
//n = 1,b = 1    n = 1直接输出
//n = 2,b = 2,1
//n = 3,b = 3,1,2
//n = 4,b = 4,2,1,3
//n = 5,b = 5,3,1,2,4
//n = 6,b = 6,4,2,1,3,5
//由上述可推，当n 为奇数时，
//先从后向前输出奇数位置的数字，再从前向后输出偶数位置的数字
//当n 为偶数时
//先从后向前输出偶数位置的数字，再从前向后输出奇数位置的数字

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.Scanner;

public class test4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] array = new int [n];
        for(int i = 0;i < n;i++){
            array[i] = scanner.nextInt();
        }
        if(n == 1){
            System.out.println(array[0]);
        }
        if(n % 2 == 0){
            for(int i = n-1;i >= 0;i -= 2){
                System.out.print(array[i] + " ");
            }
            for(int i = 0;i < n - 2;i += 2){
                System.out.print(array[i] + " ");

            }
            System.out.print(array[n-2]);
        }
        else { //n % 2 == 1
            for(int i = n-1;i >= 0;i -= 2){
                System.out.print(array[i] + " ");
            }
            for(int i = 1;i < n - 2;i += 2){
                System.out.print(array[i] + " ");
            }
            System.out.print(array[n-2]);
        }
    }

}


独立的小易（牛牛租房）


        小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。

        import java.util.Scanner;

public class wy5 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        System.out.print(liveDays(x, f, d, p));
    }

    /**
     * 思路：如果水果足够多，只需要算能支付多少天房租就可以。否则计算f+(d-f*x)/(x+p)
     * @param x：每天房租
     * @param f：已有f个水果
     * @param d：已有d元钱
     * @param p：商店每个水果卖p元
     * <a data-card-uid="547241" href="/profile/547241" target="_blank">@return */
    public static int liveDays(int x, int f, int d, int p) {
        if (x * f >= d)
            return d / x;
        d = d - f * x;
        return f + d / (x + p);
    }
}

链接：https://www.nowcoder.com/questionTerminal/a99cdf4e2f44499e80749699cc2ec2b9?source=relative
        来源：牛客网
        以下代码，不考虑水果可以出售的情况
        如果水果可以出售就更简单了，把水果换算成钱，除以每天的花费（房租和水果）
        1
        2
        3
        4
        5
        6
        7
        8
        9
        10
        11
        12
        13
        14
        15
        16
        17
        18	import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int rentPay=sc.nextInt();
        int appleNum=sc.nextInt();
        int totalMoney=sc.nextInt();
        int applePrice=sc.nextInt();

        if(totalMoney/rentPay<=appleNum)
            System.out.println(totalMoney/rentPay);
        else
            System.out.println(appleNum+(totalMoney-appleNum*rentPay)/(applePrice+rentPay));

        sc.close();
    }
}


堆棋子

        小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行y[i]列。同一个格子允许放置多个棋子。每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.
//贴上左神的代码，思路其实大家写的答案里已经有了
//但是左神的代码还是简洁很多

        import java.util.PriorityQueue;
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] x = new int[size];
            int[] y = new int[size];
            for (int i = 0; i < size; i++) {
                x[i] = in.nextInt();
            }
            for (int i = 0; i < size; i++) {
                y[i] = in.nextInt();
            }
            int[] res = minOPs(size, x, y);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < size; i++) {
                result.append(String.valueOf(res[i]) + " ");
            }
            System.out.println(result.toString().trim());
        }
        in.close();
    }

    public static int[] minOPs(int size, int[] x, int[] y) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    pq.add(Math.abs(x[k] - x[i]) + Math.abs(y[k] - y[j]));
                }
                int resI = 0;
                int sum = 0;
                while (!pq.isEmpty()) {
                    sum += pq.poll();
                    res[resI] = Math.min(res[resI], sum);
                    resI++;
                }
            }
        }
        return res;
    }

}

疯狂队列
        小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,并且他要求学生按照身高不递减的顺序排列。有一次,n个学生在列队的时候,小易老师正好去卫生间了。学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。由于按照身高顺序排列的队列的疯狂值是最小的,他们当然决定按照疯狂值最大的顺序来进行列队。现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。小易老师回来一定会气得半死。
        输入描述:
        输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示学生的人数
        第二行为n个整数h[i](1 ≤ h[i] ≤ 1000),表示每个学生的身高


        输出描述:
        输出一个整数,表示n个学生列队可以获得的最大的疯狂值。

        如样例所示:
        当队列排列顺序是: 25-10-40-5-25, 身高差绝对值的总和为15+30+35+20=100。
        这是最大的疯狂值了。

        思路：将原数列排好序，每次取数列中的最大与最小值加入到疯狂队列中（想象一下疯狂队列从中间向两边扩展），与上一次加入的最小与最大值交叉做差，直到原数列中仅剩最后一个值，把它放到疯狂队列合适的位置上保证疯狂值最大即可。

        1
        2
        3
        4
        5
        6
        7
        8
        9
        10
        11
        12
        13
        14
        15
        16
        17
        18
        19
        20
        21
        22
        23
        24
        25
        26
        27
        28
        29
        30
        31	import java.util.Arrays;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            int min = nums[0];      // 上一次加入疯狂队列的那个最小值
            int max = nums[n - 1];  // 上一次加入疯狂队列的那个最大值
            int diff = max - min;
            int minIndex = 1;       // 未加入疯狂队列的最小值索引
            int maxIndex = n - 2;   // 未加入疯狂队列的最大值索引
            while (minIndex < maxIndex) {
                diff += max - nums[minIndex];
                diff += nums[maxIndex] - min;
                min = nums[minIndex++];
                max = nums[maxIndex--];
            }
            // 原数列中最后一个数 minIndex == maxIndex，将它放到合适的位置上
            diff += Math.max(nums[maxIndex] - min, max - nums[minIndex]);
            System.out.println(diff);
        }
    }
}


牛客网编程题常用思路
        1.求最大公因数

        int gcd(int x,int y){
        return (x>=y)?(x%y==0?y:gcd(y,x%y)):(y%x==0?x:gcd(x,y%x));
        }
        1
        2
        3
        2.求各位数字之和

        int sum(int x){
        int res;
        while(x/10!=0){
        res+=x%10;
        x=x/10;
        if(x/10==0)
        res+=x;
        }
        return res;
        }
        1
        2
        3
        4
        5
        6
        7
        8
        9
        10
        3.数字反转

        int reverse(int x){
        int res=0;
        int dig=0;
        int y=x;
        while(x/10!=0){
        dig++;
        x=x/10;
        }
        while(y/10!=0){
        int temp=y%10;
        res+=temp*pow(10,dig);
        y=y/10;
        dig--;
        if(y/10==0)
        res+=y;
        }
        return res;
        }


        小易喜欢的数列
        小易非常喜欢拥有以下性质的数列:
        1、数列的长度为n
        2、数列中的每个数都在1到k之间(包括1和k)
        3、对于位置相邻的两个数A和B(A在B前),都满足(A <= B)或(A mod B != 0)(满足其一即可)
        例如,当n = 4, k = 7
        那么{1,7,7,2},它的长度是4,所有数字也在1到7范围内,并且满足第三条性质,所以小易是喜欢这个数列的
        但是小易不喜欢{4,4,4,2}这个数列。小易给出n和k,希望你能帮他求出有多少个是他会喜欢的数列。
        输入描述:
        输入包括两个整数n和k(1 ≤ n ≤ 10, 1 ≤ k ≤ 10^5)


        输出描述:
        输出一个整数,即满足要求的数列个数,因为答案可能很大,输出对1,000,000,007取模的结果。

        思路：state[i][j]表示整个状态空间，其中i(1<=i<=n)表示数列的长度，j(1<=j<=k)表示数列长度为i且以数字j结尾。
        递推关系有：state[i][j] += state[i-1][m] (1<=m<=k, 并且(m,j)是个合法的数列)，但是直接按照递推关系，用三层for循环会超时。为此可以先将长度为i-1的合法数列求和(记为sum)。然后对于数列长度为i的每一个j，求出数列长度为i-1时非法的序列个数（记为invalid）,即有state[i][j] = sum - invalid。
        对于invalid求取，可以参照素数筛选。算法的时间复杂度大概为O(nkloglogk)
        1
        2
        3
        4
        5
        6
        7
        8
        9
        10
        11
        12
        13
        14
        15
        16
        17
        18
        19
        20
        21
        22
        23
        24
        25
        26
        27
        28
        29
        30
        31
        32
        33
        34
        35
        36
        37
        38	import java.util.Scanner;

public class Main {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] state = new int[n+1][k+1];

        state[0][1] = 1;

        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=1; j<=k; j++) {
                sum = (sum + state[i-1][j]) % mod;
            }
            for(int j=1; j<=k; j++) {
                int invalid = 0;
                int p = 2;
                while(p*j <= k) {
                    invalid = (invalid + state[i-1][p*j]) % mod;
                    p++;
                }
                state[i][j] = (sum - invalid + mod) % mod;
            }
        }

        int sum = 0;
        for(int i=1; i<=k; i++) {
            sum = (sum + state[n][i]) % mod;
        }
        System.out.println(sum);

        scanner.close();
    }
}

    括号匹配问题
            括号配对问题
时间限制：3000 ms  |  内存限制：65535 KB
        难度：3
        描述
        现在，有一行括号序列，请你检查这行括号是否配对。
        输入
        第一行输入一个数N（0<N<=100）,表示有N组测试数据。后面的N行输入多组输入数据，每组输入数据都是一个字符串S(S的长度小于10000，且S不是空串），测试数据组数少于5组。数据保证S中只含有"[","]","(",")"四种字符
        输出
        每组输入数据的输出占一行，如果该字符串中所含的括号是配对的，则输出Yes,如果不配对则输出No
        样例输入
        3
        [(])
        (])
        ([[]()])样例输出
        No
        No
        Yes来源
        网络
        上传者
        naonao




        import java.util.*;
public class 括号匹配2_2013_5_23 {//
    public static void main(String[] args) {
//Bracket B=new Bracket();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while (n-- > 0) {
            String a = input.next();

            if (Bracket.isMatch(a))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    public static class Bracket{
        static boolean isMatch(String b){
            boolean m = true;
            Stack<Character> st = new Stack<Character>();
            for (int i = 0; i < b.length(); i++) {
                char p = b.charAt(i);
                if (p == '[' || p == '(')
                    st.push(p);
                if (p == ']' || p == ')') {
                    if (st.isEmpty()) {
                        m = false;
                        break;
                    }
                    else {
                        if ((p == ']' && st.peek() == '[')
                                || (p == ')' && st.peek() == '(')

                        st.pop();
else {
                            m = false;
                            break;
                        }
                    }
                }
            }
            if(!st.isEmpty())m=false;
            return m;
        }

    }


}








  /*//BufferedReader读取字符速度更快
 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;


public class 括号匹配2013_5_23  {


public static void main(String[] args) {//==========效率更高===========，


BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String str = null;
Stack<Character> stack = new Stack<Character>();


try{
int cases = Integer.valueOf(br.readLine());
while(cases-->0){


str = br.readLine();
int strLength = str.length();
boolean isMatch = true;
stack.clear();
stack.push('#');
for(int i = 0; i < strLength; ++i){
char ch = str.charAt(i);
switch(ch){
case '(':
stack.push(ch);
break;
case '[':
stack.push(ch);
break;
case ')':
if(stack.pop() != '('){
isMatch = false;
}
break;
case ']':
if(stack.pop() != '['){
isMatch = false;
}
break;
default:
isMatch = false;
break;
}
if(!isMatch){
break;
}
}
if(isMatch&&stack.pop()=='#'){
System.out.println("Yes");
}else{
System.out.println("No");
}
}
}catch(Exception e){
e.printStackTrace();
}
}
}
*/

替换空格
        题目：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

public class Solution {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" " , "%20");
    }
}

//思路
//1：从前往后插入，这样移动•的次数多不建议
//2：从后往前插入

class Solution {
    public:
    void replaceSpace(char *str,int length) {
        //遍历一边字符串找出空格的数量
        if(str==NULL||length<0)
            return ;
        int i=0;
        int oldnumber=0;//记录以前的长度
        int replacenumber=0;//记录空格的数量
        while(str[i]!='\0')
        {
            oldnumber++;
            if(str[i]==' ')
            {
                replacenumber++;
            }
            i++;
        }
        int newlength=oldnumber+replacenumber*2;//插入后的长度
        if(newlength>length)//如果计算后的长度大于总长度就无法插入
            return ;
        int pOldlength=oldnumber; //注意不要减一因为隐藏个‘\0’也要算里
        int pNewlength=newlength;
        while(pOldlength>=0&&pNewlength>pOldlength)//放字符
        {
            if(str[pOldlength]==' ') //碰到空格就替换
            {
                str[pNewlength--]='0';
                str[pNewlength--]='2';
                str[pNewlength--]='%';

            }
            else //不是空格就把pOldlength指向的字符装入pNewlength指向的位置
            {
                str[pNewlength--]=str[pOldlength];

            }
            pOldlength--; //不管是if还是elsr都要把pOldlength前移

        }


    }
};

•	剑指offer的思路.就是一个空格变成了%20，也就是说每有一个空格，长度要增加2，所以首先先计算有多少个空格，这样长度就能增加多少，得到增加后的长度Length。
        •	然后new一个Length长度的字符数组，从尾到头开始复制原来的数组，如果复制过程中，如果字符不是空格，直接复制，如果字符是空格，那么需要把这个空格变成%20（这个复制过程就是把新建的数组比如现在到了 K这个位置，然后就是K，K-1，K-2这三个位置依次变成0,2，%这三个字符，因为是从后往前复制的所以是倒序），重复这个过程就行。
        如果相等，返回true;
        代码
        1import java.util.*;
        2public class Solution {
 3    public String replaceSpace(StringBuffer str) {
        4        String str1 = str.toString();
        5        if(str1.equals(""))
            6            return str1;
        7        char [] strArray = str1.toCharArray();
        8        int i =0;
        9        int lengthSpace = 0;
        10        while(i < strArray.length)
            11        {
            12            if(strArray[i] == ' ')
                13                lengthSpace++;
            14            i++;
            15        }
        16        int newStrLength = strArray.length + lengthSpace*2;
        17        char [] newStr = new char[newStrLength];
        18        int j = newStrLength-1;
        19        i = strArray.length - 1;
        20        while(i >= 0)
            21        {
            22            if(strArray[i] !=  ' ')
                23            {
                24                newStr[j--] = strArray[i--];
                25            }else{
                26                newStr[j--] = '0';
                27                newStr[j--] = '2';
                28                newStr[j--] = '%';
                29                i--;
                30            }
            31        }
        32        return new String(newStr);
        33    }
34}
代码讲解
        •	7行把字符串转换成字符数组
        •	8-15行 计算有多少个空格，16行就是计算新的字符数组的长度（每有一个空格，长度增加2）
        •	20-31行就是复制过程，22-24行就是如果原来的旧的字符数组不是空格这个字符，那么新数组与旧数组的值一样；
        •	25-29行就是如果旧的字符数组是空格，那么新的字符数组这时候就得把j,j-1,j-2这三个位置变成0,2,%，然后重复20-31行这个过程就行。


        01背包问题
        有N件物品和一个容量为V的背包。第i件物品的费用是c，价值是w。求解将哪些装入背包可使这些物品的费用总和不超过背包容量，且价值最大。
        （用Java语言实现，先写编程思路，再写代码，不写编程思路扣分）
public class BackPack {
    public static void main(String[] args) {
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        int c[][] = BackPack_Solution(m, n, w, p);
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                System.out.print(c[i][j]+"\t");
                if(j==m){
                    System.out.println();
                }
            }
        }
        //printPack(c, w, m, n);

    }

    /**
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param w 表示商品重量数组
     * @param p 表示商品价值数组
     */
    public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            c[i][0] = 0;
        for (int j = 0; j < m + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1]))
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    else
                        c[i][j] = c[i - 1][j];
                } else
                    c[i][j] = c[i - 1][j];
            }
        }
        return c;
    }

    冒泡排序
    比较相邻的元素。如果第一个比第二个大（升序），就交换他们两个。
    对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
    针对所有的元素重复以上的步骤，除了最后一个。
    持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
    所以设置一个外循环控制每次比较的此时。内循环进行比较，如第一次外循环也就是第一个元素需要比较n-1次，每次都是前一个和后一个比较，所以内循环每次只需要比较外层的前一个。第二种：如果这个序列是一个有序的，那么此时不用每个都进行比较，一旦比较的中间一次没有交换数据，说明这个序列已经是有序了。所以可以设置一个标志位。一旦一个循环比较没有交换，将标志位设置为false，跳出循环。

            package 冒泡排序;
import java.util.Arrays;
    /**
     * 冒泡排序改进版
     * @author mmz
     *
     */
    public class BubbleSort1 {
        public static void BubbleSort(int[] arr) {
            boolean flag = true;
            while(flag){
                int temp;//定义一个临时变量
                for(int i=0;i<arr.length-1;i++){//冒泡趟数，n-1趟
                    flag = false;
                    for(int j=0;j<arr.length-i-1;j++){
                        if(arr[j+1]<arr[j]){
                            temp = arr[j];
                            arr[j] = arr[j+1];
                            arr[j+1] = temp;
                            flag = true;
                        }
                    }
                    if(!flag){
                        break;//若果没有发生交换，则退出循环
                    }
                }
            }
        }
        public static void main(String[] args) {
            int arr[] = new int[]{1,6,2,2,5};
            BubbleSort.BubbleSort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    四则运算
            请实现如下接口
    /* 功能：四则运算
     * 输入：strExpression：字符串格式的算术表达式，如: "3+2*{1+2*[-4/(8-6)+7]}"
     * 返回：算术表达式的计算结果
     */
    public static int calculate(String strExpression)
    {
        /* 请实现*/
        return 0;
    }
    约束：
            1.	pucExpression字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。
            2.	pucExpression算术表达式的有效性由调用者保证;



    输入描述:
    输入一个算术表达式

    输出描述:
    得到计算结果
            示例1
    输入
3+2*{1+2*[-4/(8-6)+7]}
    输出
25


    使用Python
    print(eval(input()))

    Java版解决方案
    public class Main{
        // 用于存放一个正括号的集合, 用于简化代码
        static Set<Character> brace = new HashSet<>();
        public static void main(String ... args){
            Scanner sc = new Scanner(System.in);
            // 初始化正括号集合 他这里处理括号的方式有些不懂,我是直接替换的
            brace.add('{');
            brace.add('(');
            brace.add('[');
            while(sc.hasNextLine()){
                // 对字符串做初始化处理，原则有二:
                // 1、处理负数，这里在-前面的位置加入一个0，如-4变为0-4，
                // 细节：注意-开头的地方前面一定不能是数字或者反括号，如9-0,(3-4)-5，这里地方是不能加0的
                // 它的后面可以是数字或者正括号，如-9=>0-9, -(3*3)=>0-(3*3)
                // 2、处理字符串，在最后的位置加#, 主要是为了防止最后一个整数无法处理的问题
                String exp = sc.nextLine().replaceAll("(?<![0-9)}\\]])(?=-[0-9({\\[])", "0") + "#";
                System.out.println(calculate(exp));
            }
        }
        private static int calculate(String exp){
            // 初始化栈
            Stack<Integer> opStack = new Stack<>();
            Stack<Character> otStack = new Stack<>();

            // 整数记录器  当num是多位时将 num += c 知道遇见运算符
            String num = "";
            for(int i = 0; i < exp.length(); i++){
                // 抽取字符
                char c = exp.charAt(i);
                // 如果字符是数字，则加这个数字累加到num后面
                if(Character.isDigit(c)){
                    num += c;
                }
                // 如果不是数字
                else{
                    // 如果有字符串被记录，则操作数入栈，并清空
                    if(!num.isEmpty()){
                        int n = Integer.parseInt(num);
                        num = "";
                        opStack.push(n);
                    }
                    // 如果遇上了终结符则退出
                    if(c == '#')
                        break;
                        // 如果遇上了+-
                    else if(c == '+' || c == '-'){
                        // 空栈或者操作符栈顶遇到正括号，则入栈
                        if(otStack.isEmpty() || brace.contains(otStack.peek())){
                            otStack.push(c);
                        } else {
                            // 否则一直做弹栈计算，直到空或者遇到正括号为止，最后入栈
                            while(!otStack.isEmpty() && !brace.contains(otStack.peek()))
                                popAndCal(opStack, otStack);
                            otStack.push(c);
                        }
                    }
                    // 如果遇上*/
                    else if(c == '*' || c == '/'){
                        // 空栈或者遇到操作符栈顶是括号，或者遇到优先级低的运算符，则入栈
                        if(otStack.isEmpty()
                                || brace.contains(otStack.peek())
                                || otStack.peek() == '+' || otStack.peek() == '-'){
                            otStack.push(c);
                        }else{
                            // 否则遇到*或/则一直做弹栈计算，直到栈顶是优先级比自己低的符号，最后入栈
                            while(!otStack.isEmpty()
                                    && otStack.peek() != '+' && otStack.peek() != '-'
                                    && !brace.contains(otStack.peek()))
                                popAndCal(opStack, otStack);
                            otStack.push(c);
                        }
                    } else {
                        // 如果是正括号就压栈
                        if(brace.contains(c))
                            otStack.push(c);
                        else{
                            // 反括号就一直做弹栈计算，直到遇到正括号为止
                            char r = getBrace(c);
                            while(otStack.peek() != r){
                                popAndCal(opStack, otStack);
                            }
                            // 最后弹出正括号
                            otStack.pop();
                        }
                    }
                }
            }
            // 将剩下的计算完，直到运算符栈为空
            while(!otStack.isEmpty())
                popAndCal(opStack, otStack);
            // 返回结果
            return opStack.pop();
        }
        private static void popAndCal(Stack<Integer> opStack, Stack<Character> otStack){
            int op2 = opStack.pop();
            int op1 = opStack.pop();
            char ot = otStack.pop();
            int res = 0;
            switch(ot){
                case '+':
                    res = op1 + op2;
                    break;
                case '-':
                    res = op1 - op2;
                    break;
                case '*':
                    res = op1 * op2;
                    break;
                case '/':
                    res = op1 / op2;
                    break;
            }
            opStack.push(res);
        }
        private static char getBrace(char brace){
            switch(brace){
                case ')':
                    return '(';
                case ']':
                    return '[';
                case '}':
                    return '{';
            }
            return '#';
        }
    }



    合唱团

    有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
    输入描述:
    每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。

    输出描述:
    输出一行表示最大的乘积。
    示例1
            输入
3
        7 4 7
        2 50
    输出
49

        import java.util.Scanner;

    public class Main {
        // 参考 【小刀初试】的算法思想， Java版本，便于理解
        public static void main(String[] args) {
            Scanner cin = new Scanner(System.in);
            while (cin.hasNextInt()) {
                int n = cin.nextInt();          // n 个学生
                int[] arr = new int [n+1];
                for (int i = 1; i <=n ; i++) {
                    arr[i] = cin.nextInt();
                }
                int K = cin.nextInt();            // 选出K个
                int d = cin.nextInt();            // 两个学生的位置编号的差不超过 d
                long[][] fmax = new long[K+1][n+1]; // 记录最大乘积
                long[][] fmin = new long[K+1][n+1]; // 记录最小乘积
                // fmax[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最大乘积；
                // fmin[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最小乘积；
                //初始化第一行
                long  res = Integer.MIN_VALUE; // 记得用Long类型，考虑数值范围
                for (int i = 1; i <=n; i++) {
                    fmax[1][i] = arr[i];
                    fmin[1][i] = arr[i];
                    for (int k = 2; k <=K; k++) {
                        for (int j = i-1 ; j > 0 &&  i-j<=d ; j--) {
                            fmax[k][i] = Math.max(fmax[k][i], Math.max(fmax[k-1][j] * arr[i], fmin[k-1][j] * arr[i]));
                            fmin[k][i] = Math.min(fmin[k][i], Math.min(fmax[k-1][j] * arr[i], fmin[k-1][j] * arr[i]));
                        }
                    }
                    res = Math.max(res ,fmax[K][i]);
                }
                System.out.println(res);
            }
        }
    }
    之字形打印矩阵
    对于一个矩阵，请设计一个算法，将元素按“之”字形打印。具体见样例。
    给定一个整数矩阵mat，以及他的维数nxm，请返回一个数组，其中元素依次为打印的数字。
    测试样例：
            [[1,2,3],[4,5,6],[7,8,9],[10,11,12]],4,3
    返回：[1,2,3,6,5,4,7,8,9,12,11,10]

    public int[] printMatrix(int[][] mat, int n, int m) {
        int[] arr = new int [n*m];
        //hang记录你的行数，count记录的是你返回的字符数组的长度
        int hang = 0;
        int count = 0;
        //偶数行顺序，奇数行倒序
        for(int i = 0; i < mat.length; i++ ){
            for(int j = 0; j < mat[i].length; j++){
                //判断数奇数行还是偶数行
                if(hang%2 == 0){
                    arr[count++] = mat[i][j];
                }else{
                    arr[count++] = mat[i][m-1-j];
                }
            }
            //写完了一行，行数需要+1
            hang++;
        }
        return arr;
    }

    地牢逃脱
    链接：https://www.nowcoder.com/questionTerminal/0385945b7d834a99bc0010e67f892e38
    来源：牛客网

    给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，牛牛从 (x0 , y0 ) 位置出发，遍历这个地牢，和一般的游戏所不同的是，他每一步只能按照一些指定的步长遍历地牢，要求每一步都不可以超过地牢的边界，也不能到达障碍上。地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。
    输入描述:
    每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 50），表示地牢的长和宽。接下来的 n 行，每行 m 个字符，描述地牢，地牢将至少包含两个 '.'。接下来的一行，包含两个整数 x0, y0，表示牛牛的出发位置（0 <= x0 < n, 0 <= y0 < m，左上角的坐标为 （0, 0），出发位置一定是 '.'）。之后的一行包含一个整数 k（0 < k <= 50）表示牛牛合法的步长数，接下来的 k 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长（-50 <= dx, dy <= 50）

    输出描述:
    输出一行一个数字表示最坏情况下需要多少次移动可以离开地牢，如果永远无法离开，输出 -1。以下测试用例中，牛牛可以上下左右移动，在所有可通行的位置.上，地牢出口如果被设置在右下角，牛牛想离开需要移动的次数最多，为3次。
    示例1
            输入
3 3
        ...
        ...
        ...
        0 1
        4
        1 0
        0 1
        -1 0
        0 -1
    输出
3

        import java.util.*;

    public class Main {
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);

            while (in.hasNext()) {//注意while处理多个case
                int x=in.nextInt();
                int y=in.nextInt();

                char[][] points=new char[x][y];
                int[][] tar=new int[x][y];
                for(int i=0;i<x;i++){
                    String str=in.next();
                    points[i]=str.toCharArray();
                }
                int startx=in.nextInt();
                int starty=in.nextInt();
                int k=in.nextInt();
                int[] stepx=new int[k];
                int[] stepy=new int[k];
                for(int i=0;i<k;i++){
                    stepx[i]=in.nextInt();
                    stepy[i]=in.nextInt();
                }
                Queue<Integer> xqueue=new LinkedList<Integer>();
                Queue<Integer> yqueue=new LinkedList<Integer>();
                //引入队列是为了遍历到最后不能走为止

                xqueue.add(startx);
                yqueue.add(starty);

                tar[startx][starty]=1;  //起始点访问标记；1表示已经访问
                while(!xqueue.isEmpty()&&!yqueue.isEmpty()){
                    startx=xqueue.remove();    //取队首
                    starty=yqueue.remove();
                    for(int i=0;i<k;i++){
                        if(startx+stepx[i]<x&&startx+stepx[i]>=0&&starty+stepy[i]<y&&starty+stepy[i]>=0)   //不出界
                            if(tar[startx+stepx[i]][starty+stepy[i]]==0){
                                if(points[startx+stepx[i]][starty+stepy[i]]=='.'){
                                    tar[startx+stepx[i]][starty+stepy[i]]=tar[startx][starty]+1;
                                    xqueue.add(startx+stepx[i]);
                                    yqueue.add(starty+stepy[i]);
                                }
                                else
                                    tar[startx+stepx[i]][starty+stepy[i]]=-1;  //访问点为X
                            }
                    }
                }
                int max=0;
                int getRoad=1;
                for(int i=0;i<x;i++)
                    for(int j=0;j<y;j++){
                        if(points[i][j]=='.'&&tar[i][j]==0){
                            getRoad=0;   //有存在没有被访问的“.”说明不能遍历完全，有些出口到不了。
                        }
                        max=Math.max(max, tar[i][j]);
                    }
                if(getRoad==0)
                    System.out.println(-1);
                else
                    System.out.println(max-1);

            }
        }
    }

    循环数比较

    对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
    牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
    输入描述:
    输入包括一行,一行中有4个正整数x1, k1, x2, k2(1 ≤ x1,x2 ≤ 10^9, 1 ≤ k1,k2 ≤ 50),以空格分割

    输出描述:
    如果v1小于v2输出"Less",v1等于v2输出"Equal",v1大于v2输出"Greater".
    示例1
            输入
1010 3 101010 2
    输出
            Equal

    链接：https://www.nowcoder.com/questionTerminal/24575008c6134b6fa4fab8ea0ea82a99
    来源：牛客网
import java.util.Scanner;

    public class aqy1 {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int x1 = sc.nextInt();
            int k1 = sc.nextInt();
            int x2 = sc.nextInt();
            int k2 = sc.nextInt();
            compare(x1, k1, x2, k2);
        }

        public static void compare(int x1, int k1, int x2, int k2) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            while (k1-- > 0) sb1.append(x1 + "");
            while (k2-- > 0) sb2.append(x2 + "");
            int l1 = sb1.length(), l2 = sb2.length();
            if (l1 > l2) {
                System.out.println("Greater");
                return;
            } else if (l1 < l2) {
                System.out.println("Less");
                return;
            }
            for (int i = 0; i < l1; ++i)
                if (sb1.charAt(i) > sb2.charAt(i)) {
                    System.out.println("Greater");
                    return;
                } else if (sb1.charAt(i) < sb2.charAt(i)) {
                    System.out.println("Less");
                    return;
                }
            System.out.println("Equal");
        }
    }
    DNA序列
    链接：https://www.nowcoder.com/questionTerminal/ab900f183e054c6d8769f2df977223b5
    来源：牛客网

    牛牛又从生物科研工作者那里获得一个任务,这次牛牛需要帮助科研工作者从DNA序列s中找出最短没有出现在DNA序列s中的DNA片段的长度。
    例如:s = AGGTCTA
    序列中包含了所有长度为1的('A','C','G','T')片段,但是长度为2的没有全部包含,例如序列中不包含"AA",所以输出2。
    输入描述:
    输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 2000),其中只包含'A','C','G','T'这四种字符。

    输出描述:
    输出一个正整数,即最短没有出现在DNA序列s中的DNA片段的长度。
    示例1
            输入
    AGGTCTA
            输出
2

    链接：https://www.nowcoder.com/questionTerminal/ab900f183e054c6d8769f2df977223b5
    来源：牛客网
import java.util.*;
    public class Main{
        public static void main(String args[]){
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            int i,j,n = input.length();
            for(i=1;i<=n;i++){
                HashSet<String> set= new HashSet<String>();
                for(j=0;j<n-i;j++) set.add(input.substring(j,j+i));
                if(set.size()<Math.pow(4,i)){
                    System.out.println(i);
                    break;
                }
            }

        }
    }
    数列的和
    链接：https://www.nowcoder.com/questionTerminal/fe19f8a78a5148018f4be53ae9b5e11e
    来源：牛客网
    数列的定义如下：数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。

    输入描述:
    输入数据有多组，每组占一行，由两个整数n（n<10000）和m(m<1000)组成，n和m的含义如前所述。

    输出描述:
    对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
    示例1
            输入
81 4
        2 2
    输出
94.73
        3.41

        import java.util.Scanner;

    /**
     * @author wylu
     */
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                double res = 0.0, n = scanner.nextInt();
                int m = scanner.nextInt();
                while ((m--) != 0) {
                    res += n;
                    n = Math.sqrt(n);
                }
                System.out.println(String.format("%.2f", res));
            }
        }
    }
    水仙花数
    春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，他是这样定义的：“水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。

    输入描述:
    输入数据有多组，每组占一行，包括两个整数m和n（100<=m<=n<=999）。

    输出描述:
    对于每个测试实例，要求输出所有在给定范围内的水仙花数，就是说，输出的水仙花数必须大于等于m,并且小于等于n，如果有多个，则要求从小到大排列在一行内输出，之间用一个空格隔开;如果给定的范围内不存在水仙花数，则输出no;每个测试实例的输出占一行。
    示例1
            输入
100 120
        300 380
    输出
            no
370 371

        import java.util.ArrayList;
import java.util.Scanner;

    /**
     * @author wylu
     */
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int m = scanner.nextInt(), n = scanner.nextInt();
                if (m > n) {
                    int tmp = m;
                    m = n;
                    n = tmp;
                }
                ArrayList<Integer> res = new ArrayList<>();
                for (int i = m; i <= n; i++) {
                    if (isFlower(i)) res.add(i);
                }

                if (res.size() == 0) {
                    System.out.println("no");
                } else {
                    for (int i = 0; i < res.size() - 1; i++) {
                        System.out.print(res.get(i) + " ");
                    }
                    System.out.println(res.get(res.size() - 1));
                }
            }
        }
        private static boolean isFlower(int num) {
            int x = num, res = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                res += Math.pow(pop, 3);
            }
            return res == num;
        }
    }
    判断题


    牛牛参加了一场考试,考试包括n道判断题,每做对一道题获得1分,牛牛考试前完全没有准备,所以考试只能看缘分了,牛牛在考试中一共猜测了t道题目的答案是"正确",其他的牛牛猜为"错误"。考试结束后牛牛知道实际上n道题中有a个题目的答案应该是"正确",但是牛牛不知道具体是哪些题目,牛牛希望你能帮助他计算可能获得的最高的考试分数是多少。
    输入描述:
    输入包括一行,一行中有三个正整数n, t, a(1 ≤ n, t, a ≤ 50), 以空格分割

    输出描述:
    输出一个整数,表示牛牛可能获得的最高分是多少。
    示例1
            输入
3 1 2
    输出
2

    思路：最大分数 = 正确题目判断对的 + 错误题目判断对的

import java.util.Scanner;
    public class Main{
        public static void main(String[] args){
            try(Scanner in = new Scanner(System.in)){
                int n = in.nextInt(),t = in.nextInt(),a = in.nextInt();
                System.out.println(helper(n,t,a));
            }
        }
        public static int helper(int n,int t,int a){
            if(t < a) return t + n - a;
            else return a + n - t;
        }
    }

    删除重复字符
    链接：https://www.nowcoder.com/questionTerminal/c4ea1f2263434861aef111aa44a5b064
    来源：牛客网

    牛牛有一个由小写字母组成的字符串s,在s中可能有一些字母重复出现。比如在"banana"中,字母'a'和字母'n'分别出现了三次和两次。
    但是牛牛不喜欢重复。对于同一个字母,他只想保留第一次出现并删除掉后面出现的字母。请帮助牛牛完成对s的操作。
    输入描述:
    输入包括一个字符串s,s的长度length(1 ≤ length ≤ 1000),s中的每个字符都是小写的英文字母('a' - 'z')

    输出描述:
    输出一个字符串,表示满足牛牛要求的字符串
            示例1
    输入
            banana
    输出
            ban

import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
    public class Main{
        public static void main(String[] args){
            try(Scanner in = new Scanner(System.in)){
                System.out.println(helper(in.nextLine()));
            }
        }
        public static String helper(String s){
            Set<Character> set = new LinkedHashSet<>();
            char[] cs = s.toCharArray();
            for(char c:cs){
                set.add(c);
            }
            StringBuffer sb = new StringBuffer();
            for(char c:set){
                sb.append(c);
            }
            return sb.toString();
        }
    }
    空中旅行
    链接：https://www.nowcoder.com/questionTerminal/cc929a2ed85f4f49b834e6e301fba77b
    来源：牛客网

    牛牛有羊羊有了属于他们自己的飞机。于是他们进行几次连续的飞行。f[i]表示第i次飞行所需的燃油的升数。飞行只能按照f数组所描述的顺序进行。
    起初飞机里有s升燃油,为了正常飞行,每次飞行前飞机内燃油量应大于等于此处飞行所需要的燃油量。请帮助他们计算在不进行加油的情况下他们能进行的飞行次数。
    输入描述:
    输入包括两行,第一行包括两个整数n和s(1 ≤ n ≤ 50, 1 ≤ s ≤ 1000),分别表示计划飞行的次数和飞起初始状态下有的燃油量。
    第二行包括n个整数f[i], (1 ≤ f[i] ≤ 1000), 表示每次计划飞行所需要的燃油量。

    输出描述:
    输出一个整数,表示他们能进行的飞行次数。
    示例1
            输入
7 10
        1 2 3 4 5 6 7
    输出
4

    思路：只需要每次飞行前检查一下燃油是否还够就好了

import java.util.*;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n, s; n = sc.nextInt(); s = sc.nextInt();
            for (int i=0; i<n; i++) {
                int in = sc.nextInt();
                if (s - in < 0) {
                    System.out.println(i);
                    return;
                }
                s -= in;
            }
            System.out.println(n);
        }
    }
    回文素数
    链接：https://www.nowcoder.com/questionTerminal/4802faa9afb54e458b93ed372e180f5c
    来源：牛客网

    如果一个整数只能被1和自己整除,就称这个数是素数。
    如果一个数正着反着都是一样,就称为这个数是回文数。例如:6, 66, 606, 6666
    如果一个数字既是素数也是回文数,就称这个数是回文素数
    牛牛现在给定一个区间[L, R],希望你能求出在这个区间内有多少个回文素数。
    输入描述:
    输入包括一行,一行中有两个整数(1 ≤ L ≤ R ≤ 1000)

    输出描述:
    输出一个整数,表示区间内回文素数个数。
    示例1
            输入
100 150
    输出
2

    链接：https://www.nowcoder.com/questionTerminal/4802faa9afb54e458b93ed372e180f5c
    来源：牛客网
import java.util.*;
    public class Main{
        public static void main(String[] args){
            try(Scanner in = new Scanner(System.in)){
                System.out.println(helper(in.nextInt(),in.nextInt()));
            }
        }
        public static int helper(int l,int r){
            int count = 0;
            if(l == 1) l++;//1不是素数
            while(l <= r){
                if(isHuiWen(l) && isSu(l)) count++;
                l++;
            }
            return count;
        }
        public static boolean isSu(int num){
            int i = 2;
            while(i * i <= num){
                int j = num / i;
                if(j * i  == num) return false;
                i++;
            }
            return true;
        }
        public static boolean isHuiWen(int num){
            char[] cs = Integer.toString(num).toCharArray();
            int i = 0,j = cs.length - 1;
            while(i <= j){
                if(cs[i] != cs[j]) return false;
                i++;
                j--;
            }
            return true;
        }
    }
    排序
    链接：https://www.nowcoder.com/questionTerminal/e496d8e885a949d18476b2dea1e594a9
    来源：牛客网

    牛牛有一个长度为n的整数序列,牛牛想对这个序列进行重排为一个非严格升序序列。牛牛比较懒惰,他想移动尽量少的数就完成重排,请你帮他计算一下他最少需要移动多少个序列中的元素。(当一个元素不在它原来所在的位置,这个元素就是被移动了的)
    输入描述:
    输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),即序列的长度
    第二行n个整数x[i](1 ≤ x[i] ≤ 100),即序列中的每个数

    输出描述:
    输出一个整数,即最少需要移动的元素个数
            示例1
    输入
3
        3 2 1
    输出
2

    链接：https://www.nowcoder.com/questionTerminal/e496d8e885a949d18476b2dea1e594a9
    来源：牛客网
import java.util.*;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            ArrayList arr = new ArrayList();
            for (int i=0; i!=n; i++) {
                arr.add(sc.nextInt());
            }
            ArrayList sortArr = new ArrayList(arr);
            Collections.sort(sortArr);
            int count = 0;
            for (int i=0; i!=n; i++) {
                if (!sortArr.get(i).equals(arr.get(i))) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    小明卖食物
    链接：https://www.nowcoder.com/questionTerminal/fba13a9bd7ad4bfaa02cefbc2512aaae
    来源：牛客网
    小明有n(1≤n≤2000）个美味的食物，他想卖掉它们来赚钱。这些食物放在一些箱子里，它们有些有趣的特性：
                    （1）这些食物被编号1~n，每一天小明可以从这排箱子的头部或者尾部取出食物去卖；
                    （2）这些食物放的越久，年龄越大，价值越大，食物i有一个初始的价值V(i);
（3）放了a天后，年龄为a，食物最终价值为V(i)xa。
    给定每一个食物的初始价值V(i)，请求出小明卖掉它们后可以获得的最大价值，第一天出售的食物年龄为1，此后每增加一天食物的年龄就加1。

    输入描述:
    第1行：一个整数n；

    第i+l行：每行食物i的初始价值V(i)。

    输出描述:
            1行：小明最终可以获得的最大价值。
    示例1
            输入
5
        1
        3
        1
        5
        2
    输出
43
    说明
    小明出售这些食物（初始价值1,3,1,5,2）的顺序为：第一天卖掉1个，第二天卖掉5个，第三天卖掉2个，第四天卖掉3个，第五天卖掉4个，获得最大的价值1x1+2x3+3x3+4x1+5x5=43。

            import java.util.Scanner;
import java.util.*;

    public class Main {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int count = sc.nextInt();
            List<Integer> number=new ArrayList<Integer>();
            for(int i = 0;i < count;i++){
                int  tmp = sc.nextInt();
                number.add(tmp);
            }
            int re = 0;
            int day = 1;
            while(!number.isEmpty()){
                if (number.get(0) < number.get(number.size() - 1)){
                    re += day * number.get(0);
                    number.remove(0);
                    day += 1;
                }else{
                    re += day * number.get(number.size() - 1);
                    number.remove(number.size() - 1);
                    day += 1;
                }

            }
            System.out.println(re);
        }

    }
    音乐列表
            题目描述
    小明喜欢在火车旅行的时候用手机听音乐，他有N首歌在手机里，在整个火车途中，他可以听P首歌，所以他想产生一个播放表产生P首歌曲，这个播放表的规则是：
            (1)每首歌都要至少被播放一次
            (2)在两首一样的歌中间，至少有M首其他的歌
    小明在想有多少种不同的播放表可以产生，那么给你N,M,P，你来算一下，输出结果取1000000007的余数
    输入描述:
    输入N,M,P
            N范围在1到100
    M范围在0到N
            P范围在N到100
    输出描述:
    输出结果mod 1000000007的余数
            示例1
    输入
            复制
1 0 3
    输出
            复制
1

        #include <bits/stdc++.h>
            #define ll long long
    using namespace std;
const int M = 1e9 + 7;
const int N = 110;
    int n, m, p;
    ll f[N][N];
    int main()
    {
        cin >> n >> m >> p;
        f[p][n] = 1;
        for (int i = p-1; i >= 0; i--)
            for (int j = n; j >= 0; j--) {
                if (j > m) f[i][j] += f[i+1][j] * (j - m) % M;
                f[i][j] += f[i+1][j+1] * (n - j) % M;
                f[i][j] %= M;
            }
        cout << f[0][0] << endl;
        return 0;
    }

    字符串价值
    链接：https://www.nowcoder.com/questionTerminal/9240357eefcf4d938b90bdd5eec3712b
    来源：牛客网

    有一种有趣的字符串价值计算方式:统计字符串中每种字符出现的次数,然后求所有字符次数的平方和作为字符串的价值
    例如: 字符串"abacaba",里面包括4个'a',2个'b',1个'c',于是这个字符串的价值为4 * 4 + 2 * 2 + 1 * 1 = 21
    牛牛有一个字符串s,并且允许你从s中移除最多k个字符,你的目标是让得到的字符串的价值最小。
    输入描述:
    输入包括两行,第一行一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),其中只包含小写字母('a'-'z')。
    第二行包含一个整数k(0 ≤ k ≤ length),即允许移除的字符个数。

    输出描述:
    输出一个整数,表示得到的最小价值
            示例1
    输入
            aba
1
    输出
2

//每次最大的值减一，得到的价值最小。
        import java.util.*;
    public class Main {
        public static int pingfang(int a[]){
            int sum=0;
            for(int i=0;i<a.length;i++)
                sum+=a[i]*a[i];
            return sum;
        }
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            String str=in.nextLine();
            int k=in.nextInt();
            HashMap<Character,Integer> map=new HashMap();
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if(!map.containsKey(c))
                    map.put(c, 1);
                else{
                    map.put(c, map.get(c)+1);
                }

            }
            List<Integer> list=new ArrayList(map.values());
            //    System.out.println(list.values().toString());
            int a[]=new int[list.size()];
            for(int i=0;i<list.size();i++){
                a[i]=list.get(i);
            }

            for(int i=0;i<k;i++){
                Arrays.sort(a);
                a[a.length-1]--;
            }
            System.out.println(pingfang(a));


        }

    }

    拼凑正方形
    链接：https://www.nowcoder.com/questionTerminal/563c6a69fd714e59a942d97047cedcb3
    来源：牛客网

    牛牛有4根木棍,长度分别为a,b,c,d。羊羊家提供改变木棍长度的服务,如果牛牛支付一个硬币就可以让一根木棍的长度加一或者减一。牛牛需要用这四根木棍拼凑一个正方形出来,牛牛最少需要支付多少硬币才能让这四根木棍拼凑出正方形。
    输入描述:
    输入包括一行,四个整数a,b,c,d(1 ≤ a,b,c,d ≤ 10^6), 以空格分割

    输出描述:
    输出一个整数,表示牛牛最少需要支付的硬币
            示例1
    输入
4 1 5 4
    输出
4

        import java.util.*;

    public class Main{
        public static void main(String[] args) {
            int[] a = new int[4];
            Scanner in = new Scanner(System.in);
            for(int i=0;i!=4;i++)
            {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            System.out.println((a[3]-a[0])+(a[2]-a[1]));
        }
    }

    区间表达
    链接：https://www.nowcoder.com/questionTerminal/826c2f28ee2a414cac87eb0304eca1a0
    来源：牛客网

    牛牛的老师给出了一个区间的定义:对于x ≤ y,[x, y]表示x到y之间(包括x和y)的所有连续整数集合。例如[3,3] = {3}, [4,7] = {4,5,6,7}.牛牛现在有一个长度为n的递增序列,牛牛想知道需要多少个区间并起来等于这个序列。
    例如:
    {1,2,3,4,5,6,7,8,9,10}最少只需要[1,10]这一个区间
    {1,3,5,6,7}最少只需要[1,1],[3,3],[5,7]这三个区间
    输入描述:
    输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),
    第二行n个整数a[i](1 ≤ a[i] ≤ 50),表示牛牛的序列,保证序列是递增的。

    输出描述:
    输出一个整数,表示最少区间个数。
    示例1
            输入
5
        1 3 5 6 7
    输出
3

    链接：https://www.nowcoder.com/questionTerminal/826c2f28ee2a414cac87eb0304eca1a0
    来源：牛客网
import java.util.*;
    public class Main{
        public static void main(String[] args){
            try(Scanner in = new Scanner(System.in)){
                int n = in.nextInt();
                int[] a = new int[n];
                for(int i = 0;i < n;i++){
                    a[i] = in.nextInt();
                }
                System.out.println(helper(a));
            }
        }
        public static int helper(int[] a){
            int sum = 1;
            for(int i = 1;i < a.length;i++){
                if(a[i] - a[i - 1] != 1) sum++;
            }
            return sum;
        }
    }

    数字游戏
    链接：https://www.nowcoder.com/questionTerminal/4f356b0618d14737a6f3782771bb4079
    来源：牛客网

    牛牛举办了一场数字游戏,有n个玩家参加这个游戏,游戏开始每个玩家选定一个数,然后将这个数写在纸上(十进制数,无前缀零),然后接下来对于每一个数字将其数位按照非递减顺序排列,得到新的数,新数的前缀零将被忽略。得到最大数字的玩家赢得这个游戏。
    输入描述:
    输入包括两行,第一行包括一个整数n(1 ≤ n ≤ 50),即玩家的人数
    第二行n个整数x[i](0 ≤ x[i] ≤ 100000),即每个玩家写下的整数。

    输出描述:
    输出一个整数,表示赢得游戏的那个玩家获得的最大数字是多少。
    示例1
            输入
3
        9638 8210 331
    输出
3689

    链接：https://www.nowcoder.com/questionTerminal/4f356b0618d14737a6f3782771bb4079
    来源：牛客网
import java.util.*;
    public class Main{
        public static void main(String[] args){
            try(Scanner in = new Scanner(System.in)){
                int n = in.nextInt(),i = 0;
                String[] str = new String[n];
                while(i < n){
                    str[i] = in.next();
                    i++;
                }
                System.out.println(helper(str));
            }
        }
        public static int helper(String[] str){
            int max = 0;
            for(String s:str){
                char[] a = s.toCharArray();
                Arrays.sort(a);
                max = Math.max(Integer.parseInt(new String(a)),max);
            }
            return max;
        }
    }

    红和绿
    链接：https://www.nowcoder.com/questionTerminal/56ab932abac44c8aabf0af75f598a0b4
    来源：牛客网

    牛牛有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。牛牛现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将会被覆盖。牛牛的目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。牛牛想知道他最少需要涂染几个正方形。
    如样例所示: s = RGRGR
    我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案。
    输入描述:
    输入包括一个字符串s,字符串s长度length(1 ≤ length ≤ 50),其中只包括'R'或者'G',分别表示红色和绿色。

    输出描述:
    输出一个整数,表示牛牛最少需要涂染的正方形数量
            示例1
    输入
            RGRGR
    输出
2

        import java.util.*;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            char[] s = sc.next().toCharArray();
            int len = s.length;// 获取字符串长度
            int gCount = 0;// 字符串中G字母的个数
            int count = 0; // 最小涂色次数
            for(int i = 0; i < len;i++)
            {
                if(s[i] == 'G')
                {
                    gCount++;
                }else
                {
                    count = Math.min(gCount, count + 1);
                }
            }
            System.out.println(count);
        }
    }

    拼凑三角形
    链接：https://www.nowcoder.com/questionTerminal/d9f5dbd3b57d450e8406e102573d4bdd
    来源：牛客网

    牛牛手中有三根木棍,长度分别是a,b,c。牛牛可以把任一一根木棍长度削短,牛牛的目标是让这三根木棍构成一个三角形,并且牛牛还希望这个三角形的周长越大越好。
    输入描述:
    输入包括一行,一行中有正整数a, b, c(1 ≤ a, b, c ≤ 100), 以空格分割

    输出描述:
    输出一个整数,表示能拼凑出的周长最大的三角形。
    示例1
            输入
1 2 3
    输出
5

    链接：https://www.nowcoder.com/questionTerminal/d9f5dbd3b57d450e8406e102573d4bdd
    来源：牛客网
import java.util.*;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[] lens = new int[3];
            for (int i=0; i!=3; i++) {
                lens[i] = sc.nextInt();
            }
            Arrays.sort(lens);
            if (lens[0] + lens[1] > lens[2]) {
                System.out.println(lens[0] + lens[1] + lens[2]);
            }
            else {
                System.out.println(2 * (lens[0] + lens[1]) - 1);
            }
        }
    }

    牛客网冒泡排序（部分翻转再进行冒泡排序的最少交换次数）
            import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    /**
     * @author wylu
     */
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] strs = br.readLine().split(" ");
            int n = Integer.parseInt(strs[0]), k = Integer.parseInt(strs[1]);
            strs = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(strs[i]);
            }

            //dp[i][j]: 表示进行不多于j次操作后与a[i],...,a[len - 1]形成逆序对数的最小值
            int[][] dp = new int[n + 1][k + 1];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j <= k; j++) {
                    dp[i][j] = countReverseOrder(a, i, i) + dp[i + 1][k];
                    if (j > 0) {
                        for (int p = i + 1; p < n; p++) {
                            int[] tmp = new int[p + 1];
                            System.arraycopy(a, 0, tmp, 0, p + 1);
                            reverse(tmp, i, p);
                            dp[i][j] = Math.min(dp[i][j], countReverseOrder(tmp, i, tmp.length - 1) + dp[p + 1][j - 1]);
                        }
                    }
                }
            }
            System.out.println(dp[0][k]);
        }

        //求元素arr[begin], ... ,arr[end]的逆序数
        private static int countReverseOrder(int[] arr, int begin, int end) {
            int count = 0;
            for (int i = begin; i <= end; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[i]) count++;
                }
            }
            return count;
        }

        private static void reverse(int[] arr, int i, int j) {
            for (; i < j; i++, j--) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }

    快速排序最优版本
    Public void quicksort(int[] data){
        quicksortOptimized(data, 0, data.length);
    }

    Private void quicksortOptimized(int[] data, int left, int right){
        Int pivot = data[(left+right)/2];
        Int i=left;
        Int j=right;
        While(i<=j){
            While(data[i] < pivot) i++;
            While(data[j] > pivot) j--;
            If(i<=j){
                Int temp = data[i];
                Data[i] = data[j];
                Data[j] = temp;
                I++;j--;
            }
        }
        If(left < j){
            quicksortOptimized(data, left, j);
        }
        If(i < right){
            quicksortOptimized(data, i, right);
        }
    }


    循环数比较
    链接：https://www.nowcoder.com/questionTerminal/955d15cbeaed4bcd9f197ca4b9020907
    来源：牛客网

    对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
    牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
    输入描述:
    输入包括一行,一行中有4个正整数x1, k1, x2, k2(1 ≤ x1,x2 ≤ 10^9, 1 ≤ k1,k2 ≤ 50),以空格分割

    输出描述:
    如果v1小于v2输出"Less",v1等于v2输出"Equal",v1大于v2输出"Greater".
    示例1
            输入
1010 3 101010 2
    输出
            Equal


import java.util.*;
import java.math.*;
    public class Main {
        public static void main(String []args){
            Scanner in=new Scanner(System.in);
            String s1=in.next(),s2,a="",b="";
            int k1=in.nextInt(),k2,i;
            s2=in.next();k2=in.nextInt();
            for(i=0;i<k1;i++) a+=s1;
            for(i=0;i<k2;i++) b+=s2;
            BigInteger x=new BigInteger(a),y=new BigInteger(b);
            System.out.printf("%s",x.compareTo(y)>0?"Greater":x.compareTo(y)<0?"Less":"Equal");
        }
    }

    链接：https://www.nowcoder.com/questionTerminal/955d15cbeaed4bcd9f197ca4b9020907
    来源：牛客网
import java.util.*;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String in1 = sc.next(); int k1 = sc.nextInt(); String in2 = sc.next(); int k2 = sc.nextInt();
            StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
            for (int i=0; i!=k1; i++) {
                sb1.append(in1);
            }
            for (int i=0; i!=k2; i++) {
                sb2.append(in2);
            }
            String o1 = sb1.toString(), o2 = sb2.toString();
            if (o1.length() > o2.length()) {
                System.out.println("Greater");
            }
            else if (o1.length() < o2.length()) {
                System.out.println("Less");
            }
            else {
                if (o1.compareTo(o2) > 0) {
                    System.out.println("Greater");
                }
                else if (o1.compareTo(o2) < 0){
                    System.out.println("Less");
                }
                else {
                    System.out.println("Equal");
                }
            }
            return;
        }
    }

    青草游戏
    链接：https://www.nowcoder.com/questionTerminal/ed0334a5e88f4662bb69374b308862d8
    来源：牛客网

    牛牛和羊羊都很喜欢青草。今天他们决定玩青草游戏。
    最初有一个装有n份青草的箱子,牛牛和羊羊依次进行,牛牛先开始。在每个回合中,每个玩家必须吃一些箱子中的青草,所吃的青草份数必须是4的x次幂,比如1,4,16,64等等。不能在箱子中吃到有效份数青草的玩家落败。假定牛牛和羊羊都是按照最佳方法进行游戏,请输出胜利者的名字。
    输入描述:
    输入包括t+1行。
    第一行包括一个整数t(1 ≤ t ≤ 100),表示情况数.
    接下来t行每行一个n(1 ≤ n ≤ 10^9),表示青草份数

    输出描述:
    对于每一个n,如果牛牛胜利输出"niu",如果羊羊胜利输出"yang"。
    示例1
            输入
3
        1
        2
        3
    输出
            niu
    yang
            niu

    链接：https://www.nowcoder.com/questionTerminal/ed0334a5e88f4662bb69374b308862d8
    来源：牛客网
import java.util.*;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T-- != 0) {
                int in = sc.nextInt();
                System.out.println( (in % 5 == 0|| in % 5 == 2) ? "yang" : "niu");
            }
            return;
        }
    }

    无聊的牛牛和羊羊
    链接：https://www.nowcoder.com/questionTerminal/327ff11066b640b6957883e1ba5ec40c
    来源：牛客网

    牛牛和羊羊非常无聊.他们有n + m个共同朋友,他们中有n个是无聊的,m个是不无聊的。每个小时牛牛和羊羊随机选择两个不同的朋友A和B.(如果存在多种可能的pair(A, B),任意一个被选到的概率相同。),然后牛牛会和朋友A进行交谈,羊羊会和朋友B进行交谈。在交谈之后,如果被选择的朋友之前不是无聊会变得无聊。现在你需要计算让所有朋友变得无聊所需要的时间的期望值。
    输入描述:
    输入包括两个整数n 和 m(1 ≤ n, m ≤ 50)


    输出描述:
    输出一个实数,表示需要时间的期望值,四舍五入保留一位小数。
    示例1
            输入
2 1
    输出
1.5

    链接：https://www.nowcoder.com/questionTerminal/327ff11066b640b6957883e1ba5ec40c
    来源：牛客网
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    /**
     * @author wylu
     */
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] strs = br.readLine().split(" ");
            int n = Integer.parseInt(strs[0]), m = Integer.parseInt(strs[1]);

            int total = n + m;
            double[] f = new double[m + 1];
            f[0] = 0;
            f[1] = total / 2.0;

            double s = total * (total - 1) / 2.0;
            for (int i = 2; i <= m; i++) {
                double tmp = total - i;
                double p1 = tmp * (tmp - 1) / 2.0 / s;
                double p2 = tmp * i / s;
                double p3 = i * (i - 1) / 2.0 / s;
                f[i] = (1 + p2 * f[i - 1] + p3 * f[i - 2]) / (1 - p1);
            }
            System.out.println(String.format("%.1f", f[m]));
        }
    }

    幸运子序列
    链接：https://www.nowcoder.com/questionTerminal/872919272a33406a9c5ddc8b2f7532f4
    来源：牛客网

    牛牛得到一个长度为n的整数序列V,牛牛定义一段连续子序列的幸运值为这段子序列中最大值和次大值的异或值(次大值是严格的次大)。牛牛现在需要求出序列V的所有连续子序列中幸运值最大是多少。请你帮帮牛牛吧。
    输入描述:
    第一行一个整数n,即序列的长度。(2<= n <= 100000)
    第二行n个数，依次表示这个序列每个数值V[i], (1 ≤ V[i] ≤ 10^8)且保证V[1]到V[n]中至少存在不同的两个值.

            输出描述:
    输出一个整数,即最大的幸运值
            示例1
    输入
5
        5 2 1 4 3
    输出
7

    思路：单调栈、找到某个数左边第一个大于它的，右边第一个大于它的。一旦破坏了从栈底到栈顶单调递减的结构的时候，就不断弹栈并计算。
            import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

    /**
     * @author wylu
     */
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String[] strs = br.readLine().split(" ");
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = Integer.parseInt(strs[i]);
            }

            int res = 0;
            LinkedList<Integer> stack = new LinkedList<>();
            //遍历所有元素作为子串最大值和次大值的情况
            for (int i = 0; i < n; i++) {
                //当前元素作为连续子序列(也即子串)的最大值的情况
                while (!stack.isEmpty() && stack.peek() <= v[i]) {
                    res = Math.max(res, v[i] ^ stack.pop());
                }
                //当前元素作为连续子序列的次大值的情况
                if (!stack.isEmpty()) {
                    res = Math.max(res, v[i] ^ stack.peek());
                }
                stack.push(v[i]);
            }
            System.out.println(res);
        }
    }
    缺失的括号
    链接：https://www.nowcoder.com/questionTerminal/de7d4a4b50f643669f331941afb1e728
    来源：牛客网

    一个完整的括号字符串定义规则如下:
            1、空字符串是完整的。
            2、如果s是完整的字符串，那么(s)也是完整的。
            3、如果s和t是完整的字符串，将它们连接起来形成的st也是完整的。
    例如，"(()())", ""和"(())()"是完整的括号字符串，"())(", "()(" 和 ")"是不完整的括号字符串。
    牛牛有一个括号字符串s,现在需要在其中任意位置尽量少地添加括号,将其转化为一个完整的括号字符串。请问牛牛至少需要添加多少个括号。
    输入描述:
    输入包括一行,一个括号序列s,序列长度length(1 ≤ length ≤ 50).
    s中每个字符都是左括号或者右括号,即'('或者')'.

    输出描述:
    输出一个整数,表示最少需要添加的括号数
            示例1
    输入
            (()(()
    输出
2

    链接：https://www.nowcoder.com/questionTerminal/de7d4a4b50f643669f331941afb1e728
    来源：牛客网
/*
    思路：类似栈的思想  左右括号相遇时可消除
         countL 记录最终正确括号消除后所剩的'('的数目
         countL 记录最终正确括号消除后所剩的')'的数目
*/
import java.util.*;
    public class Main{
        public static void main(String[] args){
            try(Scanner in = new Scanner(System.in)){
                System.out.println(helper(in.nextLine()));
            }
        }
        public static int helper(String s){
            char[] cs = s.toCharArray();
            int countL = 0,countR = 0,i = 0;
            while(i < cs.length){
                if(cs[i] == '('){
                    countL++;
                }else {
                    // 遇到右括号时，若前面有左括号未匹配，则匹配消除   如果没有，则右括号数目加1
                    if(countL != 0){
                        countL--;
                    }else{
                        countR++;
                    }
                }
                i++;
            }
            return countL + countR;
        }
    }

    最后一位
    链接：https://www.nowcoder.com/questionTerminal/fae8632cfc64433989720bc01e09f382
    来源：牛客网

    牛牛选择了一个正整数X,然后把它写在黑板上。然后每一天他会擦掉当前数字的最后一位,直到他擦掉所有数位。 在整个过程中,牛牛会把所有在黑板上出现过的数字记录下来,然后求出他们的总和sum.
            例如X = 509, 在黑板上出现过的数字依次是509, 50, 5, 他们的和就是564.
            牛牛现在给出一个sum,牛牛想让你求出一个正整数X经过上述过程的结果是sum.
            输入描述:
    输入包括正整数sum(1 ≤ sum ≤ 10^18)

    输出描述:
    输出一个正整数,即满足条件的X,如果没有这样的X,输出-1。
    示例1
            输入
564
    输出
509

    链接：https://www.nowcoder.com/questionTerminal/fae8632cfc64433989720bc01e09f382
    来源：牛客网
import java.util.*;
    public class Main {
        public static long MAX = (long)1e18;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            long in = sc.nextLong();
            System.out.println(niuBinarySearch(in, 0, MAX));
        }

        private static long getNiuSum(long num) {
            long ans = 0;
            while (num != 0) {
                ans += num;
                num /= 10;
            }
            return ans;
        }

        private static long niuBinarySearch(long target, long fromIndex, long toIndex) {
            while (fromIndex < toIndex) {
                long mid = (fromIndex + toIndex) >> 1;
                long midNiuSum = getNiuSum(mid);
                if (midNiuSum == target) {
                    return mid;
                } else if (target > midNiuSum) {
                    fromIndex = mid+1;
                } else if (target < midNiuSum) {
                    toIndex = mid ;
                }
            }
            return -1;
        }
    }
    括号匹配深度
    链接：https://www.nowcoder.com/questionTerminal/a2d5b1875bb0408384278f40d1f236c9
    来源：牛客网

    一个合法的括号匹配序列有以下定义:
            1、空串""是一个合法的括号匹配序列
2、如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
3、如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
4、每个合法的括号序列都可以由以上规则生成。
    例如: "","()","()()","((()))"都是合法的括号序列
    对于一个合法的括号序列我们又有以下定义它的深度:
            1、空串""的深度是0
2、如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为max(x,y) 3、如果"X"的深度是x,那么字符串"(X)"的深度是x+1
    例如: "()()()"的深度是1,"((()))"的深度是3。牛牛现在给你一个合法的括号序列,需要你计算出其深度。
    输入描述:
    输入包括一个合法的括号序列s,s长度length(2 ≤ length ≤ 50),序列中只包含'('和')'。


    输出描述:
    输出一个正整数,即这个序列的深度。
    示例1
    输入
            (())
    输出
2

    链接：https://www.nowcoder.com/questionTerminal/a2d5b1875bb0408384278f40d1f236c9
    来源：牛客网

import java.util.Scanner;

    public class Main {
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            int stack=0,max=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='('){
                    stack++;
                    max = max>stack?max:stack;
                }
                if(str.charAt(i)==')')        stack--;
            }
            System.out.println(max);
            in.close();
        }
    }
    数组跳跃
    给定一个非空的整数数组，从数组第一个元素(下标为0的元素)开始遍历进行移动，下一次向后或向前移动 该元素的值 的位数（值为正数向后移动，值为负数向前移动，值为零不移动），依次类推进行移动，若某次移动数组出现越界，则说明数组可以跳出，返回true；不能跳出则返回false；（加分项：也可考虑不增加使用其他集合数组辅助完成算法）
    例1：
    输入数组a[5] = [1,2,3,2,5];从第一个元素开始a[0]=1,下次向后移动1位到第二个元素a[1]=2,再次向后移动2位到第四个元素a[3],因为下次向后移动2位(a[3]=2)后,向后数组越界,即跳出数组,输出true;
    例2：
    输入数组a[2] = [1,-3];从第一个元素开始a[0]=1,下次移动1位到第二个元素a[1]=-3,再次向前移动3位后,向前数组越界,即跳出数组,输出true;

import java.util.Scanner;

    public class Main{

        public static void main(String args[]){

            Scanner sc=new Scanner(System.in);

            while(sc.hasNext()){

                String s=sc.next();

                String str=s.substring(1,s.length()-1);

                String ss[]=str.split(",");

                int a[]=newint[ss.length];

                for(int i=0;i<ss.length;i++)

                    a[i]=Integer.parseInt(ss[i]);

                boolean o=false;

                int count=0;

                int k=0;

                while(count<=a.length){

                    count++;

                    k+=a[k];

                    if(k<0||k>=a.length){

                        o=true;

                        break;

                    }

                }

                System.out.println(o);

            }

        }

    }

    寻找众数
    给定一个数组A[n], 定义数组的众数 ( Majority Element) 为数组中出现次数超过 n/2 次的元素, 假设数组A[n]非空且一定存在众数, 请设计算法找到该众数并输出.
            时间复杂度为O(n),我们可以考虑在遍历数组的时候保存两个值，一个是数组中的一个数字，另一个是次数，
    当我们遍历到下一个数字的时候如果下一个数字和我们之前保存的数字相同则次数加1，如果次数为零那么我们需要保
    存下一个数字，并把次数设为1.
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            String str=sc.next();
            String arr[]=str.split("[\\[\\],]");
            int time=0;
            String result = null;
            for(int i=1;i<arr.length;i++){//从1开始遍历，因为arr[0]为换行
                if(time==0){
                    result=arr[i];
                }
                if(arr[i].equals(result)){
                    time++;
                }else{
                    time--;
                }
            }
            System.out.println(result);
        }
    }


    importjava.util.*;
    publicclassMain{
        publicintnum(int[] arr){
            Map<Integer,Integer> map = newHashMap<>();
            for(inti = 0; i < arr.length; i++){
                if(map.containsKey(arr[i])){
                    map.put(arr[i], map.get(arr[i]) + 1);
                }else{
                    map.put(arr[i], 1);
                }
            }
            intmax = 0;
            for(Integer num : map.keySet()){
                if(num > max){
                    max = num;

                }
            }
            returnmax;
        }

    }
    第K大的元素
    给定一个无序的整型数组A[n],数组大小大于等于3,允许有值相同的元素;请设计算法找到该数组排序后第三大的元素值并输出.

import java.util.*;

    public class Main {
        public static boolean flag=false;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s=sc.nextLine();
            String s1 = s.replace("[", "");//把字符“[”去掉
            String s2 = s1.replace("]", "");//把字符“]”去掉
            String[] split = s2.split(",");//把字符“,”去掉
            int len=split.length;
            int [] arr=new int[len];
            for (int i=0;i<len;i++){
                arr[i]= Integer.parseInt(split[i]);//得到数组
            }
            sort(arr);
        }
        public static void sort(int[] arr){
            Stack<Integer> stack=new Stack<>();
            Arrays.sort(arr);//给数组排序
            for (int i=0;i<arr.length;i++){
                stack.push(arr[i]);//把数组中的数依次压入栈
            }
            int temp=0;
            for (int j=0;j<3;j++){
                temp=stack.pop();//连续取3次
            }
            System.out.println(temp);//得到第三大的数
        }
    }

    奶牛编号


    牛牛养了n只奶牛,牛牛想给每只奶牛编号,这样就可以轻而易举地分辨它们了。 每个奶牛对于数字都有自己的喜好,第i只奶牛想要一个1和x[i]之间的整数(其中包含1和x[i])。
    牛牛需要满足所有奶牛的喜好,请帮助牛牛计算牛牛有多少种给奶牛编号的方法,输出符合要求的编号方法总数。

    链接：https://www.nowcoder.com/questionTerminal/c167db5218e54ef2870aebe5b14743f2
    来源：牛客网
    输入描述:
    输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示奶牛的数量 第二行为n个整数x[i](1 ≤ x[i] ≤ 1000)

    输出描述:
    输出一个整数,表示牛牛在满足所有奶牛的喜好上编号的方法数。因为答案可能很大,输出方法数对1,000,000,007的模。
    示例1
            输入
4
        4 4 4 4
    输出
24

    链接：https://www.nowcoder.com/questionTerminal/c167db5218e54ef2870aebe5b14743f2
    来源：牛客网
    把奶牛所希望的编号排个序，然后就是乘法原理了。
    比如 4 3 9 6， 排序为3 4 6 9。第一个奶牛有3种取法，第二只奶牛有(4-1)种取法，第三头奶油有(6-2)种取法，第四匹奶牛就有9-3种取法。

            import java.util.*;

    public class Main {
        private static final long MOD = 1000000007;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i=0; i!=n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            long ans = 1;
            for (int i=0; i!=n; i++) {
                ans *= ((nums[i] - i) % MOD);
                ans %= MOD;
            }
            System.out.println(ans);
        }
    }

    平方串
    链接：https://www.nowcoder.com/questionTerminal/b43fb39898f448e39adbcffde5ff0dfc
    来源：牛客网

    如果一个字符串S是由两个字符串T连接而成,即S = T + T, 我们就称S叫做平方串,例如"","aabaab","xxxx"都是平方串.
            牛牛现在有一个字符串s,请你帮助牛牛从s中移除尽量少的字符,让剩下的字符串是一个平方串。换句话说,就是找出s的最长子序列并且这个子序列构成一个平方串。
    输入描述:
    输入一个字符串s,字符串长度length(1 ≤ length ≤ 50),字符串只包括小写字符。

    输出描述:
    输出一个正整数,即满足要求的平方串的长度。
    示例1
            输入
    frankfurt
            输出
4

    链接：https://www.nowcoder.com/questionTerminal/b43fb39898f448e39adbcffde5ff0dfc
    来源：牛客网
import java.util.*;
    public class Main {
        public static void main(String[]args){
            Scanner in=new Scanner(System.in);
            String s=in.next();
            if(s.length()==1) System.out.println(0);
            else{
                int res=0,i,n=s.length();
                for(i=0;i+1<n;i++)
                    res=Math.max(res,maxLen(s.substring(0,i+1),s.substring(i+1)));
                System.out.println(res);
            }
        }
        public static int maxLen(String a,String b){
            int len1=a.length(),len2=b.length(),i,j;
            int [][]dp=new int[len1+1][len2+1];
            for(i=1;i<=len1;i++)
                for(j=1;j<=len2;j++)
                    dp[i][j]=(a.charAt(i-1)==b.charAt(j-1)
                            ?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]));
            return dp[len1][len2]*2;
        }
    }

    链接：https://www.nowcoder.com/questionTerminal/b43fb39898f448e39adbcffde5ff0dfc
    来源：牛客网
import java.util.*;
    public class Main{
        public static void main(String[] args){
            try(Scanner in = new Scanner(System.in)){
                String s = in.nextLine();
                int max = 0;
                for(int i = 1;i < s.length();i++){
                    max = Math.max(max,helper(s.substring(0,i),s.substring(i)));
                }
                System.out.println(2 * max);
            }
        }
        public static int helper(String s1,String s2){
            int[][] dp = new int[s1.length() + 1][s2.length() + 1];
            for(int i = 0;i < s1.length();i++){
                for(int j = 0;j < s2.length();j++){
                    dp[i + 1][j + 1] = s1.charAt(i) == s2.charAt(j) ? dp[i][j] + 1 : Math.max(dp[i][j + 1],dp[i + 1][j]);
                }
            }
            return dp[s1.length()][s2.length()];
        }
    }

    房间移动（今日头条2018校招后端）
    附加题
    思路：
            (1) 每个房间的移动次数记为d[j]，甲要移动到j，需要从j-1移动，即 d[j]  = d[j-1] + 1,
            (2) 此时d[j]第一次访问，甲跳转pi[j]，移动1次，此时pi[j]为奇数次访问，状态相当于d[pi[j]-1]  +1,，甲需要从pi[j]开始移动，最后移动到 j-1, 且d[j-1]也应该再次变为偶数次访问， 移动次数为d[j-1] - d[pi[j]-1]  - 1, 移动到 j-1后，再加1，d[j-1] - d[pi[j]-1] + 1,为甲重新移动到j房间，(2)***移动了d[j-1] - d[pi[j]-1] +1次
            (3) (1) + (2) = 2*d[j-1] - d[pi[j]-1] +2
            import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            long mod = 1000000007;
            int n = in.nextInt();
            long d[] = new long [n+1];
            int pi[] = new int[n+1];
            for(int i = 1; i < n+1;i++){
                pi[i] = in.nextInt();
            }
            if(n==1){
                System.out.println(1);
                return;
            }
            for(int j = 1; j < n+1; j++){
                d[j] = (2 * d[j-1]%mod - d[pi[j]-1] + 2) % mod;
            }
            System.out.println(d[n]);
        }
    }

    球队比赛（编程题2）
    链接：https://www.nowcoder.com/questionTerminal/ff518f3162c849b9a84d1fab8e7179be
    来源：牛客网

    有三只球队，每只球队编号分别为球队1，球队2，球队3，这三只球队一共需要进行 n 场比赛。现在已经踢完了k场比赛，每场比赛不能打平，踢赢一场比赛得一分，输了不得分不减分。已知球队1和球队2的比分相差d1分，球队2和球队3的比分相差d2分，每场比赛可以任意选择两只队伍进行。求如果打完最后的 (n-k) 场比赛，有没有可能三只球队的分数打平。  
    输入描述:
    第一行包含一个数字 t (1 <= t <= 10)
    接下来的t行每行包括四个数字 n, k, d1, d2(1 <= n <= 10^12; 0 <= k <= n, 0 <= d1, d2 <= k)


    输出描述:
    每行的比分数据，最终三只球队若能够打平，则输出“yes”，否则输出“no”
    示例1
            输入
2
        3 3 0 0
        3 3 3 3
    输出
            yes
    no
            说明
    case1: 球队1和球队2 差0分，球队2 和球队3也差0分，所以可能的赛得分是三只球队各得1分
    case2: 球队1和球队2差3分，球队2和球队3差3分，所以可能的得分是 球队1得0分，球队2得3分, 球队3 得0分，比赛已经全部结束因此最终不能打平。


            import java.util.Scanner;

    public class Main {

        public static long n;
        public static long k;
        public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            int p=in.nextInt();
            for(int i=0;i<p;i++) {
                n=in.nextLong();
                k=in.nextLong();
                long d1=in.nextLong();
                long d2=in.nextLong();
                if(jiancha(n,k,d1,d2)) {
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }


            }
        }

        public static boolean jiancha(long n,long k,long d1,long d2) {
            long r=k-d1-d2;
            if(r>=0&&r%3==0) {
                if(queren(r/3+d1,r/3,r/3+d2)) {
                    return true;
                }
            }
            long t=k-d1+d2;
            if(t%3==0&&t/3-d2>=0) {
                if(queren(t/3+d1,t/3,t/3-d2)) {
                    return true;
                }
            }
            long w=k-d2+d1;
            if(w%3==0&&w/3-d1>0) {
                if(queren(w/3-d1,w/3,w/3+d2)) {
                    return true;
                }
            }
            long v=k+d1+d2;
            if(v%3==0&&v/3-d1>=0&&v/3-d2>=0) {
                if(queren(v/3-d1,v/3,v/3-d2)) {
                    return true;
                }
            }
            return false;


        }
        public static boolean queren(long a,long b,long c) {
            long we=Math.max(Math.max(a, b),c);

            if ((n-k-(3*we-a-b-c))>=0&&(n-k-(3*we-a-b-c))%3==0) {
                return true;
            }else {
                return false;
            }
        }


    }


    字符串变换（编程题1）
    链接：https://www.nowcoder.com/questionTerminal/dcc301bc11a7420b88afdbd272299809
    来源：牛客网

    有一个仅包含’a’和’b’两种字符的字符串s，长度为n，每次操作可以把一个字符做一次转换（把一个’a’设置为’b’，或者把一个’b’置成’a’)；但是操作的次数有上限m，问在有限的操作数范围内，能够得到最大连续的相同字符的子串的长度是多少。
    输入描述:
    第一行两个整数 n , m (1<=m<=n<=50000)，第二行为长度为n且只包含’a’和’b’的字符串s。

    输出描述:
    输出在操作次数不超过 m 的情况下，能够得到的 最大连续 全’a’子串或全’b’子串的长度。
    示例1
            输入
8 1
    aabaabaa
            输出
5
    说明
    把第一个 'b' 或者第二个 'b' 置成 'a'，可得到长度为 5 的全 'a' 子串。

    链接：https://www.nowcoder.com/questionTerminal/dcc301bc11a7420b88afdbd272299809
    来源：牛客网
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    /**
     * 利用前缀和数组
     * 例如：
     * n=10,m=1,s=baabaabaab
     *   b a a b a a b a a b
     *   0 1 2 3 4 5 6 7 8 9
     *
     *   将 b-->a
     *   b 的前缀和数组为
     *          sums={ 0, 3, 6, 9, 10}//10 为字符串长度
     *   计算长度分别为:
     *          3  6-0-1=5   9-3-1=5  10-6-1=3
     *     ==>>max = max{ max, sums[i]-sum[i-m-1]-1}
     */

    public class Main{
        public static int change(int n, int m, String s, char k) {
            int max = 0;
            List<Integer> sums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == k) {
                    sums.add(i);
                }
            }
            if (sums.size() <= m) {
                return n;
            }
            sums.add(s.length());
            max = sums.get(m);
            for (int i = m + 1; i < sums.size(); i++) {
                max = Integer.max(max, sums.get(i) - sums.get(i - m - 1) - 1);
            }
            return max;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String s = scanner.next();
            System.out.println(Integer.max(change(n, m, s, 'a'), change(n, m, s, 'b')));
        }
    }
    Unix路径简化
    链接：https://www.nowcoder.com/questionTerminal/590296f71dba4ba4ae3fc8e375faf689
    来源：牛客网

    简化 Unix 风格的路径，需要考虑的包括 "/../", "//", "/./" 等情况
    输入描述:
    Unix 风格的路径

    输出描述:
    简化后的Unix 风格路径
    示例1
            输入
/a/./b/../../c/
    输出
/c

import java.util.Scanner;
import java.util.Stack;

    public class Main {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String s = sc.next();
                String[] strs = s.split("/");
                Stack<String> stack = new Stack<String>();
                for (int i = 0; i < strs.length; i++) {
                    String cur = strs[i];
                    if (cur.equals(".") || cur.equals("")) {
                        continue;
                    } else if (cur.equals("")) {
                        if(!stack.isEmpty()) {
                            stack.pop();
                        }
                    } else {
                        stack.push(cur);
                    }
                }
                String res = "";
                while (!stack.isEmpty()) {
                    String cur = stack.pop();
                    res = "/" + cur + res;
                }
                if(res.equals("")) {
                    res = "/";
                }
                System.out.println(res);
            }
            sc.close();

        }

    }
    回文数组
    对于一个给定的正整数组成的数组 a[] ，如果将 a 倒序后数字的排列与 a 完全相同，我们称这个数组为“回文”的。
    例如， [1, 2, 3, 2, 1] 的倒序是他自己，所以是一个回文的数组；而 [1, 2, 3, 1, 2] 的倒序是 [2, 1, 3, 2, 1] ，所以不是一个回文的数组。
    对于任意一个正整数数组，如果我们向其中某些特定的位置插入一些正整数，那么我们总是能构造出一个回文的数组。

    输入一个正整数组成的数组，要求你插入一些数字，使其变为回文的数组，且数组中所有数字的和尽可能小。输出这个插入后数组中元素的和。

    例如，对于数组 [1, 2, 3, 1, 2] 我们可以插入两个 1 将其变为回文的数组 [1, 2, 1, 3, 1, 2, 1] ，这种变换方式数组的总和最小，为 11 ，所以输出为 11 。

    思路：问题可以转换为求回文子序列的最大和，则最终最优解为2 * sum - dp[0][a.length - 1]，sum为数组a所有元素的和。

            import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    /**
     * Dynamic Programming
     *
     * State:
     *   dp[i][j]: 表示a[i],...,a[j]中的回文子序列的最大和
     *
     * Initial State:
     *   dp[i][i] = a[i]
     *
     * State Transition:
     *   if (a[i] == a[j]) dp[i][j] = dp[i + 1][j - 1] + 2 * a[i];
     *   else dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
     *
     * @author wylu
     */
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String[] strs = br.readLine().split(" ");
            int[] a = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(strs[i]);
                sum += a[i];
            }

            long[][] dp = new long[n][n];
            for (int i = a.length - 1; i >= 0; i--) {
                dp[i][i] = a[i];
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] == a[j]) dp[i][j] = dp[i + 1][j - 1] + 2 * a[i];
                    else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
            System.out.println(2 * sum - dp[0][n - 1]);
        }
    }
    推箱子游戏
    有一个推箱子的游戏, 一开始的情况如下图:

    上图中, '.' 表示可到达的位置, '#' 表示不可到达的位置，其中 S 表示你起始的位置, 0表示初始箱子的位置, E表示预期箱子的位置，你可以走到箱子的上下左右任意一侧, 将箱子向另一侧推动。如下图将箱子向右推动一格;
..S0.. -> ...S0.
            注意不能将箱子推动到'#'上, 也不能将箱子推出边界;
    现在, 给你游戏的初始样子, 你需要输出最少几步能够完成游戏, 如果不能完成, 则输出-1。

    输入描述:
    第一行为2个数字,n, m, 表示游戏盘面大小有n 行m 列(5< n, m < 50);
    后面为n行字符串,每行字符串有m字符, 表示游戏盘面;

    输出描述:
    一个数字,表示最少几步能完成游戏,如果不能,输出-1;
    示例1
            输入
3 6
        .S#..E
            .#.0..
            ......
    输出
11

    链接：https://www.nowcoder.com/questionTerminal/d66a7a8b8e8a4acca7b1e1c8ef476354
    来源：牛客网
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            new Main().solute();
        }

        public void solute() {
            Scanner sc = new Scanner(System.in);
            // m n
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();
            // maze
            String[] input = new String[m];
            for (int i = 0; i < m; i++) {
                input[i] = sc.nextLine();
            }
            char[][] maze = new char[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    maze[i][j] = input[i].charAt(j);
                }
            }

            bfs(m, n, maze);
        }

        public void bfs(int m, int n, char[][] maze) {
            int[][][][] arr = new int[m][n][m][n];
            Queue<int[]> queue = new LinkedList<>();
            // find S, box, E
            int sX = 0, sY = 0, bX = 0, bY = 0, eX = 0, eY = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (maze[i][j] == 'S') {
                        sX = i;
                        sY = j;
                    }
                    if (maze[i][j] == '0') {
                        bX = i;
                        bY = j;
                    }
                    if (maze[i][j] == 'E') {
                        eX = i;
                        eY = j;
                    }
                }
            }
            queue.offer(new int[]{sX, sY, bX, bY});
            while (queue.peek() != null) {
                int[] poll = queue.poll();
                int sNowX = poll[0];
                int sNowY = poll[1];
                int bNowX = poll[2];
                int bNowY = poll[3];

                for (int i = 0; i < 4; i++) {
                    int snx = sNowX + theX[i];
                    int sny = sNowY + theY[i];
                    int bnx = snx + theX[i];
                    int bny = sny + theY[i];

                    if (snx >= 0 && sny >= 0 && snx < m && sny < n && maze[snx][sny] != '#' &&
                            (snx != bNowX || sny != bNowY) &&
                            arr[snx][sny][bNowX][bNowY] == 0) {

                        arr[snx][sny][bNowX][bNowY] = arr[sNowX][sNowY][bNowX][bNowY] + 1;

                        queue.offer(new int[]{snx, sny, bNowX, bNowY});

                    } else if (snx == bNowX && sny == bNowY &&
                            bnx >= 0 && bny >= 0 && bnx < m && bny < n && maze[bnx][bny] != '#' &&
                            arr[snx][sny][bnx][bny] == 0
                            ) {

                        arr[snx][sny][bnx][bny] = arr[sNowX][sNowY][snx][sny] + 1;

                        if (bnx == eX && bny == eY) {
                            System.out.println(arr[snx][sny][bnx][bny]);
                            return;
                        }

                        queue.offer(new int[]{snx, sny, bnx, bny});
                    }
                }
            }
            System.out.println(-1);
        }

        // up right down left
        int[] theX = new int[]{-1, 0, 1, 0};
        int[] theY = new int[]{0, 1, 0, -1};
    }

    房间分配
    有n个房间，现在i号房间里的人需要被重新分配，分配的规则是这样的：先让i号房间里的人全都出来，接下来按照 i+1, i+2, i+3, ... 的顺序依此往这些房间里放一个人，n号房间的的下一个房间是1号房间，直到所有的人都被重新分配。
    现在告诉你分配完后每个房间的人数以及最后一个人被分配的房间号x，你需要求出分配前每个房间的人数。数据保证一定有解，若有多解输出任意一个解。

    输入描述:
    第一行两个整数n, x (2<=n<=10^5, 1<=x<=n)，代表房间房间数量以及最后一个人被分配的房间号；
    第二行n个整数 a_i(0<=a_i<=10^9) ，代表每个房间分配后的人数。


    输出描述:
    输出n个整数，代表每个房间分配前的人数。
    示例1
            输入
3 1
        6 5 1
    输出
4 4 4

    链接：https://www.nowcoder.com/questionTerminal/43068a1013b4417a85c2c2ce8b18159e
    来源：牛客网
//从最后一个位置倒推，当遇到-1时截止
    importjava.math.BigInteger;
    importjava.util.Scanner;
    publicclassMain{
        publicstaticvoidmain(String[] args) {
            Scanner in = newScanner(System.in);
            intsize = in.nextInt();//房间数
            intlastroot = in.nextInt();//最后一个分配的房间
            BigInteger[] p = newBigInteger[size];
            BigInteger min = newBigInteger(String.valueOf(Integer.MAX_VALUE));
            for(inti = 0; i < p.length; i++){
                p[i] = in.nextBigInteger();
                min = min.compareTo(p[i])==1?p[i]:min;
            }
            BigInteger flag = newBigInteger(String.valueOf(min)).multiply(newBigInteger(String.valueOf(size)));
            while(true){
                flag = flag.add(BigInteger.ONE);
                p[lastroot-1] = p[lastroot-1].subtract(BigInteger.ONE);
                if(p[lastroot-1].compareTo(min.subtract(BigInteger.ONE))==0)
                    break;
                --lastroot;
                if(lastroot==0)
                    lastroot = size;
            }
            p[lastroot-1] = p[lastroot-1].add(flag);
            for(BigInteger i : p)
                System.out.print(i.subtract(min)+" ");
        }
    }
    字母交换
    链接：https://www.nowcoder.com/questionTerminal/8da0ea4b4853464795f5c32634a1b06f
    来源：牛客网


【编码题】字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？


    输入描述:
    第一行为一个字符串S与一个非负整数m。(1 <= |S| <= 1000, 1 <= m <= 1000000)

    输出描述:
    一个非负整数，表示操作之后，连续最长的相同字母数量。
    示例1
            输入
    abcbaa 2
    输出
2
    说明
    使2个字母a连续出现，至少需要3次操作。即把第1个位置上的a移动到第4个位置。
    所以在至多操作2次的情况下，最多只能使2个b或2个a连续出现。

    链接：https://www.nowcoder.com/questionTerminal/8da0ea4b4853464795f5c32634a1b06f
    来源：牛客网
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

    /**
     * @author wylu
     */
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] strs = br.readLine().split(" ");
            String s = strs[0];
            int m = Integer.parseInt(strs[1]);

            ArrayList<ArrayList<Integer>> positions = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                positions.add(new ArrayList<>());
            }
            for (int i = 0; i < s.length(); i++) {
                positions.get(s.charAt(i) - 'a').add(i);
            }

            int res = 0;
            //对所有字母，求在至多m次交换后所能形成最长相同且连续的子串的长度
            for (int i = 0; i < 26; i++) {
                res = Math.max(res, cal(positions.get(i), m));
            }
            System.out.println(res);
        }

        //求在至多m次交换后，字符串最多有多少个给定的字母连续
        private static int cal(ArrayList<Integer> p, int m) {
            //dp[i][j]: 将位置p[i], ... , p[j]的字母移到一起使之连续所需要的最少移动次数
            int[][] dp = new int[p.size()][p.size()];
            for (int i = 0; i < p.size() - 1; i++) {
                dp[i][i + 1] = p.get(i + 1) - p.get(i) - 1;
            }

            //给定字母出现多次且不连续时，从两侧往中间移，保证移动次数最少
            for (int len = 2; len < p.size(); len++) {
                for (int i = 0; i < p.size() - len; i++) {
                    int j = i + len;
                    dp[i][j] = dp[i + 1][j - 1] + (p.get(j) - p.get(i)) - (j - i);
                }
            }

            int res = 0;
            for (int i = 0; i < p.size(); i++) {
                for (int j = i; j < p.size(); j++) {
                    if (dp[i][j] <= m) {
                        res = Math.max(res, j - i + 1);
                    }
                }
            }
            return res;
        }
    }
    用户喜好
    链接：https://www.nowcoder.com/questionTerminal/d25162386a3140cbbe6dc071e1eb6ed6
    来源：牛客网


    为了不断优化推荐效果，今日头条每天要存储和处理海量数据。假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，对于一类文章，每个用户都有不同的喜好值，我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，有多少用户对这类文章喜好值为k。因为一些特殊的原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。


    输入描述:
    输入： 第1行为n代表用户的个数 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度 第3行为一个正整数q代表查询的组数  第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数据范围n <= 300000,q<=300000 k是整型


    输出描述:
    输出：一共q行，每行一个整数代表喜好值为k的用户的个数
            示例1
    输入
5
        1 2 3 3 5
        3
        1 2 1
        2 4 5
        3 5 3
    输出
1
        0
        2
    说明
    样例解释:
    有5个用户，喜好值为分别为1、2、3、3、5，
    第一组询问对于标号[1,2]的用户喜好值为1的用户的个数是1
    第二组询问对于标号[2,4]的用户喜好值为5的用户的个数是0
    第三组询问对于标号[3,5]的用户喜好值为3的用户的个数是2

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            HashMap<Integer,ArrayList<Integer>> hm=new HashMap<Integer,ArrayList<Integer>>();
            for(int i=0;i<n;i++) {
                int temp=sc.nextInt();
                if(hm.containsKey(temp)) {
                    hm.get(temp).add(i);
                }else {
                    ArrayList<Integer> al=new ArrayList<Integer>();
                    al.add(i);
                    hm.put(temp,al);
                }

            }

            int m=sc.nextInt();
            int b[]=new int[m];

            for(int j=0;j<m;j++) {
                int low=sc.nextInt()-1;
                int high=sc.nextInt()-1;
                int key=sc.nextInt();
                if(!hm.containsKey(key)) {
                    b[j]=0;
                }else {
                    b[j]=getNum(low, high,hm.get(key));
                }

            }
            for(int j=0;j<m;j++) {
                System.out.println(b[j]);
            }


            sc.close();


        }
        public static int getNum(int low ,int high,ArrayList<Integer> al) {
            int i=0;
            int j=al.size()-1;
            if(al.get(i)>high || al.get(j)<low ) {
                return 0;
            }else {
                while(al.get(i)<low || al.get(j)>high) {
                    if(al.get(i)<low) i++;
                    if(al.get(j)>high) j--;
                }
                return j-i+1;
            }


        }


    }

    手串
    链接：https://www.nowcoder.com/questionTerminal/0bb1fad52f474bdaa4d7636ca3a98244
    来源：牛客网


    作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次（注意这里手串是一个环形）。手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种颜色不符合要求。即询问有多少种颜色在任意连续m个串珠中出现了至少两次。

    输入描述:
    第一行输入n，m，c三个数，用空格隔开。(1 <= n <= 10000, 1 <= m <= 1000, 1 <= c <= 50) 接下来n行每行的第一个数num_i(0 <= num_i <= c)表示第i颗珠子有多少种颜色。接下来依次读入num_i个数字，每个数字x表示第i颗柱子上包含第x种颜色(1 <= x <= c)


    输出描述:
    一个非负整数，表示该手链上有多少种颜色不符需求。
    示例1
            输入
5 2 3
        3 1 2 3
        0
        2 2 3
        1 2
        1 3
    输出
2
    说明
    第一种颜色出现在第1颗串珠，与规则无冲突。
    第二种颜色分别出现在第 1，3，4颗串珠，第3颗与第4颗串珠相邻，所以不合要求。
    第三种颜色分别出现在第1，3，5颗串珠，第5颗串珠的下一个是第1颗，所以不合要求。
    总计有2种颜色的分布是有问题的。
    这里第2颗串珠是透明的。

    思路：直接对题目意思进行模拟，把每一列看成一种颜色，让后对一列进行模拟使用 % ,因为 51 % 50 = 1,当前的位置就会变成第一个位置,这样只要判断某个位置的后m个会不会的继续出现相同的值，如果出现就代表不符合题目的要求

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

    /**
     * @Auther: xuzhangwang
     * @Description:
     */
    public class Main {
        static int m;
        static int n;
        static int c;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            m = sc.nextInt();
            c = sc.nextInt();
            sc.nextLine();
            int[][] nums_color = new int[n][c];
            for (int i = 0; i < n; i++) {
                int tmp = sc.nextInt();
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < tmp; j++) {
                    int num = sc.nextInt();
                    nums_color[i][num - 1] = num;
                }
            }

            int ans = 0;
            for (int j = 0; j < nums_color[0].length; j++) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < nums_color.length; i++) {
                    list.add(nums_color[i][j]);
                }
                if (!check(list)) {
                    ans++;
                }
            }

            System.out.println(ans);
        }

        private static boolean check(List<Integer> list) {

            for (int i = 0; i < list.size(); i++) {
                for (int j = 1; j < m; j++) {
                    if (list.get(i) == 0) continue;
                    int start = list.get(i);
                    int end = (list.get((i  + j)  % n));
                    if (Math.abs(start - end) == 0) return false;
                }

            }
            return true;

        }
    }

    最长对称子字符串（最长回文串）
    给定一个字符串（数字或大小写字母）, 找出最长的对称的子串（如有多个，输出任意一个）。
    例如：
    输入：“abbaad”
    输出：“abba”

    输入描述:
    字符串

    输出描述:
    字符串

    输入例子1:
    a1223a

    输出例子1:
            22

            import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {

            //1、输入字符串
            String str;
            String maxStr="";//最终的结果
            Scanner scanner = new Scanner(System.in);
            str = scanner.nextLine();

            if(str==null)
                return;
            if(str.length()<=1)//字符串长度为1
                maxStr = str;
            if(str.length()==2){ //字符串长度为2
                if(str.charAt(0)==str.charAt(1))
                    maxStr = str;
                else
                    maxStr = str.substring(1);
            }else{//字符串长度大于等于3时

                //遍历数组，以每个字符为中心找对称字符串
                for(int i=1;i<str.length()-1;i++){
                    String strTemp;
                    int left=i,right=i;
                    if(str.charAt(i-1)==str.charAt(i+1)){
                        left = i-1;
                        right = i+1;

                    }else if(str.charAt(i-1)==str.charAt(i)){
                        left = i-1;
                        right = i;
                    }else if(str.charAt(i)==str.charAt(i+1)){
                        left = i;
                        right = i+1;
                    }
                    strTemp = getStr(left, right, str);
                    if(strTemp==null){
                        strTemp = str.substring(left,right+1);
                    }

                    if(strTemp.length()>maxStr.length()){
                        maxStr = strTemp;
                    }

                }
                System.out.println(maxStr);
            }
        }
        public static String getStr(int left,int right,String s){
            int i =left,j = right;
            while(i>=0&&j<s.length()){
                if(s.charAt(i)==s.charAt(j)){
                    i--;
                    j++;
                }else{
                    return s.substring(i+1, j);
                }
            }
            if(i<0){
                return s.substring(0,j);
            }else if(j>=s.length()){
                return s.substring(i+1,j);
            }
            return null;
        }

    }
    字符串相乘（大整数相乘）
    给定两个数字（0-9）字符串（长度不限）求它们的乘积。

    输入描述:
    第一行为第一个数字字符串

            第二行为第二个数字字符串

    输出描述:
    乘积字符串

    输入例子1:
            123
            20

    输出例子1:
            2460

            import java.util.Scanner;
    /**
     •	Created by linjian on 17/8/5.
     */
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String num1 = scanner.next();
            String num2 = scanner.next();
            System.out.println(multiply(num1,num2));
        }
        public static String multiply(String num1, String num2) {
            num1 = new StringBuilder(num1).reverse().toString();
            num2 = new StringBuilder(num2).reverse().toString();
            // even 99 * 99 is < 10000, so maximaly 4 digits
            int[] d = new int[num1.length() + num2.length()];
            for (int i = 0; i < num1.length(); i++) {
                int a = num1.charAt(i) - '0';
                for (int j = 0; j < num2.length(); j++) {
                    int b = num2.charAt(j) - '0';
                    d[i + j] += a * b;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < d.length; i++) {
                int digit = d[i] % 10;
                int carry = d[i] / 10;
                sb.insert(0, digit);
                if (i < d.length - 1)
                    d[i + 1] += carry;
            }
            //trim starting zeros
            while (sb.length() > 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }

    编程题3（产品经理让程序员实现idea）
    链接：https://www.nowcoder.com/questionTerminal/f76b7bc64e554edaa53d8e0d84f921c5
    来源：牛客网
    产品经理(PM)有很多好的idea，而这些idea需要程序员实现。现在有N个PM，在某个时间会想出一个 idea，每个 idea 有提出时间、所需时间和优先等级。对于一个PM来说，最想实现的idea首先考虑优先等级高的，相同的情况下优先所需时间最小的，还相同的情况下选择最早想出的，没有 PM 会在同一时刻提出两个 idea。
    同时有M个程序员，每个程序员空闲的时候就会查看每个PM尚未执行并且最想完成的一个idea,然后从中挑选出所需时间最小的一个idea独立实现，如果所需时间相同则选择PM序号最小的。直到完成了idea才会重复上述操作。如果有多个同时处于空闲状态的程序员，那么他们会依次进行查看idea的操作。
    求每个idea实现的时间。
    输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。随后有P行，每行有4个数字，分别是PM序号、提出时间、优先等级和所需时间。输出P行，分别表示每个idea实现的时间点。

    输入描述:
    输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。随后有P行，每行有4个数字，分别是PM序号、提出时间、优先等级和所需时间。全部数据范围 [1, 3000]。


    输出描述:
    输出P行，分别表示每个idea实现的时间点。
    示例1
            输入
2 2 5
        1 1 1 2
        1 2 1 1
        1 3 2 2
        2 1 1 2
        2 3 5 5
    输出
3
        4
        5
        3
        9

    链接：https://www.nowcoder.com/questionTerminal/f76b7bc64e554edaa53d8e0d84f921c5
    来源：牛客网
import java.util.*;

    public class Main {
        public static void main( String[] args ) {
            Scanner sc = new Scanner( System.in );
            int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();
            Idea[] ideas = new Idea[p];
            Thinker[] thinkers = new Thinker[n];
            Implementor[] implementors = new Implementor[m];
            for( int i = 0; i < m; i ++ )
                impleQueue.push( implementors[i] = new Implementor() );
            for( int i = 0; i < n; i ++ )
                thinkers[i] = new Thinker( i );
            for( int i = 0; i < p; i ++ ) {
                int pm = sc.nextInt()-1;
                int time = sc.nextInt();
                int prio = sc.nextInt();
                int cost = sc.nextInt();
                ideas[i] = new Idea( time, prio, cost );
                events.offer( thinkers[pm].getIdea( ideas[i] ) );
            }
            while( !events.isEmpty() ) {
                int time = events.peek().time;
                do { events.poll().occur();
                } while( !events.isEmpty() && events.peek().time == time );
                while( !impleQueue.isEmpty() && !thinkerQueue.isEmpty() ) {
                    Thinker tmp1 = thinkerQueue.poll();
                    Implementor tmp2 = impleQueue.pop();
                    Idea tmp3 = tmp1.ideaQueue.poll();
                    tmp3.finish = time + tmp3.cost;
                    events.offer( tmp2.peekIdea( tmp3 ) );
                    if( !tmp1.ideaQueue.isEmpty() ) thinkerQueue.offer( tmp1 );
                }
            }
            for( int i = 0; i < p; i ++ )
                System.out.println( ideas[i].finish );
            sc.close();
        }
        static PriorityQueue<Thinker> thinkerQueue = new PriorityQueue<>(
                (Thinker t1,Thinker t2) -> {
                    int c1 = t1.ideaQueue.peek().cost;
                    int c2 = t2.ideaQueue.peek().cost;
                    return c1 == c2 ? t1.order - t2.order : c1 - c2;
                }
        );
        static ArrayDeque<Implementor> impleQueue = new ArrayDeque<>();
        static PriorityQueue<Event> events =
                new PriorityQueue<>( (Event e1,Event e2) -> e1.time - e2.time );
        static class Idea {
            int time, prio, cost, finish;
            Idea( int t, int p, int c ) { time = t; prio = p; cost = c; }
        }
        static class Thinker {
            PriorityQueue<Idea> ideaQueue = new PriorityQueue<>(
                    (Idea i1,Idea i2) -> {
                        if( i1.prio != i2.prio ) return i2.prio - i1.prio;
                        else if( i1.cost != i2.cost ) return i1.cost - i2.cost;
                        else return i1.time - i2.time;
                    }
            );
            int order;
            Thinker( int o ) { order = o; }
            IdeaEvent getIdea( Idea idea ) {
                return new IdeaEvent( this, idea );
            }
        }
        static class Implementor {
            FinishEvent peekIdea( Idea idea ) {
                return new FinishEvent( this, idea );
            }
        }
        static abstract class Event {
            int time;
            Event( int t ) { time = t; }
            abstract void occur();
        }
        static class IdeaEvent extends Event {
            Thinker thinker;
            Idea idea;
            IdeaEvent( Thinker t, Idea i ) {
                super( i.time );
                thinker = t; idea = i;
            }
            void occur() {
                thinkerQueue.remove( thinker );
                thinker.ideaQueue.offer( idea );
                thinkerQueue.offer( thinker );
            }
        }
        static class FinishEvent extends Event {
            Implementor implementor;
            Idea idea;
            FinishEvent( Implementor imple, Idea i ) {
                super( i.finish );
                implementor = imple; idea = i;
            }
            void occur() {
                impleQueue.push( implementor );
            }
        }
    }

    二维平面最大点（编程题1）
    链接：https://www.nowcoder.com/questionTerminal/ea209d6014c44763a41ee04a11bf2ef1
    来源：牛客网
    P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
    如下图：实心点为满足条件的点的集合。请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。



    输入描述:
    第一行输入点集的个数 N， 接下来 N 行，每行两个数字代表点的 X 轴和 Y 轴。
    对于 50%的数据,  1 <= N <= 10000;
    对于 100%的数据, 1 <= N <= 500000;

    输出描述:
    输出“最大的” 点集合， 按照 X 轴从小到大的方式输出，每行两个数字分别代表点的 X 轴和 Y轴。
    示例1
            输入
5
        1 2
        5 3
        4 6
        7 5
        9 0
    输出
4 6
        7 5
        9 0
    链接：https://www.nowcoder.com/questionTerminal/ea209d6014c44763a41ee04a11bf2ef1
    来源：牛客网

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

    public class Main0 {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for(int i=0; i<n; i++){
                a[i] = in.nextInt();
                b[i] = in.nextInt();
            }
            int maxY = b[n-1];
            for(int i=n-2; i>=0; i--){
                if(b[i]>maxY){
                    System.out.println(a[i]+" "+b[i]);
                }
            }
            System.out.println(a[n-1]+" "+b[n-1]);

        }

    }

    计算区间的值（编程题2）
    链接：https://www.nowcoder.com/questionTerminal/1aeba6ba677949249aba82d81edc3fea
    来源：牛客网
    给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
    区间中的最小数 * 区间所有数的和最后程序输出经过计算后的最大值即可，不需要输出具体的区间。如给定序列  [6 2 1]则根据上述公式, 可得到所有可以选定各个区间的计算值:

            [6] = 6 * 6 = 36;
[2] = 2 * 2 = 4;
[1] = 1 * 1 = 1;
[6,2] = 2 * 8 = 16;
[2,1] = 1 * 3 = 3;
[6, 2, 1] = 1 * 9 = 9;

    从上述计算可见选定区间 [6] ，计算值为 36， 则程序输出为 36。
    区间内的所有数字都在[0, 100]的范围内;

    输入描述:
    第一行输入数组序列长度n，第二行输入数组序列。
    对于 50%的数据,  1 <= n <= 10000;
    对于 100%的数据, 1 <= n <= 500000;


    输出描述:
    输出数组经过计算后的最大值。
    示例1
            输入
3
        6 2 1
    输出
36

    链接：https://www.nowcoder.com/questionTerminal/1aeba6ba677949249aba82d81edc3fea
    来源：牛客网
    先找出数组中每一个数字所对应的最大范围然后与该位置的数字相乘存在另一个数组中，遍历这个数组可得
import java.util.Scanner;

    public class Main {

        public static void main(String srg[]) {

            Scanner sc = new Scanner(System.in);
            while(sc.hasNext())
            {
                int n = sc.nextInt();
                int a[] = new int[n];
                int b[] = new int[n];
                for (int i = 0;i < n;i++)
                {
                    a[i] = sc.nextInt();
                }
                for(int i = 0;i < n;i++)
                {
                    int p = i,q = i+1,sum = 0;
                    while(p >=0&&a[i] <= a[p])
                    {
                        sum += a[p];
                        p--;
                    }
                    while(q < n&&a[i] <= a[q])
                    {
                        sum += a[q];
                        q++;
                    }
                    b[i] = a[i] * sum;
                }
                int max = b[0];
                for(int i = 1;i < n;i++)
                {
                    if(b[i] > max)
                        max = b[i];
                }
                System.out.println(max);
            }
        }
    }
    字符串组合
    链接：https://www.nowcoder.com/questionTerminal/837f4d04f5cb4f26a8215b2b95cc76a5
    来源：牛客网

    输入一个字符串，输出该字符串中相邻字符的所有组合。
    举个例子，如果输入abc，它的组合有a、b、c、ab、bc、abc。（注意：输出的组合需要去重）（40分）
    输入描述:
    一个字符串

    输出描述:
    一行，每个组合以空格分隔，相同长度的组合需要以字典序排序，且去重。
    示例1
            输入
    bac
            输出
    a b c ac ba bac

    链接：https://www.nowcoder.com/questionTerminal/837f4d04f5cb4f26a8215b2b95cc76a5
    来源：牛客网
import java.util.*;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (str.length() <= 1) {
                System.out.println(str);
            }
            List rst = new ArrayList();
            helper(rst, new StringBuilder(), 0, str);
            Collections.sort(rst, (a, b) -> a.length() == b.length()
                    ? a.compareTo(b) : a.length() - b.length());
            for (int i = 0; i < rst.size(); i++) {
                System.out.print(rst.get(i) + " ");
            }
        }
        public static void helper(List rst, StringBuilder sb, int start, String str) {
            if (rst.contains(sb.toString())) {
                return;
            }
            if (sb.length() == 1) {
                rst.add(sb.toString());
            } else if (sb.length() > 1 && str.contains(sb.toString())) {
                rst.add(sb.toString());
            }
            for (int i = start; i < str.length(); i++) {
                sb.append(str.charAt(i));
                helper(rst, sb, i + 1, str);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    数独
    链接：https://www.nowcoder.com/questionTerminal/f43c26af3b5c4a5fa566460dbbd28a14
    来源：牛客网

    数独是一个非常有名的游戏。整个是一个9X9的大宫格，其中又被划分成9个3X3的小宫格。要求在每个小格中放入1-9中的某个数字。要求是：每行、每列、每个小宫格中数字不能重复。 现要求用计算机求解数独。（50分）
    输入描述:
    输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的数字。

    输出描述:
    输出九行，每行九个空格隔开的数字，为解出的答案。
    示例1
            输入
0 9 0 0 0 0 0 6 0
        8 0 1 0 0 0 5 0 9
        0 5 0 3 0 4 0 7 0
        0 0 8 0 7 0 9 0 0
        0 0 0 9 0 8 0 0 0
        0 0 6 0 2 0 7 0 0
        0 8 0 7 0 5 0 4 0
        2 0 5 0 0 0 8 0 7
        0 6 0 0 0 0 0 9 0
    输出
7 9 3 8 5 1 4 6 2
        8 4 1 2 6 7 5 3 9
        6 5 2 3 9 4 1 7 8
        3 2 8 4 7 6 9 5 1
        5 7 4 9 1 8 6 2 3
        9 1 6 5 2 3 7 8 4
        1 8 9 7 3 5 2 4 6
        2 3 5 6 4 9 8 1 7
        4 6 7 1 8 2 3 9 5

    链接：https://www.nowcoder.com/questionTerminal/f43c26af3b5c4a5fa566460dbbd28a14
    来源：牛客网
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    /**
     * @author wylu
     */
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[][] sudoku = new int[9][9];
            for (int i = 0; i < 9; i++) {
                String[] strs = br.readLine().split(" ");
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(strs[j]);
                }
            }

            dfs(sudoku, 0, 0);
        }

        private static boolean dfs(int[][] sudoku, int i, int j) {
            if (i == 8 && j == 9) {
                prtSudoku(sudoku);
                return true;
            }
            if (j == 9) {
                i++;
                j = 0;
            }

            boolean res = false;
            if (sudoku[i][j] == 0) {
                boolean[] options = optionalNumber(sudoku, i, j);
                for (int k = 1; k < options.length; k++) {
                    if (!res && !options[k]) {
                        sudoku[i][j] = k;
                        res = dfs(sudoku, i, j + 1);
                    }
                }
                if (!res) sudoku[i][j] = 0;
            } else {
                dfs(sudoku, i, j + 1);
            }
            return res;
        }

        private static void prtSudoku(int[][] sudoku) {
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku[0].length - 1; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println(sudoku[i][sudoku[0].length - 1]);
            }
        }

        private static boolean[] optionalNumber(int[][] sudoku, int x, int y) {
            boolean[] options = new boolean[10];
            for (int i = 0; i < sudoku.length; i++) {
                options[sudoku[x][i]] = true;
                options[sudoku[i][y]] = true;
            }
            int row = x / 3 * 3, col = y / 3 * 3;
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    options[sudoku[i][j]] = true;
                }
            }
            return options;
        }
    }

    计算一年中的第几天
    链接：https://www.nowcoder.com/questionTerminal/178aa3dafb144bb8b0445edb5e9b812a
    来源：牛客网
    今年的第几天？
    输入年、月、日，计算该天是本年的第几天。

    输入描述:
    包括三个整数年(1<=Y<=3000)、月(1<=M<=12)、日(1<=D<=31)。

    输出描述:
    输入可能有多组测试数据，对于每一组测试数据，
    输出一个整数，代表Input中的年、月、日对应本年的第几天。
    示例1
            输入
1990 9 20
        2000 5 1
    输出
263
        122

    链接：https://www.nowcoder.com/questionTerminal/178aa3dafb144bb8b0445edb5e9b812a
    来源：牛客网
import java.util.Scanner;

    /**
     * 计算一年中的第几天
     * 今年的第几天？
     * 输入年、月、日，计算该天是本年的第几天。
     * 输入描述:
     * 包括三个整数年(1<=Y<=3000)、月(1<=M<=12)、日(1<=D<=31)。
     * 输出描述:
     * 输入可能有多组测试数据，对于每一组测试数据，
     * 输出一个整数，代表Input中的年、月、日对应本年的第几天。
     * 输入例子1:
     * 1990 9 20
     * 2000 5 1
     * 输出例子1:
     * 263
     * 122
     *
     * @author shijiacheng
     * @date 2018/2/21
     */
    public class DayOfYeafSolution {
        public static void main(String[] args){
            int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextInt()){
                int Y = sc.nextInt();
                int M = sc.nextInt();
                int D = sc.nextInt();

                if (isLeapYear(Y)){
                    days[1] = days[1]+1;
                }

                int day = 0;
                for (int i = 1; i < M; i++) {
                    day+=days[i-1];
                }
                day +=D;
                System.out.println(day);
            }
        }

        /**
         * 判断是否是闰年
         * @param year
         * <a href="/profile/547241" data-card-uid="547241" class="js-nc-card" target="_blank" style="color: #25bb9b">@return
         */
        public static boolean isLeapYear(int year){
            if (year%4==0&&year%100!=0){
                return true;
            }else if (year%400==0){
                return true;
            }
            return false;
        }
    }
    包裹运输
    链接：https://www.nowcoder.com/questionTerminal/6e9ce0dcb36a47328ee9c92394717c4e
    来源：牛客网
    工厂生产的产品包装在相同高度h，尺寸为1 * 1,2 * 2，3 * 3，4 * 4，5 * 5，6 * 6的方形包装中。 这些产品始终以与产品高度相同的尺寸为6 * 6的包裹交付给客户。因为邮费很贵，所以工厂要想方设法的减小每个订单运送时的包裹数量。他们很需要有一个好的程序帮他们解决这个问题从而节省费用。现在这个程序由你来设计。


    输入描述:
    输入文件包括几行，每一行代表一个订单。每个订单里的一行包括六个整数，中间用空格隔开，分别为 1*1 至 6*6 这六种产品的数量。输入文件将以 6 个 0 组成的一行结尾。


    输出描述:
    除了输入的最后一行 6 个 0 以外，输入文件里每一行对应着输出文件的一行，每一行输出一个整数代表对应的订单所需的最小包裹数。
    示例1
            输入
0 0 4 0 0 1
        7 5 1 0 0 0
        0 0 0 0 0 0
    输出
2
        1
    思路：贪心。首先放6、5、4，每个各需要一个箱子。其中5只能用1填充，4可以用2或1填充。
    然后放3。可以用2或1填充。
    因为1可以填充任何空闲的地方。所以先算尽可能多用2填充的情况。
    最后把1放了。
    链接：https://www.nowcoder.com/questionTerminal/6e9ce0dcb36a47328ee9c92394717c4e
    来源：牛客网
import java.util.*;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                int[] arr = new int[7];
                boolean flag = true;
                for (int i=1; i<=6; i++) {
                    arr[i] = sc.nextInt();
                    if (arr[i] != 0) { flag = false; }
                }
                if (flag) { return; }
                int ans = 0;
                ans = ans + arr[6] + arr[5] + arr[4] + (arr[3] + 3) / 4;
                int[] two_in_three = {0, 5, 3, 1};
                ans += Math.max(0, ((arr[2] - arr[4] * 5 - two_in_three[arr[3] % 4] + 8) / 9));
                ans += Math.max(0, ((arr[1] - (36 * ans  - 36 * arr[6] - 25 * arr[5] - 16 * arr[4] - 9 * arr[3] - 4 * arr[2] + 35)) / 36));
                System.out.println(ans);
            }
        }

    }
    Kolakoski 序列
    链接：https://www.nowcoder.com/questionTerminal/79358002fe7c48a6a74f96c0dc734fa1
    来源：牛客网
    Kolakoski 序列是个自生成的无限序列。
    例如，当给定的整数组为 [1, 2] 时，Kolakoski 序列是这样的：
            [1,2,2,1,1,2,1,2,2,1,2,2,1,1,2,1,1,2,2,1,2,1,1,2,1,2,2,1,1,…]
    如果我们将相邻的相同的数字分成一组，那么将会得到：
            [[1],[2,2],[1,1],[2],[1],[2,2],[1],[2,2],[1,1],[2],[1,1],[2,2],[1],[2],[1,1],[2],[1],[2,2],[1,1],…]
    可以看出，每组数字交替由 1, 2 组成。
    接下来对每个分组求他的长度，得到：
            [1,2,2,1,1,2,1,2,2,1,2,2,1,1,2,1,1,2,2,1,2,1,1,2,1,2,2,1,1,…]
    可以看出，经过如上的变换后，数列保持不变。
    对于其他给定的整数组，同样可以用类似的方法构造 Kolakoski 序列，例如给定整数组 [2, 3] 时：
            [2,2,3,3,2,2,2,3,3,3,2,2,3,3,2,2,3,3,3,2,2,2,3,3,3,2,2,3,3,…]
    给定整数组 [2, 1, 3, 1] 时，构造得到如下：
            [2,2,1,1,3,1,2,2,2,1,3,3,1,1,2,2,1,3,3,3,1,1,1,2,1,3,3,1,1,…]

    输入描述:
    输入由两行组成：
    第一行包括两个正整数 n, m
    第二行包括 m 个正整数 a[]
    数据规模与限制：
            0 < n < 10000
            1 < m < 1000
            0 < a[i] < 1000
    a[i] 不等于 a[i + 1]
    a[0] 不等于 a[m-1]

    输出描述:
    每行一个数字，共 n 行
    整数组 a 生成的 Kolakoski 序列的前 n 项
            示例1
    输入
30 4
        2 1 3 1
    输出
2
        2
        1
        1
        3
        1
        2
        2
        2
        1
        3
        3
        1
        1
        2
        2
        1
        3
        3
        3
        1
        1
        1
        2
        1
        3
        3
        1
        1
        2

        import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int outNum = sc.nextInt();//输出长度
            int len = sc.nextInt();//个数
            int[] arr = new int[len];//组成数组
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
            }
            int p1 = 0;//组成数字的位置
            int p2 = 0;//输出数组的位置
            int[] out = new int[outNum];
            int num = 0;//一个数字输出的次数
            while (true) {
                if (num >= outNum) {
                    break;
                }
                int times = num == 0 ? arr[p1] : out[num];//第一次使用第一个数字作为次数
                if (times == 0) {//如果输出数组已经无法再遍历,那么就要从存数的数组再找数字
                    times = arr[p1];
                }
                num++;
                for (int i = 0; i < times; i++) {//取一个位置的值n,赋n个n
                    if (p2 >= outNum) {
                        break;
                    }
                    out[p2] = arr[p1];
                    p2++;
                }
                p1 = (p1 + 1) % len;//p1右移
                if (p2 >= outNum) {
                    break;
                }
            }
            for (int i = 0; i < outNum; i++) {
                System.out.println(out[i]);
            }
            sc.close();
        }
    }
    列表补全
    链接：https://www.nowcoder.com/questionTerminal/8d677d9c6af643f28c2153ee4e435ea4
    来源：牛客网
    在商城的某个位置有一个商品列表，该列表是由L1、L2两个子列表拼接而成。当用户浏览并翻页时，需要从列表L1、L2中获取商品进行展示。展示规则如下：
            1. 用户可以进行多次翻页，用offset表示用户在之前页面已经浏览的商品数量，比如offset为4，表示用户已经看了4个商品
2. n表示当前页面需要展示的商品数量
3. 展示商品时首先使用列表L1，如果列表L1长度不够，再从列表L2中选取商品
4. 从列表L2中补全商品时，也可能存在数量不足的情况
    请根据上述规则，计算列表L1和L2中哪些商品在当前页面被展示了

    输入描述:
    每个测试输入包含1个测试用例，包含四个整数，分别表示偏移量offset、元素数量n，列表L1的长度l1，列表L2的长度l2。


    输出描述:
    在一行内输出四个整数分别表示L1和L2的区间start1，end1，start2，end2，每个数字之间有一个空格。
    注意，区间段使用半开半闭区间表示，即包含起点，不包含终点。如果某个列表的区间为空，使用[0, 0)表示，如果某个列表被跳过，使用[len, len)表示，len表示列表的长度。
    示例1
            输入
2 4 4 4
        1 2 4 4
        4 1 3 3
    输出
2 4 0 2
        1 3 0 0
        3 3 1 2

    链接：https://www.nowcoder.com/questionTerminal/8d677d9c6af643f28c2153ee4e435ea4
    来源：牛客网
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    /**
     * @author wylu
     */
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(" ");
                int offset = Integer.parseInt(strs[0]), n = Integer.parseInt(strs[1]);
                int len1 = Integer.parseInt(strs[2]), len2 = Integer.parseInt(strs[3]);

                int s1 = Math.min(offset, len1);
                int e1 = Math.min(offset + n, len1);
                int s2 = Math.min(len2, Math.max(0, offset - len1));
                int e2 = Math.max(0, Math.min(len2, offset + n - len1));
                System.out.println(s1 + " " + e1 + " " + s2 + " " + e2);
            }
        }
    }

    拼多多周年庆Anniversary
    链接：https://www.nowcoder.com/questionTerminal/bc858b8477c44951bfde0c5941396622
    来源：牛客网

    拼多多王国的城市和道路的拓扑结构比较特别，是一个树状结构：
            1. 每个城市是树的一个节点；
            2. 城市之间的道路是树的一条边；
            3. 树的根节点是首都。
    拼多多周年庆马上就要到了，这是拼多多王国的一个大日子。为了活跃气氛，国王想在道路上布置花灯。花灯可是很贵的东西，尽管国王想要在所有道路上都布置花灯，但是如果要花太多钱的话，是过不了财政大臣那一关的。国王把这个计划告诉财政大臣，最后他们商讨出来这么一个方案：
            1. 一条道路要么不布置花灯，要么整条布置花灯，不能选择其中的某一段布置；
            2. 除非没有道路通向首都，否则至少为一条通向首都的道路布置花灯；
            3. 所有布置花灯的道路构成的子图是连通的，这保证国王从首都出发，能通过只走布置了花灯的道路，把所有的花灯游览完；
            4. 如果某个城市（包括首都）有大于等于2条道路通向子城市，为了防止铺张浪费，最多只能选择其中的两条路布置花灯；
            5. 布置花灯的道路的总长度设定一个上限。
    在上述方案下，国王想要使得布置花灯的道路长度越长越好，你帮国王想想办法。

    输入描述:
    每个测试输入包含1个测试用例。

    输入的第一行是一个正整数m，0<m<=9900，表示布置花灯的道路的总长度的上限。

    输入的第二行是一个正整数n，n<=100，表示城市的个数。

    紧接着是n-1行输入，每行三个正整数u、v、d，表示下标为u的城市有一条长度为d的道路通向它的一个子城市v，其中0<=u<n，0<=v<n，0<d<=100。




    输出描述:
    输出一个正整数，表示能布置花灯的道路长度的最大值
            示例1
    输入
5
        5
        0 1 1
        0 2 2
        0 3 3
        0 4 4
    输出
5

        import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

    /**
     * @author wylu
     */
    public class Main {
        static int m;
        static ArrayList<Integer> parents = new ArrayList<>();
        static ArrayList<HashSet<Integer>> children = new ArrayList<>();
        static ArrayList<Integer> dists = new ArrayList<>();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            m = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                dists.add(0);
                parents.add(-1);
                children.add(new HashSet<>());
            }
            //建图
            for (int i = 0; i < n - 1; i++) {
                String[] strs = br.readLine().split(" ");
                int u = Integer.parseInt(strs[0]), v = Integer.parseInt(strs[1]);
                int d = Integer.parseInt(strs[2]);
                if (d > m) continue;
                children.get(u).add(v);
                parents.set(v, u);
                dists.set(v, d);
            }

            //寻找树根
            int root = 0;
            while (parents.get(root) != -1) root = parents.get(root);
            System.out.println(dfs(root).last());
        }

        private static TreeSet<Integer> dfs(int root) {
            TreeSet<Integer> res = new TreeSet<>();
            int d = dists.get(root);
            //如果该结点的父结点选中该元素表示不选取该结点所在分支
            res.add(0);
            if (children.get(root).size() == 0) {
                res.add(d);
                return res;
            }

            //每一个集合代表每个孩子结点的可选路径
            ArrayList<TreeSet<Integer>> sets = new ArrayList<>();
            for (int child : children.get(root)) sets.add(dfs(child));

            for (int i = 0; i < sets.size(); i++) {
                //选中一个孩子分支的情况
                for (int path : sets.get(i)) {
                    if (d + path <= m) {
                        res.add(d + path);
                    }
                }
                //选中两个孩子分支的情况
                for (int j = i + 1; j < sets.size(); j++) {
                    for (int path1 : sets.get(i)) {
                        for (int path2 : sets.get(j)) {
                            if (path1 + path2 + d <= m) {
                                res.add(path1 + path2 + d);
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
    数三角形
    链接：https://www.nowcoder.com/questionTerminal/21094574ed7e49fe9960e96e52aee1e7
    来源：牛客网

    给出平面上的n个点，现在需要你求出，在这n个点里选3个点能构成一个三角形的方案有几种。


    输入描述:
    第一行包含一个正整数n，表示平面上有n个点（n <= 100)
    第2行到第n + 1行，每行有两个整数，表示这个点的x坐标和y坐标。(所有坐标的绝对值小于等于100，且保证所有坐标不同）

    输出描述:
    输出一个数，表示能构成三角形的方案数。
    示例1
            输入
4
        0 0
        0 1
        1 0
        1 1
    输出
4
    说明
4个点中任意选择3个都能构成三角形

    链接：https://www.nowcoder.com/questionTerminal/21094574ed7e49fe9960e96e52aee1e7
    来源：牛客网
import java.util.*;
import java.lang.*;
    public class Main {
        public static void main(String args[]){
            Scanner in = new Scanner(System.in);
            int[][] pos = new int[101][2];
            int n = Integer.parseInt(in.nextLine());
            pos[0][0] = n;
            for(int i = 1; i<= n; i++) {
                String read = in.nextLine();
                String[] nums = read.split(" ");
                for(int k = 0; k<nums.length; k++){
                    pos[i][k] = Integer.parseInt(nums[k]);
                }
            }
            System.out.println(calcTriangle(pos));
        }
        public static int calcTriangle(int[][] pos) {
            int n = pos[0][0];
            if(n<3){
                return 0;
            }
            int count = 0;
            for(int i = 1; i< n-1; i++){
                for(int j = i+1; j<n; j++){
                    for(int k = j+1; k<n+1; k++){
                        if(isOnALine(pos, i, j ,k)){
                            continue;
                        }
                        count++;
                    }
                }
            }
            return count;
        }
        private static boolean isOnALine(int[][] pos, int a ,int b ,int c) {
            return (pos[a][1]-pos[b][1]) * (pos[a][0] - pos[c][0]) == (pos[a][0] - pos[b][0]) * (pos[a][1]- pos[c][1]);
        }
    }

    三个数的最大乘积
    链接：https://www.nowcoder.com/questionTerminal/4db8abc3ee814b338ebc37024d7e8b46
    来源：牛客网

    给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
    输入描述:
    第一行是数组大小n，第二行是无序整数数组A[n]

    输出描述:
    满足条件的最大乘积
            示例1
    输入
4
        3 4 1 2
    输出
24

    链接：https://www.nowcoder.com/questionTerminal/4db8abc3ee814b338ebc37024d7e8b46
    来源：牛客网
//思路 两种情况，一是两个最小负数加一个最大正数，二是三个最大正数

import java.util.Scanner;
    public class Main {
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int nextInt = scanner.nextInt();
            long min1=0,min2=0;
            long max1=0,max2=0,max3=0;
            while(scanner.hasNext()) {
                long a = scanner.nextLong();
                if(a<0) {
                    if(a<min1) {
                        min2=min1;
                        min1=a;

                    }else if(a<min2) {
                        min2=a;
                    }
                }else if(a>=0) {
                    if (a>max1) {
                        max3=max2;
                        max2=max1;
                        max1=a;
                    }else if (a>max2) {
                        max3=max2;
                        max2=a;
                    }else if(a>max3) {
                        max3=a;
                    }
                }
            }
            long result=max1*max2*max3>min1*min2*max1?max1*max2*max3:min1*min2*max1;
            System.out.println(result);
        }
    }

    小熊吃糖
    链接：https://www.nowcoder.com/questionTerminal/dc49df3bbc0146dd92322889d40afcb1
    来源：牛客网
    有n只小熊，他们有着各不相同的战斗力。每次他们吃糖时，会按照战斗力来排，战斗力高的小熊拥有优先选择权。前面的小熊吃饱了，后面的小熊才能吃。每只小熊有一个饥饿值，每次进食的时候，小熊们会选择最大的能填饱自己当前饥饿值的那颗糖来吃，可能吃完没饱会重复上述过程，但不会选择吃撑。
    现在给出n只小熊的战斗力和饥饿值，并且给出m颗糖能填饱的饥饿值。
    求所有小熊进食完之后，每只小熊剩余的饥饿值。



    输入描述:
    第一行两个正整数n和m，分别表示小熊数量和糖的数量。（n <= 10, m <= 100）
    第二行m个正整数，每个表示着颗糖能填充的饥饿值。
    接下来的n行，每行2个正整数，分别代表每只小熊的战斗力和当前饥饿值。
    题目中所有输入的数值小于等于100。


    输出描述:
    输出n行，每行一个整数，代表每只小熊剩余的饥饿值。
    示例1
            输入
2 5
        5 6 10 20 30
        4 34
        3 35
    输出
4
        0
    说明
            第一只小熊吃了第5颗糖
    第二只小熊吃了第4颗糖
            第二只小熊吃了第3颗糖
    第二只小熊吃了第1颗糖

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            str = br.readLine().split(" ");
            int[] candies = new int[m];
            for (int i = 0; i < m; i++) {
                candies[i] = Integer.parseInt(str[i]);
            }
            int[] bear_battle = new int[n];
            int[] bear_hungry = new int[n];
            for (int i = 0; i < n; i++) {
                str = br.readLine().split(" ");
                bear_battle[i] = Integer.parseInt(str[0]);
                bear_hungry[i] = Integer.parseInt(str[1]);
            }
            int maxIndex = 0;              // 最大战斗力的熊的索引
            int max = Integer.MAX_VALUE;   // 最大战斗力值
            int count = 0;                 // 已经操作了的熊的数量
            int maxCandy = -1;             // 记录最大糖果数
            while (count < n) {
                maxIndex = getMaxIndex(bear_battle, max);
                int hungry = bear_hungry[maxIndex];
                bear_hungry[maxIndex] = getHungry(candies, hungry);
                count++;
                max = bear_battle[maxIndex];
            }
            for (int i = 0; i < n; i++) {
                System.out.println(bear_hungry[i]);
            }
        }

        public static int getMaxIndex(int[] arr, int max) {
            int maxIndex = 0;
            int tmp = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < max && arr[i] > tmp) {
                    maxIndex = i;
                    tmp = arr[maxIndex];
                }
            }
            return maxIndex;
        }

        public static int getHungry(int[] arr, int hungry) {
            Arrays.sort(arr);
            int i = arr.length - 1;
            while (i >= 0 && arr[i] > 0) {
                if (hungry >= arr[i]) {
                    hungry -= arr[i];
                    arr[i] = 0;
                }
                i--;
            }
            return hungry;
        }
    }
    两个子串
    链接：https://www.nowcoder.com/questionTerminal/abf0f0d6b4c44676b44e66060286c45a
    来源：牛客网

    给定一个字符串s, 请计算输出含有连续两个s作为子串的最短字符串。 注意两个s可能有重叠部分。例如,"ababa"含有两个"aba".
    输入描述:
    输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 50),s中每个字符都是小写字母.

    输出描述:
    输出一个字符串,即含有连续两个s作为子串的最短字符串。
    示例1
            输入
    abracadabra
            输出
    abracadabracadabra

import java.util.*;

    public class Main {
        private static final int MAX = 50005;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            char[] in = sc.next().toCharArray();
            int n = in.length;
            StringBuilder sb = new StringBuilder();
            for (int i=1; i<n; i++) {
                boolean flag = true;
                for (int j=0; i+j<n; j++) {
                    if (in[i+j] != in[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    sb.append(in, 0, i);
                    sb.append(in);
                    System.out.println(sb.toString());
                    return;
                }
            }
            sb.append(in); sb.append(in);
            System.out.println(sb.toString());
        }
    }

    最短回文长度
    链接：https://www.nowcoder.com/questionTerminal/4f10d29c0a25491ca7d351fceafee15a
    来源：牛客网

    京京和东东是好朋友。东东很喜欢回文。回文是指从前往后读和从后往前读是一样的词语。京京准备给东东一个惊喜,先取定一个字符串s,然后在后面附上0个或者更多个字母形成回文,京京希望这个回文越短越好。请帮助京京计算他能够得到的最短的回文长度。
    输入描述:
    输入包括一个字符串s,字符串s长度length(1 ≤ length ≤ 50)

    输出描述:
    输出一个整数,表示牛牛能够得到的最短的回文长度。
    示例1
            输入
    abab
            输出
5

    链接：https://www.nowcoder.com/questionTerminal/4f10d29c0a25491ca7d351fceafee15a
    来源：牛客网
import java.util.*;

    public class Main {
        private static final int MAX = 50+5;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            char[] arr = sc.next().toCharArray();
            int n = arr.length;
            for (int i=0; i!=n; i++) {
                if (judgePlalindrome(arr, i, n-1)) {
                    System.out.println(n+i);
                    return;
                }
            }
            return;
        }

        private static boolean judgePlalindrome(char[]a, int i, int j) {
            while (i <= j) {
                if (a[i++] != a[j--]) { return false; }
            }
            return true;
        }
    }

    疯狂序列
    链接：https://www.nowcoder.com/questionTerminal/dd8f34e9b83e412bab0b45a845889d34
    来源：牛客网

    东东从京京那里了解到有一个无限长的数字序列: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, ...(数字k在该序列中正好出现k次)。东东想知道这个数字序列的第n项是多少,你能帮帮他么
    输入描述:
    输入包括一个整数n(1 ≤ n ≤ 10^18)

    输出描述:
    输出一个整数,即数字序列的第n项
            示例1
    输入
169
    输出
18

        import java.util.*;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            long num = sc.nextLong();
            long ans = (int)Math.ceil(((-1 + Math.sqrt(1+8*num)) / 2));
            System.out.println(ans);
            return;
        }
    }

import java.util.*;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            long n = sc.nextLong();
            sc.close();

            long k = (long)Math.sqrt(2*n);
            if (n <= k*(k+1)/2) {
                System.out.println(k);
            }
            else {
                System.out.println(k+1);
            }
        }
    }

    求幂
    链接：https://www.nowcoder.com/questionTerminal/ab13f61189784812a018b6925fad78a6
    来源：牛客网

    东东对幂运算很感兴趣,在学习的过程中东东发现了一些有趣的性质: 9^3 = 27^2, 2^10 = 32^2
    东东对这个性质充满了好奇,东东现在给出一个整数n,希望你能帮助他求出满足 a^b = c^d(1 ≤ a,b,c,d ≤ n)的式子有多少个。
    例如当n = 2: 1^1=1^1
            1^1=1^2
            1^2=1^1
            1^2=1^2
            2^1=2^1
            2^2=2^2
    一共有6个满足要求的式子
    输入描述:
    输入包括一个整数n(1 ≤ n ≤ 10^6)

    输出描述:
    输出一个整数,表示满足要求的式子个数。因为答案可能很大,输出对1000000007求模的结果
            示例1
    输入
2
    输出
6

        import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

    public class Main {

        public final static long MOD = 1000000000 + 7;

        public static int max(int a, int b){
            return (a>b) ? a : b;
        }

        public static long gcd(long a,long b){
            return (a % b == 0) ? b : gcd(b,a%b);
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            long n = in.nextInt();
            long ans = (long)1*n*(n*2-1) % MOD;
            Set<Integer> set  = new HashSet<>();
            for (int i = 2; i*i <= n; i++){
                if ( set.contains(i)) continue;
                long tmp = i;
                int cnt = 0;

                while(tmp <= n) {
                    set.add((int)tmp);
                    tmp = tmp * i;
                    cnt++;
                }

                for(int k = 1; k <= cnt; k++) {
                    for(int j = k + 1; j <= cnt; j++) {
                        ans = (ans + n / (j / gcd(k, j) ) * (long)2 ) % MOD;
                    }
                }

            }

            System.out.println(ans);
        }
    }
    括号匹配方案
    链接：https://www.nowcoder.com/questionTerminal/380380e6c6b444888ae145593ccbbbca
    来源：牛客网

    合法的括号匹配序列被定义为:
            1. 空串""是合法的括号序列
2. 如果"X"和"Y"是合法的序列,那么"XY"也是一个合法的括号序列
3. 如果"X"是一个合法的序列,那么"(X)"也是一个合法的括号序列
4. 每个合法的括号序列都可以由上面的规则生成
    例如"", "()", "()()()", "(()())", "(((())))"都是合法的。 东东现在有一个合法的括号序列s,一次移除操作分为两步:
            1. 移除序列s中第一个左括号
2. 移除序列s中任意一个右括号.保证操作之后s还是一个合法的括号序列
            东东现在想知道使用上述的移除操作有多少种方案可以把序列s变为空
    如果两个方案中有一次移除操作移除的是不同的右括号就认为是不同的方案。
    例如: s = "()()()()()",输出1, 因为每次都只能选择被移除的左括号所相邻的右括号.
            s = "(((())))",输出24, 第一次有4种情况, 第二次有3种情况, ... ,依次类推, 4 * 3 * 2 * 1 = 24
    输入描述:
    输入包括一行,一个合法的括号序列s,序列长度length(2 ≤ length ≤ 20).


    输出描述:
    输出一个整数,表示方案数
            示例1
    输入
            (((())))
    输出
24

    链接：https://www.nowcoder.com/questionTerminal/380380e6c6b444888ae145593ccbbbca
    来源：牛客网
 * 思路：遍历字符串，每次把左括号都压入栈，每次遇到右括号，先统计栈中有几个左括号，统计数与上次统计数相乘
 * 接着弹出栈中的一个左括号
 * 直到遍历结束，结果即为方案数
 */
    public class BracketMatch {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();

            Stack<Character> stack = new Stack<>();
            int result = 1;
            char c;

            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (c == '(') {
                    stack.push(c);

                }
                if (c == ')') {
                    int size = stack.size();
                    result *= size;
                    stack.pop();
                }
            }

            System.out.println(result);
        }
    }

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String S = scanner.next();
            int index = 0;
            int result = 1;
            for (int i = 0; i < S.length(); i++) {
                if(S.charAt(i) == '('){
                    index ++;
                }else{
                    result *= index;
                    index--;
                }
            }
            System.out.println(result);
        }
    }


    神奇数
    链接：https://www.nowcoder.com/questionTerminal/56d818ae68134c12b26e81f41ecafb9e
    来源：牛客网

    东东在一本古籍上看到有一种神奇数,如果能够将一个数的数字分成两组,其中一组数字的和等于另一组数字的和,我们就将这个数称为神奇数。例如242就是一个神奇数,我们能够将这个数的数字分成两组,分别是{2,2}以及{4},而且这两组数的和都是4.东东现在需要统计给定区间中有多少个神奇数,即给定区间[l, r],统计这个区间中有多少个神奇数,请你来帮助他。
    输入描述:
    输入包括一行,一行中两个整数l和r(1 ≤ l, r ≤ 10^9, 0 ≤ r - l ≤ 10^6),以空格分割

    输出描述:
    输出一个整数,即区间内的神奇数个数
            示例1
    输入
1 50
    输出
4

    链接：https://www.nowcoder.com/questionTerminal/56d818ae68134c12b26e81f41ecafb9e
    来源：牛客网
import java.util.*;

    public class Main {
        private static Map<Integer, Boolean> map = new HashMap<>();
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int l = sc.nextInt(), r = sc.nextInt();
            int ans = 0;
            for (int i=l; i<=r; i++) {
                if (isMiraculous(i)) { ans++; }
            }
            System.out.println(ans);
        }
        private static boolean isMiraculous(int p) {
            String sp = String.valueOf(p);
            int n = sp.length();
            char[] sa = sp.toCharArray();
            Arrays.sort(sa);
            Integer sorted = Integer.valueOf(new String(sa));
            if (map.containsKey(sorted)) {
                return map.get(sorted);
            }
            int in = sp.chars().map(c -> c -'0').sum();
            if (in % 2 != 0) {
                map.put(sorted, false);
                return false;
            }
            int[] ia = sp.chars().map(c -> c -'0').toArray();
            for (int i=1; i<=(1<<n); i++) {
                int tmp = i; int left = 0 ,right = 0;
                for (int j=0; j<n; j++) {
                    if (((tmp >> j) & 1)== 0) {
                        left+=ia[j];
                    }
                    else {
                        right+=ia[j];
                    }
                }
                if (left == right) {
                    map.put(sorted, true);
                    return true;
                }
            }
            map.put(sorted, false);
            return false;
        }
    }

    数据分页说明
    链接：https://www.nowcoder.com/questionTerminal/b6c448328c4f486d8cce39245889cdfe
    来源：牛客网
    数据分页,对于指定的页数和每页的元素个数，返回该页应该显示的数据。

    输入描述:
    第一行输入数据个数，第二行全部数据，第三行输入页数，第四行输入每页最大数据个数

    输出描述:
    输出该页应该显示的数据，超出范围请输出'超过分页范围'
    示例1
            输入
6
        1 2 3 4 5 6
        1
        2
    输出
3
        4

        import java.util.*;

    public class Main{
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int nums = in.nextInt();
            int arr[] = new int[nums];
            for(int i=0;i!=nums;i++){
                arr[i] = in.nextInt();
            }
            int page = in.nextInt();
            int rows = in.nextInt();
            if(rows > nums || (page * rows) > nums)
                System.out.println("超过分页范围");
            int index = page * rows;
            int count = 0;
            while(count < rows){
                System.out.println(arr[index++]);
                count++;
            }
        }
    }
    第二大的数
    输入n个整数，查找数组中第二大的数

    输入描述:
    第一行n表示n个数，第二行n个空格隔开的数



    输出描述:
    输出第二大的数
            示例1
    输入
5
        1 2 3 4 5
    输出
4

        import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    public class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            input.readLine();
            String[] s = input.readLine().split(" ");
            int brother=Integer.MIN_VALUE,sister=Integer.MIN_VALUE;
            int temp;
            for (String a:s){
                temp=Integer.parseInt(a);
                if (temp>brother){
                    sister=brother;
                    brother=temp;
                }else if (temp>sister){
                    sister=temp;
                }
            }
            input.close();
            System.out.println(sister);


        }
    }
    最小众倍数
    链接：https://www.nowcoder.com/questionTerminal/3e9d7d22b7dd4daab695b795d243315b
    来源：牛客网

    给定5个正整数, 它们的最小的众倍数是指的能够被其中至少三个数整除的最小正整数。 给定5个不同的正整数, 请计算输出它们的最小众倍数。
    输入描述:
    输入包括一行,一行中有五个各不相同的正整数a, b, c, d, e(1 ≤ a, b, c, d, e ≤ 100), 以空格分割

    输出描述:
    输出一个整数,表示它们的最小众倍数
            示例1
    输入
1 2 3 4 5
    输出
4

        import java.util.*;

    public class Main{
        public static void main(String[] args){
            int arr[] = new int[5];
            Scanner in = new Scanner(System.in);
            for(int i=0;i!=5;i++)
                arr[i] = in.nextInt();
            Arrays.sort(arr);

            int target = arr[2];
            for(int j= target;;j++){
                int count = 0;
                for(int i=0;i<5;i++){
                    if(j % arr[i] == 0)
                        count++;
                }
                if(count >= 3){
                    System.out.println(j);
                    break;
                }

            }

        }
    }

    单词缩写
    链接：https://www.nowcoder.com/questionTerminal/45083499b8c5404fb1db44c6ea4f170a
    来源：牛客网

    在英文中,我们会把一些长的名字或者短语进行缩写。例如"looks good to me"缩写为"lgtm",短语中的每个单词的首字母组成缩写。现在给出一个字符串s,字符串s中包括一个或者多个单词,单词之间以空格分割,请输出这个字符串的缩写。
    输入描述:
    输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 50),字符串中只包括小写字母('a'~'z')和空格。

    输出描述:
    输出一个字符串,即缩写的结果。
    示例1
            输入
    looks good to me
    输出
            lgtm

import java.util.*;

    public class Main{
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            String[] newStr = str.split(" ");
            StringBuffer sb = new StringBuffer();
            for(String s : newStr){
                sb.append(s.charAt(0));
            }
            System.out.println(sb.toString());
        }
    }

    工作方案
    链接：https://www.nowcoder.com/questionTerminal/50ae2573431c45db918797836a40406e
    来源：牛客网

    牛牛手中有s份工作需要完成,牛牛准备将工作分给三位员工。考虑到三位员工还有其他工作需要做,牛牛规定他们每人必须要参与的工作数量分别是a,b,c。
    牛牛需要制定详细的工作方案,需要满足每份工作至少有一个人做,同一份工作可以由两个或者三个人共同参与。牛牛一下意识到可能的工作方案很多,牛牛需要你帮他计算一下一共有多少种不同的工作方案(对于两种方案,如果某份工作分配的人或者人数不一样就考虑为不一样的工作方案)。

    对于输入样例,s = 3, a = 3, b = 1, c = 1
    a要参与所有三份工作,b和c各自有三种选择,所以不同的工作方案是3 * 3 * 1= 9
    如果s = 3, a = 1, b = 1, c = 1
    相当于对三个员工做全排列,所以不同的工作方案是3 * 2 * 1 = 6
    输入描述:
    输入包括一行,一行包括4个正整数s,a,b,c(1 ≤ s ≤ 50, 1 ≤ a, b, c ≤ s),分别表示需要完成的工作份数,每个员工必须要参与的工作数量。


    输出描述:
    输出一个正整数,表示不同的方案种数,答案可能很大,输出答案对1000000007取模。
    示例1
            输入
3 3 1 1
    输出
9

        import java.util.Scanner;
    public class Main {
        private static int s;
        private static int a, b, c;
        private static final int MOD = 1000000007;
        public static void main(String[] args){
            int loop = 1;
            Scanner scanner = new Scanner(System.in);
            for (; loop-- > 0;) {
                s = scanner.nextInt();
                a = scanner.nextInt();
                b = scanner.nextInt();
                c = scanner.nextInt();
                solve();
            }
            scanner.close();
        }
        private static void solve() {
            long cnt = 0;
            int left = s - a;
            for (int i = Math.max(Math.max(0, left - c), b - a); i <= Math.min(b, left); i++) {

                cnt += ((C(i, left)* C(b - i, a) % MOD) * C(c - left + i, a + i)) % MOD;
            }
            cnt *= C(a, s);
            System.out.println(cnt % MOD);
        }

        private static long C(int m, int n) {
            double d = 1;
            for (int i = 0, len = m; i < len; i++) {
                d = d * n-- / m--;
            }
            return Math.round(d) % MOD;
        }
    }

    数位重排
    链接：https://www.nowcoder.com/questionTerminal/f970201e9f7e4040ab25a40918e27d15
    来源：牛客网

    牛牛有一个正整数x,牛牛需要把数字x中的数位进行重排得到一个新数(不同于x的数),牛牛想知道这个新数是否可能是原x的倍数。请你来帮他解决这个问题。
    输入描述:
    输入包括t+1行,第一行包括一个整数t(1 ≤ t ≤ 10),
    接下来t行,每行一个整数x(1 ≤ x ≤ 10^6)

    输出描述:
    对于每个x,如果可能重排之后变为自己的倍数输出"Possible", 否则输出"Impossible".
    示例1
            输入
2
        14
        1035
    输出
            Impossible
    Possible

import java.util.*;
    public class Main
    {
        public static boolean isNum(int n1,int n2)
        {
            char[] ch1=String.valueOf(n1).toCharArray();
            char[] ch2=String.valueOf(n2).toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            return String.valueOf(ch1).equals(String.valueOf(ch2));

        }
        public static void main(String[] args)
        {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(sc.hasNextInt())
            {
                int x=sc.nextInt();

                boolean flag=false;
                for(int i=2;i<=9;i++)
                {
                    if(isNum(x,x*i))
                    {
                        flag=true;
                        System.out.println("Possible");
                        break;
                    }
                }
                if(flag==false)
                {
                    System.out.println("Impossible");
                }

            }
        }
    }
    数轴
    链接：https://www.nowcoder.com/questionTerminal/ff0e55dcb75b45b09164c56f87cdf737
    来源：牛客网

    牛牛非常喜欢和朋友们一起玩。
    牛牛有n个朋友当前在一根数轴上,每个朋友当前在整数x[i]坐标位置。
    牛牛向他们发出一个移动的信号,每个朋友就向左或者向右移动s距离(每个朋友的选择是独立的,都可以选择向左或者向右)。
    为了在一起玩耍方便,牛牛希望移动之后最左边的朋友和最右边的朋友距离最近,牛牛想知道最近距离为多少。

    例如牛牛有三个朋友分别所在数轴坐标为-7, 4, 7, s = 5
    那么第一个朋友-7向右移动s,变为-2
    第二个朋友4向左移动s,变为-1
    第三个朋友7向左移动s,变为2。
    现在最左和最右的朋友距离是4,没有比这个更优的方案了。
    输入描述:
    输入包括两行,第一行两个正整数n和s(2 ≤ n ≤ 50, 0 ≤ s ≤ 10^8),表示朋友的个数和移动的距离。
    第二行包括n个正整数x[i](-10^8 ≤ x[i] ≤ 10^8),表示初始时每个朋友所在的坐标位置。


    输出描述:
    输出一个正整数,表示移动之后最左边的朋友和最右边的朋友最小距离为多少。
    示例1
            输入
3 5
        4 -7 7
    输出
4

    链接：https://www.nowcoder.com/questionTerminal/ff0e55dcb75b45b09164c56f87cdf737
    来源：牛客网
import java.util.Arrays;
import java.util.Scanner;

    public class Main {

        private static int n;
        private static int s;
        private static int[] P;

        public static void main(String[] args){

            int loop = 1;

            Scanner scanner = new Scanner(System.in);

            //loop = scanner.nextInt();
            while (loop-- > 0) {

                n = scanner.nextInt();
                s = scanner.nextInt();
                P = new int[n];

                for (int i = 0; i < n; i++) {
                    P[i] = scanner.nextInt();
                }

                solve();
            }

            scanner.close();
        }

        private static void solve() {
            Arrays.sort(P);

            int dist = P[n - 1] - P[0];
            int move = s + s;
            int i = 0;
            int right = P[n - 1];
            int left = P[i] + move < right ? P[i++] + move : right; // 定左边界

            while (P[i] + move <= right) ++i; // 跳过移动后在右边界左边的点
            while (i < n && P[i] < left) { // 当前在左边界左边，移动后在右边界右边
                if(right - P[i] < dist) dist = right - P[i];
                right = P[i++] + move;
            }
            if(right - left < dist) dist = right - left;

            System.out.println(dist);
        }
    }
    骰子游戏
    链接：https://www.nowcoder.com/questionTerminal/0e83797c34e54cca91179fe9ad681bc4
    来源：牛客网

    小易参加了一个骰子游戏,这个游戏需要同时投掷n个骰子,每个骰子都是一个印有数字1~6的均匀正方体。
    小易同时投掷出这n个骰子,如果这n个骰子向上面的数字之和大于等于x,小易就会获得游戏奖励。
    小易想让你帮他算算他获得奖励的概率有多大。
    输入描述:
    输入包括两个正整数n和x(1 ≤ n < 25, 1 ≤ x < 150),分别表示骰子的个数和可以获得奖励的最小数字和。

    输出描述:
    输出小易可以获得奖励的概率。
    如果概率为1,输出1,如果概率为0,输出0,其他以最简分数(x/y)的形式输出。
    示例1
            输入
3 9
    输出
20/27

    链接：https://www.nowcoder.com/questionTerminal/0e83797c34e54cca91179fe9ad681bc4
    来源：牛客网
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    /**
     * https://blog.csdn.net/qq_32767041/article/details/86420299
     *
     * @author wylu
     */
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] strs = br.readLine().split(" ");
            int n = Integer.parseInt(strs[0]), x = Integer.parseInt(strs[1]);

            //骰子最大面值
            int diceMaxVal = 6;
            //count[][n]: 点数和为n出现的次数
            long[][] count = new long[2][diceMaxVal * n + 1];

            int flag = 0;
            for (int i = 1; i <= diceMaxVal; i++) count[flag][i] = 1;

            for (int k = 2; k <= n; k++) {
                //有k个骰子时，最小点数和为k，不存在出现点数和小于k的情况
                for (int i = 1; i < k; i++) count[1 - flag][i] = 0;

                for (int i = k; i <= diceMaxVal * k; i++) {
                    count[1 - flag][i] = 0;
                    for (int j = 1; j < i && j <= diceMaxVal; j++) {
                        count[1 - flag][i] += count[flag][i - j];
                    }
                }

                //在下一轮中，交换两个数组，通过改变flag实现
                flag = 1 - flag;
            }

            long sum = 0, total = (long) Math.pow(diceMaxVal, n);
            for (int i = x; i <= diceMaxVal * n; i++) sum += count[flag][i];

            long  maxDivisor = gcd(total, sum);
            if (sum == 0) System.out.println(0);
            else if (sum == total) System.out.println(1);
            else System.out.println((sum / maxDivisor) + "/" + (total / maxDivisor));
        }

        private static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
    病毒传播
    链接：https://www.nowcoder.com/questionTerminal/3b6060942397444cb0fe5846e230f6d9
    来源：牛客网
    给出一个图G(V,E)，图上有n个点，m条边，所有的边都是无向边。
    最开始，也就是第0天的时候，这n个点中有一个点v感染了病毒，之后的每一天，凡是感染病毒的点都会向它的邻居点传播病毒。经过了t天之后，得到了感染病毒的点集S。要求找出第0天感染病毒的点v。如果v有很多不同的答案，把它们都找出来。

    输入描述:
    第一行两个数n，m，接下来有m行，每行两个数u，v，表示点u，v之间有一条无向边。接下来一行两个数k，t，其中k表示集合S的大小。最后一行k个数，集合S中的元素。输入的图可能有自环和重边，输入保证S中的数互不相同。（1≤n≤103,0≤m≤103,1≤t≤109,1≤u,v,k≤n,S中所有元素在区间[1,n]）

    输出描述:
    输出一行，如果不存在这样的v，输出-1。
    否则输出所有可能的v，按照从小到大的顺序输出，数字之间用空格隔开，不要在行末输出多余的空格。
    示例1
            输入
4 3
        3 2
        1 2
        1 4
        3 2
        4 2 1
    输出
4
    说明
    第0天，第1天，第2天感染病毒的点如图



    思路：
    显然感染源一定不是未感染的点，先求出任意两点间的最短距离，然后双重遍历所有点，如果两点都感染了且它们之间的最短距离>t，那么这两点予以排除，因为如果其中任一点是感染源，它们的最短距离又>t，那不可能在t时间内感染另一点；此外，如果一点感染了而另一点未感染且它们之间的距离<=t，那么也予以排除，因为如果感染的那一点是感染源，它应当能在t时间内通过最短距离感染到另一点。剩下的未被排除的就是可能的感染源。
    一开始觉得n<=1000，弗洛伊德算法（复杂度O(n^3)）应该够，然而还是超时了，换了个思路，既然所有边等权，那用bfs能以O(m*n)求得所有最短距离，终于AC

import java.util.LinkedList;
import java.util.HashSet;

    public class Main/*VirusTransmission2*/ {
        final static int INF = 0x3f3f3f3f;
        public static void main(String[] args) {
            java.util.Scanner sc = new java.util.Scanner(System.in);
            int n = sc.nextInt(), m = sc.nextInt(), i, t, inNum, flg;
            int[][] G = new int[n][n];
            boolean[] infected = new boolean[n], ans = new boolean[n];
            HashSet<Integer>[] adj = new HashSet[n];
            LinkedList<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n];
            for (i = 0; i < n; ++i) {
                adj[i] = new HashSet<>();
                java.util.Arrays.fill(G[i], INF);
                G[i][i] = 0;
            }
            for (i = 0; i < m; ++i) {
                int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
                if (u != v) {
                    adj[u].add(v);
                    adj[v].add(u);
                }
            }
            inNum = sc.nextInt();
            t = sc.nextInt();
            for (i = 0; i < inNum; ++i) {
                int j = sc.nextInt() - 1;
                infected[j] = ans[j] = true;
            }
            for (i = 0; i < n; ++i) {
                java.util.Arrays.fill(visited, false);
                visited[i] = true;
                q.clear();
                q.add(i);
                while (!q.isEmpty()) {
                    int cur = q.pop();
                    for (Integer a : adj[cur]) {
                        if (!visited[a]) {
                            G[i][a] = G[i][cur] + 1;
                            q.add(a);
                            visited[a] = true;
                        }
                    }
                }
            }
            for (i = 0; i < n; ++i) {
                if (infected[i]) {
                    for (int j = 0; j < n; ++j) {
                        if (infected[j] && G[i][j] > t)
                            ans[i] = ans[j] = false;
                        else if (!infected[j] && G[i][j] <= t)
                            ans[i] = false;
                    }
                }
            }
            for (flg = i = 0; i < n; ++i) {
                if (ans[i]) {
                    System.out.printf("%s%d", flg == 0 ? "" : " ", i+1);
                    flg = 1;
                }
            }
            System.out.println(flg == 0 ? "-1" : "");
        }
    }
    字典树排序
    给定整数n和m, 将1到n的这n个整数按字典序排列之后, 求其中的第m个数。
    对于n=11, m=4, 按字典序排列依次为1, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 因此第4个数是2.
            对于n=200, m=25, 按字典序排列依次为1 10 100 101 102 103 104 105 106 107 108 109 11 110 111 112 113 114 115 116 117 118 119 12 120 121 122 123 124 125 126 127 128 129 13 130 131 132 133 134 135 136 137 138 139 14 140 141 142 143 144 145 146 147 148 149 15 150 151 152 153 154 155 156 157 158 159 16 160 161 162 163 164 165 166 167 168 169 17 170 171 172 173 174 175 176 177 178 179 18 180 181 182 183 184 185 186 187 188 189 19 190 191 192 193 194 195 196 197 198 199 2 20 200 21 22 23 24 25 26 27 28 29 3 30 31 32 33 34 35 36 37 38 39 4 40 41 42 43 44 45 46 47 48 49 5 50 51 52 53 54 55 56 57 58 59 6 60 61 62 63 64 65 66 67 68 69 7 70 71 72 73 74 75 76 77 78 79 8 80 81 82 83 84 85 86 87 88 89 9 90 91 92 93 94 95 96 97 98 99 因此第25个数是120…

    思路：既然是字典序，那么很自然，我们可以考虑使用字典树来实现，但是，这里并不需要真的生成这个字典树，而只需要计算对应分支的节点数就行了。计算分支节点数，那么很简单，节点数就是上级节点*10，总的节点数= 1 + （1 * 10） + （1 * 10 * 10） + （1 * 10  * 10 * 10） +……，这里需要注意最后的边界，n以内的节点数，那么，最后相加的时候必须要把n+1 ~ (1 * 10 * 10 *……)这几个数去掉。
    既然知道了如何计算字典树分支的节点数，要想知道第m个数是什么，那么也就是找第m个节点，首先从1开始，如果1分支的节点数>m，那么第m个数肯定是以1开头，进一步搜索其子节点，搜索子节点时不用再搜索1了，所以是搜索1分支的第m-1个节点。如果1分支的节点数<m， 那么所查找的数肯定不是1开头，那么开始搜索2分支，在2分支中，所要找的数应该是第（m-（1分支节点数））个数。重复这个过程，要么搜索子节点，要么搜索兄弟节点，知道最终m==0，也就是当前节点就是所要搜索的节点。为了便于理解，简单修改了下java代码：

            import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                long n = sc.nextLong();
                long m = sc.nextLong();
                System.out.println(solve(n, m));
            }
        }

        private static long solve(long n, long m) {
            long ans = 1;
            while (m != 0) {
                long cnt = getCntOfPre(ans, n);
                if(cnt >= m) {
                    m --;
                    if(m == 0)
                        break;
                    ans *= 10;
                } else {
                    m -= cnt;
                    ans ++;
                }
            }
            return ans;
        }

        private static long getCntOfPre(long pre, long n) {
            long cnt = 1;
            long p = 10;
            for (; pre * p <= n; p *= 10) {
                if (pre * p - 1 + p < n)
                    cnt += p;
                else
                    cnt += n - pre * p + 1;

//          cnt += Math.min(n, pre * p - 1 + p) - pre * p + 1;
            }
            return cnt;
        }
    }

    帮忙出题
    头条的2017校招开始了！为了这次校招，我们组织了一个规模宏大的出题团队，每个出题人都出了一些有趣的题目，而我们现在想把这些题目组合成若干场考试出来，在选题之前，我们对题目进行了盲审，并定出了每道题的难度系统。一场考试包含3道开放性题目，假设他们的难度从小到大分别为a,b,c，我们希望这3道题能满足下列条件：
    a<=b<=c
    b-a<=10
    c-b<=10
    所有出题人一共出了n道开放性题目。现在我们想把这n道题分布到若干场考试中（1场或多场，每道题都必须使用且只能用一次），然而由于上述条件的限制，可能有一些考试没法凑够3道题，因此出题人就需要多出一些适当难度的题目来让每场考试都达到要求，然而我们出题已经出得很累了，你能计算出我们最少还需要再出几道题吗？
            //简单题目，一次搞定
            import java.util.Arrays;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }
                Arrays.sort(a);
                int t = 1;
                int cnt = 0;
                for (int i = 1; i < n; i++) {
                    if(t < 3) {
                        if(a[i] - a[i-1] <= 10)
                            t++;
                        else if(t == 1 && a[i] - a[i-1] <= 20) {
                            cnt ++;
                            t = 3;
                        } else {
                            cnt += 3 - t;
                            t = 1;
                        }
                    } else
                        t = 1;
                }
                cnt += 3 - t;
                System.out.println(cnt);
            }
        }
    }

