# Software_Test_Homework
一个测试框架

## 前期准备工作
下载zip到本地或者git clone到本地之后用gradle构建本工程

## 如何运行
1. 保证8080端口未被占用（或手工更改代码中的端口）
2. 选定Application.java -> Run as Java Application
3. 在本地浏览器中访问http://localhost:8080

## 如何添加新的测试函数
1. 在testunits包下创建待测函数
2. 在test包下创建tester,继承TestFacilty类,实现与待测函数匹配的eval函数
3. 在test包下的TestManger.java中注册tester即可
