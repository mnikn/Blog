### Servlet概述
Servlet负责处理网页传送过来的信息，实现的方法有doGet和doPost，一般通过继承HttpServlet来使用。

### Servlet的配置
Servlet有两种配置方式，通过web.xml来配置和通过注解配置，以下是示例。

#### xml:
```xml
<servlet>
	<servlet-name>helloServlet</servlet-name> //通过name来匹配servlet-mapping
		<servlet-class>HelloServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>helloServlet</servlet-name>
    <url-pattern>/greeting</url-pattern>
</servlet-mapping>
```

#### 注解:
```java
@WebServlet(
    name = "helloServlet",
    urlPattern = {"/greetings"};
)
class Servlet extends HttpServlet{
	//...略
}
```
这两种方法各有特点，注解的方法一个Servlet只能对应一个实例，而xml的方法可对应多个实例。

### Servlet处理文件
需要在注解处增加@MutilPart。
```java
@MultipartConfig(
        fileSizeThreshold = 5_242_880, //5MB
        maxFileSize = 20_971_520L, //20MB
        maxRequestSize = 41_943_040L //40MB
)
```
fileSizeTheshold是上传文件的大小，maxFileSize是上传文件的最大值，maxRequestSize是上传请求的最大值。
