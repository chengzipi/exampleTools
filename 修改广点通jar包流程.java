Ŀ�꣺��  com.qq.e.**   �޸ĳ�  ��>  com.junling.adv.**
		A.jar                                  B.jar

1���ҵ�Ҫ�޸ĵ�A.jar��������  jarjar.jar ����ֱ���޸�A.jar�İ���
����������
�����ѹ��ͨ�Ĺ������о��� A.jar���ǹ��ͨ�Ĺ��
����������d�̸�Ŀ¼���� ���� jarjar.jar���߰���A.jar�ļ���һ��
ruleadv.txt �ļ���ruleadv.txt����Ϊ��rule com.qq.e.** com.junling.adv.@1����ͼ�ߣ�
2��cd��d�̸�Ŀ¼��ִ��cmd���java -jar jarjar.jar process ruleadv.txt A.jar Ashengchengde.jar
�õ���Ashengchengde.jar�İ������޸İ�������ļ���

3���������룬��A.jar���л���jar����classes.dex�ļ�ʱ��
�޸�A.jar����gdtadv2.jar�е�class.dex�ļ�
ֱ�ӽ�ѹ�� Ashengchengde.jar�����ҵ�assets\gdt_plugin ����һ��gdtadv2.jar,��������ҲҪ�޸����jar,��ͼһ��  ʹ�÷����빤�ߣ�Android��������.exe��ͼ����
��ѹ��gdtadv2.jar�ļ����������沢û�а��ṹ,ֻ��һ��classes.dex�ļ���ͼ����������Ҫ�޸����classes.dex�ļ���jar���ṹ��
�򿪹���Android��������.exe��ѡ�� dexתjar, ���� classes_dex2jar.jar ����Ȼ�������ظ���һ������ �޸����jar�������ƣ�
�� classes_dex2jar.jar �ŵ�D�̸�Ŀ¼��ִ�����java -jar jarjar.jar process ruleadv.txt classes_dex2jar.jar classes_dex_new.jar,
���ɺ�� classes_dex_new.jar ���Żص�classes.dex���ڵ�Ŀ¼���棨ͼ�ģ���
�ٴ����� Android��������.exe���� ��classes_dex_new.jarת��classes_dex_new.dex,
ɾ��֮ǰ��classes.dex�ļ���classes_dex_new.jar�ļ���classes_dex_new.dex�ĳ��滻
classes.dex�ļ�������ԭ���Ľṹ���䡣
�����gdt_pluginĿ¼�����jar���ָ�֮ǰ��gdtadv2.jar������ȡgdtadv2�ļ�������� MANIFEST.MF�ļ���ͼ�壩��cd��gdt_plugin�ļ�������Ҳ����gdtadv2.jar�����ڵ�Ŀ¼���档
ִ�����jar cvfm gdtadv2.jar MANIFEST.MF  .//     (.//��ʾ��ǰĿ¼) 
���ɵ�gdtadv2.jar���������޸����֮��İ��ˣ�Ȼ��ɾ�����滻֮ǰgdtadv2.jar�����ѹ���������ļ��У���֮ǰ��gdtadv2.jar�滻��������Ŀ¼�ṹ���䡣
���������ļ������jar���ҵ� AshengchengdeĿ¼�����META-INF�µ�MANIFEST.MF
���Ƶ�Ashengchengde��Ŀ¼�£�ͼ����
cd��AshengchengdeĿ¼���棬ִ�����jar cvfm gdtend.jar MANIFEST.MF  .// 
�ɹ��õ���  gdtend.jar��������Ҫ�������޸ĺ��˵Ĺ�����com.junling.adv���������ŵ���Ŀ��ȥ���ð�

�������̣�����ʹ�����ļ��ṹ���䣬���� MANIFEST.MF�ļ��������Ӱ�졣

������
 jarjar.jar ���ٶ������������޸�jar���ģ�  ��  Android��������.exe ���ٶ�������
