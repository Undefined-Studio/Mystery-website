# 无需验证
##/api/login  POST  未实现
param

    username
    password

result

    code
    message
    data [cookies]

code 为 0 表示登录成功
message 为提示信息
data 为数组, 登录成功时包含 cookies

登录

##/api/login/testLogin   GET   未实现
result

    isLogined

验证登录

## /api/game/gameVersion GET    未需求
游戏更新日志

## /api/game/gameVersion/{versionNumber} GET    未需求
得到目标版本游戏信息

## /api/game/gameVersion/latest GET    未需求
得到最新版本游戏信息

# 需要验证
## /api/user/myInfo GET
result

    AccountEntity
    
不包含 password 字段

获取用户自己的个人信息

## /api/game/user/pass  GET 未实现
param

    id
    
id 为关卡编号

用户通关某一关卡
