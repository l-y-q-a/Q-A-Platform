# 在线问答平台

一个基于 Spring Boot 的简单在线问答平台，支持用户登录验证、讨论帖发布、回复等功能。

## 🚀 功能特性

### 用户功能
- ✅ 用户登录/退出系统
- ✅ 图形验证码验证
- ✅ 会话管理
- ✅ 测试账号提供（admin/123456, user/123456）

### 讨论功能
- ✅ 创建新讨论帖（需登录）
- ✅ 查看讨论列表
- ✅ 查看讨论详情
- ✅ 发表回复（支持匿名回复）
- ✅ 实时时间戳显示

### 技术特性
- ✅ Spring Boot 后端框架
- ✅ Thymeleaf 模板引擎
- ✅ 内存数据存储（非持久化）
- ✅ 响应式网页设计
- ✅ 会话级验证码

## 📁 项目结构

```
chatplatform/
├── src/main/java/com/example/chatplatform/
│   ├── controller/          # 控制器层
│   │   ├── CaptchaController.java   # 验证码生成
│   │   ├── LoginController.java     # 登录相关
│   │   ├── ReplyController.java     # 回复相关
│   │   └── ThreadController.java    # 讨论相关
│   ├── service/             # 服务层
│   │   ├── ThreadService.java
│   │   └── UserService.java
│   ├── dao/                 # 数据访问层
│   │   └── DataStore.java   # 内存数据存储
│   ├── model/              # 数据模型
│   │   ├── User.java
│   │   ├── Thread.java
│   │   └── Reply.java
│   └── config/             # 配置类
│       └── WebConfig.java
├── src/main/resources/
│   ├── static/             # 静态资源
│   │   └── css/
│   │       └── style.css   # 样式文件
│   ├── templates/          # 模板文件
│   │   ├── login.html      # 登录页面
│   │   ├── thread-list.html # 讨论列表
│   │   ├── thread-detail.html # 讨论详情
│   │   └── create-thread.html # 创建讨论
│   └── application.properties # 配置文件
└── ChatplatformApplication.java # 启动类
```

## 🔧 技术栈

- **后端框架**: Spring Boot 3.x
- **前端模板**: Thymeleaf
- **服务器**: 内嵌 Tomcat
- **构建工具**: Maven
- **Java版本**: 17+
- **CSS框架**: 自定义CSS

## 🛠️ 快速开始

### 环境要求
- JDK 17 或更高版本
- Maven 3.6+
- 现代浏览器（Chrome, Firefox, Edge等）

## 📝 使用指南

### 1. 用户登录
- 访问 `http://localhost:8081/login`
- 使用测试账号登录：
  - 用户名：admin，密码：123456
  - 用户名：user，密码：123456
- 验证码不区分大小写

### 2. 创建讨论
1. 登录后点击"创建新讨论"
2. 填写标题和详细内容
3. 点击"发布讨论"

### 3. 查看和回复
1. 在讨论列表点击标题查看详情
2. 在详情页底部填写回复内容
3. 昵称为可选，留空则显示"匿名用户"

## 🔒 安全特性

- 验证码机制防止暴力破解
- 会话管理确保用户状态
- 登录后才能创建讨论帖
- 回复支持匿名，但创建讨论需要身份

## ⚙️ 配置说明

### 应用配置 (`application.properties`)
```properties
# 服务器端口
server.port=8081

# 视图配置
spring.mvc.view.prefix=/templates/
spring.mvc.view.suffix=.html

# 静态资源
spring.web.resources.static-locations=classpath:/static/

# Thymeleaf 开发模式
spring.thymeleaf.cache=false
```

### 静态资源配置 (`WebConfig.java`)
- 静态资源路径：`/static/**`
- 映射到 `classpath:/static/`

## 📱 页面说明

### 登录页面 (`/login`)
- 用户登录入口
- 图形验证码
- 错误信息提示

### 讨论列表 (`/threads`)
- 显示所有讨论帖
- 创建讨论按钮（需登录）
- 用户状态显示

### 讨论详情 (`/threads/{id}`)
- 显示讨论内容和所有回复
- 回复表单
- 实时时间显示

### 创建讨论 (`/threads/new`)
- 登录用户专用
- 简单表单提交

## 🗄️ 数据模型

### User（用户）
```java
username: String
password: String
```

### Thread（讨论帖）
```java
id: int
title: String
content: String
author: String
createTime: Date
```

### Reply（回复）
```java
threadId: int
content: String
author: String
createTime: Date
```

## 🧪 测试账号

系统预置两个测试账号：
1. **admin** / 123456
2. **user** / 123456

所有密码均为：123456

## 🔄 验证码机制

- 验证码为4位字符（排除易混淆字符）
- 支持点击刷新
- 会话存储，验证后失效
- 不区分大小写

## 📱 响应式设计

- 支持移动端访问
- 自适应布局
- 触摸友好

## ⚠️ 注意事项

1. **数据持久性**：当前使用内存存储，重启后数据会丢失
2. **安全性**：密码为明文存储，仅用于演示
3. **并发**：未做并发控制，不适合生产环境
4. **性能**：未做分页，数据量大时可能性能下降

## 🔄 刷新验证码

- 点击验证码图片可刷新
- 验证码失效后需要重新获取
- 支持随机生成
