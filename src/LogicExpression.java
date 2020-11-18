import java.util.ArrayDeque;
import java.util.Deque;

/// 将中缀表达式翻译成后缀表达式
/// 输入中缀表达式： A+B*(C+D)-E/F
/// 翻译成后缀表达式：ABCD+*+EF/-
/// 中缀表达式翻译成后缀表达式的方法如下：
/// （1）从左向右依次取得数据ch
/// （2）如果ch是操作数，直接输出
/// （3）如果ch是运算符（含左右括号），则：
///                a：如果ch = '('，放入堆栈
///                b：如果ch = ')'，依次输出堆栈中的运算符，直到遇到'('为止
///                c：如果ch不是')'或者'('，那么就和堆栈顶点位置的运算符top做优先级比较
///                        1：如果ch优先级比top高，那么将ch放入堆栈
///                        2：如果ch优先级低于或者等于top，那么输出top，然后将ch放入堆栈
///    （4）如果表达式已经读取完成，而堆栈中还有运算符时，依次由顶端输出
    /*        Pseudocode()
            {
                n = passing(s, op); //s是表达式，op是数据数组，n是数据的数量

                for(int i=0; i<n; i++)
                {
                    ch = op(i);
                    if(ch是操作数)
                        output(ch);
                    else
                    {
                        if(ch == '(')
                            push(ch);
                        else if( ch == ')')
                            pop()而且输出，直到遇到'('为止;
                        else
                        {
                            if(运算符ch较stack[top]优先)
                                 push(ch);
                            else
                            {
                                pop()且输出;
                                push(ch);
                            }
                        }
                    }
                }
    */
public class LogicExpression {
    public static void main(String[] args) {
        String s= "( T && T ) || ( T || T )";
        String newExpression = changeFormat(s);//将中缀表达式解析成后缀表达式
        System.out.println(calculate(newExpression));
    }
    /**
     * 将中缀表达式解析成后缀表达式
     * @param input
     */
    public static String changeFormat(String input){
        Deque<Character> stack = new ArrayDeque<Character>();
        String[] strs = input.split(" ");
        char tmp =' ';
        char[] newExp = new char[strs.length];
        int len = strs.length;
        int j=0;
        for(int i=0;i<len;i++){
            tmp = strs[i].charAt(0);
            if(tmp=='T' || tmp=='F'){//如果是操作数，直接放入newExp中
                newExp[j++] = tmp;
            }else{
                if(tmp=='('){//如果是'('，入栈
                    stack.push(tmp);
                }else if(tmp ==')'){//如果是')'
                    while(!stack.isEmpty()){//不停地弹出栈中的内容，直到遇到'(
                        char c = stack.pop();
                        if(c=='('){
                            break;
                        }else{
                            newExp[j++] = c;//将栈中弹出的内容放入newExp中
                        }
                    }
                }else{//不是T F也不是（），是其他操作数
                    if(!stack.isEmpty()){
                        while(true){
                            char c = stack.peek();
                            if(priority(c)<priority(tmp)){//如果栈顶元素的优先级小于读取到的操作符
                                stack.push(tmp);//将读取到的操作符入栈
                                break;
                            }else{//如果栈顶元素的优先级比较高或者两者相等时
                                stack.pop();
                                newExp[j++] = c; //将栈顶元素弹出，放入newExp中
                                if(stack.isEmpty()){
                                    stack.push(tmp); //将读取到的操作符压入堆栈中
                                    break;
                                }
                            }
                        }
                    }else{//栈为空就直接放入
                        stack.push(tmp);
                    }
                }

            }        }
        while(!stack.isEmpty()){
            //将堆中剩下的操作符写入
            newExp[j++] = stack.pop();
        }
        return newExp.toString();

    }
    /**
     * 判断运算优先级
     * @param c
     * @return 返回数字越大优先级越高
     */
    private static int priority(char c){
        int p;
        switch (c) {
            case '!':
                p=3;
                break;
            case '&':
                p=2;
                break;
            case '|':
                p=1;
                break;
            default:
                p=0;
                break;
        }
        return p;
    }

    /**
     * 由后缀表达式计算值
     * @param input
     * @return
     */
    private static boolean calculate(String input){
        int i;
        char no1, no2, ret;
        char tmp;
        char[] arr = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<Character>();
        for (i = 0; i < arr.length; i++) {
            tmp = arr[i];
            //如果是操作数，直接入栈
            if (tmp=='T' || tmp=='F') {
                stack.push(tmp);
            } else if(tmp=='!'){
                no1 = stack.pop();
                if(no1=='F'){
                    stack.push('T');
                }else{
                    stack.push('F');
                }
            }else if(tmp=='|')//如果是| &，就弹出两个数字来进行运算
            {
                no1 = stack.pop();
                no2 = stack.pop();
                if(no1=='F' && no2=='F'){
                    stack.push('F');
                }else{
                    stack.push('T');
                }

            }else if(tmp=='&'){
                no1 = stack.pop();
                no2 = stack.pop();
                if(no1=='T' && no2=='T'){
                    stack.push('T');
                }else{
                    stack.push('F');
                }
            }
        }
        //弹出最后的运算结果
        char result = stack.pop();
        return result=='T'? true:false;
    }

}
