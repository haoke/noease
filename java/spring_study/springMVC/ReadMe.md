[[TOC]]
*框架:

* 普通配置文件开发:
    1. 配置前端控制器
        web.xml中 配置 DispatcherServlet
        ```xml
        <servlet>
          <servlet-name>dispatcher</servlet-name>
          <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
          <init-param>
              <param-name>contextConfigLocation</param-name>
              <param-value>classpath:applicationContext.xml</param-value>
          </init-param>
          <load-on-startup>1</load-on-startup>
        </servlet>
        <servlet-mapping>
          <servlet-name>dispatcher</servlet-name>
          <url-pattern>*.do</url-pattern>
        </servlet-mapping>
        ```
    2. 加载springmvc配置文件
    如上, 添加在配置项DispatcherServlet内
    ```xml
      <init-param>
              <param-name>contextConfigLocation</param-name>
              <param-value>classpath:applicationContext.xml</param-value>
      </init-param>
    ```
    3. springmvc文件 结构:

        - handler
        - 处理器控制器
        - 处理器适配器
        - 视图解析器

* 注解开发:
  - 常用的注解的使用
    - RequestMapping 属性
      - value path
      - method
      - params
      - headers
  - 参数绑定
    - 机制
      - 表单提交的数据都是k=v格式的
      - SpringMvc的参数绑定过程是把表单的提交的请求参数,作为控制器中的方法的参数进行绑定
      - 要求:提交表单的请求参数的name和Handler方法中参数的名称必须是一样的.
    - 支持的数据类型
      - 基本数据类型和字符串
      - 实体类型(JavaBean)
      - 集合数据类型(List,Map等)
  - 自定义参数绑定
* springmvc 与 struts的区别
* 高级:
  - 使用springmvc上传文件
  - 复杂类型的绑定--集合
  - Validation校验器
  - 异常处理器使用
  - Restful支持
  - 拦截器
