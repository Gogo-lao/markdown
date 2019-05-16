package wangyi;
public class Main1 {
    public String ReverseSentence(String str) {
        if(str == null || str == "")
            return str;
        char [] strArray = str.toCharArray();
        reverse(strArray,0,strArray.length-1);//反转整个字符串
        int begin = 0;
        for(int i=0;i<strArray.length;i++)
        {
            if(strArray[i] == ' ')
            {
                reverse(strArray,begin,i-1);
                begin = i + 1;//每当遇到空格，就是一个单词，然后反转这个单词
            }
        }
        if(begin < strArray.length-1)
        {//反转最后一个单词
            reverse(strArray,begin,strArray.length-1);
        }
        return String.valueOf(strArray);
    }
    private void reverse(char [] str,int begin,int end)
    {//反转字符数组
        while(begin < end)
        {
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String args[]){
        String str = "I'm a student's mom.";
        System.out.println(new Main1().ReverseSentence(str));;
    }
}
