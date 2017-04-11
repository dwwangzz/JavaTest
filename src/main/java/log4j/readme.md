### Rules reminder:
# TRACE < DEBUG < INFO < WARN < ERROR < FATAL

### 设置
`log4j.rootLogger = debug,stdout,D,E`

### 输出信息到控制抬
```
log4j.appender.stdout = org.apache.log4j.ConsoleAppender
#log4j.appender.stdout.Target = System.out
log4j.appender.stdout.layout = org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern = [%-5p] %d{yyyy-MM-dd HH:mm:ss,SSS} method:%l%n%m%n
#log4j.appender.stdout.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n
#log4j.appender.stdout.layout.ConversionPattern = %d{ABSOLUTE} %5p - %m%n
```
### 输出DEBUG 级别以上的日志到=D:/opt/logs/debug.log
```
#log4j.appender.D = org.apache.log4j.DailyRollingFileAppender
#log4j.appender.D.File = D:/opt/logs/debug.log
#log4j.appender.D.Append = true
#log4j.appender.D.Threshold = DEBUG
#log4j.appender.D.layout = org.apache.log4j.PatternLayout
#log4j.appender.D.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n
```

### Log4j提供的appender有以下几种：
> org.apache.log4j.ConsoleAppender（控制台）  
> org.apache.log4j.FileAppender（文件）  
> org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件）  
> org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件）  
> org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）  

以ConsoleAppender为例，如： 
`log4j.appender.stdout=org.apache.log4j.ConsoleAppender`

### 输出ERROR 级别以上的日志到=/opt/logs/error.log ###
```
log4j.appender.E = org.apache.log4j.DailyRollingFileAppender
log4j.appender.E.File =/opt/logs/error.log
log4j.appender.E.Append = true
log4j.appender.E.Threshold = ERROR
log4j.appender.E.layout = org.apache.log4j.PatternLayout
log4j.appender.E.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n
```

### 设置package输出级别
可以设置不同package的日志输出级别，语法为：
log4j.logger.packageName=level
其中，packageName为实际的包名，level为日志级别，例如：

复制代码代码如下:

```
log4j.logger.org.springframework=info
log4j.logger.org.apache.catalina=info
log4j.logger.org.apache.commons.digester.Digester=info
log4j.logger.org.apache.catalina.startup.TldConfig=info
log4j.logger.chb.test=debug
```

## 使用spring架构
Spring真是不错，替我们做了很多事情，如果系统使用了spring框架，则要集成log4j就很简单了，主要分为3个步骤，如下：

### 定义log4j配置文件

复制代码代码如下:

```
log4j.rootCategory=INFO, stdout
log4j.rootLogger=info, stdout
```

### stdout
```
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p - %m%n
```

### log to file
```
log4j.logger.org.springframework=info
log4j.logger.org.apache.catalina=info
log4j.logger.org.apache.commons.digester.Digester=info
log4j.logger.org.apache.catalina.startup.TldConfig=info
log4j.logger.chb.test=debug
```

