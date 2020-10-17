# Scanner vs BufferedReader

[牛客网IO练习场]([https://ac.nowcoder.com/acm/contest/5650?from=hr_test#question](https://ac.nowcoder.com/acm/contest/5650?from=hr_test#question))

[可使用此链接自测输入输出]([https://ac.nowcoder.com/acm/contest/5650/K](https://ac.nowcoder.com/acm/contest/5650/K))

**BufferedReader** 快很多！推荐

```java
// Using Buffer Class
import java.io.BufferedReader;
class BufferDemo
{
	public static void main(String args[]) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader([System.in](http://system.in/)));
			while (true){
          System.out.println(bf.readLine()); //循环输入
      }
	}
}
```

**Scanner**

```java
import java.util.Scanner;
class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] str = new String[num];
        for (int i = 0; i < num; i++) {
            str[i] = sc.nextLine();
        }
        sc.close();
    }
}
```

用 Scanner 是为了循环输入的功能，也就是 hasNext() 的功能，可以用死循环来代替，所以，还是推荐使用 BufferReader

 *Scanner 在 nextXXX()后使用 nextLine() 会遇到问*

`nextInt()`不会读取换行符，导致光标停在换行符前，下一次读取时会误把换行符当作新的字符

nextXXX() 包括 nextInt(), nextFloat(), nextByte(), nextShort(), nextDouble(), nextLong(), next().

```java
Scanner sc = new Scanner(System.in);
int a = sc.nextInt();
scn.nextLine();
```

可以用下面方式代替 

```java
String b = sc.next();
```

其他区别：

- BufferedReader is synchronous while Scanner is not. BufferedReader should be used if we are working with multiple threads.
- BufferedReader has significantly larger buffer memory than Scanner.
- The Scanner has a little buffer (1KB char buffer) as opposed to the BufferedReader (8KB byte buffer), but it’s more than enough.
- BufferedReader is a bit faster as compared to scanner because scanner does parsing of input data and BufferedReader simply reads sequence of characters.

## 针对牛客网的情况使用模版：

1. 要引用package, 一般通过`import java.util.*`语句全部引入即可
2. 要写一个以Main命名的类, 在main入口函数中执行逻辑, 通过`System.out.println`输出

    ```java
    public class Main {  
        public static void main(String[] args) {
    		}
    }
    ```

3. scanner读取输入时，默认的分隔符是空格和回车，如果需要读入空格，可手动指定分隔符，加一行代码 : `sc.useDelimiter("\n");`
4. 将数组或字符串以指定分隔输出可以用`String.join()`方法

    ```java
    String message = String.join("-", "This", "is", "a", "String");
    // message returned is: "This-is-a-String"
    ```