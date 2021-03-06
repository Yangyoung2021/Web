package cn.itcast.el;


/**
 * ## EL表达式
 * 	1. 概念：Expression Language 表达式语言
 * 	2. 作用：替换和简化jsp页面中java代码的编写
 * 	3. 语法：${表达式}
 * 	4. 注意：
 * 		* jsp默认支持el表达式的。如果要忽略el表达式
 * 			1. 设置jsp中page指令中：isELIgnored="true" 忽略当前jsp页面中所有的el表达式
 * 			2. \${表达式} ：忽略当前这个el表达式
 * 	5. 使用：
 * 		1. 运算：
 * 			* 运算符：
 * 				1. 算数运算符： + - * /(div) %(mod)
 * 				2. 比较运算符： > < >= <= == !=
 * 				3. 逻辑运算符： &&(and) ||(or) !(not)
 * 				4. 空运算符： empty
 * 					* 功能：用于判断字符串、集合、数组对象是否为null或者长度是否为0
 * 					* ${empty list}:判断字符串、集合、数组对象是否为null或者长度为0
 * 					* ${not empty str}:表示判断字符串、集合、数组对象是否不为null 并且 长度>0
 */
public class Profile {
}
