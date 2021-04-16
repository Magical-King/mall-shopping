# 云商城

# 分支规范
| 分支 | 命名 | 是否公共分支 | 作用 |
| :---: | :---: | :---: | :---: |
| 生产| master | 是 | 用于发布生产环境 |
| 预发 | release/develop | 是 | 用于发布预发环境 |
| 测试 | develop | 是 | 用于发布测试环境 |
| 开发 | feature/develop | 是 | 用于发布开发环境 |
| 版本发布| release | 否 |每次新版本发布时，需要基于 develop 分支切出 release/xxx，xxx 按照 semantic version 定义。示例：release/1.0.0 |

# 代码提交规范

## 请求头部(Log Header)

### 提交类型(Type)

提交类型 type 用来描述一次提交行为的改动方向。

- feat： 新增 feature
- fix: 修复 bug
- docs: 仅仅修改了文档，比如 README, CHANGELOG, CONTRIBUTE等等
- style: 仅仅修改了空格、格式缩进、逗号等等，不改变代码逻辑
- refactor: 代码重构，没有加新功能或者修复 bug
- perf: 优化相关，比如提升性能、体验
- test: 测试用例，包括单元测试、集成测试等
- chore: 改变构建流程、或者增加依赖库、工具等
- revert: 回滚到上一个版本