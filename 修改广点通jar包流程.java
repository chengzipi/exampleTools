目标：把  com.qq.e.**   修改成  —>  com.junling.adv.**
		A.jar                                  B.jar

1、找到要修改的A.jar包，利用  jarjar.jar 工具直接修改A.jar的包名
操作方法：
以下已广点通的广告包进行举例 A.jar就是广点通的广告
举例，如在d盘根目录下面 放入 jarjar.jar工具包、A.jar文件和一个
ruleadv.txt 文件（ruleadv.txt内容为：rule com.qq.e.** com.junling.adv.@1）（图七）
2、cd到d盘根目录，执行cmd命令：java -jar jarjar.jar process ruleadv.txt A.jar Ashengchengde.jar
得到的Ashengchengde.jar的包就是修改包名后的文件。

3、继续深入，当A.jar包中还有jar包和classes.dex文件时，
修改A.jar包中gdtadv2.jar中的class.dex文件
直接解压缩 Ashengchengde.jar包，找到assets\gdt_plugin 下有一个gdtadv2.jar,现在我们也要修改这个jar,（图一）  使用反编译工具：Android逆向助手.exe（图二）
解压缩gdtadv2.jar文件，发型里面并没有包结构,只有一个classes.dex文件（图三），现在要修改这个classes.dex文件的jar包结构，
打开工具Android逆向助手.exe，选择 dex转jar, 生成 classes_dex2jar.jar 包，然后我们重复上一个步骤 修改这个jar包的名称，
把 classes_dex2jar.jar 放到D盘根目录，执行命令：java -jar jarjar.jar process ruleadv.txt classes_dex2jar.jar classes_dex_new.jar,
生成后的 classes_dex_new.jar 包放回到classes.dex所在的目录下面（图四），
再次利用 Android逆向助手.exe工具 把classes_dex_new.jar转成classes_dex_new.dex,
删除之前的classes.dex文件和classes_dex_new.jar文件把classes_dex_new.dex改成替换
classes.dex文件，保持原来的结构不变。
把这个gdt_plugin目录打包成jar（恢复之前的gdtadv2.jar），提取gdtadv2文件夹里面的 MANIFEST.MF文件（图五），cd到gdt_plugin文件夹下面也就是gdtadv2.jar的所在的目录下面。
执行命令：jar cvfm gdtadv2.jar MANIFEST.MF  .//     (.//表示当前目录) 
生成的gdtadv2.jar就是我们修改完成之后的包了，然后删除并替换之前gdtadv2.jar这个解压缩出来的文件夹（把之前的gdtadv2.jar替换掉）保存目录结构不变。
最后把整个文件打包成jar，找到 Ashengchengde目录下面的META-INF下的MANIFEST.MF
复制到Ashengchengde根目录下（图六）
cd到Ashengchengde目录下面，执行命令：jar cvfm gdtend.jar MANIFEST.MF  .// 
成功得到的  gdtend.jar就是我们要的最终修改好了的广告包（com.junling.adv），把它放到项目中去引用吧

整个过程，解包和打包的文件结构不变，除了 MANIFEST.MF文件，这个不影响。

附件：
 jarjar.jar （百度搜索，用于修改jar包的）  、  Android逆向助手.exe （百度搜索）
