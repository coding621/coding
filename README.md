# Coding

基于 **Spring Cloud + Spring Cloud Alibaba + RocketMQ** 的微服务开发平台，采用前后端分离架构，提供完整的项目管理、工作流引擎、代码生成等企业级功能。

## 技术栈

| 层级 | 技术 |
|------|------|
| **后端框架** | Spring Boot 2.7.18 / Spring Cloud 2021.0.8 / Spring Cloud Alibaba 2021.0.5.0 |
| **前端框架** | Vue 2.6 + Element UI 2.15 |
| **数据库** | MySQL + MyBatis + Druid |
| **服务注册/配置中心** | Nacos |
| **API 网关** | Spring Cloud Gateway |
| **流量控制** | Sentinel |
| **消息队列** | RocketMQ 5.0.4 |
| **分布式事务** | Seata |
| **工作流引擎** | Flowable / Camunda / Activiti |
| **API 文档** | Swagger 3 / Knife4j |
| **分布式文件存储** | FastDFS |
| **服务监控** | Spring Boot Admin |
| **认证鉴权** | JWT + Shiro |
| **代码生成** | Velocity 模板引擎 |
| **工具库** | Hutool / PageHelper / Apache POI |

## 项目结构

```
coding
├── coding-gateway          # API 网关 (6880)
├── coding-auth             # 统一认证服务 (6800)
├── coding-footstone        # 公共基础模块
│   ├── coding-footstone-core         # 核心工具类
│   ├── coding-footstone-datasource   # 数据源配置
│   ├── coding-footstone-framework    # 框架基础
│   ├── coding-footstone-notice       # RocketMQ 消息通知
│   ├── coding-footstone-seata        # 分布式事务
│   ├── coding-footstone-security     # 安全模块
│   ├── coding-footstone-sensitive    # 数据脱敏
│   └── coding-footstone-swagger      # API 文档配置
├── coding-business         # 业务服务模块
│   ├── coding-system       # 系统管理
│   ├── coding-project      # 项目管理
│   ├── coding-workflow     # 工作流引擎
│   ├── coding-gen          # 代码生成
│   ├── coding-job          # 定时任务
│   ├── coding-chat         # 即时通讯
│   ├── coding-ucenter      # 用户中心
│   └── coding-launchpad    # 启动台
├── coding-openapi          # 开放接口
│   ├── coding-openapi-system    # 系统开放 API
│   └── coding-openapi-workflow  # 工作流开放 API
├── coding-monitor          # 服务监控 (6888)
├── coding-probe            # 技术探索 & Demo
├── coding-ui               # Vue 前端
└── docs                    # 文档 & SQL 脚本
    ├── config/             # Nacos 配置文件
    └── sql/                # 数据库初始化脚本
```

## 环境要求

- **JDK** >= 1.8
- **Maven** >= 3.6
- **Node.js** >= 8.9
- **MySQL** >= 5.7
- **Nacos** >= 2.x
- **Redis**
- **RocketMQ** >= 5.0

## 快速开始

### 1. 克隆项目

```bash
git clone <repository-url>
cd coding
```

### 2. 初始化数据库

按顺序执行 `docs/sql/` 目录下的 SQL 脚本：

```bash
# 基础数据库
mysql -u root -p < docs/sql/20250627/coding_nacos.sql
mysql -u root -p < docs/sql/20250627/coding_seata.sql

# 业务数据库
mysql -u root -p < docs/sql/20250627/coding-system.sql
mysql -u root -p < docs/sql/20250627/coding-project.sql
mysql -u root -p < docs/sql/20250627/coding-workflow.sql
mysql -u root -p < docs/sql/20250627/coding-gen.sql
```

### 3. 启动基础服务

确保以下服务已启动：

- **Nacos** - 服务注册与配置中心 (默认 `127.0.0.1:8848`)
- **Redis** - 缓存服务
- **MySQL** - 数据库
- **RocketMQ** - 消息队列

### 4. 导入 Nacos 配置

将 `docs/config/DEFAULT_GROUP/` 下的配置文件导入 Nacos 配置中心。

### 5. 启动后端服务

按以下顺序启动各服务：

```bash
# 1. 网关服务
cd coding-gateway && mvn spring-boot:run

# 2. 认证服务
cd coding-auth && mvn spring-boot:run

# 3. 业务服务（按需启动）
cd coding-business/coding-system && mvn spring-boot:run
cd coding-business/coding-project && mvn spring-boot:run
cd coding-business/coding-workflow && mvn spring-boot:run

# 4. 监控服务
cd coding-monitor && mvn spring-boot:run
```

### 6. 启动前端

```bash
cd coding-ui
npm install
npm run dev
```

## 服务端口

| 服务 | 端口 |
|------|------|
| API Gateway | 6880 |
| Auth Service | 6800 |
| Monitor | 6888 |
| Nacos | 8848 |
| Sentinel Dashboard | 9090 |

## 内置功能

- **用户管理** - 用户注册、登录、权限分配
- **角色管理** - RBAC 权限模型，支持角色和权限细粒度控制
- **菜单管理** - 动态菜单配置
- **部门管理** - 树形组织架构
- **岗位管理** - 岗位信息维护
- **字典管理** - 数据字典统一管理
- **参数设置** - 系统参数动态配置
- **通知公告** - 系统消息推送
- **日志管理** - 操作日志和登录日志
- **在线用户** - 在线会话监控
- **代码生成** - 基于 Velocity 模板的代码生成器
- **工作流** - 基于 Flowable 的流程设计与审批
- **项目管理** - 项目创建、任务跟踪、成员管理
- **定时任务** - 基于 XXL-Job 的任务调度
- **文件管理** - 支持 FastDFS 分布式文件存储
- **服务监控** - Spring Boot Admin 实时监控

## 项目截图

> 待补充

## 参与贡献

1. Fork 本仓库
2. 创建功能分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到远程分支 (`git push origin feature/AmazingFeature`)
5. 提交 Pull Request

## 开源协议

本项目采用 [MIT](https://opensource.org/licenses/MIT) 开源协议。
