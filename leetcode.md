#                              leetcode

[TOC]



## 一、字符串

### 1、[字符串相加](https://leetcode-cn.com/problems/add-strings/)

给定两个字符串形式的非负整数 `num1` 和`num2` ，计算它们的和。

**注意：**

1. `num1` 和`num2` 的长度都小于 5100.
2. `num1` 和`num2` 都只包含数字 `0-9`.
3. `num1` 和`num2` 都不包含任何前导零。
4. **你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。**

思路：两字符串从后向前相加，结果%10, carry /= 10。最后reverse()

```java
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i>=0) carry += num1.charAt(i--)-'0';
            if(j>=0) carry += num2.charAt(j--)-'0';
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
```

字符串加法、链表加法以及二进制加法之类的都可以这么写

### 2、[重复的子字符串](https://leetcode-cn.com/problems/repeated-substring-pattern/)

给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

**示例 1:**

```
输入: "abab"

输出: True

解释: 可由子字符串 "ab" 重复两次构成。
```

**示例 2:**

```
输入: "aba"

输出: False
```

**示例 3:**

```
输入: "abcabcabcabc"

输出: True

解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
```

思路：

1. 利用StringAPI，如果全是重复的子字符串，那么使用split函数拆分后的数组长度将会是0

2. 找字符串长度的因子，挨个去拆分出子串，去测试满足split函数拆分的数组长度是否为0

3. split函数使用的规则是正则匹配，效率略低

   方法一：split切割法

```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null) {
            return false;
        }
        
        // 长度为1，不能拆分出子串，所以直接返回false
        if (s.length() == 1) {
            return false;
        }
        
        // 长度大于1，可以拆分出子串，判断字符串中是否所有字符都相同，如"aaaaaa","zzz"，一定满足按子串长度为1的拆分，所以直接返回true
        if (s.split(String.valueOf(s.charAt(0))).length == 0) {
            return true;
        }
        
        // 找长度最长的因子，拆分出子串
        for (int i = s.length() - 1;i >= 2;i--) {
            if (s.length() % i == 0) {
                String pattern = s.substring(0,i);
                String arr[] = s.split(pattern);
                if (arr.length == 0) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
```

方法二：

```routeros
public boolean repeatedSubstringPattern(String s) {
       boolean res=false;
       for(int i=1;i<=s.length()/2;i++) {
           if(s.length()%i==0) {
	       String temp=s.substring(0,i);
	       res=true;
	       for(int m=i;m<=s.length()-i;m=m+i) {
	           if(!temp.equals(s.substring(m,m+i))) {
		       res=false;
			break;
		   }
	       }
		if(res) {
		    break;
		}	
	   }
        }
        return res;
    }
```

### 3、[字符串中的第一个唯一字符](https://leetcode-cn.com/problems/first-unique-character-in-a-string/)

给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

**案例:**

```java
s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
```

思路：hash统计每个字符出现的次数，找到hash数组中第一个等于1的元素，返回其索引即可

```java
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            freq[s.charAt(i) - 'a'] += 1;
        }
        
        for (int i = 0; i < len; i++)
            if(freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
```

